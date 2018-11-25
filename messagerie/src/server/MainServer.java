package server;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;

public class MainServer {

    public static void main(String[] args) throws RemoteException, MalformedURLException {

        LocateRegistry.createRegistry(8079);

        Naming.rebind("//localhost:8079/RMIChat", new ChatServer());

    }
}
