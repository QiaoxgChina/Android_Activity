package com.qiaoxg.demoactivity.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.qiaoxg.demoactivity.R;
import com.qiaoxg.demoactivity.entity.UserBean;

import java.util.List;

/**
 * Created by admin on 2017/8/21.
 */

public class OrientationAdapter extends RecyclerView.Adapter<OrientationAdapter.ViewHolder> {

    private List<UserBean> mUserBeanList;

    public OrientationAdapter(List<UserBean> beanList) {
        this.mUserBeanList = beanList;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_orientation, null, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        UserBean bean = mUserBeanList.get(position);
        holder.headerIv.setImageResource(bean.getHeader());
        holder.userNameTv.setText(bean.getUserName());
        holder.phoneTv.setText(bean.getPhone());
    }

    @Override
    public int getItemCount() {
        return mUserBeanList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        private ImageView headerIv;
        private TextView userNameTv, phoneTv;

        public ViewHolder(View itemView) {
            super(itemView);

            headerIv = (ImageView) itemView.findViewById(R.id.header_iv);
            userNameTv = (TextView) itemView.findViewById(R.id.userName_tv);
            phoneTv = (TextView) itemView.findViewById(R.id.phone_tv);
        }
    }
}
