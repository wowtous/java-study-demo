package org.darebeat.utils;


import org.junit.Test;
import static org.junit.Assert.*;

/**
 * Created by darebeat on 9/30/16.
 */
public class StringUtilsTest {

    @Test
    public void testIsEmpty(){
        assertTrue(StringUtils.isEmpty(""));
        assertTrue(StringUtils.isEmpty(null));
        assertFalse(StringUtils.isEmpty(" "));
    }

    @Test
    public void testIsSpace(){
        assertTrue(StringUtils.isSpace(""));
        assertTrue(StringUtils.isSpace(null));
        assertTrue(StringUtils.isSpace(" "));
        assertTrue(StringUtils.isSpace("       "));
    }

    @Test
    public void testNull2Length0(){
        assertTrue("testNull2Length0",StringUtils.null2Length0(null).equals(""));
    }

    @Test
    public void testUpperFirstLetter(){
        assertEquals("testUpperFirstLetter",StringUtils.upperFirstLetter("letter"),"Letter");
    }

    @Test
    public void testLowerFirstLetter(){
        assertEquals("testLowerFirstLetter","letter",StringUtils.lowerFirstLetter("Letter"));
    }

    @Test
    public void testReverse(){
        assertEquals("testReverse",StringUtils.reverse("code"),"edoc");
    }

    @Test
    public void testToDBC(){
        assertEquals("testToDBC",StringUtils.toDBC("，"),",");
    }

    @Test
    public void testToSBC(){
        assertEquals("testToSBC",StringUtils.toSBC(","),"，");
    }

    @Test
    public void testChinesePy(){
        assertEquals("getPYFirstLetter","s",StringUtils.getPYFirstLetter("试转拼音"));
        assertEquals("cn2PY",StringUtils.cn2PY("测试转拼音"),"ceshizhuanpinyin");
    }
}
