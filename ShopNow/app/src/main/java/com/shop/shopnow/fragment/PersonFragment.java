package com.shop.shopnow.fragment;

import static android.content.Context.MODE_PRIVATE;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.shop.shopnow.R;
import com.shop.shopnow.activities.LoginActivity;
import com.shop.shopnow.activities.QuanLyDonActivity;
import com.shop.shopnow.adapters.GridViewAdapter;
import com.shop.shopnow.databinding.FragmentPersonBinding;
import com.shop.shopnow.models.Phone;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class PersonFragment extends Fragment {

    FragmentPersonBinding binding;

    Context context;

    String urlXoaTaiKhoan = "https://dpna.000webhostapp.com/api/deleteUser.php";

    public PersonFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        binding = FragmentPersonBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        //Lấy thông tin từ local stogare
        SharedPreferences preferences = requireContext().getSharedPreferences("MyPrefs", MODE_PRIVATE);
        SharedPreferences.Editor editor = preferences.edit();

        // Xét tên tài khoản
        String tentaikhoan  = preferences.getString("tentaikhoan", "");
        binding.tentaikhoan.setText(tentaikhoan);
        //
        int idtaikhoan = preferences.getInt("idtaikhoan", -1);

        //Ấn quản lý đon
        binding.mngDonDat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(requireContext(), QuanLyDonActivity.class);
                startActivity(intent);
            }
        });
        //Ấn đăng xuất
        binding.logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(requireContext(), "Đăng xuất thành công", Toast.LENGTH_SHORT).show();

                //Xóa thông tin user khỏi local storage
                editor.remove("idtaikhoan");
                editor.remove("tentaikhoan");
                editor.remove("matkhau");
                editor.remove("sodienthoai");
                editor.remove("email");
                editor.apply();

                startActivity(new Intent(requireContext(), LoginActivity.class));
            }
        });
        //Ấn xóa tài khoản
        binding.dltUser.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                Toast.makeText(requireContext(), "Chưa làm", Toast.LENGTH_SHORT).show();
                //Xóa thông tin user khỏi local stogare
                editor.remove("idtaikhoan");
                editor.remove("tentaikhoan");
                editor.remove("matkhau");
                editor.remove("sodienthoai");
                editor.remove("email");
                editor.apply();

                //Xóa tài khoản khỏi server
                xoaTaiKhoan(urlXoaTaiKhoan, idtaikhoan);

                startActivity(new Intent(requireContext(), LoginActivity.class));

            }
        });

        return view;

    }

    private void xoaTaiKhoan(String url, int id) {

        RequestQueue requestQueue = Volley.newRequestQueue(requireContext());
        StringRequest stringRequest = new StringRequest(Request.Method.POST, url,
                response -> {
            
                    if(response.equals("Thanh cong")) {
                        Toast.makeText(requireContext(), "Xóa tài khoản thành công", Toast.LENGTH_SHORT).show();
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
                params.put("iduser",String.valueOf(id));
                return params;
            }
        };
        requestQueue.add(stringRequest);
    }

}