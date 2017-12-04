package com.bwie.lihanxiang20171204.adapter;

import android.content.Context;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;

import com.bwie.lihanxiang20171204.R;
import com.bwie.lihanxiang20171204.bean.Ad1Bean;

import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by Lonely on 2017/12/4.
 */
public class MyAdapter extends RecyclerView.Adapter<MyAdapter.IViewHolder> {
    Context context;
    List<Ad1Bean> list;

    public MyAdapter(Context context, List<Ad1Bean> list) {
        this.context = context;
        this.list = list;
    }

    @Override
    public MyAdapter.IViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = View.inflate(context, R.layout.item, null);
        return new IViewHolder(view);
    }

    @Override
    public void onBindViewHolder(MyAdapter.IViewHolder holder, final int position) {
//         holder.viewPager.setImageURI(list.get(position).getPicUrl());

    }

    @Override
    public int getItemCount() {
        return list == null ? 0 : list.size();
    }


    static class IViewHolder extends RecyclerView.ViewHolder {
        @Bind(R.id.viewPager)
        ViewPager viewPager;

        IViewHolder(View view) {
            super(view);
            ButterKnife.bind(this, view);
        }
    }
}
