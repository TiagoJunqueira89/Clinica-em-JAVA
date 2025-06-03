package dataAccessObject;

import exception.ExcepcaoDAO;
import model.Consulta;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Tiago Junqueira
 */

/**
 * Classe responsável pelas operações CRUD da entidade Consulta na base de dados
 */
public class ConsultaDAO {

    /**
     * Cria uma nova consulta na base de dados
     * 
     * @param consulta A consulta a criar
     * @throws ExcepcaoDAO Em caso de erro de acesso à base de dados
     */
    public void criarConsulta(Consulta consulta) throws ExcepcaoDAO {
        String sql = "INSERT INTO consultas (data_consulta, hora_consulta, utente_id) VALUES (?, ?, ?)";

        try (Connection ligacao = ConnectionBD.getConnection();
             PreparedStatement ps = ligacao.prepareStatement(sql)) {

            ps.setString(1, consulta.getDataConsulta());
            ps.setString(2, consulta.getHoraConsulta());
            ps.setInt(3, consulta.getUtenteId());
            ps.executeUpdate();

        } catch (SQLException e) {
            throw new ExcepcaoDAO("Erro ao criar consulta: " + e.getMessage(), e);
        }
    }

    /**
     * Lê uma consulta a partir do ID
     * 
     * @param id O ID da consulta a ler
     * @return O objecto Consulta, ou null se não existir
     * @throws ExcepcaoDAO Em caso de erro de acesso à base de dados
     */
    public Consulta lerConsultaPorId(int id) throws ExcepcaoDAO {
        String sql = "SELECT * FROM consultas WHERE id = ?";
        Consulta consulta = null;

        try (Connection ligacao = ConnectionBD.getConnection();
             PreparedStatement ps = ligacao.prepareStatement(sql)) {

            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                consulta = new Consulta();
                consulta.setId(rs.getInt("id"));
                consulta.setDataConsulta(rs.getString("data_consulta"));
                consulta.setHoraConsulta(rs.getString("hora_consulta"));
                consulta.setUtenteId(rs.getInt("utente_id"));
            }

        } catch (SQLException e) {
            throw new ExcepcaoDAO("Erro ao ler consulta por ID: " + e.getMessage(), e);
        }

        return consulta;
    }

    /**
     * Le todas as consultas da base de dados
     * 
     * @return Uma lista de todas as consultas
     * @throws ExcepcaoDAO Em caso de erro de acesso à base de dados
     */
    public List<Consulta> lerTodasConsultas() throws ExcepcaoDAO {
        String sql = "SELECT * FROM consultas";
        List<Consulta> lista = new ArrayList<>();

        try (Connection ligacao = ConnectionBD.getConnection();
             PreparedStatement ps = ligacao.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {
                Consulta consulta = new Consulta();
                consulta.setId(rs.getInt("id"));
                consulta.setDataConsulta(rs.getString("data_consulta"));
                consulta.setHoraConsulta(rs.getString("hora_consulta"));
                consulta.setUtenteId(rs.getInt("utente_id"));
                lista.add(consulta);
            }

        } catch (SQLException e) {
            throw new ExcepcaoDAO("Erro ao ler todas as consultas: " + e.getMessage(), e);
        }

        return lista;
    }

    /**
     * Actualiza os dados de uma consulta existente na base de dados
     * 
     * @param consulta A consulta com dados actualizados
     * @throws ExcepcaoDAO Em caso de erro de acesso à base de dados
     */
    public void actualizarConsulta(Consulta consulta) throws ExcepcaoDAO {
        String sql = "UPDATE consultas SET data_consulta = ?, hora_consulta = ?, utente_id = ? WHERE id = ?";

        try (Connection ligacao = ConnectionBD.getConnection();
             PreparedStatement ps = ligacao.prepareStatement(sql)) {

            ps.setString(1, consulta.getDataConsulta());
            ps.setString(2, consulta.getHoraConsulta());
            ps.setInt(3, consulta.getUtenteId());
            ps.setInt(4, consulta.getId());

            ps.executeUpdate();

        } catch (SQLException e) {
            throw new ExcepcaoDAO("Erro ao actualizar consulta: " + e.getMessage(), e);
        }
    }

    /**
     * Apaga uma consulta da base de dados
     * 
     * @param id O ID da consulta a apagar
     * @throws ExcepcaoDAO Em caso de erro de acesso à base de dados
     */
    public void apagarConsulta(int id) throws ExcepcaoDAO {
        String sql = "DELETE FROM consultas WHERE id = ?";

        try (Connection ligacao = ConnectionBD.getConnection();
             PreparedStatement ps = ligacao.prepareStatement(sql)) {

            ps.setInt(1, id);
            ps.executeUpdate();

        } catch (SQLException e) {
            throw new ExcepcaoDAO("Erro ao apagar consulta: " + e.getMessage(), e);
        }
    }
}