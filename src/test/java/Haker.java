
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import org.apache.commons.io.IOUtils;

public class Haker {
    public static void main(String[] args)  throws  Exception{
        String path="http://localhost:8080/JavaWeb0531/controller/bmi_session";
        URL url = new URL(path);
        HttpURLConnection conn =(HttpURLConnection)url.openConnection();
        //塞入header
        conn.setRequestProperty("Cookie", "JSESSIONID=2287B37BA2EE2CFCE38DD4A9952734EB");
        conn.connect();
        InputStream is =conn.getInputStream();
        System.err.println(IOUtils.toString(is,"utf-8"));
}
}
