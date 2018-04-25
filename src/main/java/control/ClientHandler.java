/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package control;

import interfaces.I_Client;

/**
 *
 * @author Menja
 */
public class ClientHandler implements Runnable{
    //Variables
    private I_Client i_client;
    private String name;
    private String address;
    private int age;

    //Constructor
    public ClientHandler() {
    }

    public ClientHandler(I_Client i_client) {
        this.i_client = i_client;
    }

    //Run conversation with client
    @Override
    public void run() {
        name = i_client.askForName("Type your name: ");
        address = i_client.askForAddress("What is your address? ");
        age = i_client.askForAge("What is your age? ");
        
        i_client.sendMessage("Hi " + name + "\n");
        i_client.sendMessage("Your address is " + address + "\n");
        i_client.sendMessage("and you are: " + age + " year old" + "\n");
    }
    
    

}
