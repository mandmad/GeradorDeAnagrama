import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Scanner;

public class GeradorDeAnagrama 
{ 
    public static void main(String[] args) throws FileNotFoundException 
    { 
        String str = "vermelho"; 
        int n = str.length(); 
        GeradorDeAnagrama permutation = new GeradorDeAnagrama(); 
        permutation.permute(str, 0, n-1); 
        
       // imprimeAnagramas("hmeoevrl", "elm ho rev");
        
        
    } 
  

    private void permute(String str, int l, int r) throws FileNotFoundException 
    { 
        File f = new File("C:/Users/Amanda/Desktop/Palavras.txt");    
        Scanner scanner = new Scanner(f);
        
        String String4;
        String4 = "";
        
        if (l == r) {
          // System.out.println("String inputada: " +str); 
           String String1 = str;
          
           while (scanner.hasNextLine() && !(str.isEmpty())){
    
        	  String String2 = scanner.nextLine();
        	  String String3 = str.replace(String2, "");
        	  //str = str.replace(String2, "");
        	  // System.out.println("Linha do arquivo sendo lida: "+ String2);
        	   //System.out.println("String inputada - linha do arquivo: "+String3);
        	   if (String2 != String3) {
        		   String4 += "," + String2;
        	   }
        	 //  System.out.println(String4);
        	   
        	 imprimeAnagramas(String2, String3);
        	   
           }
           //System.out.println(String4);
           
          
           
        } else
        { 
            for (int i = l; i <= r; i++) 
            { 
                str = swap(str,l,i); 
                permute(str, l+1, r); 
                str = swap(str,l,i); 
            } 
        } 
    } 
  

    public String swap(String a, int i, int j) 
    { 
        char temp; 
        char[] charArray = a.toCharArray(); 
        temp = charArray[i] ; 
        charArray[i] = charArray[j]; 
        charArray[j] = temp; 
        return String.valueOf(charArray); 
    } 
    
    static void imprimeAnagramas(String str1, String str2){

         str1 = str1.replaceAll("\\s", "").toLowerCase();  
         str2 = str2.replaceAll("\\s", "").toLowerCase(); 
       // System.out.println("Comparando as palavras: "+ str1 +" e "+ str2);
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
            System.out.println("É IGUAL" + hmap1+ hmap2);       

    }
  
} 
  
