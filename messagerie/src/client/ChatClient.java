package client;

import server.IChatServer;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.Scanner;

public class ChatClient extends UnicastRemoteObject implements IChatClient, Runnable {

    private IChatServer chatServer;
    private String clientName;

    protected ChatClient(String clientName,IChatServer chatServer) throws RemoteException {
        this.clientName = clientName;
        this.chatServer = chatServer;
        chatServer.registerChatClient(this);
    }

    @Override
    public void receiveMessage(String msg) throws RemoteException {
        System.out.println(msg);
    }

    public void run() {
        Scanner scanner = new Scanner(System.in);
        String message;
        while(true) {
            message=scanner.nextLine();
            try {
                chatServer.broadcastMessage("\n"+clientName+" : " +message);
            } catch(RemoteException e) {
                e.printStackTrace();
            }
        }
    }


}
