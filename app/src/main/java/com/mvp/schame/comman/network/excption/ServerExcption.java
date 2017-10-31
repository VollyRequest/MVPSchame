package com.mvp.schame.comman.network.excption;

/**
 * Created by dell on 2017/10/31.
 */

public class ServerExcption extends RuntimeException {
    private int code;
    private String msg;

    public ServerExcption(int code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public int getCode() {
        return code;
    }

    public String getMsg() {
        return msg;
    }
}
