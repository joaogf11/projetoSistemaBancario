package br.com.bcb.utils;

import com.mongodb.MongoClient;
import com.mongodb.client.MongoDatabase;

public class ManipulationFile {
    public void connect(){
        MongoClient connect = new MongoClient("localhost", 27017);
        MongoDatabase dataBase = connect.getDatabase("SistemaBCB");
        System.out.println("Conexão bem sucedida! ");
    }
}
