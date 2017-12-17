//cole sitzberger
package com.example.colescoreboard.myapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class baseball_game_manager extends AppCompatActivity {


    TextView awayruns;
    TextView homeruns;
    TextView outs;
    TextView strikes;
    TextView balls;
    TextView innings;
    Button update;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_baseball_game_manager);

        awayruns = (TextView) findViewById(R.id.scoreviewaway);
        homeruns = (TextView) findViewById(R.id.scoreviewhome);
        outs = (TextView) findViewById(R.id.outview);
        strikes = (TextView) findViewById(R.id.strikesview);
        balls = (TextView) findViewById(R.id.ballview);
        innings = (TextView) findViewById(R.id.inningview);
        update = (Button) findViewById(R.id.updateb);

        List<String> teamsab = new ArrayList< String >();

        teamsab.add("HOME");
        teamsab.add("AWAY");


        update.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View arg0) {
                String ipaddress = getIntent().getStringExtra("IP address");

                String homerun = homeruns.getText().toString();

                String awayrun = awayruns.getText().toString();

                String s = strikes.getText().toString();

                String b = balls.getText().toString();

                String o = outs.getText().toString();

                String i = innings.getText().toString();

               // ListView a = (ListView)findViewById(R.id.atbat);

                String ab = "home";
                        //a.getSelectedItem().toString();

               // = abList.getSelectedItem().toString();

                Client_BBboard myClient = new Client_BBboard(ipaddress, homerun, awayrun, o, b, s, i);
                myClient.execute();

            }
        });
    }



    void downrunhome(View theButton)
    {

        String homerun = homeruns.getText().toString();
        int hr = Integer.parseInt(homerun);
        if(hr != 0)
        {
           hr=hr-1;
           homerun = Integer.toString(hr);
           update();
           homeruns.setText(homerun);

        }
    }

    void uprunhome(View theButton)
    {
        String homerun = homeruns.getText().toString();
        int hr = Integer.parseInt(homerun);

        hr=hr+1;
        homerun = Integer.toString(hr);
        update();
        homeruns.setText(homerun);
    }

    void downrunaway(View theButton)
    {

        String awayrun = awayruns.getText().toString();
        int ar = Integer.parseInt(awayrun);
        if(ar != 0)
        {
            ar=ar-1;
            awayrun = Integer.toString(ar);
            update();
            awayruns.setText(awayrun);

        }
    }
    void uprunaway(View theButton)
    {
        String awayrun = awayruns.getText().toString();
        int ar = Integer.parseInt(awayrun);

        ar=ar+1;
        awayrun = Integer.toString(ar);
        update();
        awayruns.setText(awayrun);
    }
    //these funtions control the balls strikes and out veiw with a buttom to quickly reset the
    // fields to zero
    void downstrikes(View theButton)
    {

        String s = strikes.getText().toString();
        int st = Integer.parseInt(s);
        if(st != 0)
        {
            st=st-1;
            s = Integer.toString(st);
            update();
            strikes.setText(s);

        }
    }
    void upstrikes(View theButton)
    {  String s = strikes.getText().toString();
        int st = Integer.parseInt(s);
        if(st != 2)
        {
            st=st+1;
            s = Integer.toString(st);
            update();
            strikes.setText(s);

        }
    }
    void zerostrikes(View theButton) {
        String s = strikes.getText().toString();
        int st = Integer.parseInt(s);

        st = 0;
        s = Integer.toString(st);
        update();
        strikes.setText(s);

    }
    void downball(View theButton)
    {

        String b = balls.getText().toString();
        int bt = Integer.parseInt(b);
        if(bt != 0)
        {
            bt=bt-1;
            b = Integer.toString(bt);
            update();
            balls.setText(b);

        }
    }
    void upball(View theButton)
    {  String b = balls.getText().toString();
        int bt = Integer.parseInt(b);
        if(bt != 3)
        {
            bt=bt+1;
            b = Integer.toString(bt);
            update();
            balls.setText(b);

        }
    }
    void zeroball(View theButton) {
        String b = balls.getText().toString();
        int bt = Integer.parseInt(b);

        bt = 0;
        b = Integer.toString(bt);
        update();
        balls.setText(b);

    }

    void downouts(View theButton)
    {

        String o = outs.getText().toString();
        int ot = Integer.parseInt(o);
        if(ot != 0)
        {
            ot=ot-1;
            o = Integer.toString(ot);
            update();
            outs.setText(o);

        }
    }
    void upouts(View theButton)
    {  String o = outs.getText().toString();
        int ot = Integer.parseInt(o);
        if(ot != 2)
        {
            ot=ot+1;
            o = Integer.toString(ot);
            update();
            outs.setText(o);

        }
    }
    void zeroouts(View theButton) {
        String o = outs.getText().toString();
        int ot = Integer.parseInt(o);

        ot = 0;
        o = Integer.toString(ot);
        update();
        outs.setText(o);

    }
    void downinnings(View theButton)
    {

        String i = innings.getText().toString();
        int it = Integer.parseInt(i);
        if(it != 1)
        {
            it=it-1;
            i= Integer.toString(it);
            update();
            innings.setText(i);

        }
    }
    void upinnings(View theButton)
    {
        String i = innings.getText().toString();
        int it = Integer.parseInt(i);

        it = it + 1;
        i = Integer.toString(it);
        update();
        innings.setText(i);
    }

    void update()
    {

    }
}


