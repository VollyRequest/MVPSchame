package com.mvp.schame.comman.network.converter;

import com.google.gson.Gson;

import java.io.IOException;
import java.lang.reflect.Type;

import okhttp3.ResponseBody;
import retrofit2.Converter;

/**
 * Created by dell on 2017/10/30.
 */

public final class RetrofitResponseBodyConverter<T> implements Converter<ResponseBody, T> {

    private final Gson gson;
    private Type type;

    RetrofitResponseBodyConverter(Gson gson, Type type) {
        this.gson = gson;
        this.type = type;
    }

    @Override
    public T convert(ResponseBody responseBody) throws IOException {
        try {
            String jsonString = responseBody.string();
            return this.gson.fromJson(jsonString, type);
        } finally {
            responseBody.close();
        }
    }
}
