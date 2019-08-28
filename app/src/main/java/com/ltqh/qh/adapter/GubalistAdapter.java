package com.ltqh.qh.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.ltqh.qh.R;
import com.ltqh.qh.entity.GubaEntity;

import java.util.ArrayList;
import java.util.List;

public class GubalistAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private static final int TYPE_ITEM = 0;
    private static final int TYPE_FOOTER = 1;

    public boolean isLoadMore = false;


    private List<GubaEntity.DataBeanX.DataBean> datas;


    private Context context;

    public GubalistAdapter(Context context) {
        this.context = context;
        datas = new ArrayList<>();
    }

    public void setDatas(List<GubaEntity.DataBeanX.DataBean> datas) {
        this.datas = datas;
        this.notifyDataSetChanged();
    }

    public void addDatas(List<GubaEntity.DataBeanX.DataBean> datas) {
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

            View view = LayoutInflater.from(context).inflate(R.layout.item_gubalist_layout, parent, false);
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
         ((MyViewHolder) holder).text_name.setText(datas.get(position).getName());
         ((MyViewHolder) holder).text_code.setText(datas.get(position).getCode()+"");
            int status = datas.get(position).getShareit();
            if (status==0){
                ((MyViewHolder) holder).text_add.setText("加入");
            }else {
                ((MyViewHolder) holder).text_add.setText("退出");
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
        TextView text_name, text_code,text_add;
        ImageView img_star;

        public MyViewHolder(View itemView) {
            super(itemView);
            text_name = (TextView) itemView.findViewById(R.id.text_name);
            text_code = (TextView) itemView.findViewById(R.id.text_code);
            text_add=itemView.findViewById(R.id.text_add);


            text_add.setOnClickListener(new View.OnClickListener() {
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
        void onSuccessListener(GubaEntity.DataBeanX.DataBean content);

    }

    private OnItemClick onItemClick;

    public void setOnItemClick(OnItemClick onItemClick) {
        this.onItemClick = onItemClick;
    }
}
