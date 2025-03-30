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
    private String quantity;

    public Product(String name, String quantity){
        this.name = name;
        this.quantity= quantity;
    }
    //getters
    public int getId(){
        return id;
    }

    public String getName(){
        return this.name;
    }

    public String getQuantity(){
        return this.quantity;
    }
    //setters
    public void setId(int id){
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setQuantity(String quantity) {
        this.quantity = quantity;
    }


}
