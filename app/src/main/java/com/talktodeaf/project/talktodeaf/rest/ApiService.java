package com.talktodeaf.project.talktodeaf.rest;

import com.talktodeaf.project.talktodeaf.model.Example;

import retrofit.Callback;
import retrofit.http.GET;
import retrofit.http.Path;

/**
 * Created by wiwat on 1/22/2015.
 */
public interface ApiService {
    @GET("/testService/rest/callservice/")
    void getExampleByMethodWithCallback(@Path("getQueryMySQL") String method, Callback<Example> callback);

}
