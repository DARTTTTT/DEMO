package com.ltqh.qh.operation.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.ltqh.qh.R;
import com.ltqh.qh.operation.entity.OApiEntity;
import com.ltqh.qh.operation.entity.OPositionEntity;
import com.ltqh.qh.operation.entity.OTradeListEntity;
import com.ltqh.qh.operation.quotebase.QuoteProxy;
import com.ltqh.qh.operation.utils.OUtil;

import java.util.ArrayList;
import java.util.List;

public class OPositionAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private static final int TYPE_ITEM = 0;
    private static final int TYPE_FOOTER = 1;

    public boolean isLoadMore = false;


    private List<OPositionEntity.DataBean> datas;

    private OTradeListEntity oTradeListEntity;
    private List<String> dataList;
    private Context context;
    private double div;
    private List<Integer> stopLossList;
    private List<Integer> depositList;
    private int volume;
    private double profit_price, loss_price;

    public OPositionAdapter(Context context) {
        this.context = context;
        datas = new ArrayList<>();
    }

    public void getData() {

    }

    public void setDatas(List<OPositionEntity.DataBean> datas) {
        this.datas = datas;
        this.notifyDataSetChanged();
    }

    public void setTradeList(OTradeListEntity oTradeListEntity) {
        this.oTradeListEntity = oTradeListEntity;
        this.notifyDataSetChanged();
    }

    public void addDatas(List<OPositionEntity.DataBean> datas) {
        this.datas.addAll(datas);
        isLoadMore = false;
        this.notifyDataSetChanged();
    }

    public void startLoad() {
        isLoadMore = true;
        this.notifyDataSetChanged();
    }

    public void stopLoad() {
        isLoadMore = false;
        this.notifyDataSetChanged();
    }

    public void removeItemData(int position) {
        datas.remove(position);//删除数据源,移除集合中当前下标的数据
        notifyItemRemoved(position);//刷新被删除的地方
        notifyItemRangeChanged(position, getItemCount()); //刷新被删除数据，以及其后面的数据
    }


    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        RecyclerView.ViewHolder holder;
        if (viewType == TYPE_ITEM) {

            View view = LayoutInflater.from(context).inflate(R.layout.o_item_position, parent, false);
            holder = new MyViewHolder(view);
            return holder;
        }


        View view = LayoutInflater.from(context).inflate(R.layout.item_foot_layout, parent, false);
        holder = new ProgressViewHoler(view);


        return holder;


    }

    @Override
    public int getItemViewType(int position) {
        if (position + 1 == getItemCount() && isLoadMore) {
            return TYPE_FOOTER;
        }
        return TYPE_ITEM;

    }


    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {


        if (holder instanceof MyViewHolder) {


            ((MyViewHolder) holder).text_name.setText(datas.get(position).getCommodity() + datas.get(position).getContCode());
            ((MyViewHolder) holder).text_volum.setText(datas.get(position).getVolume() + "手");
            long time = datas.get(position).getTradeTime().getTime();

            ((MyViewHolder) holder).text_tradetime.setText("交易时间: " + OUtil.dateToStamp(time));
            double opPrice = datas.get(position).getOpPrice();

            ((MyViewHolder) holder).text_oprice.setText(String.valueOf(opPrice) + "-");

            ((MyViewHolder) holder).text_id.setText("订单ID: " + datas.get(position).getId());


            boolean isBuy = datas.get(position).isIsBuy();

            List<String> dataList = QuoteProxy.getInstance().getDataList();
            OApiEntity oApiEntity = QuoteProxy.getInstance().getoApiEntity();


            String lastPrice = null;

            if (dataList == null) {
                return;
            }

            for (String quote : dataList) {
                String[] split = quote.split(",");
                if (datas.get(position).getContCode().replaceAll("[^a-z^A-Z]", "").equals(split[0].replaceAll("[^a-z^A-Z]", ""))) {
                    lastPrice = split[2];
                }


            }


            List<OApiEntity.ForeignCommdsBean> foreignCommds = oApiEntity.getForeignCommds();
            List<OApiEntity.StockIndexCommdsBean> stockIndexCommds = oApiEntity.getStockIndexCommds();
            List<OApiEntity.DomesticCommdsBean> domesticCommds = oApiEntity.getDomesticCommds();

            String priceChange = null;
            String price = null;
            double sub = 0;
            if (isBuy == true) {
                sub = OUtil.sub(Double.valueOf(lastPrice), opPrice);

            } else {
                sub = OUtil.sub(opPrice, Double.valueOf(lastPrice));

            }


            double income = 0;
            double allcome = 0;
            for (OApiEntity.ForeignCommdsBean foreign : foreignCommds) {
                if (foreign.getCode().equals(datas.get(position).getContCode().replaceAll("[^a-z^A-Z]", ""))) {
                    price = foreign.getPrice();
                    priceChange = foreign.getPriceChange();

                    double mul2 = OUtil.mul(Double.valueOf(price), Double.valueOf(priceChange));//单点波动的价格

                    double div2 = OUtil.div(sub, Double.valueOf(priceChange), 1);

                    income = OUtil.mul(mul2, div2);
                    allcome = OUtil.mul(income, datas.get(position).getVolume());


                    //先除以手数
                    double div_profit = OUtil.div(datas.get(position).getStopProfit(), datas.get(position).getVolume(), 1);
                    double div_loss = OUtil.div(datas.get(position).getStopLoss(), datas.get(position).getVolume(), 1);

                    //除以单点波动价格
                    double div1 = OUtil.div(div_profit, mul2, 1);
                    double div = OUtil.div(div_loss, mul2, 1);

                    double mul = OUtil.mul(div1, Double.valueOf(priceChange));
                    double loss_price_mul = OUtil.mul(div, Double.valueOf(priceChange));

                    //用当前的价格去加和去减
                    if (isBuy == true) {
                        profit_price = OUtil.add(opPrice, mul);
                        loss_price = OUtil.add(opPrice, loss_price_mul);
                    } else {
                        profit_price = OUtil.sub(opPrice, mul);
                        loss_price = OUtil.sub(opPrice, loss_price_mul);
                    }

                }
            }
            for (OApiEntity.StockIndexCommdsBean foreign : stockIndexCommds) {
                if (foreign.getCode().equals(datas.get(position).getContCode().replaceAll("[^a-z^A-Z]", ""))) {
                    price = foreign.getPrice();
                    priceChange = foreign.getPriceChange();

                    double mul2 = OUtil.mul(Double.valueOf(price), Double.valueOf(priceChange));//单点波动的价格

                    double div2 = OUtil.div(sub, Double.valueOf(priceChange), 1);

                    income = OUtil.mul(mul2, div2);
                    allcome = OUtil.mul(income, datas.get(position).getVolume());

                    //先除以手数
                    double div_profit = OUtil.div(datas.get(position).getStopProfit(), datas.get(position).getVolume(), 1);
                    double div_loss = OUtil.div(datas.get(position).getStopLoss(), datas.get(position).getVolume(), 1);

                    //除以单点波动价格
                    double div1 = OUtil.div(div_profit, mul2, 1);
                    double div = OUtil.div(div_loss, mul2, 1);

                    double mul = OUtil.mul(div1, Double.valueOf(priceChange));
                    double loss_price_mul = OUtil.mul(div, Double.valueOf(priceChange));

                    //用当前的价格去加和去减
                    if (isBuy == true) {
                        profit_price = OUtil.add(opPrice, mul);
                        loss_price = OUtil.add(opPrice, loss_price_mul);
                    } else {
                        profit_price = OUtil.sub(opPrice, mul);
                        loss_price = OUtil.sub(opPrice, loss_price_mul);

                    }
                }
            }
            for (OApiEntity.DomesticCommdsBean foreign : domesticCommds) {
                if (foreign.getCode().equals(datas.get(position).getContCode().replaceAll("[^a-z^A-Z]", ""))) {
                    price = foreign.getPrice();
                    priceChange = foreign.getPriceChange();


                    double mul2 = OUtil.mul(Double.valueOf(price), Double.valueOf(priceChange));//单点波动的价格

                    double div2 = OUtil.div(sub, Double.valueOf(priceChange), 1);

                    income = OUtil.mul(mul2, div2);
                    allcome = OUtil.mul(income, datas.get(position).getVolume());

                    //先除以手数
                    double div_profit = OUtil.div(datas.get(position).getStopProfit(), datas.get(position).getVolume(), 1);
                    double div_loss = OUtil.div(datas.get(position).getStopLoss(), datas.get(position).getVolume(), 1);

                    //除以单点波动价格
                    double div1 = OUtil.div(div_profit, mul2, 1);
                    double div = OUtil.div(div_loss, mul2, 1);

                    double mul = OUtil.mul(div1, Double.valueOf(priceChange));
                    double loss_price_mul = OUtil.mul(div, Double.valueOf(priceChange));

                    //用当前的价格去加和去减
                    if (isBuy == true) {
                        profit_price = OUtil.add(opPrice, mul);
                        loss_price = OUtil.add(opPrice, loss_price_mul);
                    } else {
                        profit_price = OUtil.sub(opPrice, mul);
                        loss_price = OUtil.sub(opPrice, loss_price_mul);

                    }
                }
            }


            if (income >= 0) {
                ((MyViewHolder) holder).text_income.setTextColor(context.getResources().getColor(R.color.redcolor));

            } else {
                ((MyViewHolder) holder).text_income.setTextColor(context.getResources().getColor(R.color.greencolor));
            }

            int moneyType = datas.get(position).getMoneyType();
            //Log.d("print", "onBindViewHolder:230模式:"+moneyType);
            double multiple = 1;
            if (moneyType == 0) {
                multiple = 1;
            } else if (moneyType == 1) {
                multiple = 10;
            }

            double all_div = OUtil.div(allcome, multiple, 1);

            double lastincome = OUtil.double1Point(all_div);

            if (opPrice == 0.0) {
                ((MyViewHolder) holder).text_income.setText("正在加载");
                ((MyViewHolder) holder).text_income.setTextSize(15f);

            } else {
                ((MyViewHolder) holder).text_income.setTextSize(29f);
                ((MyViewHolder) holder).text_income.setText(String.valueOf(lastincome) + "元");
            }


            if (Double.valueOf(lastPrice) > opPrice) {
                ((MyViewHolder) holder).text_price.setTextColor(context.getResources().getColor(R.color.redcolor));
            } else if (Double.valueOf(lastPrice) == opPrice) {
                ((MyViewHolder) holder).text_price.setTextColor(context.getResources().getColor(R.color.o_text_3433));

            } else if (Double.valueOf(lastPrice) < opPrice) {
                ((MyViewHolder) holder).text_price.setTextColor(context.getResources().getColor(R.color.greencolor));

            }

            ((MyViewHolder) holder).text_price.setText(lastPrice);
            if (isBuy == true) {
                ((MyViewHolder) holder).text_isbuy.setText("买多");
                ((MyViewHolder) holder).text_isbuy.setBackground(context.getResources().getDrawable(R.drawable.o_maiduo));
            } else {
                ((MyViewHolder) holder).text_isbuy.setText("买空");
                ((MyViewHolder) holder).text_isbuy.setBackground(context.getResources().getDrawable(R.drawable.o_maikong));

            }
            if (oTradeListEntity==null){
                return;
            }
            List<OTradeListEntity.TradeListBean> tradeList = oTradeListEntity.getTradeList();
            int deposit = 0;

            for (OTradeListEntity.TradeListBean tradeBean : tradeList) {
                if (tradeBean.getContCode().equals(datas.get(position).getContCode())) {
                    double stopLossBegin = datas.get(position).getStopLossBegin();
                    volume = datas.get(position).getVolume();
                    div = OUtil.div(stopLossBegin, volume, 1);
                    stopLossList = tradeBean.getStopLossList();
                    depositList = tradeBean.getDepositList();

                    double div1 = OUtil.div(tradeBean.getChargeUnit(), multiple, 1);

                    double mul = OUtil.mul(div1, volume);
                    double v = OUtil.double1Point(mul);

                    ((MyViewHolder) holder).text_service.setText(v + "");

                }
            }
            if (stopLossList.size() == 0) {
                return;
            }
            for (int i = 0; i < stopLossList.size(); i++) {

                double mul1 = OUtil.mul(div, multiple);
                // Log.d("print", "onBindViewHolder:297:   "+mul1+"--------"+stopLossList);

                if (mul1 == stopLossList.get(i)) {
                    //  Log.d("print", "onBindViewHolder:301:   "+depositList);
                    if (depositList.size() != 0) {

                        double div1 = OUtil.div(depositList.get(i), multiple, 1);
                        double mul = OUtil.mul(div1, volume);
                        deposit = depositList.get(i) * volume;

                        //  Log.d("print", "onBindViewHolder:302:  " + depositList.get(i) + "------倍数" + multiple + "-------计算1:" + div1 + "-----最终计算2" + mul);
                        double v = OUtil.double1Point(mul);

                        ((MyViewHolder) holder).text_bond.setText(v + "");
                    } else {
                        double div1 = OUtil.div(stopLossList.get(i), multiple, 1);
                        double mul = OUtil.mul(div1, volume);
                        deposit = stopLossList.get(i) * volume;
                        double mul2 = OUtil.mul(mul, -1);

                        // Log.d("print", "onBindViewHolder:302:  " + stopLossList.get(i) + "------倍数" + multiple + "-------计算1:" + div1 + "-----最终计算2" + mul);
                        double v = OUtil.double1Point(mul2);
                        ((MyViewHolder) holder).text_bond.setText(v + "");
                    }
                }
            }


            if (isBuy == true) {
                ((MyViewHolder) holder).text_pingcang.setBackgroundColor(context.getResources().getColor(R.color.o_text_3red));
            } else {
                ((MyViewHolder) holder).text_pingcang.setBackgroundColor(context.getResources().getColor(R.color.o_text_3green));

            }


            ((MyViewHolder) holder).text_stopprofit.setText("止盈: " + datas.get(position).getStopProfit() + "  (" + profit_price + ")");
            ((MyViewHolder) holder).text_stoploss.setText("止损: " + datas.get(position).getStopLoss() + "  (" + loss_price + ")");
        }
    }

    @Override
    public int getItemCount() {
        if (isLoadMore) {
            return datas.size() + 1;
        }
        return datas.size();
    }


    class MyViewHolder extends RecyclerView.ViewHolder {
        TextView text_name, text_volum, text_tradetime,
                text_oprice, text_id, text_income, text_stopprofit,
                text_stoploss, text_isbuy, text_price, text_pingcang,
                text_tiaozheng, text_bond, text_service;


        public MyViewHolder(View itemView) {
            super(itemView);
            text_name = (TextView) itemView.findViewById(R.id.text_name);
            text_volum = (TextView) itemView.findViewById(R.id.text_volum);
            text_tradetime = (TextView) itemView.findViewById(R.id.text_tradetime);
            text_oprice = (TextView) itemView.findViewById(R.id.text_oprice);
            text_id = (TextView) itemView.findViewById(R.id.text_id);
            text_income = (TextView) itemView.findViewById(R.id.text_income);
            text_stopprofit = (TextView) itemView.findViewById(R.id.text_stopprofit);
            text_stoploss = (TextView) itemView.findViewById(R.id.text_stoploss);
            text_isbuy = itemView.findViewById(R.id.text_isbuy);
            text_price = itemView.findViewById(R.id.text_lastprice);
            text_tiaozheng = itemView.findViewById(R.id.text_tiaozheng);
            text_pingcang = itemView.findViewById(R.id.text_pingcang);
            text_bond = itemView.findViewById(R.id.text_bond);
            text_service = itemView.findViewById(R.id.text_service);

            text_pingcang.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if (onItemClick != null) {
                        onItemClick.onPingcangListener(getAdapterPosition(), datas.get(getPosition()));
                    }
                }
            });


            text_tiaozheng.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (onItemClick != null) {
                        onItemClick.onTiaozhengListener(datas.get(getPosition()));
                    }
                }
            });


            itemView.setOnClickListener(new View.OnClickListener() {
                @Override

                public void onClick(View v) {
                    if (onItemClick != null) {
                        onItemClick.onDetailListener(datas.get(getPosition()));
                    }
                }
            });

        }
    }

    public static class ProgressViewHoler extends RecyclerView.ViewHolder {
        public ProgressBar bar;

        public ProgressViewHoler(View itemView) {
            super(itemView);
            bar = (ProgressBar) itemView.findViewById(R.id.progress);
        }
    }


    public interface OnItemClick {
        void onPingcangListener(int position, OPositionEntity.DataBean dataBean);

        void onTiaozhengListener(OPositionEntity.DataBean dataBean);

        void onDetailListener(OPositionEntity.DataBean dataBean);

    }

    private OnItemClick onItemClick;

    public void setOnItemClick(OnItemClick onItemClick) {
        this.onItemClick = onItemClick;
    }
}
