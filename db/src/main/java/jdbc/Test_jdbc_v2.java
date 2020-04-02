package jdbc;

import java.sql.*;

/**
 * @Author:txy
 * @Date:created in 8:50 2020/3/8
 */
public class Test_jdbc_v2 {
    public static String getMysql() throws SQLException {
        String url="jdbc:mysql://127.0.0.1:3306/javaee01?serverTimezone=UTC";

        String drivername = "com.mysql.cj.jdbc.Driver";

        String sqlString = "select * from s_user ";
        Connection connection = null;
        Statement statement = null;
        ResultSet resultSet = null;
        int n = 500;
        while (n-->=0) {
            try {
                //加载驱动
                Class.forName(drivername);
                //创建连接
                connection = DriverManager.getConnection(url, "root", "mysqlroot");
                //通过连接获取statement
                statement = connection.createStatement();
                //statement （增、删、改、查）
                resultSet = statement.executeQuery(sqlString);
                //获取执行结果
                while (resultSet.next()) {
                    System.out.println(resultSet.getString(1));
                }


            } catch (ClassNotFoundException | SQLException e) {
                e.printStackTrace();
            } finally {
                if (null != resultSet) {
                    try {
                        resultSet.close();
                    } catch (SQLException e) {
                        e.printStackTrace();
                    }
                }
                if (null != statement) {
                    try {
                        statement.close();
                    } catch (SQLException e) {
                        e.printStackTrace();
                    }
                }
                if (null != connection) {
                    try {
                        connection.close();
                    } catch (SQLException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
        return null;
    }

    public static void main(String[] args) {

        try {
            getMysql();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
