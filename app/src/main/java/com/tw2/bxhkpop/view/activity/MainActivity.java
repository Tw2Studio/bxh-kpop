package com.tw2.bxhkpop.view.activity;

import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.Signature;
import android.os.Build;
import android.support.v4.app.FragmentManager;
import android.support.v4.content.ContextCompat;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.tw2.bxhkpop.R;
import com.tw2.bxhkpop.adapter.HomeAdapter;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private ViewPager viewPager;
    private HomeAdapter adapter;
    private LinearLayout nvgHome, nvgKetQua, nvgBXH, nvgProfile;
    private TextView tvToolbar;
    private ImageView imageView1, imageView2, imageView3, imageView4;
    private List<ImageView> imageViewList = new ArrayList<>();
    private List<Integer> listOne = new ArrayList<>();
    private List<Integer> listTwo = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            getWindow().setStatusBarColor(ContextCompat.getColor(getApplicationContext(), R.color.colorPrimaryDark));
        }

        initList();
        initView();
        initPager();
    }

    private void initList() {
        listOne.add(R.drawable.ic_home);
        listOne.add(R.drawable.ic_bxh);
        listOne.add(R.drawable.ic_video);
        listOne.add(R.drawable.ic_profile);


        listTwo.add(R.drawable.ic_home);
        listTwo.add(R.drawable.ic_bxh);
        listTwo.add(R.drawable.ic_video);
        listTwo.add(R.drawable.ic_profile);
    }

    private void initPager() {
        FragmentManager manager = getSupportFragmentManager();
        adapter = new HomeAdapter(manager);
        viewPager.setAdapter(adapter);
        setBGTab(0);

        viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            public void onPageScrollStateChanged(int state) {
            }

            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
            }

            public void onPageSelected(int position) {
                switch (position) {
                    case 0:
                        tvToolbar.setText("MY KPOP");
                        setBGTab(0);
                        break;
                    case 1:
                        tvToolbar.setText("BẢNG XẾP HẠNG");
                        setBGTab(1);
                        break;
                    case 2:
                        tvToolbar.setText("VIDEO");
                        setBGTab(2);
                        break;
                    case 3:
                        tvToolbar.setText("TÀI KHOẢN");
                        setBGTab(3);
                        break;


                }
            }
        });
    }

    private void initView() {
        viewPager = (ViewPager) findViewById(R.id.main_viewpager);
        nvgHome = (LinearLayout) findViewById(R.id.navigation_home);
        nvgKetQua = (LinearLayout) findViewById(R.id.navigation_ketqua);
        nvgBXH = (LinearLayout) findViewById(R.id.navigation_bxh);
        nvgProfile = (LinearLayout) findViewById(R.id.navigation_profile);
        tvToolbar = (TextView) findViewById(R.id.tv_toolbar);

        imageView1 = (ImageView) findViewById(R.id.img_home);
        imageView2 = (ImageView) findViewById(R.id.img_ketqua);
        imageView3 = (ImageView) findViewById(R.id.img_bxh);
        imageView4 = (ImageView) findViewById(R.id.img_profile);

        imageViewList.add(imageView1);
        imageViewList.add(imageView2);
        imageViewList.add(imageView3);
        imageViewList.add(imageView4);

        nvgHome.setOnClickListener(this);
        nvgKetQua.setOnClickListener(this);
        nvgBXH.setOnClickListener(this);
        nvgProfile.setOnClickListener(this);
    }


    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.navigation_home:
                tvToolbar.setText("AFF SUZUKI CUP");
                setBGTab(0);
                viewPager.setCurrentItem(0);
                break;
            case R.id.navigation_ketqua:
                tvToolbar.setText("KẾT QUẢ");
                setBGTab(1);
                viewPager.setCurrentItem(1);
                break;
            case R.id.navigation_bxh:
                tvToolbar.setText("BẢNG XẾP HẠNG");
                setBGTab(2);
                viewPager.setCurrentItem(2);
                break;
            case R.id.navigation_profile:
                tvToolbar.setText("TÀI KHOẢN");
                setBGTab(3);
                viewPager.setCurrentItem(3);
                break;


        }
    }

    public void setBGTab(int position) {
        for (int i = 0; i < imageViewList.size(); i++) {
            if (position == i) {
                imageViewList.get(i).setImageResource(listTwo.get(i));
            } else {
                imageViewList.get(i).setImageResource(listOne.get(i));
            }
        }

    }
}
