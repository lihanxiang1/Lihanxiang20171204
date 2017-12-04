package com.bwie.lihanxiang20171204.interfaces;

import com.bwie.lihanxiang20171204.bean.UserBean;

import retrofit2.Call;
import retrofit2.http.GET;

/**
 * Created by Lonely on 2017/12/4.
 */
public interface IInterface {
    @GET("umIPmfS6c83237d9c70c7c9510c9b0f97171a308d13b611?uri=homepage")
    Call<UserBean> get();
}
