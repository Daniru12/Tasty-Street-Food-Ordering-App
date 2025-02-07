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
import com.daniru.tastystreeteats.adapter.PopularAddapter;
import com.daniru.tastystreeteats.adapter.PopularAddapter;
import com.daniru.tastystreeteats.databinding.FragmentHomeBinding;
import com.denzcoskun.imageslider.ImageSlider;
import com.denzcoskun.imageslider.constants.ScaleTypes;
import com.denzcoskun.imageslider.models.SlideModel;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class HomeFragment extends Fragment {

    private FragmentHomeBinding binding;

    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    private String mParam1;
    private String mParam2;

    public HomeFragment() {
        // Required empty public constructor
    }

    public static HomeFragment newInstance(String param1, String param2) {
        HomeFragment fragment = new HomeFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentHomeBinding.inflate(inflater, container, false);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        // Prepare the image list for the image slider
        ArrayList<SlideModel> imageList = new ArrayList<>();
        imageList.add(new SlideModel(R.drawable.burger1, ScaleTypes.FIT));
        imageList.add(new SlideModel(R.drawable.fries, ScaleTypes.FIT));
        imageList.add(new SlideModel(R.drawable.burgers, ScaleTypes.FIT));
        imageList.add(new SlideModel(R.drawable.hotdog, ScaleTypes.FIT));

        // Set the image list to the ImageSlider
        binding.imageSlider.setImageList(imageList);

        // Prepare data for RecyclerView
        List<String> foodName = Arrays.asList("Burger", "Sandwich", "Pizza", "Fries");
        List<String> price = Arrays.asList("Rs 560", "Rs 780", "Rs 950", "Rs 350");
        List<Integer> popularFoodImages = Arrays.asList(
                R.drawable.bug,
                R.drawable.chickensandwiches,
                R.drawable.pizza,
                R.drawable.fr
        );

        // Initialize and set up the RecyclerView
        PopularAddapter adapter = new PopularAddapter(foodName, price, popularFoodImages);
        binding.PopulerRecyclerView.setLayoutManager(new LinearLayoutManager(requireContext()));
        binding.PopulerRecyclerView.setAdapter(adapter);
    }
}
