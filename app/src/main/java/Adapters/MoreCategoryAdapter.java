package Adapters;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.sameedshah.shoppingapp.R;

public class MoreCategoryAdapter extends RecyclerView.Adapter<MoreCategoryAdapter.ViewHolder>{
    int[] images ;
    String[] title ;
    String[] items ;
    private Context mContext;
    private MoreCategoryAdapter.ItemClickListener mClickListener;

    public MoreCategoryAdapter(Context context, int[] images, String[] titles, String[] items){
        this.mContext = context;
        this.images = images;
        this.title = titles;
        this.items = items;
    }

    @NonNull
    @Override
    public MoreCategoryAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {

        View v = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.more_category_adapter,
                viewGroup, false);
        return new MoreCategoryAdapter.ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull MoreCategoryAdapter.ViewHolder viewHolder, int i) {
        viewHolder.mImage.setImageResource(images[i]);
        viewHolder.mTitle.setText(title[i]);
        viewHolder.mItems.setText(items[i]);
    }

    @Override
    public int getItemCount() {
        return title.length;
    }
    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener  {

        ImageView mImage;
        TextView mTitle;
        TextView mItems;


        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            mImage = itemView.findViewById(R.id.image_of_category);
            mTitle = itemView.findViewById(R.id.categoryTitle);
            mItems = itemView.findViewById(R.id.categoryItems);
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            if (mClickListener != null) mClickListener.onItemClick(v, getAdapterPosition());
        }
    }
    void setClickListener(MoreCategoryAdapter.ItemClickListener itemClickListener) {
        this.mClickListener = itemClickListener;
    }

    public interface ItemClickListener {
        void onItemClick(View view, int position);
    }
}
