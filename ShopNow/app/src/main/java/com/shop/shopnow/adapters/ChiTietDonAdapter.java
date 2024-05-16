package com.shop.shopnow.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.shop.shopnow.R;
import com.shop.shopnow.models.ChiTietDon;
import com.shop.shopnow.models.DonHang;
import com.squareup.picasso.Picasso;

import java.util.List;

public class ChiTietDonAdapter extends BaseAdapter {


    int layout;
    List<ChiTietDon> chiTietDonList;
    Context context;

    public ChiTietDonAdapter(int layout, List<ChiTietDon> chiTietDonList, Context context) {
        this.layout = layout;
        this.chiTietDonList = chiTietDonList;
        this.context = context;
    }

    @Override
    public int getCount() {
        return chiTietDonList.size();
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

        ImageView hinh = view.findViewById(R.id.hinhanhCT);
        TextView ten = view.findViewById(R.id.tensanphamCT);
        TextView soluong = view.findViewById(R.id.soluongCT);
        TextView mausac = view.findViewById(R.id.mausacCT);
        TextView bonho = view.findViewById(R.id.bonhoCT);

        ChiTietDon chiTietDon = chiTietDonList.get(i);

        Picasso.get().load(chiTietDon.getAnh()).into(hinh);
        ten.setText(chiTietDon.getTen());
        soluong.setText("Số lượng  " + chiTietDon.getSoluong());
        mausac.setText("Màu sắc  " + chiTietDon.getMausac());
        bonho.setText("Bộ nhớ  " + chiTietDon.getBonho());



        return view;
    }
}
