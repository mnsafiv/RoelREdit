package com.safonov_iv.roelredit.Repo;

import okhttp3.*;

import java.io.IOException;

public class MapData {
    final OkHttpClient client = new OkHttpClient();
    public static final MediaType JSON
            = MediaType.parse("application/json; charset=utf-8");

    String getMapById(String url)  {
        Request request = new Request.Builder()
                .url(url)
                .build();

        try (Response response = client.newCall(request).execute()) {
            assert response.body() != null;
            return response.body().string();
        }
        catch (IOException e){
            e.printStackTrace();
        }
        return null;
    }


    String saveMap(String url, String json)  {
        RequestBody body = RequestBody.create(json, JSON);
        Request request = new Request.Builder()
                .url(url)
                .post(body)
                .build();
        try (Response response = client.newCall(request).execute()) {
            assert response.body() != null;
            return response.body().string();
        }
        catch (IOException e){
            e.printStackTrace();
        }
        return null;
    }

    public String getData(String url){
        return getMapById(url);
    }

    public String sendData(String url, String json){
        return saveMap(url,json);
    }


}
