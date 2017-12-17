//cole sitzberger
package com.example.colescoreboard.myapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;

public class RefMainGameScreen extends AppCompatActivity {

    String ipad;
    TextView response;
    EditText editTextAddress;
    Button buttonConnect;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ref_main_game_screen);

        editTextAddress = (EditText) findViewById(R.id.IPtext);
        buttonConnect = (Button) findViewById(R.id.IP_Confirm_Button);
        response = (TextView) findViewById(R.id.checkIP);


        buttonConnect.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View arg0) {
                Client myClient = new Client(editTextAddress.getText().toString(), 55155 , response);
                myClient.execute();

                moveOn(editTextAddress.getText().toString());

//                Intent ipintent = new Intent(this, baseball_game_manager.class);
//                ipintent.putExtra("IP address", editTextAddress.getText().toString());
//                startActivity(ipintent);

            }
        });
    }
//    public void onClick(View arg0) {
//          Client myClient = new Client(editTextAddress.getText().toString(), 55155 , response);
//          myClient.execute();
//
//        // moveOn(editTextAddress.getText().toString());
//
//
//                 Intent ipintent = new Intent(this, baseball_game_manager.class);
//                ipintent.putExtra("IP address", editTextAddress.getText().toString());
//
//                startActivity(ipintent);
//
//
//    }
           void moveOn(String i)
        {
           //Intent ipintent = new Intent(this, baseball_starter.class);
            Intent ipintent = new Intent(this, SportSelect.class);

            ipintent.putExtra("IP address", i);

            startActivity(ipintent);
        }

}
