package io.mk.executor;

public class Resumo {

    private Integer sucesso = 0;
    private Integer falha = 0;

    public void addSucesso(){
        sucesso++;
    }

    public void addFalha(){
        falha++;
    }

    public void addResumo(Resumo resumo){
        sucesso += resumo.getSucesso();
        falha += resumo.getFalha();
    }

    public Integer getSucesso() {
        return sucesso;
    }

    public Integer getFalha() {
        return falha;
    }


    @Override
    public String toString() {
        return "Resumo{" +
                "sucesso=" + sucesso +
                ", falha=" + falha +
                '}';
    }
}
