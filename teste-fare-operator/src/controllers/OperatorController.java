package controllers;

import models.Fare;
import models.Operator;
import services.OperatorService;

import java.util.List;

public class OperatorController {

    OperatorService operatorService  = new OperatorService();

    public void createOperator(Operator operator){
        operatorService.create(operator);
    }

    public Operator buscarPorCode(String code){
        return operatorService.getOperatorById(code);
    }

    public void editarOperator(Operator operator){
        operatorService.update(operator);
    }

    public List<Operator> listarOpetarors(){
        return operatorService.getOperators();
    }
}
