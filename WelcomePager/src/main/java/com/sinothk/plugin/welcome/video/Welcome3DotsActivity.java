package com.sinothk.plugin.welcome.video;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager.widget.ViewPager;

import com.sinothk.plugin.welcome.R;

import java.util.List;

public abstract class Welcome3DotsActivity extends AppCompatActivity {

    private ViewPager vp;
    private ImageView iv1;
    private ImageView iv2;
    private ImageView iv3;
    private Button startBtn;
    private List<Fragment> fragments;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome_dot1);

        vp = findViewById(R.id.vp);
        iv1 = findViewById(R.id.iv1);
        iv2 = findViewById(R.id.iv2);
        iv3 = findViewById(R.id.iv3);
        startBtn = findViewById(R.id.startBtn);

        // 数据
        fragments = initWelcomeData();
        initView();

    }

    protected abstract List<Fragment> initWelcomeData();

//    /**
//     * 初始化数据,添加三个Fragment
//     */
//    private List<Fragment> initData() {
//        List<Fragment> fs = new ArrayList<>();
//        fs.add(GuildVideoFragment.getInstance(R.raw.guide_1));
//        fs.add(GuildVideoFragment.getInstance(R.raw.guide_2));
//        fs.add(GuildVideoFragment.getInstance(R.raw.guide_3));
//        return fs;
//    }

    /**
     * 设置ViewPager的适配器和滑动监听
     */
    private void initView() {
        vp.setOffscreenPageLimit(3);
        vp.setAdapter(new MyPageAdapter(getSupportFragmentManager()));
        vp.addOnPageChangeListener(new MyPageChangeListener());
    }

    /**
     * ViewPager适配器
     */
    private class MyPageAdapter extends FragmentPagerAdapter {


        public MyPageAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            return fragments.get(position);
        }

        @Override
        public int getCount() {
            return fragments.size();
        }
    }

    /**
     * ViewPager滑动页面监听器
     */
    private class MyPageChangeListener implements ViewPager.OnPageChangeListener {
        @Override
        public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
        }

        @Override
        public void onPageScrollStateChanged(int state) {
        }

        /**
         * 根据页面不同动态改变红点和在最后一页显示立即体验按钮
         *
         * @param position
         */
        @Override
        public void onPageSelected(int position) {

            startBtn.setVisibility(View.GONE);
            iv1.setImageResource(R.mipmap.dot_normal);
            iv2.setImageResource(R.mipmap.dot_normal);
            iv3.setImageResource(R.mipmap.dot_normal);

            if (position == 0) {
                iv1.setImageResource(R.mipmap.dot_focus);
            } else if (position == 1) {
                iv2.setImageResource(R.mipmap.dot_focus);
            } else {
                iv3.setImageResource(R.mipmap.dot_focus);
                startBtn.setVisibility(View.VISIBLE);
                startBtn.setOnClickListener(getStartBtnClickListener());
            }
        }
    }

    protected abstract View.OnClickListener getStartBtnClickListener();
}
