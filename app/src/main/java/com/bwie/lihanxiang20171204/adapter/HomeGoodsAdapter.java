package com.bwie.lihanxiang20171204.adapter;

import android.content.Context;
import android.net.Uri;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.bwie.lihanxiang20171204.R;
import com.bwie.lihanxiang20171204.bean.UserBean;
import com.facebook.drawee.view.SimpleDraweeView;

/**
 * Created by Lonely on 2017/12/4.
 */
public class HomeGoodsAdapter extends RecyclerView.Adapter<HomeGoodsAdapter.MyViewHolder> {
    // 数据源
    UserBean lists;    // 改泛型。
    // 上下文
    Context context;

    public HomeGoodsAdapter(UserBean lists, Context context) {
        this.lists = lists;
        this.context = context;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType)
    {
        MyViewHolder holder = new MyViewHolder(LayoutInflater.from(context).inflate(R.layout.home_goods_item, parent,
                false));
        return holder;
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position)
    {
        holder.goods_name.setText(lists.getData().getDefaultGoodsList().get(position).getGoods_name());

        Uri uri = Uri.parse(lists.getData().getDefaultGoodsList().get(position).getGoods_img());
        holder.img.setImageURI(uri);
    }

    @Override
    public int getItemCount()
    {
        return lists.getData().getDefaultGoodsList().size();
    }

    class MyViewHolder extends RecyclerView.ViewHolder
    {

        TextView goods_name;
        SimpleDraweeView img;

        public MyViewHolder(View view)
        {
            super(view);
            img =  view.findViewById(R.id.home_goods_img);
            goods_name  = (TextView) view.findViewById(R.id.home_goods_name);
        }
    }
}
