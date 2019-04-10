package br.com.estevaocristino.dsp20191.aulas1316.ap.persistencia.dml.update;

import br.com.estevaocristino.dsp20191.aulas1316.ap.model.Funcionario;
import br.com.estevaocristino.dsp20191.aulas1316.ap.model.Lotacao;
import br.com.estevaocristino.dsp20191.aulas1316.ap.persistencia.base.PersistenciaJdbc;
import br.com.estevaocristino.dsp20191.aulas1316.ap.persistencia.dml.query.ConsultaFuncionario;
import br.com.estevaocristino.dsp20191.aulas1316.ap.persistencia.dml.query.ConsultaLotacao;

import java.sql.PreparedStatement;

public class AtualizarLotacao extends PersistenciaJdbc{

    public boolean atualizaLotacao(Lotacao lotacao) throws Exception {

        boolean result = false;

        try {
            Lotacao lotacao1 = new ConsultaLotacao().consultaPorId(lotacao.getId());
            if (lotacao1.getId() != null) {
                preparaPersistencia();

                String sql = "UPDATE CARGO " +
                        "SET DATA_INICIAL = '" + lotacao.getDataInicial() +
                        "', DATA_FINAL = '" + lotacao.getDataFinal() +
                        "', DEPARTAMENTO = ?" +
                        ", CARGO = ?" +
                        " WHERE ID = ?";
                PreparedStatement pstmt = connection.prepareStatement(sql);
                pstmt.setLong(1, lotacao.getDepartamento().getId());
                pstmt.setLong(2, lotacao.getCargo().getId());
                pstmt.setLong(3, lotacao.getId());
                pstmt.executeUpdate();
                result = true;
                System.out.println("O Lotacao foi atualizado corretamente!");
            } else {
                System.out.println("Não foi localizado o lotacao com o id = " + lotacao.getId());
            }
        }catch (Exception e){
            e.printStackTrace();
        }

        return result;
    }
}
