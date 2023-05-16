package com.example.myapi;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.ProgressDialog;
import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {
    private MyAdapter myAdapter;
    RecyclerView recyclerView;
    ProgressDialog progressDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        progressDialog = new ProgressDialog(MainActivity.this);
        progressDialog.setMessage("Loading....");
        progressDialog.show();


        RetrofitApi retrofitApi = RetrofitClient.getRetrofitInstance().create(RetrofitApi.class);
        Call<List<DataModal>> call = retrofitApi.getHeroes();
        call.enqueue(new Callback<List<DataModal>>() {
            @Override
            public void onResponse(Call<List<DataModal>> call, Response<List<DataModal>> response) {
                progressDialog.dismiss();
                generateDataList(response.body());
            }


            @Override
            public void onFailure(Call<List<DataModal>> call, Throwable t) {
                progressDialog.dismiss();
                Toast.makeText(MainActivity.this, "Something went wrong...Please try later!", Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void generateDataList(List<DataModal> photoList) {
        recyclerView = findViewById(R.id.recyclerview);
        myAdapter=new MyAdapter( this,  photoList);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(MainActivity.this);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(myAdapter);
    }
}