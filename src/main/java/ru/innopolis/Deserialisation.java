package ru.innopolis;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.Serializable;

/**
 * Deserialization class
 */
class Deserialisation implements Serializable {

    private static Object gameCharacter;

    /**
     * This method is realise the deserialization of a character from file
     *
     * @param fName
     * @return unpacked character from file
     */
    public Object doDeser( String fName) {

        try {
            ObjectInputStream is = new ObjectInputStream(new FileInputStream(fName));
            gameCharacter = is.readObject();

        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return gameCharacter;
    }
}