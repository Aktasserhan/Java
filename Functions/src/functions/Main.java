
package functions;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

public class Main {
    
    public static void main(String[] args) {
        int count=0;
        ArrayList<String> words = new ArrayList<>();
         Iterator<String> iterator = words.iterator();
        Scanner ss=new Scanner(System.in);
        while(true){
            count++;
            String word =ss.next();
            words.add(word);
            if(word.equals("end-of-file")){
                for(int i=0;i<words.size();i++){
                    System.out.println(iterator.hasNext());
                }
                break;
                
            } 
        }
    }
    
}
