package stack;

public class LauncherStack {
    public static void main(String[] args) {
        LIFO stack = new LIFO();

        stack.push("Str1");
        stack.push("Str2");
        stack.push("Str3");

        System.out.println("LIFO 1: " + stack.pop());
        System.out.println("LIFO 2: " + stack.peak());
        System.out.println("LIFO 2: " + stack.pop());
        System.out.println("LIFO 3: " + stack.pop());
        System.out.println("LIFO 0: " + stack.pop());
        System.out.println("LIFO 0: " + stack.peak());
    }
}
