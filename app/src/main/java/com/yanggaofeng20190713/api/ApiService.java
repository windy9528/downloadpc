package com.yanggaofeng20190713.api;

import com.yanggaofeng20190713.common.Constant;
import com.yanggaofeng20190713.entity.Result;
import com.yanggaofeng20190713.entity.UserInfo;

import io.reactivex.Observable;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

/**
 * date:2019/7/13
 * name:windy
 * function:  封装retrofit网络请求接口
 */
public interface ApiService {

    /**
     * 登录功能
     *
     * @param phone
     * @param pwd
     * @return
     */
    @FormUrlEncoded
    @POST(Constant.LOGIN_URL)
    Observable<Result<UserInfo>> login(@Field("phone") String phone,
                                       @Field("pwd") String pwd);


}
