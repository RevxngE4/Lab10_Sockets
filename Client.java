import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public class Client {
    public static void main(String[] args) {
        try {
            Socket socket = new Socket("localhost", 12345);

            BufferedReader input = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            PrintWriter output = new PrintWriter(socket.getOutputStream(), true);

            Scanner scanner = new Scanner(System.in);
            System.out.print("Ingresa tu nombre: ");
            String username = scanner.nextLine();

            output.println(username);

            String greeting = input.readLine();
            System.out.println("Servidor: " + greeting);

            while (true) {
                System.out.print("> ");
                String expression = scanner.nextLine();

                output.println(expression);

                if (expression.equalsIgnoreCase("bye")) {
                    System.out.println("Saliendo...");
                    break;
                }

                String result = input.readLine();
                System.out.println("Servidor: " + result);
            }

            socket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

