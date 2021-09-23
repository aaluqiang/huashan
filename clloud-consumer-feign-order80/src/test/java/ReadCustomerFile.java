import java.io.File;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import org.apache.commons.io.FileUtils;
import org.apache.commons.io.LineIterator;

public class ReadCustomerFile {

    int idx;
    Connection conn = null;
    PreparedStatement pstmt = null;

    // 使用commons-io.jar包的FileUtils的类进行读取
    public void readTxtFileByFileUtils(String fileName) {
        File file = new File(fileName);

        dbConnection();

        try {
            LineIterator lineIterator = FileUtils.lineIterator(file, "GB2312");
            while (lineIterator.hasNext()) {
                String line = lineIterator.nextLine();

                // 行数据转换成数组
                String[] custArray = line.split("\\|");
                insertCustInfo(custArray);
                Thread.sleep(10);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            dbDisConnection();
        }
    }

    // 插入到数据库中
    public void insertCustInfo(String[] strArray) {
        try {
            StringBuffer sqlBf = new StringBuffer();
            sqlBf.setLength(0);

            sqlBf.append("INSERT INTO TEMP_CUST_INFO(CUST_NO, CUST_NM, MOB_NO1)                \n");
            sqlBf.append("          VALUES(?                                                    \n");
            sqlBf.append("               , ?                                                    \n");
            sqlBf.append("               , ?)                                                   \n");

            pstmt = conn.prepareStatement(sqlBf.toString());
            idx = 1;
            pstmt.clearParameters();
            pstmt.setInt(idx++, Integer.parseInt(strArray[0]));
            pstmt.setString(idx++, strArray[1]);
            pstmt.setString(idx++, strArray[2]);

            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (pstmt != null) {
                try {
                    pstmt.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    // 连接数据库
    public Connection dbConnection() {
        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");

            String url = "jdbc:oracle:thin:@127.0.0.1:1521:orcl";
            String user = "scott";
            String password = "goodluck";

            conn = DriverManager.getConnection(url, user, password);
            System.out.println("Connection 开启！");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return conn;
    }

    // 关闭数据库
    public void dbDisConnection() {
        if (conn != null) {
            try {
                conn.close();
                System.out.println("Connection 关闭！");
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        ReadCustomerFile rcf = new ReadCustomerFile();
        rcf.readTxtFileByFileUtils("D:\\test\\customer_info.txt");
    }
}