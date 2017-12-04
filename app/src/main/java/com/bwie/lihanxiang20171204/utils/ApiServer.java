package com.bwie.lihanxiang20171204.utils;


import com.bwie.lihanxiang20171204.bean.UserBean;

import retrofit2.http.GET;
import retrofit2.http.Url;
import rx.Observable;

/**
 * Created by Lonely on 2017/12/4.
 */
public interface ApiServer {
    @GET
    Observable<UserBean> getHome(@Url String url);
}
