package com.example.gorbovshop_v2;

import android.os.Bundle;

import com.example.gorbovshop_v2.model.ItemCode;
import com.example.gorbovshop_v2.model.ShoppingCart;
import com.example.gorbovshop_v2.model.CartItem;

import androidx.appcompat.app.AppCompatActivity;

import android.view.Menu;
import android.view.MenuItem;

public class MenuActivity extends AppCompatActivity {

    private ShoppingCart shoppingCart;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);

        shoppingCart = new ShoppingCart();

        shoppingCart.addItem(new CartItem(
                R.drawable.avcadosld, ItemCode.AVCADOSLD));
        shoppingCart.addItem(new CartItem(
                R.drawable.bfdumplings, ItemCode.BEEFDUMPLINGS));
        shoppingCart.addItem(new CartItem(
                R.drawable.buttrchicken, ItemCode.BUTTRCHKN ));
        shoppingCart.addItem(new CartItem(
                R.drawable.chkntacos, ItemCode.CHKNTACOS ));
        shoppingCart.addItem(new CartItem(
                R.drawable.padthai, ItemCode.PADTHAI ));
        shoppingCart.addItem(new CartItem(
                R.drawable.poutine, ItemCode.POUTINE ));
        shoppingCart.addItem(new CartItem(
                R.drawable.saltpprchkn, ItemCode.SALTPPRCHKN ));
        shoppingCart.addItem(new CartItem(
                R.drawable.stroganoff, ItemCode.BEEFSTRGNOFF ));
        shoppingCart.addItem(new CartItem(
                R.drawable.sushiplat, ItemCode.SUSHIPLAT ));
        shoppingCart.addItem(new CartItem(
                R.drawable.tmpurashrmp, ItemCode.TMPURASHRMP ));
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
}
