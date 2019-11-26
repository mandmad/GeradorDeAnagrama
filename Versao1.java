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
        System.out.println("Digite a palavra: ");
        lePalavra(arquivo.nextLine());
        arquivo.close();
      }
      
      static void imprimeAnagramas(String str1, String str2){

          //System.out.println("Comparando as palavras: "+ str1 +" e "+ str2);
          HashMap<Character, Integer> hmap1 
              = new HashMap<Character, Integer>(); 
          HashMap<Character, Integer> hmap2 
              = new HashMap<Character, Integer>(); 
    
          char arr1[] = str1.toCharArray(); 
          char arr2[] = str2.toCharArray(); 
    
          // Mapping first string 
          for (int i = 0; i < arr1.length; i++) { 
    
              if (hmap1.get(arr1[i]) == null) { 
    
                  hmap1.put(arr1[i], 1); 
              } 
              else { 
                  Integer c = (int)hmap1.get(arr1[i]); 
                  hmap1.put(arr1[i], ++c); 
              } 
          } 
    
          // Mapping second String 
          for (int j = 0; j < arr2.length; j++) { 
    
              if (hmap2.get(arr2[j]) == null) 
                  hmap2.put(arr2[j], 1); 
              else { 
    
                  Integer d = (int)hmap2.get(arr2[j]); 
                  hmap2.put(arr2[j], ++d); 
              } 
          } 
    
          if (hmap1.equals(hmap2)) 
              System.out.println(arr2);                

      }

      static void lePalavra(String arquivo) throws IOException {
        File f = new File("dicionario.txt");    
        Scanner scanner = new Scanner(f);
        
        System.out.println("Entrando para comparar a palavra: "+arquivo);
        while (scanner.hasNextLine()) {
        //System.out.println("Gerando anagramas da palavra: " + scanner.nextLine());
          imprimeAnagramas(scanner.nextLine(), arquivo);
          //System.out.println(scanner.nextLine());
        }
        scanner.close();
      }  
      

    
      public static void main(String[] args) throws IOException {
        geradorDeAnagrama();


      }  

  }  
