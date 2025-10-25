package service;

import model.Cliente;
import utils.CadastrosUtils;

import java.util.List;

/**
 * Classe responsável pela gestão de clientes.
 * <p>
 * Mantém uma lista de clientes carregada a partir dos dados persistidos
 * e fornece métodos para acessar e adicionar novos clientes.
 */
public class GestaoDeClientes {

    /**
     * Lista de clientes atualmente cadastrados no sistema.
     */
    private List<Cliente> clientes;

    /**
     * Construtor que inicializa a lista de clientes
     * carregando os dados existentes através da classe CadastrosUtils.
     */
    public GestaoDeClientes() {
        this.clientes = CadastrosUtils.carregarDados();
    }

    /**
     * Retorna a lista de clientes cadastrados.
     *
     * @return lista de clientes
     */
    public List<Cliente> getClientes() {
        return clientes;
    }

    /**
     * Adiciona um novo cliente à lista e exibe informações de confirmação.
     *
     * @param novoCliente objeto Cliente a ser adicionado
     */
    public void adicionarCliente(Cliente novoCliente) {
        clientes.add(novoCliente);
        System.out.println("\nCadastro salvo!");
        System.out.println("\n" + novoCliente);
    }

}
