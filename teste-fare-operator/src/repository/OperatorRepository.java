package repository;

import models.Fare;
import models.Operator;

import java.util.ArrayList;
import java.util.List;

public class OperatorRepository {

    List<Operator> fareTable = new ArrayList<>();

    public void insert(Operator op){
        Operator opValidacao = buscaOperatorJaExistentePeloCode(op.getCode());
        if(opValidacao != null){
            System.out.println("Já existe um registro para a entidade Fare com esse código. ");
        } else {
            op.validarInsercao(opValidacao);
            fareTable.add(op);
            System.out.println("Operator cadastrado com sucesso!");
        }
    }

    public void update(Operator op){
        Operator fareValidacao = buscaOperatorJaExistente(op.getId());
        op.validarUpdate(fareValidacao, op.getId());
        fareTable.remove(fareValidacao);
        fareTable.add(op);
    }

    private Operator buscaOperatorJaExistente(String id){
        return fareTable.stream().filter(op -> op.getId() == id)
                .findAny().orElse(null);
    }

    private Operator buscaOperatorJaExistentePeloCode(String code){
        return fareTable.stream().filter(op -> op.getCode().equals(code))
                .findAny().orElse(null);
    }


    public Operator getById(String id){
        return buscaOperatorJaExistentePeloCode(id);
    }

    public List<Operator> getAll(){
        return fareTable;
    }
}
