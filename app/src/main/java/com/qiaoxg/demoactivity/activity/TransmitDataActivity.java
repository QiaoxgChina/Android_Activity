package com.qiaoxg.demoactivity.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.qiaoxg.demoactivity.R;
import com.qiaoxg.demoactivity.entity.UserBean;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class TransmitDataActivity extends Activity {

    private static final String TAG = "TransmitDataActivity";

    public static final String TRANSMIT_DATA_TYPE_NORMAL = "NORMAL";
    public static final String TRANSMIT_DATA_TYPE_SERIALIZE = "SERIALIZE";//serialize

    @BindView(R.id.username_et)
    EditText usernameEt;
    @BindView(R.id.age_et)
    EditText ageEt;
    @BindView(R.id.normal_btn)
    Button normalBtn;
    @BindView(R.id.serialize_btn)
    Button serializeBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_transmit_data);
        ButterKnife.bind(this);
    }

    @OnClick({R.id.normal_btn, R.id.serialize_btn})
    public void onViewClicked(View view) {
        //获取用户输入的数据
        String userName = usernameEt.getText().toString();
        String ageString = ageEt.getText().toString();
        Intent i = new Intent(this, ShowDataActivity.class);
        switch (view.getId()) {
            case R.id.normal_btn:
                //将用户输入的数据放进intent中
                i.putExtra("USERNAME", userName);
                i.putExtra("AGE", ageString);
                i.putExtra("TYPE", TRANSMIT_DATA_TYPE_NORMAL);
                break;
            case R.id.serialize_btn:
                //想要直接传递一个对象，这个对象必须实现Serializable，即先将对象序列化；当然还有另外一种序列化对象的方法Parcelable，
                //两种方法相比较而言，serializable用起来比较简单，parcelable比较复杂
                //1）. 在内存的使用中,前者在性能方面要强于后者
                //2）. 后者在序列化操作的时候会产生大量的临时变量,(原因是使用了反射机制)从而导致GC的频繁调用,因此在性能上会稍微逊色
                //3）. Parcelable是以Ibinder作为信息载体的.在内存上的开销比较小,因此在内存之间进行数据传递的时候,Android推荐使用Parcelable,既然是内存方面比价有优势,那么自然就要优先选择.
                //4）. 在读写数据的时候,Parcelable是在内存中直接进行读写,而Serializable是通过使用IO流的形式将数据读写入在硬盘上.
                UserBean userBean = new UserBean();
                userBean.setAge(ageString);
                userBean.setUserName(userName);
                i.putExtra("USERBEAN", userBean);
                i.putExtra("TYPE", TRANSMIT_DATA_TYPE_SERIALIZE);
                break;
        }
        startActivity(i);
    }
}
