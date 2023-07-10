package br.com.bcb.utils;
import com.mongodb.client.*;
import org.bson.Document;

import java.util.Arrays;
import java.util.Scanner;

public class findPayment {
    public void getHist() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Digite o CPF: ");
        String cpf = scanner.nextLine();

        paymentHistory(cpf);
    }

    public void paymentHistory(String cpf) {
        MongoClient mongoClient = MongoClients.create("mongodb://localhost:27017");
        MongoDatabase database = mongoClient.getDatabase("BDBdb");
        MongoCollection<Document> collection = database.getCollection("payments");

        Document query = new Document("$or", Arrays.asList(
                new Document("userPaid", cpf),
                new Document("userReceived", cpf)
        ));

        FindIterable<Document> results = collection.find(query);
        System.out.println("Query: " + query.toJson());

        try {
            for (Document result : results) {
                Double transactionValue = result.getDouble("transactionValue");
                if (transactionValue != null) {
                    String transactionDate = result.getString("transactionDate");
                    String userPaid = result.getString("userPaid");
                    String userReceived = result.getString("userReceived");
                    String userPaidBank = result.getString("userPaidBank");
                    String userReceivedBank = result.getString("userReceivedBank");
                    String uuid = result.getString("UUID");
                    String paymentMethod = result.getString("paymentMethod");

                    System.out.println("CPF: " + cpf);
                    System.out.println("Valor da transação: " + transactionValue);
                    System.out.println("Data da transação: " + transactionDate);
                    System.out.println("Usuário pagador: " + userPaid);
                    System.out.println("Usuário beneficiário: " + userReceived);
                    System.out.println("Banco do usuário pagador: " + userPaidBank);
                    System.out.println("Banco do usuário beneficiário: " + userReceivedBank);
                    System.out.println("UUID: " + uuid);
                    System.out.println("Método de pagamento: " + paymentMethod);
                    System.out.println("---------------------------------------");
                } else {
                    System.out.println("Nenhum pagamento encontrado para o CPF: " + cpf);
                }
            }
        } finally {
            mongoClient.close();
        }
    }
}
