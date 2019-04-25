package br.com.gilmarioarantes.jpaexemplo.persistencia;

import br.ufg.estevao.aula2528jpa.model.Veiculo;
import br.ufg.estevao.aula2528jpa.persistencia.VeiculoRepository;
import br.ufg.estevao.aula2528jpa.persistencia.VeiculoRepositoryImp;
import org.apache.log4j.Logger;
import org.h2.tools.Server;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.sql.SQLException;

public class DeletaPessoaTeste {

    Logger logger = Logger.getLogger(DeletaPessoaTeste.class.getName());
    Server server = null;
    VeiculoRepository repository = null;

    @BeforeTest
    public void setup() throws SQLException {
        server = Server.createTcpServer().start();
        repository = new VeiculoRepositoryImp();
    }

    @Test
    public void deletaPessoaTeste(){

        Veiculo veiculo = repository.read(1L);
        if(veiculo != null){
            repository.delete(veiculo);
        }

        // This will return null
        Veiculo novaVeiculo = repository.read(1L);

        Assert.assertTrue(novaVeiculo == null);
    }


}
