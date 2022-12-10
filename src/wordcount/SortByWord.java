package wordcount;


public class SortByWord implements Comparable<SortByWord>{
    int count;
    String word;

    public SortByWord(int count, String word) {
        this.count = count;
        this.word = word;
    }
    

    public void print() 
    {
            System.out.println("count : " + count + " ==> Word : " + word);
    }

    public int getCount() {
        return count;
    }

    public String getWord() {
        return word;
    }

    @Override
    public int compareTo(SortByWord o) {
        if (count > o.count) {
            return 1;
        }
        else if(count < o.count)
        {
            return -1;
        }
        else{
            return 0;
        }
    }
    
    
}
