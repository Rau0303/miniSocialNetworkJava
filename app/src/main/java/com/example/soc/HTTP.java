package com.example.soc;

import android.os.AsyncTask;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;

public class HTTP {

    public interface OnRequestCompletedListener {
        void onRequestCompleted(String response);

        void onRequestError(Exception e);
    }
    public  void getdata(){}

    public  void makeHttpRequestInBackground(String url, String data, OnRequestCompletedListener listener) {
        new HttpRequestTask(listener).execute(url, data);
    }

    public static class HttpRequestTask extends AsyncTask<String, Void, String> {
        private final OnRequestCompletedListener listener;

        HttpRequestTask(OnRequestCompletedListener listener) {
            this.listener = listener;
        }

        @Override
        protected String doInBackground(String... params) {
            try {
                return makeHttpRequest(params[0], params[1]);
            } catch (IOException e) {
                e.printStackTrace();
                return null;
            }
        }

        @Override
        protected void onPostExecute(String result) {
            if (listener != null) {
                if (result != null) {
                    listener.onRequestCompleted(result);
                } else {
                    listener.onRequestError(new IOException("HTTP request failed or returned empty response."));
                }
            }
        }
    }

    private static String makeHttpRequest(String url, String data) throws IOException {
        URL apiUrl = new URL(url);
        HttpURLConnection connection = (HttpURLConnection) apiUrl.openConnection();
        connection.setReadTimeout(10000);
        connection.setConnectTimeout(15000);
        connection.setRequestProperty("Content-Type", "application/json; charset=UTF-8");
        connection.setRequestProperty("Accept", "application/json");

        connection.setRequestMethod("POST");
        connection.setDoOutput(true);


        try (OutputStream outputStream = connection.getOutputStream()) {
            outputStream.write(data.getBytes("UTF-8"));
        }

        connection.connect();

        if (connection.getResponseCode() == HttpURLConnection.HTTP_OK) {

            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
            StringBuilder response = new StringBuilder();
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                response.append(line);
            }
            bufferedReader.close();
            return response.toString();
        } else {

            throw new IOException("HTTP request failed with status code: " + connection.getResponseCode());
        }
    }
}
