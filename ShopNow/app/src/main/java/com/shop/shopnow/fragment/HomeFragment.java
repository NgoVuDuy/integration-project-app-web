package com.shop.shopnow.fragment;

import android.content.Context;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.Volley;
import com.shop.shopnow.adapters.GridViewAdapter;
import com.shop.shopnow.databinding.FragmentHomeBinding;
import com.shop.shopnow.models.Phone;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class HomeFragment extends Fragment {

    FragmentHomeBinding binding;
    GridViewAdapter gridViewAdapter;

    String url = "https://dpna.000webhostapp.com/api/product_information.php";

    int idDienThoai;
    String tenDienThoai;
    String giaDienThoai;
    String manHinh;
    String heDieuHanh;
    String camreraTruoc, camreraSau;
    String chip, ram, sim,pin, hang;
    String mauMacDinh, boNhoMacDinh;
    String src;
    List<Phone> listPhone;

    Context context;

    public HomeFragment() {
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
        binding = FragmentHomeBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();

        sanphamnoibat(url);
        sanphamdanggiamgia(url);

        return view;
    }

    public void sanphamnoibat(String url) {
        RequestQueue requestQueue = Volley.newRequestQueue(requireContext());
        JsonArrayRequest jsonArrayRequest = new JsonArrayRequest(Request.Method.GET, url, null,
                response -> {
                    try {
                        listPhone = new ArrayList<>();
                        for(int i = 0; i < 6; i ++) {
                            JSONObject jsonObject = response.getJSONObject(i);

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

                        GridLayoutManager gridLayoutManager = new GridLayoutManager(context, 2);
                        binding.rcvNoiBat.setLayoutManager(gridLayoutManager);
                        // Đoạn mã Java
                        gridViewAdapter = new GridViewAdapter(this.getContext());
                        gridViewAdapter.setData(listPhone);
                        binding.rcvNoiBat.setAdapter(gridViewAdapter);

                    } catch (JSONException e) {
                        throw new RuntimeException(e);
                    }
                },
                error -> {
                }
        );
        requestQueue.add(jsonArrayRequest);
    }

    public void sanphamdanggiamgia(String url) {
        RequestQueue requestQueue = Volley.newRequestQueue(requireContext());
        JsonArrayRequest jsonArrayRequest = new JsonArrayRequest(Request.Method.GET, url, null,
                response -> {
                    try {
                        listPhone = new ArrayList<>();
                        for(int i = 0; i < 6; i ++) {
                            JSONObject jsonObject = response.getJSONObject(i);

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
                        LinearLayoutManager layoutManager = new LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false);
//                        GridLayoutManager gridLayoutManager = new GridLayoutManager(requireContext(), 2);
                        binding.rcvSale.setLayoutManager(layoutManager);


                        gridViewAdapter = new GridViewAdapter(this.getContext());
                        gridViewAdapter.setData(listPhone);
                        binding.rcvSale.setAdapter(gridViewAdapter);

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