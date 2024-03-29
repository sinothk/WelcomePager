//package com.sinothk.plugin.welcome.video.demo;
//
//import android.os.Bundle;
//import android.view.View;
//import android.widget.Button;
//import android.widget.ImageView;
//
//import androidx.appcompat.app.AppCompatActivity;
//import androidx.fragment.app.Fragment;
//import androidx.fragment.app.FragmentManager;
//import androidx.fragment.app.FragmentPagerAdapter;
//import androidx.viewpager.widget.ViewPager;
//
//import java.util.ArrayList;
//import java.util.List;
//
//public class MainActivity extends AppCompatActivity {
//
//    private ViewPager vp;
//    private ImageView iv1;
//    private ImageView iv2;
//    private ImageView iv3;
//    private Button bt_start;
//    private List<Fragment> fragments;
//
//    private void assignViews() {
//
//        vp = findViewById(R.id.vp);
//        iv1 = findViewById(R.id.iv1);
//        iv2 = findViewById(R.id.iv2);
//        iv3 = findViewById(R.id.iv3);
//        bt_start = findViewById(R.id.bt_start);
//    }
//
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_main);
//        assignViews();
//        initData();
//        initView();
//
//    }
//
//    /**
//     * 初始化数据,添加三个Fragment
//     */
//    private void initData() {
//        fragments = new ArrayList<>();
//
//        Fragment fragment1 = new Guild2Fragment();
//        Bundle bundle1 = new Bundle();
//        bundle1.putInt("index", 1);
//        fragment1.setArguments(bundle1);
//        fragments.add(fragment1);
//
//        Fragment fragment2 = new Guild2Fragment();
//        Bundle bundle2 = new Bundle();
//        bundle2.putInt("index", 2);
//        fragment2.setArguments(bundle2);
//        fragments.add(fragment2);
//
//        Fragment fragment3 = new Guild2Fragment();
//        Bundle bundle3 = new Bundle();
//        bundle3.putInt("index", 3);
//        fragment3.setArguments(bundle3);
//        fragments.add(fragment3);
//    }
//
//    /**
//     * 设置ViewPager的适配器和滑动监听
//     */
//    private void initView() {
//        vp.setOffscreenPageLimit(3);
//        vp.setAdapter(new MyPageAdapter(getSupportFragmentManager()));
//        vp.addOnPageChangeListener(new MyPageChangeListener());
//    }
//
//    /**
//     * ViewPager适配器
//     */
//    private class MyPageAdapter extends FragmentPagerAdapter {
//
//
//        public MyPageAdapter(FragmentManager fm) {
//            super(fm);
//        }
//
//        @Override
//        public Fragment getItem(int position) {
//            return fragments.get(position);
//        }
//
//        @Override
//        public int getCount() {
//            return fragments.size();
//        }
//    }
//
//    /**
//     * ViewPager滑动页面监听器
//     */
//    private class MyPageChangeListener implements ViewPager.OnPageChangeListener {
//        @Override
//        public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
//
//        }
//
//        /**
//         * 根据页面不同动态改变红点和在最后一页显示立即体验按钮
//         *
//         * @param position
//         */
//        @Override
//        public void onPageSelected(int position) {
//
//            bt_start.setVisibility(View.GONE);
//            iv1.setImageResource(R.mipmap.dot_normal);
//            iv2.setImageResource(R.mipmap.dot_normal);
//            iv3.setImageResource(R.mipmap.dot_normal);
//
//            if (position == 0) {
//                iv1.setImageResource(R.mipmap.dot_focus);
//            } else if (position == 1) {
//                iv2.setImageResource(R.mipmap.dot_focus);
//            } else {
//                iv3.setImageResource(R.mipmap.dot_focus);
//                bt_start.setVisibility(View.VISIBLE);
//            }
//        }
//
//        @Override
//        public void onPageScrollStateChanged(int state) {
//
//        }
//    }
//}
