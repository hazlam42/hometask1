package ru.innopolis;
import java.util.Map;
import java.util.Scanner;

/**
 * Main class where the program is execution
 */
class Main {

    private static Map<String, GameCharacter> cache;

    public static String[] array; // here I store name of files like elements

    private static GameCharacter character; //this is game character

    /**
     * This method creates array of elements, each element is a name of input files
     *
     * @param line taken from user input
     */
    public static void setArray(String line) {

        String myDelimiter = " "; //delimiter for parsing name of files in the line
        String[] nameArray = line.split(myDelimiter);
        for (String a : nameArray) {
            System.out.println(a);
        }
        array = nameArray;
    }

    public static void main(String[] args) throws InterruptedException {

        String currentPath = System.getProperty("user.dir") + "\\"; //current path where program will save and read files
        System.out.println(currentPath); //show current directory where files stored
        Serialisation instance = new Serialisation();
        final Cash cash = new Cash(cache);
        Scanner scan = new Scanner(System.in);
        String line;
        boolean condition = true; // switch to quit the loop

        while (condition) {

            String typeData;
            System.out.println("Do you want to deserialize files? (Y/N)");
            typeData = scan.nextLine();

            if (typeData.equalsIgnoreCase("y")) {

                System.out.println("Please enter the name of files in one line separated with space");

                line = scan.nextLine(); // take whole string for following parsing

                Main.setArray(line);

                for (final String a : array) {

                    Thread thread = new Thread(() -> {

                        Object checkUnique;

                        System.out.println(Thread.currentThread().getName() + " trying to deserialization the character... ");

                        Deserialisation d1 = new Deserialisation();

                        character = (GameCharacter) d1.doDeser(currentPath + a);

                        checkUnique = cash.put(a, character); //checking character for originality

                        if (checkUnique != null) {
                            try {
                                throw new IllegalArgumentException("There was attempt to putting same file in the cache!");
                            } catch (IllegalArgumentException e) {
                                e.printStackTrace();
                            }
                        } else
                            System.out.println(Thread.currentThread().getName() + " unzipped character type is " + character.getType());
                    });
                    thread.start();
                    thread.join();
                }
            } else {
                condition = false;
                break;
            }

            boolean condition2 = true;
            cache = cash.getCopy();

            while (condition2) {
                System.out.println("Do you want to serialize files? (Y/N)");
                typeData = scan.nextLine();
                if (typeData.equalsIgnoreCase("y")) {

                    for (Map.Entry<String, GameCharacter> entry : cache.entrySet()) {

                        character = entry.getValue();

                        System.out.println(character.getType() + " had been extracted from cache!");

                        instance.doSer(character, currentPath + "Characters.txt");

                        instance.setState(false);

                        condition2 = false;
                    }
                    System.out.println(Thread.currentThread().getName() + "  had successfully write the characters to file!");
                    instance.setState(true);

                } else {
                    condition2 = false;
                }
            }

        }
    }

}
