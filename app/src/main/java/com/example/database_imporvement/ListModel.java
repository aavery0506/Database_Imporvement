package com.example.database_imporvement;

import java.util.ArrayList;

public class ListModel {
    ArrayList<String> pNames;
    ArrayList<String> pDetails;


    private static ListModel instance;

    private ListModel(){
        pNames = new ArrayList<>();
        pDetails = new ArrayList<>();

    }

    public static ListModel getInstance(){
        if(instance == null){
            instance = new ListModel();
        }
        return instance;
    }

    public String getPNames(){
        return pNames.toString();
    }

    public String getPDetails(){
        return pDetails.toString();
    }
}
