package dao;

import model.Treino;
import util.Conexao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class TreinoDAO {

    public TreinoDAO() {};

    public void salvar(Treino treino) throws Exception {
        String sql = "INSERT INTO treinos (aluno_id, tipo_treino, descricao, duracao_minutos, data_inicio) VALUES (?, ?, ?, ?, ?)";

        try (Connection conn = Conexao.getConexao();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, treino.getAlunoId());
            stmt.setString(2, treino.getTipoTreino());
            stmt.setString(3, treino.getDescricao());
            stmt.setInt(4, treino.getDuracaoMinutos());
            stmt.setString(5, treino.getDataInicio());

            stmt.executeUpdate();
        }
    }

    public List<Treino> listarPorAluno(int alunoId) throws Exception {
        List<Treino> lista = new ArrayList<>();
        String sql = "SELECT * FROM treinos WHERE aluno_id = ?";

        try (Connection conn = Conexao.getConexao();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, alunoId);
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                Treino t = new Treino(
                    rs.getInt("aluno_id"),
                    rs.getString("tipo_treino"),
                    rs.getString("descricao"),
                    rs.getInt("duracao_minutos"),
                    rs.getString("data_inicio")
                );
                lista.add(t);
            }
        }

        return lista;
    }

    public void atualizar(Treino treino, int idTreino) throws Exception {
        String sql = "UPDATE treinos SET tipo_treino = ?, descricao = ?, duracao_minutos = ?, data_inicio = ? WHERE id = " + idTreino;

        try (Connection conn = Conexao.getConexao();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, treino.getTipoTreino());
            stmt.setString(2, treino.getDescricao());
            stmt.setInt(3, treino.getDuracaoMinutos());
            stmt.setString(4, treino.getDataInicio());

            stmt.executeUpdate();
        }
    }

    public void excluir(int treinoId) throws Exception {
        String sql = "DELETE FROM treinos WHERE id = ?";

        try (Connection conn = Conexao.getConexao();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, treinoId);
            stmt.executeUpdate();
        }
    }
}
