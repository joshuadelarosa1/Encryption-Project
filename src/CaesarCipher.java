package src;

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
      encrypt(pen, args[1]);
    } // if user inputs encode
    else if (args[0].equals("decode")) {
      decrypt(pen, args[1]);
    } // if user inputs decode
    else {
      System.err.println("Valid inputs are \"encode\" or \"decode\". Please try again.");
      System.exit(1);
    } // error checking if user didn't put in valid inputs
  } // main

  // preconditions: takes in a print writer & a string that needs to be encoded
  // postconditions: prints a string with encoded phrase
  // encrypt encodes and prints a phrase from the user by using the Caesar Cipher
  static void encrypt(PrintWriter pen, String arg) {
    int alphaLength = 26;

    // declarations for arithmatic
    int base = (int) 'a';
    char[] str = arg.toCharArray();

    for (int n = 0; n < alphaLength; n++) {
      pen.printf("n = %d:", n);
      for (int i = 0; i < arg.length(); i++) {
        int ch = str[i];
        int temp = ch - base;

        int result = (temp + n) % alphaLength;
        char chNew = (char) (result + base);
        pen.print(chNew);
      } // for to do arithmatic to get new values
      pen.println();
    } // for that shows all values adding from 0-26
  } // encrypt

  // preconditions: takes in a print writer & a string that needs to be encoded
  // postconditions: prints a string with encoded phrase
  // decrypt deocdes and prints a phrase from the user by using the Caesar Cipher
  static void decrypt(PrintWriter pen, String arg) {
    int alphaLength = 26;

    // declarations for arithmatic
    int base = (int) 'a';
    char[] str = arg.toCharArray();

    for (int n = 0; n < alphaLength; n++) {
      pen.printf("n = %d:", n);
      for (int i = 0; i < arg.length(); i++) {
        int ch = str[i];
        int temp = ch - base;
        int result = (temp - n) % alphaLength;

        if (result < 0) {
          int resultNew = (result + alphaLength);

          char chNew = (char) (resultNew + base);
          pen.print(chNew);
        } // if result is less than 0 and needs to loop back to z

        else {
          char chNew = (char) (result + base);
          pen.print(chNew);
        } // normal cases where it does not become negative
      } // for to do arithmatic for decoding
      pen.println();
    } // for to show all decryption options
  } // decrypt

} // class CaesarCipher


