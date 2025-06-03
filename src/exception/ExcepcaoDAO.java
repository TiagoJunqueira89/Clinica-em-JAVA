package exception;

/**
 *
 * @author Tiago Junqueira
 */
public class ExcepcaoDAO extends Exception {
    
    /**
     * Construtor que aceita uma mensagem de erro
     * 
     * @param mensagem Mensagem de erro
     */
    public ExcepcaoDAO(String mensagem) {
        super(mensagem);
    }

    /**
     * Construtor que aceita uma mensagem de erro e uma causa
     * 
     * @param mensagem Mensagem de erro
     * @param causa    Excepção que originou esta
     */
    public ExcepcaoDAO(String mensagem, Throwable causa) {
        super(mensagem, causa);
    }
    
}
