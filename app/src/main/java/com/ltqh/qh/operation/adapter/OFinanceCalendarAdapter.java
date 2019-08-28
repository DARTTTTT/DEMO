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
import com.ltqh.qh.entity.FinanceCalendarEnitiy;
import com.ltqh.qh.operation.entity.OFinanceCalendarEnitiy;

import java.util.ArrayList;
import java.util.List;

public class OFinanceCalendarAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private static final int TYPE_ITEM = 0;
    private static final int TYPE_FOOTER = 1;

    public boolean isLoadMore = false;


    private List<OFinanceCalendarEnitiy.NewsBean.NewsDataBean> datas;


    private Context context;

    public OFinanceCalendarAdapter(Context context) {
        this.context = context;
        datas = new ArrayList<>();
    }

    public void setDatas(List<OFinanceCalendarEnitiy.NewsBean.NewsDataBean> datas) {
        this.datas = datas;
        this.notifyDataSetChanged();
    }

    public void addDatas(List<OFinanceCalendarEnitiy.NewsBean.NewsDataBean> datas) {
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

            View view = LayoutInflater.from(context).inflate(R.layout.o_item_layout_finance, parent, false);
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
            if (position==datas.size()-1){
                ((MyViewHolder) holder).viewLine.setVisibility(View.GONE);
            }

            ((MyViewHolder) holder).text_title.setText(datas.get(position).getTitle());
            String previous = datas.get(position).getPrevious();
            String consensus = datas.get(position).getConsensus();
            String actual = datas.get(position).getActual();
            String strUnit=null;
            String unit = datas.get(position).getUnit();

            if (unit==null){
                strUnit="";
            }else {
                strUnit=unit;
            }


            String strQianzhi = null;
            String strYuqi = null;
            String strGongbu = null;


            if (previous == null) {
                strQianzhi = "--";
            } else {
                strQianzhi = previous+strUnit;
            }
            if (consensus == null) {
                strYuqi = "--";
            } else {
                strYuqi = consensus+strUnit;
            }
            if (actual == null) {
                strGongbu = "--";
            } else {
                strGongbu = actual+strUnit;
            }
            ((MyViewHolder) holder).text_previous.setText("前值:" + strQianzhi);
            ((MyViewHolder) holder).text_revised.setText("预测:" + strYuqi);
            ((MyViewHolder) holder).text_actual.setText("公布:" + strGongbu);


            String country = datas.get(position).getCountry();


            ((MyViewHolder) holder).text_country.setText(country);
            ((MyViewHolder) holder).text_publictime.setText(datas.get(position).getPublictime().substring(5, 10));
            switch (datas.get(position).getStar()) {
                case 1:
                    ((MyViewHolder) holder).img_star.setImageDrawable(context.getResources().getDrawable(R.mipmap.o_yikexing_xing));
                    break;

                case 2:
                    ((MyViewHolder) holder).img_star.setImageDrawable(context.getResources().getDrawable(R.mipmap.o_liangkexing_xing));
                    break;

                case 3:
                    ((MyViewHolder) holder).img_star.setImageDrawable(context.getResources().getDrawable(R.mipmap.o_sankexing_xing));

                    break;
                case 4:
                    ((MyViewHolder) holder).img_star.setImageDrawable(context.getResources().getDrawable(R.mipmap.o_sikexing_xing));

                    break;
                case 5:
                    ((MyViewHolder) holder).img_star.setImageDrawable(context.getResources().getDrawable(R.mipmap.o_wukexing_xing));

                    break;
            }


            if (country.equals("中国")){
                ((MyViewHolder) holder).img_country.setImageDrawable(context.getResources().getDrawable(R.mipmap.qi_zhongguo));

            }else if (country.equals("美国")){
                ((MyViewHolder) holder).img_country.setImageDrawable(context.getResources().getDrawable(R.mipmap.qi_meiguo));

            }else if (country.equals("日本")){
                ((MyViewHolder) holder).img_country.setImageDrawable(context.getResources().getDrawable(R.mipmap.qi_riben));

            }else if (country.equals("欧元区")){
                ((MyViewHolder) holder).img_country.setImageDrawable(context.getResources().getDrawable(R.mipmap.qi_oumeng));

            }else if (country.equals("英国")){
                ((MyViewHolder) holder).img_country.setImageDrawable(context.getResources().getDrawable(R.mipmap.qi_yingguo));

            }else if (country.equals("韩国")){
                ((MyViewHolder) holder).img_country.setImageDrawable(context.getResources().getDrawable(R.mipmap.qi_hanguo));

            }else if (country.equals("加拿大")){
                ((MyViewHolder) holder).img_country.setImageDrawable(context.getResources().getDrawable(R.mipmap.qi_jianada));

            }else if (country.equals("澳大利亚")){
                ((MyViewHolder) holder).img_country.setImageDrawable(context.getResources().getDrawable(R.mipmap.qi_aodaliya));

            }else if (country.equals("新西兰")){
                ((MyViewHolder) holder).img_country.setImageDrawable(context.getResources().getDrawable(R.mipmap.qi_xinxilan));

            }else if (country.equals("意大利")){
                ((MyViewHolder) holder).img_country.setImageDrawable(context.getResources().getDrawable(R.mipmap.qi_yidali));

            }else if (country.equals("德国")){
                ((MyViewHolder) holder).img_country.setImageDrawable(context.getResources().getDrawable(R.mipmap.qi_deguo));

            }else if (country.equals("瑞士")){
                ((MyViewHolder) holder).img_country.setImageDrawable(context.getResources().getDrawable(R.mipmap.qi_ruishi));

            }else {
                ((MyViewHolder) holder).img_country.setImageDrawable(context.getResources().getDrawable(R.mipmap.o_try));

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
        View viewLine;

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
            viewLine=itemView.findViewById(R.id.view_line);
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
        void onSuccessListener(OFinanceCalendarEnitiy.NewsBean.NewsDataBean dataBean);

    }

    private OnItemClick onItemClick;

    public void setOnItemClick(OnItemClick onItemClick) {
        this.onItemClick = onItemClick;
    }
}
