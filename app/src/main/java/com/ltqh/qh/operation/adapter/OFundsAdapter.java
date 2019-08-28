package com.ltqh.qh.operation.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.ltqh.qh.R;
import com.ltqh.qh.operation.entity.OFundsEntity;
import com.ltqh.qh.operation.entity.OWithdrawHistoryEntity;
import com.ltqh.qh.operation.utils.OUtil;

import java.util.ArrayList;
import java.util.List;

public class OFundsAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private static final int TYPE_ITEM = 0;
    private static final int TYPE_FOOTER = 1;

    public boolean isLoadMore = false;


    private List<OFundsEntity.DataBean> datas;


    private Context context;

    public OFundsAdapter(Context context) {
        this.context = context;
        datas = new ArrayList<>();
    }

    public void setDatas(List<OFundsEntity.DataBean> datas) {
        this.datas = datas;
        this.notifyDataSetChanged();
    }

    public void addDatas(List<OFundsEntity.DataBean> datas) {
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

            View view = LayoutInflater.from(context).inflate(R.layout.o_funds_layout, parent, false);
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
            String explain = datas.get(position).getExplain();
            ((MyViewHolder) holder).text_name.setText(explain);
            String remark = datas.get(position).getRemark();

            String detail = datas.get(position).getDetail();



            if (explain.contains("资金存入")){
                //((MyViewHolder) holder).text_state.setText("处理失败");
                ((MyViewHolder) holder).text_money.setText("+"+datas.get(position).getMoney());

            }else if (explain.contains("网站活动")){
                ((MyViewHolder) holder).text_money.setText("+"+datas.get(position).getMoney());

              //  ((MyViewHolder) holder).text_state.setText("处理成功");
            }

            if (detail.contains("退还")){
                //((MyViewHolder) holder).text_state.setText("处理失败");
                ((MyViewHolder) holder).text_money.setText("+"+datas.get(position).getMoney());

            }else if (explain.contains("冻结")){
                ((MyViewHolder) holder).text_money.setText("-"+datas.get(position).getMoney());

                //  ((MyViewHolder) holder).text_state.setText("处理成功");
            }else if (explain.contains("支付")){
                ((MyViewHolder) holder).text_money.setText("-"+datas.get(position).getMoney());

                //  ((MyViewHolder) holder).text_state.setText("处理成功");
            }else if (explain.contains("获得")){
                ((MyViewHolder) holder).text_money.setText("+"+datas.get(position).getMoney());

                //  ((MyViewHolder) holder).text_state.setText("处理成功");
            } else if (detail.contains("赠送积分")){
                //((MyViewHolder) holder).text_state.setText("处理失败");
                ((MyViewHolder) holder).text_money.setText("+"+datas.get(position).getMoney());

            }else if (explain.contains("支付交易积分")){
                ((MyViewHolder) holder).text_money.setText("-"+datas.get(position).getMoney());

                //  ((MyViewHolder) holder).text_state.setText("处理成功");
            }

            long time = datas.get(position).getTime();

            String s = OUtil.dateToStamp(time);
            ((MyViewHolder) holder).text_time.setText(s);

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
        TextView text_name, text_money,text_state,text_time;

        View view_line;

        public MyViewHolder(View itemView) {
            super(itemView);
            text_name = (TextView) itemView.findViewById(R.id.text_name);
            text_money=itemView.findViewById(R.id.text_money);
            text_state=itemView.findViewById(R.id.text_state);
            text_time=itemView.findViewById(R.id.text_time);

            view_line=itemView.findViewById(R.id.view_line);


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
        void onSuccessListener(OFundsEntity.DataBean data);

    }

    private OnItemClick onItemClick;

    public void setOnItemClick(OnItemClick onItemClick) {
        this.onItemClick = onItemClick;
    }
}
