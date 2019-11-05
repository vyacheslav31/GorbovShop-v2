package com.example.gorbovshop_v2;

import android.content.Intent;
import android.os.Bundle;

import com.example.gorbovshop_v2.model.ItemCode;
import com.example.gorbovshop_v2.model.ShoppingCart;
import com.example.gorbovshop_v2.model.CartItem;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.DialogFragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import java.util.ArrayList;

public class MenuActivity extends AppCompatActivity implements ShippingDialog.SingleChoiceListener {

    // Declare members
    private ShoppingCart mShoppingCart;
    private ArrayList<CartItem> mCartItems;
    private RecyclerView mRecyclerView;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);

        // Create ArrayList and ShoppingCart for the RecyclerView
        mCartItems = new ArrayList<CartItem>();
        mShoppingCart = new ShoppingCart();

        // Add items to the arraylist
        mCartItems.add(new CartItem(
                R.drawable.avcadosld, ItemCode.AVCADOSLD));
        mCartItems.add(new CartItem(
                R.drawable.bfdumplings, ItemCode.BEEFDUMPLINGS));
        mCartItems.add(new CartItem(
                R.drawable.buttrchicken, ItemCode.BUTTRCHKN ));
        mCartItems.add(new CartItem(
                R.drawable.chkntacos, ItemCode.CHKNTACOS ));
        mCartItems.add(new CartItem(
                R.drawable.padthai, ItemCode.PADTHAI ));
        mCartItems.add(new CartItem(
                R.drawable.poutine, ItemCode.POUTINE ));
        mCartItems.add(new CartItem(
                R.drawable.saltpprchkn, ItemCode.SALTPPRCHKN ));
        mCartItems.add(new CartItem(
                R.drawable.stroganoff, ItemCode.BEEFSTRGNOFF ));
        mCartItems.add(new CartItem(
                R.drawable.sushiplat, ItemCode.SUSHIPLAT ));
        mCartItems.add(new CartItem(
                R.drawable.tmpurashrmp, ItemCode.TMPURASHRMP ));

        // Create layout manager, adapter and get recyclerview
        mRecyclerView = findViewById(R.id.recyclerView);
        mRecyclerView.setHasFixedSize(true);
        mLayoutManager = new LinearLayoutManager(this);
        mAdapter = new ShoppingAdapter(mCartItems, mShoppingCart);

        // Initialize the recycler view with layoutmanager and adapter
        mRecyclerView.setLayoutManager(mLayoutManager);
        mRecyclerView.setAdapter(mAdapter);

        // Create FAB
        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            // Create on Click
            @Override
            public void onClick(View view) {
                DialogFragment shippingOptionsDialog = new ShippingDialog();
                shippingOptionsDialog.setCancelable(false);
                shippingOptionsDialog.show(getSupportFragmentManager(), "Shipping Options");
            }
        });

    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }



    @Override
    public void onPositiveButtonClicked(String[] list, int position) {
        int shippingCost;
        // Get shipping cost
        switch (position) {
            case 0:
                shippingCost = 50;
                break;
            case 1:
                shippingCost = 10;
                break;
            case 3:
                shippingCost = 0;
                break;

                default:
                    shippingCost = 0;
        }
        // Submit shipping cost w/ the shopping cart
        Intent intent = new Intent(MenuActivity.this, CheckoutActivity.class);
        intent.putExtra("Shipping Cost", shippingCost);
        intent.putExtra("Cart", mShoppingCart);
        startActivity(intent);
    }

    @Override
    public void onNegativeButtonClicked() {

    }
}
