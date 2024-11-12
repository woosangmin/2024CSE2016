package lecture05;

public class Dangling {
    public static void main(String[] args) {
        if (false)
            if (false)
                System.out.println(1);
            else
                System.out.println(2);
    }

}
