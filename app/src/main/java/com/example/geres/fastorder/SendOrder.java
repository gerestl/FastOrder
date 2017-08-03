package com.example.geres.fastorder;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class SendOrder extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_send_order);

        Bundle data = getIntent().getExtras();
        if(data == null){
            return;
        }
        String total = data.getString("Total");
        Toast.makeText(getApplicationContext(),"Total " + total,Toast.LENGTH_LONG).show();
        final TextView moneytv = (TextView) findViewById(R.id.moneytv);
        moneytv.setText(total);
    }
    //OnClick method for the order now button
    public void orderNow(View view) {

        Intent i = new Intent(this, MainActivity.class);
        startActivity(i);

    }
}
