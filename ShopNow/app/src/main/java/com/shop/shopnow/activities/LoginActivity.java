package com.shop.shopnow.activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.Volley;
import com.google.android.material.datepicker.SingleDateSelector;
import com.shop.shopnow.R;
import com.shop.shopnow.adapters.GridViewAdapter;
import com.shop.shopnow.databinding.ActivityLoginBinding;
import com.shop.shopnow.models.Phone;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class LoginActivity extends AppCompatActivity {

    ActivityLoginBinding binding;

    String urlDangNhap = "https://dpna.000webhostapp.com/api/dangnhap.php";

    boolean checkLogin = false;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityLoginBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        SharedPreferences preferences = getSharedPreferences("MyPrefs", MODE_PRIVATE);
        if(preferences.contains("idtaikhoan")) {
//            Toast.makeText(this, "Đã tồn tại idtaikhoan", Toast.LENGTH_SHORT).show();
            startActivity(new Intent(this, MainActivity.class));
        } else {
//            Toast.makeText(this, "Chưa tồn tại idtaikhoan", Toast.LENGTH_SHORT).show();
        }


        binding.todangky.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(LoginActivity.this, SignUpActivity.class));
            }
        });

        binding.dangnhap.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                dangnhap(urlDangNhap);
            }
        });

    }

    @Override
    protected void onResume() {
        super.onResume();

        binding.taikhoanlogin.setText(null);
        binding.matkhaulogin.setText(null);
    }

    public void dangnhap(String url) {

        SharedPreferences preferences = getSharedPreferences("MyPrefs", MODE_PRIVATE);
        SharedPreferences.Editor editor = preferences.edit();

        RequestQueue requestQueue = Volley.newRequestQueue(this);
        JsonArrayRequest jsonArrayRequest = new JsonArrayRequest(Request.Method.GET, url, null,
                response -> {
                    try {
                        for(int i = 0; i < response.length(); i ++) {
                            JSONObject jsonObject = response.getJSONObject(i);

                            int idtaikhoan = jsonObject.getInt("idtaikhoan");
                            String taikhoan = jsonObject.getString("tentaikhoan");
                            String matkhau = jsonObject.getString("matkhau");
                            String sodienthoai = jsonObject.getString("sodienthoai");
                            String email = jsonObject.getString("email");

                            if(taikhoan.equals(binding.taikhoanlogin.getText().toString()) && matkhau.equals(binding.matkhaulogin.getText().toString())) {

                                checkLogin = true;

                                editor.putInt("idtaikhoan", idtaikhoan);
                                editor.putString("tentaikhoan", taikhoan);
                                editor.putString("matkhau", matkhau);
                                editor.putString("sodienthoai", sodienthoai);
                                editor.putString("email", email);

                                editor.apply();
                                break;

                            }
                        }
                        if(checkLogin) {
                            Toast.makeText(this, "Đăng nhập thành công", Toast.LENGTH_SHORT).show();
                            startActivity(new Intent(LoginActivity.this, MainActivity.class));

                        } else {
                            Toast.makeText(this, "Đăng nhập thất bại", Toast.LENGTH_SHORT).show();
                        }

                    } catch (JSONException e) {
                        throw new RuntimeException(e);
                    }
                },
                error -> {
                }
        );
        requestQueue.add(jsonArrayRequest);
    }
}