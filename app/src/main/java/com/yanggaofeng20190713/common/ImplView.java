package com.yanggaofeng20190713.common;

import com.yanggaofeng20190713.entity.Result;

/**
 * date:2019/7/13
 * name:windy
 * function:
 */
public interface ImplView<T> {

    void success(Result result);

    void fail(Result result);
}
