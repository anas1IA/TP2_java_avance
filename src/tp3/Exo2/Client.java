package Exo2;

import java.net.*;
import java.io.*;

public class Client{

    static Socket clientSocket;
    public static void main(String[] args){

        clientSocket = new Socket("127.0.0.1", 8000);
        System.out.println("Hello");

    }
}