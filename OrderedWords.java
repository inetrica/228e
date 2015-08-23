import java.util.Scanner;

/**
 * This class prompts the user for a word.
 * The user will be notified if the word is in alphabetical order, in reverse
 * alphabetical order, or not in order
 *
 */
public class OrderedWords {
    public static void main(String[] args){
        //input string
        String word = "";
        //input scanner
        Scanner stdin = new Scanner(System.in);
        //boolean for quitting program
        boolean done = false;

        System.out.println("Please enter q! if you would like to quit.\n");

        //main loop
        while(!done){
            word = getInput(stdin);

            int inOrder = isInOrder(word);

            if(inOrder == 0){
                System.out.println("IN ORDER");
            } else if (inOrder == 1) {
                System.out.println("NOT IN ORDER");
            } else if (inOrder == 2) {
                System.out.println("REVERSE ORDER");
            } else {
                System.err.println("An error occured processing this word");
            }
            System.out.println();
        }

    }

    /**
     *  in order returns 0
     *  out of order returns 1
     *  reverse order returns 2
     */
    private static int isInOrder(String word){
        //initial min value for 'a'
        int prev = 1;

        //orders
        boolean order, reverse;
        order = true;
        reverse = true;
        
        //iterate through the letters of the word, 
        //determining whether they are in order
        for(int i = 0; i < word.length(); i++){
            int val = word.charAt(i);
            //if  its the first letter, nothing to compare yet
            if(i==0){
                prev = val;
                continue;
            }
            
            //if the next char is smaller, its not in order
            //if the next char is greater, its not in reverse order
            if(val < prev){
                order = false;
            } else if (val > prev){
                reverse = false;
            }
            
            //if we've already determined its neither in order, nor in reverse
            //just return as "not in order"
            if(!order && !reverse){
                return 1;
            }

            prev = val;
        }

        if(order) return 0;
        if(reverse) return 2;

        return -1;
    }

    /**
     *   use this function to get user input
     *   if input is 'q!', we quit
     *   if input contains anything besides letters, re-prompt for input
     */
    private static String getInput(Scanner stdin){
        //TODO handle invalid input (only ints or symbols)
        boolean valid = true;
        String w = "";
        do{
            valid = true;
            System.out.println("Please enter a word:");
            w = stdin.next();
            if(w.equals("q!")) System.exit(0);
            if(!w.matches("^[a-zA-Z]+$")){
                valid = false;
                System.out.println("Please do not include numbers or symbols.");
            }
        } while(!valid);
        return w.toLowerCase();
    }
}
