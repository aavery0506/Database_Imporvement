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

    public void setpNames(ArrayList<String> pNames) {
        this.pNames = pNames;
    }

    public void setpDetails(ArrayList<String> pDetails) {
        this.pDetails = pDetails;
    }

    public ArrayList<String> getPDetails() {
        return pDetails;
    }

    public ArrayList<String> getPNames() {
        return pNames;
    }
}
