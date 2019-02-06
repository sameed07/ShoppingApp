package Adapters;

import android.content.Context;
import android.graphics.Color;
import android.support.annotation.NonNull;
import android.support.v4.view.PagerAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.sameedshah.shoppingapp.R;

public class SliderAdapter extends PagerAdapter {

    Context context;
    LayoutInflater inflater;

    public int[] imageArray = {R.drawable.eat,R.drawable.sleep,R.drawable.code};
    public  String[] titleArray = {"Screen 1","Screen 2","Screen 3"};
    public  String[] descArray = {"Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua.",
    "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua.",
    "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua."};
    public int[] colorArray = {Color.rgb(115,122,252),Color.rgb(253,190,9)
    ,Color.rgb(247,243,244)};

    public SliderAdapter(Context context){
        this.context = context;
    }

    @Override
    public int getCount() {
        return titleArray.length;
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object o) {
        return (view ==o);
    }

    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {

        container.removeView((LinearLayout)object);
    }

    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup container, int position) {
        inflater = (LayoutInflater)context.getSystemService(context.LAYOUT_INFLATER_SERVICE);
        View view = inflater.inflate(R.layout.slide,container,false);

        LinearLayout linearLayout = view.findViewById(R.id.mLayout);
        ImageView imageView = view.findViewById(R.id.slide_image);
        TextView titleText = view.findViewById(R.id.textTitle);
        TextView descText = view.findViewById(R.id.txtDescription);


        imageView.setImageResource(imageArray[position]);
        titleText.setText(titleArray[position]);
        descText.setText(descArray[position]);

        container.addView(view);
        return view;
    }
}
