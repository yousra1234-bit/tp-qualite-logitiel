package tp3.exo3;



public interface ProductApiClient {
    Product getProduct(String productId) throws ApiException;
}
