import java.io.Console;
import java.lang.constant.Constable;
import java.util.Arrays;
import java.util.Collection;

public class Third_practice {

    public static void main(String[] args) {
        System.out.println(replaceVovels("apple"));
        System.out.println(replaceVovels("Even if you did this task not by yourself," +
                " you have to understand every single line of code"));
        System.out.println();

        System.out.println(stringTransform("hello"));
        System.out.println(stringTransform("bookkeeper"));
        System.out.println();

        System.out.println(doesBlockFit(1, 3, 5, 4, 5));
        System.out.println(doesBlockFit(1, 8, 1, 1, 1));
        System.out.println(doesBlockFit(1, 2, 2, 1, 1));
        System.out.println();

        System.out.println(numCheck(243));
        System.out.println(numCheck(52));
        System.out.println();

        int[] numbers1 = {1, -3, 2};
        int[] numbers2 = {2, 5, 2};
        int[] numbers3 = {1, -6, 9};
        System.out.println(countRoots(numbers1));
        System.out.println(countRoots(numbers2));
        System.out.println(countRoots(numbers3));

        String[][] array1 = {
                {"Apple", "Shop1", "Shop2", "Shop3", "Shop4"},
                {"Banana", "Shop2", "Shop3", "Shop4"},
                {"Orange", "Shop1", "Shop3", "Shop4"},
                {"Pear", "Shop2", "Shop4"}
        };
        String[][] array2 = {
                {"Fridge", "Shop2", "Shop3"},
                {"Microwave", "Shop1", "Shop2", "Shop3", "Shop4"},
                {"Laptop", "Shop3", "Shop4"},
                {"Phone", "Shop1", "Shop2", "Shop3", "Shop4"}
        };
        System.out.println(salesData(array1));
        System.out.println(salesData(array2));
        System.out.println();

        System.out.println(validSplit("apple eagle egg goat"));
        System.out.println(validSplit("cat dog goose fish"));
        System.out.println();

        int[] array3 = {3, 1, 4, 2, 7, 5};
        int[] array4 = {1, 2, 3, 4, 5};
        int[] array5 = {1, 2, -6, 10, 3};
        System.out.println(waveForm(array3));
        System.out.println(waveForm(array4));
        System.out.println(waveForm(array5));
        System.out.println();

        System.out.println(commonVowel("Hello world"));
        System.out.println(commonVowel("Actions speak louder than words."));
        System.out.println();

        int[][] array6 = {
                {1, 2, 3, 4, 5},
                {6, 7, 8, 29, 10},
                {5, 5, 5, 5, 35},
                {7, 4, 3, 14, 2},
                {1, 0, 11, 10, 1}
        };
        int[][] array7 = {
                {6, 4, 19, 0, 0},
                {81, 25, 3, 1, 17},
                {48, 12, 60, 32, 14},
                {91, 47, 16, 65, 217},
                {5, 73, 0, 4, 21}
        };
        System.out.println(dataScience(array6));
        System.out.println(dataScience(array7));
    }

    public static String replaceVovels(String s) {
        String vovels = "aeiouy";
        String refactoredS = "";
        for (int i = 0; i < s.length(); i++) {
            if (vovels.indexOf(Character.toLowerCase(s.charAt(i))) == -1) {
                refactoredS += s.charAt(i);
            }
            else refactoredS += '*';
        }
        return refactoredS;
    }

    public static String stringTransform(String s) {
        String transformedS = Character.toString(s.charAt(0));
        for (int i = 1; i < s.length(); i++) {
            if (Character.toLowerCase(s.charAt(i)) ==
                    Character.toLowerCase(transformedS.charAt(transformedS.length() - 1))) {
                transformedS = transformedS.substring(0 ,transformedS.length() - 1);
                transformedS += "Double" + Character.toUpperCase(s.charAt(i));
            }
            else {
                transformedS += s.charAt(i);
            }
        }
        return transformedS;
    }

