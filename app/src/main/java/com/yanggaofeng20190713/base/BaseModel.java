package com.yanggaofeng20190713.base;

import com.yanggaofeng20190713.api.ApiService;
import com.yanggaofeng20190713.common.ImplView;
import com.yanggaofeng20190713.entity.Result;
import com.yanggaofeng20190713.util.RetrofitUtil;

import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;

/**
 * date:2019/7/13
 * name:windy
 * function:  对p层的封装
 */
public abstract class BaseModel {

    private ImplView implView;

    public BaseModel(ImplView implView) {
        this.implView = implView;
    }

    public void requestData(Object... args) {

        ApiService apiService = RetrofitUtil.getInstance().create(ApiService.class);

        getModel(apiService, args)
                .subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Consumer<Result>() {
                    @Override
                    public void accept(Result result) throws Exception {
                        if ("0000".equals(result.getStatus())) {
                            implView.success(result);
                        } else {
                            implView.fail(result);
                        }
                    }
                }, new Consumer<Throwable>() {
                    @Override
                    public void accept(Throwable throwable) throws Exception {
                        throwable.printStackTrace();
                    }
                });
    }

    protected abstract Observable getModel(ApiService apiService, Object... args);

    /**
     * 销毁数据 避免内存泄露
     */
    public void unBind() {
        if (implView != null) {
            implView = null;
        }
    }
}
