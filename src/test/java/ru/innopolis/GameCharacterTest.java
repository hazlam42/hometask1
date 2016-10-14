package ru.innopolis;

import org.junit.After;
import org.junit.Assert;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * This is Unit test for class GameCharacter
 */
public class GameCharacterTest {

    private static Logger log = LoggerFactory.getLogger(Main.class);
    GameCharacter character1 = new GameCharacter(50, "Elf", new String[]{"arch", "sword", "castet"});


    @After
    public void tearDown() throws Exception {
        character1 = null;
    }

    @Test
    public void getPower() throws Exception {

        int power = character1.getPower();
        Assert.assertEquals(50, power);
        log.info("Method getPower() from GameCharacter has successfully passed Unit test!");

    }

    @Test
    public void getType() throws Exception {

        String type = character1.getType();
        Assert.assertEquals("Elf", type);
        log.info("Method getType() from GameCharacter has successfully passed Unit test!");

    }

    @Test
    public void getWeapons() throws Exception {

        String weapons = character1.getWeapons();
        System.out.println(weapons);
        Assert.assertEquals("arch sword castet ", weapons);
        log.info("Method getWeapons() from GameCharacter has successfully passed Unit test!");

    }

}