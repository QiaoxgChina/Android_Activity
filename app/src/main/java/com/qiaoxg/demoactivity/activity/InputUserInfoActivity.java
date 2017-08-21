package com.qiaoxg.demoactivity.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Button;
import android.widget.EditText;

import com.qiaoxg.demoactivity.R;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class InputUserInfoActivity extends AppCompatActivity {

    private int mResultCode = 1;

    @BindView(R.id.username_et)
    EditText usernameEt;
    @BindView(R.id.age_et)
    EditText ageEt;
    @BindView(R.id.ok_btn)
    Button okBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_input_user_info);
        ButterKnife.bind(this);
    }

    @OnClick(R.id.ok_btn)
    public void onViewClicked() {
        String userName = usernameEt.getText().toString();
        String phone = ageEt.getText().toString();
        Intent i = new Intent();
        i.putExtra("USERNAME", userName);
        i.putExtra("PHONE", phone);
        setResult(mResultCode, i);
        this.finish();
    }
}
