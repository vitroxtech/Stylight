package squaring.vitrox.stylight.Network;

import java.util.List;


import retrofit2.http.GET;
import retrofit2.http.Query;
import rx.Observable;
import squaring.vitrox.stylight.Model.StylightResponsePosts;
import squaring.vitrox.stylight.Model.StylightResponseProduct;


public interface ApiService {

    @GET("rest/products")
    Observable<StylightResponseProduct> getProducts(@Query("category") String category, @Query("pageItems") int pageItems );

    @GET("rest/posts")
    Observable<StylightResponsePosts> getPost(@Query("category") String category, @Query("pageItems") int pageItems );

}
