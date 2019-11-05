package com.example.gorbovshop_v2;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.TextView;

import com.example.gorbovshop_v2.model.CartItem;
import com.example.gorbovshop_v2.model.ShoppingCart;

import java.util.ArrayList;

public class CheckoutActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_checkout);
        displayOrderInfo();
    }

    private void displayOrderInfo() {
        Intent intent = getIntent();
        ShoppingCart cart = intent.getParcelableExtra("Cart");
        int shippingFees = intent.getIntExtra("Shipping Cost", 0);
        ArrayList<CartItem> itemList = cart.getItemList();

        TextView checkoutTextView = findViewById(R.id.checkout_textview);

        int cartSubtotal = cart.getCartSubtotal();
        double tps = cart.getCartSubtotal() * 0.05;
        double tvq = cart.getCartSubtotal() * 0.0975;
        double shippingTax = shippingFees * 0.0975 * 0.05;
        double total = cartSubtotal + shippingFees + tps + tvq + shippingTax;

        checkoutTextView.setText(String.format("%-25s%-10s%s", "Item", "Qty", "Price\n"));
        checkoutTextView.append("--------------------------------------------\n");

        if (!itemList.isEmpty()) {
            for (CartItem item : itemList) {
                checkoutTextView.append(String.format("\n%-26s%-10s%s\n", item.getItemName(), cart.getItemQtyById(item.getItemCode()), Integer.toString(item.getItemPrice())));
            }
            checkoutTextView.append(String.format("\n\n\n\n\nSubtotal: %d\nDelivery Fees: %d\nTPS: %.2f\nTVQ: %.2f\nTotal: %.2f$", cartSubtotal, shippingFees, tps, tvq, total));
        }

        checkoutTextView.append("\n\nThank you very much for using my application!\nHave a great day :)");
    }
}
