package com.example.viewpagermvvm.ui.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.example.viewpagermvvm.R;
import com.example.viewpagermvvm.data.model.Repo;
import com.example.viewpagermvvm.data.model.User;

import java.util.ArrayList;

public class SecondRecyclerAdapter  extends RecyclerView.Adapter<SecondRecyclerAdapter.ViewHolder>
{
    private Context context;
    private User user;

    public SecondRecyclerAdapter(Context context, User user) {
        this.context = context;
        this.user = user;
    }

    @NonNull
    @Override
    public SecondRecyclerAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.lay_second_adapter,parent,false);
        return new SecondRecyclerAdapter.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull SecondRecyclerAdapter.ViewHolder holder, int position) {

        holder.bind(user);

    }

    @Override
    public int getItemCount() {
        return user.getData().size();
    }

    @Override
    public long getItemId(int position) {
        return Long.parseLong(String.valueOf(user));
    }


    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView txtid,txtPage,txtName,txtEmail;
        ImageView imageView;
        private User user;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            txtid = itemView.findViewById(R.id.textViewId);
            txtPage = itemView.findViewById(R.id.textViewPage);
            txtEmail = itemView.findViewById(R.id.textViewEmail);
            txtName = itemView.findViewById(R.id.textViewName);
            imageView = itemView.findViewById(R.id.imageView);
        }

        void bind(User user)
        {
            this.user = user;
            txtid.setText("Id -: "+user.getData().get(getAdapterPosition()).getId());
            txtPage.setText("Page No :- "+user.getPage());
            txtEmail.setText("Email Id :- "+user.getData().get(getAdapterPosition()).getEmail());
            txtName.setText("Full Name :- "+user.getData().get(getAdapterPosition()).getFirst_name() + " "+user.getData().get(getAdapterPosition()).getLast_name());
            Glide.with(imageView.getContext()).load(user.getData().get(getAdapterPosition()).getAvatar()).apply(RequestOptions.circleCropTransform()).into(imageView);

        }
    }
}
