package com.example.simplelogin;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class WingAdapter extends RecyclerView.Adapter<WingAdapter.WingVH> {
    ArrayList<Wing> List;
    Context context;

    public WingAdapter(ArrayList<Wing> list, Context context) {
        List = list;
        this.context = context;
    }

    @NonNull
    @Override
    public WingVH onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new WingVH(LayoutInflater.from(parent.getContext()).inflate(R.layout.item_wing,parent,false));
    }

    @Override
    public void onBindViewHolder(@NonNull WingAdapter.WingVH holder, int position) {
        holder.populate(List.get(position));

    }



    @Override
    public int getItemCount() {
        return List.size();
    }


    public class WingVH extends RecyclerView.ViewHolder {

        TextView NameW,HostelW,BranchW,IDW;
        public WingVH(@NonNull View itemView) {
            super(itemView);
            NameW=itemView.findViewById(R.id.item_name);
            HostelW=itemView.findViewById(R.id.item_hostel);
            BranchW=itemView.findViewById(R.id.item_branch);
            IDW=itemView.findViewById(R.id.item_id_no);
        }

        public void populate(Wing wing) {

            NameW.setText(wing.getName());
            HostelW.setText(wing.getHostel());
            BranchW.setText(wing.getBranch());
            IDW.setText(wing.getId());
        }
    }
}
