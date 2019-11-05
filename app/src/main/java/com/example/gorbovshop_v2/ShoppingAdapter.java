package com.example.gorbovshop_v2;


import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.gorbovshop_v2.model.CartItem;
import com.example.gorbovshop_v2.model.ShoppingCart;

import org.w3c.dom.Text;

import java.util.ArrayList;

public class ShoppingAdapter extends RecyclerView.Adapter<ShoppingAdapter.ShoppingViewHolder> {
    private ArrayList<CartItem> mCartItems;
    private ShoppingCart mShoppingCart;

    public ShoppingAdapter(ArrayList<CartItem> itemList, ShoppingCart shoppingCart) {
        mCartItems = itemList;
        mShoppingCart = shoppingCart;
    }

    @NonNull
    @Override
    public ShoppingViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.menu_item, parent, false);
        ShoppingViewHolder svh = new ShoppingViewHolder(v);
        return svh;
    }

    @Override
    public void onBindViewHolder(@NonNull ShoppingViewHolder holder, int position) {
        final CartItem currentItem = mCartItems.get(position);

        holder.cardImage.setImageResource(currentItem.getImageResource());
        holder.vendorImage.setImageResource(currentItem.getImageResource());
        holder.cardTitle.setText(currentItem.getItemName());
        holder.cardDescription.setText(currentItem.getItemDescription());
        holder.cardPrice.setText(Integer.toString(currentItem.getItemPrice()));

        holder.addToCartButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Declare variables
                TextView quantity;
                TextView subtotal;

                mShoppingCart.addItem(currentItem);

                // Get layout
                ViewGroup layout = (ViewGroup) view.getParent();

                // Get subtotal and quantity
                quantity = (TextView) layout.getChildAt(7);
                subtotal = (TextView) layout.getChildAt(8);

                quantity.setText("Quantity: " + mShoppingCart.getItemCountById(currentItem.getItemCode()));
                subtotal.setText("Subtotal: " + mShoppingCart.getItemCountById(currentItem.getItemCode()) * currentItem.getItemPrice());
            }
        });

        holder.removeFromCartButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (mShoppingCart.removeItem(currentItem)) {
                    // Declare variables
                    TextView quantity;
                    TextView subtotal;

                    // Get layout
                    ViewGroup layout = (ViewGroup) view.getParent();

                    // Get subtotal and quantity
                    quantity = (TextView) layout.getChildAt(7);
                    subtotal = (TextView) layout.getChildAt(8);

                    quantity.setText("Quantity: " + mShoppingCart.getItemCountById(currentItem.getItemCode()));
                    subtotal.setText("Subtotal: " + mShoppingCart.getItemCountById(currentItem.getItemCode()) * currentItem.getItemPrice());
                }
            }
        });

    }

    @Override
    public int getItemCount() {
        return mCartItems.size();
    }

    public static class ShoppingViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
        public ImageView vendorImage;
        public ImageView cardImage;
        public TextView cardTitle;
        public TextView cardPrice;
        public TextView cardDescription;
        public TextView cardQuantity;
        public TextView cardSubtotal;
        public Button addToCartButton;
        public Button removeFromCartButton;


        public ShoppingViewHolder(@NonNull View itemView) {
            super(itemView);
            vendorImage = itemView.findViewById(R.id.vendor_image);
            cardImage = itemView.findViewById(R.id.card_image);
            cardTitle = itemView.findViewById(R.id.card_title);
            cardPrice = itemView.findViewById(R.id.card_price);
            cardDescription = itemView.findViewById(R.id.card_description);
            cardQuantity = itemView.findViewById(R.id.card_quantity);
            cardSubtotal = itemView.findViewById(R.id.card_subtotal);
            addToCartButton = itemView.findViewById(R.id.addToCart_button);
            removeFromCartButton = itemView.findViewById(R.id.removeFromCart_button);
        }

        @Override
        public void onClick(View view) {

            switch(this.getLayoutPosition()) {

            }
        }
    }
}
