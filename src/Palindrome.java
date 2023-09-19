public class Palindrome {

    public static void main(String[] args) {
        for (int i = 0; i < args.length; i++) {
            String s = args[i];
            System.out.println(isPalindrome(s));
        }
    }

    public static String reverseString(String s) {
        String  newS = "";
        for (int i = s.length() - 1; i >= 0; i--) newS += s.charAt(i);
        return newS;
    }

    public static boolean isPalindrome(String s) {
        return (s.equals(reverseString(s)));
    }
}
