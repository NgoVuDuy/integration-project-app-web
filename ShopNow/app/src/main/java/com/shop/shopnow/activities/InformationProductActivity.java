package com.shop.shopnow.activities;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;

import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.shop.shopnow.R;
import com.shop.shopnow.adapters.GridViewAdapter;
import com.shop.shopnow.databinding.ActivityInformationProductBinding;
import com.shop.shopnow.models.Phone;
import com.squareup.picasso.Picasso;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class InformationProductActivity extends AppCompatActivity {

    ActivityInformationProductBinding binding;
    int idDienThoai;
    int idtaikhoan;

    List<String> hinhanh;
    List<String> color;

    List<String> bonho;

    List<ImageView> imageViewList;
    List<TextView> colorList;
    List<TextView> bonhoList;

    String url_get_color = "https://dpna.000webhostapp.com/api/getColorPhoneById.php";
    String url_get_stogare = "https://dpna.000webhostapp.com/api/getStogarePhoneById.php";

    String url_themvaogiohang = "https://dpna.000webhostapp.com/api/addPhoneToCartCT.php";

    String hinhanhChecked, colorChecked, bonhoChecked;

    boolean isClickImg = false;
    boolean isClickBonho = false;

    Phone phone = new Phone();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityInformationProductBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        //Lấy idtaikhoan
        SharedPreferences preferences = getSharedPreferences("MyPrefs", MODE_PRIVATE);
        idtaikhoan = preferences.getInt("idtaikhoan", -1);

        Intent intent = getIntent();

        //Lấy thông tin sản phẩm
        phone = (Phone) intent.getSerializableExtra("thongtinsanpham");

        //Lấy iddienthoai
        idDienThoai = phone.getIdDienThoai();

        //Gán giá trị
        binding.tenDienThoaiCT.setText(phone.getTenDienThoai());
        binding.giaDienThoaiCT.setText(phone.getGiaDienThoai() + " VND");
        binding.hangDienThoaiCT.setText("Hãng: " + phone.getHang());
        binding.manHinhDienThoaiCT.setText("Màn hình: " +phone.getManHinh());

        binding.osDienThoaiCT.setText("Hệ điều hành: " +phone.getHeDieuHanh());
        binding.camTruocDienThoaiCT.setText("Camera trước: " +phone.getCamreraTruoc());
        binding.camSauDienThoaiCT.setText("Camera sau: " +phone.getCamreraSau());
        binding.chipDienThoaiCT.setText("Chip: " +phone.getChip());
        binding.ramDienThoaiCT.setText("Ram: " +phone.getRam());
        binding.simDienThoaiCT.setText("Sim: " +phone.getSim());
        binding.pinSacDienThoaiCT.setText("Pin, sạc: " +phone.getPin());

        //Khởi tạo mảng 1
        imageViewList = new ArrayList<>();
        imageViewList.add(binding.hinh1);
        imageViewList.add(binding.hinh2);
        imageViewList.add(binding.hinh3);
        imageViewList.add(binding.hinh4);
        //Khởi tạo mảng 2
        colorList = new ArrayList<>();
        colorList.add(binding.mau1);
        colorList.add(binding.mau2);
        colorList.add(binding.mau3);
        colorList.add(binding.mau4);
        //Khởi tạo mảng 3
        bonhoList = new ArrayList<>();
        bonhoList.add(binding.bonho1);
        bonhoList.add(binding.bonho2);
        bonhoList.add(binding.bonho3);
        bonhoList.add(binding.bonho4);

        //Lấy màu sắc và hình tương ứng của sản phẩm
        getColorProduct(url_get_color, idDienThoai);
        //Lấy bộ nhớ tương ứng với sản phẩm
        getStogare(url_get_stogare, idDienThoai);


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


    private void getColorProduct(String url, int idDienThoai) {

        hinhanh = new ArrayList<>();
        color = new ArrayList<>();

        RequestQueue requestQueue = Volley.newRequestQueue(this);
        StringRequest stringRequest = new StringRequest(Request.Method.POST, url,
                response -> {
                    try {
                        JSONArray jsonArray = new JSONArray(response); // Chuyển đổi response thành một JSONArray

                        for(int i = 0; i < jsonArray.length(); i++) {
                            JSONObject jsonObject = jsonArray.getJSONObject(i);

                            // Lấy thông tin màu sản phẩm từ jsonObject
                            String colorLoadSv = jsonObject.getString("mausac");
                            String hinhanhLoadSv = jsonObject.getString("linkmausac");

                            color.add(colorLoadSv);
                            hinhanh.add(hinhanhLoadSv);

                        }

                        //Đổ dữ liệu hình ảnh vào layout
                        for (int i = 0; i < hinhanh.size(); i++) {
                            ImageView imageView = imageViewList.get(i);
                            Picasso.get().load(hinhanh.get(i)).into(imageView);
                            imageView.setVisibility(View.VISIBLE);
                        }
                        if(hinhanh.size() == 1) {
                            imageViewList.get(1).setVisibility(View.VISIBLE);
                        }
                        if(hinhanh.size() == 3) {
                            imageViewList.get(3).setVisibility(View.VISIBLE);
                        }
                        //Đổ dữ liệu màu sắc vào layout
                        for(int i = 0; i < color.size() ; i ++) {
                            TextView itemcolor = colorList.get(i);
                            itemcolor.setVisibility(View.VISIBLE);
                            itemcolor.setText(color.get(i));
                        }
                        // xét sự kiện khi ấn vào từng ảnh
                        for (int i = 0; i < hinhanh.size(); i++) {
                            final int finalI = i;
                            imageViewList.get(i).setOnClickListener(new View.OnClickListener() {
                                @Override
                                public void onClick(View view) {

                                    for(int j = 0; j < colorList.size(); j ++) {
                                        colorList.get(j).setTextColor(getResources().getColor(R.color.black));
                                    }
                                    colorList.get(finalI).setTextColor(getResources().getColor(R.color.blue));

                                    hinhanhChecked = hinhanh.get(finalI);
                                    colorChecked = color.get(finalI);

                                    isClickImg = true;

                                    Toast.makeText(InformationProductActivity.this, colorChecked, Toast.LENGTH_SHORT).show();

                                }
                            });
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
                params.put("id", String.valueOf(idDienThoai));
                return params;
            }
        };
        requestQueue.add(stringRequest);
    }
    private void getStogare(String url, int idDienThoai) {

        bonho = new ArrayList<>();

        RequestQueue requestQueue = Volley.newRequestQueue(this);
        StringRequest stringRequest = new StringRequest(Request.Method.POST, url,
                response -> {
                    try {
                        JSONArray jsonArray = new JSONArray(response); // Chuyển đổi response thành một JSONArray

                        for(int i = 0; i < jsonArray.length(); i++) {
                            JSONObject jsonObject = jsonArray.getJSONObject(i);

                            // Lấy thông tin màu sản phẩm từ jsonObject
                            String bonhoLoadSv = jsonObject.getString("bonho");

                            bonho.add(bonhoLoadSv);

                        }

                        //Đổ dữ liệu vào layout
                        for(int i = 0; i < bonho.size() ; i ++) {
                            TextView itembonho = bonhoList.get(i);
                            itembonho.setVisibility(View.VISIBLE);
                            itembonho.setText(bonho.get(i));
                        }

                        //Xét sự kiện khi ấn vào từng item bộ nhớ
                        for(TextView bonhoTV: bonhoList) {
                            bonhoTV.setOnClickListener(new View.OnClickListener() {
                                @Override
                                public void onClick(View view) {

                                    for(int j = 0; j < bonhoList.size(); j ++) {
                                        bonhoList.get(j).setTextColor(getResources().getColor(R.color.black));
                                    }
                                    bonhoTV.setTextColor(getResources().getColor(R.color.blue));

                                    bonhoChecked = bonhoTV.getText().toString();

                                    isClickBonho = true;

                                }
                            });
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
                params.put("id", String.valueOf(idDienThoai));
                return params;
            }
        };
        requestQueue.add(stringRequest);
    }


    //Xét sự kiện khi ấn vào nút mua ngay
    public void onBuy(View view) {

        //Kiểm tra ràng buộc
        if(!isClickImg) {
            Toast.makeText(this, "Bạn chưa chọn màu sắc điện thoại", Toast.LENGTH_SHORT).show();
        }
        else if(!isClickBonho) {
            Toast.makeText(this, "Bạn chưa chọn bộ nhớ điện thoại", Toast.LENGTH_SHORT).show();
        } else {
            Intent intent = new Intent(InformationProductActivity.this, BuyActivity.class);

            //Kiểm tra mua 1 đơn hàng
            intent.putExtra("checkBuy", 1);

            intent.putExtra("hinhanhChecked", hinhanhChecked);
            intent.putExtra("colorChecked",colorChecked);
            intent.putExtra("bonhoChecked",bonhoChecked);
            intent.putExtra("soluongmua",binding.soluongmua.getText().toString());
            intent.putExtra("dongia", phone.getGiaDienThoai() );
            intent.putExtra("tensanpham",phone.getTenDienThoai());
            intent.putExtra("idsanpham", idDienThoai);
            intent.putExtra("idnguoidat", idtaikhoan);

            startActivity(intent);
        }


    }
    //Xét sự kiện khi ấn vào nút thêm vào giỏ hàng
    public void onAddCart(View view) {
//        Toast.makeText(this, "Thêm vào giỏ hàng", Toast.LENGTH_SHORT).show();
        //Kiểm tra ràng buộc
        if(!isClickImg) {
            Toast.makeText(this, "Bạn chưa chọn màu sắc điện thoại", Toast.LENGTH_SHORT).show();
        }
        else if(!isClickBonho) {
            Toast.makeText(this, "Bạn chưa chọn bộ nhớ điện thoại", Toast.LENGTH_SHORT).show();
        } else {
            //Xử lý giá tiền
            int dongia = Integer.parseInt(phone.getGiaDienThoai().replaceAll("\\.", ""));
            int soluong = Integer.parseInt(binding.soluongmua.getText().toString());
            int tongtien = dongia * soluong;

            String tongtienFormat = chenDauCham(String.valueOf(tongtien));


            themVaoGioHang(
                    url_themvaogiohang,
                    idtaikhoan,
                    idDienThoai,
                    phone.getTenDienThoai(),
                    binding.soluongmua.getText().toString(),
                    colorChecked,
                    bonhoChecked,
                    phone.getGiaDienThoai(),
                    tongtienFormat,
                    hinhanhChecked
            );
        }


    }

    //Hàm thêm vào bảng giỏ hàng
    private void themVaoGioHang(
            String url,
            int idnguoidat,
            int idsanpham,
            String tensanpham,
            String soluong,
            String mausac,
            String bonho,
            String gia,
            String tongtien,
            String linkanh) {

        RequestQueue requestQueue = Volley.newRequestQueue(this);
        StringRequest stringRequest = new StringRequest(Request.Method.POST, url,
                response -> {
                            Toast.makeText(this, "Thêm vào giỏ hàng thành công", Toast.LENGTH_SHORT).show();
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
                params.put("ten",tensanpham);
                params.put("soluong",soluong);
                params.put("mausac",mausac);
                params.put("bonho",bonho);
                params.put("gia",gia);
                params.put("tongtien",tongtien);
                params.put("anh",linkanh);

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