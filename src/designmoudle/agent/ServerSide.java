package com.agent;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class ServerSide extends UnicastRemoteObject implements ServerInterface {
    public ServerSide() throws RemoteException { }
    @Override
    public String sayHello() throws RemoteException {
        System.out.println("HELLO");
        return "HELLO";
    }
    public static void main(String[] args) throws RemoteException, MalformedURLException {
        ServerInterface server=new ServerSide();
        Naming.rebind("Server",server);
    }
}