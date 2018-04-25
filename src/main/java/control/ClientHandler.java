/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package control;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import server.EchoServerSide;

/**
 *
 * @author Menja
 */
public class ClientHandler extends Thread {

    //Variabler
    Socket socketConnection; //Socket skaber forbindelse mellem server og client
    EchoServerSide server;
    Scanner inputFromClient; //Message from client
    PrintWriter messageToClient;//Bruges i forbindelse med at der skal komme svar tilbage til client

    //Constructor
    public ClientHandler(Socket socketConnection, EchoServerSide server) throws IOException {
        //
        this.socketConnection = socketConnection;
        this.server = server;

        //
        inputFromClient = new Scanner(socketConnection.getInputStream());//getInpuStream returner input fra socket
    }

    //Kør tråde
    @Override
    public void run() {

        System.out.println("Tråden er startet");
        this.server.addClientToServer(this);//this referer til clienHandler

        String messageFromClient = inputFromClient.nextLine();//blokerende kald og venter 1 gang

        while (!messageFromClient.toUpperCase().equals("EXIT")) {
            System.out.println("Hey dette er fra Client: " + messageFromClient);
            messageFromClient = inputFromClient.nextLine();//sørger for at vente på næste input
        }

        try {
            this.server.removeClientFromServer(this);
            socketConnection.close();
        } catch (IOException ex) {
            Logger.getLogger(ClientHandler.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

}
