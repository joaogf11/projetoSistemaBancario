package br.com.bcb.utils;

import br.com.bcb.models.scope.Payments;
import br.com.bcb.models.scope.User;

import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Scanner;
import java.util.UUID;

public class Utils {
    private final findPayment findPayments = new findPayment();
    public void linesRepeat() {
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


    public void getHist() {
        findPayments.getHist();
    }
    public void transRegist() {
        Scanner scanner = new Scanner(System.in);
        Payments payments = new Payments();

        System.out.println("Digite o valor: ");
        double value = scanner.nextDouble();
        payments.setTransactionValue(value);

        System.out.println("Digite a data: ");
        scanner.nextLine();
        String transfDateStr = scanner.nextLine();
        payments.setTransactionDate(transfDateStr);
        Instant transfDateUnixTime = convertBornDateToInstant(transfDateStr);
        payments.setTransactionDateUnixTime(transfDateUnixTime);

        System.out.println("CPF do Pagador: ");
        String paidCpf = scanner.nextLine();
        payments.setUserPaid(paidCpf);

        System.out.println("Banco do Pagador: ");
        String paidBank = scanner.nextLine();
        payments.setUserPaidBank(paidBank);

        System.out.println("CPF do Receptor: ");
        String receivedCpf = scanner.nextLine();
        payments.setUserRecieved(receivedCpf);

        System.out.println("Banco do Receptor: ");
        String receivedBank = scanner.nextLine();
        payments.setUserRecievedBank(receivedBank);

        System.out.println("Forma de pagamento (TED, DOC ou PIX): ");
        String paymentMethod = scanner.nextLine();
        payments.setPaymentMethod(paymentMethod);

        UUID uuid = UUID.randomUUID();
        String uuidAsString = uuid.toString();
        payments.setUUID(uuidAsString);

        paymentRegistration.registerPayments(payments);
    }

    public void userRegist() {

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
        scanner.nextLine();
        user.setAccountPassword(accountPassword);

        scanner.nextLine();

        System.out.print("Digite a senha do ATP: ");
        int atpPassword = scanner.nextInt();
        scanner.nextLine();
        user.setAtpPassword(atpPassword);

        scanner.nextLine();

        System.out.print("Digite a senha do cartão: ");
        int cardPassword = scanner.nextInt();
        scanner.nextLine();
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

    public void optionSelect() {
        int option;
        do {
            linesRepeat();
            printMenu();
            option = Integer.parseInt(new Scanner(System.in).nextLine());

            switch (option) {
                case 1 -> {
                    linesRepeat();
                    System.out.println("Realizar Transferencia");
                    transRegist();
                }
                case 2 -> {
                    linesRepeat();
                    System.out.println("Histórico de Transferencia");
                    getHist();
                }
                case 3 -> {
                    linesRepeat();
                    System.out.println("Cadastrar Pagamento");
                    userRegist();
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
