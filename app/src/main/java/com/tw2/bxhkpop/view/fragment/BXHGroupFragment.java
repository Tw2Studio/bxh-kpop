package com.tw2.bxhkpop.view.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.tw2.bxhkpop.R;
import com.tw2.bxhkpop.view.activity.BXHActivity;

public class BXHGroupFragment extends Fragment implements View.OnClickListener {
    private View view;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_bxh_group, container, false);
        initView();
        return view;
    }

    private void initView() {
        view.findViewById(R.id.btn_vote_nam).setOnClickListener(this);
        view.findViewById(R.id.btn_vote_nu).setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btn_vote_nam:
                Intent intent = new Intent(getActivity(), BXHActivity.class);
                startActivity(intent);
                break;
            case R.id.btn_vote_nu:
                Intent intent1 = new Intent(getActivity(), BXHActivity.class);
                startActivity(intent1);
                break;
        }
    }
}
