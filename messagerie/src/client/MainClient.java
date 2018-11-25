package client;

import server.IChatServer;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;

public class MainClient {

    public static void main(String[] args) throws RemoteException, NotBoundException, MalformedURLException {

        String serverURL ="//localhost:8079/RMIChat";

        IChatServer chatServer = (IChatServer) Naming.lookup(serverURL);

        try {
            new Thread(new ChatClient(args[0],chatServer)).start();
            chatServer.broadcastMessage("The Member "+args[0]+" just joined the chat .\n" );
        }catch (Exception e){
            e.printStackTrace();
        }

    }
}
