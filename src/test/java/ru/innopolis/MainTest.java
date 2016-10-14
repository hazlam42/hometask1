package ru.innopolis;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static org.junit.Assert.*;

/**
 * This is Unit test of Main Class
 */
public class MainTest {

    private static Logger log = LoggerFactory.getLogger(Main.class);
    String line = "Elf ggg";
    String nameArray[];
    boolean elf = false;
    @Before
    public void setUp() throws Exception {


    }

    @After
    public void tearDown() throws Exception {
        nameArray = null;
        line = null;
    }

    @Test
    public void setArray()  {

        nameArray = line.split(" ");
        elf = nameArray[0].equals("Elf");
        assertTrue("Success", elf );
        log.info("Success");
    }

}