package models;

import java.util.List;

public class Fare {

    private String id;
    private Operator operator;
    private int status;
    private double value;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Operator getOperator() {
        return operator;
    }

    public void setOperator(Operator operator) {
        this.operator = operator;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public double getValue() {
        return value;
    }

    public void setValue(double value) {
        this.value = value;
    }

    public void validarInsercao(Fare fareValidacao){
        if(id == null){
            throw new RuntimeException("Não é possível salvar um registro com Id não preenchido");
        }
        if(fareValidacao != null){
            throw new RuntimeException("Já existe um registro para a entidade Fare com o Id " + id);
        }
    }

    public void validarUpdate(Fare fareValidacao, String id){
        if(fareValidacao == null){
            throw new RuntimeException("Não há registros para a entidade Fare com Id " + id);
        }
    }
}
