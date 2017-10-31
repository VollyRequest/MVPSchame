package com.mvp.schame.comman.network;

import com.jakewharton.retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import com.mvp.schame.comman.constants.Constants;
import com.mvp.schame.comman.network.converter.RetrofitConverterFactory;

import io.reactivex.schedulers.Schedulers;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;

/**
 * Created by dell on 2017/10/30.
 * 对网络请求进行初始化
 */

public final class API {

    public static API instance = null;

    public static Retrofit retrofit = null;

    public static API getInstance(boolean isBeta) {
        if (instance == null) {
            instance = new API(isBeta);
        }
        return instance;
    }

    private API(boolean isBeta) {
        // 拦截请求体和响应体，并打印日志
        HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor();
        interceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
        // 初始化OkHttpClient
        OkHttpClient client = new OkHttpClient.Builder()
                .addInterceptor(interceptor)
                .addInterceptor(chain -> {
                    Request request = chain.request();
                    Request.Builder builder = request.newBuilder();
                    // 修改请求头
                    //------------
                    // 生成新的请求
                    Request build = builder.build();
                    Response response = chain.proceed(build);
                    return response;
                })
                .build();
        // 初始化Retrofit，2.0以后Converter不在packge内，只能在build.gradle中添加依赖，并使用addConverterFactory添加。
        retrofit = new Retrofit.Builder()
                .baseUrl(isBeta ? Constants.BETA_URL:Constants.BASE_URL)// 添加基址url
                .addConverterFactory(RetrofitConverterFactory.create())// 添加转换器，
                .addCallAdapterFactory(RxJava2CallAdapterFactory.createWithScheduler(Schedulers.io()))// 指定所有的网络请求都在IO线程执行
                .client(client)// 绑定okhttp
                .build();
    }
    public static Retrofit getRetrofit(){return retrofit;}

}
