package wordcount;

public class Main {

    public static void main(String[] args) throws Exception {
        CallMethods callMethods = new CallMethods();
        callMethods.forStopWords();
        callMethods.forNotStopWords();
    }
    
}
