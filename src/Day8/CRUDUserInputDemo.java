package Day8;

import java.sql.*;
import java.util.Scanner;

public class CRUDUserInputDemo {
    String url = "jdbc:postgresql://localhost:5432/bootcamp";
    String username = "postgres";
    String password = "postgres";
    Scanner scanner = new Scanner(System.in);
    public void addData() {
        String addQuery = "INSERT INTO car_models(car_name, car_price, category,quantity)" +
                "VALUES (?,?,?,?)";


        try (Connection con = DriverManager.getConnection(url, username, password);
                PreparedStatement pst = con.prepareStatement(addQuery)) {
            System.out.println("enter car name: ");
            String carName = scanner.nextLine();
            System.out.println("enter car price: ");
            int carPrice = scanner.nextInt();
            scanner.nextLine();

            System.out.println("print category: ");
            String category = scanner.nextLine();
            System.out.println("print quantity:");
            int quantity = scanner.nextInt();

            pst.setString(1,carName);
            pst.setInt(2,carPrice);
            pst.setString(3,category);
            pst.setInt(4,quantity);

            pst.executeUpdate();

            System.out.println("data berhasil di input!");
        }catch (SQLException e){
            System.out.println(e.getMessage());
        }
    }

    public void updateData(){
        String updateQuery = "Update car_models SET car_price =?, quantity =? WHERE car_name =?";
        try(Connection con = DriverManager.getConnection(url,username,password);
            PreparedStatement pst = con.prepareStatement(updateQuery)){
            System.out.println("enter car price: ");
            int carPrice = scanner.nextInt();
            System.out.println("insert quantity: ");
            int quantity = scanner.nextInt();
            scanner.nextLine();
            System.out.println("input car name: ");
            String carName = scanner.nextLine();
            pst.setInt(1,carPrice);
            pst.setInt(2,quantity);
            pst.setString(3,carName);


            pst.executeUpdate();
            System.out.println("data berhasil di update");

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public void deleteData(){
        String deleteQuery = "DELETE FROM transaction_history WHERE "+
                "order_id IN (SELECT order_id FROM car_orders where car_id = ?)";
        String deleteOrdersQuery = "DELETE FROM car_orders WHERE car_id = ?";
        String deleteCarModelQuery = "DELETE FROM car_models WHERE id = ?";

        System.out.println("enter car id to delete: ");
        int carId = scanner.nextInt();

        try(Connection con = DriverManager.getConnection(url,username,password)){
            con.setAutoCommit(false);// start transaction
           try(PreparedStatement pstDeleteQuery = con.prepareStatement(deleteQuery);
            PreparedStatement pstDeleteOrders= con.prepareStatement(deleteOrdersQuery);
            PreparedStatement pstDeleteCarModel = con.prepareStatement(deleteCarModelQuery)){

               //delete from car_order_history
               pstDeleteQuery.setInt(1,carId);
               pstDeleteQuery.executeUpdate();

               //delete from car_orders
               pstDeleteOrders.setInt(1,carId);
               pstDeleteOrders.executeUpdate();

               //delete from car_models
               pstDeleteCarModel.setInt(1,carId);
               pstDeleteCarModel.executeUpdate();

               con.commit(); //comit transaction
               System.out.println("menghapus order berhasil");


            }catch(SQLException e){
               con.rollback();
               System.out.println(e.getMessage());
           }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

    }
    public void addOrderWithHistory(){
        String addOrderQuery = "INSERT INTO car_orders(car_id,order_date,quantity) values(?,?,?)";
        String addOrderHistoryQuery = "INSERT INTO transaction_history(order_id,order_history_date) values(?,?)";
        String UpdateCarModelQuantityQuery = "UPDATE car_models set quantity = quantity-? WHERE id=?";

        try(Connection con = DriverManager.getConnection(url,username,password)){
            con.setAutoCommit(false);
            try(PreparedStatement pstOrder = con.prepareStatement(addOrderQuery, PreparedStatement.RETURN_GENERATED_KEYS);
            PreparedStatement pstOrderHistory = con.prepareStatement(addOrderHistoryQuery);
            PreparedStatement pstUpdateCarModel = con.prepareStatement(UpdateCarModelQuantityQuery)) {
                System.out.println("enter car id : ");
                int carId = scanner.nextInt();
                scanner.nextLine();
                System.out.println("enter order date(yyyy-mm-dd): ");
                String orderDate = scanner.nextLine();
                System.out.println("enter quantity: ");
                int quantity = scanner.nextInt();
                scanner.nextLine();

                pstOrder.setInt(1, carId);
                pstOrder.setDate(2, java.sql.Date.valueOf(orderDate));
                pstOrder.setInt(3, quantity);
                pstOrder.executeUpdate();
                ResultSet rs = pstOrder.getGeneratedKeys();
                if (rs.next()) {
                    int orderId = rs.getInt(1);

                    pstOrderHistory.setInt(1, orderId);
                    pstOrderHistory.setDate(2, java.sql.Date.valueOf(orderDate));
                    pstOrderHistory.executeUpdate();

                    pstUpdateCarModel.setInt(1,quantity);
                    pstUpdateCarModel.setInt(2,carId);
                    pstUpdateCarModel.executeUpdate();
                    con.commit();
                    System.out.println("order and order history inserted");
                } else {
                    con.rollback();
                    System.out.println("failed to retrieve order ID");
                }


            }catch (SQLException e){
                con.rollback();
                System.out.println(e.getMessage());
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);

        }
    }

    public static void main(String[] args) {
        CRUDUserInputDemo demo = new CRUDUserInputDemo();
        Scanner scanner = new Scanner(System.in);

        while(true){
            System.out.println("choose an operation: "+
                    "\n1. add data"+
                    "\n2. update data"+
                    "\n3. delete data"+
                    "\n4. add order"+
                    "\n5. exit");
            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice){
                case 1: demo.addData();
                break;
                case 2: demo.updateData();
                break;
                  case 3: demo.deleteData();
                    break;
                case 4:
                    demo.addOrderWithHistory();
                    break;
                case 5:
                    System.out.println("exiting");
                    return;
                default:
                    System.out.println("invalid choice");
            }
        }
    }
}