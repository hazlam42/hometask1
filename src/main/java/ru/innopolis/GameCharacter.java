package ru.innopolis;
import java.io.Serializable;

/**
 * Class that describe some game characters
 */
class GameCharacter implements Serializable {

    private int power;
    private String type;
    private String[] weapons;

    /**
     * This method return a power of a character
     *
     * @return int power
     */
    public int getPower() {
        return power;
    }

    /**
     * This method return the type of a character
     *
     * @return string type
     */
    public String getType() {
        return type;
    }

    /**
     * This method return weapons of character
     *
     * @return string weaponlist
     */
    public String getWeapons() {

        String weaponList = "";
        for (int i = 0; i < weapons.length; i++) {
            weaponList = weaponList + weapons[i] + " ";
        }
        return weaponList;
    }

    /**
     * Constructor for tyoe GameCharacter
     *
     * @param power
     * @param type
     * @param weapons
     */
    public GameCharacter(int power, String type, String[] weapons) {
        this.power = power;
        this.type = type;
        this.weapons = weapons;
    }
}