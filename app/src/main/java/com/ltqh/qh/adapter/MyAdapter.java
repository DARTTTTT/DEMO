package com.ltqh.qh.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.ltqh.qh.R;
import com.ltqh.qh.entity.MyMenuEntity;
import com.ltqh.qh.utils.AppUtil;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;

public class MyAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private static final int TYPE_ITEM = 0;
    private static final int TYPE_FOOTER = 1;

    public boolean isLoadMore = false;


    private List<MyMenuEntity> datas;


    private Context context;

    public MyAdapter(Context context) {
        this.context = context;
        datas = new ArrayList<>();
    }

    public void setDatas(List<MyMenuEntity> datas) {
        this.datas = datas;
        this.notifyDataSetChanged();
    }

    public void addDatas(List<MyMenuEntity> datas) {
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


    public void clean(List<MyMenuEntity> datas) {
        this.datas = datas;
        this.notifyDataSetChanged();

    }


    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        RecyclerView.ViewHolder holder;
        if (viewType == TYPE_ITEM) {

            View view = LayoutInflater.from(context).inflate(R.layout.item_my_layout, parent, false);
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

            String name = datas.get(position).getName();
            ((MyViewHolder) holder).text_title.setText(name);
            ((MyViewHolder) holder).img_bg.setImageResource(datas.get(position).getImg());

            switch (name) {
                case "联系客服":
                    ((MyViewHolder) holder).view.setVisibility(View.GONE);
                    break;
                case "关于我们":
                    ((MyViewHolder) holder).view.setVisibility(View.GONE);
                    ((MyViewHolder) holder).bottom_line.setVisibility(View.GONE);

                    break;

                case "个人资料":
                    ((MyViewHolder) holder).bottom_line.setVisibility(View.GONE);

                    break;

            }




            if (name.contains("清除缓存")) {

                ((MyViewHolder) holder).text_title.setText(name);
                ((MyViewHolder) holder).view.setVisibility(View.GONE);

            } else if (name.contains("0.6MB")) {
                ((MyViewHolder) holder).text_title.setText("清除缓存(0.00MB)");

            }


            //((MyViewHolder) holder).webView.loadUrl(datas.get(position));

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
        TextView text_title;
        ImageView img_bg;
        View view, bottom_line;

        public MyViewHolder(View itemView) {
            super(itemView);
            text_title = itemView.findViewById(R.id.text_name);
            img_bg = itemView.findViewById(R.id.img_icon);
            view = itemView.findViewById(R.id.right_line);
            bottom_line = itemView.findViewById(R.id.bottom_line);


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
        void onSuccessListener(MyMenuEntity content);

    }

    private OnItemClick onItemClick;

    public void setOnItemClick(OnItemClick onItemClick) {
        this.onItemClick = onItemClick;
    }
}
