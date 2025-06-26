import org.apache.hc.core5.annotation.Internal;

import java.util.ArrayList;
import java.util.List;

public class ListExercises {

    /** Returns the total sum in a list of integers */
    public static int sum(List<Integer> L) {
        // TODO: Fill in this function.
        int Lsum = 0;
        for(int i : L){
            Lsum += i;
        }
        return Lsum;
    }

    /** Returns a list containing the even numbers of the given list */
    public static List<Integer> evens(List<Integer> L) {
        // TODO: Fill in this function.
        List<Integer> L_evens = new ArrayList<>();
        for(int i : L){
            if(i % 2 == 0){
                L_evens.add(i);
            }
        }
        return L_evens;
    }

    /** Returns a list containing the common item of the two given lists */
    public static List<Integer> common(List<Integer> L1, List<Integer> L2) {
        // TODO: Fill in this function.
        List<Integer> L_common = new ArrayList<>();
        for(int i : L1){
            if(L2.contains(i)){
                L_common.add(i);
            }
        }
        return L_common;
    }


    /** Returns the number of occurrences of the given character in a list of strings. */
    public static int countOccurrencesOfC(List<String> words, char c) {
        // TODO: Fill in this function.
        int sum_occur = 0;
        for(String s : words){
            for(int i = 0 ; i<s.length();i++){
                if(c == s.charAt(i)){
                    sum_occur++;
                }
            }
        }
        return sum_occur;
    }
}
