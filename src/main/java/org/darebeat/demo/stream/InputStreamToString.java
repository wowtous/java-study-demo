package org.darebeat.demo.stream;

import org.apache.commons.io.IOUtils;

import java.io.*;
import java.util.Scanner;

/**
 * Created by darebeat on 9/29/16.
 */
public class InputStreamToString {
    // 1. By java.util.Scanner
    public static String getStringByScanner(InputStream inputStream){
        return new Scanner(inputStream,"UTF-8").next();
    }

    // 2. By BufferedReader
    public static String getStringByBufferedReader(InputStream inputStream) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));

        String line = "";
        String result = "";

        while ((line = bufferedReader.readLine()) != null){
            result += line;
        }
        return result;
    }

    // 3. By Apache IO
    public static String getStringByApacheIO_toString(InputStream inputStream) throws IOException {
        return IOUtils.toString(inputStream);
    }

    // 4. By Apache IO
    public static String getStringByApacheIO_copy(InputStream inputStream) throws IOException {
        StringWriter writer = new StringWriter();
        IOUtils.copy(inputStream,writer,"UTF-8");
        return writer.toString();
    }

}
