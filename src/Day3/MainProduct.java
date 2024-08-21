package Day3;

public class MainProduct {
    public static void main(String[] args) {
    ProductController myProduct = new ProductController("rinso","sabun cuci piring",2000000);

        System.out.println("product: "+myProduct.getProductName());
        System.out.println("desc:"+myProduct.getProductDesc());
        System.out.println("price: "+myProduct.getProductPrice());

        //add product
        System.out.println("=========================================================");
        myProduct.addProduct("babi guling", "haram ges","300000");
        System.out.println("==========================================================");
        myProduct.addProduct("nasi kebuli", "kasian ges nasinya di buli","300000");
        System.out.println("==========================================================");
        myProduct.addProduct("miras", "haram ges", "5000000");
        System.out.println("======================================================");

        //remove product
        myProduct.removeProduct("babi guling");
        System.out.println("=====================================================");
        System.out.println("total product: "+myProduct.getAllProduct() );
        System.out.println("=====================================================");
        myProduct.getNamaToko();
    }
}
