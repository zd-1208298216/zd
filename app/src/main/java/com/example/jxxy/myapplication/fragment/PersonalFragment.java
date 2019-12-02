package com.example.jxxy.myapplication.fragment;

import android.app.Activity;
import android.content.Intent;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.example.jxxy.myapplication.R;

import com.example.jxxy.myapplication.activity.ChangePwdActivity;
import com.example.jxxy.myapplication.activity.LoginActivity;
import com.example.jxxy.myapplication.activity.MyAddressActivity;
import com.example.jxxy.myapplication.activity.MyCollectActivity;
import com.example.jxxy.myapplication.activity.MyOrderActivity;
import com.example.jxxy.myapplication.common.BaseFragment;
import com.example.jxxy.myapplication.utils.SystemCofig;
import com.nostra13.universalimageloader.core.ImageLoader;

import butterknife.BindView;
import butterknife.OnClick;

public class PersonalFragment extends BaseFragment{
    @BindView(R.id.personal_for_login)
    RelativeLayout personal_for_login;
    @BindView(R.id.user_img_view)
    ImageView user_img_view;

    @BindView(R.id.user_name)
    TextView user_name;

    @BindView(R.id.user_level)
    TextView user_level;

    @BindView(R.id.personal_for_not_login)
    RelativeLayout personal_for_not_login;

    @BindView(R.id.person_logout_layout)
    RelativeLayout person_logout_layout;

    @Override
    public int getContentViewId() {
        return R.layout.fragment_personal;
    }

    @Override
    protected void initView(View view) {
        super.initView(view);
        resetUI();
    }
    private void resetUI(){
        if (SystemCofig.isLogin()){
            personal_for_login.setVisibility(View.VISIBLE);
            personal_for_not_login.setVisibility(View.GONE);
            person_logout_layout.setVisibility(View.VISIBLE);

            ImageLoader.getInstance().displayImage(SystemCofig.getLoginUserHead(),user_img_view);
            user_name.setText(SystemCofig.getLoginUserName());
            user_level.setText(SystemCofig.getLoginUserEmail());
        }else{
            personal_for_login.setVisibility(View.GONE);
            personal_for_not_login.setVisibility(View.VISIBLE);
            person_logout_layout.setVisibility(View.GONE);
        }
    }
    @OnClick(R.id.personal_login)
    void login(){
        Intent intent=new Intent(getActivity(), LoginActivity.class);
        startActivityForResult(intent,1000);
    }
    @OnClick(R.id.personal_my_order)
    void person_my_order(){
        if (SystemCofig.isLogin()){
            startActivity(new Intent(getActivity(), MyOrderActivity.class));
        }else{
            Intent intent=new Intent(getActivity(),LoginActivity.class);
            startActivityForResult(intent,1001);
        }
    }
    @OnClick(R.id.my_collect)
    void my_collect(){
        if (SystemCofig.isLogin()){
            startActivity(new Intent(getActivity(), MyCollectActivity.class));
        }else{
            Intent intent=new Intent(getActivity(),LoginActivity.class);
            startActivityForResult(intent,1002);
        }
    }
    @OnClick(R.id.my_address)
    void my_address(){
        if (SystemCofig.isLogin()){
            startActivity(new Intent(getActivity(), MyAddressActivity.class));
        }else{
            Intent intent=new Intent(getActivity(),LoginActivity.class);
            startActivityForResult(intent,1003);
        }
    }
    @OnClick(R.id.my_account)
    void my_accout(){
        if (SystemCofig.isLogin()){
            startActivity(new Intent(getActivity(), ChangePwdActivity.class));
        }else{
            Intent intent=new Intent(getActivity(),LoginActivity.class);
            startActivityForResult(intent,1004);
        }
    }
    @OnClick(R.id.person_logout_layout)
    void logout(){
        SystemCofig.logout();
        resetUI();
    }
    @Override
    public void onActivityResult(int requestCode,int resultGode,Intent data){
        super.onActivityResult(requestCode,requestCode,data);
        if (resultGode== Activity.RESULT_OK){
            resetUI();
            Intent intent=new Intent();
            if (requestCode==1000){
            }else if (requestCode==1001){
                intent.setClass(getActivity(),MyOrderActivity.class);
                startActivity(intent);
            }else if (requestCode==1002){
                intent.setClass(getActivity(),MyCollectActivity.class);
                startActivity(intent);
            }else if (requestCode==1003){
                intent.setClass(getActivity(),MyAddressActivity.class);
                startActivity(intent);
            }else if (requestCode==1004){
                intent.setClass(getActivity(),ChangePwdActivity.class);
                startActivity(intent);
            }
        }
    }

}
