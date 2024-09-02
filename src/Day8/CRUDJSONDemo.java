package Day8;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.ObjectNode;

import java.sql.*;

public class CRUDJSONDemo {
    String getData = "select*from car_models";
    String url = "jdbc:postgresql://localhost:5432/bootcamp";
    String username = "postgres";
    String password = "postgres";

    public void GetData() {
        try (
                Connection con = DriverManager.getConnection(url, username, password);
//                Statement st = con.createStatement();

                // untuk security supaya tidak kena sqlinjection

                PreparedStatement st = con.prepareStatement(getData);
                ResultSet rs = st.executeQuery()) {
            ResultSetMetaData rsmd = rs.getMetaData();

            int columnCount = rsmd.getColumnCount();

            ObjectMapper mapper = new ObjectMapper();
            ArrayNode arrNode = mapper.createArrayNode();
            while(rs.next())
            {
                ObjectNode objNode = mapper.createObjectNode();
                for (int i =1; i <= columnCount; i++){
                    String columnName = rsmd.getColumnName(i);
                    objNode.put(columnName, rs.getString(i));
                }
                arrNode.add(objNode);
            }
            String jsonString = mapper.writerWithDefaultPrettyPrinter().writeValueAsString(arrNode);
            System.out.println(jsonString);
        } catch (SQLException | com.fasterxml.jackson.core.JsonProcessingException e)  {
            System.out.println(e);
        }
    }

    public void addData(){
        String addQuery = "INSERT INTO car_models(car_name, car_price, category,quantity)"+
                "VALUES (?,?,?,?)";
        try(
                Connection con = DriverManager.getConnection(url,username,password);
                PreparedStatement pst = con.prepareStatement(addQuery)){
            //add first car
            pst.setString(1,"Tesla");
            pst.setInt(2,12000000);
            pst.setString(3,"electric");
            pst.setInt(4, 300);
            pst.addBatch();
            //add first car
            pst.setString(1,"bukan Tesla");
            pst.setInt(2,15000000);
            pst.setString(3,"electric/diesel");
            pst.setInt(4, 200);
            pst.addBatch();

            //execute
            pst.executeBatch();
            System.out.println("data berhasil ditambahkan");

        }catch (SQLException e){
            throw new RuntimeException(e);
        }
    }

    public void updateData(){
        String updateQuery = "Update car_models SET car_price =?, quantity =? WHERE car_name =?";
        try(Connection con = DriverManager.getConnection(url,username,password);
        PreparedStatement pst = con.prepareStatement(updateQuery)){
            //update first car
            pst.setInt(1,500000000);
            pst.setInt(2,350);
            pst.setString(3,"bukan Tesla");

            //execute batch
            pst.executeBatch();
            System.out.println("Data berhasil di update");
        }
        catch (SQLException e){
            throw new RuntimeException();
        }
    }

    public void deleteData(){
        String deleteQuery = "DELETE FROM car_models WHERE car_name = ?";
        try(Connection con = DriverManager.getConnection(url,username,password);
            PreparedStatement pst = con.prepareStatement(deleteQuery)){

            //delete first car
            pst.setString(1,"bukan Tesla");
            pst.addBatch();

            //execute
            pst.executeBatch();
            System.out.println("data berhasil dihapus");
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
    public static void main(String[] args) {
        CRUDJSONDemo demo = new CRUDJSONDemo();
//        demo.GetData();
//        demo.addData();
        //demo.updateData();
//          demo.deleteData();
    }
}

