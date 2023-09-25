import java.util.Arrays;
import java.util.Random;

public class SecondPractice {
    public static void main(String[] args) {
        System.out.println(duplicateChars("Donald"));
        System.out.println(duplicateChars("orange"));
        System.out.println();

        System.out.println(getInititals("Ryan Gosling"));
        System.out.println(getInititals("Barack Obama"));
        System.out.println();

        int[] numbers1 = {44, 32, 86, 19};
        System.out.println(differenceEvenOdd(numbers1));
        int[] numbers2 = {22, 50, 16, 63, 31, 55};
        System.out.println(differenceEvenOdd(numbers2));
        System.out.println();

        float[] numbers3 = {1f, 2f, 3f, 4f, 5f};
        System.out.println(equalToAvg(numbers3));
        float[] numbers4 = {1f, 2f, 3f, 4f, 6f};
        System.out.println(equalToAvg(numbers4));
        System.out.println();

        int[] numbers5 = {1, 2, 3};
        System.out.println(indexMult(numbers5));
        int[] numbers6 = {3, 3, -2, 408, 3, 31};
        System.out.println(indexMult(numbers6));
        System.out.println();

        System.out.println(reverse("Hello World"));
        System.out.println(reverse("The quick brown fox."));
        System.out.println();

        System.out.println(tribonacci(7));
        System.out.println(tribonacci(11));
        System.out.println();

        System.out.println(pseudoHash(5));
        System.out.println(pseudoHash(10));
        System.out.println(pseudoHash(0));
        System.out.println();

        System.out.println(botHelper("Hello, I'm under the water, please help me"));
        System.out.println(botHelper("Two pepperoni pizzas please"));
        System.out.println();

        System.out.println(isAnagram("listen", "silent"));
        System.out.println(isAnagram("eleven plus two", "twelve plus one"));
        System.out.println(isAnagram("hello", "world"));
        System.out.println();
    }

    public static boolean duplicateChars(String str) {
        for (int i = 0; i < str.length(); i++) {
            for (int j = i + 1; j < str.length(); j++) {
                char a = str.charAt(i);
                char b = str.charAt(j);
                if (Character.toLowerCase(a) == Character.toLowerCase(b)) {
                    return true;
                }
            }
        }
        return false;
    }

    public static String getInititals(String str) {
        char first = str.charAt(0);
        for (int i = 1; i < str.length(); i ++) {
            if (str.charAt(i) == ' ') return String.valueOf(first) + str.charAt(i + 1);
        }
        return String.valueOf(first);
    }

    public static int differenceEvenOdd(int[] numbers) {
        int difference = 0;
        for (int i = 0; i < numbers.length; i++) {
            if (numbers[i] % 2 == 0) difference += numbers[i];
            else difference -= numbers[i];
        }
        return Math.abs(difference);
    }

    public static boolean equalToAvg(float[] numbers) {
        float sum = 0;
        int count = numbers.length;
        for (int i = 0; i < count; i++) {
            sum += numbers[i];
        }
        float avg = sum / count;
        for (float numb : numbers) {
            if (numb == avg) return true;
        }
        return false;
    }

    public static String indexMult(int[] numbers) {
        int[] newNumbers = new int[numbers.length];
        for (int i = 0; i < numbers.length; i++) {
            newNumbers[i] = numbers[i] * i;
        }
        return Arrays.toString(newNumbers);
    }

    public static String reverse(String str) {
        //StringBuilder newStr = new StringBuilder();
        //for (int i = str.length() - 1; i >= 0; i--) newStr.append(str.charAt(i));
        //return newStr.toString( );
        String  newStr = "";
        for (int i = str.length() - 1; i >= 0; i--) newStr += str.charAt(i);
        return newStr;
    }

    public static int tribonacci(int x) {
        if (x == 1) return 0;
        if (x == 2) return 0;
        if (x == 3) return 1;
        return (tribonacci(x - 1) + tribonacci(x - 2) + tribonacci(x - 3));
    }

    public static String pseudoHash(int x) {
        String symbols = "abcdef0123456789";
        String hash = "";
        Random r = new Random();
        while (x > 0) {
            char temp = symbols.charAt(r.nextInt(symbols.length()));
            hash += temp;
            x -= 1;
        }
        return hash;
    }

    public static String botHelper(String str) {
        String nowStr = "";
        char[] symbols = {',', '.', '!', '?', ';', ':'};
        int c = 0;
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) != ' ') {
                for (char symbol : symbols) {
                    if (symbol == str.charAt(i)) c += 1;
                }
                if (c == 0) nowStr += Character.toLowerCase(str.charAt(i));
                c = 0;
            }
            else {
                if (nowStr.equals("help")) {
                    return "Calling for a staff member";
                }
                nowStr = "";
            }
        }
        if (nowStr.equals("help")) {
            return "Calling for a staff member";
        }
        return "Keep waiting";
    }

    public static boolean isAnagram(String str1, String str2) {
        char[] chars1 = new char[str1.length()];
        int[] charsc = new int[str1.length()];
        int unique = 0;

        for (int i = 0; i < str1.length(); i++) {
            char nowSymbol = Character.toLowerCase(str1.charAt(i));
            boolean isIn = false;
            for (int j = 0; j < chars1.length; j++) {
                if (nowSymbol == chars1[j]) {
                    charsc[j] += 1;
                    isIn = true;
                    break;
                }
            }
            if (!isIn) {
                chars1[unique] = nowSymbol;
                charsc[unique] = 1;
                unique++;
            }
        }

        for (int i = 0; i < str2.length(); i++){
            char nowSymbol = Character.toLowerCase(str2.charAt(i));
            boolean isIn = false;
            int index = 0;
            for (int j = 0; j < chars1.length; j++) {
                if (nowSymbol == chars1[j]) {
                    isIn = true;
                    index = j;
                    break;
                }
            }
            if (!isIn) return false;
            else {
                if (charsc[index] > 0) charsc[index]--;
                else return false;
            }
        }

        for (int i : charsc) {
            if (i != 0) return false;
        }

        return true;
    }
}