package org.cp.inet;

import org.junit.Test;

import javax.net.ssl.HttpsURLConnection;
import java.io.*;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

/**
 * create by CP on 2019/9/23 0023.
 */
public class URLTest {

    @Test
    public void test1() {
        HttpURLConnection urlConnection = null;
        FileOutputStream outputStream = null;
        InputStream inputStream = null;
        try {
            URL url = new URL("http://192.168.0.100:8008/icons/dicon.png");
            urlConnection = (HttpURLConnection) url.openConnection();
            urlConnection.connect();
            inputStream = urlConnection.getInputStream();
            outputStream = new FileOutputStream("dicon.png");
            byte[] buf = new byte[1024];
            int len;
            while ((len = inputStream.read(buf))!=-1) {
                outputStream.write(buf, 0, len);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            CloseUtil.close(inputStream, outputStream);
            urlConnection.disconnect();
        }
    }
}
