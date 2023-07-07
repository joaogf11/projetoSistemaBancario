package br.com.bcb.utils;

import br.com.bcb.models.scope.User;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Date;
import java.util.Scanner;

public class Utils {
    public void linesRepeat(){
        System.out.println("=".repeat(50));
    }
    public void printMenu() {
        linesRepeat();
        System.out.println("Escolha uma opção:");
        System.out.println("1 - Realizar Transferencia");
        System.out.println("2 - Histórico de Transferencia");
        System.out.println("3 - Cadastrar Usuário");
        System.out.println("4 - Sair");
        linesRepeat();
    }

    public Instant convertBornDateToInstant(String bornDateStr) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        try {
            LocalDate bornDate = LocalDate.parse(bornDateStr, formatter);
            return bornDate.atStartOfDay(ZoneId.systemDefault()).toInstant();
        } catch (DateTimeParseException e) {
            e.printStackTrace();
            System.out.println("Erro ao converter. " + e.getMessage());
            return null;
        }
    }

    public void optionSelect(){
        int option;
        do {
            linesRepeat();
            printMenu();
            option = Integer.parseInt(new Scanner(System.in).nextLine());

            switch (option) {
                case 1 -> {
                    linesRepeat();
                    System.out.println("Realizar Transferencia");
                }
                case 2 -> {
                    linesRepeat();
                    System.out.println("Histórico de Transferencia");
                }
                case 3 -> {
                    linesRepeat();
                    System.out.println("Cadastrar Usuário");

                    Scanner scanner = new Scanner(System.in);

                    User user = new User();

                    System.out.print("Digite o nome: ");
                    String name = scanner.nextLine();
                    user.setName(name);

                    System.out.print("Digite o CPF: ");
                    String cpf = scanner.nextLine();
                    user.setCpf(cpf);

                    System.out.print("Digite o saldo: ");
                    double balance = scanner.nextDouble();
                    scanner.nextLine();
                    user.setBalance(balance);


                    System.out.print("Digite a senha da conta: ");
                    int accountPassword = scanner.nextInt();
                    user.setAccountPassword(accountPassword);

                    scanner.nextLine();

                    System.out.print("Digite a senha do ATP: ");
                    int atpPassword = scanner.nextInt();
                    user.setAtpPassword(atpPassword);

                    scanner.nextLine();

                    System.out.print("Digite a senha do cartão: ");
                    int cardPassword = scanner.nextInt();
                    user.setCardPassword(cardPassword);


                    System.out.print("Digite a data de nascimento (dd/MM/yyyy): ");
                    String bornDateStr = scanner.nextLine();
                    user.setBornDate(bornDateStr);
                    Instant bornDateUnixTime = convertBornDateToInstant(bornDateStr);
                    user.setBornDateUnixTime(bornDateUnixTime);

                    System.out.print("Digite o gênero: ");
                    String gender = scanner.nextLine();
                    user.setGender(gender);

                    System.out.print("Digite o endereço: ");
                    String address = scanner.nextLine();
                    user.setAddress(address);

                    System.out.print("Digite o número de celular: ");
                    String cellNumber = scanner.nextLine();
                    user.setCellNumber(cellNumber);

                    userRegistration.registerUser(user);
                }
                case 4 -> {
                    linesRepeat();
                    System.out.println("Até a próxima!");
                }
                default -> System.out.println("Opção inválida. Tente novamente.");
            }
        } while (option != 4);
    }
}
