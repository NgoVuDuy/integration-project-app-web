package com.shop.shopnow.activities;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.shop.shopnow.R;
import com.shop.shopnow.adapters.GridViewAdapter;
import com.shop.shopnow.adapters.QuanLyDonAdapter;
import com.shop.shopnow.databinding.ActivityQuanLyDonBinding;
import com.shop.shopnow.models.DonHang;
import com.shop.shopnow.models.Phone;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class QuanLyDonActivity extends AppCompatActivity {

    ActivityQuanLyDonBinding binding;
    List<DonHang> donHangList;

    String url_don_hang = "https://dpna.000webhostapp.com/api/getDonDat.php";
    int idtaikhoan;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityQuanLyDonBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        //Lấy idtaikhoan
        SharedPreferences preferences = getSharedPreferences("MyPrefs", MODE_PRIVATE);
        idtaikhoan = preferences.getInt("idtaikhoan", -1);

        getDonHang(url_don_hang, idtaikhoan);



    }
    //Lấy đơn hàng theo id
    private void getDonHang(String url, int idtaikhoan) {

        RequestQueue requestQueue = Volley.newRequestQueue(this);
        StringRequest stringRequest = new StringRequest(Request.Method.POST, url,
                response -> {
                    try {

                        donHangList = new ArrayList<>();

                        JSONArray jsonArray = new JSONArray(response); // Chuyển đổi response thành một JSONArray

                        for(int i = 0; i < jsonArray.length(); i++) {
                            JSONObject jsonObject = jsonArray.getJSONObject(i);

                            int iddon = jsonObject.getInt("iddon");
                            String tamtinh = jsonObject.getString("tamtinh");
                            String phivanchuyen = jsonObject.getString("phivanchuyen");
                            String tongtien = jsonObject.getString("tongtien");
                            String trangthai = jsonObject.getString("trangthai");

                            donHangList.add(new DonHang(iddon, tamtinh, phivanchuyen, tongtien, trangthai));

                        }
                        QuanLyDonAdapter quanLyDonAdapter = new QuanLyDonAdapter(R.layout.item_donhang, donHangList, this);
                        binding.listdonhang.setAdapter(quanLyDonAdapter);


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
}