package com.ltqh.qh.operation.adapter;

import android.animation.ObjectAnimator;
import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.ltqh.qh.R;
import com.ltqh.qh.entity.GoldlistEntity;
import com.ltqh.qh.operation.config.OUserConfig;
import com.ltqh.qh.operation.entity.OApiEntity;
import com.ltqh.qh.utils.Util;

import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class OHomeMarketAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

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

    public OHomeMarketAdapter(Context context) {
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

            View view = LayoutInflater.from(context).inflate(R.layout.o_item_homemarket_layout, parent, false);
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

            if ((position+1)%3!=0){
                ((MyViewHolder) holder).viewLine.setVisibility(View.VISIBLE);

            }else {
                ((MyViewHolder) holder).viewLine.setVisibility(View.GONE);

            }

          /*  if (position == 0 || position == 1) {
                ((MyViewHolder) holder).viewLine.setVisibility(View.VISIBLE);
            } else {
                ((MyViewHolder) holder).viewLine.setVisibility(View.GONE);

            }*/


            String s = datas.get(position);
            String[] split = s.split(",");

            String marketName = null;

            if (key.equals(OUserConfig.P_FOREIGN)) {
                for (OApiEntity.ForeignCommdsBean foreign : foreignCommds) {
                    if (split[0].startsWith(foreign.getCode())) {
                        marketName = foreign.getName();
                    }
                }

            } else if (key.equals(OUserConfig.P_STOCKINDEX)) {
                for (OApiEntity.StockIndexCommdsBean stockIndex : stockIndexCommds) {
                    if (split[0].startsWith(stockIndex.getCode())) {
                        marketName = stockIndex.getName();
                    }
                }

            } else if (key.equals(OUserConfig.P_DOMESTIC)) {
                for (OApiEntity.DomesticCommdsBean domestic : domesticCommds) {
                    if (split[0].startsWith(domestic.getCode())) {
                        marketName = domestic.getName();
                    }
                }

            } else if (key.equals(OUserConfig.P_ALLDEX)) {
                List<OApiEntity.ForeignCommdsBean> foreignCommds = oApiEntity.getForeignCommds();
                for (OApiEntity.ForeignCommdsBean name : foreignCommds) {
                    if (split[0].startsWith(name.getCode())) {
                        marketName = name.getName();
                    }
                }

                List<OApiEntity.StockIndexCommdsBean> stockIndexCommds = oApiEntity.getStockIndexCommds();
                for (OApiEntity.StockIndexCommdsBean name : stockIndexCommds) {
                    if (split[0].startsWith(name.getCode())) {
                        marketName = name.getName();
                    }
                }
                List<OApiEntity.DomesticCommdsBean> domesticCommds = oApiEntity.getDomesticCommds();
                for (OApiEntity.DomesticCommdsBean name : domesticCommds) {
                    if (split[0].startsWith(name.getCode())) {
                        marketName = name.getName();
                    }
                }

            }

            ((MyViewHolder) holder).text_name.setText(marketName);


            String change = split[1];

            String last = split[2];

            lastPrice = last;

            String newprice = split[3];


            Integer flag = Integer.valueOf(change);


            double v = Double.valueOf(last);
            double v1 = Double.valueOf(newprice);


            String a = String.valueOf((v - v1) / v * 100);

            String numberFormat2 = getNumberFormat2(a);


            String percent = null;
            if (flag == 1) {

                percent = "+" + numberFormat2 + "%";

                ((MyViewHolder) holder).text_last.setTextColor(context.getResources().getColor(R.color.redcolor));
                ((MyViewHolder) holder).text_high.setTextColor(context.getResources().getColor(R.color.redcolor));
                ((MyViewHolder) holder).text_pricechange.setTextColor(context.getResources().getColor(R.color.redcolor));
            } else if (flag == -1) {

                percent = numberFormat2 + "%";

                ((MyViewHolder) holder).text_last.setTextColor(context.getResources().getColor(R.color.greencolor));
                ((MyViewHolder) holder).text_high.setTextColor(context.getResources().getColor(R.color.greencolor));
                ((MyViewHolder) holder).text_pricechange.setTextColor(context.getResources().getColor(R.color.greencolor));

            } else if (flag == 0) {

                percent = numberFormat2 + "%";

                ((MyViewHolder) holder).text_last.setTextColor(context.getResources().getColor(R.color.o_text_3433));
                ((MyViewHolder) holder).text_high.setTextColor(context.getResources().getColor(R.color.o_text_3433));
                ((MyViewHolder) holder).text_pricechange.setTextColor(context.getResources().getColor(R.color.o_text_3433));

            }

            ((MyViewHolder) holder).text_pricechange.setText(String.valueOf(Util.sub(v, v1)));

            ((MyViewHolder) holder).text_high.setText(percent);

            ((MyViewHolder) holder).text_last.setText(last);


            if (oldDatas.size() != 0) {
                for (int i = 0; i < oldDatas.size(); i++) {
                    String s1 = oldDatas.get(i);
                    String[] split1 = s1.split(",");
                    if (split[0].equals(split1[0])) {
                        Log.d("print", "onBindViewHolder:老：" + split1[2] + "-------新 " + last);
                        int compare = Double.compare(Double.valueOf(last), Double.valueOf(split1[2]));
                        switch (compare) {
                            case 1:

                                ((MyViewHolder) holder).layout_bar.setBackgroundResource(R.drawable.o_bg_zhang);

                                break;
                            case 0:
                                ((MyViewHolder) holder).layout_bar.setBackgroundColor(Color.WHITE);

                                break;
                            case -1:
                                ((MyViewHolder) holder).layout_bar.setBackgroundResource(R.drawable.o_bg_die);

                                break;
                        }


                    }
                    ObjectAnimator animator = ObjectAnimator.ofFloat(((MyViewHolder) holder).layout_bar, "alpha", 1f, 0f);
                    animator.setDuration(3000);
                    animator.start();

                }
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
        TextView text_name, text_last, text_pricechange, text_high;
        RelativeLayout layout_bar;
        View viewLine;

        public MyViewHolder(View itemView) {
            super(itemView);
            text_name = (TextView) itemView.findViewById(R.id.text_name);
            text_last = (TextView) itemView.findViewById(R.id.text_last);
            text_high = itemView.findViewById(R.id.text_high);
            layout_bar = itemView.findViewById(R.id.layout_bar);
            text_pricechange = itemView.findViewById(R.id.text_pricechange);
            viewLine = itemView.findViewById(R.id.view_line);

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
