import java.io.IOException;
import java.io.PrintStream;
import java.math.BigInteger;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class Bob {
    public static void main(String[] args) throws IOException {
        BigInteger e, cipher, message,n;
        String msg;
        ServerSocket s1 = new ServerSocket(1342);

        Socket s = s1.accept();
        Scanner sc = new Scanner(s.getInputStream());
        e=sc.nextBigInteger();
        n=sc.nextBigInteger();

        Scanner sc2 = new Scanner(System.in);
        System.out.println("Enter a message to be encrypted: ");
        msg = sc2.nextLine();
        message = sc2.nextBigInteger();
        System.out.println("Enter a message to be encrypted: "+msg);

        cipher = message.modPow(e, n);

        PrintStream p = new PrintStream(s.getOutputStream());
        p.println(cipher);

    }
}
