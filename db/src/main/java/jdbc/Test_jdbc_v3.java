package jdbc;

import java.sql.*;

/**
 * @Author:txy
 * @Date:created in 8:50 2020/3/8
 */
public class Test_jdbc_v3 {
    public static String getMysql(){
        String url="jdbc:mysql://127.0.0.1:3306/javaee01?serverTimezone=UTC";

        String drivername = "com.mysql.cj.jdbc.Driver";

        String sqlString = "select * from s_user ";

        int n = 500;
        while(n-->=0) {
            try (Connection connection = DriverManager.getConnection(url, "root", "mysqlroot")) {
                //通过连接获取statement
                try (Statement statement = connection.createStatement()) {
                    //statement （增、删、改、查）
                    try (ResultSet resultSet = statement.executeQuery(sqlString)) {
                        //获取执行结果
                        while (resultSet.next()) {
                            System.out.println(resultSet.getString(1));
                        }
                    }

                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return null;
    }

    public static void main(String[] args) {

        getMysql();
    }
}
