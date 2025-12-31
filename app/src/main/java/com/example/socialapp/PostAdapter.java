package com.example.socialapp;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import java.util.List;

// This custom adapter connects the data list with our item_post layout
public class PostAdapter extends RecyclerView.Adapter<PostAdapter.MyViewHolder> {

    private List<Post> postList;

    // Constructor to receive the data from MainActivity
    public PostAdapter(List<Post> postList) {
        this.postList = postList;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        // Inflating the custom card layout (item_post.xml)
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_post, parent, false);
        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        Post currentPost = postList.get(position);

        // Setting text to views using our specific Identifiers
        holder.userName.setText(currentPost.getUsername());
        holder.messageContent.setText(currentPost.getContent());
    }

    @Override
    public int getItemCount() {
        return postList.size();
    }

    // ViewHolder class to link UI components with Java variables
    public class MyViewHolder extends RecyclerView.ViewHolder {
        public TextView userName, messageContent;

        public MyViewHolder(View view) {
            super(view);
            // Identifiers: Linking IDs from item_post.xml
            userName = view.findViewById(R.id.tweetUser);
            messageContent = view.findViewById(R.id.tweetText);
        }
    }
}