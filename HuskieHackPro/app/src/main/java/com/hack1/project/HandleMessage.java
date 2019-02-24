package com.hack1.project;

import android.os.AsyncTask;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.util.ArrayList;

public class HandleMessage extends AsyncTask<String,Void, ArrayList<String>> {
    public static final String RETRIVEURL = "https://named-sequencer-226302.appspot.com/retrive";
    public static final String INSERTURL = "https://named-sequencer-226302.appspot.com/createM";
    private boolean insert;
    private MessageRequestResult callingClass;


    public HandleMessage(MessageRequestResult callingClass,boolean insert){
        this.callingClass=callingClass;
        this.insert=insert;

    }

    @Override
    protected void onPostExecute(ArrayList<String> res) {
        callingClass.onMessageRequestResult(res,insert);
    }

    @Override
    protected ArrayList<String> doInBackground(String... strings) {
        ArrayList<String> res = new ArrayList<>();
        try {
            HttpURLConnection conn = (HttpURLConnection)new URL(insert ? INSERTURL : RETRIVEURL).openConnection();
            conn.setDoInput(true);
            conn.setDoOutput(true);
            conn.setRequestMethod("POST");
            String post = "";
            if(insert){
                post = URLEncoder.encode("message","UTF-8") + "=" + URLEncoder.encode(strings[1],"UTF-8") + "&" + URLEncoder.encode("time","UTF-8") + "=" + URLEncoder.encode(strings[0],"UTF-8");
            }
            else{
                post =   URLEncoder.encode("time","UTF-8") + "=" + URLEncoder.encode(strings[0],"UTF-8");

            }
            OutputStreamWriter writer = new OutputStreamWriter(conn.getOutputStream());
            System.out.println("POST IS HERE +" + post);
            writer.write(post);
            writer.flush();
            writer.close();
            BufferedReader reader = new BufferedReader(new InputStreamReader(conn.getInputStream()));
            String n;
            while ((n = reader.readLine()) != null) {
                if(n.indexOf("~~")!=-1) {
                    res.add(n);
                }
            }

        } catch (IOException e) {

        }

        return res;

    }


}

