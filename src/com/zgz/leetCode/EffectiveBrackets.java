package com.zgz.leetCode;
import java.util.HashMap;
import java.util.Stack;
/**
 * https://leetcode-cn.com/problems/valid-parentheses/
 * 给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串，判断字符串是否有效。
 *
 * 有效字符串需满足：
 *
 * 左括号必须用相同类型的右括号闭合。
 * 左括号必须以正确的顺序闭合。
 * 注意空字符串可被认为是有效字符串
 *
 * 输入: "()[]{}"
 * 输出: true
 */
public class EffectiveBrackets {
    private static HashMap<Character, Character> map = new HashMap<>();
    static {
        // key - value
        map.put('(', ')');
        map.put('{', '}');
        map.put('[', ']');
    }
    public static void main(String[] args) {
      System.out.println("结果:="+isValid("({})"));
    }
    /**
     * 思路:这个和方法1是一样的,只是没有使用到map而已
     * @param s
     * @return
     */
    public static boolean isValid(String s) {
        System.out.println("map:="+map);
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i <  s.length(); i++) {
            char c = s.charAt(i);
            if (map.containsKey(c)) { // 左括号
                stack.push(c);
            } else { // 右括号
                if (stack.isEmpty()) return false;
                if (c != map.get(stack.pop())) return false;
            }
        }
        return stack.isEmpty();
    }
    /**
     * 思路:把左括号放到栈中,在遍历字符串的时候把栈定元素取出和右边括号对比
     * 比如:"{([])},把{([ 这三个字符放到栈(Stack)中,然后遍历到第四个也就是]字符的时候,
     * 把栈中的元素取出并从栈中移除,分别取出来的是[ ( {,刚好和右边的]  )  }进行对比就可以
     * @param s
     * @return
     */
    public static boolean isValid1(String s) {
        Stack<Character> stack = new Stack<>();
        int len = s.length();
        for (int i = 0; i < len; i++) {
            char c = s.charAt(i);
            if (c == '(' || c == '{' || c == '[') { // 左括号
                stack.push(c);
            } else { // 右括号
                if (stack.isEmpty()) return false;//这是防止"})"这种情况
                char left = stack.pop();
                System.out.println("left:="+left);
                System.out.println("c:="+c);
                if (left == '(' && c != ')') return false;
                if (left == '{' && c != '}') return false;
                if (left == '[' && c != ']') return false;
            }
        }
        return stack.isEmpty();
    }
    /**
     * 思路:判断字符串中是否包含()  {}  [],如果有就用空字符串替换它,最后只要判断这个字符串是否为空
     * @param s
     * @return
     */
    public static boolean isValid2(String s) {
        while (s.contains("{}")
                || s.contains("[]")
                || s.contains("()")) {
            s = s.replace("{}", "");
            s = s.replace("()", "");
            s = s.replace("[]", "");
        }
        return s.isEmpty();
    }
}
