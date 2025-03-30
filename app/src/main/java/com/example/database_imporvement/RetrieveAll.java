package com.example.database_imporvement;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentResultOwner;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.database_imporvement.databinding.FragmentRetrieveBinding;
import com.example.database_imporvement.databinding.FragmentShowProductsBinding;


public class RetrieveAll extends Fragment {

    private FragmentRetrieveBinding binding;

    public RetrieveAll() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        //return inflater.inflate(R.layout.fragment_retrieve, container, false);
        binding = FragmentRetrieveBinding.inflate(inflater,container,false);
        ListModel model = ListModel.getInstance();
        binding.ETRetrieve.setText(model.getPDetails().toString());

        return binding.getRoot();
    }
}