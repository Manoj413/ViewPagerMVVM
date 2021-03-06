package com.example.viewpagermvvm.ui.fragment;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.viewpagermvvm.R;
import com.example.viewpagermvvm.base.BaseFragment;
import com.example.viewpagermvvm.data.model.Repo;
import com.example.viewpagermvvm.ui.adapter.FirstRecyclerAdapter;
import com.example.viewpagermvvm.util.ViewModelFactory;

import java.util.ArrayList;

import javax.inject.Inject;

import butterknife.BindView;

public class FragmentFirst extends BaseFragment {
    private static final String TAG = "First";
    @BindView(R.id.recyclerFirst)
    RecyclerView recyclerView;
    RecyclerView.LayoutManager layoutManager;
    FirstRecyclerAdapter firstRecyclerAdapter;
    ViewPagerModel pageViewModel;
    @BindView(R.id.loading_view)
    ProgressBar progressBar;
    @BindView(R.id.tv_error)
    TextView errorTextView;
    @Inject
    ViewModelFactory viewModelFactory;

    @Override
    protected int layoutRes() {
        return R.layout.lay_fragment_first;
    }
    public FragmentFirst() {
        // Required empty public constructor
    }


    public static FragmentFirst newInstance() {
        return new FragmentFirst();
    }


    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        pageViewModel = ViewModelProviders.of(this,viewModelFactory).get(ViewPagerModel.class);
        pageViewModel.setIndex(TAG);

        pageViewModel.getRepos().observe(this, new Observer<ArrayList<Repo>>() {
            @Override
            public void onChanged(ArrayList<Repo> repos) {
                Toast.makeText(getContext(),"Result Obtained",Toast.LENGTH_LONG).show();

                setupAdapter(repos);
            }
        });


        observableViewModel();
    }



   /* @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        pageViewModel = ViewModelProviders.of(this).get(ViewPagerModel.class);
        pageViewModel.setIndex(TAG);
    }




    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View root = inflater.inflate(R.layout.lay_fragment_first, container, false);
      recyclerView = root.findViewById(R.id.recyclerFirst);
      progressBar = root.findViewById(R.id.loading_view);
      errorTextView = root.findViewById(R.id.tv_error);

       pageViewModel.getMutableLiveData().observe(this, new Observer<ArrayList<Repo>>() {
           @Override
           public void onChanged(ArrayList<Repo> repos) {
               Toast.makeText(getContext(),"Result Obtained",Toast.LENGTH_LONG).show();

               setupAdapter(repos);
           }
       });

       observableViewModel();
        return root;
    }
*/

    private void observableViewModel() {
        pageViewModel.getRepos().observe(this, repos -> {
            if(repos != null) recyclerView.setVisibility(View.VISIBLE);
        });

        pageViewModel.getError().observe(this, isError -> {
            if (isError != null) if(isError) {
                errorTextView.setVisibility(View.VISIBLE);
                recyclerView.setVisibility(View.GONE);
                errorTextView.setText("An Error Occurred While Loading Data!");
            }else {
                errorTextView.setVisibility(View.GONE);
                errorTextView.setText(null);
            }
        });

        pageViewModel.getLoading().observe(this, isLoading -> {
            if (isLoading != null) {
                progressBar.setVisibility(isLoading ? View.VISIBLE : View.GONE);
                if (isLoading) {
                    errorTextView.setVisibility(View.GONE);
                    recyclerView.setVisibility(View.GONE);
                }
            }
        });
    }
    private void setupAdapter(ArrayList<Repo> repos)
    {
        firstRecyclerAdapter = new FirstRecyclerAdapter(getContext(),repos);
        layoutManager = new LinearLayoutManager(getContext(),RecyclerView.VERTICAL,false);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(firstRecyclerAdapter);
    }
}
