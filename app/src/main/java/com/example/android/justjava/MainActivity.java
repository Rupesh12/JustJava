package com.example.android.justjava;


import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.text.NumberFormat;

/**
 * This app displays an order form to order coffee.
 */
public class MainActivity extends AppCompatActivity {
    int quantity = 0 ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    /**
     * This method is called when the order button is clicked.
     */
    public void submitOrder(View view) {

        CheckBox whipped_cream_topping = (CheckBox) findViewById(R.id.whipped_cream_checkbox);
        CheckBox choclate = (CheckBox) findViewById(R.id.choclate_checkbox);
        EditText name_text = (EditText) findViewById(R.id.name) ;
        String name = name_text.getText().toString() ;
        boolean cream = whipped_cream_topping.isChecked();
        boolean choc = choclate.isChecked();
        //String priceMessage = "Total: $ "+ price+"\nThank you !";

        int price = price(cream,choc) ;
        Log.v("MainActivity.java","name "+name);
        displayMessage(createOrderSummary(price,cream,choc,name));
    }
    /**
     * Method to calculate the price
     * **/
    private int price(boolean cream , boolean choc){
        int unit_price = 5 ;
        if(cream){
            unit_price++ ;
        }
        if(choc){
            unit_price = unit_price + 2 ;
        }
        return quantity * unit_price ;
    }
    /**
     * Method to create the order summary
     * @param price of the coffe
     * @return orderSummary
     * **/
    private String createOrderSummary(int price,boolean cream,boolean choclate, String name){
        return ("Name : "+name+"\nAdd Whipped Cream : " + cream+"\nAdd Choclate : "+choclate+"\nQuantity : "+quantity+"\nTotal : $ "+price+"\nThank You");
    }

    /**
     * This method displays the given quantity value on the screen.
     */
    private void displayQuantity(int number) {
        TextView quantityTextView = (TextView) findViewById(
                R.id.quantity_text_view);
        quantityTextView.setText("" + number);
    }
    

    public void increment(View view) {
        if(quantity<99)
        displayQuantity(++quantity);
        else{
            Context context = getApplicationContext();
            CharSequence text = "Sorry we can't let you die so soon.";
            int duration = Toast.LENGTH_SHORT;

            Toast toast = Toast.makeText(context, text, duration);
            toast.show();
        }
    }
    public void decrement(View view) {
        if(quantity>0)
            displayQuantity(--quantity);
        else{
            Context context = getApplicationContext();
            CharSequence text = "We don't make negative coffees";
            int duration = Toast.LENGTH_SHORT;

            Toast toast = Toast.makeText(context, text, duration);
            toast.show();
        }
    }


    /**
     * This method displays the given text on the screen.
     */
    private void displayMessage(String message) {
        TextView priceTextView = (TextView) findViewById(R.id.order_summary_text_view);
        priceTextView.setText(message);
    }





}