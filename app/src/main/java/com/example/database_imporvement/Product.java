package com.example.database_imporvement;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;
//make this class an Entity object with a table name of products
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
    //getters
    public int getID(){
        return id;
    }

    public String getName(){
        return this.name;
    }

    public int getQuantity(){
        return this.quantity;
    }
    //setters
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
