package br.com.bcb;

import com.mongodb.MongoClient;
import com.mongodb.client.MongoDatabase;

public class Main {
    public static void main(String[] args) {
        MongoClient connect = new MongoClient("localhost", 27017);
        MongoDatabase dataBase = connect.getDatabase("SistemaBCB");
        System.out.println("Conectado com Sucesso!");
    }

}
