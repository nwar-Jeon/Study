package properties;

import java.io.FileReader;
import java.net.URL;
import java.net.URLDecoder;
import java.util.Properties;

public class PropertiesMain {
    public static void main(String[] a) throws Exception{
        Properties properties = new Properties();
        Class class1 = PropertiesMain.class;
        URL resource = class1.getResource("properties/db.properties");
        String path = resource.getPath();
        path = URLDecoder.decode(path, "utf-8");
        properties.load(new FileReader(path));

        String driver = properties.getProperty("driver");
        String url = properties.getProperty("url");
        String username = properties.getProperty("username");
        String password = properties.getProperty("password");

        System.out.println("driver : " + driver);
        System.out.println("url : " + url);
        System.out.println("username : "+ username);
        System.out.println("password : " + password);
    }
}
