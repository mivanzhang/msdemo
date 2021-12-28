package com.example.msdemo;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.example.msdemo.recycleview.GalleryLayoutManager;
import com.example.msdemo.recycleview.MainAdapter;
import com.example.msdemo.recycleview.ScaleTransformer;

import java.util.ArrayList;
import java.util.List;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

/**
 * Created by chensuilun on 2017/3/23.
 */

public class MainFragment extends Fragment  {

    private MainActivity mMainActivity;
    private RecyclerView bannerReycleView;
    private RecyclerView detailReycleView;
    /**
     * Generate by live templates.
     * Use FragmentManager to find this Fragment's instance by tag
     */
    public static MainFragment getFragment(FragmentManager manager) {
        MainFragment fragment=(MainFragment) manager.findFragmentByTag(MainFragment.class.getSimpleName());
        if(fragment==null){
            fragment=newInstance();
        }
        return fragment;
    }

    public static MainFragment newInstance() {
        Bundle args = new Bundle();
        MainFragment fragment = new MainFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        mMainActivity = (MainActivity) context;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        bannerReycleView=view.findViewById(R.id.banner);
        detailReycleView=view.findViewById(R.id.detail);
        initView(view,savedInstanceState);
    }

    protected void initView(View root, Bundle savedInstanceState) {
        final List<String> title = new ArrayList<String>();
        int size = 50;
        for (int i = 0; i < size; i++) {
            title.add("Hello" + i);
        }
        LinearLayoutManager horizontalLayoutManager = new LinearLayoutManager(getContext(),LinearLayoutManager.HORIZONTAL,false);
        MainAdapter horizontalAdapter = new MainAdapter(title);
        bannerReycleView.setLayoutManager(horizontalLayoutManager);
        bannerReycleView.setAdapter(horizontalAdapter);

        LinearLayoutManager verticalLayoutManager = new LinearLayoutManager(getContext());
        MainAdapter verticalAdapter = new MainAdapter(title, MainAdapter.VIEW_TYPE_TEXT);

        detailReycleView.setLayoutManager(verticalLayoutManager);
        detailReycleView.setAdapter(verticalAdapter);

        detailReycleView.addOnScrollListener(new RecyclerView.OnScrollListener() {
            @Override
            public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
                    int firstItemPosition = recyclerView.getChildLayoutPosition(recyclerView.getChildAt(3));
                    bannerReycleView.scrollToPosition(firstItemPosition);
            }
        });

        bannerReycleView.addOnScrollListener(new RecyclerView.OnScrollListener() {
            @Override
            public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
                    int firstItemPosition = recyclerView.getChildLayoutPosition(recyclerView.getChildAt(3));
                    detailReycleView.scrollToPosition(firstItemPosition);
            }
        });
        horizontalAdapter.setOnItemClickListener(new MainAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(View view, int position) {
                detailReycleView.scrollToPosition(position);
            }
        });
    }
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_main, container, false);
    }
}
