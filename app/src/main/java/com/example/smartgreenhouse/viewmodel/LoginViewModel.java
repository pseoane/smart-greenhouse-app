package com.example.smartgreenhouse.viewmodel;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.MutableLiveData;

import com.example.smartgreenhouse.model.Auth;
import com.example.smartgreenhouse.model.Client;
import com.example.smartgreenhouse.model.Usuario;
import com.google.gson.Gson;

public class LoginViewModel extends AndroidViewModel {
    private MutableLiveData<Boolean> loginResult; // true = login succeeded; false = login failed

    public LoginViewModel(@NonNull Application application) {
        super(application);
    }

    public MutableLiveData<Boolean> getLoginResult() {
        if (loginResult == null) {
            loginResult = new MutableLiveData<>();
        }
        return loginResult;
    }

    public void performLogin(Usuario user) {
        Client.getSharedInstance().login(
                user,
                response -> {
                    Auth auth = new Gson().fromJson(response.toString(), Auth.class);
                    Client.getSharedInstance().setAuthToken(auth);
                    loginResult.postValue(true);
                },
                error -> {
                    loginResult.postValue(false);
                }
        );
    }
}
