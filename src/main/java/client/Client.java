/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package client;

import interfaces.I_Client;
import java.util.Scanner;

/**
 *
 * @author Menja
 */
public class Client implements I_Client{
    private Scanner scanner;
    
    public Client() {
        scanner = new Scanner(System.in);
    }
    
    

    @Override
    public void connectToServer(String ipAddress, int port) {
       
    }

    @Override
    public void closeConnection() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void sendMessage(String message) {
        System.out.println(message);
    }

    @Override
    public String askForAddress(String question) {
        sendMessage(question);
        return scanner.nextLine();
    }

    @Override
    public String askForPassword(String question) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String askForName(String question) {
        sendMessage(question);
        return scanner.nextLine();
    }

    @Override
    public int askForAge(String question) {
        return 0;
    }

    @Override
    public int askForInteger(String question, int min, int max) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int makeMultiChoises(String question, String[] choises) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
