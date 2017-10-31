package com.mvp.schame.comman.network.excption;

/**
 * Created by dell on 2017/10/31.
 */

public class ApiException extends RuntimeException {

    private int code ;
    private String erroMsg;
    private String response ;

    public ApiException(Throwable throwable , int code){
        super(throwable);
        this.code = code;
    }

    public ApiException(int code , String eroMsg){
        this.code = code ;
        this.erroMsg = eroMsg;
        this.response = null;
    }

    public ApiException(int code , String eroMsg,String response){
        this.code = code ;
        this.erroMsg = eroMsg;
        this.response = response;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getErroMsg() {
        return erroMsg;
    }

    public void setErroMsg(String erroMsg) {
        this.erroMsg = erroMsg;
    }

    public String getResponse() {
        return response;
    }

    public void setResponse(String response) {
        this.response = response;
    }

    @Override
    public String toString() {
        return "ApiException{" +
                "code=" + code +
                ", msg='" + erroMsg + '\'' +
                ", response='" + response + '\'' +
                "} " + super.toString();
    }
}
