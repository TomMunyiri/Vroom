package com.tommunyiri.vroom.ui.home;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import com.google.android.material.internal.VisibilityAwareImageButton;
import com.tommunyiri.vroom.OrderRideActivity;
import com.tommunyiri.vroom.R;
import com.tommunyiri.vroom.databinding.FragmentHomeBinding;
import com.tommunyiri.vroom.databinding.FragmentNotificationsBinding;

public class HomeFragment extends Fragment {
    private FragmentHomeBinding binding;

    private HomeViewModel homeViewModel;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        binding = FragmentHomeBinding.inflate(inflater, container, false);
        View view = binding.getRoot();
        homeViewModel =
                ViewModelProviders.of(this).get(HomeViewModel.class);
        View root = inflater.inflate(R.layout.fragment_home, container, false);
        //final TextView textView = root.findViewById(R.id.text_home);
        homeViewModel.getText().observe(getViewLifecycleOwner(), new Observer<String>() {
            @Override
            public void onChanged(@Nullable String s) {
                binding.textHome.setText(s);
            }
        });
        binding.layoutOrderRide.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent orderRide=new Intent(getContext(), OrderRideActivity.class);
                startActivity(orderRide);
            }
        });
        return view;
    }
}