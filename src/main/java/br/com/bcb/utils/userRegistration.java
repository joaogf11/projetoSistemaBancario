package br.com.bcb.utils;

import br.com.bcb.models.scope.User;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.MongoCollection;
import org.bson.Document;

public class userRegistration {

    public static void registerUser(User user) {

        MongoClient mongoClient = MongoClients.create("mongodb://localhost:27017");
        MongoDatabase database = mongoClient.getDatabase("BDBdb");
        MongoCollection<Document> collection = database.getCollection("users");

        Document userDocument = new Document();
        userDocument.append("name", user.getName());
        userDocument.append("cpf", user.getCpf());
        userDocument.append("balance", user.getBalance());
        userDocument.append("accountPassword", user.getAccountPassword());
        userDocument.append("cardPassword", user.getCardPassword());
        userDocument.append("atpPassword", user.getAtpPassword());
        userDocument.append("bornDate", user.getBornDate());
        userDocument.append("gender", user.getGender());
        userDocument.append("address", user.getAddress());
        userDocument.append("cellNumber", user.getCellNumber());
        userDocument.append("bornDateUnixTime", user.getBornDateUnixTime());


        collection.insertOne(userDocument);

        mongoClient.close();


    }


}


