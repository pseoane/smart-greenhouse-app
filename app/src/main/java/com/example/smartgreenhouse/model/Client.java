package com.example.smartgreenhouse.model;


import android.content.Context;

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
            queryParams += ("," + key);
        }
        String url = baseUrl + "plugins/telemetry/device/" + DEVICE_ID + "values/timeseries" + queryParams;
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
                Map<String, String> headers = super.getHeaders();
                headers.put("X-Authorization", authToken);
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