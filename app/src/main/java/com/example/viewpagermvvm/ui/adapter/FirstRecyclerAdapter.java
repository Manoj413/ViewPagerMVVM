package com.example.viewpagermvvm.ui.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.viewpagermvvm.R;
import com.example.viewpagermvvm.data.model.Repo;

import java.util.ArrayList;
import java.util.zip.Inflater;

import butterknife.BindView;

public class FirstRecyclerAdapter extends RecyclerView.Adapter<FirstRecyclerAdapter.ViewHolder>
{
    private Context context;
    private ArrayList<Repo> repoArrayList;

    public FirstRecyclerAdapter(Context context, ArrayList<Repo> repoArrayList) {
        this.context = context;
        this.repoArrayList = repoArrayList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
       View view = LayoutInflater.from(context).inflate(R.layout.lay_first_adapter,parent,false);
       return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

        holder.bind(repoArrayList.get(position));
    }

    @Override
    public int getItemCount() {
        return repoArrayList.size();
    }

    @Override
    public long getItemId(int position) {
        return Long.parseLong(String.valueOf(repoArrayList.get(position)));
    }


    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView txtid,node_id,txtfull_name,txtdescription,txttype,txtsite_admin;
        private Repo repo;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            txtid = itemView.findViewById(R.id.textViewId);
            node_id = itemView.findViewById(R.id.textViewNodeId);
            txtfull_name = itemView.findViewById(R.id.textViewName);
            txtdescription = itemView.findViewById(R.id.textViewDescription);
            txttype = itemView.findViewById(R.id.textViewtype);
            txtsite_admin = itemView.findViewById(R.id.textViewAdmin);
        }

        void bind(Repo repo)
        {
            this.repo = repo;
            txtid.setText("Id -: "+repo.getId());
            node_id.setText("Node Id :- "+repo.getNode_id());
            txtfull_name.setText("Name :- "+repo.getFull_name());
            txtdescription.setText("Description :- "+repo.getDescription());
            txttype.setText("Owner Type :- "+repo.getOwner().getType());
            txtsite_admin.setText("Admin :- "+repo.getOwner().getSite_admin());
        }
    }
}
