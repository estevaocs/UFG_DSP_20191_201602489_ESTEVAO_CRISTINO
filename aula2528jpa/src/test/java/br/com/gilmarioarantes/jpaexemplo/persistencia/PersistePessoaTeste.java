package br.com.gilmarioarantes.jpaexemplo.persistencia;

import br.ufg.estevao.aula2528jpa.model.Veiculo;
import br.ufg.estevao.aula2528jpa.persistencia.VeiculoRepository;
import br.ufg.estevao.aula2528jpa.persistencia.VeiculoRepositoryImp;
import org.apache.log4j.Logger;
import org.h2.tools.Server;
import org.testng.Assert;
import org.testng.annotations.*;

import java.sql.SQLException;

public class PersistePessoaTeste {

    Logger logger = Logger.getLogger(PersistePessoaTeste.class.getName());

    Server server = null;
    VeiculoRepository repository;

    @BeforeTest
    public void setup() throws SQLException {
        server = Server.createTcpServer().start();
        repository = new VeiculoRepositoryImp();
    }

    @Test
    public void TestaPersistenciaPessoa(){
        Veiculo veiculo = new Veiculo("Volkswagen", "Gol", 2017, 2018, 82);

        // Create person
        Veiculo novaVeiculo =  repository.create(veiculo);
        System.out.println("Id do veiculo: " + novaVeiculo.getId());
        Assert.assertTrue(veiculo != null);
    }


}
