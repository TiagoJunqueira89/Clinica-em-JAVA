package dataAccessObject;

import exception.ExcepcaoDAO;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import model.Utente;

/**
 *
 * @author Tiago Junqueira
 */

/**
 * Classe responsável pelas operações CRUD da entidade Utente na base de dados
 */
public class UtenteDAO {

    /**
     * Cria um novo utente na base de dados
     * 
     * @param utente O utente a criar
     * @throws ExcepcaoDAO Em caso de erro de acesso à base de dados
     */
    public void criarUtente(Utente utente) throws ExcepcaoDAO {
        String sql = "INSERT INTO utentes (nome, contacto) VALUES (?, ?)";

        try (Connection ligacao = ConnectionBD.getConnection();
             PreparedStatement ps = ligacao.prepareStatement(sql)) {

            ps.setString(1, utente.getNome());
            ps.setString(2, utente.getContacto());
            ps.executeUpdate();

        } catch (SQLException e) {
            throw new ExcepcaoDAO("Erro ao criar utente: " + e.getMessage(), e);
        }
    }

    /**
     * Lê um utente a partir do seu ID
     * 
     * @param id O ID do utente a ler
     * @return O objecto Utente, ou null se não existir
     * @throws ExcepcaoDAO Em caso de erro de acesso à base de dados
     */
    public Utente lerUtentePorId(int id) throws ExcepcaoDAO {
        String sql = "SELECT * FROM utentes WHERE id = ?";
        Utente utente = null;

        try (Connection ligacao = ConnectionBD.getConnection();
             PreparedStatement ps = ligacao.prepareStatement(sql)) {
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                utente = new Utente();
                utente.setId(rs.getInt("id"));
                utente.setNome(rs.getString("nome"));
                utente.setContacto(rs.getString("contacto"));
            }
        } catch (SQLException e) {
            throw new ExcepcaoDAO("Erro ao ler utente por ID: " + e.getMessage(), e);
        }
        return utente;
    }

    /**
     * Lê todos os utentes da base de dados
     * 
     * @return Uma lista de todos os utentes
     * @throws ExcepcaoDAO Em caso de erro de acesso à base de dados
     */
    public List<Utente> lerTodosUtentes() throws ExcepcaoDAO {
        String sql = "SELECT * FROM utentes";
        List<Utente> lista = new ArrayList<>();

        try (Connection ligacao = ConnectionBD.getConnection();
             PreparedStatement ps = ligacao.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {
            while (rs.next()) {
                Utente utente = new Utente();
                utente.setId(rs.getInt("id"));
                utente.setNome(rs.getString("nome"));
                utente.setContacto(rs.getString("contacto"));
                lista.add(utente);
            }
        } catch (SQLException e) {
            throw new ExcepcaoDAO("Erro ao ler todos os utentes: " + e.getMessage(), e);
        }
        return lista;
    }

    /**
     * Actualiza os dados de um utente existente na base de dados
     * 
     * @param utente O utente com os dados actualizados
     * @throws ExcepcaoDAO Em caso de erro de acesso à base de dados
     */
    public void actualizarUtente(Utente utente) throws ExcepcaoDAO {
        String sql = "UPDATE utentes SET nome = ?, contacto = ? WHERE id = ?";

        try (Connection ligacao = ConnectionBD.getConnection();
             PreparedStatement ps = ligacao.prepareStatement(sql)) {

            ps.setString(1, utente.getNome());
            ps.setString(2, utente.getContacto());
            ps.setInt(3, utente.getId());

            ps.executeUpdate();

        } catch (SQLException e) {
            throw new ExcepcaoDAO("Erro ao actualizar utente: " + e.getMessage(), e);
        }
    }

    /**
     * Apaga um utente da base de dados
     * 
     * @param id O ID do utente a apagar
     * @throws ExcepcaoDAO Em caso de erro de acesso à base de dados
     */
    public void apagarUtente(int id) throws ExcepcaoDAO {
        String sql = "DELETE FROM utentes WHERE id = ?";

        try (Connection ligacao = ConnectionBD.getConnection();
             PreparedStatement ps = ligacao.prepareStatement(sql)) {

            ps.setInt(1, id);
            ps.executeUpdate();

        } catch (SQLException e) {
            throw new ExcepcaoDAO("Erro ao apagar utente: " + e.getMessage(), e);
        }
    }
    
    /**
 * Lê um utente
 * 
 * @param nome Nome do utente a procurar
 * @return O objeto Utente encontrado ou null se não existir
 * @throws ExcepcaoDAO Em caso de erro de acesso à base de dados
 */
    public Utente lerUtentePorNome(String nome) throws ExcepcaoDAO {
        String sql = "SELECT * FROM utentes WHERE nome = ?";
        Utente utente = null;

        try (Connection ligacao = ConnectionBD.getConnection(); PreparedStatement ps = ligacao.prepareStatement(sql)) {

            ps.setString(1, nome);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                utente = new Utente();
                utente.setId(rs.getInt("id"));
                utente.setNome(rs.getString("nome"));
                utente.setContacto(rs.getString("contacto"));
            }

        } catch (SQLException e) {
            throw new ExcepcaoDAO("Erro ao ler utente por nome: " + e.getMessage(), e);
        }

        return utente;
    }
}
