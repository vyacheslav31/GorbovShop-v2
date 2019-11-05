package com.example.gorbovshop_v2;

import android.os.Bundle;

import com.example.gorbovshop_v2.model.ItemCode;
import com.example.gorbovshop_v2.model.ShoppingCart;
import com.example.gorbovshop_v2.model.CartItem;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import java.util.ArrayList;

public class MenuActivity extends AppCompatActivity {

    private ShoppingCart mShoppingCart;
    private ArrayList<CartItem> mCartItems;
    private RecyclerView mRecyclerView;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);

        mCartItems = new ArrayList<CartItem>();
        mShoppingCart = new ShoppingCart();

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

        mRecyclerView = findViewById(R.id.recyclerView);
        mRecyclerView.setHasFixedSize(true);
        mLayoutManager = new LinearLayoutManager(this);
        mAdapter = new ShoppingAdapter(mCartItems, mShoppingCart);

        mRecyclerView.setLayoutManager(mLayoutManager);
        mRecyclerView.setAdapter(mAdapter);
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

    public void addToCart(View view) {
    }

    public void removeFromCart(View view) {
    }
}
