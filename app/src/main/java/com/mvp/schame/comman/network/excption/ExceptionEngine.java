package com.mvp.schame.comman.network.excption;

import android.net.ParseException;

import com.google.gson.JsonParseException;
import com.google.gson.stream.MalformedJsonException;
import com.jakewharton.retrofit2.adapter.rxjava2.HttpException;

import org.json.JSONException;

import java.net.ConnectException;
import java.net.SocketTimeoutException;

/**
 * Created by dell on 2017/10/31.
 */

public class ExceptionEngine {

    public static final int UN_KNOWN_ERROR = 1000;//未知错误
    public static final int ANALYTIC_SERVER_DATA_ERROR = 1001;//解析(服务器)数据错误
    public static final int CONNECT_ERROR = 1003;//网络连接错误
    public static final int TIME_OUT_ERROR = 1004;//网络连接超时

    public static ApiException handleExcption(Throwable excp) {
        ApiException exception;
        if (excp instanceof HttpException) {
            HttpException httpException = (HttpException) excp;
            exception = new ApiException(excp, ((HttpException) excp).code());
            exception.setErroMsg("network is erro");
            return exception;
        } else if (excp instanceof ServerExcption) {
            ServerExcption serverExcption = (ServerExcption) excp;
            exception = new ApiException(serverExcption.getCode(), serverExcption.getMsg());
            return exception;
        } else if (excp instanceof JsonParseException
                || excp instanceof JSONException
                || excp instanceof ParseException || excp instanceof MalformedJsonException) {
            exception = new ApiException(excp, ANALYTIC_SERVER_DATA_ERROR);
            exception.setErroMsg("analytic json is faile");
        } else if (excp instanceof ConnectException) {//连接网络错误
            exception = new ApiException(excp, CONNECT_ERROR);
            exception.setErroMsg("连接失败");
            return exception;
        } else if (excp instanceof SocketTimeoutException) {//网络超时
            exception = new ApiException(excp, TIME_OUT_ERROR);
            exception.setErroMsg("网络超时");
            return exception;
        } else {  //未知错误
            exception = new ApiException(excp, UN_KNOWN_ERROR);
            exception.setErroMsg("未知错误");
            return exception;
        }
        return null ;
    }

}
