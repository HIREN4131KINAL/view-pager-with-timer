package com.example.dhaval.viewpagerdemo;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;

/**
 * Created by Dhaval on 07-Apr-16.
 */
public class PagerAdapter extends android.support.v4.view.PagerAdapter {

    ArrayList<String> values = new ArrayList<>();
    private Context context;
    private LayoutInflater layoutInflater;

    public PagerAdapter(Context context) {
        this.context = context;
        values.add("http://www.gettyimages.pt/gi-resources/images/Homepage/Hero/PT/PT_hero_42_153645159.jpg");
        values.add("http://www.gettyimages.ca/gi-resources/images/Homepage/Category-Creative/UK/UK_Creative_462809583.jpg");
        values.add("http://www.gettyimages.ca/gi-resources/images/Homepage/Hero/UK/CMS_Creative_164657191_Kingfisher.jpg");
//        values.add("https://static.pexels.com/photos/8700/wall-animal-dog-pet.jpg");


    }

    @Override
    public int getCount() {
        return values.size();
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view == object;
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position) {

        layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View view = layoutInflater.inflate(R.layout.swipe, container, false);
        ImageView textView = (ImageView) view.findViewById(R.id.ivMain);

        Picasso.with(context).load(values.get(position)).into(textView);
        container.addView(view);
        return view;
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        container.removeView((View) object);
    }


}
