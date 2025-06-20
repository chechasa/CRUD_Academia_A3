package model;


public class Treino {
    private int alunoId;
    private String tipoTreino;
    private String descricao;
    private int duracaoMinutos;
    private String dataInicio;


    public Treino() {}


    public Treino( int alunoId, String tipoTreino, String descricao,
                  int duracaoMinutos, String dataInicio) {
        this.alunoId = alunoId;
        this.tipoTreino = tipoTreino;
        this.descricao = descricao;
        this.duracaoMinutos = duracaoMinutos;
        this.dataInicio = dataInicio;
    }

     public Treino(String tipoTreino, String descricao,
                  int duracaoMinutos, String dataInicio) {
        this.tipoTreino = tipoTreino;
        this.descricao = descricao;
        this.duracaoMinutos = duracaoMinutos;
        this.dataInicio = dataInicio;
    }


    public int getAlunoId() { return alunoId; }
    public void setAlunoId(int alunoId) { this.alunoId = alunoId; }

    public String getTipoTreino() { return tipoTreino; }
    public void setTipoTreino(String tipoTreino) { this.tipoTreino = tipoTreino; }

    public String getDescricao() { return descricao; }
    public void setDescricao(String descricao) { this.descricao = descricao; }

    public int getDuracaoMinutos() { return duracaoMinutos; }
    public void setDuracaoMinutos(int duracaoMinutos) { this.duracaoMinutos = duracaoMinutos; }

    public String getDataInicio() { return dataInicio; }
    public void setDataInicio(String dataInicio) { this.dataInicio = dataInicio; }


    @Override
public String toString() {
    return "Treino {" +
           ", Aluno ID = " + alunoId +
           ", Tipo = '" + tipoTreino + '\'' +
           ", Descrição = '" + descricao + '\'' +
           ", Duração (min) = " + duracaoMinutos +
           ", Início = '" + dataInicio + '\'' +
           '}';
}
}