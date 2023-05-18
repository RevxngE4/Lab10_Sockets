import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    public static void main(String[] args) {
        try {
            ServerSocket serverSocket = new ServerSocket(12345);
            System.out.println("Servidor en ejecución. Esperando conexiones...");

            while (true) {
                Socket clientSocket = serverSocket.accept();
                System.out.println("Cliente conectado: " + clientSocket);

                BufferedReader input = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
                PrintWriter output = new PrintWriter(clientSocket.getOutputStream(), true);

                String username = input.readLine();
                System.out.println("Cliente: " + username);

                output.println("Hola, " + username + "! Choose a mathematical expression (example: the first number is the variable 'X' and the second is the number of the variable, or type 'bye' to exit:");

                String expression = input.readLine();
                System.out.println("Expresión recibida: " + expression);

                if (expression.equalsIgnoreCase("bye")) {
                    System.out.println("Cliente solicitó salir. Cerrando conexión...");
                    break;
                }

                double result = calcularExpresion(expression);
                System.out.println("Resultado: " + result);

                output.println("El resultado de la expresión es: " + result);

                clientSocket.close();
                System.out.println("Cliente desconectado: " + clientSocket);
            }

            serverSocket.close();
            System.out.println("Servidor detenido.");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static double calcularExpresion(String expression) {
        double resultado = 0;

        String[] tokens = expression.split(" ");
        double x = Double.parseDouble(tokens[0]);
        int opcion = Integer.parseInt(tokens[1]);
        double a = 5;
        double nx = 8;
        double b = 14;
        double c = 16;
        double d = 18;
        double y = 21;
        double e = 12;
        double a1 = 12;
        double a2 = 47;
        double a3 = 36;

        switch (opcion) {
            case 1:
                resultado = ((5 * Math.pow(a,nx)/b + c)-Math.sqrt(Math.abs(Math.cos(Math.pow(x, 3)))));
                break;
            case 2:
                resultado = (Math.abs((x-y))/Math.pow((1 + 2 * x), a) - Math.pow(e,Math.sqrt(1+a)));
                break;
            case 3:
                resultado = Math.sqrt(a + a1 * x + a2 *(Math.sqrt(Math.abs(Math.sin(x)))));
                break;
            case 4:
                resultado = Math.log(Math.pow(a,7)) + Math.pow(Math.atan(x),2) + Math.PI/Math.sqrt(Math.abs(a + x));
                break;
            case 5:
                resultado = Math.sqrt((Math.pow((a + b),2) / c + d) + Math.pow(e, Math.sqrt(x+1)));
                break;
            case 6:
                resultado = Math.pow(e,((2 * Math.sin(4 * x)+ Math.pow(Math.cos(Math.pow(x,2)), 2))));
                break;
            case 7:
                resultado = 1/4 * ((1 + Math.pow(x , 2)/ 1 - x) + 1/2 * Math.tan(x));
                break;

            default:
                System.out.println("Opción no válida.");
        }

        return resultado;
    }
}
