package com.example.nazi.practice.Examples;

import android.content.Intent;
import android.icu.text.NumberFormat;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.nazi.practice.R;

import java.net.URI;

public class MainActivity extends AppCompatActivity{
    int quantity =2;
    private CheckBox whippedCreamid;
    private CheckBox chocolateid;
    private EditText ed1;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }

        public void increment(View view){
            if(quantity<100)
            {   quantity = quantity + 1;
                displayQuantity(quantity);
            }
            else {
                Toast.makeText(getApplicationContext(),"Quantity is too large ",Toast.LENGTH_SHORT).show();
            }
    }
    public void decrement(View view){
        if(quantity>1)
        {
            quantity= quantity-1;
            displayQuantity(quantity);
        }
        else {
            Toast.makeText(getApplicationContext(),"Quantity cannot be less than 1 cup of coffees",Toast.LENGTH_SHORT).show();
        }

    }
    public void submitOrder(View view){


        ed1 = findViewById(R.id.editText);
        String name =ed1.getText().toString().trim();

        chocolateid=findViewById(R.id.chocolate);
        Log.v("MainActivity","Name :"+name);
        boolean haschocolate =chocolateid.isChecked();

        whippedCreamid =findViewById(R.id.checkBox);
        boolean hasWhippedCream=whippedCreamid.isChecked();
        Log.v("MainActivity","Has Whipped Cream "+hasWhippedCream);//Log method shows the output i9n android monitors

        int price =calculatePrice(haschocolate,haschocolate);
       String body=(createSummaryOrder(price,hasWhippedCream,haschocolate,name));
        Intent emailIntent = new Intent(Intent.ACTION_SENDTO);
        emailIntent.setType("*/*");
        emailIntent.setData(Uri.parse("mailto:"));//only email app will handle this
        emailIntent.putExtra(Intent.EXTRA_SUBJECT,"Order Bill");
        emailIntent.putExtra(Intent.EXTRA_TEXT,body);
        if(emailIntent.resolveActivity(getPackageManager())!=null)
        {
            startActivity(emailIntent);
        }
        else
        {
            Toast.makeText(getApplicationContext(),"Gmail app is not install ",Toast.LENGTH_SHORT).show();
        }

       /* Intent emailIntent = new Intent(Intent.ACTION_SENDTO, Uri.fromParts("mailto","",null));
        emailIntent.putExtra(Intent.EXTRA_SUBJECT,"ORDER BILL");
        emailIntent.putExtra(Intent.EXTRA_TEXT,body);

        startActivity(Intent.createChooser(emailIntent, "Send email..."));

        if(emailIntent.resolveActivity(getPackageManager())!=null)
        {
            startActivity(Intent.createChooser(emailIntent, "Send email..."));
        }
        else
            Toast.makeText(this,"Gmail App is not installed",Toast.LENGTH_SHORT).show();*/
        //OR
     /*String priceMessage = createSummaryOrder(price);
       displayMessage(priceMessage);*/

    }
    // tO calculate price of order
    //returning total price
    private int calculatePrice(boolean addwhippedcreamid,boolean addchocolateid)
    {
        int basePrice =5;



            if(addchocolateid){
                basePrice=basePrice+1;
            }
            if(addchocolateid){
                basePrice=basePrice+2;
            }




            // OR
            // int price = quantity *5;
            // return price;



        return quantity*basePrice;

    }

    private String createSummaryOrder(int price,boolean addWhippedCream,boolean addchocolate,String addname)
    {

        String priceMessage =getString(R.string.order_summary_name);
        priceMessage =priceMessage +"\nQuantity :"+ quantity;
        priceMessage+="\nWhipped Cream is added :"+addWhippedCream;
        priceMessage+="\nChocolate is added :"+addchocolate;

        priceMessage =priceMessage + "\nTotal : $"+price+"\n"+getString(R.string.Thanku);
                return priceMessage;

    }
    //This method display quantity value on the screen
    private void displayQuantity(int numofcoffees)
    {
        TextView quantity = findViewById(R.id.quantity_text_view);
        quantity.setText(""+numofcoffees);

    }

    private void displayMessage(String message)
    {
        TextView orderSummaryTextView = findViewById(R.id.order_summary_text_view);
        orderSummaryTextView.setText(message);
    }
}
