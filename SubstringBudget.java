import java.util.ArrayList;
import java.util.List;

public class SubstringBudget {
    public static void main(String[] args) {
        ArrayList<Integer> arr = new ArrayList<>();
        arr.add(2);
        arr.add(3);
        arr.add(4);
        arr.add(5);
        arr.add(7);
        System.out.println("as");
        System.out.println(maxLengthSubstringWithCost("bab","bbb",2));
    }

    public static int solution(List<Integer> arr) {
        int output = 0;
        
        while (arr.size() > 1) {
            // Find the minimum value and its index
            int min = arr.get(0);
            int mindex = 0;
            for (int i = 1; i < arr.size(); i++) {
                if (arr.get(i) < min) {
                    min = arr.get(i);
                    mindex = i;
                }
            }

            // Find the maximum value and its index
            int max = arr.get(0);
            int maxdex = 0;
            for (int i = 1; i < arr.size(); i++) {
                if (arr.get(i) > max) {
                    max = arr.get(i);
                    maxdex = i;
                }
            }

            // Ensure we remove the higher index first to avoid shifting issues

            arr.remove(maxdex);
            arr.remove(mindex);
            

            // Calculate num and update the output
            int num = (int) Math.ceil((double) (max + min) / (max - min + 1));
            output += num;

            // Add the new value to the list
            arr.add(max + min);
        }

        return output;
    }
    public static int maxLengthSubstringWithCost(String s, String t, int K) {
        int output = 0;
        int tempK = K;
        int pointerB = 0;
        int pointerA = 0;
        while(pointerB < s.length()){
            int diff = Math.abs(s.charAt(pointerB)-t.charAt(pointerB));
            while(diff<K && diff>tempK){
                tempK+= Math.abs(s.charAt(pointerA)-t.charAt(pointerA));
                pointerA++;
            }
            tempK-=diff;
            output = Math.max(output, pointerB-pointerA+1);
            pointerB++;
        }
        return output;
    }
}
