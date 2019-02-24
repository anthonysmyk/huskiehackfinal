package com.hack1.project;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

public class MessageListAdapter extends RecyclerView.Adapter<MessageListAdapter.ViewHolder>{
    private ArrayList<Message> messages;
    private Context contex;
    public MessageListAdapter(Context context,ArrayList<Message> messages){
        this.contex=context;
        this.messages=messages;
    }

    public ViewHolder onCreateViewHolder(ViewGroup parent,int type){
        return new MessageListAdapter.ViewHolder(LayoutInflater.from(contex).inflate(R.layout.indimessage,null));
    }
    public void onBindViewHolder(MessageListAdapter.ViewHolder viewHolder,int pos){
        viewHolder.message.setText(messages.get(pos).getMessage());
        viewHolder.time.setText(messages.get(pos).getTime());

    }
    public int getItemCount(){return this.messages.size();}














    public class ViewHolder extends RecyclerView.ViewHolder{
        TextView message,time;
        public ViewHolder(View v){
            super(v);
            message = v.findViewById(R.id.Message);
            time = v.findViewById(R.id.Date);

        }
    }
}
