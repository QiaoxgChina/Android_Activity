package com.qiaoxg.demoactivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.qiaoxg.demoactivity.activity.LifeCircleActivity;
import com.qiaoxg.demoactivity.activity.StartForResultActivity;
import com.qiaoxg.demoactivity.activity.TransmitDataActivity;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends Activity {

    private static final String TAG = "MainActivity";
    @BindView(R.id.lifeCircle_btn)
    Button lifeCircleBtn;
    @BindView(R.id.startForResult_btn)
    Button startForResultBtn;
    @BindView(R.id.orientationChange_btn)
    Button orientationChangeBtn;
    @BindView(R.id.transmitData_btn)
    Button transmitDataBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
    }

    @OnClick({R.id.lifeCircle_btn, R.id.startForResult_btn, R.id.orientationChange_btn, R.id.transmitData_btn})
    public void onViewClicked(View view) {
        Intent i = new Intent();
        switch (view.getId()) {
            case R.id.lifeCircle_btn:
                i.setClass(this, LifeCircleActivity.class);
                break;
            case R.id.startForResult_btn:
                i.setClass(this, StartForResultActivity.class);
                break;
            case R.id.orientationChange_btn:
                break;
            case R.id.transmitData_btn:
                i.setClass(this, TransmitDataActivity.class);
                break;
        }
        startActivity(i);
    }
}
