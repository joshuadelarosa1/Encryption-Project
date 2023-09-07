import java.io.PrintWriter;

public class CaesarCipher{
  public static void main(String[] args) throws Exception{
    
    PrintWriter pen = new PrintWriter(System.out, true);
    
    // error checking
    if(args.length != 2){
      System.err.println("You have entered an incorrect number of parameters. Please try again.");
      System.exit(2);
    }

    if(args[0].equals("encode")){
      encrypt(pen, args[1]);
    }
    else if(args[0].equals("decode")){
      decrypt(pen, args[1]);
    }
  
    // error checking 
    else{
      System.err.println("Valid inputs are \"encode\" or \"decode\". Please try again.");
      System.exit(1);
    }   
  } // main

  static void encrypt(PrintWriter pen, String arg){
      
    int base = (int) 'a';
    char[] str = arg.toCharArray();
        
    for(int n = 0; n < 26; n++){
      pen.printf("n = %d:", n);
        for(int i = 0; i < arg.length(); i++){
          int ch = str[i];
          int temp = ch - base;

          int result = (temp + n) % 26;
          char chNew = (char) (result + base);
          pen.print(chNew);
        }
      pen.println();
    }
  } //encrypt

  static void decrypt(PrintWriter pen, String arg){
    
    int base = (int) 'a';
    char[] str = arg.toCharArray();
        
    for(int n = 0; n < 26; n++){
      pen.printf("n = %d:", n);
        for(int i = 0; i < arg.length(); i++){
          int ch = str[i];
          int temp = ch - base;
          int result = (temp - n) % 26;

          if(result < 0){
            int resultNew = (result + 26);

            char chNew = (char) (resultNew + base);
            pen.print(chNew);
          }

          else{
            char chNew = (char) (result + base);
            pen.print(chNew);
          }
        }
      pen.println();
    }
  } //decrypt
  
} // class CaesarCipher




//https://www.javatpoint.com/string-comparison-in-java
//https://www.educative.io/answers/how-to-find-the-length-of-a-string-in-java
//https://www.freecodecamp.org/news/string-to-char-array-java-tutorial/#:~:text=1.,on%20the%20current%20string%20object.
//https://www.youtube.com/watch?v=jK6NX9iyi-8
//https://www.tutorialspoint.com/java/util/scanner_close.htm#:~:text=The%20java.,()%20method%20closes%20this%20scanner.
//https://www.digitalocean.com/community/tutorials/string-char-array-java
//https://www.geeksforgeeks.org/java-program-to-get-a-character-from-a-string/#
