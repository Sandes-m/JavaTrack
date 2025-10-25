package service;

import model.Cliente;
import model.Endereco;
import utils.CadastrosUtils;
import utils.ConsoleUtils;

import static utils.ConsoleUtils.*;
import static utils.ConsoleUtils.emailOpcional;
import static utils.ConsoleUtils.limparCaracteres;
import static utils.ConsoleUtils.solicitarComplemento;
import static utils.ConsoleUtils.solicitarDataNascimento;
import static utils.ConsoleUtils.solicitarEmail;
import static utils.ConsoleUtils.solicitarEntrada;
import static utils.ConsoleUtils.solicitarNumero;
import static utils.ConsoleUtils.verificarCancelamento;

/**
 * Classe responsável pelo menu principal do sistema de cadastro de clientes.
 * <p>
 * Controla o fluxo de execução do programa, permitindo criar cadastros,
 * encerrar o sistema e persistir os dados dos clientes.
 */
public class Menu {

    /**
     * Executa o menu principal do sistema.
     * Exibe as opções disponíveis ao utilizador e direciona para o fluxo de cadastro ou encerramento do sistema.
     */
    public static void executar() {
        GestaoDeClientes gestao = new GestaoDeClientes();

        String opcao;

        while (true) {
            System.out.println("\nPAINEL DE CADASTRO");
            System.out.println("\nDigite (1) para realizar um novo cadastro");
            System.out.println("Digite (0) para encerrar");
            opcao = solicitarEntrada("");

            if (opcao.equalsIgnoreCase("1")) {
                System.out.println("\nPor favor, preecha os demais campos para prosseguir!");
                executarCadastro(gestao);
            } else if (opcao.equalsIgnoreCase("0")) {
                CadastrosUtils.salvarDados(gestao.getClientes());
                ConsoleUtils.fecharScanner();
                System.out.println("\nEncerrando o sistema. Dados salvos automáticamente!");
                return;
            } else {
                System.out.println("Opção inválida, selecione (0) para encerrar ou (1) para prosseguir!");
            }
        }
    }

    /**
     * Executa o processo de cadastro de um novo cliente.
     * <p>
     * Solicita todos os dados do cliente, realiza validações, busca o endereço via API a partir do CEP,
     * permite tentar novamente caso o CEP não seja localizado e adiciona o cliente à gestão de clientes.
     *
     * @param gestao instância da gestão de clientes responsável por armazenar os cadastros
     */
    private static void executarCadastro(GestaoDeClientes gestao) {

        int tentativas = 0;

        // Solicitação de dados básicos do cliente
        String nome = solicitarNome();
        String email = solicitarEmail();
        String telefone = solicitarTelefone();
        String cpf = solicitarCpf();
        String dataDeNascimento = solicitarDataNascimento();
        String emailRecuperacao = emailOpcional();

        // Solicitação do CEP e verificação de cancelamento
        String cep = limparCaracteres(solicitarEntrada("Informe seu CEP (ou digite 'EXIT' para sair)"));
        verificarCancelamento(cep);

        ViaCEPService localizar = new ViaCEPService();
        Endereco buscaDeEndereco = localizar.buscarEndereco(cep);

        // Loop para CEP inválido, permitindo 3 tentativas
        while (buscaDeEndereco == null && tentativas < 3) {
            cep = limparCaracteres(solicitarEntrada("\nPor favor, informe o CEP novamente (ou digite 'EXIT' para sair)"));
            verificarCancelamento(cep);
            buscaDeEndereco = localizar.buscarEndereco(cep);
            tentativas++;

            if (tentativas == 3) {
                System.out.println("O CEP informado não foi localizado, por favor, insira um novo CEP");
                cep = limparCaracteres(solicitarEntrada("\nInforme seu CEP (ou digite 'EXIT' para sair)"));
                verificarCancelamento(cep);
                buscaDeEndereco = localizar.buscarEndereco(cep);
                tentativas = 0;
                tentativas++;
            }
        }

        if (buscaDeEndereco != null) {
            System.out.println("\nEndereço encontrado! Informe o Número e Complemento");
        }

        // Solicitação de número e complemento do endereço
        String numero = solicitarNumero();
        String complemento = solicitarComplemento();


        buscaDeEndereco.setNumero(numero); // Atualiza número no endereço
        buscaDeEndereco.setComplemento(complemento); // Atualiza complemento no endereço

        // Cria objeto Cliente com todos os dados coletados
        Cliente novoCliente = new Cliente(nome, cpf, telefone, dataDeNascimento, email, buscaDeEndereco);

        // Adiciona o cliente à lista de clientes gerenciada
        gestao.adicionarCliente(novoCliente);
    }
}
