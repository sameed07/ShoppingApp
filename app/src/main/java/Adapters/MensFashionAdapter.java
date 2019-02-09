package Adapters;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v4.view.GravityCompat;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.sameedshah.shoppingapp.R;

public class MensFashionAdapter extends RecyclerView.Adapter<MensFashionAdapter.ViewHolder>{
    int[] images ;
    String[] title ;
    String[] price ;
    private Context mContext;
    private MensFashionAdapter.ItemClickListener mClickListener;

    public MensFashionAdapter(Context context, int[] images, String[] titles, String[] price){
        this.mContext = context;
        this.images = images;
        this.title = titles;
        this.price = price;
    }
    @NonNull
    @Override
    public MensFashionAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int i) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.latest_product_adapter,
                parent, false);
        return new MensFashionAdapter.ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull MensFashionAdapter.ViewHolder viewHolder, int i) {

        viewHolder.mImage.setImageResource(images[i]);
        viewHolder.mTitle.setText(title[i]);
        viewHolder.mPrice.setText(price[i]);

    }
    @Override
    public int getItemCount() {
        return title.length;
    }

    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener  {

        ImageView mImage;
        TextView mTitle;
        TextView mPrice;


        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            mImage = itemView.findViewById(R.id.mImageView);
            mTitle = itemView.findViewById(R.id.product_title);
            mPrice = itemView.findViewById(R.id.txtPrice);
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            if (mClickListener != null) mClickListener.onItemClick(v, getAdapterPosition());
        }
    }
    void setClickListener(MensFashionAdapter.ItemClickListener itemClickListener) {
        this.mClickListener = itemClickListener;
    }
    public interface ItemClickListener {
        void onItemClick(View view, int position);
    }

}
