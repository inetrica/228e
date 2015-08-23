import java.util.Scanner;

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

            boolean inOrder = isInOrder(word);

            if(inOrder){
                System.out.println("IN ORDER");
            } else {
                System.out.println("NOT IN ORDER");
            }
            System.out.println();
        }

    }

    private static boolean isInOrder(String word){
        //initial min value for 'a'
        int prev = 'a' - 1;
        for(int i = 0; i < word.length(); i++){
            int val = word.charAt(i);
            
            if(val < prev){
                return false;
            }
            prev = val;
        }
        return true;

    }

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
