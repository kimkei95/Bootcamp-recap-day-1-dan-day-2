package Day8;

import java.sql.*;

public class CRUDDemo {
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
            while(rs.next())
            {
                for (int i =1; i <= columnCount; i++){
                System.out.println(rs.getString(i)+"\t");
            }
                System.out.println();
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
    }

    public static void main(String[] args) {
        CRUDDemo demo = new CRUDDemo();
        demo.GetData();
    }
}
