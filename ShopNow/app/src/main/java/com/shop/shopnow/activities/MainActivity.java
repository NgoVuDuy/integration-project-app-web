package com.shop.shopnow.activities;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentStatePagerAdapter;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.SearchView;
import android.widget.Toast;

import com.shop.shopnow.R;
import com.shop.shopnow.adapters.ViewPagerAdapter;
import com.shop.shopnow.databinding.ActivityMainBinding;

import java.util.Objects;

public class MainActivity extends AppCompatActivity {

    ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // Ánh xạ view bằng binding
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        // Xét adapter cho viewpager và tablayout
        ViewPagerAdapter viewPagerAdapter = new ViewPagerAdapter(getSupportFragmentManager(), FragmentStatePagerAdapter.BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT);
        binding.viewPager.setAdapter(viewPagerAdapter);
        binding.tabLayout.setupWithViewPager(binding.viewPager);

        // Gán icon cho từng tab
        int[] icons = {
                R.drawable.round_home_24,
                R.drawable.round_view_list_24,
                R.drawable.round_person_24
        };
        for(int i = 0; i < icons.length; i ++) {
            Objects.requireNonNull(binding.tabLayout.getTabAt(i)).setIcon(icons[i]);
        }
//        SharedPreferences preferences = getSharedPreferences("MyPrefs", MODE_PRIVATE);
//        int idtaikhoan = preferences.getInt("idtaikhoan", -1);
//        Toast.makeText(this, String.valueOf(idtaikhoan), Toast.LENGTH_SHORT).show();

    }

    // Khởi tạo menu
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);

        MenuItem searchItem = menu.findItem(R.id.search_icon);
        SearchView searchView = (SearchView) searchItem.getActionView();

        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                // Xử lý khi người dùng gửi truy vấn (ví dụ: nhấn Enter trên bàn phím)
//                Toast.makeText(MainActivity.this, query, Toast.LENGTH_SHORT).show();

                Intent intent = new Intent(MainActivity.this, SearchActivity.class);
                intent.putExtra("tukhoatimkiem", query);
                startActivity(intent);

                return true;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                // Xử lý khi người dùng thay đổi văn bản trong ô tìm kiếm
//                Toast.makeText(MainActivity.this, newText, Toast.LENGTH_SHORT).show();
                return false;
            }
        });


        return super.onCreateOptionsMenu(menu);
    }

    // Xét sự kiện ấn vào menu
    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {

        if(item.getItemId() == R.id.introdution_item) {

            startActivity(new Intent(this, InformationActiviy.class));
        }
        if(item.getItemId() == R.id.news_item) {
            startActivity(new Intent(this, NewsActivity.class));
        }
        if (item.getItemId() == R.id.cart_icon) {
            startActivity(new Intent(this, CartActivity.class));

        }

        return super.onOptionsItemSelected(item);
    }
}