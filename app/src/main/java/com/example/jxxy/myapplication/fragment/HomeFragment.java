package com.example.jxxy.myapplication.fragment;


import android.graphics.Bitmap;
import android.support.v4.widget.SwipeRefreshLayout;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import com.example.jxxy.myapplication.R;

import com.example.jxxy.myapplication.common.BaseFragment;
import com.example.jxxy.myapplication.view.MyWebView;

import butterknife.BindView;
import butterknife.OnClick;

public class HomeFragment extends BaseFragment {

    private static final String TAG="HomeFragment";

    @BindView(R.id.swipe_refresh_layout)
    SwipeRefreshLayout mSwipeRefreshLayout;
    @BindView(R.id.webView)
    MyWebView mWebView;
    @OnClick(R.id.home_title_search)
    void search(){
        toastshort("开发中...");
    }

    @Override
    public int getContentViewId(){return R.layout.fragment_home;}

    @Override
    protected void initView(View view){
        super.initView(view);
        initWebView();
        initSwipREfreshLayout();
    }
    private void initSwipREfreshLayout(){
        mSwipeRefreshLayout.setColorSchemeResources(android.R.color.holo_blue_bright,android.R.color.holo_green_light,
                android.R.color.holo_orange_light,android.R.color.holo_red_light);
        mSwipeRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener(){
            @Override
            public void onRefresh(){
                mWebView.reload();
            }
        });
    }
    private void initWebView(){
        mWebView.setVerticalScrollBarEnabled(false);
        mWebView.setHorizontalScrollBarEnabled(false);

        WebSettings settings=mWebView.getSettings();
        settings.setJavaScriptEnabled(true);
        settings.setSupportZoom(false);
        settings.setBuiltInZoomControls(false);

        mWebView.setOnCustomScrollChanged(new MyWebView.IWebViewScroll(){
            @Override
            public void onTop(){
                mSwipeRefreshLayout.setEnabled(true);
            }
            @Override
            public void notOnTop(){
                mSwipeRefreshLayout.setEnabled(false);
            }
        });
        mWebView.setOnKeyListener(new View.OnKeyListener(){
            @Override
            public boolean onKey(View v, int keyCode, KeyEvent event){
                if (event.getAction()==KeyEvent.ACTION_DOWN){
                    if (keyCode==KeyEvent.KEYCODE_BACK&&mWebView.canGoBack()){
                        mWebView.goBack();
                        return true;
                    }
                }return false;
            }
        });
        mWebView.setWebViewClient(new WebViewClient(){
            @Override
            public boolean shouldOverrideUrlLoading(WebView view,String url){
                view.loadUrl(url);
                return true;
            }
            @Override
            public void onPageStarted(WebView view, String url, Bitmap favicon){
                mSwipeRefreshLayout.setRefreshing(true);
                Log.e(TAG,"onpageStarted");
            }
            @Override
            public void onPageFinished(WebView view,String url){
                mSwipeRefreshLayout.setRefreshing(false);
                Log.e(TAG,"onpageFinishde");
            }
        });
        mWebView.loadUrl("https://www.yhd.com/");
    }
}

