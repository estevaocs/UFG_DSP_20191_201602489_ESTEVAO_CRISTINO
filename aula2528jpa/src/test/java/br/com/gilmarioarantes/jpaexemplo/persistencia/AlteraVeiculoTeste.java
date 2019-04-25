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

public class AlteraVeiculoTeste {

    Logger logger = Logger.getLogger(AlteraVeiculoTeste.class.getName());

    Server server = null;
    VeiculoRepository repository = null;

    @BeforeTest
    public void setup() throws SQLException {
        server = Server.createTcpServer().start();
        repository = new VeiculoRepositoryImp();
    }

    @Test
    public void alteraNomeTeste(){
        Veiculo veiculo = repository.read(1L);
        if(veiculo == null){
            veiculo = new Veiculo("Volkswagen", "Palio", 2017, 2018, 75);
            veiculo =  repository.create(veiculo);
        }
        veiculo.setMarca("Fiat");
        veiculo.setAnoFabricacao(2018);
        //update person record
        repository.update(veiculo);

        veiculo = repository.read(veiculo.getId());

        System.out.println("id: " + veiculo.getId() + "\n" +
                "Marca: " + veiculo.getMarca() + "\n" +
                "Modelo: " + veiculo.getModelo() + "\n" +
                "Ano de Fabricação: " + veiculo.getAnoFabricacao() + "\n" +
                "Ano do Modelo: " + veiculo.getAnoModelo() + "\n" +
                "Potência do Motor: " + veiculo.getPotenciaMotor() + "\n");

        Assert.assertTrue(veiculo.getMarca().equals("Fiat"));
    }



}
