import java.util.Scanner; 

public class Soal1 {
  public static void main(String[] args) {
    System.out.println("Masukkan jumlah case :");
    Scanner input = new Scanner(System.in);  
    int kasus = input.nextInt();
    for (int i = 0; i < kasus; i++){
      try {
        long Jkasus = input.nextLong();
        System.out.println ("can be fitted in:");
        if (Jkasus >= -128 && Jkasus <= 127) 
          System.out.println("* byte");
        if (Jkasus >= -32768 && Jkasus <= 32767) 
          System.out.println("* short");
        if (Jkasus >= -2147483648 && Jkasus <= 2147483647) 
          System.out.println("* int");
       System.out.println("* long");
      }
      catch(Exception e){
        System.out.println(input.next() + " can't be fitted anywhere");
            }
        }
        input.close();
    }
}