package com.qiaoxg.demoactivity.activity;

import android.content.res.Configuration;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.qiaoxg.demoactivity.R;
import com.qiaoxg.demoactivity.adapter.OrientationAdapter;
import com.qiaoxg.demoactivity.entity.UserBean;

import java.util.ArrayList;
import java.util.List;

public class OrientationActivity extends AppCompatActivity {

    private static final String TAG = "OrientationActivity";

    private OrientationAdapter mOrientationAdapter;
    private RecyclerView mPortraitRv, mLandscapeRv;
    private int mOrientation;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mOrientation = this.getResources().getConfiguration().orientation; // 获取屏幕方向

        //为横屏和竖屏分别绘制两种view
        if (mOrientation == Configuration.ORIENTATION_LANDSCAPE) {
            setContentView(R.layout.activity_orientation_landscape);
        } else if (mOrientation == Configuration.ORIENTATION_PORTRAIT) {
            setContentView(R.layout.activity_orientation_portrait);
        }
        initData();
        initAdapter();
    }

    private void initAdapter() {
        mOrientationAdapter = new OrientationAdapter(initData());
        if (mOrientation == Configuration.ORIENTATION_LANDSCAPE) {
            mLandscapeRv = (RecyclerView) findViewById(R.id.landscape_rv);
            mLandscapeRv.setLayoutManager(new GridLayoutManager(this, 2));
            mLandscapeRv.setAdapter(mOrientationAdapter);
        } else if (mOrientation == Configuration.ORIENTATION_PORTRAIT) {
            mPortraitRv = (RecyclerView) findViewById(R.id.portrait_rv);
            mPortraitRv.setLayoutManager(new LinearLayoutManager(this));
            mPortraitRv.setAdapter(mOrientationAdapter);
        }
    }

    private List<UserBean> initData() {
        List<UserBean> beans = new ArrayList<>();
        for (int i = 0; i < 40; i++) {
            UserBean bean = new UserBean();
            bean.setUserName("USERNAME" + i);
            int headerId = R.drawable.header_01;
            if (i % 4 == 1) {
                headerId = R.drawable.header_02;
            } else if (i % 4 == 2) {
                headerId = R.drawable.header_03;
            } else if (i % 4 == 3) {
                headerId = R.drawable.header_04;
            }
            bean.setHeader(headerId);
            bean.setPhone("10086 + " + i);
            beans.add(bean);
        }
        return beans;
    }

}
