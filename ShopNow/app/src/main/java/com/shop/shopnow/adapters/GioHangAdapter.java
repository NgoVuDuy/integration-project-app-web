package com.shop.shopnow.adapters;


import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.shop.shopnow.R;
import com.shop.shopnow.activities.CartActivity;
import com.shop.shopnow.models.GioHang;
import com.squareup.picasso.Picasso;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GioHangAdapter extends BaseAdapter {

    int layout;
    List<GioHang> gioHangList;
    Context context;

    String url_xoasp = "https://dpna.000webhostapp.com/api/deleteCart.php";

    public GioHangAdapter(int layout, List<GioHang> gioHangList, Context context) {
        this.layout = layout;
        this.gioHangList = gioHangList;
        this.context = context;
    }

    @Override
    public int getCount() {
        return gioHangList.size();
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

        ImageView hinhanh = view.findViewById(R.id.hinhanhGH);
        TextView ten = view.findViewById(R.id.tensanphamGH);
        TextView dongia = view.findViewById(R.id.dongiaGH);
        TextView mausac = view.findViewById(R.id.mausacGH);
        TextView bonho = view.findViewById(R.id.bonhoGH);
        TextView tongtien = view.findViewById(R.id.tongtienGH);
        TextView soluong = view.findViewById(R.id.soluongGH);
        Button xoa = view.findViewById(R.id.xoaGH);

        GioHang gioHang = gioHangList.get(i);
        Picasso.get().load(gioHang.getHinhanh()).into(hinhanh);
        ten.setText(gioHang.getTen());
        dongia.setText("Đơn giá  " + gioHang.getDongia());
        mausac.setText("Màu sắc  " + gioHang.getMausac());
        bonho.setText("Bộ nhớ  " + gioHang.getBonho());
        tongtien.setText("Tổng tiền  " + gioHang.getTongtien());
        soluong.setText("Số lượng  " + gioHang.getSoluong());

        //Xóa từng sản phầm
        xoa.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(context, String.valueOf(gioHang.getId()), Toast.LENGTH_SHORT).show();

                xoasanpham(url_xoasp, gioHang.getId(), i);

                context.startActivity(new Intent(context, CartActivity.class));

            }
        });

        return view;
    }

    private void xoasanpham(String url, int idsanpham, int p) {

        RequestQueue requestQueue = Volley.newRequestQueue(context);
        StringRequest stringRequest = new StringRequest(Request.Method.POST, url,

                response -> {
                    Toast.makeText(context, response, Toast.LENGTH_SHORT).show();

                    gioHangList.remove(p);
                    notifyDataSetChanged();

                },

                error -> {

                }
        ){
            @NonNull
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                Map<String, String>  params = new HashMap<>();
                params.put("id", String.valueOf(idsanpham));
                return params;
            }
        };
        requestQueue.add(stringRequest);

    }

}
