package model;

/**
 *
 * @author Tiago Junqueira
 */
public class Consulta {
    
    private int id;
    private String dataConsulta;
    private String horaConsulta;
    private int utenteId; // Chave estrangeira para a tabela utentes

    /**
     * Construtor vazio
     */
    public Consulta() {
    }

    /**
     * Construtor completo
     * 
     * @param id           Identificador da consulta
     * @param dataConsulta Data da consulta
     * @param horaConsulta Hora da consulta
     * @param utenteId     ID do utente a que esta consulta pertence
     */
    public Consulta(int id, String dataConsulta, String horaConsulta, int utenteId) {
        this.id = id;
        this.dataConsulta = dataConsulta;
        this.horaConsulta = horaConsulta;
        this.utenteId = utenteId;
    }

    /**
     * Obtém o identificador da consulta
     * 
     * @return O ID da consulta
     */
    public int getId() {
        return id;
    }

    /**
     * Define o identificador da consulta
     * 
     * @param id Novo ID da consulta
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * Obtém a data da consulta
     * 
     * @return A data da consulta
     */
    public String getDataConsulta() {
        return dataConsulta;
    }

    /**
     * Define a data da consulta
     * 
     * @param dataConsulta Nova dta da consulta
     */
    public void setDataConsulta(String dataConsulta) {
        this.dataConsulta = dataConsulta;
    }

    /**
     * Obtém a hora da consulta
     * 
     * @return A hora da consulta
     */
    public String getHoraConsulta() {
        return horaConsulta;
    }

    /**
     * Define a hora da consulta
     * 
     * @param horaConsulta Nova hora da consulta
     */
    public void setHoraConsulta(String horaConsulta) {
        this.horaConsulta = horaConsulta;
    }

    /**
     * Obtém o ID do utente associado a esta consulta
     * 
     * @return O ID do utente
     */
    public int getUtenteId() {
        return utenteId;
    }

    
    public void setUtenteId(int utenteId) {
        this.utenteId = utenteId;
    }

    /**
     * Compara esta consulta com outro objecto para verificar igualdade
     *
     * @param o O objecto a comparar
     * @return true se forem iguais, false caso contrário
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Consulta)) return false;

        Consulta consulta = (Consulta) o;

        return id == consulta.id;
    }

    /**
     * Calcula o hash code para esta consulta
     *
     * @return O hash code baseado no ID
     */
    @Override
    public int hashCode() {
        return Integer.hashCode(id);
    }

    /**
     * Retorna uma representação em texto da consulta
     *
     * @return String com os dados da consulta
     */
    @Override
    public String toString() {
        return "Consulta{" +
                "id=" + id +
                ", dataConsulta='" + dataConsulta + '\'' +
                ", horaConsulta='" + horaConsulta + '\'' +
                ", utenteId=" + utenteId +
                '}';
    }
}

