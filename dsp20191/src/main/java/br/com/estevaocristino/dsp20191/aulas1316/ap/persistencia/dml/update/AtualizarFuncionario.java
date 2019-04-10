package br.com.estevaocristino.dsp20191.aulas1316.ap.persistencia.dml.update;

import br.com.estevaocristino.dsp20191.aulas1316.ap.model.Cargo;
import br.com.estevaocristino.dsp20191.aulas1316.ap.model.Departamento;
import br.com.estevaocristino.dsp20191.aulas1316.ap.model.Funcionario;
import br.com.estevaocristino.dsp20191.aulas1316.ap.persistencia.base.PersistenciaJdbc;
import br.com.estevaocristino.dsp20191.aulas1316.ap.persistencia.dml.query.ConsultaCargo;
import br.com.estevaocristino.dsp20191.aulas1316.ap.persistencia.dml.query.ConsultaFuncionario;

import java.sql.PreparedStatement;

public class AtualizarFuncionario extends PersistenciaJdbc{

    public boolean atualizaFuncionario(Funcionario funcionario) throws Exception {

        boolean result = false;

        try {
            Funcionario funcionario1 = new ConsultaFuncionario().consultaPorId(funcionario.getId());
            if (funcionario1.getId() != null) {
                preparaPersistencia();

                String sql = "UPDATE CARGO " +
                        "SET NOME = '" + funcionario.getNome() +
                        "', MATRICULA = '" + funcionario.getMatricula() +
                        "' WHERE ID = ?";
                PreparedStatement pstmt = connection.prepareStatement(sql);
                pstmt.setLong(1, funcionario.getId());
                pstmt.executeUpdate();
                result = true;
                System.out.println("O Funcionario foi atualizado corretamente!");
            } else {
                System.out.println("Não foi localizado o funcionario com o id = " + funcionario.getId());
            }
        }catch (Exception e){
            e.printStackTrace();
        }

        return result;
    }
}
