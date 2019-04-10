package br.com.estevaocristino.dsp20191.aulas1316.ap.persistencia.dml.insert;

import br.com.estevaocristino.dsp20191.aulas1316.ap.model.Departamento;
import br.com.estevaocristino.dsp20191.aulas1316.ap.persistencia.base.PersistenciaJdbc;

/**
 * Created by aluno on 09/04/19.
 */
public class PersisteDepartamento extends PersistenciaJdbc {

    private Departamento departamento;

    public PersisteDepartamento(){
        departamento = new Departamento();
    }

    public boolean persisteCargo(Departamento departamento) throws Exception{

        preparaPersistencia();

        String sql = "INSERT INTO DEPARTAMENTO " +
                "VALUES('" + departamento.getId() +
                "','" + departamento.getNome() +
                "')";

        stmt.executeUpdate(sql);
        System.out.println("O Departamento foi persistido corretamente!");
        stmt.close();
        connection.close();

        return true;
    }
}
