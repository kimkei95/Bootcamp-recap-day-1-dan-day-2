package WeeklyCRUDDemo;


import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.ObjectNode;

import java.util.Scanner;
import java.sql.*;
public class WeeklyDemo {
    String readProducts ="select*from Products";
    String readCustomers="select*from Customers";
    String url = "jdbc:postgresql://localhost:5432/Weekly_Test_Market";
    String username = "postgres";
    String password = "postgres";
    Scanner scanner = new Scanner(System.in);

    public void addCustomer() {
        String addQuery = "INSERT INTO Customers(first_name, last_name, address,no_hp,email)" +
                "VALUES (?,?,?,?,?)";
        try (Connection con = DriverManager.getConnection(url, username, password);
             PreparedStatement pst = con.prepareStatement(addQuery)) {
            System.out.println("enter first name: ");
            String firstName = scanner.nextLine();
            System.out.println("enter last name: ");
            String lastName = scanner.nextLine();
            System.out.println("enter address: ");
            String address = scanner.nextLine();
            System.out.println("masukkan no hp: ");
            String noHp = scanner.nextLine();

            System.out.println("masukkan email: ");
            String email = scanner.nextLine();

            pst.setString(1,firstName);
            pst.setString(2,lastName);
            pst.setString(3, address);
            pst.setString(4, noHp);
            pst.setString(5,email);

            pst.executeUpdate();
            System.out.println("data user berhasil ditambahkan");



        }catch (SQLException e){
            System.out.println(e.getMessage());
        }
    }
    public void addProduct(){
        String addQueryProduct = "INSERT INTO Products(product_name, description, stock, category_id, price)" +
                "VALUES (?,?,?,?,?)";
        try (Connection con = DriverManager.getConnection(url, username, password);
             PreparedStatement pst = con.prepareStatement(addQueryProduct)){
            System.out.println("add product name: ");
            String productName = scanner.nextLine();
            System.out.println("put description: ");
            String description = scanner.nextLine();
            System.out.println("enter stock");
            int stock = scanner.nextInt();
            System.out.println("enter category id: ");
            int categoryId = scanner.nextInt();
            scanner.nextLine();
            System.out.println("enter price");
            int price = scanner.nextInt();

            pst.setString(1, productName);
            pst.setString(2,description);
            pst.setInt(3,stock);
            pst.setInt(4,categoryId);
            pst.setInt(5, price);
            pst.executeUpdate();

            System.out.println("data produk berhasil di input");
        }catch (SQLException e){
            System.out.println(e.getMessage());
        }
    }
    public void readProducts(){
        try(
                Connection con = DriverManager.getConnection(url,username,password);
                PreparedStatement st = con.prepareStatement(readProducts);
                ResultSet rs = st.executeQuery()){
            ResultSetMetaData rsmd =rs.getMetaData();
            int columnCount=rsmd.getColumnCount();
            ObjectMapper mapper = new ObjectMapper();
            ArrayNode arrNode = mapper.createArrayNode();
            while(rs.next()){
                ObjectNode objNode = mapper.createObjectNode();
                for(int i =1; i<=columnCount; i++){
                    String columnName = rsmd.getColumnName(i);
                    objNode.put(columnName, rs.getString(i));
                }
                arrNode.add(objNode);
            }String jsonString = mapper.writerWithDefaultPrettyPrinter().writeValueAsString(arrNode);
            System.out.println(jsonString);
        }catch (SQLException | com.fasterxml.jackson.core.JsonProcessingException e){
            System.out.println(e);
        }
    }
    public void readCustomers(){
        try(Connection con = DriverManager.getConnection(url,username,password);
            PreparedStatement st = con.prepareStatement(readCustomers);
            ResultSet rs = st.executeQuery()){
            ResultSetMetaData rsmd = rs.getMetaData();

            int columnCount = rsmd.getColumnCount();
            ObjectMapper mapper = new ObjectMapper();
            ArrayNode arrNode = mapper.createArrayNode();
            while(rs.next()){
                ObjectNode objNode = mapper.createObjectNode();
                for(int i =1; i<=columnCount; i++){
                    String columnName = rsmd.getColumnName(i);
                    objNode.put(columnName, rs.getString(i));
                }
                arrNode.add(objNode);
            }
            String jsonString = mapper.writerWithDefaultPrettyPrinter().writeValueAsString(arrNode);
            System.out.println(jsonString);
        }catch (SQLException | com.fasterxml.jackson.core.JsonProcessingException e){
            System.out.println(e);
        }
    }
    public void updatePrice(){
        String updatePriceQuery = "update products set price =? where id =?";
        try(Connection con =DriverManager.getConnection(url,username,password);
            PreparedStatement pst = con.prepareStatement(updatePriceQuery)){
            System.out.println("enter product id: ");
            int prodId = scanner.nextInt();
            scanner.nextLine();
            System.out.println("enter price update: ");
            int updatePrice = scanner.nextInt();
            scanner.nextLine();

            pst.setInt(1,updatePrice);
            pst.setInt(2,prodId);

            pst.executeUpdate();
            System.out.println("data berhasil di update");
        }catch (SQLException e){
            System.out.println(e.getMessage());
        }
    }
    public void updateAddress(){
        String updateAddressQuery ="update customers set address =? where id = ?";
        try(Connection con = DriverManager.getConnection(url,username,password);
        PreparedStatement pst = con.prepareStatement(updateAddressQuery)){
            System.out.println("input update adress for customer: ");
            String updateAdress = scanner.nextLine();
            System.out.println("input userId: ");
            int userId = scanner.nextInt();
            pst.setString(1,updateAdress);
            pst.setInt(2,userId);

            pst.executeUpdate();

            System.out.println("Address customer berhasil di update!!!");

        }catch (SQLException e){
            System.out.println(e.getMessage());
        }
    }
public void deleteCustomer(){
        String deleteCustQuery ="Delete from customers where id=?";
        try(Connection con = DriverManager.getConnection(url,username,password);
            PreparedStatement pst = con.prepareStatement(deleteCustQuery)){
            System.out.println("enter user_id you want to delete from database: ");
            int userId = scanner.nextInt();

            pst.setInt(1,userId);
            pst.executeUpdate();

            System.out.println("user berhasil dihapus!!!");

        }catch(SQLException e){
            System.out.println(e.getMessage());
        }

}



    public static void main(String[] args) {
        WeeklyDemo demo = new WeeklyDemo();
        Scanner scanner = new Scanner(System.in);
        while(true){
            System.out.println("choose an operation :"+
                    "\n1.add customer "+
                    "\n2.add product "+
                    "\n3.read product data "+
                    "\n4. read customer data"+
                    "\n5. update product price "+
                    "\n6. update cust address"+
                    "\n7. delete customers"+
                    "\n8. exit");
            int choice = scanner.nextInt();
//            scanner.nextInt();

            switch (choice){
                case 1: demo.addCustomer();
                break;
                case 2: demo.addProduct();
                break;
                case 3: demo.readProducts();
                break;
                case 4:demo.readCustomers();
                break;
                case 5: demo.updatePrice();
                break;
                case 6: demo.updateAddress();
                break;
                case 7: demo.deleteCustomer();
                break;
                case 8:
                    System.out.println("exiting");
                    return;
                default:
                    System.out.println("invalid choice!");
            }
        }
    }

}
