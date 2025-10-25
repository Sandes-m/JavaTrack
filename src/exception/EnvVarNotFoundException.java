package exception;

/**
 * Exceção personalizada lançada quando uma variável de ambiente esperada não é encontrada.
 * <p>
 * Extende RuntimeException, permitindo que seja lançada durante a execução do programa.
 */
public class EnvVarNotFoundException extends RuntimeException {

    /**
     * Construtor da exceção.
     *
     * @param message Mensagem detalhando a causa da exceção
     */
    public EnvVarNotFoundException(String message) {
        super(message);

    }

}
