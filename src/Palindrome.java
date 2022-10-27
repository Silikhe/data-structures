public class Palindrome {
//    Given an integer x, return true if x is palindrome integer.
//
//    An integer is a palindrome when it reads the same backward as forward.
//
//    For example, 121 is a palindrome while 123 is not.
//
//
//    Example 1:
//
//    Input: x = 121
//    Output: true
//    Explanation: 121 reads as 121 from left to right and from right to left.
//            Example 2:
//
//    Input: x = -121
//    Output: false
//    Explanation: From left to right, it reads -121. From right to left, it becomes 121-. Therefore it is not a palindrome.
//    Example 3:
//
//    Input: x = 10
//    Output: false
//    Explanation: Reads 01 from right to left. Therefore it is not a palindrome.
//
//
//    Constraints:
//
//            -231 <= x <= 231 - 1
//
//
//    Follow up: Could you solve it without converting the integer to a string?

     public static void main(String[] args) {
         int test = 121;
         System.out.println(isPalindrome(test));
//         int a = 2147483647;
//         a = a + 1;
//         System.out.println(a);
    }

    public static boolean isPalindrome(int num){
        if(num < 0) return  false;
        int reversed = 0, remainder, original = num;
        while(num != 0) {
            remainder = num % 10; // reversed integer is stored in variable
            reversed = reversed * 10 + remainder; //multiply reversed by 10 then add the remainder so it gets stored at next decimal place.
            num  /= 10;  //the last digit is removed from num after division by 10.
        }
        // palindrome if original and reversed are equal
        return original == reversed;
    }
}
