package com.example.database_imporvement;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "products")
public class Product {

    @PrimaryKey(autoGenerate = true)

    @ColumnInfo(name = "productID")
    private int id;
    @ColumnInfo(name = "productName")
    private String name;
    @ColumnInfo(name = "productQuantity")
    private int quantity;

    public Product(String name, int quantity){
        this.name = name;
        this.quantity= quantity;
    }

    public int getID(){
        return id;
    }

    public String getName(){
        return name;
    }

    public int getQuantity(){
        return quantity;
    }

    public void setID(int id){
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }


}
