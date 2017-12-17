//cole sitzberger
package com.example.colescoreboard.myapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class SportSelect extends AppCompatActivity {

    Button bb;
    Button sc;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sport_select);

        bb = (Button) findViewById(R.id.Baseball);
        sc = (Button) findViewById(R.id.Soccer);

                bb.setOnClickListener(new View.OnClickListener()
        {

            @Override
            public void onClick(View arg0) {
                String ipaddress = getIntent().getStringExtra("IP address");

               // ListView a = (ListView)findViewById(R.id.atbat);

                String ab = "home";
                //a.getSelectedItem().toString();

                // = abList.getSelectedItem().toString();

                sportclient myClient = new sportclient(ipaddress,"baseball");
                myClient.execute();

                baseballclick();
            }
        });
        sc.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View arg0) {
                String ipaddress = getIntent().getStringExtra("IP address");

                // ListView a = (ListView)findViewById(R.id.atbat);

                String ab = "home";
                //a.getSelectedItem().toString();

                // = abList.getSelectedItem().toString();

                sportclient myClient = new sportclient(ipaddress,"soccer");
                myClient.execute();

                soccerclick();
            }
        });
    }

    void soccerclick()
    {
        String i = getIntent().getStringExtra("IP address");
        Intent ipintent = new Intent(this, soccer_game_manager.class);

        ipintent.putExtra("IP address", i);

        startActivity(ipintent);
    }
    void baseballclick()
    {
        String i = getIntent().getStringExtra("IP address");
        Intent ipintent = new Intent(this, baseball_game_manager.class);

        ipintent.putExtra("IP address", i);

        startActivity(ipintent);
    }
}
