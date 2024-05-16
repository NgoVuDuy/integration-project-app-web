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
import com.shop.shopnow.models.Phone;
import com.squareup.picasso.Picasso;

import java.util.List;

public class GridViewAdapter extends RecyclerView.Adapter<GridViewAdapter.GridViewHolder>{

    private Context context;
    private List<Phone> phoneList;

    public GridViewAdapter(Context context) {
        this.context = context;
    }

    public void setData(List<Phone> listOption) {
        this.phoneList = listOption;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public GridViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_phone_gv, parent, false);
        return new GridViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull GridViewHolder holder, int i) {

        // Gán dữ liệu phoneList cho view
        Phone phone = phoneList.get(holder.getAdapterPosition());
        Picasso.get().load(phone.getSrc()).into(holder.srcImg);
        holder.tenDienThoai.setText(phone.getTenDienThoai());

        // Xét sự kiện khi ấn vào từng view
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(context, InformationProductActivity.class);
//                intent.putExtra("id", phoneList.get(holder.getAdapterPosition()).getIdDienThoai());
                intent.putExtra("thongtinsanpham",phoneList.get(holder.getAdapterPosition()));
                context.startActivity(intent);

            }
        });

        // Xét sự kiện khi ấn vào item mua ngay
        holder.muaNgayBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(context, InformationProductActivity.class);
                intent.putExtra("id", phoneList.get(holder.getAdapterPosition()).getIdDienThoai());
                intent.putExtra("thongtinsanpham",phoneList.get(holder.getAdapterPosition()));
                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        if(phoneList != null) {
            return phoneList.size();
        }
        return 0;
    }

    public class GridViewHolder extends RecyclerView.ViewHolder {

        private ImageView srcImg;
        private TextView tenDienThoai;
        private Button muaNgayBtn;
        public GridViewHolder(@NonNull View itemView) {
            super(itemView);
            srcImg = itemView.findViewById(R.id.hinhDienThoai);
            tenDienThoai = itemView.findViewById(R.id.tenDienThoai);
            muaNgayBtn = itemView.findViewById(R.id.btnMuaNgay);
        }
    }
}
