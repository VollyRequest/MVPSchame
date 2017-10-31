package com.mvp.schame.comman.network.converter;

import com.google.gson.Gson;
import com.google.gson.TypeAdapter;
import com.google.gson.reflect.TypeToken;

import java.lang.annotation.Annotation;
import java.lang.reflect.Type;

import okhttp3.RequestBody;
import okhttp3.ResponseBody;
import retrofit2.Converter;
import retrofit2.Retrofit;

/**
 * Created by dell on 2017/10/30.
 * @author fzc
 */

public class RetrofitConverterFactory extends Converter.Factory {
    private final Gson gson;

    public static RetrofitConverterFactory create() {
        return create(new Gson());
    }

    public static RetrofitConverterFactory create(Gson gson) {
        return new RetrofitConverterFactory(gson);
    }

    private RetrofitConverterFactory(Gson gson) {
        if (gson == null) {
            throw new NullPointerException("gson == null");
        } else {
            this.gson = gson;
        }
    }

    @Override
    public Converter<ResponseBody, ?> responseBodyConverter(Type type, Annotation[] annotations, Retrofit retrofit) {
        return new RetrofitResponseBodyConverter<>(this.gson, type);
    }

    @Override
    public Converter<?, RequestBody> requestBodyConverter(Type type, Annotation[] parameterAnnotations, Annotation[] methodAnnotations, Retrofit retrofit) {
        TypeAdapter adapter = this.gson.getAdapter(TypeToken.get(type));
        return new RetrofitRequestBodyConverter<>(this.gson, adapter);
    }
}
