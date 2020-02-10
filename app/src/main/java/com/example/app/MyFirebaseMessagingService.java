package com.example.app;

import android.content.Context;
import android.util.Log;

import com.google.firebase.messaging.FirebaseMessagingService;
import com.google.firebase.messaging.RemoteMessage;


public class MyFirebaseMessagingService extends FirebaseMessagingService {

    @Override
    public void onNewToken(String token) {
        super.onNewToken(token);
        Log.e("newToken", token);
//Add your token in your sharepreferences.
        getSharedPreferences("_", MODE_PRIVATE).edit().putString("fcm_token", token).apply();
    }

    @Override
    public void onMessageReceived(RemoteMessage remoteMessage) {
        super.onMessageReceived(remoteMessage);
    }
    //Whenewer you need FCM token, just call this static method to get it.
    public static String getToken(Context context) {
        return context.getSharedPreferences("_", MODE_PRIVATE).getString("fcm_token", "empty");
    }
}