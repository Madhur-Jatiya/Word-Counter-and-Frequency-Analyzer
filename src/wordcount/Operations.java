package wordcount;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;

public class Operations {
    
                //print paragraph
    
    public void printParagraph(File file) throws FileNotFoundException {
        System.out.println("\n\t\t\tPrint Paragraph\n");
        
        Scanner sc = new Scanner(file);
        
        while(sc.hasNext())
        {
            System.out.println(sc.nextLine());
        }
    }
    
                //Word count
    
    public void wordCount(ArrayList<String> list) {

        System.out.println("\nNo. of Words : " + list.size());
    }
    
                //Sentence count
    
    public void sentenceCount(File file) throws FileNotFoundException {
        int count = 0;
        
        Scanner sc = new Scanner(file);

        while (sc.hasNext()) {  
            String str = sc.next();
                if (str.endsWith(".")) {
                    count++;
            }
        }
        System.out.println("\nNo of Sentence : " + count);
    }
    
                //Space count
    
    public void spaceCount(File file) throws FileNotFoundException {
        int count = 0;
        
        Scanner sc = new Scanner(file);
        
        while (sc.hasNext()) {  
            String str = sc.nextLine();
                for (int i = 0; i < str.length(); i++) {
                    if (str.charAt(i) == ' ') {
                        count++;
                    }    
                }
            }
        System.out.println("\nNo of Space : " + (count-1));
    }
    
                //Character count
    
    public void characterCount(File file) throws FileNotFoundException {
        int count = 0;
        
        Scanner sc = new Scanner(file);

        while (sc.hasNext()) {  
            String str = sc.next();
            for (int i = 0; i < str.length(); i++) {
                count++;
            }
        }

        System.out.println("\nNo of Charaters : " + count);
    }
    
                //Top 5 Words
    
    public void top5Words(ArrayList<String> list) throws FileNotFoundException
       {
        System.out.println("\n\n\tTop 5 used Words\n");
        HashSet<String> set = new HashSet<>(list);
        ArrayList<SortByWord> top5List = new ArrayList();
        SortByWord word = null;

        for (String str : set) {
                word = new SortByWord(Collections.frequency(list, str), str);
                top5List.add(word);
        }          

        Collections.sort(top5List);

        int count = 0;

        for (int i = top5List.size()-1; i >= 0; i--) {
            if (count==5) {
                break;
            }
            SortByWord word1 = top5List.get(i);
            word1.print();
            count++;
    }                       
}

                //Least 5 Words
        
    public void least5Words(ArrayList<String> list) throws FileNotFoundException
       {
           System.out.println("\n\n\tLeast used Words\n");

        HashSet<String> set = new HashSet<>(list);
        ArrayList<SortByWord> top5List = new ArrayList();
        SortByWord word = null;

        for (String str : set) {
                word = new SortByWord(Collections.frequency(list, str), str);
                top5List.add(word);
        }          

        Collections.sort(top5List);
        int count=0;
        for (int i = 0; i < top5List.size(); i++) {
            SortByWord word1 = top5List.get(i);
            if (count==5) {
                break;
            }
//                if (word1.getCount()>1) {
//                    break;
//                }
            word1.print();
            count++;
    }           
}

        
            //Word Search
        
    public void wordSearch(List list)
    {    
        System.out.println("\n\tWord Search");
        Scanner sc = new Scanner(System.in);
        
            HashSet<String> set = new HashSet<>(list);
            ArrayList<SortByWord> top5List = new ArrayList();
            SortByWord word = null;
            
            for (String str1 : set) {
                    word = new SortByWord(Collections.frequency(list, str1), str1);
                    top5List.add(word);
            }
                        
            
            System.out.print("\nEnter word you want to search : ");
            String str = sc.next();
            
            boolean check = false;
            
            for (int i = 0; i < top5List.size()-1; i++) {
                SortByWord wrd = top5List.get(i);
                
                if ((wrd.getWord()).equals(str)) {
                    System.out.println("Count : " + wrd.getCount());
                    check = true;
                }
            }
            
            if (!check) {
                System.out.println("Word Not Found");
        }
            
    }
    
    
            //Word Set Search
    
    public void MultipleWordSearch(List list)
    {
        System.out.println("\n\tSet Search");
        Scanner sc = new Scanner(System.in);
        
            HashSet<String> set = new HashSet<>(list);
            ArrayList<SortByWord> top5List = new ArrayList();
            SortByWord word = null;
            
            for (String str1 : set) {
                    word = new SortByWord(Collections.frequency(list, str1), str1);
                    top5List.add(word);
            }
                        
            String arr[] = new String[5];
            
            for (int i = 0; i < 5; i++) {
                System.out.print((i+1) + " Enter word you want to search : ");
                arr[i] = sc.next();
            }
            
            System.out.println("");
            
            boolean check;
            for (int j = 0; j < arr.length; j++) {
                
                check = false;
                
                for (int i = 0; i < top5List.size()-1; i++) {

                    SortByWord wrd = top5List.get(i);
                    if ((wrd.getWord()).equals(arr[j])) {
                        System.out.println("Word : " + arr[j] + " ==> Count : " + wrd.getCount());
                        check = true;
                    }
                }
                
                
                if (!check) {
                        System.out.println("Word : " + arr[j] + " ==> Word Not Found");
                    }
            }
    }
    
        //top 5 Characters
    
    public void top5Charaters(File file) throws FileNotFoundException
    {
        System.out.println("\n\n\tMost 5 used Characters\n");
        Scanner sc = new Scanner(file);
        ArrayList<Character> list = new ArrayList<>();
        
        while (sc.hasNext()) {            
            String str = sc.next();
            for (int i = 0; i < str.length(); i++) {
                list.add(str.charAt(i));
            }
        }
        
        SortByCharacter character = null;
        ArrayList<SortByCharacter> top5charaters = new ArrayList();
        HashSet<Character> set = new HashSet(list);
        
        for (Character ch : set) {        
                character = new SortByCharacter(Collections.frequency(list, ch),ch);
                top5charaters.add(character);
        }
        
            Collections.sort(top5charaters);
        
            int count=0;
            
            for (int i = top5charaters.size()-1; i >= 0 ; i--) {
                if (count == 5) {
                    break;
                }
                
                SortByCharacter ch = top5charaters.get(i);
                ch.print();
                count++;
            }
    }
    
    
        //Least 5 Characters
    
    public void Least5Charaters(File file) throws FileNotFoundException
    {
        System.out.println("\n\n\tLeast used Characters\n");
        Scanner sc = new Scanner(file);
        ArrayList<Character> list = new ArrayList<>();
        
        while (sc.hasNext()) {            
            String str = sc.next();
            for (int i = 0; i < str.length(); i++) {
                list.add(str.charAt(i));
            }
        }
        
        SortByCharacter character = null;
        ArrayList<SortByCharacter> top5charaters = new ArrayList();
        HashSet<Character> set = new HashSet(list);
        
        for (Character ch : set) {        
                character = new SortByCharacter(Collections.frequency(list, ch),ch);
                top5charaters.add(character);
        }
        
            Collections.sort(top5charaters);
        
            int count =0;
            
            for (int i = 0; i < top5charaters.size(); i++) {
                SortByCharacter ch = top5charaters.get(i);
                if (count==5) {
                    break;
                }
//                if (ch.getCount()>1) {
//                    break;
//                }
                ch.print();
                count++;
            }
    }
}
