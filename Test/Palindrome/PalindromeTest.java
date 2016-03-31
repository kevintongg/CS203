public class PalindromeTest {

    public static void main(String[] args) {

        System.out.println(isPalindromeIterative("HellolleH"));

    }

    public static boolean isPalindromeIterative(String s) {
        for (int i = 0; i < s.length(); i++) { // For every index in the string
            if (s.charAt(i) != s.charAt(s.length() - (i + 1))) { // Compare the character at that index, and the index subtracted from the reverse side
                return false;
            }
        }
        return true;
    }
}
