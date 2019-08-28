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
import com.ltqh.qh.operation.entity.OMessageEntity;
import com.ltqh.qh.operation.utils.OUtil;
import com.ltqh.qh.utils.DelTagsUtil;

import java.util.ArrayList;
import java.util.List;

public class OMessageAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private static final int TYPE_ITEM = 0;
    private static final int TYPE_FOOTER = 1;

    public boolean isLoadMore = false;


    private List<OMessageEntity.DataBean> datas;


    private Context context;

    public OMessageAdapter(Context context) {
        this.context = context;
        datas = new ArrayList<>();
    }

    public void setDatas( List<OMessageEntity.DataBean> datas) {
        this.datas = datas;
        this.notifyDataSetChanged();
    }

    public void addDatas( List<OMessageEntity.DataBean> datas) {
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

            View view = LayoutInflater.from(context).inflate(R.layout.o_item_message, parent, false);
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

            ((MyViewHolder) holder).text_title.setText(datas.get(position).getContent());

            long time1 = datas.get(position).getTime().getTime();


            String s = OUtil.dateToStamp(time1);

            ((MyViewHolder) holder).text_publictime.setText(s);

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
        TextView text_title, text_publictime, text_qianzhi, text_yuqi, text_shiji, text_yingxiang;
        ImageView img_star;
        RelativeLayout layout_stay, layout_stay2;

        public MyViewHolder(View itemView) {
            super(itemView);
            text_title = (TextView) itemView.findViewById(R.id.text_content);
            text_publictime = (TextView) itemView.findViewById(R.id.text_time);
            text_qianzhi = (TextView) itemView.findViewById(R.id.text_qianzhi);
            text_yuqi = (TextView) itemView.findViewById(R.id.text_yuqi);
            text_shiji = (TextView) itemView.findViewById(R.id.text_shiji);

            img_star = itemView.findViewById(R.id.img_star);
            text_yingxiang = itemView.findViewById(R.id.text_yingxiang);



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
        void onSuccessListener(OMessageEntity.DataBean content);

    }

    private OnItemClick onItemClick;

    public void setOnItemClick(OnItemClick onItemClick) {
        this.onItemClick = onItemClick;
    }
}
