package repository;

import models.Fare;
import models.Operator;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

public class FareRepository {

    List<Fare> fareTable = new ArrayList<>();

    public void insert(Fare fare){
        Fare fareValidacao = buscaFareJaExistente(fare.getId());
        fare.validarInsercao(fareValidacao);
        if(validaFareStatus(fare.getOperator())){
            fareTable.add(fare);
            System.out.println("Tarifa cadastrada com sucesso!");
        } else {
            System.out.println("Operador ja possui vinculo com um fare ativo. ");
        }

    }

    private boolean validaFareStatus(Operator operator){
        AtomicInteger validator = new AtomicInteger();
        fareTable.forEach(fare -> {
            if(fare.getOperator().getId() == operator.getId()){
                validator.addAndGet(1);
            }
        });
        if(validator.get() == 0){
            return true;
        } else {
            return false;
        }
    }

    public void update(Fare fare){
        Fare fareValidacao = buscaFareJaExistente(fare.getId());
        fare.validarUpdate(fareValidacao, fare.getId());
        fareTable.remove(fareValidacao);
        fareTable.add(fare);
    }

    private Fare buscaFareJaExistente(String id){
        return fareTable.stream().filter(fare1 -> fare1.getId().equals(id))
                .findAny().orElse(null);
    }


    public Fare getById(String id){
        return buscaFareJaExistente(id);
    }

    public List<Fare> getAll(){
        return fareTable;
    }
}
