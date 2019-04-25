package br.ufg.estevao.aula2528jpa.persistencia;

import br.ufg.estevao.aula2528jpa.model.Veiculo;

import java.util.List;

public interface VeiculoRepository {

    Veiculo create(Veiculo veiculo);

    Veiculo read(Long id);

    List<Veiculo> findByMarca(String marca);

    List<Veiculo> findByModelo(String modelo);

    List<Veiculo> findByAnoFabricacao(Integer anoFabricacao);

    List<Veiculo> findByAnoModelo(Integer anoModelo);

    Veiculo update(Veiculo veiculo);

    void delete(Veiculo veiculo);

    void close();
}
