package com.daniru.tastystreeteats.adapter;

import android.view.LayoutInflater;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.daniru.tastystreeteats.databinding.PopulerItemBinding; // Correct class name based on XML

import java.util.List;

public class PopularAddapter extends RecyclerView.Adapter<PopularAddapter.PopularViewHolder> {

    private final List<String> items;
    private final List<String> prices;
    private final List<Integer> images;

    // Constructor
    public PopularAddapter(List<String> items, List<String> prices, List<Integer> images) {
        this.items = items;
        this.prices = prices;
        this.images = images;
    }

    @NonNull
    @Override
    public PopularViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        // Inflate layout using ViewBinding
        PopulerItemBinding binding = PopulerItemBinding.inflate(
                LayoutInflater.from(parent.getContext()), parent, false
        );
        return new PopularViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull PopularViewHolder holder, int position) {
        // Bind data to the ViewHolder
        holder.bind(items.get(position), prices.get(position), images.get(position));
    }

    @Override
    public int getItemCount() {
        // Return the size of the list
        return items.size();
    }

    // Inner ViewHolder class
    public static class PopularViewHolder extends RecyclerView.ViewHolder {

        private final PopulerItemBinding binding;

        public PopularViewHolder(@NonNull PopulerItemBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }

        public void bind(String item, String price, int imageRes) {
            // Set the data to the UI components
            binding.foodNamePopular.setText(item);
            binding.prizepopular.setText(price); // Ensure XML ID matches
            binding.imageView2.setImageResource(imageRes); // Ensure XML ID matches
        }
    }
}
