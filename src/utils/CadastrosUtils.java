package utils;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import model.Cliente;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

/**
 * Classe utilitária responsável por persistir e carregar os dados dos clientes.
 * <p>
 * Utiliza arquivos JSON para armazenar a lista de clientes e recuperar dados previamente salvos.
 */
public class CadastrosUtils {

    /**
     * Caminho do arquivo JSON onde os dados dos clientes serão armazenados.
     */
    private static final String NOME_DO_ARQUIVO = "data/Clientes.json";

    /**
     * Salva a lista de clientes no arquivo JSON especificado.
     * Caso a pasta "data" não exista, ela será criada.
     *
     * @param clientes lista de clientes a ser salva
     */
    public static void salvarDados(List<Cliente> clientes) {

        File pasta = new File("data");
        if (!pasta.exists()) {
            pasta.mkdirs();
        }

        Gson gson = new GsonBuilder()
                .setPrettyPrinting()
                .create();

        String json = gson.toJson(clientes);

        try {
            FileWriter arquivo = new FileWriter(NOME_DO_ARQUIVO);
            arquivo.write(json);
            arquivo.close();
            System.out.println("\nDados salvos em " + NOME_DO_ARQUIVO);
        } catch (IOException e) {
            System.out.println("\nErro ao salvar os dados " + e.getMessage());
        }

    }

    /**
     * Carrega a lista de clientes a partir do arquivo JSON.
     * <p>
     * Caso o arquivo não exista ou esteja vazio, retorna uma lista vazia.
     *
     * @return lista de clientes carregada do arquivo
     */
    public static List<Cliente> carregarDados() {
        try {
            FileReader leitor = new FileReader(NOME_DO_ARQUIVO);
            Type tipoDaLista = new TypeToken<List<Cliente>>() {
            }.getType();

            Gson gson = new Gson();

            List<Cliente> clientes = gson.fromJson(leitor, tipoDaLista);

            if (clientes == null) {
                return new ArrayList<>();
            }

            System.out.println("\nDados antigos carregados ao disco!");
            return clientes;
        } catch (Exception e) {
            System.out.println("\nArquivo " + NOME_DO_ARQUIVO + " não localizado!");
            return new ArrayList<>();
        }

    }

}
