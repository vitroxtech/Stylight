package squaring.vitrox.stylight.Adapter;

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

import squaring.vitrox.stylight.Common.MoneyHelper;
import squaring.vitrox.stylight.Model.Product;
import squaring.vitrox.stylight.R;

public class ProductsListAdapter extends RecyclerView.Adapter<ProductsListAdapter.ProductsListAdapterViewHolder> {

    private List<Product> mProducts;
    private Context mContext;
    private MoneyHelper moneyHelper;
    public ProductsListAdapter(Context context) {
        mContext = context;
        moneyHelper= new MoneyHelper();
        mProducts = new ArrayList<>();
    }

    public void addProducts(List<Product> products) {
        mProducts = products;
        notifyDataSetChanged();
    }

    @Override
    public ProductsListAdapterViewHolder onCreateViewHolder(ViewGroup viewGroup, int position) {
        View view = LayoutInflater.from(mContext).inflate(R.layout.product_row, null, false);
        return new ProductsListAdapterViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ProductsListAdapterViewHolder holder, int position) {
        if (mProducts != null) {
            final Product product = mProducts.get(position);
            holder.bind(product);
        }
    }


    @Override
    public int getItemCount() {
        if (mProducts == null) {
            return 0;
        }
        return mProducts.size();
    }

    public class ProductsListAdapterViewHolder extends RecyclerView.ViewHolder {
        public TextView title;
        public TextView price;
        public ImageView thumb;

        public ProductsListAdapterViewHolder(View itemView) {
            super(itemView);
            title = (TextView) itemView.findViewById(R.id.productname);
            price = (TextView) itemView.findViewById(R.id.productprice);
            thumb = (ImageView) itemView.findViewById(R.id.productimage);
        }
        public void bind(final Product item) {
            title.setText(item.getName());
            price.setText(moneyHelper.getshowablePrice(item.getPrice().toString(),
                    item.getCurrency().getName()));
            String Urlimage = item.getImages().get(0).getUrl();
            Glide.with(mContext).load(Urlimage)
                    .diskCacheStrategy(DiskCacheStrategy.RESULT)
                    .placeholder(R.drawable.placeholder).error(R.drawable.placeholder)
                    .centerCrop().into(thumb);
        }
    }
}