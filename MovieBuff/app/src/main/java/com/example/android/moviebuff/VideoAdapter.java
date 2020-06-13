package com.example.android.moviebuff;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class VideoAdapter extends RecyclerView.Adapter<VideoAdapter.MyViewHolder> {

    ArrayList<RImage> dataset;

    public VideoAdapter(ArrayList<RImage>dataset)
    {
        this.dataset=dataset;

    }


    public static class MyViewHolder extends RecyclerView.ViewHolder
    {
        public TextView video;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            this.video=itemView.findViewById(R.id.video);
        }
    }

    @NonNull
    @Override
    public VideoAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v=(View) LayoutInflater.from(parent.getContext()).inflate(R.layout.videoview,parent,false);
        MyViewHolder vh=new MyViewHolder(v);
        return vh;
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        if(dataset.get(position).getType()=="Youtube")
            holder.video.setText("https://wwww.youtube,com/q="+dataset.get(position).getPath());
        else
            holder.video.setText("https://wwww.vimeo,com/q="+dataset.get(position).getPath());


    }


    @Override
    public int getItemCount() {
        return dataset.size();
    }
}
