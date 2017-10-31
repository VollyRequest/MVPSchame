package com.mvp.schame.mvp;

import com.google.gson.Gson;
import com.google.gson.annotations.SerializedName;

/**
 * Created by dell on 2017/10/31.
 */

public class HttpResponse {
    /**
     * 描述信息
     */
    @SerializedName("msg")
    private String msg;

    /**
     * 状态码
     */
    @SerializedName("retCode")
    private int code;

    /**
     * 数据对象[成功返回对象,失败返回错误说明]
     */
    @SerializedName("result")
    private Object result;

    /**
     * 是否成功(这里约定200)
     *
     * @return
     */
    public boolean isSuccess() {
        return code == 200 ? true : false;
    }

    public String toString() {
        String response = "[http response]" + "{\"code\": " + code + ",\"msg\":" + msg + ",\"result\":" + new Gson().toJson(result) + "}";
        return response;
    }


    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public Object getResult() {
        return result;
    }

    public void setResult(Object result) {
        this.result = result;
    }
}
