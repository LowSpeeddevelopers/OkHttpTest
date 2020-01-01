package com.example.okhttptest;

import android.content.Context;
import android.util.Log;

import org.jetbrains.annotations.NotNull;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.MultipartBody;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

public class connection {

    String url;
    Context context;
    connection(String url, Context context){
        this.url=url;
        this.context=context;


//post , get , head

        OkHttpClient okHttpClient =new OkHttpClient.Builder().build();


        RequestBody requestBody = new MultipartBody.Builder()
                .setType(MultipartBody.FORM)
                .addFormDataPart("name", "fahim")
                .addFormDataPart("email","fahimfahadleon6474@gmail.com")
                .addFormDataPart("id","2")
                .addFormDataPart("password","password")
                .addFormDataPart("password_confirmation","password")
                .addFormDataPart("phone","01914616453")
                .build();

        Request request = new Request.Builder().post(requestBody).url(url).build();
        okHttpClient.newCall(request).enqueue(new Callback() {
            @Override
            public void onFailure(@NotNull Call call, @NotNull IOException e) {
                Log.e("failed",e.getMessage());
            }

            @Override
            public void onResponse(@NotNull Call call, @NotNull Response response) throws IOException {



                String jsonresponse =  response.body().string();


                Log.e("response",jsonresponse);


                try {
                    JSONObject jsonObject=new JSONObject(jsonresponse);


                    String message=jsonObject.getString("message");
                    String error = jsonObject.getString("error");
                    String user= jsonObject.getString("user");

                    Log.e("message",message);
                    Log.e("error",error);
                    Log.e("user",user);


                    JSONObject userjson=new JSONObject(user);


                    String name = userjson.getString("name");
                    String email = userjson.getString("email");
                    String phone = userjson.getString("phone");
                    String updated_at = userjson.getString("updated_at");
                    String created_at = userjson.getString("created_at");
                    String id = userjson.getString("id");



                    Log.e("name",name);
                    Log.e("email",email);
                    Log.e("phone",phone);
                    Log.e("created_at",created_at);
                    Log.e("updtate_at",updated_at);
                    Log.e("id",id);


                } catch (JSONException e) {
                    Log.e("purse failed","Invalid json");
                }

            }
        });






    }




}
