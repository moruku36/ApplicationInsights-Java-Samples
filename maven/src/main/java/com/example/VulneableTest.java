import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class VulnerableCode {
    public static void main(String[] args) throws IOException {
        Properties prop = new Properties();
        InputStream input = VulnerableCode.class.getClassLoader().getResourceAsStream("config.properties");
        prop.load(input);

        String url = prop.getProperty("url");
        String username = prop.getProperty("username");
        String password = prop.getProperty("password");

        try {
            Connection conn = DriverManager.getConnection(url, username, password);
            // SQLインジェクション攻撃を受ける可能性がある
            String query = "SELECT * FROM users WHERE username='" + args[0] + "'";
            conn.createStatement().executeQuery(query);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}