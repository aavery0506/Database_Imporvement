package com.example.database_imporvement;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.database_imporvement.databinding.FragmentShowProductsBinding;


public class ShowProducts extends Fragment {

    private FragmentShowProductsBinding binding;

    public ShowProducts() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
       // return inflater.inflate(R.layout.fragment_show_products, container, false);
        binding = FragmentShowProductsBinding.inflate(inflater,container,false);
        ListModel model = ListModel.getInstance();
        binding.ETShow.setText(model.getPNames().toString());

        return binding.getRoot();

    }
}