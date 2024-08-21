package Day3;

import java.util.HashSet;

public class ProductController implements Product {
    private String productName;
    private String productDesc;
    private int productPrice;
private HashSet<String>Product =new HashSet<>();
public ProductController(String productName, String productDesc, int productPrice){
    this.productName = productName;
    this.productDesc = productDesc;
    this.productPrice = productPrice;
}
    @Override
    public String getProductName() {
        return productName;
    }

    @Override
    public String getProductDesc() {
        return productDesc;
    }

    @Override
    public int getProductPrice() {
        return productPrice;
    }

    @Override
    public void addProduct(String productName, String productDesc, String productPrice) {
        Product.add(productName);
        Product.add(productDesc);
        Product.add(productPrice);
        System.out.println("added Product: " +productName);
        System.out.println("added Description: "+productDesc);
        System.out.println("added Price: "+productPrice);
    }

    @Override
    public void removeProduct(String productName) {
        if(Product.remove(productName)){
            System.out.println("product has been removed: "+productName);
        }else{
            System.out.println("product not found");
        }

    }

    @Override
    public int getAllProduct() {
        return Product.size();
    }
}
