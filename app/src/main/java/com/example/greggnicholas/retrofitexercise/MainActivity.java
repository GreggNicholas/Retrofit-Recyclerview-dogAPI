package com.example.greggnicholas.retrofitexercise;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.widget.ImageView;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {
    private static final String Base_URL_HOUND_API = "https://dog.ceo";
    private HoundService houndService;
    private ImageView catView;
    private RecyclerView recyclerView;
    private RecyclerViewAdapter adapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        catView = findViewById(R.id.cat_view);
        recyclerView = findViewById(R.id.recycler_view);


        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(Base_URL_HOUND_API)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        houndService = retrofit.create(HoundService.class);

        houndService.getDogs().enqueue(new Callback<RandomHound>() {
            @Override
            public void onResponse(Call<RandomHound> call, Response<RandomHound> response) {
                Log.d("Tag", "onResponse: " + houndService.getDogs());

                adapter = new RecyclerViewAdapter(getApplicationContext(), response.body().getDogs());
                recyclerView.setAdapter(adapter);
                recyclerView.setLayoutManager(new GridLayoutManager(getApplicationContext(), 3));


            }

            @Override
            public void onFailure(Call<RandomHound> call, Throwable t) {
                Log.d("TAG", "onResponse: " + t.toString());
            }
        });


    }
}
