package com.shop.shopnow.activities;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

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
import com.shop.shopnow.adapters.GioHangAdapter;
import com.shop.shopnow.databinding.ActivityCartBinding;
import com.shop.shopnow.models.GioHang;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CartActivity extends AppCompatActivity {

    ActivityCartBinding binding;
    List<GioHang> gioHangList;

    String url_get_gio_hang = "https://dpna.000webhostapp.com/api/getCart.php";
    String url_xoatatca = "https://dpna.000webhostapp.com/api/deleteAllCart.php";
    int idtaikhoan;

    GioHangAdapter gioHangAdapter;

    JSONArray thanhtoanArray;
    JSONArray thanhtoanArray2;

    int sum = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityCartBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        //lấy idtaikhoa
        SharedPreferences preferences = getSharedPreferences("MyPrefs", MODE_PRIVATE);
        idtaikhoan = preferences.getInt("idtaikhoan", -1);

        //đổ dữ liệu
        getGioHang(url_get_gio_hang, idtaikhoan);

        //xóa tất cả
        binding.clearcart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                xoatatca(url_xoatatca, 1);
                binding.totalGH.setText("0");
                binding.thanhtoanGH.setEnabled(false);

            }
        });

        //thanh toán
        binding.thanhtoanGH.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(CartActivity.this, BuyActivity.class);
                //Đưa dữ liệu truyền màn hình
                String jsonString = thanhtoanArray.toString();
                //test
                String jsonString2 = thanhtoanArray2.toString();

                //Kiểm tra mua nhiều đơn hàng
                intent.putExtra("checkBuy", 2);

                intent.putExtra("tongtien", binding.totalGH.getText().toString());
                intent.putExtra("thanhtoan", jsonString);

                //test
                intent.putExtra("thanhtoan2", jsonString2);


                startActivity(intent);

            }
        });
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
//            onBackPressed();
            startActivity(new Intent(this, MainActivity.class));
        }
        return super.onOptionsItemSelected(item);
    }
    private void getGioHang(String url, int idtaikhoan) {

        RequestQueue requestQueue = Volley.newRequestQueue(this);
        StringRequest stringRequest = new StringRequest(Request.Method.POST, url,
                response -> {
                    try {
                        //Khởi tạo mảng lưu thông tin sp trong giỏ hàng
                        thanhtoanArray = new JSONArray();
                        thanhtoanArray2 = new JSONArray();

                        gioHangList = new ArrayList<>();

                        JSONArray jsonArray = new JSONArray(response); // Chuyển đổi response thành một JSONArray

                        for(int i = 0; i < jsonArray.length(); i++) {
                            JSONObject jsonObject = jsonArray.getJSONObject(i);

                            int idgiohang = jsonObject.getInt("idgiohang");
                            String linksp = jsonObject.getString("linksp");
                            String tensp = jsonObject.getString("tensp");
                            String giasp = jsonObject.getString("giasp");
                            String soluong = jsonObject.getString("soluong");
                            String mausac = jsonObject.getString("mausac");
                            String bonho = jsonObject.getString("bonho");
                            String tongtien = jsonObject.getString("tongtien");

                            JSONObject sanpham = new JSONObject();

                            sanpham.put("id", idgiohang);
                            sanpham.put("name", tensp);
                            sanpham.put("img", linksp);
                            sanpham.put("sl", soluong);
                            sanpham.put("productCore", giasp);
                            sanpham.put("color", mausac);
                            sanpham.put("storage", bonho);

                            thanhtoanArray.put(sanpham);

                            //Tính tổng và định dạng
                            int tongtienFormat = Integer.parseInt(tongtien.replaceAll("\\.", ""));
                            sum += tongtienFormat;

                            //Thêm dữ liệu vào danh sách giỏ hàng
                            gioHangList.add(new GioHang(idgiohang, linksp, tensp, giasp, mausac, bonho, soluong, tongtien));

                        }
                        //xét adapter và hiển thị giỏ hàng
                        gioHangAdapter = new GioHangAdapter(R.layout.item_giohang, gioHangList, this);
                        binding.listgiohang.setAdapter(gioHangAdapter);

                        //xử lý hiển thị tổng tiền tại đây
                        binding.totalGH.setText(chenDauCham(String.valueOf(sum)));

                        thanhtoanArray2.put(binding.totalGH.getText().toString());
                        for(int i = 0; i < jsonArray.length(); i++) {
                            JSONObject jsonObject = jsonArray.getJSONObject(i);

                            int idgiohang = jsonObject.getInt("idgiohang");
                            String linksp = jsonObject.getString("linksp");
                            String tensp = jsonObject.getString("tensp");
                            String giasp = jsonObject.getString("giasp");
                            String soluong = jsonObject.getString("soluong");
                            String mausac = jsonObject.getString("mausac");
                            String bonho = jsonObject.getString("bonho");
                            String tongtien = jsonObject.getString("tongtien");

                            JSONObject sanpham = new JSONObject();

                            sanpham.put("id", idgiohang);
                            sanpham.put("name", tensp);
                            sanpham.put("img", linksp);
                            sanpham.put("sl", soluong);
                            sanpham.put("productCore", giasp);
                            sanpham.put("color", mausac);
                            sanpham.put("storage", bonho);

                            thanhtoanArray2.put(sanpham);

                        }

                        if(gioHangList.size() == 0) {
                            binding.thanhtoanGH.setEnabled(false);
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
                    Toast.makeText(this, response, Toast.LENGTH_SHORT).show();

                    gioHangList.clear();
                    gioHangAdapter.notifyDataSetChanged();

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

    public static String chenDauCham(String chuoi) {
        StringBuilder sb = new StringBuilder(chuoi);
        int length = sb.length();

        // Duyệt qua chuỗi từ phải sang trái và chèn dấu chấm sau mỗi 3 ký tự
        for (int i = length - 3; i > 0; i -= 3) {
            sb.insert(i, '.');
        }

        return sb.toString();
    }
}