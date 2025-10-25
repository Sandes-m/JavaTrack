package utils;

import com.google.i18n.phonenumbers.NumberParseException;
import service.NationalityService;

import java.util.Scanner;

/**
 * Classe utilitária responsável por interações com o console.
 * <p>
 * Fornece métodos para solicitar e validar entradas do usuário,
 * como CPF, nome, e-mail, telefone e outros dados de cadastro.
 * Também contém validações básicas e tratamento para cancelamento de operação.
 */
public class ConsoleUtils {

    /**
     * Serviço usado para verificar a nacionalidade de números de telefone.
     */
    private static final NationalityService verificarNacionalidade = new NationalityService();

    /**
     * Scanner usado para capturar entradas do usuário no console.
     */
    private static final Scanner entrada = new Scanner(System.in);

    /**
     * Remove caracteres especiais de uma string, como barras, pontos, parênteses e traços.
     *
     * @param texto texto de entrada
     * @return texto limpo sem caracteres especiais
     */
    public static String limparCaracteres(String texto) {
        return texto.replaceAll("[/().,-]", "");
    }

    /**
     * Exibe uma mensagem no console e captura a resposta do usuário.
     *
     * @param mensagem texto exibido ao usuário
     * @return resposta digitada
     */
    public static String solicitarEntrada(String mensagem) {
        System.out.println(mensagem);
        return entrada.nextLine();
    }

    /**
     * Verifica se o usuário digitou "exit" para cancelar o cadastro.
     * Caso positivo, o sistema encerra a execução.
     *
     * @param entradaUsuario texto digitado pelo usuário
     */
    public static void verificarCancelamento(String entradaUsuario) {
        if (entradaUsuario.toLowerCase().equalsIgnoreCase("exit")) {
            System.out.println("\nCadastro cancelado pelo usuário.");
            System.exit(0);
        }
    }

    /**
     * Solicita o CPF do usuário e valida se contém 11 dígitos.
     *
     * @return CPF válido contendo 11 números
     */
    public static String solicitarCpf() {
        String cpf;
        while (true) {
            cpf = solicitarEntrada("CPF (Apenas números)")
                    .replaceAll("[^0-9]", "");

            if (cpf.length() == 11) {
                return cpf;
            }

            System.out.println("\nAVISO: O CPF deve conter 11 dígitos!");
        }
    }

    /**
     * Solicita o nome do usuário, garantindo que não contenha números e possua ao menos 3 letras.
     *
     * @return nome válido
     */
    public static String solicitarNome() {
        String nome;
        while (true) {
            nome = solicitarEntrada("Nome");

            if (nome.matches(".*[0-9].*")) {
                System.out.println("\nAVISO: O nome não pode conter números!");
                continue;
            }

            if (nome.trim().length() > 3) {
                return nome;
            }

            System.out.println("\nAVISO: O nome deve ter pelo menos 3 letras!");
        }
    }

    /**
     * Solicita um endereço de e-mail e valida se contém "@" e domínio válido.
     *
     * @return e-mail válido
     */
    public static String solicitarEmail() {
        String email;

        while (true) {
            email = solicitarEntrada("E-mail");

            if (email.contains("@") && email.contains(".com") || email.contains(".com.br")) {
                return email;
            }

            System.out.println("\nAVISO: Digite um E-mail válido (example@host.com)");
        }
    }

    /**
     * Solicita o telefone do usuário e verifica se é um número brasileiro.
     *
     * @return número de telefone válido
     */
    public static String solicitarTelefone() {
        String telefone;

        while (true) {
            telefone = solicitarEntrada("Contato (Celular)")
                    .replaceAll("[^0-9]", "");

            if (!telefone.startsWith("+")) {
                telefone = "+" + telefone;
            }

            try {
                if (!verificarNacionalidade.isForeignNumber(telefone)) {
                    return telefone;
                }

                System.out.println("\nAVISO: Sistema comporta apenas número brasileiros. Transferindo atendimento via e-mail.");
                System.exit(0);


            } catch (NumberParseException e) {
                System.out.println("\nAVISO: Informe o número com o código do país e DDD (ex: +5511955550000)");
            }

        }
    }

    /**
     * Solicita a data de nascimento no formato DD/MM/AAAA e garante que contenha 8 dígitos.
     *
     * @return data de nascimento válida
     */
    public static String solicitarDataNascimento() {
        String data;

        while (true) {
            data = solicitarEntrada("Data de Nascimento (DD/MM/AAAA)")
                    .replaceAll("[^0-9]", "");

            if (data.length() == 8) {
                return data;
            }

            System.out.println("\nAVISO: A data deve conter apenas números!");
        }
    }

    /**
     * Solicita um e-mail de recuperação opcional.
     * Caso o campo fique vazio, retorna uma string vazia.
     *
     * @return e-mail de recuperação ou string vazia
     */
    public static String emailOpcional() {
        String emailRec;

        while (true) {
            emailRec = solicitarEntrada("Email de Recuperação (Opcional)");

            if (emailRec.isEmpty()) {
                return "";
            }

            if (emailRec.contains("@")) {
                return emailRec;
            }

            System.out.println("\nAVISO: Digite um E-mail válido (example@host.com)");
        }
    }

    /**
     * Solicita o número residencial, garantindo que seja numérico e tenha até 10 dígitos.
     *
     * @return número residencial válido
     */
    public static String solicitarNumero() {
        String numero;

        while (true) {
            numero = solicitarEntrada("\nNúmero Residêncial")
                    .replaceAll("[^0-9]", "");

            if (numero.isEmpty()) {
                System.out.println("\nAVISO: O número não pode ser deixado em branco e não pode conter letras!");
                continue;
            }

            if (numero.length() <= 10) {
                return numero;
            }

            System.out.println("\nAVISO: Digite um número de residência válido!");
        }
    }

    /**
     * Solicita o complemento residencial (opcional).
     * Caso vazio, retorna uma string vazia.
     *
     * @return complemento ou string vazia
     */
    public static String solicitarComplemento() {
        String complemento;

        while (true) {
            complemento = solicitarEntrada("\nComplemento (Opcional)");

            if (complemento.isEmpty()) {
                return "";
            }

            if (!complemento.trim().isEmpty()) {
                return complemento;
            }
        }
    }

    /**
     * Fecha o Scanner utilizado nas leituras de entrada.
     * Deve ser chamado ao final do programa para liberar recursos.
     */
    public static void fecharScanner() {
        entrada.close();
    }

}
