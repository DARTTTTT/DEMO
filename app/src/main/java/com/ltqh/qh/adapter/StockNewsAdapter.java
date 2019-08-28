package com.ltqh.qh.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.ltqh.qh.R;
import com.ltqh.qh.entity.AlertsEntity;
import com.ltqh.qh.entity.StocknewsEntity;
import com.ltqh.qh.view.XCRoundRectImageView;

import java.util.ArrayList;
import java.util.List;

public class StockNewsAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private static final int TYPE_ITEM = 0;
    private static final int TYPE_FOOTER = 1;

    public boolean isLoadMore = false;


    private Context context;
    private List<StocknewsEntity.DataBean> datas;

    public StockNewsAdapter(Context context) {
        this.context = context;
        datas = new ArrayList<>();
    }

    public void setDatas(List<StocknewsEntity.DataBean> datas) {
        this.datas = datas;
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

            View view = LayoutInflater.from(context).inflate(R.layout.item_stocknews_layout, parent, false);
            holder = new MyViewHolder(view);
            return holder;
        }


        View view = LayoutInflater.from(context).inflate(R.layout.item_foot_layout, parent, false);
        holder = new ProgressViewHoler(view);


        return holder;

    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        if (holder instanceof MyViewHolder) {
            ((MyViewHolder) holder).text_title.setText(datas.get(position).getTitle());
            ((MyViewHolder) holder).text_time.setText(datas.get(position).getTime());
            String images = datas.get(position).getImages();
            String s = images.replaceAll("http", "https");
            Glide.with(context.getApplicationContext())
                    .load(s)
                    .asBitmap()
                    .centerCrop()
                    .into(((MyViewHolder) holder).img_bg);


            ((MyViewHolder) holder).layout.removeAllViews();
            for (int i = 0; i < datas.get(position).getKeywords().size(); i++) {
                TextView textView = new TextView(context);
                textView.setLayoutParams(new LinearLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT));
                textView.setTextColor(context.getResources().getColor(R.color.maincolor));
               // textView.setBackground(context.getResources().getDrawable(R.drawable.bg_kuang_mainclor));
                textView.setPadding(10, 3, 10, 3);
                textView.setGravity(Gravity.CENTER_VERTICAL);
                textView.setTextSize(12);
                textView.setText(datas.get(position).getKeywords().get(i));
                LinearLayout.LayoutParams lp = (LinearLayout.LayoutParams) textView.getLayoutParams();
                lp.setMargins(5,5,5,5);
                textView.setLayoutParams(lp);
                ((MyViewHolder) holder).layout.addView(textView);
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
        TextView text_title, text_time;
        XCRoundRectImageView img_bg;
        LinearLayout layout;

        public MyViewHolder(View itemView) {
            super(itemView);
            text_title = (TextView) itemView.findViewById(R.id.text_title);
            text_time = (TextView) itemView.findViewById(R.id.text_time);
            img_bg = itemView.findViewById(R.id.img_bg);
            layout = itemView.findViewById(R.id.layout_view);

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

    private OnItemClick onItemClick;

    public void setOnItemClick(OnItemClick onItemClick) {
        this.onItemClick = onItemClick;
    }

    public interface OnItemClick {
        void onSuccessListener(StocknewsEntity.DataBean dataBean);

    }
}
