package com.example.justjava;


import android.annotation.SuppressLint;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import org.w3c.dom.Text;

import java.net.URI;

public class MainActivity extends AppCompatActivity {
        int quantityValue=0;
        int pricePerCup=5;
        boolean hasWhippedCream=false;
    boolean hasChocolateTopping=false;

    @Override
        public  void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        TextView lastButtonView=(TextView)findViewById(R.id.baseline_order_text_view);
        lastButtonView.setText("Order");

//         var quantityValueTextView = findViewById<TextView>(R.id.quantityValue)

//        INTENT TRyout
//        Maps intent  creation
//        Uri geoLocation= Uri.parse("geo:47.6,-122.3");
//        Intent intent = new Intent(Intent.ACTION_VIEW);
//        intent.setData(geoLocation);
//        if(intent.resolveActivity(getPackageManager())!=null){ //checks if app on phone is able to deal with maps intent
//            startActivity(intent);
//        }


        }

        /**
         * This method is called when the + button is clicked.
         */
        public void increment(View view) {
//        display(1)
//        TextView quantityValueTextView = (TextView)findViewById(R.id.quantityValue);
//        update the price base on increment/decrement function
            CheckBox whippedCream=(CheckBox) findViewById(R.id.checkbox_whipped_cream);
            hasWhippedCream=whippedCream.isChecked();

            CheckBox chocolate=(CheckBox) findViewById(R.id.checkbox_chocolate);
            hasChocolateTopping=chocolate.isChecked();
            if(quantityValue<101)
            {quantityValue+=1;}
            else{
                Toast.makeText(this.getApplicationContext(),"Max number of coffee orders is 100",Toast.LENGTH_SHORT).show();
            }
            if(hasWhippedCream || hasChocolateTopping)
                isToppingSelected();

//        quantityValueTextView.setText(quantityValue+"");
        //displaying Price based on updated quantity and price set to 5
        displayQuantity(quantityValue);
        }

        /**
         * This method is called when the - button is clicked.
         */
        public void decrement(View view){
            TextView quantityValueTextView =(TextView)findViewById(R.id.quantityValue);
            if(quantityValue>1)
                quantityValue-=1;
            else{
                Toast toast= Toast.makeText(this,"You cannot go below this",Toast.LENGTH_SHORT);
                toast.show();
                return ;
            }
            CheckBox whippedCream=(CheckBox) findViewById(R.id.checkbox_whipped_cream);
            hasWhippedCream=whippedCream.isChecked();

            CheckBox chocolate=(CheckBox) findViewById(R.id.checkbox_chocolate);
            hasChocolateTopping=chocolate.isChecked();
            if(hasWhippedCream || hasChocolateTopping)
                isToppingSelected();


//            isToppingSelected();
            displayQuantity(quantityValue);
//            quantityValueTextView.setText(quantityValue+"");
//        update the price base on increment/decrement function
//            displayPrice(quantityValue);
        }

        @SuppressLint("SetTextI18n")
        public void displayPrice(int number){
            TextView priceTextViewValue= (TextView)findViewById(R.id.priceValue);
            priceTextViewValue.setText("$"+number);

        }

        private void isToppingSelected(){

            if(hasWhippedCream){
                Toast.makeText(this,"Whipped Cream added .. Price per cup increased by 1",Toast.LENGTH_SHORT).show();
                pricePerCup+=1;
            }
//            if(hasWhippedCream==false){
//                pricePerCup-=1;
//            }
            if(hasChocolateTopping){
                Toast.makeText(this,"Chocolate cream added .. Price per cup increased by 2",Toast.LENGTH_SHORT).show();
                pricePerCup+=2;
            }
//            if(hasChocolateTopping==false)
//                pricePerCup-=1;
            displayPrice(pricePerCup);

        }

        /**
         * This method displays the given quantity value on the screen.
         */
