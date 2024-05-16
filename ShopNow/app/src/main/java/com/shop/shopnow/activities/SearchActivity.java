package com.shop.shopnow.activities;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.shop.shopnow.R;
import com.shop.shopnow.adapters.GridViewAdapter;
import com.shop.shopnow.databinding.ActivitySearchBinding;
import com.shop.shopnow.models.Phone;
import com.squareup.picasso.Picasso;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SearchActivity extends AppCompatActivity {

    ActivitySearchBinding binding;

    GridViewAdapter gridViewAdapter;
    List<Phone> listPhone;

    String urlSearch = "https://dpna.000webhostapp.com/api/timKiem.php";

    int idDienThoai;
    String tenDienThoai;
    String giaDienThoai;
    String manHinh;
    String heDieuHanh;
    String camreraTruoc, camreraSau;
    String chip, ram, sim,pin, hang;
    String mauMacDinh, boNhoMacDinh;
    String src;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivitySearchBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        Intent intent = getIntent();
        String query = intent.getStringExtra("tukhoatimkiem");
        resultSearch(urlSearch, query);


    }

    private void resultSearch(String url, String query) {


        RequestQueue requestQueue = Volley.newRequestQueue(this);
        StringRequest stringRequest = new StringRequest(Request.Method.POST, url,
                response -> {
                    try {

                        listPhone = new ArrayList<>();
                        JSONArray jsonArray = new JSONArray(response); // Chuyển đổi response thành một JSONArray

                        for(int i = 0; i < jsonArray.length(); i++) {
                            JSONObject jsonObject = jsonArray.getJSONObject(i);

                            idDienThoai = jsonObject.getInt("iddienthoai");
                            tenDienThoai = jsonObject.getString("tendienthoai");
                            src = jsonObject.getString("linkdienthoai");
                            giaDienThoai = jsonObject.getString("gia");
                            manHinh = jsonObject.getString("manhinh");
                            heDieuHanh = jsonObject.getString("hedieuhanh");
                            camreraTruoc = jsonObject.getString("cameratruoc");
                            camreraSau = jsonObject.getString("camerasau");
                            chip = jsonObject.getString("chip");
                            ram = jsonObject.getString("ram");
                            sim = jsonObject.getString("sim");
                            pin = jsonObject.getString("pin");
                            hang = jsonObject.getString("hang");
                            mauMacDinh = jsonObject.getString("mausacdf");
                            boNhoMacDinh = jsonObject.getString("bonhodf");

                            listPhone.add(new Phone( idDienThoai,  tenDienThoai,  giaDienThoai,  manHinh,  heDieuHanh,  camreraTruoc,  camreraSau,  chip,  ram,  sim,  pin,  hang,  mauMacDinh,  boNhoMacDinh,  src));

                        }
                        GridLayoutManager gridLayoutManager = new GridLayoutManager(this, 2);
                        binding.rcvSearch.setLayoutManager(gridLayoutManager);

                        gridViewAdapter = new GridViewAdapter(this);
                        gridViewAdapter.setData(listPhone);
                        binding.rcvSearch.setAdapter(gridViewAdapter);

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
                params.put("ketqua",query);
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