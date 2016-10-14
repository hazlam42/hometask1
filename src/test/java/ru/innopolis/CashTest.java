package ru.innopolis;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.HashMap;
import java.util.Map;

/**
 * This is Unit test for Class Cash
 */
public class CashTest {

    private static Logger log = LoggerFactory.getLogger(Main.class);

    boolean condition;
    Object object;
    Map<String, GameCharacter> cache = new HashMap<>();
    Cash cash = new Cash(cache);
    GameCharacter character1 = new GameCharacter(50, "Elf", new String[]{"arch", "sword", "castet"});
    GameCharacter character2 = new GameCharacter(200, "Troll", new String[]{"bare hands", "big axe"});
    GameCharacter character3 = new GameCharacter(120, "Mag", new String[]{"spell", "invisibility"});
    GameCharacter character4 = new GameCharacter(10, "Peasant", new String[]{"shovel", "hoe", "stick"});
    GameCharacter character5 = new GameCharacter(10, "Nicromant", new String[]{"spell", "light power"});

    String key1 = "CashKey1";
    String key2 = "CashKey2";
    String key3 = "CashKey3";
    String key4 = "CashKey4";
    String key5 = "CashKey5";

    @Before
    public void setUp() throws Exception {
        cache.put(key1, character1);
        cache.put(key2, character2);
        cache.put(key3, character3);
        cache.put(key4, character4);

        cash.put(key1, character1);
        cash.put(key2, character2);
        cash.put(key3, character3);
        cash.put(key4, character4);
    }

    @After
    public void tearDown() throws Exception {
        cash.clear();
        cache.clear();
        key1 = null;
        key2 = null;
        key3 = null;
        key4 = null;
        key5 = null;
    }

    @Test
    public void put() throws Exception {
        object = cash.put(key5, character5);
        Assert.assertEquals(null, object);
        log.info("Method put() from Cash has successfully passed Unit test!");
    }

    @Test
    public void getCopy() throws Exception {

        Map<String, GameCharacter> copy = cash.getCopy();
        Assert.assertEquals(copy, cache);
        log.info("Method getCopy() from Cash has successfully passed Unit test!");

    }

    @Test
    public void get() throws Exception {
        object = cash.get(key5);
        Assert.assertEquals(null, object);
        log.info("Method get() from Cash has successfully passed Unit test!");
    }

    @Test
    public void clear() throws Exception {

        cash.clear();
        if (cash.put(key1, character1) == null) {
            condition = true;
        } else {
            condition = false;
        }
        Assert.assertTrue("Success", condition);
        log.info("Method clear() from Cash has successfully passed Unit test!");
    }

}