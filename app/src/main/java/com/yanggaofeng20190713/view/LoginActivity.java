package com.yanggaofeng20190713.view;

import android.Manifest;
import android.text.TextUtils;
import android.text.method.HideReturnsTransformationMethod;
import android.text.method.PasswordTransformationMethod;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

import com.blankj.utilcode.util.RegexUtils;
import com.blankj.utilcode.util.SPUtils;
import com.yanggaofeng20190713.R;
import com.yanggaofeng20190713.base.BaseActivity;
import com.yanggaofeng20190713.common.ImplView;
import com.yanggaofeng20190713.entity.Result;
import com.yanggaofeng20190713.entity.UserInfo;
import com.yanggaofeng20190713.presenter.LoginPresenter;

import butterknife.BindView;
import butterknife.OnClick;

public class LoginActivity extends BaseActivity implements ImplView<UserInfo> {

    @BindView(R.id.ed_phone)
    EditText edPhone;
    @BindView(R.id.ed_pwd)
    EditText edPwd;
    @BindView(R.id.iv_eye)
    ImageView ivEye;
    @BindView(R.id.btn_login)
    Button btnLogin;
    boolean flag = true;  // 密码是否可见标识符 默认为真
    private LoginPresenter loginPresenter;

    @Override
    protected void initData() {

    }

    @Override
    protected void initView() {
        loginPresenter = new LoginPresenter(this);
    }

    /**
     * butterKnife 绑定点击事件
     *
     * @param view
     */
    @OnClick({R.id.btn_login, R.id.iv_eye})
    public void clickListener(View view) {
        switch (view.getId()) {
            case R.id.iv_eye:
                changePwdStatus();
                break;
            case R.id.btn_login:
                login();
                break;
        }
    }

    /**
     * 用户登录操作
     */
    private void login() {
        String phone = edPhone.getText().toString().trim();
        String pwd = edPwd.getText().toString().trim();
        if (TextUtils.isEmpty(phone) || TextUtils.isEmpty(pwd)) {
            showToast("手机号或密码不能为空哟，亲！");
        } else if (!RegexUtils.isMobileExact(phone)) { //正则校验手机号
            showToast("您输入的手机号有误，请重新输入!");
        } else {
            loginPresenter.requestData(phone, pwd);
        }
    }

    /**
     * 实现改变 密码状态(是否可见)
     */
    private void changePwdStatus() {
        if (flag) { //当flag为true  显示对用户可见
            //设置EditText的密码为可见的
            edPwd.setTransformationMethod(HideReturnsTransformationMethod.getInstance());
            flag = false;  //标识符 改变
        } else {
            //设置密码为隐藏的
            edPwd.setTransformationMethod(PasswordTransformationMethod.getInstance());
            flag = true;
        }
    }

    @Override
    protected int setLayoutId() {
        return R.layout.activity_login;
    }

    /**
     * 销毁数据
     */
    @Override
    protected void destoryData() {
        if (loginPresenter != null) {
            loginPresenter.unBind();
            loginPresenter = null;
        }
    }

    /**
     * 登录接口 成功的回调
     *
     * @param result
     */
    @Override
    public void success(Result result) {
        UserInfo userInfo = (UserInfo) result.getResult();
        //存储 用户手机号
        SPUtils.getInstance().put("mobliePhone", userInfo.getPhone());
        //存储用户头像
        SPUtils.getInstance().put("loadUrl", userInfo.getHeadPic());
        //跳转到下载页面
        startActivity(MainActivity.class);
        finish();
    }

    /**
     * 登录接口 失败的回调
     *
     * @param result
     */
    @Override
    public void fail(Result result) {
        showToast(result.getMessage());
    }
}
