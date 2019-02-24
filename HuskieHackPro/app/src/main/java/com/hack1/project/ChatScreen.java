package com.hack1.project;

import android.os.Handler;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

public class ChatScreen extends AppCompatActivity implements MessageRequestResult,Runnable {
    private RecyclerView recyclerView;
    private EditText userMessage;
    private Button submit;
    private Handler handler= new Handler();
    private DateTimeFormatter format=DateTimeFormatter.ofPattern("yyyy/MM/dd/HH:mm:ss");
    private String date = format.format(LocalDateTime.of(1999,1,1,1,1,1));
    private ArrayList<Message> loadedMessages = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chat_screen);
        recyclerView = findViewById(R.id.rvList);
        userMessage = findViewById(R.id.message);
        submit = findViewById(R.id.submit);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        run();
        submit.setOnClickListener(view->{
            HandleMessage insert = new HandleMessage(ChatScreen.this,true);
            insert.execute(format.format(LocalDateTime.now()),userMessage.getText().toString());

        });
    }

    @Override
    public void onMessageRequestResult(ArrayList<String> resData, boolean insert) {
         if(!insert&&resData.size()>0){
            String last = resData.get(resData.size()-1);
            date =last.substring(last.indexOf("~~")+2);
            for(String data:resData){
                loadedMessages.add(new Message(data.substring(0,data.indexOf("~~")),data.substring(data.indexOf("~~")+2)));

            }

            recyclerView.setAdapter(new MessageListAdapter(this,loadedMessages));

        }


    }
    public void run(){
        HandleMessage retrive = new HandleMessage(this,false);
        retrive.execute(date);
        handler.postDelayed(this,1000);

    }
}
