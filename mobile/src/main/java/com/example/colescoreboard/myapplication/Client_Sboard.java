//cole sitzberger
package com.example.colescoreboard.myapplication;

import android.os.AsyncTask;
import android.widget.Button;
import android.widget.TextView;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;
import java.net.UnknownHostException;



public class Client_Sboard extends AsyncTask<Void, Void, Void> {


//This class is used to establish the intial connection with the scoreboard

    //AsyncTask allows the app to work on wifi channels that do have a strict NAT type


    String dstAddress;
    int dstPort;
    String response = "";
    TextView textResponse;
    String sports;

    String sOne = "";
    String sTwo = "";
    Button baseball;

    Client_Sboard(String addr, int port, TextView textResponse) {
        dstAddress = addr;
        dstPort = port;
        this.textResponse=textResponse;
    }
    Client_Sboard(String addr, String prefx) {
        dstAddress = addr;

        sports = prefx;
    }
    Client_Sboard(String addr, String prefx, String i, String ii) {
        dstAddress = addr;

        sports = prefx;
        sOne = i;
        sTwo = ii;
    }
    @Override
    protected Void doInBackground(Void... arg0) {

        Socket socket = null;

        try {
            socket = new Socket(dstAddress, 55155);

            BufferedReader input;

            input = new BufferedReader(new InputStreamReader(socket.getInputStream()));

            DataOutputStream output;

            output = new DataOutputStream(socket.getOutputStream());

            if(sports == "start soccer clock") {
                String t = new String("" + sports + "\n");
                output.writeBytes(t);
            }
           else if(sports == "update soccer")
            {
                String t = new String(sports +"/"+ sOne+"/"+sTwo+"/"+"\n");
                output.writeBytes(t);
            }


            //	ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream(
            //			1024);
            //	byte[] buffer = new byte[1024];

            //	int bytesRead;
            //	InputStream inputStream = socket.getInputStream();

			/*
			 * notice: inputStream.read() will block if no data return
			 */
            //	while ((bytesRead = inputStream.read(buffer)) != -1)
            //	{
            //		byteArrayOutputStream.write(buffer, 0, bytesRead);
            //		response += byteArrayOutputStream.toString("UTF-8");
            //	}

        }
        catch (UnknownHostException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
            response = "UnknownHostException: " + e.toString();
        }
        catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
            response = "IOException: " + e.toString();
        }
        finally {
            if (socket != null) {
                try {
                    socket.close();
                } catch (IOException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
            }
        }
        return null;
    }

    @Override
    protected void onPostExecute(Void result) {
//        textResponse.setText(response);
        //      super.onPostExecute(result);
    }

}


