package ru.innopolis;

import java.io.*;

/**
 * Serialization class
 */
public class Serialisation implements Serializable {



    private boolean state = true;

    private boolean aBoolean = true;

    private static String currentPath = System.getProperty("user.dir") + "\\";

    private Object object;

    private GameCharacter character;

    /**
     * Constructor
     */
    public Serialisation() {
    }

    /**
     * This method using within doSer()
     *
     * @param state
     */
    public void setState(boolean state) {
        this.state = state;
    }

    /**
     * This is getter for state
     * @return state
     */
    public boolean isState() {
     return state;
    }

    /**
     * This method do serialize game characters into the file Characetrs.txt
     *
     * @param character
     * @param fName
     */
    public boolean doSer(GameCharacter character, String fName) {

        File f = new File(currentPath + "Characters.txt"); //creating file

        if (f.exists() && state) {

            try {
                FileOutputStream fileStream = new FileOutputStream(fName);
                try (ObjectOutputStream os = new ObjectOutputStream(fileStream)) {

                    os.writeObject(character);
                    os.flush();
                    os.close();
                }
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
            return aBoolean;

        } else if (state == false) {
            try {
                FileOutputStream fileStream = new FileOutputStream(fName, true);
                try (ObjectOutputStream os = new ObjectOutputStream(fileStream)) {

                    os.writeObject(character);
                    os.flush();
                    os.close();
                }
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
            return  aBoolean;

        } else if (!f.exists()) {
            try {
                FileOutputStream fileStream = new FileOutputStream(fName);
                try (ObjectOutputStream os = new ObjectOutputStream(fileStream)) {

                    os.writeObject(character);
                    os.flush();
                    os.close();
                }
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
            return aBoolean;
        }
        return aBoolean = false;
    }

}
