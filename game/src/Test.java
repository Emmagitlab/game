import java.util.*;

public class Test {
    public static int Solution(String str) {
        String[] strArr = str.split("\n");
        Stack<String> stack = new Stack<>();
        HashSet<String> set = new HashSet<>();
        stack.push("");
        int sum = 0;

        for(String s : strArr) {
            int lvl = s.length() - s.trim().length();
            while(stack.size() > lvl+1) stack.pop();
            if(s.contains(".")) {
                set.add(stack.peek());
                continue;
            }

            String temp = stack.peek() + "/" + s.trim();
            stack.push(temp);
        }

        for(String s : set) {
            System.out.println(s);
            sum += s.length();
        }

        return sum;
    }

    public static void main(String[] args) {
        String test = "dir1\n dir11\n  abc.jpeg\n dir12\n  picture.jpeg\n  dir121\n  file1.txt\ndir2\n file2.gif";
        System.out.println(Solution(test));
    }
}
