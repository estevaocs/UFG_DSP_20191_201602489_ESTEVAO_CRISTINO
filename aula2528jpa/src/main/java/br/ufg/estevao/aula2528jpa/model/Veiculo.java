package br.ufg.estevao.aula2528jpa.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.io.Serializable;

@Entity
public class Veiculo implements Serializable {

    @Id
    @GeneratedValue
    private Long id;
    private String marca;
    private String modelo;
    private Integer anoFabricacao;
    private Integer anoModelo;
    private Integer potenciaMotor;

    public Veiculo() {

    }

    public Veiculo(String marca, String modelo, Integer anoFabricacao, Integer anoModelo, Integer potenciaMotor) {
        this.marca = marca;
        this.modelo = modelo;
        this.anoFabricacao = anoFabricacao;
        this.anoModelo = anoModelo;
        this.potenciaMotor = potenciaMotor;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public Integer getAnoFabricacao() {
        return anoFabricacao;
    }

    public void setAnoFabricacao(Integer anoFabricacao) {
        this.anoFabricacao = anoFabricacao;
    }

    public Integer getAnoModelo() {
        return anoModelo;
    }

    public void setAnoModelo(Integer anoModelo) {
        this.anoModelo = anoModelo;
    }

    public Integer getPotenciaMotor() {
        return potenciaMotor;
    }

    public void setPotenciaMotor(Integer potenciaMotor) {
        this.potenciaMotor = potenciaMotor;
    }

}
