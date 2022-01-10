package com.example.smartgreenhouse.model;


import android.content.Context;
import android.util.Log;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;
import com.google.gson.Gson;

import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Client {
    private static Client client;
    private final String baseUrl = "https://srv-iot.diatel.upm.es/api";
    private final String DEVICE_ID = "9ae70ea0-6bb1-11ec-9a04-591db17ccd5b"; // Telemetry Sensors Device
    private RequestQueue queue;
    private String authToken;
    private Gson gson;

    private Client() {
        gson = new Gson();
    }

    // Getters
    public static Client getSharedInstance() {
        if (client == null) {
            client = new Client();
        }
        return client;
    }

    // Setters
    public void setRequestQueue(Context context) {
        if (queue == null) {
            queue = Volley.newRequestQueue(context);
        }
    }

    public void setAuthToken(Auth auth) {
        authToken = auth.token;
        Log.d("Auth", authToken);
    }

    // Action methods
    public void login(
            User user,
            Response.Listener<org.json.JSONObject> successListener,
            Response.ErrorListener errorListener
    ) {
        String url = baseUrl + "/auth/login";
        post(url, gson.toJson(user), successListener, errorListener);
    }

    public void getSensorsValues(
            ArrayList<String> keys, // Which sensors values should be returned
            Response.Listener<org.json.JSONObject> successListener,
            Response.ErrorListener errorListener
    ) {
        String queryParams = "?keys=";
        for (String key : keys) {
            queryParams += (key + ",");
        }
        queryParams = queryParams.substring(0, queryParams.length() - 1); //To remove last parameter

        String url = baseUrl + "/plugins/telemetry/DEVICE/" + DEVICE_ID + "/values/timeseries" + queryParams;
        Log.d("URL", url);
        get(url, successListener, errorListener);
    }

    // Private methods
    private void get(
            String url,
            Response.Listener<org.json.JSONObject> listener,
            Response.ErrorListener errorListener
    ) {
        JsonObjectRequest request = new JsonObjectRequest(
                Request.Method.GET,
                url,
                null,
                listener,
                errorListener
        ) {
            @Override
            public Map<String, String> getHeaders() throws AuthFailureError {
                Map<String, String> headers = new HashMap<String, String>();
                String authorization = "Bearer " + authToken; //According the documentation, Bearer is needed
                Log.d("authorization", authorization);
                headers.put("X-Authorization", authorization);
                return headers;
            }
        };
        queue.add(request); // Sends the request
    }

    private void post(
            String url,
            String jsonString,
            Response.Listener<org.json.JSONObject> listener,
            Response.ErrorListener errorListener
    ) {
        try {
            JSONObject requestBody = new JSONObject(jsonString);
            JsonObjectRequest request = new JsonObjectRequest(
                    Request.Method.POST,
                    url,
                    requestBody,
                    listener,
                    errorListener
            );
            queue.add(request); // Sends the request
        } catch (Exception e) {
            VolleyError error = new VolleyError("Unable to parse body into json");
            errorListener.onErrorResponse(error);
        }
    }
}