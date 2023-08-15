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

    private OnRequestCompletedListener listener;

    public HTTP(OnRequestCompletedListener listener) {
        this.listener = listener;
    }

    public void makeHttpRequestInBackground(String url, String data) {
        new HttpRequestTask().execute(url, data);
    }

    public void makeHttpPutRequestInBackground(String url, String data) {
        new HttpPutRequestTask().execute(url, data);
    }

    public void makeHttpDeleteRequestInBackground(String url) {
        new HttpDeleteRequestTask().execute(url);
    }

    public void makeHttpUpdateRequestInBackground(String url, String data) {
        new HttpUpdateRequestTask().execute(url, data);
    }

    private class HttpRequestTask extends AsyncTask<String, Void, String> {

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
            handleRequestResult(result);
        }
    }

    private class HttpPutRequestTask extends AsyncTask<String, Void, String> {

        @Override
        protected String doInBackground(String... params) {
            try {
                return makeHttpPutRequest(params[0], params[1]);
            } catch (IOException e) {
                e.printStackTrace();
                return null;
            }
        }

        @Override
        protected void onPostExecute(String result) {
            handleRequestResult(result);
        }
    }

    private class HttpDeleteRequestTask extends AsyncTask<String, Void, String> {

        @Override
        protected String doInBackground(String... params) {
            try {
                return makeHttpDeleteRequest(params[0]);
            } catch (IOException e) {
                e.printStackTrace();
                return null;
            }
        }

        @Override
        protected void onPostExecute(String result) {
            handleRequestResult(result);
        }
    }

    private class HttpUpdateRequestTask extends AsyncTask<String, Void, String> {

        @Override
        protected String doInBackground(String... params) {
            try {
                return makeHttpUpdateRequest(params[0], params[1]);
            } catch (IOException e) {
                e.printStackTrace();
                return null;
            }
        }

        @Override
        protected void onPostExecute(String result) {
            handleRequestResult(result);
        }
    }

    private String makeHttpRequest(String url, String data) throws IOException {
        // Реализация метода для отправки запроса POST
        return data;
    }

    private String makeHttpPutRequest(String url, String data) throws IOException {
        // Реализация метода для отправки запроса PUT

        return data;
    }

    private String makeHttpDeleteRequest(String url) throws IOException {
        // Реализация метода для отправки запроса DELETE
        return url;
    }

    private String makeHttpUpdateRequest(String url, String data) throws IOException {
        // Реализация метода для отправки запроса UPDATE
        return data;
    }

    private void handleRequestResult(String result) {
        if (listener != null) {
            if (result != null) {
                listener.onRequestCompleted(result);
            } else {
                listener.onRequestError(new IOException("HTTP request failed or returned empty response."));
            }
        }
    }
}
