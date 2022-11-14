import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class userAuthenticationAction {
    public String user_name;
    public int user_id = 1;
    private String password;
    public static int count = 1;
    public static String input;

    public userAuthenticationAction(String Ruser, String Rpassword) {

        this.user_id = count++;
        this.user_name = Ruser;
        this.password = Rpassword;
        count++;

        System.out.printf("User %s has been crated \n", Ruser);
        System.out.printf("Enter 'login' to log in or 'register' to open another account");
    }

    public static void login(String Luser, String Lpassword){
        for (int i = 1; i <= count; i++) {
            System.out.printf("Enter 'login' to log in or 'register' to open another account");
        }
    }

    public static void process(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("login");
        System.out.println("register");
        input = scanner.nextLine();


            while (input.equals("login")) {

                System.out.println("username");
                String Luser = scanner.nextLine();
                System.out.println("Password");
                String Lpassword = scanner.nextLine();
                int a = count;
                login(Luser, Lpassword);
                System.out.println("");
                input = scanner.nextLine();
            }
            while (input.equals("register")) {

                System.out.println("username");
                String Ruser = scanner.nextLine();
                System.out.println("Password");
                String Rpassword = scanner.nextLine();
                userAuthenticationAction count = new userAuthenticationAction(Ruser, Rpassword);
                System.out.println("");
                input = scanner.nextLine();
            }
            while ((!input.equals("register")) || (!input.equals("login"))) {
                System.out.println("invild option, chose login or regiser!");
                input = scanner.nextLine();
            }
    }

}