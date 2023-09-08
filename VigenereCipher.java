import java.io.PrintWriter;
import java.lang.String;


public class VigenereCipher{
  public static void main(String[] args) throws Exception{

    PrintWriter pen = new PrintWriter(System.out, true);

    if(args.length != 3){
      System.err.println("You have entered an incorrect number of parameters. Please try again.");
      System.exit(2);
    } //error checks for correct # of parameters

    if(args[0].equals("encode")){
      encrypt(pen, args[1], args[2]);
    } //if user inputs encode
    else if(args[0].equals("decode")){
        decrypt(pen, args[1], args[2]);
    } //if user inputs decode
    else{
      System.err.println("Valid inputs are \"encode\" or \"decode\". Please try again.");
      System.exit(1);
    } //error checking if user didn't put in valid inputs
  
  }//main

  //preconditions: takes in a print writer, a string that needs to be encoded, and the codeWord to encode string
  //postconditions: prints a string with encoded phrase
  //encrypt encodes and prints a phrase based on a keyword inputed by the user by using the Vigenere Cipher
  static void encrypt(PrintWriter pen, String arg, String codeWord){

    if(codeWord.isEmpty()){
      pen.println(arg);

      System.exit(0);
    }//if codeword is empty just gives back same word

    //declaratinos for what the arithmatic needs
    int base = (int) 'a';
    int i = 0, j = 0;
    char[] newCodeWord = codeWord.toCharArray();
    char[] temp = arg.toCharArray();
    

    do {
      if(j == newCodeWord.length){
        j = 0;
      }//this is for when codeWord is shorter than what is needed to be encoded & repeats it

      //declarations
      int current = temp[i];
      int currentBase = current - base;
      int currentCodeWord = newCodeWord[j];
      int currentCodeWordBase = currentCodeWord - base;

      //arithmetic & printing the result or chNew
      int result = (currentBase + currentCodeWordBase) % 26;
      char chNew = (char) (result + base);
      pen.print(chNew);

      //continues the loop
      i++;
      j++;
    } while (i < arg.length()); //do while

    pen.println();

  }

  //preconditions: takes in a print writer, a string that needs to be decoded, and the codeWord to decode string
  //postconditions: prints a string with decoded phrase
  //decrypt decodes and prints a phrase based on a keyword inputed by the user by using the Vigenere Cipher
  static void decrypt(PrintWriter pen, String arg, String codeWord){

    if(codeWord.isEmpty()){
      pen.println(arg);

      System.exit(0);
    }//if codeword is empty just gives back same word

    //declaratinos for what the arithmatic needs
    int base = (int) 'a';
    int i = 0, j = 0;
    char[] newCodeWord = codeWord.toCharArray();
    char[] temp = arg.toCharArray();

    do {
      if(j == newCodeWord.length){
        j = 0;
      }//this is for when codeWord is shorter than what is needed to be decoded & repeats it

      //declarations
      int current = temp[i];
      int currentBase = current - base;
      int currentCodeWord = newCodeWord[j];
      int currentCodeWordBase = currentCodeWord - base;

      //arithmetic
      int result = (currentBase - currentCodeWordBase) % 26;

      if(result < 0){
        int resultNew = (result + 26);

        char chNew = (char) (resultNew + base);
        pen.print(chNew);
      }//if result is less than zero & needs to loop around back to 'z'

      else{
      char chNew = (char) (result + base);
      pen.print(chNew);
      }//if result is not less than 0

      //continues loop
      i++;
      j++;
    } while (i < arg.length());//do while

    pen.println();

  } //decrypt
} //class VignereCipher
