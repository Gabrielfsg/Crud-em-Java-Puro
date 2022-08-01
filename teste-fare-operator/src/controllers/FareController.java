package controllers;

import models.Fare;
import models.Operator;
import services.FareService;
import services.OperatorService;

import java.util.List;

public class FareController {

    FareService fareService = new FareService();
    OperatorService operatorService = new OperatorService();

    public void createFare(Fare fare, String operatorCode, List<Operator> lista) {
        Operator operator = operatorService.getOperatorByCode(operatorCode, lista);
        if (operator != null) {
            fare.setOperator(operator);
            fareService.create(fare);
        } else {
            System.out.println("Operador não encontrado. Registre um operador primeiro ou entre com um código existente.");
        }
    }

    public List<Fare> listarFares() {
        return fareService.getFares();
    }

    public Fare buscarPorId(String id) {
        return fareService.getFareById(id);
    }

    public void editarFare(Fare fare) {
        fareService.update(fare);
    }
}
