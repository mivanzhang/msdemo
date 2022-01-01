package com.example.msdemo.recycleview;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.msdemo.BuildConfig;
import com.example.msdemo.R;
import com.example.msdemo.bean.Person;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.Random;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;


public class MainAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> implements View.OnClickListener {
    public static final int VIEW_TYPE_IMAGE = 0;
    public static final int VIEW_TYPE_TEXT = 1;
    private static final String TAG = "DemoAdapter";
    private List<Person> mItems;
    private int mType = VIEW_TYPE_IMAGE;
    private OnItemClickListener mOnItemClickListener;
    private Context mContext;

    public MainAdapter(List<Person> items,Context context) {
        this(items, VIEW_TYPE_IMAGE,context);
    }

    public MainAdapter(List<Person> items, int type,Context context) {
        this.mItems = items;
        mType = type;
        mContext=context;
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
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        if (BuildConfig.DEBUG) {
            Log.e(TAG, "onCreateViewHolder: type:" + viewType);
        }
        View v;
        if (viewType == VIEW_TYPE_IMAGE) {
            v = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_recycle_avatar , parent, false);
            v.setOnClickListener(this);
            return new ViewHolder(v);
        } else {
            v = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_recycle_detail, parent, false);
            v.setOnClickListener(this);
            return new DetailedViewHolder(v);
        }

    }
    int [] resource=new int[]{R.mipmap.allan_munger,R.mipmap.amanda_brady,R.mipmap.carlos_slattery
            ,R.mipmap.cecil_folk,R.mipmap.carole_poland,R.mipmap.colin_ballinger,R.mipmap.isaac_fielder
            ,R.mipmap.mona_kane,R.mipmap.robert_tolbert,R.mipmap.wanda_howard
            ,R.mipmap.johnie_mconnell,R.mipmap.katri_ahokas,R.mipmap.kristin_patterson};
    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        if (BuildConfig.DEBUG) {
            Log.d(TAG, "onBindViewHolder: position:" + position);
        }
        Person item = mItems.get(position);
        if (mType == VIEW_TYPE_IMAGE) {

            ((ViewHolder)holder).avatar.setImageResource(getImage(position));
        } else {
            ((DetailedViewHolder)holder).name.setText(item.getFirstName()+" "+item.getLastName());
            ((DetailedViewHolder)holder).title.setText(item.getTitle());
            ((DetailedViewHolder)holder).info.setText(item.getIntroduction());
        }
        holder.itemView.setTag(position);
    }

    private int getImage(int position) {
        //图片没有全部处理，更聚焦与逻辑展示
        return resource[position%(resource.length)];

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
        public ImageView avatar;

        public ViewHolder(View itemView) {
            super(itemView);
            avatar = (ImageView) itemView.findViewById(R.id.item_avatar);
        }
    }

    protected static class DetailedViewHolder extends RecyclerView.ViewHolder {
        public TextView name;
        public TextView title;
        public TextView info;

        public DetailedViewHolder(View itemView) {
            super(itemView);
            name = (TextView) itemView.findViewById(R.id.name);
            title = (TextView) itemView.findViewById(R.id.title);
            info = (TextView) itemView.findViewById(R.id.detail);
        }
    }

    public interface OnItemClickListener {

        void onItemClick(View view, int position);

    }
}
