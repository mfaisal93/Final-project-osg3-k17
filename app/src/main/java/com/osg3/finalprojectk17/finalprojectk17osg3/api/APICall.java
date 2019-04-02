package com.osg3.finalprojectk17.finalprojectk17osg3.api;

import com.osg3.finalprojectk17.finalprojectk17osg3.model.DomainSearch;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface APICall {
    @GET("/search")
    Call<DomainSearch> searchDomain(@Query("query") String text);
}
