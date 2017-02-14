package squaring.vitrox.stylight.Model;


import java.util.List;

public class ProductRecycler implements RecyclerObject {

    private List<Product> Product;

    public List<Product> getProducts() {
        return Product;
    }

    public void setProducts(List<Product> products) {
        this.Product = products;
    }
}
