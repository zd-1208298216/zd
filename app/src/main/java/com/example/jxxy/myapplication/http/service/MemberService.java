package com.example.jxxy.myapplication.http.service;

import com.example.jxxy.myapplication.http.entity.HttpResult;
import com.example.jxxy.myapplication.http.entity.MemberEntity;

import rx.Observable;

import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Path;
import retrofit2.http.Query;


public interface MemberService {
    @FormUrlEncoded
    @POST("member/login2")
    Observable<HttpResult<MemberEntity>>login2(
            @Field("input") String input,
            @Field("password") String password
    );

    @FormUrlEncoded
    @POST("member")
    Observable<HttpResult<MemberEntity>>register(
            @Field("uname") String uname,
            @Field("password") String password,
            @Field("email") String email
    );

    @FormUrlEncoded
    @PUT("member/{memberId}")
    Observable<HttpResult>changePassword(
            @Path("memberId") String memberId,
            @Path("old_pwd") String old_pwd,
            @Query("new_pwd") String new_pwd

    );
}
