package com.qiaoxg.demoactivity.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.util.Log;
import android.widget.Button;
import android.widget.TextView;

import com.qiaoxg.demoactivity.R;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class StartForResultActivity extends AppCompatActivity {

    private static final String TAG = "StartForResultActivity";

    private int mRequestCode = 0;

    @BindView(R.id.userName_tv)
    TextView userNameTv;
    @BindView(R.id.phone_tv)
    TextView phoneTv;
    @BindView(R.id.gotoInput_btn)
    Button gotoInputBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start_for_result);
        ButterKnife.bind(this);
    }

    @OnClick(R.id.gotoInput_btn)
    public void onViewClicked() {
        Intent i = new Intent(this, InputUserInfoActivity.class);
        startActivityForResult(i, mRequestCode);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        Log.e(TAG, "onActivityResult: requestCode is " + requestCode + " and resultCode is " + resultCode);
        if (data == null) {
            Log.e(TAG, "onActivityResult: intent is null");
            return;
        }
        if (requestCode == mRequestCode) {
            String inputUserName = data.getStringExtra("USERNAME");
            if (!TextUtils.isEmpty(inputUserName)) {
                userNameTv.setText(inputUserName);
            }

            String inputPhone = data.getStringExtra("PHONE");
            if (!TextUtils.isEmpty(inputPhone)) {
                phoneTv.setText(inputPhone);
            }
        }
    }
}
