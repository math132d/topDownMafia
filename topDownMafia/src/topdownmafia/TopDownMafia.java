package topdownmafia;

import java.util.Scanner;

/**
 *
 * @author majoh
 */
public class TopDownMafia {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean correctName = false;
        String name = null;
        
        System.out.println("This game is suppesed to one day be a cool Mafia-esque thingamadohicky.");
        System.out.println("Please enter your name, All I will do is print it, cause I'm cool!");
        System.out.println("And so I know you're interested in this project *wink *wink");
        System.out.println("How bout you just type your name now!");
        
        
        while(!correctName){
            name = scanner.nextLine();

            if(name.contains(" ")){
                System.out.println("Names don't usually contain spaces you dingo!");
                System.out.println("Just your first name please ;)");
            }else{
                correctName = true;
            }
        }
        
        System.out.println("Hello " + name + ", nice to have you on board! ;*");
    }
}