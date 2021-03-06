package android.assessment.test.adapter;

import android.arch.lifecycle.MutableLiveData;
import android.assessment.test.R;
import android.assessment.test.databinding.RowListingsBinding;
import android.assessment.test.managers.AppManager;
import android.assessment.test.models.Media;
import android.assessment.test.models.MediaMetadata;
import android.assessment.test.models.NewsArticle;
import android.content.Context;
import android.databinding.DataBindingUtil;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;

import com.bumptech.glide.Glide;
import com.bumptech.glide.Priority;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.bumptech.glide.request.RequestOptions;

import java.util.List;


public class ListingAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private MutableLiveData<List<NewsArticle>> items;
    private Context context;
    private RequestOptions imageOptions;
    private static final int TYPE_ITEM = 1;
    private static final int TYPE_FOOTER = 2;
    private FooterListingHolder footerHolder;
    private OnClickListener onClickListener;
    private AppManager appManager;
    private boolean showAlert;

    public ListingAdapter(Context context, AppManager appManager, MutableLiveData<List<NewsArticle>> items, OnClickListener onClickListener) {
        this.context = context;
        this.items = items;
        this.showAlert = showAlert;
        imageOptions = new RequestOptions()
                .placeholder(R.drawable.img_loading_pics)
                .error(R.drawable.img_loading_pics)
                .diskCacheStrategy(DiskCacheStrategy.ALL)
                .priority(Priority.HIGH);
        this.onClickListener = onClickListener;
        this.appManager = appManager;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        if (viewType == TYPE_FOOTER) {
            View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.progressbar_small, parent, false);
            return new FooterListingHolder(v);
        } else if (viewType == TYPE_ITEM) {
            RowListingsBinding binding = DataBindingUtil.inflate(
                    LayoutInflater.from(context),
                    R.layout.row_listings,
                    parent, false);

            return new ItemListingHolder(binding.getRoot());
        }

        return null;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, final int position) {
        if (holder instanceof FooterListingHolder) {

            footerHolder = (FooterListingHolder) holder;

        } else if (holder instanceof ItemListingHolder) {

            final ItemListingHolder listingHolder = (ItemListingHolder) holder;

            if (items.getValue() != null) {

                final NewsArticle newsArticle = items.getValue().get(position);
                listingHolder.binding.setNewsArticle(newsArticle);
                listingHolder.binding.setAppManager(appManager);
                listingHolder.binding.executePendingBindings();

                listingHolder.binding.itemCardListing.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {

                        onClickListener.onItemClick(listingHolder.getAdapterPosition(), newsArticle, listingHolder.binding);


                    }
                });

                Media media = newsArticle.getMedia() != null && newsArticle.getMedia().length > 0 ? newsArticle.getMedia()[0] : null;
                MediaMetadata mediaMetadata = media != null && media.getMediaMetadata() != null && media.getMediaMetadata().length > 0 ? media.getMediaMetadata()[0] : null;
                String imgUrl = mediaMetadata != null ? mediaMetadata.getUrl() : null;

                Glide.with(context)
                        .load(imgUrl)
                        .apply(imageOptions)
                        .into(listingHolder.binding.thumbIv);
            }
        }
    }

    public void setData(List<NewsArticle> dataItems) {
        if (dataItems == null)
            return;
        this.items.setValue(dataItems);
        notifyDataSetChanged();
    }

    public List<NewsArticle> getData() {
        return items.getValue();
    }


    @Override
    public int getItemCount() {
        return items.getValue() != null ? items.getValue().size() : 0;
    }


    @Override
    public int getItemViewType(int position) {
        if (isPositionFooter(position)) {
            return TYPE_FOOTER;
        }
        return TYPE_ITEM;
    }


    public void notifyItemChange(int position) {
        this.notifyItemChanged(position);
    }

    public void setFooterVisibility(int visibility) {

        if (footerHolder != null && footerHolder.proressBar != null)
            footerHolder.proressBar.setVisibility(visibility);
    }


    private boolean isPositionFooter(int position) {
        return position == items.getValue().size() - 1;
    }


    class FooterListingHolder extends RecyclerView.ViewHolder {
        ProgressBar proressBar;

        public FooterListingHolder(View itemView) {
            super(itemView);
            this.proressBar = itemView.findViewById(R.id.progress_small);
        }
    }

    public class ItemListingHolder extends RecyclerView.ViewHolder {
        RowListingsBinding binding;

        ItemListingHolder(View itemView) {
            super(itemView);
            binding = DataBindingUtil.bind(itemView);
        }


    }


    public interface OnClickListener {

        void onItemClick(int position, NewsArticle newsArticle, RowListingsBinding binding);


    }
}
