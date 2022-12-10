package wordcount;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class CallMethods {
   
    public void forNotStopWords() throws FileNotFoundException
   {
       System.out.println("\n\n-------------------Before Remove Stop Words----------------------");
       
       //add file to arraylist
        ArrayList<String> list = new ArrayList();
        File file = new File("file1.txt");
        Scanner sc = new Scanner(file);
        
        while (sc.hasNext()) {
            list.add(sc.next());
        }
        
        //call all methods
        Operations operations = new Operations();
        
        operations.printParagraph(file);
        operations.wordCount(list);
        operations.sentenceCount(file);
        operations.characterCount(file);
        operations.wordSearch(list);
        operations.MultipleWordSearch(list);
        
        sc.close();
   }
   
    public void forStopWords() throws FileNotFoundException, IOException
   {
       System.out.println("\n\n-------------------After Remove Stop Words----------------------");
       
       //add file to arraylist1
       ArrayList<String> list = new ArrayList();
        File file = new File("file1.txt");
        Scanner sc = new Scanner(file);
                
        while (sc.hasNext()) {
            String str1 = sc.next().toLowerCase();
            String str2 = str1.replaceAll("[$&+,:;=?@#|'<>.-^*()%!]", "");
            list.add(str2);
        }
        
        //add stopwords to arraylist2
        ArrayList<String> list1 = new ArrayList();
        File file1 = new File("stopwords.txt");
        Scanner sc1 = new Scanner(file1);
        
        while (sc1.hasNext()) {
            list1.add(sc1.next());
        }
        
        list.removeAll(list1);
        
        //create new file not contains stop words and special characters
        FileWriter writer = new FileWriter("newFile.txt"); 
        for(String newFile: list) {
          writer.write(newFile + " ");
        }
        writer.close();
        
        
        //call all methods
        File newFile = new File("newFile.txt");

        Operations operations = new Operations();
        operations.printParagraph(newFile);
        operations.wordCount(list);
        operations.spaceCount(newFile);
        operations.characterCount(newFile);
        operations.top5Words(list);
        operations.least5Words(list);
        operations.top5Charaters(newFile);
        operations.Least5Charaters(newFile);
        
        sc.close();
   }
}
