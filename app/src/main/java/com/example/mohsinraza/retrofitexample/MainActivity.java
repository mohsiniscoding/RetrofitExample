package com.example.mohsinraza.retrofitexample;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {

    private List<User> users = new ArrayList<>();
    private  UserRecyclerViewAdapter adapter;

    private static final String TAG = "MainActivity";
    private static final String BASE_URL = "https://api.github.com/";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



        final RecyclerView rv = (RecyclerView) findViewById(R.id.rvUsers);
        rv.hasFixedSize();
        rv.setLayoutManager(new LinearLayoutManager(this));



        Retrofit.Builder builder = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory
                .create());

        Retrofit retrofit = builder.build();

        GithubClient client = retrofit.create(GithubClient.class);

        Call<List<User>> call = client.getAllUsers();

        call.enqueue(new Callback<List<User>>() {
            @Override
            public void onResponse(Call<List<User>> call, Response<List<User>> response) {

                users = response.body();

                adapter = new UserRecyclerViewAdapter(MainActivity.this,users);
                rv.setAdapter(adapter);

                int count = response.body().size();
                Toast.makeText(MainActivity.this, "count: "+count, Toast.LENGTH_SHORT).show();
                adapter.notifyDataSetChanged();
            }

            @Override
            public void onFailure(Call<List<User>> call, Throwable t) {
                Toast.makeText(MainActivity.this, "Failer", Toast.LENGTH_SHORT).show();
            }
        });







    }
}
