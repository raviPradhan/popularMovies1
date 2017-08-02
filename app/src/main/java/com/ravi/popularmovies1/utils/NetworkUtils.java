package com.ravi.popularmovies1.utils;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.util.Log;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class NetworkUtils {

    public static boolean isInternetConnected(Context context){
        ConnectivityManager cm =
                (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo netInfo = cm.getActiveNetworkInfo();
        return netInfo != null && netInfo.isConnected();
    }

    public static String getJson(String urlString)
            throws IOException {
        URL url;
        String responseMessage = "";
        try {
            url = new URL(urlString);
        } catch (MalformedURLException e) {
            throw new IllegalArgumentException("invalid url: " + urlString);
        }
        HttpURLConnection conn = null;
        try {
            Log.e("URL", "> " + url);
            conn = (HttpURLConnection) url.openConnection();
            conn.setConnectTimeout(Constants.TIMEOUT_CONNECTION);
            conn.setReadTimeout(Constants.TIMEOUT_SOCKET);
            int status = conn.getResponseCode();
            if (status > HttpURLConnection.HTTP_ACCEPTED) {
//                Log.e("RESPONSE CODE", "> " + status);
                throw new IOException("GET failed with error code " + status);
            }

            InputStream is = conn.getInputStream();
            int ch;
            StringBuilder sb = new StringBuilder();
            while ((ch = is.read()) != -1) {
                sb.append((char) ch);
            }
            responseMessage = sb.toString();
            is.close();
        } finally {
            if (conn != null) {
                conn.disconnect();
            }
        }
        return responseMessage;
    }
}