//    @SuppressLint("SetTextI18n")
    private void displayQuantity(int number) {
        TextView quantityValueTextView = findViewById(R.id.quantityValue);
//        update the price base on increment/decrement function
        quantityValueTextView.setText(quantityValue+"");
        //displaying Price based on updated quantity and price set to 5
        displayPrice(number*pricePerCup);
    }



private void displayMessage(String message) {
        TextView orderSummaryTextView = (TextView) findViewById(R.id.order_summary_text_view);
    orderSummaryTextView.setText(message);
    TextView orderBaseLineTextView = (TextView) findViewById(R.id.baseline_order_text_view);
    orderBaseLineTextView.setText("Order Status: Order Complete");
        }

    public void submitOrder(View view){
//        TextView quantityValueTextView= (TextView)findViewById(R.id.quantityValue);
//        String toast="Order of "+quantityValue +"coffee is placed successfully \nThank You!";
//        val lastButtonView=findViewById<TextView>(R.id.baseline_order_text_view);
//        lastButtonView.text=toast
//        displayMessage(toast);
//        int price=calculatePrice();
//        displayPrice(price);
        //displays orderSummary at the last
//        CheckBox whippedCream=(CheckBox) findViewById(R.id.checkbox_whipped_cream);
//        hasWhippedCream=whippedCream.isChecked();
//
//        CheckBox chocolate=(CheckBox) findViewById(R.id.checkbox_chocolate);
//        hasChocolateTopping=chocolate.isChecked();

//       displayMessage(createOrderSummary());
        createOrderSummary();
    }

    private int calculatePrice(){
//        if(hasWhippedCream){
//            Toast.makeText(this,"Whipped Cream added .. Price per cup increased by 1",Toast.LENGTH_SHORT).show();
//            pricePerCup+=1;
//        }
//        if(hasChocolateTopping){
//            Toast.makeText(this,"Chocolate cream added .. Price per cup increased by 2",Toast.LENGTH_SHORT).show();
//            pricePerCup+=2;
//            displayPrice(pricePerCup);
//        }

        return quantityValue*pricePerCup;

    }

//    Creates summary of order
    private void createOrderSummary(){
        EditText nameText=(EditText) findViewById(R.id.nameOfPerson);
//      String summary=Name:"+nameText.getName()+Add whippedCream?"+hasWhippedCream+
//        Add Chocolate?"+hasChocolateTopping+Quantity:"+quantityValue+Total:$"+calculatePrice()
//        +Thank You!
        String summary=this.getString(R.string.orderSummaryName,nameText.getText().toString())+
                "\n"+this.getString(R.string.order_summary_whipped_cream,hasWhippedCream)+
                "\n"+this.getString(R.string.order_summary_chocolate,hasChocolateTopping)+
                "\n"+  this.getString(R.string.order_summary_quantity,quantityValue)+
                "\n"+ this.getString(R.string.order_summary_total,"$"+calculatePrice())+
                "\n"+this.getString(R.string.thank_you);

        //These lines selects and sets order summary for the current person.
        TextView orderSummaryTextView=(TextView) findViewById(R.id.order_summary_text_view);
         orderSummaryTextView.setText(summary);

        //This intent is trying to send mail of the current Coffee order.

        // this line just allows to send data to any app
        //Intent mailIntent=new Intent((Intent.ACTION_SEND));mailIntent.setType("*/*");

        Intent mailIntent=new Intent(Intent.ACTION_SENDTO);//line1
        mailIntent.setData(Uri.parse("mailto:"));//line2
        // lines 1 and 2 confirms only mailing app is selected for intent.
        mailIntent.putExtra(Intent.EXTRA_SUBJECT,"Just Java Order for "+nameText.getText());
        mailIntent.putExtra(Intent.EXTRA_TEXT,summary);

//        mailIntent.setType("*/*");
         if(mailIntent.resolveActivity(getPackageManager()) != null) {
            startActivity(mailIntent);
        }

//        return summary;

    }
        }