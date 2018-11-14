package com.tw2.bxhkpop.adapter;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.squareup.picasso.Picasso;
import com.tw2.bxhkpop.R;
import com.tw2.bxhkpop.model.Member;
import com.tw2.bxhkpop.view.activity.DetailActivity;

import java.util.ArrayList;
import java.util.List;

import de.hdodenhof.circleimageview.CircleImageView;

public class BXHAdapter extends RecyclerView.Adapter<BXHAdapter.ViewHolder> {
    private List<Member> data = new ArrayList<>();
    private Context context;
    private List<Integer> list = new ArrayList<>();
    private boolean firstShow;

    public BXHAdapter(List<Member> data, Context context) {
        this.data = data;
        this.context = context;
        firstShow = true;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view = inflater.inflate(firstShow ?R.layout.item_bxh_one : R.layout.item_bxh, parent, false);
        firstShow = false;
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        final Member member = data.get(position);
        holder.linearLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, DetailActivity.class);
                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return data.size();
    }


    public class ViewHolder extends RecyclerView.ViewHolder {
        CircleImageView imageView;
        TextView tvrank;
        ImageView imgRank;
        LinearLayout linearLayout;
        public ViewHolder(View itemView) {
            super(itemView);
            linearLayout = (LinearLayout) itemView.findViewById(R.id.container_bxh);
        }
    }
}
