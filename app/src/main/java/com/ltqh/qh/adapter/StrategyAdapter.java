package com.ltqh.qh.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.ltqh.qh.R;
import com.ltqh.qh.entity.StrategyEntity;

import java.util.ArrayList;
import java.util.List;

public class StrategyAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private static final int TYPE_ITEM = 0;
    private static final int TYPE_FOOTER = 1;

    public boolean isLoadMore = false;


    private List<StrategyEntity.DataBean> datas;


    private Context context;

    public StrategyAdapter(Context context) {
        this.context = context;
        datas = new ArrayList<>();
    }

    public void setDatas(List<StrategyEntity.DataBean> datas) {
        this.datas = datas;
        this.notifyDataSetChanged();
    }

    public void addDatas(List<StrategyEntity.DataBean> datas) {
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

            View view = LayoutInflater.from(context).inflate(R.layout.item_strategy_layout, parent, false);
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
            ((MyViewHolder) holder).text_title.setText(datas.get(position).getTitle());
            ((MyViewHolder) holder).text_publictime.setText(datas.get(position).getCreateDate().substring(0,16));
            ((MyViewHolder) holder).text_summary.setText(datas.get(position).getSummary());
            ((MyViewHolder) holder).text_readcount.setText(datas.get(position).getReadCount()+"阅读量");

            ((MyViewHolder) holder).text_summary.setLineSpacing(0f,1.4f);
            String bannerUrl = datas.get(position).getBannerUrl();

            if (!("").equals(bannerUrl)){
                Glide.with(context)
                        .load(bannerUrl)
                        .diskCacheStrategy(DiskCacheStrategy.ALL)
                        .into(((MyViewHolder) holder).img_banner);
            }else {
                ((MyViewHolder) holder).img_banner.setVisibility(View.GONE);
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
        TextView text_title, text_publictime,text_summary,text_readcount;
        ImageView img_banner;

        public MyViewHolder(View itemView) {
            super(itemView);
            text_title = (TextView) itemView.findViewById(R.id.text_title);
            text_publictime = (TextView) itemView.findViewById(R.id.text_date);
            text_readcount= (TextView) itemView.findViewById(R.id.text_readcount);
            text_summary= (TextView) itemView.findViewById(R.id.text_summary);
            img_banner= (ImageView) itemView.findViewById(R.id.img_banner);


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
        void onSuccessListener(StrategyEntity.DataBean dataBean);

    }

    private OnItemClick onItemClick;

    public void setOnItemClick(OnItemClick onItemClick) {
        this.onItemClick = onItemClick;
    }
}
