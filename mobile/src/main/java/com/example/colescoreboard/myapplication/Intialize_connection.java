package com.example.colescoreboard.myapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;

public class Intialize_connection extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_intialize_connection);

//        String ipn = getIntent().getStringExtra("IP address").toString();
//
//       // initialize(ip);
//
//       try{
//
//            Socket clientSocket = new Socket(ipn, 55155);
//
//            BufferedReader input;
//
//            input = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
//
//            DataOutputStream output;
//
//            output = new DataOutputStream(clientSocket.getOutputStream());
//
//            String t = "Hello there!";
//            output.writeBytes("intialize;" + t + "\n");
//
//
//
//            //String responseFromServer = input.readLine();
//
//            //readingin = requestFromClient.split(";");
//
//            //System.out.println(responseFromServer);
//
//
//           // clientSocket.close();
//        }
//
//        catch(IOException e)
//        {
//            e.printStackTrace();
//            Log.d("In con", "Error");
//        }
//
//
//        Intent intent = new Intent(this, baseball_game_manager.class);
//
//        intent.putExtra("IP address", ipn);
//
//        startActivity(intent);
//    }
//
//
//    public void initialize(String ipn) {
//        // Boolean retval = false;
//        //try{
//
//            //Socket clientSocket = new Socket(ipn, 5555);
//
////            BufferedReader input;
////
////            input = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
////
////            DataOutputStream output;
////
////            output = new DataOutputStream(clientSocket.getOutputStream());
////
////            String t = "Hello there!";
////            output.writeBytes("intialize;" + t + "\n");
//
//
//
//            //String responseFromServer = input.readLine();
//
//            //readingin = requestFromClient.split(";");
//
//            //System.out.println(responseFromServer);
//
//
//            //clientSocket.close();
////        }
////
////        catch(IOException e)
////        {
//            Log.d("In con", "Error");
//        //}
//        // return retval;
//        //DataOutputStream toCodeDoc = new DataOutputStream(clientSocket.getOutputStream());
//        //BufferedReader inFromServer = new BufferedReader(new InputStream().)
    }
}
