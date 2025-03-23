package com.example.database_imporvement;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

import java.util.List;

@Dao
public interface ProductDao {

    @Insert
    void insertProduct(Product product);

    @Query("SELECT * FROM products WHERE productName = :name") //SQLite statement/command
    List<Product> findProduct(String name); //Java

    @Query("DELETE FROM products WHERE productName = :name")
    void deleteProduct(String name);

    @Query("DELETE FROM products")
    void deleteAllProducts();


    @Query("SELECT * FROM products")
    List<Product> getAllProducts();
}
