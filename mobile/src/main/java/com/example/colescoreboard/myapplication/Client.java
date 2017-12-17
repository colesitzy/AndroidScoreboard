//cole sitzberger
package com.example.colescoreboard.myapplication;

import java.io.BufferedReader;
import java.io.ByteArrayOutputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.Socket;
import java.net.UnknownHostException;
import android.os.AsyncTask;
import android.widget.TextView;

//This class is used to establish the intial connection with the scoreboard

//AsyncTask allows the app to work on wifi channels that do have a strict NAT type
public class Client extends AsyncTask<Void, Void, Void> {

    String dstAddress;
    int dstPort;
    String response = "";
    TextView textResponse;



    Client(String addr, int port, TextView textResponse) {
        dstAddress = addr;
        dstPort = port;
        this.textResponse=textResponse;
    }
    Client(String addr, int port,TextView textResponse, int sOne, int sTwo) {
        dstAddress = addr;
        dstPort = port;
        this.textResponse=textResponse;
    }
    @Override
    protected Void doInBackground(Void... arg0) {

        Socket socket = null;

        try {
            socket = new Socket(dstAddress, dstPort);

            BufferedReader input;

            input = new BufferedReader(new InputStreamReader(socket.getInputStream()));

            DataOutputStream output;

            output = new DataOutputStream(socket.getOutputStream());

            String t = new String("intialize/"+"Hello there"+"\n");
            output.writeBytes(t);

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
        textResponse.setText(response);
        super.onPostExecute(result);
    }

}
