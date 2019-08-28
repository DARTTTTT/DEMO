package com.ltqh.qh.operation.adapter;

import android.content.Context;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.ltqh.qh.R;
import com.ltqh.qh.operation.entity.OAddressEntity;
import com.ltqh.qh.operation.entity.OBankListEntity;

import java.util.ArrayList;
import java.util.List;

public class OAreaSelectAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private static final int TYPE_ITEM = 0;
    private static final int TYPE_FOOTER = 1;

    public boolean isLoadMore = false;


    private List<OAddressEntity.DataBean> datas;


    private Context context;

    public OAreaSelectAdapter(Context context) {
        this.context = context;
        datas = new ArrayList<>();
    }

    public void setDatas(List<OAddressEntity.DataBean> datas) {
        this.datas = datas;
        this.notifyDataSetChanged();
    }

    public void addDatas(List<OAddressEntity.DataBean> datas) {
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

            View view = LayoutInflater.from(context).inflate(R.layout.o_area_layout, parent, false);
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
            ((MyViewHolder) holder).text_name.setText(datas.get(position).getName());


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
        void onSuccessListener(OAddressEntity.DataBean data);

    }

    private OnItemClick onItemClick;

    public void setOnItemClick(OnItemClick onItemClick) {
        this.onItemClick = onItemClick;
    }
}
