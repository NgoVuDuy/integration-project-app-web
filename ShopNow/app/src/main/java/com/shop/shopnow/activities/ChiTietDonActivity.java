package com.shop.shopnow.activities;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.shop.shopnow.R;
import com.shop.shopnow.adapters.ChiTietDonAdapter;
import com.shop.shopnow.adapters.QuanLyDonAdapter;
import com.shop.shopnow.databinding.ActivityChiTietDonBinding;
import com.shop.shopnow.models.ChiTietDon;
import com.shop.shopnow.models.DonHang;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ChiTietDonActivity extends AppCompatActivity {

    String url_getchitietdon = "https://dpna.000webhostapp.com/api/getChitietDon.php";
    String url_updatetrangthai = "https://dpna.000webhostapp.com/api/updateTrangThaiDon.php";

    ActivityChiTietDonBinding binding;

    List<ChiTietDon> chiTietDonList;

    String tongtien;
    String trangthai;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityChiTietDonBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        Intent intent = getIntent();
        int iddonhang = intent.getIntExtra("iddonhang", -1);


        getDonHang(url_getchitietdon, iddonhang);

        binding.nhanhangCT.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                updateTrangThai(url_updatetrangthai, iddonhang);
            }
        });


    }

    private void getDonHang(String url, int iddonhang) {

        RequestQueue requestQueue = Volley.newRequestQueue(this);
        StringRequest stringRequest = new StringRequest(Request.Method.POST, url,
                response -> {
                    try {

                        chiTietDonList = new ArrayList<>();

                        JSONArray jsonArray = new JSONArray(response); // Chuyển đổi response thành một JSONArray

                        for(int i = 0; i < jsonArray.length(); i++) {
                            JSONObject jsonObject = jsonArray.getJSONObject(i);

                            String linkanh = jsonObject.getString("linkanh");
                            String ten = jsonObject.getString("ten");
                            String soluong = jsonObject.getString("soluong");
                            String mausac = jsonObject.getString("mausac");
                            String bonho = jsonObject.getString("bonho");
                            tongtien = jsonObject.getString("tongtien");
                            trangthai = jsonObject.getString("trangthai");

                            chiTietDonList.add(new ChiTietDon(linkanh, ten, soluong, mausac, bonho));

                        }
                        ChiTietDonAdapter chiTietDonAdapter = new ChiTietDonAdapter(R.layout.item_chitietdon, chiTietDonList, this);
                        binding.listchitietdon.setAdapter(chiTietDonAdapter);

                        binding.tongtienCT.setText("Tổng " + tongtien);

                        if(trangthai.equals("Đã nhận hàng")) {
                            binding.nhanhangCT.setVisibility(View.GONE);
                        }


                    } catch (JSONException e) {
                        throw new RuntimeException(e);
                    }
                },
                error -> {
                    // Xử lý lỗi khi gửi yêu cầu
                }
        ){
            @NonNull
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                Map<String, String>  params = new HashMap<>();
                params.put("id", String.valueOf(iddonhang));
                return params;
            }
        };
        requestQueue.add(stringRequest);
    }
    private void updateTrangThai(String url, int iddonhang) {

        RequestQueue requestQueue = Volley.newRequestQueue(this);
        StringRequest stringRequest = new StringRequest(Request.Method.POST, url,
                response -> {

                        Toast.makeText(this, "Đã cập nhật thành công", Toast.LENGTH_SHORT).show();
                        startActivity(new Intent(ChiTietDonActivity.this, QuanLyDonActivity.class));

                },
                error -> {
                    // Xử lý lỗi khi gửi yêu cầu
                }
        ){
            @NonNull
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                Map<String, String>  params = new HashMap<>();
                params.put("id", String.valueOf(iddonhang));
                return params;
            }
        };
        requestQueue.add(stringRequest);
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_back, menu);
        return super.onCreateOptionsMenu(menu);
    }

    // Xét sự kiện ấn vào menu
    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {

        if(item.getItemId() == R.id.back_item) {
            onBackPressed();
        }
        return super.onOptionsItemSelected(item);
    }
}