package com.shop.shopnow.adapters;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;

import com.shop.shopnow.fragment.HomeFragment;
import com.shop.shopnow.fragment.PersonFragment;
import com.shop.shopnow.fragment.ProductsFragment;

public class ViewPagerAdapter extends FragmentStatePagerAdapter {

    public ViewPagerAdapter(@NonNull FragmentManager fm, int behavior) {
        super(fm, behavior);
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {

        switch (position) {
            case 0: return new HomeFragment();
            case 1: return new ProductsFragment();
            case 2: return new PersonFragment();
        }
        return new HomeFragment();
    }

    @Override
    public int getCount() {
        return 3;
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {

        switch (position) {
            case 0: return "Trang chủ";
            case 1: return "Sản phẩm";
            case 2: return "Cá nhân";
        }

        return "Trang chủ";
    }
}
