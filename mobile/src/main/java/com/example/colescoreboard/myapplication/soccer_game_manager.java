//cole sitzberger
package com.example.colescoreboard.myapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class soccer_game_manager extends AppCompatActivity {

    TextView homescore;
    TextView awayscore;
    Button us;
    Button sc;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_soccer_game_manager);

        homescore = (TextView) findViewById(R.id.SoccerScoreHome);
        awayscore = (TextView) findViewById(R.id.AwayScoreSoccer);
        us = (Button) findViewById(R.id.updatescore);
        sc = (Button) findViewById(R.id.startclock);

        sc.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View arg0) {
                String ipaddress = getIntent().getStringExtra("IP address");

                // ListView a = (ListView)findViewById(R.id.atbat);

                String ab = "home";
                //a.getSelectedItem().toString();

                // = abList.getSelectedItem().toString();

                Client_Sboard myClient = new  Client_Sboard(ipaddress,"start soccer clock");
                myClient.execute();
            }
        });
        us.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View arg0) {
                String ipaddress = getIntent().getStringExtra("IP address");

                // ListView a = (ListView)findViewById(R.id.atbat);

               String hs =homescore.getText().toString();
                String as =awayscore.getText().toString();

                Client_Sboard myClient = new  Client_Sboard(ipaddress,"update soccer",hs,as);
                myClient.execute();
            }
        });
    }



    void downscorehome(View theButton)
    {

        String homerun = homescore.getText().toString();
        int hr = Integer.parseInt(homerun);
        if(hr != 0)
        {
            hr=hr-1;
            homerun = Integer.toString(hr);
            homescore.setText(homerun);

        }
    }

    void upscorehome(View theButton)
    {
        String homerun = homescore.getText().toString();
        int hr = Integer.parseInt(homerun);

        hr=hr+1;
        homerun = Integer.toString(hr);

        homescore.setText(homerun);
    }

    void downscoreaway(View theButton)
    {

        String awayrun = awayscore.getText().toString();
        int ar = Integer.parseInt(awayrun);
        if(ar != 0)
        {
            ar=ar-1;
            awayrun = Integer.toString(ar);

           awayscore.setText(awayrun);

        }
    }
    void uprunaway(View theButton)
    {
        String awayrun = awayscore.getText().toString();
        int ar = Integer.parseInt(awayrun);

        ar=ar+1;
        awayrun = Integer.toString(ar);

        awayscore.setText(awayrun);
    }
}
