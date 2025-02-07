package com.daniru.tastystreeteats.Fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;

import com.daniru.tastystreeteats.R;
import com.daniru.tastystreeteats.adapter.CartAdapter;
import com.daniru.tastystreeteats.databinding.FragmentCartBinding;

import java.util.ArrayList;
import java.util.Arrays;

public class CartFragment extends Fragment {

    private FragmentCartBinding binding;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        // Inflate the layout using ViewBinding
        binding = FragmentCartBinding.inflate(inflater, container, false);

        // Dummy data for the cart
        ArrayList<String> cartFoodName = new ArrayList<>(Arrays.asList("Burger", "Sandwich", "Momo", "Pizza", "Fries"));
        ArrayList<String> cartItemPrice = new ArrayList<>(Arrays.asList("Rs 560", "Rs 780", "Rs 950", "Rs 950", "Rs 350"));
        ArrayList<Integer> cartImages = new ArrayList<>(Arrays.asList(
                R.drawable.bug,
                R.drawable.chickensandwiches,
                R.drawable.momo,
                R.drawable.pizza,
                R.drawable.fr
        ));

        // Setting up the adapter
        CartAdapter adapter = new CartAdapter(cartFoodName, cartItemPrice, cartImages);
        binding.cartRecyclerView.setLayoutManager(new LinearLayoutManager(requireContext()));
        binding.cartRecyclerView.setAdapter(adapter);


        return binding.getRoot();
    }
}
