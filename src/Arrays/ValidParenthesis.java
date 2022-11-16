package Arrays;

import java.util.Stack;

public class ValidParenthesis {
//    Given a string s containing just the characters '(', ')', '{', '}', '[' and ']', determine if the input string is valid.
//
//    An input string is valid if:
//
//    Open brackets must be closed by the same type of brackets.
//    Open brackets must be closed in the correct order.
//    Every close bracket has a corresponding open bracket of the same type.
//
//
//    Example 1:
//
//    Input: s = "()"
//    Output: true
//    Example 2:
//
//    Input: s = "()[]{}"
//    Output: true
//    Example 3:
//
//    Input: s = "(]"
//    Output: false
//
//
//    Constraints:
//
//            1 <= s.length <= 104
//    s consists of parentheses only '()[]{}'.

    public boolean isValid(String s) {
        Stack<Character> st=new Stack<Character>();
        for(char a:s.toCharArray())
        {

            //Check if stack not empty and the top element corresponds to curr char
            if(!st.isEmpty() && (st.peek()==a-1 || st.peek()==a-2))
                st.pop();
                //else these migh be starting brackets or unsatisfied closing brackets
            else
                st.push(a);
        }

        return st.isEmpty();
    }
}
