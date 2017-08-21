package com.qiaoxg.demoactivity.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import com.qiaoxg.demoactivity.R;
import com.qiaoxg.demoactivity.entity.UserBean;

import butterknife.BindView;
import butterknife.ButterKnife;

import static com.qiaoxg.demoactivity.activity.TransmitDataActivity.TRANSMIT_DATA_TYPE_NORMAL;

public class ShowDataActivity extends Activity {

    @BindView(R.id.dataType_tv)
    TextView dataTypeTv;
    @BindView(R.id.userName_tv)
    TextView userNameTv;
    @BindView(R.id.age_tv)
    TextView ageTv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_data);
        ButterKnife.bind(this);
        initData();
    }

    private void initData() {
        Intent i = getIntent();
        if (i.getStringExtra("TYPE").equals(TRANSMIT_DATA_TYPE_NORMAL)) {
            dataTypeTv.setText("传递方式 : 简单数据");
            userNameTv.setText("UserName : " + i.getStringExtra("USERNAME"));
            ageTv.setText("   Age   : " + i.getStringExtra("AGE"));
        } else {
            UserBean bean = (UserBean) i.getSerializableExtra("USERBEAN");
            dataTypeTv.setText("传递方式 : Serializable");
            userNameTv.setText("UserName : " + bean.getUserName());
            ageTv.setText("   Age   : " + bean.getAge());
        }
    }
}
