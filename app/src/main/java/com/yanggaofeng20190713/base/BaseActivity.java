package com.yanggaofeng20190713.base;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.Toast;

import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * date:2019/7/13
 * name:windy
 * function:
 */
public abstract class BaseActivity extends AppCompatActivity {

    private Unbinder bind;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(setLayoutId());

        bind = ButterKnife.bind(this);
        initView();

        initData();
    }

    /**
     * 初始化数据
     */
    protected abstract void initData();

    /**
     * 初始化控件
     */
    protected abstract void initView();

    /**
     * 加载布局
     *
     * @return
     */
    protected abstract int setLayoutId();

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (bind != null) {
            bind.unbind();
        }
        bind = null;
        destoryData();
        System.gc();  //通知gc回收
    }

    /**
     * 销毁数据
     */
    protected abstract void destoryData();

    /**
     * 封装toast方法
     *
     * @param msg
     */
    public void showToast(String msg) {
        Toast.makeText(this, msg, Toast.LENGTH_SHORT).show();
    }

    /**
     * 封装无参跳转
     *
     * @param clz
     */
    public void startActivity(Class clz) {
        startActivity(new Intent(this, clz));
    }

    public void isFullenScreen(boolean flag){
        if(flag){ //如果为true  ，则设置全屏


        }
    }
}
