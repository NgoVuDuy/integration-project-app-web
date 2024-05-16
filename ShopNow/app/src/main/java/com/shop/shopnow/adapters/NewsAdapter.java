package com.shop.shopnow.adapters;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;


import com.shop.shopnow.R;
import com.shop.shopnow.activities.InformationProductActivity;
import com.shop.shopnow.activities.News2Activity;
import com.shop.shopnow.models.News;
import com.squareup.picasso.Picasso;

import java.util.List;

public class NewsAdapter extends RecyclerView.Adapter<NewsAdapter.NewsHolder>{

    private Context context;
    private List<News> NewsList;

    public NewsAdapter(Context context) {
        this.context = context;
    }

    public void setData(List<News> listOption) {
        this.NewsList = listOption;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public NewsHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_news, parent, false);
        return new NewsHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull NewsHolder holder, int i) {

        // Gán dữ liệu NewsList cho view
        News news = NewsList.get(holder.getAdapterPosition());
        holder.srcImg.setImageResource(news.getSrc());
        holder.tieuDe.setText(news.getTieuDe());

        // Xét sự kiện khi ấn vào từng view
//        holder.itemView.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                context.startActivity(new Intent(context, InformationProductActivity.class));
//            }
//        });

        // Xét sự kiện khi ấn vào item xem thêm
        holder.xemThemBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(context, News2Activity.class);

                intent.putExtra("tieude", NewsList.get(holder.getAdapterPosition()).getTieuDeFull());
                intent.putExtra("noidung", NewsList.get(holder.getAdapterPosition()).getNoiDung());

                context.startActivity(intent);

            }
        });
    }

    @Override
    public int getItemCount() {
        if(NewsList != null) {
            return NewsList.size();
        }
        return 0;
    }

    public class NewsHolder extends RecyclerView.ViewHolder {
        private ImageView srcImg;
        private TextView tieuDe;
        private Button xemThemBtn;
        public NewsHolder(@NonNull View itemView) {
            super(itemView);
            srcImg = itemView.findViewById(R.id.hinhTinTuc);
            tieuDe = itemView.findViewById(R.id.tieuDe);
            xemThemBtn = itemView.findViewById(R.id.btnXemThem);
        }
    }
}
