import java.util.*;  
import java.io.*;
import java.util.Scanner;
   
public class Main {  
    static void isAnagram(String str1, String str2) {  
        String s1 = str1.replaceAll("\\s", "").toLowerCase();  
        String s2 = str2.replaceAll("\\s", "").toLowerCase();  
        boolean status = true;  
        if (!str1.matches("\\w") || !str1.matches("\\w")){
          if (s1.length() != s2.length()) {  
              status = false;  
          } else {  
              char[] ArrayS1 = s1.toLowerCase().toCharArray();  
              char[] ArrayS2 = s2.toLowerCase().toCharArray();  
              Arrays.sort(ArrayS1);  
              Arrays.sort(ArrayS2);  
              status = Arrays.equals(ArrayS1, ArrayS2);  
          }  
          if (status) {  
              System.out.println(s1 + " and " + s1 + " are anagrams");  
          } else {  
              System.out.println(s1 + " and " + s2 + " are not anagrams");  
          }  
        } else {
          System.out.println("Erro: Os anagramas só podem conter letras de A a Z");
        }
        
    }  


    static void geradorDeAnagrama() throws IOException {
      
      Scanner arquivo = new Scanner(System.in);
      System.out.println("Digite o caminho do arquivo: ");
      System.out.println("Ex.: C:/palavras.txt ");
      leArquivo(arquivo.nextLine());
      arquivo.close();
    }
    
    static void anagramaPalavra(String palavra){


    }

    static void leArquivo(String arquivo) throws IOException {
      File f = new File("palavras.txt");    
      Scanner scanner = new Scanner(f);
      

      while (scanner.hasNextLine()) {
      System.out.println(scanner.nextLine());
      }
      scanner.close();
    }  
    

   
    public static void main(String[] args) throws IOException {
      geradorDeAnagrama();


    }  
