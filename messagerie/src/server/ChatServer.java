package server;

import client.IChatClient;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;

public class ChatServer extends UnicastRemoteObject implements IChatServer {

    private ArrayList<IChatClient> chatClients;

    protected ChatServer() throws RemoteException {
        chatClients=new ArrayList<IChatClient>();
    }

    @Override
    public void registerChatClient(IChatClient chatClient) throws RemoteException {
        this.chatClients.add(chatClient);
    }

    @Override
    public void broadcastMessage(String msg) throws RemoteException {

        for(IChatClient client : chatClients){
            client.receiveMessage(msg);
        }

    }

}
