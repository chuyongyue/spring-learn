package com.peerfintech;

import com.peerfintech.bean.soundsystem.CDPlayerConfig;
import com.peerfintech.bean.soundsystem.CompactDisc;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

/**
 * Unit test for simple App.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = CDPlayerConfig.class)
public class AppTest {

    @Autowired
    private CompactDisc cd;
    /**
     * Rigorous Test :-)
     */
    @Test
    public void cdShouldNotBeNull() {
        assertNotNull(cd);
    }
}
