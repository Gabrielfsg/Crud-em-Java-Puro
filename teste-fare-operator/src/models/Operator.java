package models;

public class Operator {

    private String id;
    private String code;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public void validarInsercao(Operator opValidacao){
        if(id == null){
            throw new RuntimeException("Não é possível salvar um registro com Id não preenchido");
        }
    }

    public void validarUpdate(Operator operatorValidacao, String id){
        if(operatorValidacao == null){
            throw new RuntimeException("Não há registros para a entidade Fare com Id " + id);
        }
    }
}
