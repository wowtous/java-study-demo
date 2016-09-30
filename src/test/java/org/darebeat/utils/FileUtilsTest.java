package org.darebeat.utils;

import org.junit.Test;

import java.io.File;
import java.io.FileInputStream;
import java.io.FilenameFilter;

import static org.darebeat.utils.FileUtils.*;
import static org.junit.Assert.*;

/**
 * Created by darebeat on 9/30/16.
 */
public class FileUtilsTest {
    String path = TestUtils.BASEPATH + "tmp" + TestUtils.SEP;
    String path1 = TestUtils.BASEPATH + "tmp1" + TestUtils.SEP;
    String path2 = TestUtils.BASEPATH + "tmp2" + TestUtils.SEP;
    String filePath = path + "test.file";
    String filePath1 = path1 + "test.file";
    String filePath2 = path2 + "test.file";

    @Test
    public void testGetFileByPath(){
        assertEquals("testGetFileByPath",getFileByPath(" "),null);
        assertTrue("testGetFileByPath",getFileByPath(path).exists());
    }

    @Test
    public void testIsFileExists(){
        assertTrue("testIsFileExists String",isFileExists(path));
        assertTrue("testIsFileExists File",isFileExists(new File(path)));
    }

    @Test
    public void testIsDir(){
        assertTrue("testIsDir String",isDir(path));
        assertTrue("testIsDir File",isDir(new File(path)));
    }

    @Test
    public void testIsFile(){
        assertTrue("testIsFile String",isFile(filePath));
        assertTrue("testIsFile file",isFile(new File(filePath)));
    }

    @Test
    public void testCreateOrExistsDir(){
        assertFalse("testCreateOrExistsDir without path",createOrExistsDir(" "));
        assertTrue("testCreateOrExistsDir String",createOrExistsDir(path));
        assertFalse("testCreateOrExistsDir String",createOrExistsDir(filePath));
        assertTrue("testCreateOrExistsDir File",createOrExistsDir(new File(path)));
    }

    @Test
    public void testCreateOrExistsFile() throws Exception {
        assertTrue(createOrExistsFile(path+"test1.file"));
        assertTrue(createOrExistsFile(new File(filePath)));
        assertTrue(createOrExistsFile(filePath));
        assertFalse(createOrExistsFile(path));
        assertFalse(createOrExistsFile(" "));
    }

    @Test
    public void testCreateFileByDeleteOldFile(){
        assertTrue(createFileByDeleteOldFile(filePath));
        assertFalse(createFileByDeleteOldFile(path));
        assertTrue(createFileByDeleteOldFile(new File(filePath)));
        assertFalse(createFileByDeleteOldFile(" "));
    }

    @Test
    public void testCopyOrMoveDir(){
        assertFalse(copyDir(path,path));
        assertFalse(copyDir(path,filePath));
        if (isFileExists(path1)){
            FileUtils.deleteDir(path1);
        }
        assertTrue(copyDir(path,path1));

        assertFalse(moveDir(path,path));
        assertFalse(moveDir(path,filePath));
        if (isFileExists(path2)){
            FileUtils.deleteDir(path2);
        }
        assertTrue(moveDir(path1,path2));
    }

    @Test
    public void testCopyOrMoveFile() {
        if (isFileExists(filePath1)){
            assertTrue(deleteFilesInDir(path1));
        }
        assertTrue(copyFile(filePath,filePath1));
        assertFalse(copyFile(filePath,filePath1));

        if (isFileExists(filePath2)){
            assertTrue(deleteFile(filePath2));
        }
        assertTrue(moveFile(filePath1,filePath2));
        assertFalse(moveFile(filePath1,filePath2));
    }

    @Test
    public void testListFilesInDir() throws Exception {
        System.out.println(listFilesInDir(path).toString());
        System.out.println(listFilesInDir(path, false).toString());
        System.out.println(listFilesInDir(path, true).toString());
    }

    FilenameFilter filter = new FilenameFilter() {
        public boolean accept(File dir, String name) {
            return name.endsWith(".file");
        }
    };

