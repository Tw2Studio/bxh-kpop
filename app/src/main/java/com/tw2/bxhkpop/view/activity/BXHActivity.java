package com.tw2.bxhkpop.view.activity;

import android.os.Build;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.tw2.bxhkpop.R;
import com.tw2.bxhkpop.adapter.BXHAdapter;
import com.tw2.bxhkpop.model.Member;

import java.util.ArrayList;
import java.util.List;

public class BXHActivity extends AppCompatActivity {
    private RecyclerView recyclerView;
    private List<Member> list;
    private BXHAdapter adapter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bxh);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            getWindow().setStatusBarColor(ContextCompat.getColor(getApplicationContext(), R.color.colorPrimaryDark));
        }
        initView();
        initData();
    }

    private void initData() {
        list = new ArrayList<>();
        list.add(new Member());
        list.add(new Member());
        list.add(new Member());
        list.add(new Member());
        list.add(new Member());
        list.add(new Member());
        list.add(new Member());
        list.add(new Member());

        adapter = new BXHAdapter(list, BXHActivity.this);
        recyclerView.setAdapter(adapter);
    }

    private void initView() {
        recyclerView = (RecyclerView) findViewById(R.id.recycle_bxh);
        LinearLayoutManager layoutManager = new LinearLayoutManager(BXHActivity.this);
        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        recyclerView.setLayoutManager(layoutManager);
        DividerItemDecoration dividerItemDecoration = new DividerItemDecoration(recyclerView.getContext(),
                layoutManager.getOrientation());
        recyclerView.addItemDecoration(dividerItemDecoration);
    }
}
