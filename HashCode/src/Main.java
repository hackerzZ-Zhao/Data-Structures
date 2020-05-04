import sun.lwawt.macosx.CSystemTray;

import java.util.HashSet;

public class Main {

    public static void main(String[] args) {
	// write your code here
        int a = 42;
        System.out.println(((Integer)a).hashCode());

        int b = -42;
        System.out.println(((Integer)b).hashCode());

        double c = 3.1415;
        System.out.println(((Double)c).hashCode());

        Student student = new Student(3, 2, "bobo","Liu");
        System.out.println(student.hashCode());
    }
}
