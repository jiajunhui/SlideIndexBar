package com.kk.taurus.slidebar.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.kk.taurus.slidebar.R;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Taurus on 2017/6/16.
 */

public class ListAdapter extends RecyclerView.Adapter<ListAdapter.ItemHolder>{

    private Context mContext;
    private List<String> mList = new ArrayList<>();

    public ListAdapter(Context context,List<String> list){
        this.mContext = context;
        this.mList = list;
    }

    @Override
    public ItemHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new ItemHolder(View.inflate(mContext,R.layout.item_text,null));
    }

    @Override
    public void onBindViewHolder(ItemHolder holder, int position) {
        String text = mList.get(position);
        holder.text.setText(text);
        char firstChar = text.charAt(0);
        holder.header.setVisibility(View.GONE);
        if(position > 0){
            char preChar = mList.get(position - 1).charAt(0);
            if(firstChar!=preChar){
                holder.header.setVisibility(View.VISIBLE);
                holder.header.setText(String.valueOf(firstChar));
            }
        }else{
            holder.header.setVisibility(View.VISIBLE);
            holder.header.setText(String.valueOf(firstChar));
        }
    }

    @Override
    public int getItemCount() {
        return mList.size();
    }

    public static class ItemHolder extends RecyclerView.ViewHolder{

        TextView header;
        TextView text;

        public ItemHolder(View itemView) {
            super(itemView);
            header = (TextView) itemView.findViewById(R.id.tv_header);
            text = (TextView) itemView.findViewById(R.id.tv_text);
        }

    }

}
