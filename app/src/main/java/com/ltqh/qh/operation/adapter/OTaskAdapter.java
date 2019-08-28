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
import com.ltqh.qh.operation.entity.OFundsEntity;
import com.ltqh.qh.operation.entity.OTaskEntity;
import com.ltqh.qh.operation.utils.OUtil;

import java.util.ArrayList;
import java.util.List;

public class OTaskAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private static final int TYPE_ITEM = 0;
    private static final int TYPE_FOOTER = 1;

    public boolean isLoadMore = false;


    private List<OTaskEntity.DataBean> datas;


    private Context context;

    public OTaskAdapter(Context context) {
        this.context = context;
        datas = new ArrayList<>();
    }

    public void setDatas(List<OTaskEntity.DataBean> datas) {
        this.datas = datas;
        this.notifyDataSetChanged();
    }

    public void addDatas(List<OTaskEntity.DataBean> datas) {
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

            View view = LayoutInflater.from(context).inflate(R.layout.o_task_layout, parent, false);
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
            ((MyViewHolder) holder).text_subname.setText(datas.get(position).getSubname());

            String statusName = datas.get(position).getStatusName();

            if (statusName.contains("已过期")){
                ((MyViewHolder) holder).text_join.setBackground(context.getResources().getDrawable(R.drawable.o_bg_gray_task));
                ((MyViewHolder) holder).text_join.setTextColor(context.getResources().getColor(R.color.white));

            }else if (statusName.contains("未参与")){
                ((MyViewHolder) holder).text_join.setBackground(context.getResources().getDrawable(R.drawable.o_bg_kuang_maincolor));
                ((MyViewHolder) holder).text_join.setTextColor(context.getResources().getColor(R.color.maincolor));
            }else if (statusName.contains("已领取")){
                ((MyViewHolder) holder).text_join.setBackground(context.getResources().getDrawable(R.drawable.o_bg_gray_task));
                ((MyViewHolder) holder).text_join.setTextColor(context.getResources().getColor(R.color.white));

            }


            int type = datas.get(position).getType();
            switch (type){
                case 6:
                    ((MyViewHolder) holder).img_icon.setImageDrawable(context.getResources().getDrawable(R.mipmap.o_task_one));
                    break;
                case 4:
                    ((MyViewHolder) holder).img_icon.setImageDrawable(context.getResources().getDrawable(R.mipmap.o_task_two));
                    break;
                case 2:
                    ((MyViewHolder) holder).img_icon.setImageDrawable(context.getResources().getDrawable(R.mipmap.o_task_three));

                    break;
                case 7:
                    ((MyViewHolder) holder).img_icon.setImageDrawable(context.getResources().getDrawable(R.mipmap.o_task_four));

                    break;
                case 8:
                    ((MyViewHolder) holder).img_icon.setImageDrawable(context.getResources().getDrawable(R.mipmap.o_task_five));

                    break;
            }


            ((MyViewHolder) holder).text_join.setText(statusName);
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
        TextView text_name,text_subname,text_join;
        ImageView img_icon;
        View view_line;

        public MyViewHolder(View itemView) {
            super(itemView);
            text_name =  itemView.findViewById(R.id.text_name);
            text_subname=itemView.findViewById(R.id.text_subname);
            text_join=itemView.findViewById(R.id.text_join);
            img_icon=itemView.findViewById(R.id.img_task);
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
        void onSuccessListener(OTaskEntity.DataBean data);

    }

    private OnItemClick onItemClick;

    public void setOnItemClick(OnItemClick onItemClick) {
        this.onItemClick = onItemClick;
    }
}
