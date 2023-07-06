package com.example.growgh;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.core.content.ContextCompat;
import androidx.viewpager.widget.PagerAdapter;

public class ViewPagerAdapter extends PagerAdapter {


    Context context;
    int images[]={
            R.drawable.img_3,
            R.drawable.img_1,
            R.drawable.img_4
    };

    int headings[]={
            R.string.about,
            R.string.mission,
            R.string.vision,
    };
    int desc[]={
            R.string.Desc,
            R.string.Desc,
            R.string.Desc

    };


    public ViewPagerAdapter(Context context){
        this.context=context;

    }

    @Override
    public int getCount() {
        return images.length;
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
        return view==(LinearLayout)object;
    }
    public Object instantiateItem(@NonNull ViewGroup container, int position){
        LayoutInflater layoutInflater =(LayoutInflater)context.getSystemService(context.LAYOUT_INFLATER_SERVICE);
        View view = layoutInflater.inflate(R.layout.slider_layout,container,false);

        ImageView slidertitleimage=(ImageView) view.findViewById(R.id.title_image);
        TextView descr=(TextView) view.findViewById(R.id.desc);
        TextView heading=(TextView) view.findViewById(R.id.slide_title);

        slidertitleimage.setImageResource(images[position]);
        descr.setText(desc[position]);
        heading.setText(headings[position]);
        container.addView(view);
        return view;
    }

    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
        container.removeView((LinearLayout)object);
    }
}
