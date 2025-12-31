package com.example.socialapp;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;
import java.util.List;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class HomeFragment extends Fragment {

    private EditText etName, etMsg;
    private Button btnSubmit;
    private RecyclerView recyclerView;
    private PostAdapter adapter;
    private List<Post> postList = new ArrayList<>();
    private ApiService apiService;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Linking this Java class with fragment_home.xml
        View v = inflater.inflate(R.layout.fragment_home, container, false);

        // Identifiers linking
        etName = v.findViewById(R.id.etName);
        etMsg = v.findViewById(R.id.etMsg);
        btnSubmit = v.findViewById(R.id.btnSubmit);
        recyclerView = v.findViewById(R.id.postRecyclerView);

        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        adapter = new PostAdapter(postList);
        recyclerView.setAdapter(adapter);

        setupRetrofit();
        loadData();

        btnSubmit.setOnClickListener(view -> {
            // Your post logic here
        });

        return v;
    }

    private void setupRetrofit() {
        Retrofit rf = new Retrofit.Builder()
                .baseUrl("https://social-app-api-0euf.onrender.com/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        apiService = rf.create(ApiService.class);
    }

    private void loadData() {
        apiService.getPosts().enqueue(new Callback<List<Post>>() {
            @Override
            public void onResponse(Call<List<Post>> call, Response<List<Post>> response) {
                if (response.isSuccessful() && response.body() != null) {
                    postList.clear();
                    postList.addAll(response.body());
                    adapter.notifyDataSetChanged();
                }
            }
            @Override
            public void onFailure(Call<List<Post>> call, Throwable t) { }
        });
    }
}