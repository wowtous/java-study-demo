package org.darebeat.utils;

import org.junit.*;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import static org.darebeat.utils.TestUtils.BASEPATH;
import static org.darebeat.utils.TestUtils.SEP;
import static org.darebeat.utils.ZipUtils.*;
import static org.junit.Assert.assertTrue;

/**
 * Created by darebeat on 9/30/16.
 */
public class ZipUtilsTest {
    private static String testZip;
    private static String testZipSrc;
    private static String testZipFiles;
    private static String testZipFile;
    private static String unzipFile;

    /**
     * 在本类加载前执行，注意的是有关键字：static
     */
    @BeforeClass
    public static void testBeforeClass() {
        System.out.println("public static void testBeforeClass()");
    }

    /**
     * 在执行目标测试方法testTest()前执行
     */
    @Before
    public void testBefore() {
        System.out.println("-------------------------------------");
        System.out.println("public void testBefore()");
        testZip = BASEPATH + "zip" + SEP;
        testZipSrc = BASEPATH + "html" + SEP;
        testZipFiles = BASEPATH + "zip" + SEP + "testZips.zip";
        testZipFile = BASEPATH + "zip" + SEP + "testZip.zip";
        unzipFile = BASEPATH + "zip" + SEP + "testUnzip";

        if (!FileUtils.isFileExists(testZip)){
            FileUtils.createOrExistsDir(testZip);
        }
        System.out.println("-------------------------------------");
    }

    @Test
    public void testZipFiles() throws Exception {
        List<File> files = FileUtils.listFilesInDir(testZipSrc, false);
        FileUtils.createOrExistsFile(testZipFiles);
        zipFiles(files, testZipFiles);
    }

    @Test
    public void testZipFile() throws Exception {
        zipFile(testZipSrc, testZipFile, "测试zip");
    }

    @Test
    public void testUpZipFile() throws Exception {
        assertTrue(unzipFile(testZipFile, unzipFile));
        assertTrue(unzipFile(testZipFiles, unzipFile));
    }

    @Test
    public void testUpZipFiles() throws Exception {
        List<File> files = new ArrayList<>();
        files.add(new File(testZipFile));
        files.add(new File(testZipFiles));
        assertTrue(unzipFiles(files, unzipFile));
    }

    @Test
    public void testUnzipFileByKeyword() throws Exception {
        System.out.println((unzipFileByKeyword(testZipFile, unzipFile, ".css")).toString());
    }

    @Test
    public void testGetFileNamesInZip() throws Exception {
        System.out.println(getFilesPath(testZipFile));
    }

    @Test
    public void testGetComments() throws Exception {
        System.out.println(getComments(testZipFile));
    }

    /**
     * 在执行目标测试方法testTest()执行
     */
    @After
    public void testAfter() {
        System.out.println("-------------------------------------");
        System.out.println("public void testAfter()");
        System.out.println("-------------------------------------");
    }

    /**
     * 在本类加载后执行，注意的是有关键字：static
     */
    @AfterClass
    public static void testAfterClass() {
        System.out.println("public static void testAfterClass()");
        FileUtils.deleteDir(testZip);
    }
}
