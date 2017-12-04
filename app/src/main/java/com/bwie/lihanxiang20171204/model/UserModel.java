package com.bwie.lihanxiang20171204.model;


import com.bwie.lihanxiang20171204.bean.Ad1Bean;
import com.bwie.lihanxiang20171204.bean.UserBean;
import com.bwie.lihanxiang20171204.interfaces.IInterface;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by Lonely on 2017/12/4.
 */
public class UserModel implements Imodel {
    private onFinish onfinish;

    public UserModel(UserModel.onFinish onfinish) {
        this.onfinish = onfinish;
    }

    @Override
    public void suibian(String url) {
        Retrofit retrofit = new Retrofit.Builder()
                .addConverterFactory(GsonConverterFactory.create())
                .baseUrl(url)
                .build();
        IInterface iInterface = retrofit.create(IInterface.class);
        Call<UserBean> userBeanCall = iInterface.get();
        userBeanCall.enqueue(new Callback<UserBean>() {
            @Override
            public void onResponse(Call<UserBean> call, Response<UserBean> response) {
//                List<Ad1Bean> newslist = response.body().getData().getAd1();
//                onfinish.setonsuibian(newslist);
            }

            @Override
            public void onFailure(Call<UserBean> call, Throwable t) {

            }
        });
    }

    public interface onFinish{
        void setonsuibian(List<Ad1Bean> list);
    }
}
