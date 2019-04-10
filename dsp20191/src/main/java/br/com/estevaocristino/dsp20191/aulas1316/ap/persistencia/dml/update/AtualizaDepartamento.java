package br.com.estevaocristino.dsp20191.aulas1316.ap.persistencia.dml.update;

import br.com.estevaocristino.dsp20191.aulas1316.ap.model.Cargo;
import br.com.estevaocristino.dsp20191.aulas1316.ap.model.Departamento;
import br.com.estevaocristino.dsp20191.aulas1316.ap.persistencia.base.PersistenciaJdbc;
import br.com.estevaocristino.dsp20191.aulas1316.ap.persistencia.dml.query.ConsultaCargo;
import br.com.estevaocristino.dsp20191.aulas1316.ap.persistencia.dml.query.ConsultaDepartamento;

import java.sql.PreparedStatement;

public class AtualizaDepartamento extends PersistenciaJdbc{

    public boolean atualizaDepartamento(Departamento departamento) throws Exception {

        boolean result = false;

        try {
            Departamento departamento1 = new ConsultaDepartamento().consultaPorId(departamento.getId());
            if (departamento1.getId() != null) {
                preparaPersistencia();

                String sql = "UPDATE CARGO " +
                        "SET NOME = '" + departamento.getNome() +
                        "' WHERE ID = ?";
                PreparedStatement pstmt = connection.prepareStatement(sql);
                pstmt.setLong(1, departamento.getId());
                pstmt.executeUpdate();
                result = true;
                System.out.println("O Departamento foi atualizado corretamente!");
            } else {
                System.out.println("Não foi localizado o departamento com o id = " + departamento.getId());
            }
        }catch (Exception e){
            e.printStackTrace();
        }

        return result;
    }
}
