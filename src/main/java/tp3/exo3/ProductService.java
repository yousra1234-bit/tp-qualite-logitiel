package tp3.exo3;

public class ProductService {

    private final ProductApiClient productApiClient;

    public ProductService(ProductApiClient productApiClient) {
        this.productApiClient = productApiClient;
    }

    public Product getProduct(String productId) throws ApiException {
        return productApiClient.getProduct(productId);
    }
}
