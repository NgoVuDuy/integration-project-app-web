package com.shop.shopnow.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.shop.shopnow.R;
import com.shop.shopnow.models.Buy;
import com.squareup.picasso.Picasso;

import java.util.List;

public class BuyAdapter extends BaseAdapter {

    int layout;
    List<Buy> buyList;
    Context context;

    public BuyAdapter(int layout, List<Buy> buyList, Context context) {
        this.layout = layout;
        this.buyList = buyList;
        this.context = context;
    }

    @Override
    public int getCount() {
        return buyList.size();
    }

    @Override
    public Object getItem(int i) {
        return null;
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {

        // Khởi tạo đối tượng view
        LayoutInflater layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        view = layoutInflater.inflate(layout, null);

        ImageView hinhanh = view.findViewById(R.id.hinhanh);
        TextView ten = view.findViewById(R.id.tensanpham);
        TextView dongia = view.findViewById(R.id.dongia);
        TextView soluong = view.findViewById(R.id.soluong);
        TextView mausac = view.findViewById(R.id.mausac);
        TextView bonho = view.findViewById(R.id.bonho);

        Buy buy = buyList.get(i);
        Picasso.get().load(buy.getHinh()).into(hinhanh);
        ten.setText(buy.getTen());
        dongia.setText("Đơn giá  " + buy.getDongia());
        soluong.setText("Số lượng  " + buy.getSoluong());
        mausac.setText("Màu sắc  " + buy.getMausac());
        bonho.setText("Bộ nhớ  " + buy.getBonho());

        return view;
    }
}
