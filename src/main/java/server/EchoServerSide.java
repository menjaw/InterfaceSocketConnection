/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package server;

import control.ClientHandler;
import interfaces.I_Server;
import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Menja
 */
public class EchoServerSide implements I_Server {

    //Static gør variablerne tilgængelige  til at dele data
    public static int PORT = 8081;
    public static String IP = "127.0.0.1";
    private List<ClientHandler> clientHandler = Collections.synchronizedList(new ArrayList());//synchronizedList sikrer synkron kørsel

    //Run
    public static void main(String[] args) throws IOException {
        System.out.println("The server is listening");
        new EchoServerSide().listenForClients();//opretter en instans af sig selv og kalder på lytte-metoden
    }

    //Methods
    @Override
    public void listenForClients() {
        try {
            //ServerSocket venter på der kommer requests fra netværket
            //ServerSocket-metoden Creates an unbound(ubunden) server socket.
            ServerSocket serverSocket = new ServerSocket();
            //bind() binder serverSocket til en specifik addresse (IP-adresse, PORT-nummer) the ServerSocket to a specific address (IP address and port number)
            //InetSocketAddressProvides an immutable(uforanderlig) object used by sockets for binding, connecting, or as returned values.
            serverSocket.bind(new InetSocketAddress(IP, PORT));

            while (true) {
                //En Socket er et endpoint (stikkontakt) for kommunikation mellem to maskiner
                //Socket-metoden Creater en uConnected socket
                //accept()-metoden lytter efter connections der laves til denne socket og accepterer det. Den blokerer indtil der er lavet en connection
                Socket socket = serverSocket.accept();
                new ClientHandler(socket, this).start();
            }
        } catch (IOException ex) {
            Logger.getLogger(EchoServerSide.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void addClientToServer(ClientHandler clientHandler) {
        this.clientHandler.add(clientHandler);
    }

    @Override
    public void removeClientFromServer(ClientHandler clientHandler) {
        this.clientHandler.remove(clientHandler);
    }

}
