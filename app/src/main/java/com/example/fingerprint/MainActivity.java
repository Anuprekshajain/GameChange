package com.example.fingerprint;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Toast;

import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {
    RecyclerView rvData;
    CityAdapter adapter;
    List<ListModel> dataList;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        dataList = new ArrayList<ListModel>();
        rvData = findViewById(R.id.recycle);
        fetchJson();
    }

    public void fetchJson(){
        RetrofitRead service = RetrofitInstance.getRetrofitInstance().create(RetrofitRead.class);
        Call<List<ResponsePOJO>> call = service.getData();
        call.enqueue(new Callback<List<ResponsePOJO>>() {
            @Override
            public void onResponse(Call<List<ResponsePOJO>> call, Response<List<ResponsePOJO>> response) {
                for(int i =0; i<response.body().size();i++) {
                    dataList.add(new ListModel(response.body().get(i).getName(), response.body().get(i).getCapital(),new Gson().toJson(response.body().get(i))));
                }
                adapter = new CityAdapter(getApplicationContext(),dataList);
                RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(MainActivity.this);
                rvData.setLayoutManager(layoutManager);
                rvData.setAdapter(adapter);
            }

            @Override
            public void onFailure(Call<List<ResponsePOJO>> call, Throwable t) {
                Toast.makeText(MainActivity.this, t.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }

    public void onButtonClick(View view){
        Intent intent = new Intent(MainActivity.this,SecondActivity.class);
        startActivity(intent);
    }

}
