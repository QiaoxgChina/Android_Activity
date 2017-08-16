package com.qiaoxg.demoactivity.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import com.qiaoxg.demoactivity.R;

/**
 * 介绍Activity在不同情况下的生命周期:（方法的编号见方法里边的log）
 * 1、进入此activity时，依次执行：1、2、3, 此时activity处于活动状态
 * 2、退出此activity时，依次执行：4、5、6
 * 3、启动此activity之后，按home键返回桌面，依次执行：4、5
 * 4、在桌面点击应用重新进入，依次执行：7、2、3
 * 5、在活动状态，点击此activity中的按钮进入另一个activity，依稀执行：4、5
 * 6、从另一个activity中返回到本activity中，依次执行：7、2、3
 */
public class LifeCircleActivity extends Activity {

    private static final String TAG = "LifeCircleActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Log.e(TAG, "==========onCreate: 1111111111111111=============");

        //首次创建 Activity 时调用。
        // 您应该在此方法中执行所有正常的静态设置 — 创建视图、将数据绑定到列表等等。
        // 系统向此方法传递一个 Bundle 对象，其中包含 Activity 的上一状态，不过前提是捕获了该状态（请参阅后文的保存 Activity 状态）。
        //始终后接 onStart()。

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_life_circle);

        findViewById(R.id.goto_btn).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(LifeCircleActivity.this, OtherActivity.class);
                startActivity(i);
            }
        });
    }

    @Override
    protected void onStart() {
        Log.e(TAG, "==========onStart: 222222222222222222=============");
        //在 Activity 即将对用户可见之前调用。
        //如果 Activity 转入前台，则后接 onResume()，如果 Activity 转入隐藏状态，则后接 onStop()。
        super.onStart();
    }

    @Override
    protected void onResume() {
        Log.e(TAG, "============onResume: 33333333333333=============");
        //在 Activity 即将开始与用户进行交互之前调用。
        // 此时，Activity 处于 Activity 堆栈的顶层，并具有用户输入焦点。
        //始终后接 onPause()。
        super.onResume();
    }

    @Override
    protected void onRestart() {
        Log.e(TAG, "==========onRestart: 77777777777777===========");
        //在 Activity 已停止并即将再次启动前调用。
        //始终后接 onStart()
        super.onRestart();
    }

    @Override
    protected void onPause() {
        Log.e(TAG, "==========onPause: 444444444444444================");
        //当系统即将开始继续另一个 Activity 时调用。
        // 此方法通常用于确认对持久性数据的未保存更改、停止动画以及其他可能消耗 CPU 的内容，诸如此类。
        // 它应该非常迅速地执行所需操作，因为它返回后，下一个 Activity 才能继续执行。
        // 如果 Activity 返回前台，则后接 onResume()，如果 Activity 转入对用户不可见状态，则后接 onStop()。
        super.onPause();
    }

    @Override
    protected void onStop() {
        Log.e(TAG, "==============onStop: 5555555555555555================");
        //在 Activity 对用户不再可见时调用。
        // 如果 Activity 被销毁，或另一个 Activity（一个现有 Activity 或新 Activity）继续执行并将其覆盖，就可能发生这种情况。
        //如果 Activity 恢复与用户的交互，则后接 onRestart()，如果 Activity 被销毁，则后接 onDestroy()。
        super.onStop();
    }

    @Override
    protected void onDestroy() {
        Log.e(TAG, "==============onDestroy: 6666666666666666==============");
        //在 Activity 被销毁前调用。
        // 这是 Activity 将收到的最后调用。
        // 当 Activity 结束（有人对 Activity 调用了 finish()），或系统为节省空间而暂时销毁该 Activity 实例时，可能会调用它。
        // 您可以通过 isFinishing() 方法区分这两种情形。
        super.onDestroy();
    }
}
