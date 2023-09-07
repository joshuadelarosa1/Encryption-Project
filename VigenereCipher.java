import java.io.PrintWriter;
import java.lang.String;


public class VigenereCipher{
  public static void main(String[] args) throws Exception{

    PrintWriter pen = new PrintWriter(System.out, true);

    if(args.length != 3){
      System.err.println("You have entered an incorrect number of parameters. Please try again.");
      System.exit(2);
    }

    if(args[0].equals("encode")){
      encrypt(pen, args[1], args[2]);
    }
      else if(args[0].equals("decode")){
        decrypt(pen, args[1], args[2]);
    }
    else{
      System.err.println("Valid inputs are \"encode\" or \"decode\". Please try again.");
      System.exit(1);
    }
  
  }//main

  static void encrypt(PrintWriter pen, String arg, String codeWord){
    
    int base = (int) 'a';
    int i = 0, j = 0;

    if(codeWord.isEmpty()){
      pen.println(arg);

      System.exit(0);
    }

    char[] newCodeWord = codeWord.toCharArray();
    char[] temp = arg.toCharArray();

    do {
      if((Character.isAlphabetic(temp[i])) != true){
        continue;
      }

      if(j == newCodeWord.length){
        j = 0;
      }

      int current = temp[i];
      int currentBase = current - base;
      int currentCodeWord = newCodeWord[j];
      int currentCodeWordBase = currentCodeWord - base;

      int result = (currentBase + currentCodeWordBase) % 26;
      char chNew = (char) (result + base);
      pen.print(chNew);

      i++;
      j++;
    } while (i < arg.length());

    pen.println();

  }

  static void decrypt(PrintWriter pen, String arg, String codeWord){

  }
} //class VignereCipher

//https://www.w3schools.com/java/ref_string_isempty.asp#:~:text=The%20isEmpty()%20method%20checks,)%2C%20and%20false%20if%20not.
//https://www.geeksforgeeks.org/character-array-in-java/#
//https://www.edureka.co/blog/system-exit-in-java/#:~:text=exit()%20Method%3F-,System.,by%20terminating%20Java%20Virtual%20Machine.