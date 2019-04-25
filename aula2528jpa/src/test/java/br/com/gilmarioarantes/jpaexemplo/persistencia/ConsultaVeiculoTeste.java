package br.com.gilmarioarantes.jpaexemplo.persistencia;

import br.ufg.estevao.aula2528jpa.model.Veiculo;
import br.ufg.estevao.aula2528jpa.persistencia.VeiculoRepository;
import br.ufg.estevao.aula2528jpa.persistencia.VeiculoRepositoryImp;
import org.apache.log4j.Logger;
import org.h2.tools.Server;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.sql.SQLException;

public class ConsultaVeiculoTeste {

    Logger logger = Logger.getLogger(ConsultaVeiculoTeste.class.getName());

    VeiculoRepository repository;

    Server server;

    @BeforeTest
    public void setup() throws SQLException {
        server = Server.createTcpServer().start();
        repository = new VeiculoRepositoryImp();
    }

    @Test
    public void consultaPeloIdTeste(){
        Veiculo veiculo = repository.read(1L);
        System.out.println("Marca: " + veiculo.getMarca() + "\n" +
                "Modelo: " + veiculo.getModelo() + "\n" +
                "Ano de Fabricação: " + veiculo.getAnoFabricacao() + "\n" +
                "Ano do Modelo: " + veiculo.getAnoModelo() + "\n" +
                "Potência do Motor: " + veiculo.getPotenciaMotor() + "\n");
        Assert.assertTrue(veiculo != null);
    }


}
