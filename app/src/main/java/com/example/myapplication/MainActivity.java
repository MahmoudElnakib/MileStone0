package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;
import android.os.Bundle;
//import android.os.StrictMode;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
//import android.widget.TableLayout;
import android.widget.TextView;
//import android.widget.Toast;
import java.net.Socket;

public class MainActivity extends AppCompatActivity {

    EditText txtIP;
    EditText txtPort;
    EditText txtMSG;
    Button button1;

    //Socket s;
    //String str ;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        txtIP = (EditText) findViewById(R.id.txtIP);
        txtPort = (EditText) findViewById(R.id.txtPort);
        txtMSG = (EditText) findViewById(R.id.txtMSG);
        button1 = (Button) findViewById(R.id.button1);
        TextView txtView = (TextView) findViewById((R.id.textView10));

        button1.setOnClickListener(new View.OnClickListener() {



            public void onClick(View view) {
                Log.d("test","Hi");

                Thread t = new Thread(new Runnable(){
                    @Override
                    public void run() {

                        try {
                            Log.d("test","Hi2");
                            Socket s = new Socket(txtIP.getText().toString(),Integer.parseInt(txtPort.getText().toString()));
                            Log.d("test","Hi3");
                            DataOutputStream x = new DataOutputStream(s.getOutputStream());
                            x.writeUTF(txtMSG.getText().toString());
                            DataInputStream in =new DataInputStream(s.getInputStream());
                            String str = in.readUTF();
                            //x.flush();
                            //InputStreamReader in = new InputStreamReader(s.getInputStream());
                            //BufferedReader bf = new BufferedReader(in);
                            Log.d("test","Hi4");
                            //String str = bf.readLine()
                            txtView.setText(str);
                            //Toast.makeText(
                                    //getApplicationContext(),"" + str , Toast.LENGTH_LONG).show();
                            //System.out.println("server: " + str);
                            //Log.d("test", str);
                            //x.close();
                            //s.close();


                        } catch (IOException e) {
                            e.printStackTrace();
                        }

                    }
                });
                t.start();
            }
        });




    }
}
