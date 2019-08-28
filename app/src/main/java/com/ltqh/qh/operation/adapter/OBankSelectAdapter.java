package com.ltqh.qh.operation.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.ltqh.qh.R;
import com.ltqh.qh.operation.entity.OAddressEntity;
import com.ltqh.qh.operation.entity.OBankEntity;

import java.util.ArrayList;
import java.util.List;

public class OBankSelectAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private static final int TYPE_ITEM = 0;
    private static final int TYPE_FOOTER = 1;

    public boolean isLoadMore = false;


    private List<OBankEntity.DataBean> datas;


    private Context context;

    public OBankSelectAdapter(Context context) {
        this.context = context;
        datas = new ArrayList<>();
    }

    public void setDatas(List<OBankEntity.DataBean> datas) {
        this.datas = datas;
        this.notifyDataSetChanged();
    }

    public void addDatas(List<OBankEntity.DataBean> datas) {
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

            View view = LayoutInflater.from(context).inflate(R.layout.o_bank_layout, parent, false);
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
        String content;
        String time;



        if (holder instanceof MyViewHolder) {

            String bank = datas.get(position).getValue();
            ((MyViewHolder) holder).text_name.setText(bank);



            if (bank.contains("工商")){
                ((MyViewHolder) holder).img_card.setImageDrawable(context.getResources().getDrawable(R.mipmap.bank_gongshang));

            }else if (bank.contains("建设")){
                ((MyViewHolder) holder).img_card.setImageDrawable(context.getResources().getDrawable(R.mipmap.bank_jianhang));

            }else if (bank.contains("农业")){
                ((MyViewHolder) holder).img_card.setImageDrawable(context.getResources().getDrawable(R.mipmap.bank_nongye));

            }else if (bank.contains("招商")){
                ((MyViewHolder) holder).img_card.setImageDrawable(context.getResources().getDrawable(R.mipmap.bank_zhaoshang));

            }else if (bank.contains("中国")){
                ((MyViewHolder) holder).img_card.setImageDrawable(context.getResources().getDrawable(R.mipmap.bank_china));

            }else if (bank.contains("交通")){
                ((MyViewHolder) holder).img_card.setImageDrawable(context.getResources().getDrawable(R.mipmap.bank_jiaotong));

            }else if (bank.contains("邮政")){
                ((MyViewHolder) holder).img_card.setImageDrawable(context.getResources().getDrawable(R.mipmap.bank_youzheng));

            }else if (bank.contains("民生")){
                ((MyViewHolder) holder).img_card.setImageDrawable(context.getResources().getDrawable(R.mipmap.bank_minsheng));

            }else if (bank.contains("浦发")){
                ((MyViewHolder) holder).img_card.setImageDrawable(context.getResources().getDrawable(R.mipmap.bank_pufa));

            }else if (bank.contains("兴业")){
                ((MyViewHolder) holder).img_card.setImageDrawable(context.getResources().getDrawable(R.mipmap.bank_xingye));

            }else if (bank.contains("华夏")){
                ((MyViewHolder) holder).img_card.setImageDrawable(context.getResources().getDrawable(R.mipmap.bank_huaxia));

            }else if (bank.contains("光大")){
                ((MyViewHolder) holder).img_card.setImageDrawable(context.getResources().getDrawable(R.mipmap.bank_guangda));

            }else if (bank.contains("广发")){
                ((MyViewHolder) holder).img_card.setImageDrawable(context.getResources().getDrawable(R.mipmap.bank_guangfa));

            }else if (bank.contains("中信")){
                ((MyViewHolder) holder).img_card.setImageDrawable(context.getResources().getDrawable(R.mipmap.bank_zhongxin));

            }else if (bank.contains("平安")){
                ((MyViewHolder) holder).img_card.setImageDrawable(context.getResources().getDrawable(R.mipmap.bank_pingan));

            }



        if (position==datas.size()-1){
            ((MyViewHolder) holder).view_line.setVisibility(View.GONE);
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

    private int flag=0;

    class MyViewHolder extends RecyclerView.ViewHolder {
        TextView text_name;
        ImageView img_select,img_card;
        View view_line;

        public MyViewHolder(View itemView) {
            super(itemView);
            text_name = (TextView) itemView.findViewById(R.id.text_name);
            img_select=itemView.findViewById(R.id.img_select);

            view_line=itemView.findViewById(R.id.view_line);
            img_card=itemView.findViewById(R.id.img_card);

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
        void onSuccessListener(OBankEntity.DataBean data);

    }

    private OnItemClick onItemClick;

    public void setOnItemClick(OnItemClick onItemClick) {
        this.onItemClick = onItemClick;
    }
}