    @Test
    public void testListFilesInDirWithFilter() throws Exception {
        System.out.println(listFilesInDirWithFilter(path, ".file").toString());
        System.out.println(listFilesInDirWithFilter(path, ".file", false).toString());
        System.out.println(listFilesInDirWithFilter(path, ".file", true).toString());
        System.out.println(listFilesInDirWithFilter(path, filter).toString());
        System.out.println(listFilesInDirWithFilter(path, filter, false).toString());
        System.out.println(listFilesInDirWithFilter(path, filter, true).toString());
    }

    @Test
    public void testSearchFile() throws Exception {
        System.out.println(searchFileInDir(path, "test.file").toString());
        System.out.println(searchFileInDir(path, ".gitignore").toString());
    }


    @Test
    public void testWriteFileFromIS() throws Exception {
        assertTrue(writeFileFromIS(path + "NEW.txt", new FileInputStream(path + ".gitignore"), false));
        assertTrue(writeFileFromIS(path + "NEW.txt", new FileInputStream(path + ".gitignore"), true));
    }

    @Test
    public void testWriteFileFromString() throws Exception {
        assertTrue(writeFileFromString(path + "NEW.txt", "这是新的", false));
        assertTrue(writeFileFromString(path + "NEW.txt", "\r\n这是追加的", true));
        assertTrue(writeFileFromString(path + "NEW.txt", "\r\n这是追加的1", true));
        assertTrue(writeFileFromString(path + "NEW.txt", "\r\n这是追加的2", true));
        assertTrue(writeFileFromString(path + "NEW.txt", "\r\n这是追加的3", true));
        assertTrue(writeFileFromString(path + "NEW.txt", "\r\n这是追加的4", true));
        assertTrue(writeFileFromString(path + "NEW.txt", "\r\n这是追加的5", true));
        assertTrue(writeFileFromString(path + "NEW.txt", "\r\n这是追加的6", true));
    }

    @Test
    public void testGetFileCharsetSimple() throws Exception {
        assertEquals(getFileCharsetSimple(path + ".gitignore"),"GBK");
    }

    @Test
    public void testGetFileLines() throws Exception {
        assertEquals(getFileLines(path + "test.file"),1);
    }

    @Test
    public void testReadFile2List() throws Exception {
        System.out.println(readFile2List(path + "NEW.txt", "").toString());
        System.out.println(readFile2List(path + "NEW.txt", "UTF-8").toString());
        System.out.println(readFile2List(path + "NEW.txt", 2, 5, "UTF-8").toString());
        System.out.println(readFile2List(path + "NEW.txt", "GBK").toString());
    }

    @Test
    public void testReadFile2String() throws Exception {
        System.out.println(readFile2String(path + "NEW.txt", ""));
        System.out.println(readFile2String(path + "NEW.txt", "UTF-8"));
        System.out.println(readFile2String(path + "NEW.txt", "GBK"));
    }

    @Test
    public void testReadFile2Bytes() throws Exception {
        System.out.println(new String(readFile2Bytes(path + "NEW.txt")));
    }

    @Test
    public void testGetFileSize() throws Exception {
        assertEquals(getFileSize(path + ".gitignore"),"2.000B");
    }

    @Test
    public void testGetDirName() throws Exception {
        assertEquals(getDirName(new File(path + "NEW.txt")),path);
        assertEquals(getDirName(path + "NEW.txt"),path);
    }

    @Test
    public void testGetFileName() throws Exception {
        assertEquals(getFileName(new File(path + "NEW.txt")),"NEW.txt");
        assertEquals(getFileName(path + "NEW.txt"),"NEW.txt");
    }

    @Test
    public void testGetFileNameNoExtension() throws Exception {
        assertEquals(getFileNameNoExtension(new File(path + "NEW.txt")),"NEW");
        assertEquals(getFileNameNoExtension(path + "NEW.txt"),"NEW");
    }

    @Test
    public void testGetFileExtension() throws Exception {
        assertEquals(getFileExtension(new File(path + "NEW.txt")),"txt");
        assertEquals(getFileExtension(path + "NEW.txt"),"txt");
    }
}
