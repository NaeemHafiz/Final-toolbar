package com.example.freshfinaltoolbarwhatsapp;


import android.app.ProgressDialog;
import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.SearchView;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


/**
 * A simple {@link Fragment} subclass.
 */
public class ChatsFragment extends Fragment implements SwipeRefreshLayout.OnRefreshListener {

    private List<ChildHakayatCategory> childHakayatCategoryList = new ArrayList<>();
    private RecyclerView recyclerView;
    private HakayatAdapter hakayatAdapter;
    private ApiInterface apiInterface;
    private SearchView s;
    private ProgressDialog progressDoalog;
    private SwipeRefreshLayout swipeRefreshLayout;


    public ChatsFragment() {

        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_chats1, container, false);
        progressDoalog = new ProgressDialog(getActivity());
        recyclerView = view.findViewById(R.id.recyclerview);
        swipeRefreshLayout = view.findViewById(R.id.swipeRefreshLayout);
        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        swipeRefreshLayout.setOnRefreshListener(this);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        hakayatAdapter = new HakayatAdapter(childHakayatCategoryList);
        recyclerView.setAdapter(hakayatAdapter);
    }

    @Override
    public void onResume() {
        super.onResume();
        getData();
    }

    private void refreshContent() {
        Handler handler = new Handler();
        Runnable updateData = new Runnable() {
            @Override
            public void run() {
                LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getActivity());
                recyclerView.setLayoutManager(linearLayoutManager);
                // call the constructor of UsersAdapter to send the reference and data to Adapter
                hakayatAdapter = new HakayatAdapter(childHakayatCategoryList);
                recyclerView.setAdapter(hakayatAdapter); // set the Adapter to RecyclerView
                swipeRefreshLayout.setRefreshing(false);
            }
        };
        handler.postDelayed(updateData, 3000);
    }

    private void getData() {
        showProgressDialog();
        apiInterface = RetrofitClient.getRetrofit().create(ApiInterface.class);
        Call<ParentHakayatCategory> call = apiInterface.performShowCategoriesData();
        call.enqueue(new Callback<ParentHakayatCategory>() {
            @Override
            public void onResponse(Call<ParentHakayatCategory> call, Response<ParentHakayatCategory> response) {
                hideProgressDialog();
                hakayatAdapter.updateData(response.body().getData());
            }

            @Override
            public void onFailure(Call<ParentHakayatCategory> call, Throwable t) {
                Toast.makeText(getActivity(), t.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void showProgressDialog() {
        if (progressDoalog != null) {
            progressDoalog.setMax(100);
            progressDoalog.setMessage("Please Wait....");
            progressDoalog.show();
        }
    }

    private void hideProgressDialog() {
        if (progressDoalog != null)
            progressDoalog.dismiss();
    }

    @Override
    public void onRefresh() {
        refreshContent();

    }
}
