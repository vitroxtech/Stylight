package squaring.vitrox.stylight;

import android.os.Bundle;
import android.support.design.widget.Snackbar;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import rx.Observable;
import rx.Observer;
import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Func2;
import rx.schedulers.Schedulers;
import squaring.vitrox.stylight.Adapter.ListAdapter;
import squaring.vitrox.stylight.Common.Config;
import squaring.vitrox.stylight.Model.Header;
import squaring.vitrox.stylight.Model.Post;
import squaring.vitrox.stylight.Model.Product;
import squaring.vitrox.stylight.Model.ProductRecycler;
import squaring.vitrox.stylight.Model.StylightResponsePosts;
import squaring.vitrox.stylight.Model.StylightResponseProduct;
import squaring.vitrox.stylight.Network.ApiService;

public class MainActivity extends BaseActivity {

    private static final String TAG = "MainActivity: ";

    @Inject
    ApiService service;

    @Inject
    ListAdapter itemListAdapter;


    private RecyclerView mRecyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getComponent().inject(this);
        setContentView(R.layout.activity_main);
        mRecyclerView = (RecyclerView) findViewById(R.id.recyclerview);
        mRecyclerView.setHasFixedSize(true);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        CallProducts();
    }

    private void CallProducts() {
        // I used the Observable zip because on the graphic design on PDF show it intercalated I mean the posts and products
        final String[] products = new String[]{Config.CLOTHING_ID, Config.LAMPS_ID};
        final String[] posts = new String[]{Config.FASHION_SLUG, Config.LIFESTYLE_SLUG};
        for (int i = 0; i < products.length; i++) {
            Observable<StylightResponseProduct> Ob1 = service.getProducts(products[i], Config.MAX_ITEMS);
            Observable<StylightResponsePosts> Ob2 = service.getPost(posts[i], Config.MAX_ITEMS);
            Observable.zip(Ob1, Ob2, new Func2<StylightResponseProduct, StylightResponsePosts, List<Serializable>>() {
                @Override
                public List<Serializable> call(StylightResponseProduct stylightResponseProduct,
                                               StylightResponsePosts stylightResponsePosts) {
                    List<Serializable> list = new ArrayList<>();
                    list.add(stylightResponseProduct);
                    list.add(stylightResponsePosts);
                    return list;
                }
            }).observeOn(AndroidSchedulers.mainThread())
                    .subscribeOn(Schedulers.newThread())
                    .subscribe(new Observer<List<Serializable>>() {
                        @Override
                        public void onCompleted() {
                            System.out.println(TAG + "rxFinished");
                        }

                        @Override
                        public void onError(Throwable e) {
                            SendErrorMessage(e.getMessage());
                        }

                        @Override
                        public void onNext(List<Serializable> list) {

                            StylightResponseProduct products = (StylightResponseProduct) list.get(0);
                            StylightResponsePosts posts = (StylightResponsePosts) list.get(1);
                            addProducts(products.getProducts());
                            addPosts(posts.getPosts());
                        }
                    });
        }
    }

    public void addProducts(List<Product> dataObjList) {
        Header header = new Header(getResources().getString(R.string.fashion_header),
                getResources().getString(R.string.fashion_header_p2));
        itemListAdapter.addHeader(header);
        ProductRecycler rec = new ProductRecycler();
        rec.setProducts(dataObjList);
        itemListAdapter.addProducts(rec);
        mRecyclerView.setAdapter(itemListAdapter);
    }

    public void addPosts(List<Post> dataObjList) {
        String text = String.format(getResources().getString(R.string.post_fashion_header), dataObjList.get(0).getCategory().getName());
        Header header = new Header(text,
                getResources().getString(R.string.post_fashion_header_p2));
        itemListAdapter.addHeader(header);
        itemListAdapter.addPosts(dataObjList);
        mRecyclerView.setAdapter(itemListAdapter);
    }

    private void SendErrorMessage(final String txt) {
        //Show errors with
        this.runOnUiThread(new Runnable() {
            public void run() {
                Snackbar.make(findViewById(android.R.id.content), txt, Snackbar.LENGTH_LONG).show();
            }
        });
    }
}
