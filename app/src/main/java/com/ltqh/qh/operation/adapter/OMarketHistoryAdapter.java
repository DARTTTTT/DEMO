package com.ltqh.qh.operation.adapter;

import android.animation.ObjectAnimator;
import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.ltqh.qh.R;
import com.ltqh.qh.operation.config.OUserConfig;
import com.ltqh.qh.operation.entity.OApiEntity;
import com.ltqh.qh.operation.utils.ODateUtil;
import com.ltqh.qh.utils.SPUtils;

import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Set;

public class OMarketHistoryAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private static final int TYPE_ITEM = 0;
    private static final int TYPE_FOOTER = 1;

    public boolean isLoadMore = false;


    private List<String> datas;
    private List<String> oldDatas;

    private String lastPrice;

    private List<String> dataList;

    private List<String> dataList2;

    private OApiEntity oApiEntity;
    private List<OApiEntity.ForeignCommdsBean> foreignCommds;
    private List<OApiEntity.DomesticCommdsBean> domesticCommds;
    private List<OApiEntity.StockIndexCommdsBean> stockIndexCommds;
    private Context context;
    private String key;
    private boolean openTradeTime;
    private boolean openTradeTime1;
    private boolean openTradeTime2;

    public OMarketHistoryAdapter(Context context) {
        this.context = context;
        datas = new ArrayList<>();
        oldDatas = new ArrayList<>();
        oApiEntity = new OApiEntity();
        foreignCommds = new ArrayList<>();
        domesticCommds = new ArrayList<>();
        stockIndexCommds = new ArrayList<>();
    }

    public void setAllDatas(String key, OApiEntity oApiEntity) {
        this.oApiEntity = oApiEntity;
        this.notifyDataSetChanged();
    }

    public void setForeignDatas(String key, List<OApiEntity.ForeignCommdsBean> foreignCommds) {
        this.key = key;
        this.foreignCommds = foreignCommds;
        this.notifyDataSetChanged();
    }

    public void setDomesDatas(String key, List<OApiEntity.DomesticCommdsBean> domesticCommds) {
        this.key = key;
        this.domesticCommds = domesticCommds;
        this.notifyDataSetChanged();
    }

    public void setStockDatas(String key, List<OApiEntity.StockIndexCommdsBean> stockIndexCommds) {
        this.key = key;
        this.stockIndexCommds = stockIndexCommds;
        this.notifyDataSetChanged();
    }

    public void setDatas(String key, List<String> datas) {
        this.key = key;
        this.datas = datas;
        this.notifyDataSetChanged();
    }

    public void addDatas(List<String> datas) {
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


    public void notifyItem(List<String> datas) {
        this.oldDatas = datas;
        this.notifyDataSetChanged();
    }


    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        RecyclerView.ViewHolder holder;
        if (viewType == TYPE_ITEM) {

            View view = LayoutInflater.from(context).inflate(R.layout.o_item_market_history_layout, parent, false);
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

            String s = datas.get(position);
            String[] split = s.split(",");

            String marketName = null;

            String marketTime = null;
            SimpleDateFormat sdf = new SimpleDateFormat("HH:mm");













            if (key.equals(OUserConfig.P_FOREIGN)) {
                for (OApiEntity.ForeignCommdsBean foreign : foreignCommds) {
                    if (split[0].startsWith(foreign.getCode())) {
                        marketName = foreign.getName() + split[0];
                        String niteWarningTime = foreign.getNiteWarningTime();
                        String am = niteWarningTime.substring(0, 2);
                        try {
                            openTradeTime = ODateUtil.isOpenTradeTime(sdf.parse(sdf.format(new Date())), sdf.parse(foreign.getAmTradeTime()), sdf.parse(foreign.getAmWarningTime()));
                            openTradeTime1 = ODateUtil.isOpenTradeTime(sdf.parse(sdf.format(new Date())), sdf.parse(foreign.getPmTradeTime()), sdf.parse(foreign.getPmWarningTime()));
                            openTradeTime2 = ODateUtil.isOpenTradeTime(sdf.parse(sdf.format(new Date())), sdf.parse(foreign.getNiteTradeTime()), sdf.parse(foreign.getNiteWarningTime()));

                        } catch (Exception e) {
                            e.printStackTrace();
                        }

                        int i = Integer.valueOf(am);
                        if (i <= 5) {
                            marketTime = foreign.getAmOpenTime().substring(0, 5) + "~次日" + niteWarningTime.substring(0, 5);
                        } else {
                            marketTime = foreign.getAmOpenTime().substring(0, 5) + "~夜间" + niteWarningTime.substring(0, 5);
                        }

                    }
                }

            } else if (key.equals(OUserConfig.P_STOCKINDEX)) {
                for (OApiEntity.StockIndexCommdsBean stockIndex : stockIndexCommds) {
                    if (split[0].startsWith(stockIndex.getCode())) {
                        marketName = stockIndex.getName() + split[0];
                        String niteWarningTime = stockIndex.getNiteWarningTime();
                        String am = niteWarningTime.substring(0, 2);
                        try {
                            openTradeTime = ODateUtil.isOpenTradeTime(sdf.parse(sdf.format(new Date())), sdf.parse(stockIndex.getAmTradeTime()), sdf.parse(stockIndex.getAmWarningTime()));
                            openTradeTime1 = ODateUtil.isOpenTradeTime(sdf.parse(sdf.format(new Date())), sdf.parse(stockIndex.getPmTradeTime()), sdf.parse(stockIndex.getPmWarningTime()));
                            openTradeTime2 = ODateUtil.isOpenTradeTime(sdf.parse(sdf.format(new Date())), sdf.parse(stockIndex.getNiteTradeTime()), sdf.parse(stockIndex.getNiteWarningTime()));

                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                        int i = Integer.valueOf(am);
                        if (i <= 5) {
                            marketTime = stockIndex.getAmOpenTime().substring(0, 5) + "~次日" + niteWarningTime.substring(0, 5);
                        } else {
                            marketTime = stockIndex.getAmOpenTime().substring(0, 5) + "~夜间" + niteWarningTime.substring(0, 5);
                        }

                    }
                }

            } else if (key.equals(OUserConfig.P_DOMESTIC)) {
                for (OApiEntity.DomesticCommdsBean domestic : domesticCommds) {
                    if (split[0].startsWith(domestic.getCode())) {
                        marketName = domestic.getName() + split[0];
                        String niteWarningTime = domestic.getNiteWarningTime();
                        try {
                            openTradeTime = ODateUtil.isOpenTradeTime(sdf.parse(sdf.format(new Date())), sdf.parse(domestic.getAmTradeTime()), sdf.parse(domestic.getAmWarningTime()));
                            openTradeTime1 = ODateUtil.isOpenTradeTime(sdf.parse(sdf.format(new Date())), sdf.parse(domestic.getPmTradeTime()), sdf.parse(domestic.getPmWarningTime()));
                            openTradeTime2 = ODateUtil.isOpenTradeTime(sdf.parse(sdf.format(new Date())), sdf.parse(domestic.getNiteTradeTime()), sdf.parse(domestic.getNiteWarningTime()));

                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                        String am = niteWarningTime.substring(0, 2);

                        int i = Integer.valueOf(am);
                        if (i <= 5) {
                            marketTime = domestic.getAmOpenTime().substring(0, 5) + "~次日" + niteWarningTime.substring(0, 5);
                        } else {
                            marketTime = domestic.getAmOpenTime().substring(0, 5) + "~夜间" + niteWarningTime.substring(0, 5);
                        }
                    }
                }

            } else if (key.equals(OUserConfig.P_ALLDEX) || key.equals(OUserConfig.P_MINEDEX)) {
                List<OApiEntity.ForeignCommdsBean> foreignCommds = oApiEntity.getForeignCommds();
                for (OApiEntity.ForeignCommdsBean data : foreignCommds) {
                    if (split[0].startsWith(data.getCode())) {
                        marketName = data.getName() + split[0];
                        try {
                            openTradeTime = ODateUtil.isOpenTradeTime(sdf.parse(sdf.format(new Date())), sdf.parse(data.getAmTradeTime()), sdf.parse(data.getAmWarningTime()));
                            openTradeTime1 = ODateUtil.isOpenTradeTime(sdf.parse(sdf.format(new Date())), sdf.parse(data.getPmTradeTime()), sdf.parse(data.getPmWarningTime()));
                            openTradeTime2 = ODateUtil.isOpenTradeTime(sdf.parse(sdf.format(new Date())), sdf.parse(data.getNiteTradeTime()), sdf.parse(data.getNiteWarningTime()));

                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                        String niteWarningTime = data.getNiteWarningTime();
                        String am = niteWarningTime.substring(0, 2);

                        int i = Integer.valueOf(am);
                        if (i <= 5) {
                            marketTime = data.getAmOpenTime().substring(0, 5) + "~次日" + niteWarningTime.substring(0, 5);
                        } else {
                            marketTime = data.getAmOpenTime().substring(0, 5) + "~夜间" + niteWarningTime.substring(0, 5);
                        }
                    }
                }

                List<OApiEntity.StockIndexCommdsBean> stockIndexCommds = oApiEntity.getStockIndexCommds();
                for (OApiEntity.StockIndexCommdsBean data : stockIndexCommds) {
                    if (split[0].startsWith(data.getCode())) {
                        marketName = data.getName() + split[0];
                        try {
                            openTradeTime = ODateUtil.isOpenTradeTime(sdf.parse(sdf.format(new Date())), sdf.parse(data.getAmTradeTime()), sdf.parse(data.getAmWarningTime()));
                            openTradeTime1 = ODateUtil.isOpenTradeTime(sdf.parse(sdf.format(new Date())), sdf.parse(data.getPmTradeTime()), sdf.parse(data.getPmWarningTime()));
                            openTradeTime2 = ODateUtil.isOpenTradeTime(sdf.parse(sdf.format(new Date())), sdf.parse(data.getNiteTradeTime()), sdf.parse(data.getNiteWarningTime()));

                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                        String niteWarningTime = data.getNiteWarningTime();
                        String am = niteWarningTime.substring(0, 2);

                        int i = Integer.valueOf(am);
                        if (i <= 5) {
                            marketTime = data.getAmOpenTime().substring(0, 5) + "~次日" + niteWarningTime.substring(0, 5);
                        } else {
                            marketTime = data.getAmOpenTime().substring(0, 5) + "~夜间" + niteWarningTime.substring(0, 5);
                        }
                    }
                }
                List<OApiEntity.DomesticCommdsBean> domesticCommds = oApiEntity.getDomesticCommds();
                for (OApiEntity.DomesticCommdsBean data : domesticCommds) {
                    if (split[0].startsWith(data.getCode())) {
                        marketName = data.getName() + split[0];
                        try {
                            openTradeTime = ODateUtil.isOpenTradeTime(sdf.parse(sdf.format(new Date())), sdf.parse(data.getAmTradeTime()), sdf.parse(data.getAmWarningTime()));
                            openTradeTime1 = ODateUtil.isOpenTradeTime(sdf.parse(sdf.format(new Date())), sdf.parse(data.getPmTradeTime()), sdf.parse(data.getPmWarningTime()));
                            openTradeTime2 = ODateUtil.isOpenTradeTime(sdf.parse(sdf.format(new Date())), sdf.parse(data.getNiteTradeTime()), sdf.parse(data.getNiteWarningTime()));

                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                        String niteWarningTime = data.getNiteWarningTime();
                        String am = niteWarningTime.substring(0, 2);

                        int i = Integer.valueOf(am);
                        if (i <= 5) {
                            marketTime = data.getAmOpenTime().substring(0, 5) + "~次日" + niteWarningTime.substring(0, 5);
                        } else {
                            marketTime = data.getAmOpenTime().substring(0, 5) + "~夜间" + niteWarningTime.substring(0, 5);
                        }
                    }
                }

            }

            ((MyViewHolder) holder).text_name.setText(marketName);



            String percent = null;






        }


        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (onItemClick != null) {
                    onItemClick.onSuccessListener(datas.get(position));
                }
            }
        });
    }


    public static String getNumberFormat2(String value) {
        double v = Double.parseDouble(value);
        DecimalFormat mFormat = new DecimalFormat("#0.00");
        return mFormat.format(v);
    }

    public String timesOne(String time) {
        SimpleDateFormat sdr = new SimpleDateFormat("yyyy-MM-dd HH:mm");
        @SuppressWarnings("unused")
        long lcc = Long.valueOf(time);
        int i = Integer.parseInt(time);
        String times = sdr.format(new Date(i * 1000L));
        return times;

    }


    @Override
    public int getItemCount() {
        if (isLoadMore) {
            return datas.size() + 1;
        }
        return datas.size();
    }

    class MyViewHolder extends RecyclerView.ViewHolder {
        TextView text_name;

        public MyViewHolder(View itemView) {
            super(itemView);
            text_name = (TextView) itemView.findViewById(R.id.text_name);

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
        void onSuccessListener(String code);

    }

    private OnItemClick onItemClick;

    public void setOnItemClick(OnItemClick onItemClick) {
        this.onItemClick = onItemClick;
    }
}
