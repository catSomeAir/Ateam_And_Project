package com.example.last_project.main.tab.home;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.viewpager2.adapter.FragmentStateAdapter;

import com.example.last_project.main.tab.Main_Tab_HomeFragment;
import com.example.last_project.main.tab.Main_Tab_MyManaulFragment;

public class HomeFragmentAdapter extends FragmentStateAdapter {
    public int count;

    public HomeFragmentAdapter(@NonNull Fragment fragment, int count) {
        super(fragment);
        this.count = count;
    }

    @NonNull
    @Override
    public Fragment createFragment(int position) {
        int index = getRealPosition(position);

        if (index == 0){
            return new Home_BannerFragment1();
        } else if (index == 1) {
            return new Home_BannerFragment2();
        }else {
            return new Home_BannerFragment3();
        }
    }

    @Override
    public int getItemCount() {
        return 2000;
    }

    public int getRealPosition(int position) {
        return position % count;
    }
}
