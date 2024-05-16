package com.shop.shopnow.adapters;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.TextView;

import com.shop.shopnow.R;
import com.shop.shopnow.activities.ChiTietDonActivity;
import com.shop.shopnow.models.DonHang;

import java.util.List;

public class QuanLyDonAdapter extends BaseAdapter {

    int layout;
    List<DonHang> donHangList;
    Context context;

    public QuanLyDonAdapter(int layout, List<DonHang> donHangList, Context context) {
        this.layout = layout;
        this.donHangList = donHangList;
        this.context = context;
    }

    @Override
    public int getCount() {
        return donHangList.size();
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

        TextView madon = view.findViewById(R.id.madon);
        TextView tamtinh = view.findViewById(R.id.tamtinh);
        TextView phivanchuyen = view.findViewById(R.id.phivanchuyen);
        TextView tongtien = view.findViewById(R.id.tongtien);
        TextView trangthai = view.findViewById(R.id.trangthai);
        Button xemchitiet = view.findViewById(R.id.xemchitiet);

        //Gán giá trị
        DonHang donHang = donHangList.get(i);
        madon.setText("Mã đơn  " +  String.valueOf(donHang.getMaDon()));
        tamtinh.setText("Tạm tính  " +  donHang.getTamTinh());
        phivanchuyen.setText("Phí vận chuyển  " +  donHang.getPhiVanChuyen());
        tongtien.setText("Tổng tiền  " +  donHang.getTongTien());
        trangthai.setText("Trạng thái  " +  donHang.getTrangThai());

        xemchitiet.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(context, ChiTietDonActivity.class);

                intent.putExtra("iddonhang", donHang.getMaDon());

                context.startActivity(intent);
            }
        });

        return view;
    }
}