    public static boolean doesBlockFit(int a, int b, int c, int w, int h) {
        int[] abcArray = {a, b, c};
        Arrays.sort(abcArray);
        int minABC = abcArray[0];
        int midABC = abcArray[1];
        int minWH = Math.min(w, h);
        int maxWH = Math.max(w, h);
        return minABC <= minWH && midABC <= maxWH;
    }

    public static boolean numCheck(int number) {
        int strangeNumber = 0;
        for (int i = 0; i < Integer.toString(number).length(); i++) {
            strangeNumber += (int) Math.pow(Character.getNumericValue(Integer.toString(number).charAt(i)), 2);
        }
        return (number - strangeNumber) % 2 == 0;
    }

    public static int countRoots(int[] numbers) {
        int a = numbers[0];
        int b = numbers[1];
        int c = numbers[2];
        double x1;
        double x2;
        int d = (int) Math.pow(b, 2) - 4 * a * c;
        if (d < 0) return 0;
        x1 = (-b + Math.sqrt(d)) / (2 * a);
        x2 = (-b - Math.sqrt(d)) / (2 * a);
        if (x1 % 1 == 0 || x2 % 1 == 0) {
            if (x1 % 1 == 0 && x2 % 1 == 0) {
                if (x1 == x2) return 1;
                return 2;
            }
            return 1;
        }
        return 0;
    }

    public static String salesData(String[][] array) {
        int products = 0;
        int product_with_stores = 0;
        for (String[] strings : array) {
            if (product_with_stores < strings.length) {
                product_with_stores = strings.length;
                products = 1;
            }
            else if (product_with_stores == strings.length) {
                products += 1;
            }
        }
        String[] answer = new String[products];
        int temp = 0;
        for (String[] strings : array) {
            if (product_with_stores == strings.length) {
                answer[temp] = strings[0];
                temp += 1;
            }
        }
        return Arrays.toString(answer);
    }

    public static boolean validSplit(String string) {
        char[] starts = new char[string.split(" ").length];
        char[] ends = new char[string.split(" ").length];
        int temp = 0;
        for (String str :  string.split(" ")) {
            starts[temp] = Character.toLowerCase(str.charAt(0));
            ends[temp] = Character.toLowerCase(str.charAt(str.length() - 1));
            temp++;
        }

        int mismatches = 0;
        for (char char1 : starts) {
            for (int i = 0; i < ends.length; i++) {
                if (char1 == ends[i]) {
                    ends[i] = '-';
                    break;
                }
                if (i == ends.length - 1) mismatches += 1;
            }
        }
        return mismatches <= 1;
    }

    public static boolean waveForm(int[] numbers) {
        boolean isUp = numbers[0] < numbers[1];
        for (int i = 2; i < numbers.length; i++) {
            if (!((isUp && numbers[i - 1] > numbers[i]) || (!isUp && numbers[i] > numbers[i - 1]))) {
                return false;
            }
            isUp = !isUp;
        }
        return true;
    }

    public static String commonVowel(String str) {
        char[] vowels = {'a', 'e', 'i', 'o', 'u', 'y'};
        int[] numbs = new int[vowels.length];
        for (String substr : str.toLowerCase().split("")) {
            for (int i = 0; i < vowels.length; i++) {
                if (substr.charAt(0) == vowels[i]) numbs[i]++;
            }
        }
        int maxnumb = 0;
        int maxC = 0;
        for (int numb : numbs) {
            if (numb == maxnumb) {
                maxC += 1;
            }
            else if (numb > maxnumb) {
                maxC = 1;
                maxnumb = numb;
            }
        }
        char[] answer = new char[maxC];
        int temp = 0;
        for (int i = 0; i < numbs.length; i++) {
            if (numbs[i] == maxnumb) {
                answer[temp] = vowels[i];
                temp++;
            }
        }
        return Arrays.toString(answer);
    }

    public static String  dataScience(int[][] array) {
        float sum = 0;
        for (int j = 0; j < array.length; j++) {
            for (int i = 0; i < array.length; i++) {
                if (i != j) sum += array[i][j];
            }
            array[j][j] = Math.round(sum / (array.length - 1));
            sum = 0;
        }
        return Arrays.deepToString(array);
    }
}