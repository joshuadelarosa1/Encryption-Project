import java.io.PrintWriter;

/*
 * @author: Joshua Delarosa Caeser Cipher uses the caesar cipher to encrypt and decrypt a given
 * string by the user.
 */
public class CaesarCipher {
  public static void main(String[] args) throws Exception {

    PrintWriter pen = new PrintWriter(System.out, true);

    if (args.length != 2) {
      System.err.println("You have entered an incorrect number of parameters. Please try again.");
      System.exit(2);
    } // error checks for correct # of parameters

    if (args[0].equals("encode")) {
      encrypt(pen, args[1], "encode");
    } // if user inputs encode
    else if (args[0].equals("decode")) {
      encrypt(pen, args[1], "decode");
    } // if user inputs decode
    else {
      System.err.println("Valid inputs are \"encode\" or \"decode\". Please try again.");
      System.exit(1);
    } // error checking if user didn't put in valid inputs
  } // main

  // preconditions: takes in a print writer & a string that needs to be encoded
  // postconditions: prints a string with encoded phrase
  // encrypt encodes and prints a phrase from the user by using the Caesar Cipher
  static void encrypt(PrintWriter pen, String arg, String userCall) {
    int alphaLength = 26;

    // declarations for arithmatic
    int base = (int) 'a';
    char[] str = arg.toCharArray();

    for (int n = 0; n < alphaLength; n++) {
      pen.printf("n = %d:", n);
      for (int i = 0; i < arg.length(); i++) {
        int ch = str[i];
        int temp = ch - base;

        if (userCall.equals("encode")) {
          int result = (temp + n) % alphaLength;
          char chNew = (char) (result + base);
          pen.print(chNew);
        } else if (userCall.equals("decode")) {
          int result = (temp - n) % alphaLength;

          if (result < 0) {
            char chNew = negativeResult(result);
            pen.print(chNew);
          } // if result is less than 0 and needs to loop back to z
          else {
            char chNew = (char) (result + base);
            pen.print(chNew);
          }
        }
      } // for to do arithmatic to get new values
      pen.println();
    } // for that shows all values adding from 0-26
  } // encrypt

  // preconditions: takes in the negative result
  // postconditions: returns the wrapped around char
  static char negativeResult(int result) {
    int alphaLength = 26;
    int base = (int) 'a';

    int resultNew = (result + alphaLength);
    return (char) (resultNew + base);

  } // negative result

} // class CaesarCipher


