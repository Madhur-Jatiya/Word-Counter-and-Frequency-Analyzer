package wordcount;

public class SortByCharacter implements Comparable<SortByCharacter>{
    int count = 0;
    char ch;

    public SortByCharacter(int count,char ch) {
        this.ch = ch;
        this.count = count;
    }

    public int getCount() {
        return count;
    }

    public char getCh() {
        return ch;
    }
    
    public void print()
    {
        System.out.println("Charater : " + ch + " ==> count : " + count);
    }

    @Override
    public int compareTo(SortByCharacter o) {
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
