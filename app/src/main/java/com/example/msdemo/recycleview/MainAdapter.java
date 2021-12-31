package com.example.msdemo.recycleview;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.msdemo.BuildConfig;
import com.example.msdemo.R;

import java.util.List;
import java.util.Random;

import androidx.recyclerview.widget.RecyclerView;


public class MainAdapter extends RecyclerView.Adapter<MainAdapter.ViewHolder> implements View.OnClickListener {
    public static final int VIEW_TYPE_IMAGE = 0;
    public static final int VIEW_TYPE_TEXT = 1;
    private static final String TAG = "DemoAdapter";
    private List<String> mItems;
    private int mType = VIEW_TYPE_IMAGE;
    private OnItemClickListener mOnItemClickListener;


    public MainAdapter(List<String> items) {
        this(items, VIEW_TYPE_IMAGE);
    }

    public MainAdapter(List<String> items, int type) {
        this.mItems = items;
        mType = type;
    }

    private static final Random RANDOM = new Random();


    public MainAdapter setOnItemClickListener(OnItemClickListener onItemClickListener) {
        this.mOnItemClickListener = onItemClickListener;
        return this;
    }

    @Override
    public int getItemViewType(int position) {
        return mType;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        if (BuildConfig.DEBUG) {
            Log.e(TAG, "onCreateViewHolder: type:" + viewType);
        }
        View v;
        if (viewType == VIEW_TYPE_IMAGE) {
            v = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_recycle_demo, parent, false);
        } else {
            v = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_recycle_tv, parent, false);
        }
        v.setOnClickListener(this);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        if (BuildConfig.DEBUG) {
            Log.d(TAG, "onBindViewHolder: position:" + position);
        }
        String item = mItems.get(position);
        if (mType == VIEW_TYPE_TEXT) {
            holder.text.setText(item);
        } else {
            holder.text.setText("H" + position);
        }
        holder.itemView.setTag(position);
    }

    @Override
    public int getItemCount() {
        return mItems.size();
    }

    @Override
    public void onClick(final View v) {
        if (mOnItemClickListener != null) {
            mOnItemClickListener.onItemClick(v, (int) v.getTag());
        }
    }

    protected static class ViewHolder extends RecyclerView.ViewHolder {
        public TextView text;

        public ViewHolder(View itemView) {
            super(itemView);
            text = (TextView) itemView.findViewById(R.id.item_icon);
        }
    }

    public interface OnItemClickListener {

        void onItemClick(View view, int position);

    }
}
