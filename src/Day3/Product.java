package Day3;

public interface Product {
    String getProductName();
    String getProductDesc();
    int getProductPrice();
    void addProduct(String productName, String productDesc, String productPrice);
    void removeProduct(String productName);
    int getAllProduct();

    default  void getNamaToko(){
        System.out.println("Nama Toko: Alfamart");
    }

    }

