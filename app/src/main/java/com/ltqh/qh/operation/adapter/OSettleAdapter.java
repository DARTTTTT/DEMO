package com.ltqh.qh.operation.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.ltqh.qh.R;
import com.ltqh.qh.operation.entity.OPositionEntity;
import com.ltqh.qh.operation.utils.OUtil;

import java.util.ArrayList;
import java.util.List;

public class OSettleAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private static final int TYPE_ITEM = 0;
    private static final int TYPE_FOOTER = 1;

    public boolean isLoadMore = false;


    private  List<OPositionEntity.DataBean>  datas;


    private Context context;

    public OSettleAdapter(Context context) {
        this.context = context;
        datas = new ArrayList<>();
    }

    public void setDatas(List<OPositionEntity.DataBean> datas) {
        this.datas = datas;
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


    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        RecyclerView.ViewHolder holder;
        if (viewType == TYPE_ITEM) {

            View view = LayoutInflater.from(context).inflate(R.layout.o_item_settle, parent, false);
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
         ((MyViewHolder) holder).text_name.setText(datas.get(position).getCommodity()+datas.get(position).getContCode());
         ((MyViewHolder) holder).text_volum.setText(datas.get(position).getVolume()+"手");
            long time = datas.get(position).getTime().getTime();


            ((MyViewHolder) holder).text_tradetime.setText("买入时间: "+OUtil.dateToStamp(time));

            ((MyViewHolder) holder).text_cptime.setText("平仓时间: "+OUtil.dateToStamp(datas.get(position).getTradeTime().getTime()));

            ((MyViewHolder) holder).text_oprice.setText("买入价: "+datas.get(position).getOpPrice());

            ((MyViewHolder) holder).text_id.setText("订单ID: "+datas.get(position).getId());

            double income = datas.get(position).getIncome();

            if (income>0){
                ((MyViewHolder) holder).text_income.setTextColor(context.getResources().getColor(R.color.redcolor));
            }else if (income==0.0){
                ((MyViewHolder) holder).text_income.setTextColor(context.getResources().getColor(R.color.o_text_hint_color));

            }else if (income<0){
                ((MyViewHolder) holder).text_income.setTextColor(context.getResources().getColor(R.color.greencolor));

            }


            ((MyViewHolder) holder).text_income.setText(String.valueOf(income));

            ((MyViewHolder) holder).text_stopprofit.setText("止盈: "+datas.get(position).getStopProfit());
            ((MyViewHolder) holder).text_stoploss.setText("止损: "+datas.get(position).getStopLoss());

            ((MyViewHolder) holder).text_cpprice.setText("平仓价: "+datas.get(position).getCpPrice());

            boolean isBuy = datas.get(position).isIsBuy();

            if (isBuy==true){
                ((MyViewHolder) holder).text_isbuy.setText("买多");
                ((MyViewHolder) holder).text_isbuy.setBackground(context.getResources().getDrawable(R.drawable.o_maiduo));
            }else {
                ((MyViewHolder) holder).text_isbuy.setText("买空");
                ((MyViewHolder) holder).text_isbuy.setBackground(context.getResources().getDrawable(R.drawable.o_maikong));

            }


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
        TextView text_name, text_volum, text_tradetime, text_oprice, text_id, text_income,text_stopprofit,text_stoploss,text_isbuy,text_cpprice,text_cptime;
        ImageView img_star;
        RelativeLayout layout_stay, layout_stay2;

        public MyViewHolder(View itemView) {
            super(itemView);
            text_name = (TextView) itemView.findViewById(R.id.text_name);
            text_volum = (TextView) itemView.findViewById(R.id.text_volum);
            text_tradetime = (TextView) itemView.findViewById(R.id.text_tradetime);
            text_oprice = (TextView) itemView.findViewById(R.id.text_oprice);
            text_cptime=itemView.findViewById(R.id.text_cptime);
            text_cpprice=itemView.findViewById(R.id.text_cprice);
            text_id = (TextView) itemView.findViewById(R.id.text_id);
            text_income = (TextView) itemView.findViewById(R.id.text_income);
            text_stopprofit = (TextView) itemView.findViewById(R.id.text_stopprofit);
            text_stoploss = (TextView) itemView.findViewById(R.id.text_stoploss);
            text_isbuy=itemView.findViewById(R.id.text_isbuy);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if (onItemClick != null) {
                        onItemClick.onSuccessListener(datas.get(getPosition()));
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
        void onSuccessListener(OPositionEntity.DataBean dataBean);

    }

    private OnItemClick onItemClick;

    public void setOnItemClick(OnItemClick onItemClick) {
        this.onItemClick = onItemClick;
    }
}
