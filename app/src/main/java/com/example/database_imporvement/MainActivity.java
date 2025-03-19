package com.example.database_imporvement;

import android.os.Bundle;
import android.util.Log;
import android.view.View;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.sqlite.db.SupportSQLiteDatabase;

import com.example.database_imporvement.databinding.ActivityMainBinding;

import java.util.ArrayList;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class MainActivity extends AppCompatActivity {

    ActivityMainBinding binding;

    private ProductRoomDatabase productdb;
    private ArrayList<Product> productList;

    private RecyclerAdapter adapter;
    private RecyclerView recyclerView;
    private RecyclerView.LayoutManager layoutManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        //view binding
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        setContentView(view);

        layoutManager = new LinearLayoutManager(this);
        binding.rview.setLayoutManager(layoutManager);
        adapter = new RecyclerAdapter();
        binding.rview.setAdapter(adapter);




        productList = new ArrayList<>();
        //callback method
        RoomDatabase.Callback myCallback = new RoomDatabase.Callback() {
            @Override
            public void onCreate(@NonNull SupportSQLiteDatabase db){
                super.onCreate(db);
            }
            @Override
            public void onOpen(@NonNull SupportSQLiteDatabase db){
                super.onOpen(db);
            }
        };

        //build and create a connection to the database
        productdb = Room.databaseBuilder(getApplicationContext(),ProductRoomDatabase.class,"products")
                        .addCallback(myCallback).build();

        binding.buttonSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                addProductInBackground(new Product(binding.textViewName.getText().toString(),
                        Integer.parseInt(binding.textViewQuantity.getText().toString())));
            }
        });

        binding.buttonRetrieve.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getProductListBackground();

            }
        });


        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }
    public void addProductInBackground(Product product){
        ExecutorService executor = Executors.newSingleThreadExecutor();

        executor.execute(new Runnable() {
            @Override
            public void run() {
                productdb.getProductDao().insertProduct(product);
            }
        });
    }

    public void getProductListBackground(){
        ExecutorService executor = Executors.newSingleThreadExecutor();

        executor.execute(new Runnable() {
            @Override
            public void run() {
                //productdb.getProductDao().insertProduct(product);

                productList = (ArrayList<Product>) productdb.getProductDao().getAllProducts();

                StringBuilder finalString = new StringBuilder();

                for(Product temp : productList){
                    finalString.append(temp.getName()).append("   |   ").append(temp.getQuantity())
                            .append("\n");
                }
                Log.d("testing","basil");

            }
        });
    }
}