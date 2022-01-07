package com.example.smartgreenhouse.adapters;

import com.example.smartgreenhouse.model.SensorItem;
import com.example.smartgreenhouse.model.Usuario;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.Headers;
import retrofit2.http.POST;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface MyApiService {
    //Get Token
    @Headers({"Accept: application/json","Content-type:application/json"})
    @POST("auth/login")
    Call<JsonObject> getToken(@Body Usuario user);
    //get asset
    @Headers({"Content-type:application/json"})
    @GET("tenant/assetInfos?page=0&pageSize=100&type=green_house")
    Call<JsonObject> getAssetsTen(@Header("X-Authorization") String token);

    //
    @Headers({"Content-type:application/json"})
    @GET("relations/info")
    Call<JsonArray> getRelAssets(@Header("X-Authorization") String token,
                                 @Query("fromId") String id, @Query("fromType") String type);
    //get Latest Telemetry
    @Headers({"Accept: application/json"})
    @GET("plugin/telemetry/ASSET/{id}/values/timeseries?keys=currentValuepH")
    Call<JsonArray> getLatestTel(@Header("X-Authorization") String token,
                                 @Path("id") String id);





}
