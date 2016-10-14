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
 * This is Unit test for Deserialisation class
 */
public class DeserialisationTest {

    private static Logger log = LoggerFactory.getLogger(Main.class);
    Object character;
    Deserialisation deser = new Deserialisation();
    String filePath = System.getProperty("user.dir") + "\\Troll.txt";
    Map<String, GameCharacter> cache = new HashMap<>();
    Cash cash = new Cash(cache);
    GameCharacter two = new GameCharacter(200, "Troll", new String[]{"bare hands", "big axe"});
    String key1 = "Troll";
    Map<String, GameCharacter> copy = cash.getCopy();

    @Before
    public void setUp() throws Exception {
        cash.put(key1, two);
    }

    @After
    public void tearDown() throws Exception {
        cache.clear();
        cash.clear();
        two = null;
        filePath = null;
        deser = null;
        key1 = null;
    }

    @Test
    public void doDeser() throws Exception {

        character = deser.doDeser(filePath);
        GameCharacter char2 = (GameCharacter) character;
        GameCharacter char1 = copy.get(key1);
        Assert.assertEquals(char1.getType(), char2.getType());
        log.info("Method doDeser() from Deserialisation Class has successfully passed Unit test!");
    }

}