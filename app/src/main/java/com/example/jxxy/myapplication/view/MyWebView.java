package com.example.jxxy.myapplication.view;

import android.content.Context;
import android.util.AttributeSet;
import android.webkit.WebView;

public class MyWebView extends WebView {
    private IWebViewScroll mIWebViewScroll;
    public MyWebView(Context context){super(context,null);}
    public MyWebView(Context context,AttributeSet attrs){super(context,attrs,0);}
    public MyWebView(Context context,AttributeSet attrs,int defStyleAttr){super(context,attrs,defStyleAttr);}

    @Override
    protected void onScrollChanged(int l,int t,int oldl,int oldt){
        super.onScrollChanged(1,t,oldl,oldt);
        if (mIWebViewScroll!=null&&t==0){
            mIWebViewScroll.onTop();
        }else if (mIWebViewScroll!=null&&t!=0){
            mIWebViewScroll.notOnTop();
        }
    }
    public void setOnCustomScrollChanged(IWebViewScroll listener){
        this.mIWebViewScroll=listener;
    }
    public interface IWebViewScroll{
        void onTop();
        void notOnTop();
    }
}
