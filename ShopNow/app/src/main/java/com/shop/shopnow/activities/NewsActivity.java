package com.shop.shopnow.activities;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import com.shop.shopnow.R;
import com.shop.shopnow.adapters.GridViewAdapter;
import com.shop.shopnow.adapters.NewsAdapter;
import com.shop.shopnow.databinding.ActivityNewsBinding;
import com.shop.shopnow.models.News;

import java.util.ArrayList;
import java.util.List;

public class NewsActivity extends AppCompatActivity {

    ActivityNewsBinding binding;
    NewsAdapter newsAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityNewsBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        GridLayoutManager gridLayoutManager = new GridLayoutManager(this, 1);
        binding.rcvTinTuc.setLayoutManager(gridLayoutManager);

        newsAdapter = new NewsAdapter(this);
        newsAdapter.setData(allTinTuc());
        binding.rcvTinTuc.setAdapter(newsAdapter);
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

    public List<News> allTinTuc() {

        List<News> listNew = new ArrayList<>();
        listNew.add(new News(1,R.drawable.tintuc11, "Ra mắt Realme 12+ thiết kế cực sang...",getResources().getString(R.string.noidung1), "Ra mắt Realme 12+ thiết kế cực sang, giá chưa tới 7 triệu đồng"));
        listNew.add(new News(2,R.drawable.tintuc22, "Những tính năng trên Xiaomi 14 Ultra...",getResources().getString(R.string.noidung2), "Những tính năng trên Xiaomi 14 Ultra khiến iPhone xấu hổ"));
        listNew.add(new News(3,R.drawable.tintuc33, "Không cần điện thoại Samsung cũng...",getResources().getString(R.string.noidung3), "Không cần điện thoại Samsung cũng có thể truy cập Galaxy AI"));
        listNew.add(new News(4,R.drawable.tintuc44, "Phát hiện bất ngờ thú vị khi người dùng...",getResources().getString(R.string.noidung4), "Phát hiện bất ngờ thú vị khi người dùng Android chuyển sang iPhone"));
        listNew.add(new News(5,R.drawable.tintuc55, "Rò rỉ lớn về chip xử lý trên loạt iPhone...",getResources().getString(R.string.noidung5), "Rò rỉ lớn về chip xử lý trên loạt iPhone và iPad sắp ra mắt"));
        listNew.add(new News(6,R.drawable.tintuc66, "OnePlus 12R Genshin Impact ra mắt ...",getResources().getString(R.string.noidung6), "OnePlus 12R Genshin Impact ra mắt với màu tím nổi bật, hấp dẫn mọi game thủ"));
        return listNew;


    }
}