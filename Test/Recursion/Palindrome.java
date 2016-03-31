public class Palindrome {

    public static void main(String[] args) {

        isPalindrome("hello world");

    }

    public static boolean isPalindrome(String s) {

        // base case
        if (s.length() <= 1) {
            return true;
        } else if (s.charAt(0) != s.charAt(s.length() - 1)) {
            return false;
        } else {
            // recursive call
            return isPalindrome(s.substring(1, s.length() - 1));
        }
    }

    public static boolean isPalindrome(String s, int low, int high) {

        // base case
        if (high <= low) {
            return true;
        } else if (s.charAt(low) != s.charAt(high)) {
            return false;
        } else {
            return isPalindrome(s, low + 1, high - 1);
        }
    }
}
