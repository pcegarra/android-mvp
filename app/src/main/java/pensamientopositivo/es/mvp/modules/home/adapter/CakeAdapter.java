package pensamientopositivo.es.mvp.modules.home.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import pensamientopositivo.es.mvp.R;
import pensamientopositivo.es.mvp.mvp.model.Cake;

/**
 * Created by pablo on 8/1/17.
 */

public class CakeAdapter extends RecyclerView.Adapter<CakeAdapter.Holder> {

    private LayoutInflater mLayoutInflater;
    private Context mContext;
    private List<Cake> mCakeList = new ArrayList<>();

    public CakeAdapter (Context context,LayoutInflater layoutInflater){
        mContext=context;
        mLayoutInflater=layoutInflater;
    }

    @Override
    public Holder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = mLayoutInflater.inflate(R.layout.item_list_layout, parent, false);
        return new Holder(view);
    }

    @Override
    public void onBindViewHolder(Holder holder, int position) {
        holder.bind(mCakeList.get(position));
    }

    @Override
    public int getItemCount() {
        return mCakeList.size();
    }

    public void addCakes(List<Cake>cakes){
        mCakeList.addAll(cakes);
        notifyDataSetChanged();
    }

    public void clearItems() {
        mCakeList.clear();
        notifyDataSetChanged();
    }

    public class Holder extends RecyclerView.ViewHolder{

        private Context mContext;

        @BindView(R.id.text_title)
        TextView mTextTitle;

        @BindView(R.id.text_description)
        TextView mTextDescription;

        @BindView(R.id.image_icon)
        ImageView mIcon;

        public Holder(View itemView) {
            super(itemView);
            mContext = itemView.getContext();
            ButterKnife.bind(this,itemView);
        }

        public void bind(Cake cake){
            mTextTitle.setText(cake.getTitle());
            mTextDescription.setText(cake.getPreviewDescription());
            Glide.with(mContext).load(cake.getImageUrl()).diskCacheStrategy(DiskCacheStrategy.SOURCE).into(mIcon);
        }
    }
}
