public class Palindrome {
    public static boolean isPalindrome(String word) {
        String a, b = "";
        a = word;
        int n = a.length();
        for(int i = n - 1; i >= 0; i--)
        {
            b = b + a.charAt(i);
        }
        
        if(a.equalsIgnoreCase(b))
        {
            return true;
        }
        else
        {
            return false;
        }
    }
    
    public static void main(String[] args) {
        System.out.println(Palindrome.isPalindrome("Deleveled"));
    }
}