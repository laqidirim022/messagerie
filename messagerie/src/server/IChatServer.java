package server;

import client.IChatClient;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface IChatServer extends Remote {
    void registerChatClient(IChatClient chatClient) throws RemoteException;
    void broadcastMessage(String msg) throws RemoteException;
}
