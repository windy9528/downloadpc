package com.yanggaofeng20190713.presenter;

import android.appwidget.AppWidgetProviderInfo;

import com.yanggaofeng20190713.api.ApiService;
import com.yanggaofeng20190713.base.BaseModel;
import com.yanggaofeng20190713.common.ImplView;

import io.reactivex.Observable;

/**
 * date:2019/7/13
 * name:windy
 * function:  登录的p层
 */
public class LoginPresenter extends BaseModel {

    public LoginPresenter(ImplView implView) {
        super(implView);
    }

    @Override
    protected Observable getModel(ApiService apiService, Object... args) {
        return apiService.login(String.valueOf(args[0]), String.valueOf(args[1]));
    }
}
