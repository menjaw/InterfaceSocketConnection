/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interfaces;

/**
 *
 * @author Menja
 */
public interface I_Client {

    public void connectToServer(String ipAddress, int port);

    public void closeConnection();

    public void sendMessage(String message);

    public String askForString(String question);

    public String askForPassword(String question);

    public String askForEmail(String question);

    public int askForInterger(String question);

    public int askForInteger(String question, int min, int max);

    public int makeMultiChoises(String question, String[] choises);

}
