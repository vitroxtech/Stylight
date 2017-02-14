package squaring.vitrox.stylight.Adapter;

import android.content.Context;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.List;

import squaring.vitrox.stylight.Model.Header;

import squaring.vitrox.stylight.Model.Post;

import squaring.vitrox.stylight.Model.ProductRecycler;
import squaring.vitrox.stylight.R;


public class ListAdapter extends RecyclerView.Adapter<ListAdapter.GenericViewHolder> {
    private static final int TYPE_HEADER = 1;
    private static final int TYPE_PRODUCT = 2;
    private static final int TYPE_POST = 3;

    List<Serializable> mItems;
    Context mContext;
    ProductsListAdapter adapter;

    public ListAdapter(Context context) {
        super();
        this.mContext = context;
        mItems = new ArrayList<>();
    }

    public void addProducts(ProductRecycler products) {
        mItems.add(products);
    }

    public void addHeader(Header header) {
        mItems.add(header);
        notifyDataSetChanged();
    }

    public void addPosts(List<Post> posts) {
        mItems.addAll(posts);
        notifyDataSetChanged();
    }

    public void clear() {
        mItems.clear();
        notifyDataSetChanged();
    }

    @Override
    public GenericViewHolder onCreateViewHolder(ViewGroup viewGroup, int viewType) {
        GenericViewHolder customItemViewHolder = null;

        if (viewType == TYPE_PRODUCT) {
            View v = LayoutInflater.from(viewGroup.getContext())
                    .inflate(R.layout.recycler_horizontal, viewGroup, false);
            customItemViewHolder = new ProductsViewHolder(v);
        } else if (viewType == TYPE_POST) {
            View v = LayoutInflater.from(viewGroup.getContext())
                    .inflate(R.layout.post_row, viewGroup, false);
            customItemViewHolder = new PostsViewHolder(v);
        } else if (viewType == TYPE_HEADER) {
            View v = LayoutInflater.from(viewGroup.getContext())
                    .inflate(R.layout.header_row, viewGroup, false);
            customItemViewHolder = new HeaderViewHolder(v);
        }
        return customItemViewHolder;
    }

    @Override
    public void onBindViewHolder(GenericViewHolder viewHolder, int i) {

        if (viewHolder instanceof ProductsViewHolder) {
            ((ProductsViewHolder) viewHolder).bind((ProductRecycler) mItems.get(i));

        } else if (viewHolder instanceof PostsViewHolder) {
            ((PostsViewHolder) viewHolder).bind((Post) mItems.get(i));

        } else if (viewHolder instanceof HeaderViewHolder) {
            ((HeaderViewHolder) viewHolder).bind((Header) mItems.get(i));
        }
    }


    @Override
    public int getItemCount() {
        return mItems.size();
    }

    private class ProductsViewHolder extends GenericViewHolder {

        public RecyclerView recyclerView;

        public ProductsViewHolder(View itemView) {
            super(itemView);
            recyclerView = (RecyclerView) itemView.findViewById(R.id.recyclerhorizontal);
        }

        public void bind(final ProductRecycler productRecycler) {
            final LinearLayoutManager layoutManager
                    = new LinearLayoutManager(mContext, LinearLayoutManager.HORIZONTAL, false);
            adapter = new ProductsListAdapter(mContext);
            recyclerView.setAdapter(adapter);
            adapter.addProducts(productRecycler.getProducts());
            recyclerView.addItemDecoration(new HorizontalItemDecorator((int) mContext.getResources().getDimension(R.dimen.padding_size_small)));
            recyclerView.setLayoutManager(layoutManager);
            recyclerView.setHasFixedSize(true);
        }

    }

    private class PostsViewHolder extends GenericViewHolder {
        public TextView title;
        public TextView kind;
        public ImageView thumb;

        public PostsViewHolder(View itemView) {
            super(itemView);
            kind = (TextView) itemView.findViewById(R.id.itemKind);
            title = (TextView) itemView.findViewById(R.id.itemTitle);
            thumb = (ImageView) itemView.findViewById(R.id.rowThumbnail);
        }

        public void bind(final Post item) {
            title.setText(item.getTitle());
            kind.setText(item.getCategory().getName());
            String Urlimage = item.getTeaserImage();
            Glide.with(mContext).load(Urlimage)
                    .diskCacheStrategy(DiskCacheStrategy.RESULT)
                    .placeholder(R.drawable.placeholder).error(R.drawable.placeholder)
                    .centerCrop().into(thumb);
        }
    }

    private class HeaderViewHolder extends GenericViewHolder {
        public TextView title;
        public TextView subtitle;

        public HeaderViewHolder(View itemView) {
            super(itemView);
            title = (TextView) itemView.findViewById(R.id.headerTitle);
            subtitle = (TextView) itemView.findViewById(R.id.headersubTitle);
        }

        public void bind(final Header header) {
            title.setText(header.getTitle());
            subtitle.setText(header.getSubTitle());
        }
    }

    static class GenericViewHolder extends RecyclerView.ViewHolder {

        public GenericViewHolder(View itemView) {
            super(itemView);

        }
    }

    @Override
    public int getItemViewType(int position) {

        int type = super.getItemViewType(position);

        if (mItems.get(position) instanceof ProductRecycler) {
            type = TYPE_PRODUCT;
        } else if (mItems.get(position) instanceof Post) {
            type = TYPE_POST;
        } else if (mItems.get(position) instanceof Header) {
            type = TYPE_HEADER;
        }
        return type;
    }

}