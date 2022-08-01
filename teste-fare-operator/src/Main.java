import controllers.FareController;
import controllers.OperatorController;
import models.Fare;
import models.Operator;

import java.util.List;
import java.util.UUID;

import java.util.Scanner;

public class Main {

    FareController fareController = new FareController();

    OperatorController operatorController = new OperatorController();
    Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        Scanner scMain = new Scanner(System.in);
        Main main = new Main();
        int opc = 0;
        while (opc != 7) {
            System.out.println("### MENU ### \n" +
                    "1.Cadastrar Fare. \n" +
                    "2.Cadastrar Operator. \n" +
                    "3.Editar Fare. \n" +
                    "4.Editar Operator. \n" +
                    "5.Buscar Fares. \n" +
                    "6.Buscar Operators. \n" +
                    "7.Sair. \n" +
                    "Escolha uma Opção: ");
            opc = scMain.nextInt();

            switch (opc) {
                case 1:
                    main.novoFare();
                    break;
                case 2:
                    main.novoOperator();
                    break;
                case 3:
                    main.editarFare();
                    break;
                case 4:
                    main.editarOperator();
                    break;
                case 5:
                    main.listarFares();
                    break;
                case 6:
                    main.listarOperators();
                    break;
                case 7:
                    System.exit(0);
                    break;
                default:
                    System.out.println("Informe um opção válida. ");
            }
        }

    }

    public void novoFare() {
        Fare fare = new Fare();
        fare.setId(UUID.randomUUID().toString());
        System.out.println("Informe o valor da tarifa a ser cadastrada:");
        double num2 = sc.nextDouble();
        fare.setValue(num2);
        System.out.println("Informe o código da operadora para a tarifa:");
        System.out.println("Exemplos: OP01, OP02, OP03...");
        String operatorCodeInput = sc.next();
        fare.setStatus(1);
        List<Operator> operators = operatorController.listarOpetarors();
        fareController.createFare(fare, operatorCodeInput, operators);
    }

    public void novoOperator() {
        Operator operator = new Operator();
        operator.setId(UUID.randomUUID().toString());
        System.out.println("Cadastre o código da operadora para a tarifa:");
        System.out.println("Exemplos: OP01, OP02, OP03...");
        String operatorCodeInput = sc.next();
        operator.setCode(operatorCodeInput);
        operatorController.createOperator(operator);
    }

    public void listarFares() {
        List<Fare> fares = fareController.listarFares();
        if(fares.size() > 0){
            fares.forEach(fare -> {
                System.out.println("Id Fare: " + fare.getId());
                System.out.println("Status: " + fare.getStatus());
                System.out.println("Value: " + fare.getValue());
                System.out.println("Id Operator: " + fare.getOperator().getCode());
                System.out.println("\n");
            });
        } else {
            System.out.println("Nenhum Registro Encontrado. ");
        }
    }

    public void listarOperators() {
        List<Operator> operators = operatorController.listarOpetarors();
        if(operators.size() > 0){
            operators.forEach(op -> {
                System.out.println("Id Operator: " + op.getId());
                System.out.println("Código Operator: " + op.getCode());
                System.out.println("\n");
            });
        } else {
            System.out.println("Nenhum Registro Encontrado. ");
        }
    }

    public void editarFare() {
        System.out.println("Entre com o id do Fare");
        String id = sc.next();
        Fare fare = fareController.buscarPorId(id);
        if (fare != null) {
            System.out.println("Informe o valor da tarifa a ser cadastrada:");
            double num2 = sc.nextDouble();
            fare.setValue(num2);
            fareController.editarFare(fare);
            System.out.println("Tarifa editada com sucesso!");
        } else {
            System.out.println("Fare não encontrado!");
        }
    }

        public void editarOperator () {
            System.out.println("Entre com o código do operator");
            String code = sc.next();
            Operator operator = operatorController.buscarPorCode(code);
            if (operator != null) {
                System.out.println("Cadastre o código da operadora para a tarifa:");
                System.out.println("Exemplos: OP01, OP02, OP03...");
                String operatorCodeInput = sc.next();
                operator.setCode(operatorCodeInput);
                operatorController.editarOperator(operator);
                System.out.println("Operator editado com sucesso!");
            } else {
                System.out.println("Operator não encontrado!");
            }
        }
    }
