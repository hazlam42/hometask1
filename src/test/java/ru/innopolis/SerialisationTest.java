package ru.innopolis;

import org.junit.After;
import org.junit.Assert;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * This is Unit test for class Serialisation
 */
public class SerialisationTest {

    private static Logger log = LoggerFactory.getLogger(Main.class);

    boolean check;
    String fName = System.getProperty("user.dir") + "\\UnitTest.txt";
    Serialisation ser = new Serialisation();
    GameCharacter character1 = new GameCharacter(50, "Elf", new String[]{"arch", "sword", "castet"});

    @After
    public void tearDown() throws Exception {

        fName = null;
        ser = null;
        character1 = null;

    }

    @Test
    public void setState() throws Exception {
            ser.setState(false);
            Assert.assertFalse("Success!", false);
            log.info("Method setState() from Serelisation Class has successfully passed Unit test!");
    }

    @Test
    public void doSer() throws Exception {

        check = ser.doSer(character1, fName );
        Assert.assertTrue("Success", check);
        log.info("Method doSer() from Serelisation Class has successfully passed Unit test!");

    }

}