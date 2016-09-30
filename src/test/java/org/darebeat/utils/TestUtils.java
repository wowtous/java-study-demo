package org.darebeat.utils;

import org.junit.runner.RunWith;
import org.robolectric.RobolectricTestRunner;
import org.robolectric.annotation.Config;
import java.io.File;

/**
 * Created by darebeat on 9/30/16.
 */
@RunWith(RobolectricTestRunner.class)
@Config(manifest = Config.NONE)
public class TestUtils {
    public static final char SEP = File.separatorChar;
    public static final String BASEPATH = System.getProperty("user.dir") + SEP + "data" + SEP;
}
