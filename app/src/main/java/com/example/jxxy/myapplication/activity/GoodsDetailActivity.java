package com.example.jxxy.myapplication.activity;



import android.text.TextUtils;

import android.widget.TextView;


import com.example.jxxy.myapplication.R;
import com.example.jxxy.myapplication.common.BaseActivity;

import butterknife.BindView;

import butterknife.OnClick;



//商品详情活动页

public class GoodsDetailActivity extends BaseActivity {



    @BindView(R.id.tv_title)

    TextView tvTitle;

    private int goods_id;

    private String goods_name;



    @Override

    public int getContentViewId() {

        return R.layout.activity_goods_detail;

    }



    @Override

    protected void initView() {

        super.initView();

        goods_id=getIntent().getIntExtra("goods_id",0);     //从上一个活动通过intent传来参数设置商品id和名称

        goods_name=getIntent().getStringExtra("goods_name");

        tvTitle.setMaxEms(9);

        tvTitle.setLines(1);



        if (TextUtils.isEmpty(goods_name)){

            tvTitle.setText("商品详情");

        }else{

            tvTitle.setText(goods_name);

        }

    }



    @OnClick(R.id.iv_back)

    void close(){finish();}

}