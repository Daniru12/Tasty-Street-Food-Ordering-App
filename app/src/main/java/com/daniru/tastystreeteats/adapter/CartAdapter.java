package com.daniru.tastystreeteats.adapter;

import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.daniru.tastystreeteats.databinding.CartItemBinding;

import java.util.Arrays;
import java.util.List;

public class CartAdapter extends RecyclerView.Adapter<CartAdapter.CartViewHolder> {

    private final List<String> cartItems;
    private final List<String> cartItemPrices;
    private final List<Integer> cartImages;
    private final int[] itemQuantities;

    public CartAdapter(List<String> cartItems, List<String> cartItemPrices, List<Integer> cartImages) {
        this.cartItems = cartItems;
        this.cartItemPrices = cartItemPrices;
        this.cartImages = cartImages;
        this.itemQuantities = new int[cartItems.size()];
        Arrays.fill(this.itemQuantities, 1); // Initialize all quantities to 1
    }

    @NonNull
    @Override
    public CartViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        // Inflate the layout using CartItemBinding
        CartItemBinding binding = CartItemBinding.inflate(LayoutInflater.from(parent.getContext()), parent, false);
        return new CartViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull CartViewHolder holder, int position) {
        holder.bind(position);
    }

    @Override
    public int getItemCount() {
        return cartItems.size();
    }

    // Inner ViewHolder class
    public class CartViewHolder extends RecyclerView.ViewHolder {
        private final CartItemBinding binding;

        public CartViewHolder(@NonNull CartItemBinding binding) {
            super(binding.getRoot());
            this.binding = binding;

            // Set onClickListeners for buttons
            binding.minusbutton.setOnClickListener(v -> decreaseQuantity(getAdapterPosition()));
            binding.plusbutton.setOnClickListener(v -> increaseQuantity(getAdapterPosition()));
            binding.deleteButton.setOnClickListener(v -> deleteItem(getAdapterPosition()));
        }

        public void bind(int position) {
            binding.cardFoodName.setText(cartItems.get(position));
            binding.CardItemPrice.setText(cartItemPrices.get(position)); // Corrected here
            binding.cartImage.setImageResource(cartImages.get(position));
            binding.itemQuantity.setText(String.valueOf(itemQuantities[position]));
        }

        private void decreaseQuantity(int position) {
            if (itemQuantities[position] > 1) {
                itemQuantities[position]--;
                binding.itemQuantity.setText(String.valueOf(itemQuantities[position]));
            }
        }

        private void increaseQuantity(int position) {
            if (itemQuantities[position] < 10) {
                itemQuantities[position]++;
                binding.itemQuantity.setText(String.valueOf(itemQuantities[position]));
            }
        }

        private void deleteItem(int position) {
            cartItems.remove(position);
            cartItemPrices.remove(position);
            cartImages.remove(position);
            notifyItemRemoved(position);
            notifyItemRangeChanged(position, cartItems.size());
        }
    }
}
