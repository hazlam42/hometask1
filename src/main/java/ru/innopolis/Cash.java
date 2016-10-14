package ru.innopolis;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/**
 *  Realisation of Cache
 */
class Cash {

    private static Object object = new Object();

    private Map<String, GameCharacter> cash;

    /**
     * Constructor for initialize HashMap
     * @param cash
     */
    public Cash(Map<String, GameCharacter> cash) {
        this.cash = Collections.synchronizedMap(new HashMap<String, GameCharacter>());
    }

    /**
     * This method need for reference to HashMap
     * @return reference to HashMap
     */
    public Map<String,GameCharacter> getCopy(){
        return cash;
    }


    /**
     * This method needed for putting <v,K> to HashMap
     * @param cashKey
     * @param value
     * @return the previous value associated with cashKey, or
     *         null if there was no mapping for cashKey.
     */
    public Object put(String cashKey, GameCharacter value ){
        return cash.put(cashKey, value);
    }

    /**
     * This method needed for getting value associated with cashKey
     * @param cashKey
     * @return the previous value associated with cashKey, or
     *         null if there was no mapping for cashKey.
     */
    public Object get(String cashKey){
        return cash.get(cashKey);
    }

    /**
     * Removes all of the mappings from this HashMap .
     */
    public void clear(){
        cash.clear();
    }
}
