package com.example.smartgreenhouse.model;

import android.view.View;

import com.example.smartgreenhouse.adapters.ApiAdapter;
import com.example.smartgreenhouse.adapters.MyApiService;
import com.google.gson.JsonObject;

import org.json.JSONObject;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Cliente {

    private static Cliente client;
    private Cliente() {
    }
    public static Cliente getSharedInstance() {
        if (client == null) {
            client = new Cliente();
            return client;
        }
        else return client;
    }
/*
    public void login(View view){
        MyApiService tbs = ApiAdapter.getApiService();
        Call<JsonObject> response = tbs.getToken(new Usuario("Admin","Admin"));
        response.enqueue(new Callback<JsonObject>() {
            @Override
            public void onResponse(Call<JsonObject> call, Response<JsonObject> response) {
                if (response.code() == 200){
                    try{
                        String token = (new JSONObject(response.body().toString())).getString("token");
                    } catch (Exception ex){
                        ex.printStackTrace();
                    }
                }

            }

            @Override
            public void onFailure(Call<JsonObject> call, Throwable t) {

            }
        });
    }
    public void requestAssetId(View view){
        MyApiService tbs = ApiAdapter.getApiService();
        Call<JsonObject> response = tbs.getAssetsTen();
        response.enqueue(new Callback<JsonObject>() {
            @Override
            public void onResponse(Call<JsonObject> call, Response<JsonObject> response) {
                if (response.code() == 200){
                    try{
                        String id = (new JSONObject(response.body().toString())).getString("id");
                    } catch (Exception ex){
                        ex.printStackTrace();
                    }
                }

            }
            @Override
            public void onFailure(Call<JsonObject> call, Throwable t) {

            }

        });
    }
    public void requestRealAsset (View view){
        MyApiService tbs = ApiAdapter.getApiService();
        Call<JsonObject> response = tbs.getAssetsTen(t);
        response.enqueue(new Callback<JsonObject>() {
            @Override
            public void onResponse(Call<JsonObject> call, Response<JsonObject> response) {
                if (response.code() == 200){
                    try{



                    } catch (Exception ex){
                        ex.printStackTrace();
                    }
                }

            }
        @Override
            public void onFailure(Call<JsonObject> call, Throwable t) {

            }

        });

    }
    public void requestLastTel (View view){
        MyApiService tbs = ApiAdapter.getApiService();
        Call<JsonObject> response = tbs.getLatestTel();
        response.enqueue(new Callback<JsonObject>() {
            @Override
            public void onResponse(Call<JsonObject> call, Response<JsonObject> response) {
                if (response.code() == 200){
                    try{


                    } catch (Exception ex){
                        ex.printStackTrace();
                    }
                }

            }
            @Override
            public void onFailure(Call<JsonObject> call, Throwable t) {

            }

        });

    }
*/
}
