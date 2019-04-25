package com.example.freshfinaltoolbarwhatsapp;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


/**
 * A simple {@link Fragment} subclass.
 */
public class ChatsFragment extends Fragment {

    private List<ChildHakayatCategory> childHakayatCategoryList = new ArrayList<>();
    private RecyclerView recyclerView;
    private HakayatAdapter hakayatAdapter;
    private LinearLayoutManager linearLayoutManager;
    private ApiInterface apiInterface;


    public ChatsFragment() {
        getData();
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_chats1, container, false);
        recyclerView = view.findViewById(R.id.recyclerview);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        hakayatAdapter = new HakayatAdapter(childHakayatCategoryList);
        recyclerView.setAdapter(hakayatAdapter);
        getData();
        return view;
    }

    private void getData() {
        apiInterface = RetrofitClient.getRetrofit().create(ApiInterface.class);
        Call<ParentHakayatCategory> call = apiInterface.performShowCategoriesData();
        call.enqueue(new Callback<ParentHakayatCategory>() {
            @Override
            public void onResponse(Call<ParentHakayatCategory> call, Response<ParentHakayatCategory> response) {
                hakayatAdapter.updateData(response.body().getData());
            }

            @Override
            public void onFailure(Call<ParentHakayatCategory> call, Throwable t) {
                Toast.makeText(getActivity(), t.getMessage(), Toast.LENGTH_SHORT).show();

            }
        });
    }


}
