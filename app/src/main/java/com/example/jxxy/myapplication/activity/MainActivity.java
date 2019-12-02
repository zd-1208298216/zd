package com.example.jxxy.myapplication.activity;

import android.support.annotation.LayoutRes;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.util.Log;

import com.example.jxxy.myapplication.R;

import com.example.jxxy.myapplication.common.BaseActivity;
import com.example.jxxy.myapplication.fragment.NavigationFragment;
import com.example.jxxy.myapplication.http.entity.MemberEntity;
import com.example.jxxy.myapplication.http.presenter.MemberPresenter;

import rx.Subscriber;

public class MainActivity extends BaseActivity {

    @Override
    public @LayoutRes
    int getContentViewId()
    {
        return R.layout.activity_main;
    }

    @Override
    protected void initView(){
        super.initView();
        FragmentManager manager=getSupportFragmentManager();
        FragmentTransaction transaction=manager.beginTransaction();
        transaction.replace(R.id.fl_main,new NavigationFragment());
        transaction.commit();

    }
}
