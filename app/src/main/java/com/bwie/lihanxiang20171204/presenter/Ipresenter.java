package com.bwie.lihanxiang20171204.presenter;

import com.bwie.lihanxiang20171204.bean.UserBean;
import com.bwie.lihanxiang20171204.model.HomeModel;
import com.bwie.lihanxiang20171204.view.IHomeView;

/**
 * Created by Lonely on 2017/12/4.
 */
public class Ipresenter implements HomeModel.OnHomeFinish {
    private final IHomeView homeView;
    private final HomeModel homeModel;

    public Ipresenter(IHomeView homeView) {
        this.homeView = homeView;
        homeModel = new HomeModel(this);
    }

    // 调用model请求数据的方法
    public void getData(){
        homeModel.GetHomeData();
    }

    @Override
    public void onhomeFinish(UserBean homeBean) {
        homeView.ShowHomeData(homeBean);
    }
}
