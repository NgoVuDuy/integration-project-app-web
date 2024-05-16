package com.shop.shopnow.activities;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.shop.shopnow.R;
import com.shop.shopnow.adapters.GridViewAdapter;
import com.shop.shopnow.databinding.ActivitySignUpBinding;
import com.shop.shopnow.models.Phone;
import com.shop.shopnow.models.User;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.net.InetSocketAddress;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Pattern;

public class SignUpActivity extends AppCompatActivity {

    ActivitySignUpBinding binding;
    User user;

    String namePattern = "^[a-zA-Z0-9]+$";
    String phoneNumberPattern = "^\\d+$";
    String emailPattern = "^[^\\s@]+@[^\\s@]+\\.[^\\s@]+$";

    String urlDangKy = "https://dpna.000webhostapp.com/api/dangky.php";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivitySignUpBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        binding.todangnhap.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(SignUpActivity.this, LoginActivity.class));
            }
        });

        binding.dangky.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                user = getUser();

                if(user.getTaikhoan().length()==0 || user.getSodienthoai().length()==0 || user.getEmail().length()==0 || user.getMatkhau().length()==0) {
                    Toast.makeText(SignUpActivity.this, "Vui lòng nhập đầy đủ thông tin", Toast.LENGTH_SHORT).show();
                } else
                    if(!user.getMatkhau().equals(user.getXacnhanmaukhau())) {
                        Toast.makeText(SignUpActivity.this, "Mật khẩu không trùng khớp", Toast.LENGTH_SHORT).show();
                    } else {
                        if(!Pattern.matches(namePattern,user.getTaikhoan())) {
                            Toast.makeText(SignUpActivity.this, "Tài khoản không bao gồm kí tự đặt biệt và khoảng trắng", Toast.LENGTH_SHORT).show();
                        }
                        else if(user.getTaikhoan().length() < 4 || user.getTaikhoan().length() > 8) {
                            Toast.makeText(SignUpActivity.this, "Tài khoản từ 4 đến 8 kí tự !", Toast.LENGTH_SHORT).show();
                        }
                        else if(!Pattern.matches(phoneNumberPattern,user.getSodienthoai()) || user.getSodienthoai().length() < 10) {
                            Toast.makeText(SignUpActivity.this, "Số điện thoại không hợp lệ !", Toast.LENGTH_SHORT).show();
                        }
                        else if(!Pattern.matches(emailPattern,user.getEmail())) {
                            Toast.makeText(SignUpActivity.this, "Email không hợp lệ !", Toast.LENGTH_SHORT).show();
                        }
                        else if(!Pattern.matches(namePattern,user.getMatkhau())) {
                            Toast.makeText(SignUpActivity.this, "Mật khẩu không bao gồm kí tự đặt biệt !", Toast.LENGTH_SHORT).show();
                        }
                        else if(user.getMatkhau().length() < 8) {
                            Toast.makeText(SignUpActivity.this, "Độ dài từ 8 ký tự trở lên !", Toast.LENGTH_SHORT).show();
                        } else {
                            Toast.makeText(SignUpActivity.this, "Hợp lệ", Toast.LENGTH_SHORT).show();
                            dangky(urlDangKy, user.getTaikhoan(), user.getMatkhau(), user.getSodienthoai(), user.getEmail());
                        }
                    }
            }
        });
    }
    private User getUser() {
        return new User(binding.taikhoan.getText().toString(), binding.sodienthoai.getText().toString(), binding.email.getText().toString(), binding.matkhau.getText().toString(), binding.nhaplaimatkhau.getText().toString());
    }


    private void dangky(String url, String taikhoan, String matkhau, String sodienthoai, String email) {

        RequestQueue requestQueue = Volley.newRequestQueue(this);
        StringRequest stringRequest = new StringRequest(Request.Method.POST, url,
                response -> {

                    if(response.equals("Thanh cong")) {
                        Toast.makeText(this, "Đăng ký thành công", Toast.LENGTH_SHORT).show();
                    } else {
                        Toast.makeText(this, "Đăng ký thất bại", Toast.LENGTH_SHORT).show();
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
                params.put("tentaikhoan",taikhoan);
                params.put("email",email);
                params.put("sodienthoai",sodienthoai);
                params.put("matkhau",matkhau);

                return params;
            }
        };
        requestQueue.add(stringRequest);
    }


}