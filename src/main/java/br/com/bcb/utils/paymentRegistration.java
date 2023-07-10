package br.com.bcb.utils;

import br.com.bcb.models.scope.Payments;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;

public class paymentRegistration {
    public static void registerPayments(Payments payments) {

        MongoClient mongoClient = MongoClients.create("mongodb://localhost:27017");
        MongoDatabase database = mongoClient.getDatabase("BDBdb");
        MongoCollection<Document> collection = database.getCollection("payments");

        Document paymentsDocument = new Document();
        paymentsDocument.append("value", payments.getTransactionValue());
        paymentsDocument.append("date", payments.getTransactionDate());
        paymentsDocument.append("userPaid", payments.getUserPaid());
        paymentsDocument.append("userPaidBank", payments.getUserPaidBank());
        paymentsDocument.append("userRecieved", payments.getUserRecieved());
        paymentsDocument.append("userRecievedBank", payments.getUserRecievedBank());
        paymentsDocument.append("paymentMethod", payments.getPaymentMethod());
        paymentsDocument.append("UUID", payments.getUUID());
        paymentsDocument.append("transactionalUnixTime", payments.getTransactionDateUnixTime());

        collection.insertOne(paymentsDocument);

        mongoClient.close();
    }


}
