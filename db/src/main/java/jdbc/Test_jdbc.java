package jdbc;

import java.sql.*;

/**
 * @Author:txy
 * @Date:created in 8:50 2020/3/8
 */
public class Test_jdbc {
    public static String getMysql(){
        String url="jdbc:mysql://127.0.0.1:3306/javaee01?serverTimezone=UTC";

        String drivername = "com.mysql.cj.jdbc.Driver";

        String sqlString = "select * from s_user ";


        try{
            //加载驱动
            Class.forName(drivername);//可以省略
            //创建连接
            Connection connection =  DriverManager.getConnection(url,"root","mysqlroot");
            //通过连接获取statement
            Statement statement = connection.createStatement();
            //statement （增、删、改、查）
            ResultSet resultSet = statement.executeQuery(sqlString);
            //获取执行结果
            while(resultSet.next()) {
                System.out.println(resultSet.getString(1));
            }
        }catch (SQLException | ClassNotFoundException e){
            e.printStackTrace();
        }

        return null;
    }

    public static void main(String[] args) {

        getMysql();
    }
}
