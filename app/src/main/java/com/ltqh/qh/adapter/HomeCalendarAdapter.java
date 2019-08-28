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
import com.ltqh.qh.entity.FinanceEntity;

import java.util.ArrayList;
import java.util.List;

public class HomeCalendarAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private static final int TYPE_ITEM = 0;
    private static final int TYPE_FOOTER = 1;

    public boolean isLoadMore = false;


    private List<FinanceEntity.DataBean.NewsBean.NewsDataBean> datas;


    private Context context;

    public HomeCalendarAdapter(Context context) {
        this.context = context;
        datas = new ArrayList<>();
    }

    public void setDatas(List<FinanceEntity.DataBean.NewsBean.NewsDataBean> datas) {
        this.datas = datas;
        this.notifyDataSetChanged();
    }

    public void addDatas(List<FinanceEntity.DataBean.NewsBean.NewsDataBean> datas) {
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

            View view = LayoutInflater.from(context).inflate(R.layout.item_calendar_layout, parent, false);
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
            ((MyViewHolder) holder).text_previous.setText("前值:" + datas.get(position).getPrevious());
            ((MyViewHolder) holder).text_revised.setText("预测:" + datas.get(position).getRevised());
            ((MyViewHolder) holder).text_actual.setText("公布值:" + datas.get(position).getActual());
            ((MyViewHolder) holder).text_country.setText(datas.get(position).getCountry());
            ((MyViewHolder) holder).text_publictime.setText(datas.get(position).getPublictime().substring(11, 16));
            switch (datas.get(position).getStar()) {
                case 1:
                    ((MyViewHolder) holder).img_star.setBackgroundResource(R.mipmap.star_one_liang);
                    break;

                case 2:
                    ((MyViewHolder) holder).img_star.setBackgroundResource(R.mipmap.star_two_liang);

                    break;

                case 3:
                    ((MyViewHolder) holder).img_star.setBackgroundResource(R.mipmap.star_three_liang);

                    break;
            }

            switch (datas.get(position).getCountry()) {
                case "中国":
                    ((MyViewHolder) holder).img_country.setBackgroundResource(R.mipmap.qi_zhongguo);
                    break;
                case "日本":
                    ((MyViewHolder) holder).img_country.setBackgroundResource(R.mipmap.qi_riben);
                    break;
                case "美国":
                    ((MyViewHolder) holder).img_country.setBackgroundResource(R.mipmap.qi_meiguo);
                    break;
                case "欧元区":
                    ((MyViewHolder) holder).img_country.setBackgroundResource(R.mipmap.qi_oumeng);
                    break;
                case "英国":
                    ((MyViewHolder) holder).img_country.setBackgroundResource(R.mipmap.qi_yingguo);
                    break;
                case "韩国":
                    ((MyViewHolder) holder).img_country.setBackgroundResource(R.mipmap.qi_hanguo);
                    break;
                case "加拿大":
                    ((MyViewHolder) holder).img_country.setBackgroundResource(R.mipmap.qi_jianada);
                    break;
                case "澳大利亚":
                    ((MyViewHolder) holder).img_country.setBackgroundResource(R.mipmap.qi_aodaliya);
                    break;
                case "新西兰":
                    ((MyViewHolder) holder).img_country.setBackgroundResource(R.mipmap.qi_xinxilan);
                    break;
                case "意大利":
                    ((MyViewHolder) holder).img_country.setBackgroundResource(R.mipmap.qi_yidali);
                    break;
                case "德国":
                    ((MyViewHolder) holder).img_country.setBackgroundResource(R.mipmap.qi_deguo);
                    break;
                case "瑞士":
                    ((MyViewHolder) holder).img_country.setBackgroundResource(R.mipmap.qi_ruishi);
                    break;
                case "俄罗斯":
                    ((MyViewHolder) holder).img_country.setBackgroundResource(R.mipmap.qi_els);

                    break;
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
        TextView text_title, text_previous, text_revised, text_actual, text_country, text_publictime;
        ImageView img_star, img_country;

        public MyViewHolder(View itemView) {
            super(itemView);
            text_title = (TextView) itemView.findViewById(R.id.text_title);
            text_previous = (TextView) itemView.findViewById(R.id.text_previous);
            text_revised = (TextView) itemView.findViewById(R.id.text_revised);
            text_actual = (TextView) itemView.findViewById(R.id.text_actual);
            text_country = (TextView) itemView.findViewById(R.id.text_country);
            text_publictime = (TextView) itemView.findViewById(R.id.text_publictime);
            img_star = (ImageView) itemView.findViewById(R.id.img_star);
            img_country = (ImageView) itemView.findViewById(R.id.img_country);
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
        void onSuccessListener(FinanceEntity.DataBean.NewsBean.NewsDataBean dataBean);

    }

    private OnItemClick onItemClick;

    public void setOnItemClick(OnItemClick onItemClick) {
        this.onItemClick = onItemClick;
    }
}
