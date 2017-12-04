package com.bwie.lihanxiang20171204;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.bwie.lihanxiang20171204.adapter.MyHomeXrAdapter;
import com.bwie.lihanxiang20171204.bean.UserBean;
import com.bwie.lihanxiang20171204.presenter.Ipresenter;
import com.bwie.lihanxiang20171204.view.IHomeView;

import butterknife.Bind;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity implements IHomeView {

    @Bind(R.id.main_recycle_view)
    RecyclerView mainRecycleView;

    Ipresenter ipresenter;

    MyHomeXrAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        ipresenter = new Ipresenter(this);

        ipresenter.getData();

        mainRecycleView.setLayoutManager(new LinearLayoutManager(MainActivity.this));
    }
    @Override
    public void ShowHomeData(UserBean homeBean) {
        mainRecycleView.setAdapter(adapter = new MyHomeXrAdapter(homeBean, MainActivity.this));

        // 上拉刷新和下拉刷新的监听事件
//        mainRecycleView.setPullRefreshEnabled(true);
//        mainRecycleView.setLoadingMoreEnabled(true);
//        mainRecycleView.setLoadingListener(new XRecyclerView.LoadingListener() {
//            @Override
//            public void onRefresh() {
//                // 下拉刷新
//                homeXrecyclerview.refreshComplete();
//            }
//
//            @Override
//            public void onLoadMore() {
//                // 上拉加载
//                homeXrecyclerview.loadMoreComplete();
//            }
//        });
    }

//    @Override
//    public void getData(List<Ad1Bean> ad1Been) {
//        System.out.println("newslistBean = " + ad1Been.get(1).getTitle());
//        LinearLayoutManager manager = new LinearLayoutManager(MainActivity.this,LinearLayoutManager.VERTICAL,false);
//        mainRecycleView.setLayoutManager(manager);
//        MyAdapter myAdapter = new MyAdapter(MainActivity.this, ad1Been);
//        mainRecycleView.setAdapter(myAdapter);
//    }
}
