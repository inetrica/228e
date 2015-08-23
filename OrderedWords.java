import java.util.Scanner;

public class OrderedWord {
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
        }

    }

    private boolean isInOrder(String word){
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

    private String getInput(Scanner stdin){
        //TODO handle invalid input (only ints or symbols)
        boolean valid = true;
        String w = "";
        do{
            System.out.println("Please enter a word.");
            System.out.println("Please do not include numbers or symbols:");
            w = stdin.next();
            if(w.equals("q!")) System.exit(0);
        } while(!valid);
        return w.toLowerCase();
    }
}
