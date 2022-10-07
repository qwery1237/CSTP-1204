import java.util.*;
public class lab5 {
    public static int dayOfYear1(int month, int dayOfMonth, int year){
        int[]monthLengths = new int[]{31, 28, 31, 30, 31, 30, 31 , 31, 30, 31, 30, 31};
        int sum = 0 ;
        for (int i = 1; i < month; i++)
            sum += monthLengths[i-1];
        sum += dayOfMonth;
        return sum;
    }
    public static boolean isLeap(int year){
        if (year % 4 != 0){
            return false;
        } else if (year % 400 == 0) {
            return true;
        } else if (year % 100 == 0) {
            return false;
        } else {
            return true;
        }
    }
    public static enum Month {JANUARY, FEBRUARY, MARCH, APRIL, MAY, JUNE, JULY, AUGUST, SEPTEMBER, OCTOBER, NOVEMBER, DECEMBER};
    public static int dayOfYear2(Month month, int dayOfMonth, int year) {
        int[] monthLengths = new int[] { 31, 28, 31, 30, 31, 30, 31 , 31, 30, 31, 30, 31};
        int sum = 0;
        for(int i = 0; i < month.ordinal() ; i++){
            sum += monthLengths[i];
        }

        sum += dayOfMonth;
        return sum;
    }
    public static boolean isBalanced (String brackets) {
        Stack<Character> temp = new Stack<>();
        for ( char x : brackets.toCharArray()) {
            if ("[{(".contains(""+x)) {
                temp.add(x);
            }else {
                switch (x) {
                    case ']' : if (temp.empty() || temp.pop() != '[') return false;
                        break;
                    case '}' : if (temp.empty() || temp.pop() != '{') return false;
                        break;
                    default: if (temp.empty() || temp.pop() != '(') return false;
                        break;
                }
            }
        }
        if (temp.empty()) return true;
        return false;
    }
    public static void main(String[] args) {
        System.out.println(dayOfYear1(3,20,2022));  //task 1
        System.out.println(isLeap(300));    // task2
        System.out.println(dayOfYear2(Month.MARCH,20,2022)); // task 3
        // task 4
        String balancedBracket1 = "{}[][][]()";
        String balancedBracket2 = "{}[{}][][]()";
        String unbalancedBracket1 = "{}[][][](";
        String unbalancedBracket2 = "{}[][][])";
        String unbalancedBracket3 = "{}[][][](}";
        String unbalancedBracket4 = "{}[][][]{)";
        System.out.println("--- Task 4  ---");
        System.out.println(isBalanced(balancedBracket1));
        System.out.println(isBalanced(balancedBracket2));
        System.out.println(isBalanced(unbalancedBracket1));
        System.out.println(isBalanced(unbalancedBracket2));
        System.out.println(isBalanced(unbalancedBracket3));
        System.out.println(isBalanced(unbalancedBracket4));
    }
}
