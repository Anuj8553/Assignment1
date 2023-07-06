package com.example.growgh;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.List;

public class RVRetrofitAdapter  extends RecyclerView.Adapter<RVRetrofitAdapter.RVHolderRetrofit> {
    Context mCntext;
    List<ProductResult> productResults;
    public RVRetrofitAdapter(Context mContext,List<ProductResult> productResults){
        this.productResults=productResults;
        this.mCntext=mContext;
    }
    @NonNull
    @Override
    public RVRetrofitAdapter.RVHolderRetrofit onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(mCntext).inflate(R.layout.rvitem,parent,false);

        return new RVHolderRetrofit(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RVRetrofitAdapter.RVHolderRetrofit holder, int position) {
            holder.tvTitle.setText(productResults.get(position).getTitle());
        Glide.with(mCntext)
                .load(productResults.get(position).getImage()).placeholder(R.drawable.img_3).error(R.drawable.ic_launcher_background).into(holder.ivImage);

    }

    @Override
    public int getItemCount() {
        return productResults.size();
    }

    public class RVHolderRetrofit extends RecyclerView.ViewHolder {
        TextView tvTitle;
        ImageView ivImage;
        public RVHolderRetrofit(@NonNull View itemView) {
            super(itemView);
            ivImage=itemView.findViewById(R.id.ivImage);
            tvTitle=itemView.findViewById(R.id.tvTitle);
        }
    }
}
