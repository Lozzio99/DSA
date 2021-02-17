package decodingStrings;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;
import java.util.Scanner;

public class EncryptionProgram
{
    private Scanner scanner;
    private Random random;
    private ArrayList<Character> list;
    private ArrayList<Character> shuffled;
    private Character character;
    private String line;
    private char[] letters;


    EncryptionProgram()
    {
        this.scanner = new Scanner(System.in);
        this.random = new Random();
        this.list = new ArrayList<>();
        this.shuffled = new ArrayList<>();
        this.character = ' ';
        newKey();
        askQuestion();
    }
    private void askQuestion()
    {
        while(true)
        {
            System.out.println("""
                    What do you want to do?
                     N < new key\s
                     G < get key\s
                     E < encrypt\s
                     D < decrypt\s
                     Q < quit   """);
            char response = Character.toUpperCase(scanner.nextLine().charAt(0));

            switch (response)
            {
                case 'N' -> newKey();
                case 'G' -> getKey();
                case 'E' -> encrypt();
                case 'D' -> decrypt();
                case 'Q' -> quit();
                default -> System.out.println(" <<<< >>>>");
            }
        }
    }
    private void newKey()
    {
        this.character = ' ';
        list.clear();
        shuffled.clear();

        for (int i = 32; i<127; i++)
        {
            list.add(Character.valueOf(character));
            character++;
        }
        shuffled = new ArrayList<>(list);
        Collections.shuffle(shuffled);
        System.out.println("********** New Key Generated **********");


    }

    private void getKey()
    {
        System.out.println(" KEY : ");
        for (Character x : list)
            System.out.print(x);
        System.out.println();

        for (Character x : shuffled)
            System.out.print(x);
        System.out.println();
    }
    private void encrypt()
    {
        System.out.println(" Enter a message to encrypt ");
        String message = scanner.nextLine();
        this.letters = message.toCharArray();
        for (int i = 0; i< this.letters.length;i++)
        {
            for (int j = 0; j< this.list.size(); j++)
            {
                if (letters[i] == list.get(j))
                {
                    letters[i] = shuffled.get(j);
                    break;
                }
            }
        }
        System.out.println(" Encrypted : ");
        for (char c : this.letters)
            System.out.print(c);
        System.out.println();

    }

    private void decrypt()
    {
        System.out.println(" Enter a message to decrypt ");
        String message = scanner.nextLine();
        this.letters = message.toCharArray();
        for (int i = 0; i< this.letters.length;i++)
        {
            for (int j = 0; j< this.shuffled.size(); j++)
            {
                if (letters[i] == shuffled.get(j))
                {
                    letters[i] = list.get(j);
                    break;
                }
            }
        }
        System.out.println(" Decrypted : ");
        for (char c : this.letters)
            System.out.print(c);
        System.out.println();
    }
    private void quit()
    {
        System.out.println(" Exiting ..");
        System.exit(0);
    }
}
