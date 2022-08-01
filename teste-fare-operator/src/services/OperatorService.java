package services;

import models.Operator;
import repository.OperatorRepository;

import java.util.List;

public class OperatorService {

    OperatorRepository operatorRepository = new OperatorRepository();

    public Operator getOperatorByCode(String code, List<Operator> operators)
    {
        Operator selectedOperator = operators.stream().filter(op -> op.getCode().equals(code))
                .findAny().orElse(null);
        return selectedOperator;
    }

    public Operator getOperatorById(String id)
    {
        return operatorRepository.getById(id);
    }

    public List<Operator> getOperators()
    {
        return operatorRepository.getAll();
    }

    public void create(Operator insertingOperator)
    {
        operatorRepository.insert(insertingOperator);
    }

    public void update(Operator updatingOperator)
    {
        operatorRepository.update(updatingOperator);
    }
}
