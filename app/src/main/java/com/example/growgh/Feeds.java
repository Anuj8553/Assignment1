package com.example.growgh;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.Toast;


import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Feeds extends AppCompatActivity {
RecyclerView rvproducts;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_feeds);
        rvproducts=findViewById(R.id.IMAGES);

        getProducts();
    }
    private void getProducts(){
        Call<List<ProductResult>> apiCall = RetroFitClient.getInstance().getApis().getProducts() ;
        apiCall.enqueue(new Callback<List<ProductResult>>() {
            @Override
            public void onResponse(Call<List<ProductResult>> call, Response<List<ProductResult>> response) {
                List<ProductResult> productResults = response.body();
                setAdapter(productResults);
            }


            @Override
            public void onFailure(Call<List<ProductResult>> call, Throwable t) {
                Toast.makeText(Feeds.this, "Error Loading images", Toast.LENGTH_SHORT).show();
            }
        });



    }

    private void setAdapter(List<ProductResult> productResults) {
        rvproducts.setLayoutManager(new LinearLayoutManager(this));
        RVRetrofitAdapter rvRetrofitAdapter = new RVRetrofitAdapter(this,productResults);
        rvproducts.setAdapter(rvRetrofitAdapter);

    }

}