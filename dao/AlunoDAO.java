package dao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import model.Aluno;
import util.Conexao;


public class AlunoDAO {



    public AlunoDAO() {}

    public void salvar(Aluno aluno) throws Exception {
        String sql = "INSERT INTO alunos (nome, cpf, data_nascimento, telefone, email) VALUES (?, ?, ?, ?, ?)";

        try (Connection conn = Conexao.getConexao();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, aluno.getNome());
            stmt.setString(2, aluno.getCpf());
            stmt.setString(3, aluno.getDataNascimento());
            stmt.setString(4, aluno.getTelefone());
            stmt.setString(5, aluno.getEmail());
            stmt.executeUpdate();
        }
    }

        public List<Aluno> listarTodos() throws Exception {
        List<Aluno> lista = new ArrayList<>();
        String sql = "SELECT * FROM alunos ORDER BY nome";
        try (Connection conn = Conexao.getConexao();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                Aluno aluno = new Aluno(
                    rs.getString("nome"),
                    rs.getString("cpf"),
                    rs.getString("data_nascimento"),
                    rs.getString("telefone"),
                    rs.getString("email")
                );
                lista.add(aluno);
            }
        }
        return lista;
    }

     public void atualizar(Aluno aluno) throws Exception {
        String sql = "UPDATE alunos SET nome = ?, data_nascimento = ?, telefone = ?, email = ? WHERE cpf = ?";
        try (Connection conn = Conexao.getConexao();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, aluno.getNome());
            stmt.setString(2, aluno.getDataNascimento());
            stmt.setString(3, aluno.getTelefone());
            stmt.setString(4, aluno.getEmail());
            stmt.setString(5, aluno.getCpf());
            stmt.executeUpdate();
        }
    }

        public void excluir(String termo) throws Exception {
        String sql = "DELETE FROM alunos WHERE nome ILIKE ? OR cpf = ?";
        try (Connection conn = Conexao.getConexao();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
              stmt.setString(1, "%" + termo + "%");
            stmt.setString(2, termo);
            stmt.executeUpdate();
        }
    }

     public List<Aluno> buscarPorNomeOuCpf(String termo) throws Exception {
        List<Aluno> lista = new ArrayList<>();
        String sql = "SELECT * FROM alunos WHERE nome ILIKE ? OR cpf = ?";
        try (Connection conn = Conexao.getConexao();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, "%" + termo + "%");
            stmt.setString(2, termo);
            try (ResultSet rs = stmt.executeQuery()) {
                while (rs.next()) {
                    Aluno aluno = new Aluno(
                        rs.getString("nome"),
                        rs.getString("cpf"),
                        rs.getString("data_nascimento"),
                        rs.getString("telefone"),
                        rs.getString("email")
                    );
                    lista.add(aluno);
                }
            }
        }
        return lista;
    }




    
}
