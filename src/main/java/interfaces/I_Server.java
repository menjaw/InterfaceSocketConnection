/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interfaces;

import control.ClientHandler;

/**
 *
 * @author Menja
 */
public interface I_Server {
    public void listenForClients();
    public void addClientToServer(ClientHandler clientHandler);
    public void removeClientFromServer(ClientHandler clientHandler);
}
