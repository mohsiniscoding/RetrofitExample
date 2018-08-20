package com.example.mohsinraza.retrofitexample;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.util.List;

public class UserRecyclerViewAdapter extends RecyclerView.Adapter<UserRecyclerViewAdapter.UsersViewHolder> {

    private List<User> users;
    private Context context;

    public UserRecyclerViewAdapter(Context context, List<User> users) {
        this.users = users;
        this.context = context;
    }

    @NonNull
    @Override
    public UsersViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.user_list_item,viewGroup,false);
        return new UsersViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull UsersViewHolder holder, int i) {
        holder.username.setText(users.get(i).getName());
        holder.profile_picture.setImageResource(R.drawable.ic_launcher_background);
        Glide.with(context)
                .load(users.get(i).getAvatar_img_url())
                .into(holder.profile_picture);

    }

    @Override
    public int getItemCount() {
        return users.size();
    }

    public class UsersViewHolder extends RecyclerView.ViewHolder {

        TextView username;
        ImageView profile_picture;

        public UsersViewHolder(@NonNull View itemView) {
            super(itemView);
            username = (TextView) itemView.findViewById(R.id.username);
            profile_picture = (ImageView) itemView.findViewById(R.id.user_img);
        }
    }
}
