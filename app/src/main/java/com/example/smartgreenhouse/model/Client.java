package com.example.smartgreenhouse.model;

public class Client {
    private static Client client;
    private Client() {}

    public static Client getSharedInstance() {
        if (client == null) {
            client = new Client();
        }
        return client;
    }

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
    /*
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
