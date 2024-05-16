package com.shop.shopnow.activities;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
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
import com.shop.shopnow.adapters.BuyAdapter;
import com.shop.shopnow.adapters.GridViewAdapter;
import com.shop.shopnow.databinding.ActivityBuyBinding;
import com.shop.shopnow.models.Buy;
import com.shop.shopnow.models.Phone;
import com.squareup.picasso.Picasso;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BuyActivity extends AppCompatActivity {

    ActivityBuyBinding binding;
    String hinhanhChecked, colorChecked, bonhoChecked, soluongmua;

    String url_dat_hang = "https://dpna.000webhostapp.com/api/dathangdon.php";
    String url_dat_hangs = "https://dpna.000webhostapp.com/api/dathang.php";

    String url_xoatatca = "https://dpna.000webhostapp.com/api/deleteAllCart.php";


    List<Buy> buyList;

    int idnguoidat;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityBuyBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        //Gán thông tin khách hàng
        //get local stogare
        SharedPreferences preferences = getSharedPreferences("MyPrefs", MODE_PRIVATE);
        binding.hovaten.setText(preferences.getString("tentaikhoan", ""));
        binding.email.setText(preferences.getString("email", ""));
        binding.sodienthoai.setText(preferences.getString("sodienthoai", ""));

        idnguoidat = preferences.getInt("idtaikhoan", -1);


        //Khởi tạo mảng
        buyList = new ArrayList<>();

        //get Intent
        Intent intent = getIntent();
//        Toast.makeText(this, String.valueOf(idnguoidat), Toast.LENGTH_SHORT).show();

        //Gán pvc
        binding.phivanchuyen.setText("Phí vận chuyển  0 VND");

        int checkBuy = intent.getIntExtra("checkBuy", -1);
        if(checkBuy == 1) {

            hinhanhChecked = intent.getStringExtra("hinhanhChecked");
            colorChecked = intent.getStringExtra("colorChecked");
            bonhoChecked = intent.getStringExtra("bonhoChecked");
            soluongmua = intent.getStringExtra("soluongmua");

            //Gán giá trị mảng
            buyList.add(new Buy(hinhanhChecked, intent.getStringExtra("tensanpham"), soluongmua, intent.getStringExtra("dongia"), colorChecked, bonhoChecked));

            //Tạo adapter
            BuyAdapter buyAdapter = new BuyAdapter(R.layout.item_buy, buyList, this);
            binding.rcvBuy.setAdapter(buyAdapter);

            //xét lại chiều cao cho listview
            binding.rcvBuy.getLayoutParams().height = dpToPx(400);
            binding.rcvBuy.requestLayout(); // Yêu cầu layout lại

            //Xử lý giá tiền
            int dongia = Integer.parseInt(intent.getStringExtra("dongia").replaceAll("\\.", ""));
            int soluong = Integer.parseInt(soluongmua);
            int tamtinh = dongia * soluong;

            String tamtinhFormat = chenDauCham(String.valueOf(tamtinh));

            binding.tamtinh.setText("Tạm tính  " + tamtinhFormat);
            binding.tongcong.setText("Tổng tiền  " + tamtinhFormat);

            //Ấn nút đặt hàng
            binding.dathang.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if(binding.magiamgia.length() != 0) {
                        Toast.makeText(BuyActivity.this, "Mã giảm giá không hợp lệ !", Toast.LENGTH_SHORT).show();
                    } else {

                        dathang(url_dat_hang,intent.getIntExtra("idnguoidat", -1),intent.getIntExtra("idsanpham", -1),intent.getStringExtra("tensanpham"), soluongmua, colorChecked, bonhoChecked, tamtinhFormat, "0 VND", tamtinhFormat, hinhanhChecked);

                        Toast.makeText(BuyActivity.this, "Đặt hàng thành công", Toast.LENGTH_SHORT).show();

                        Intent intent = new Intent(BuyActivity.this, QuanLyDonActivity.class);
                        startActivity(intent);
                        // Upload dữ liệu lên server
                    }
                }
            });

        } else {
            //test

            String jsonString = intent.getStringExtra("thanhtoan");

            String jsonString2 = intent.getStringExtra("thanhtoan2");
//            Toast.makeText(this, jsonString2, Toast.LENGTH_SHORT).show();

            //lay tong tien
            String tongtien = intent.getStringExtra("tongtien");

            try {
                JSONArray jsonArray = new JSONArray(jsonString);
                for (int i = 0; i < jsonArray.length(); i++) {
                    JSONObject jsonObject =  jsonArray.getJSONObject(i);
                    String id = jsonObject.getString("id");
                    String name = jsonObject.getString("name");
                    String img = jsonObject.getString("img");
                    String soluong = jsonObject.getString("sl");
                    String gia = jsonObject.getString("productCore");
                    String color = jsonObject.getString("color");
                    String bonho = jsonObject.getString("storage");

                    buyList.add(new Buy(img, name, soluong, gia, color, bonho));


                }

                //Tạo adapter
                BuyAdapter buyAdapter = new BuyAdapter(R.layout.item_buy, buyList, this);
                binding.rcvBuy.setAdapter(buyAdapter);

                int currentHeight = binding.rcvBuy.getHeight();


                //xét lại chiều cao cho listview
                binding.rcvBuy.getLayoutParams().height = dpToPx(jsonArray.length() * 400);
                binding.rcvBuy.requestLayout(); // Yêu cầu layout lại

                //xet tong tien
                binding.tongcong.setText("Tạm tính  " + tongtien);
                binding.tamtinh.setText("Tổng tiền  " + tongtien);


            } catch (JSONException e) {
                throw new RuntimeException(e);
            }
            //Xử lý đặt hàng

            binding.dathang.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {

                    dathangnhieu(url_dat_hangs, idnguoidat, jsonString2);
                    xoatatca(url_xoatatca, 1);

                    startActivity(new Intent(BuyActivity.this, QuanLyDonActivity.class));


                }
            });
        }

        //Áp mã
        binding.apdung.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(binding.magiamgia.length() != 0) {
                    Toast.makeText(BuyActivity.this, "Mã giảm giá không hợp lệ !", Toast.LENGTH_SHORT).show();
                }
            }
        });



    }
    //Khởi tạo menu
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
    public static String chenDauCham(String chuoi) {
        StringBuilder sb = new StringBuilder(chuoi);
        int length = sb.length();

        // Duyệt qua chuỗi từ phải sang trái và chèn dấu chấm sau mỗi 3 ký tự
        for (int i = length - 3; i > 0; i -= 3) {
            sb.insert(i, '.');
        }

        return sb.toString();
    }

    private void dathang(String url, int idnguoidat, int idsanpham, String tensanpham, String soluong, String mausac, String bonho, String tamtinh, String phivanchuyen, String tongtien, String linkanh) {

        RequestQueue requestQueue = Volley.newRequestQueue(this);
        StringRequest stringRequest = new StringRequest(Request.Method.POST, url,
                response -> {

                    Toast.makeText(this, response, Toast.LENGTH_SHORT).show();

                },
                error -> {
                    // Xử lý lỗi khi gửi yêu cầu
                }
        ){
            @NonNull
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                Map<String, String>  params = new HashMap<>();
                params.put("idnguoidat", String.valueOf(idnguoidat));
                params.put("id", String.valueOf(idsanpham));
                params.put("tendon",tensanpham);
                params.put("soluong",soluong);
                params.put("mausac",mausac);
                params.put("bonho",bonho);
                params.put("tamtinh",tamtinh);
                params.put("phivanchuyen",phivanchuyen);
                params.put("tongtien",tongtien);
                params.put("linkanh",linkanh);

                return params;
            }
        };
        requestQueue.add(stringRequest);
    }
    private void dathangnhieu(String url,int idtaikhoan, String jsonString) {

        RequestQueue requestQueue = Volley.newRequestQueue(this);
        StringRequest stringRequest = new StringRequest(Request.Method.POST, url,
                response -> {

                    Toast.makeText(this, "Đặt hàng thành công", Toast.LENGTH_SHORT).show();

                },
                error -> {
                    // Xử lý lỗi khi gửi yêu cầu
                }
        ){
            @NonNull
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                Map<String, String>  params = new HashMap<>();
                params.put("data", jsonString);
                params.put("idnguoidat", String.valueOf(idtaikhoan));

                return params;
            }
        };
        requestQueue.add(stringRequest);
    }

    private void xoatatca(String url, int query) {

        RequestQueue requestQueue = Volley.newRequestQueue(this);
        StringRequest stringRequest = new StringRequest(Request.Method.POST, url,

                response -> {
//                    Toast.makeText(this, response, Toast.LENGTH_SHORT).show();

                },

                error -> {

                }
        ){
            @NonNull
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                Map<String, String>  params = new HashMap<>();
                params.put("id", String.valueOf(query));
                return params;
            }
        };
        requestQueue.add(stringRequest);

    }

    // Phương thức để chuyển đổi dp sang px
    private int dpToPx(int dp) {
        float density = getResources().getDisplayMetrics().density;
        return Math.round(dp * density);
    }
}