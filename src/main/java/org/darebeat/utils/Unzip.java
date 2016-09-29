package org.darebeat.utils;

import java.io.*;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;

/**
 * Created by darebeat on 9/30/16.
 */
public class Unzip {
    public static void unzip(String zipfile,String outputPath){
        if (outputPath == null){
            outputPath = "";
        } else {
            outputPath += File.separator;
        }

        // 1.0 Create output directory
        File outputDirectory = new File(outputPath);

        if (outputDirectory.exists()){
            outputDirectory.delete();
        }
        outputDirectory.mkdir();

        // 2.0 Unzip (create folders & copy files)
        try {
            // 2.1 Get zip input stream
            ZipInputStream zip = new ZipInputStream(new FileInputStream(zipfile));

            ZipEntry entry = null;
            int len;
            byte[] buffer = new byte[1024];

            // 2.2 Go over each entry "file/folder" in zip file
            while ((entry = zip.getNextEntry()) != null){
                if (!entry.isDirectory()){
                    System.out.println("-"+entry.getName());

                    // create new file
                    File file = new File(outputPath+entry.getName());

                    // create file parent directory if it is not exists
                    if (!new File(file.getParent()).exists()){
                        new File(file.getParent()).mkdir();
                    }

                    // get new file output stream
                    FileOutputStream out = new FileOutputStream(file);

                    // copy bytes
                    while ((len = zip.read(buffer))>0){
                        out.write(buffer,0,len);
                    }
                    out.close();
                }
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
