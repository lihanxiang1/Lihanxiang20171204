package com.bwie.lihanxiang20171204.model;

import android.util.Log;

import com.bwie.lihanxiang20171204.bean.UserBean;
import com.bwie.lihanxiang20171204.utils.Field;
import com.bwie.lihanxiang20171204.utils.HomeRetroFactory;

import rx.Observable;
import rx.Observer;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * Created by Lonely on 2017/12/4.
 */
public class HomeModel implements IHomeModel  {
    // 创建类用于保存数据 用于接口
    UserBean homeBean;
    private OnHomeFinish onHomeFinish;

    public HomeModel(OnHomeFinish onHomeFinish) {
        this.onHomeFinish = onHomeFinish;
    }

    // 创建接口 用于保存数据
    public interface OnHomeFinish {
        void onhomeFinish(UserBean homeBean);
    }

    @Override
    public void GetHomeData() {
        homeBean = new UserBean();
        Observable<UserBean> home = HomeRetroFactory.getInstance().getHome(Field.HOME_PATH_DATA);
        // 通过rxjava观察者模式 配置数据
        home.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<UserBean>() {
                    @Override
                    public void onCompleted() {
                        Log.d("home", "onCompleted: ");
                    }

                    @Override
                    public void onError(Throwable e) {
                        Log.d("home", "onError: " + "请求数据错误=======================");
                        e.printStackTrace();
                    }

                    @Override
                    public void onNext(UserBean data) {
                        Log.d("home", "onNext: " + data.getData().getAd1().get(0).getTitle() + "----");
                        homeBean = data;
                        onHomeFinish.onhomeFinish(homeBean);
                    }
                });
    }
}
