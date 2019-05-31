import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;


public class TCPServer {
    public static void main(String[] args) throws Exception{
        String clientesentence;
        String capitalizedsentence;
        ServerSocket welcomeSocket = new ServerSocket(5050);
        System.out.println("== Running ==\n\n");

        while(true){
            Socket connectionsocket = welcomeSocket.accept();
            System.out.println("Conectado: " + connectionsocket.getLocalSocketAddress());

            BufferedReader inFromClient  = new BufferedReader(
                    new InputStreamReader(connectionsocket.getInputStream())
            );

            DataOutputStream outToClient = new DataOutputStream(
                    connectionsocket.getOutputStream()
            );

            clientesentence = inFromClient.readLine();
            System.out.println("Mensagem recebida: " + clientesentence);
            capitalizedsentence = clientesentence.toUpperCase() + '\n';
            System.out.println("Mensagem Modificada a ser enviada: " + capitalizedsentence);
            outToClient.writeBytes(capitalizedsentence);
            System.out.println("Conexão finalizada");
            System.out.println("\n=+=+=+=+=+=+=+=+=+=+=+=+\n");
            connectionsocket.close();
        }
    }
}