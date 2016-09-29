package org.darebeat.demo.stream;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;

/**
 * Created by darebeat on 9/29/16.
 */
public class App {
    public static void main(String[] args) throws IOException {
        // 1. By java.util.Scanner
        InputStream inputStream = new ByteArrayInputStream("hello world to String".getBytes());
        System.out.println("getStringByScanner: "+InputStreamToString.getStringByScanner(inputStream));

        // 2. By BufferedReader
        inputStream = new ByteArrayInputStream("hello world to String".getBytes());
        System.out.println("getStringByBufferedReader: " +InputStreamToString.getStringByBufferedReader(inputStream));

        // 3. By Apache IO
        inputStream = new ByteArrayInputStream("hello world to String".getBytes());
        System.out.println("getStringByApacheIO IOUtils.toString: "+InputStreamToString.getStringByApacheIO_toString(inputStream));

        // 4. By Apache IO
        inputStream = new ByteArrayInputStream("hello world to String".getBytes());
        System.out.println("getStringByApacheIO IOUtils.copy: "+ InputStreamToString.getStringByApacheIO_copy(inputStream));
    }
}
