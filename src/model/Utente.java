package model;

/**
 *
 * @author Tiago Junqueira
 */
public class Utente {
    
    private int id;
    private String nome;
    private String contacto;

    /**
     * Construtor vazio
     */
    public Utente() {
    }

    /**
     * Construtor completo
     * 
     * @param id       Identificador do utente
     * @param nome     Nome do utente
     * @param contacto Contacto telefónico do utente
     */
    public Utente(int id, String nome, String contacto) {
        this.id = id;
        this.nome = nome;
        this.contacto = contacto;
    }

    /**
     * Obtém o identificador do utente
     * 
     * @return O ID do utente
     */
    public int getId() {
        return id;
    }

    /**
     * Define o identificador do utente
     * 
     * @param id Novo ID do utente
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * Obtém o nome do utente
     * 
     * @return O nome do utente
     */
    public String getNome() {
        return nome;
    }

    /**
     * Define o nome do utente
     * 
     * @param nome Novo nome do utente
     */
    public void setNome(String nome) {
        this.nome = nome;
    }

    /**
     * Obtém o contacto do utente
     * 
     * @return O contacto do utente
     */
    public String getContacto() {
        return contacto;
    }

    /**
     * Define o contacto do utente
     * 
     * @param contacto Novo contacto do utente
     */
    public void setContacto(String contacto) {
        this.contacto = contacto;
    }

    /**
     * Compara este utente com outro objecto para verificar igualdade
     *
     * @param o O objecto a comparar
     * @return true se forem iguais, false caso contrário
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Utente)) return false;

        Utente utente = (Utente) o;

        return id == utente.id;
    }

    /**
     * Calcula o hash code para este utente
     *
     * @return O hash code baseado no ID
     */
    @Override
    public int hashCode() {
        return Integer.hashCode(id);
    }

    /**
     * Retorna uma representação em texto do utente
     *
     * @return String com os dados do utente
     */
    @Override
    public String toString() {
        return nome;
    }
}
    

