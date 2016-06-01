import java.util.Scanner;

public class Test2 {

    public static void main(String[] args) {


        asdf();
    }


    private static void asdf() {

        Scanner sc = new Scanner(System.in);

        boolean run = true;

        try {
            while (run) {
                System.out.println("Enter a hexadecimal");
                String str = sc.next();
                int len = str.length();
                byte[] out = new byte[len / 2];
                int endIndx;

                for (int i = 0; i < len; i = i + 2) {
                    endIndx = i + 2;
                    if (endIndx > len)
                        endIndx = len - 1;
                    out[i / 2] = (byte) Integer.parseInt(str.substring(i, endIndx), 16);
                }
                long l = Long.parseLong(String.valueOf(out), 2);
                System.out.println(l);
            }
        } catch (NumberFormatException e) {
            e.printStackTrace();
        }
    }
}
