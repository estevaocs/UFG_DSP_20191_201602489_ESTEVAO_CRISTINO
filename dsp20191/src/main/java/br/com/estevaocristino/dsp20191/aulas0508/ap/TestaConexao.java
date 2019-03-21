package br.com.estevaocristino.dsp20191.aulas0508.ap;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * Created by aluno on 20/03/19.
 */
public class TestaConexao {

    static Usuario usuario = new Usuario();

    static Conexao conexao = new Conexao();

    public static Properties getProp() throws IOException {
        Properties props = new Properties();
        FileInputStream file = new FileInputStream("src/main/resources/conexao.properties");
        props.load(file);
        return props;

    }

    public static void  main(String args[]) throws IOException {

        String nome; //Variavel que guardará o nome do usuário.
        String login; //Variavel que guardará o login do usuário.
        String senha; //Variável que guardará o password do usúario.
        String sgbd; //Variável que guardará o sistema sgbd.
        String tipoConexao; //Variável que guardará o tipo de conexão utilizada.
        String bancoDados; //Variável que guardará o banco de dados que será usado.
        String urlBd; //Variável que guardará o url de endereço do banco de dados.
        String sistemaOperacional;//Variável que guardará o nome do Sistema Operacional.

        Properties prop = getProp();

        //Lendo Propriedades
        nome = prop.getProperty("nome");
        login = prop.getProperty("usuario");
        senha = prop.getProperty("senha");
        sgbd = prop.getProperty("sgbd");
        tipoConexao = prop.getProperty("tipoConexao");
        bancoDados = prop.getProperty("bancoDados");
        urlBd = prop.getProperty("urlBd");

        //Pegando o nome do sistema operacional
        sistemaOperacional = System.getProperty("os.name").toLowerCase();


        //Setando Usuário
        usuario.setNome(nome);
        usuario.setLogin(login);
        usuario.setSenha(senha);

        //Setando Conexão
        conexao.setSgbd(sgbd);
        conexao.setTipoConexao(tipoConexao);
        conexao.setBancoDados(bancoDados);
        conexao.setUrlBd(urlBd);
        conexao.setSistemaOperacional(sistemaOperacional);

        //Imprimindo Resultado
        System.out.println("Nome = " + usuario.getNome());
        System.out.println("Login = " + usuario.getLogin());
        System.out.println("Senha = " + usuario.getSenha());
        System.out.println("SGDB = " + conexao.getSgbd());
        System.out.println("Tipo de Conexão = " + conexao.getTipoConexao());
        System.out.println("Banco de Dados = " + conexao.getBancoDados());
        System.out.println("Url de Conexão do Banco = " + conexao.getUrlBd());
        System.out.println("Sistema Operacional = " + conexao.getSistemaOperacional());
    }
}
