package com.example.geres.fastorder;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.PictureDrawable;
import android.nfc.Tag;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.TextView.OnEditorActionListener;
import android.widget.Toast;

import static java.lang.System.in;


public class MainActivity extends AppCompatActivity implements OnEditorActionListener, OnClickListener {


    //define widget variables
    private EditText cmb_oneET;
    private EditText cmb_twoET;
    private EditText cmb_threeET;
    private Button readyToOrder;

    private String qtyOne, qtyTwo, qtyThree = "";
    public float total = 0f;


    //private SharedPreferences savedValues;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //get reference to the widgets
        cmb_oneET = (EditText) findViewById(R.id.cmb_oneET);
        cmb_twoET = (EditText) findViewById(R.id.cmb_twoET);
        cmb_threeET = (EditText) findViewById(R.id.cmb_threeET);
        readyToOrder = (Button) findViewById(R.id.readytoorder);

        //set listener for thew event
        cmb_oneET.setOnEditorActionListener(this);
        cmb_twoET.setOnEditorActionListener(this);
        cmb_threeET.setOnEditorActionListener(this);
        readyToOrder.setOnClickListener(this);

        //savedValues = getSharedPreferences("SavedValues", MODE_PRIVATE);


    }

    private void calculateTotal() {
        //get the quantities from the user
        qtyOne = cmb_oneET.getText().toString();
        qtyTwo = cmb_twoET.getText().toString();
        qtyThree = cmb_threeET.getText().toString();


        float firstQuantity, secondQuantity, thirdQuantity;
        if (qtyOne.equals("")) {
            firstQuantity = 0;
        } else {
            firstQuantity = Float.parseFloat(qtyOne);
        }
        if (qtyTwo.equals("")) {
            secondQuantity = 0;
        } else {
            secondQuantity = Float.parseFloat(qtyTwo);
        }
        if (qtyThree.equals("")) {
            thirdQuantity = 0;
        } else {
            thirdQuantity = Float.parseFloat(qtyThree);
        }

        //prices of combos
        float burgerOnePrice = (float) 6.99;
        float burgerTwoPrice = (float) 5.99;
        float burgerThreePrice = (float) 4.99;

        float subtotal1 = firstQuantity * burgerOnePrice;
        float subtotal2 = secondQuantity * burgerTwoPrice;
        float subtotal3 = thirdQuantity * burgerThreePrice;

        total = subtotal1 + subtotal2 + subtotal3;
        //Log.d(TAG, "Total:" + total);
    }

//    /*public void fastorder(View view ) {
//        calculateTotal(total);
//        Toast.makeText(getApplicationContext(),"Total1"+total,Toast.LENGTH_LONG).show();
//
//        Intent i = new Intent(this, SendOrder.class);
//        i.putExtra("Total",total);
//        Toast.makeText(getApplicationContext(),"Total2"+total,Toast.LENGTH_LONG).show();
//
//
//        startActivity(i);
//
//    }*/

    @Override
    public boolean onEditorAction(TextView textView, int i, KeyEvent keyEvent) {
        return false;
    }

    @Override
    public void onClick(View view) {
        calculateTotal();
        Toast.makeText(getApplicationContext(), "Total " + total, Toast.LENGTH_LONG).show();

        Intent i = new Intent(this, SendOrder.class);

        i.putExtra("Total", total);
        startActivity(i);

    }
}

