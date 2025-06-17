package model;


public class Aluno {
    private int id;
    private String nome;
    private String cpf;
    private String dataNascimento;
    private String telefone;
    private String email;

    // Construtor vazio
    public Aluno() {}

    // Construtor completo
    public Aluno(String nome, String cpf, String dataNascimento,
                 String telefone, String email) {
        this.nome = nome;
        this.cpf = cpf;
        this.dataNascimento = dataNascimento;
        this.telefone = telefone;
        this.email = email;
    }

    // Getters e Setters
    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public String getNome() { return nome; }
    public void setNome(String nome) {
        if (nome == null || nome.trim().isEmpty()) {
            throw new IllegalArgumentException("Nome não pode ser vazio");
        }
        this.nome = nome;
    }

    public String getCpf() { return cpf; }
    public void setCpf(String cpf) {
        if (cpf == null || cpf.length() != 14) {
            throw new IllegalArgumentException("CPF inválido, formato 000.000.000-00");
        }
        this.cpf = cpf;
    }

    public String getDataNascimento() { return dataNascimento; }

    public void setDataNascimento(String dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public String getTelefone() { return telefone; }
    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getEmail() { return email; }
    public void setEmail(String email) {
        if (email == null || !email.contains("@")) {
            throw new IllegalArgumentException("Email inválido");
        }
        this.email = email;
    }

    @Override
public String toString() {
    return "\nAluno "+ this.nome +" {" +
           "nome='" + nome + '\'' +
           ", cpf='" + cpf + '\'' +
           ", dataNascimento='" + dataNascimento + '\'' +
           ", telefone='" + telefone + '\'' +
           ", email='" + email + '\'' +
           '}';
}
}