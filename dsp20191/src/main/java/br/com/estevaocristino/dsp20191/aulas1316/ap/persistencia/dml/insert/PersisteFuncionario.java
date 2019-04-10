package br.com.estevaocristino.dsp20191.aulas1316.ap.persistencia.dml.insert;

import br.com.estevaocristino.dsp20191.aulas1316.ap.model.Funcionario;
import br.com.estevaocristino.dsp20191.aulas1316.ap.persistencia.base.PersistenciaJdbc;

/**
 * Created by aluno on 09/04/19.
 */
public class PersisteFuncionario extends PersistenciaJdbc {

    private Funcionario funcionario;

    public PersisteFuncionario(){
        funcionario = new Funcionario();
    }

    public boolean persisteFuncionario(Funcionario funcionario) throws Exception{

        preparaPersistencia();

        String sql = "INSERT INTO FUNCIONARIO " +
                "VALUES('" + funcionario.getId() +
                "','" + funcionario.getNome() +
                "','" + funcionario.getMatricula() +
                "')";

        stmt.executeUpdate(sql);
        System.out.println("O Funcionario foi persistido corretamente!");
        stmt.close();
        connection.close();

        return true;
    }
}
