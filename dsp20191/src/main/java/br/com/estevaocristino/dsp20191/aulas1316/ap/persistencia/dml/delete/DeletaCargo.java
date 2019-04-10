package br.com.estevaocristino.dsp20191.aulas1316.ap.persistencia.dml.delete;

import br.com.estevaocristino.dsp20191.aulas1316.ap.model.Cargo;
import br.com.estevaocristino.dsp20191.aulas1316.ap.persistencia.base.PersistenciaJdbc;
import br.com.estevaocristino.dsp20191.aulas1316.ap.persistencia.dml.query.ConsultaCargo;

import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class DeletaCargo extends PersistenciaJdbc {

    public boolean deletaCargo(Long id) throws Exception {
        boolean result = false;
        try {
            Cargo cargo = new ConsultaCargo().consultaPorId(id);
            if (cargo.getId() != null) {
                preparaPersistencia();

                String sql = "DELETE FROM CARGO WHERE ID = ?";
                PreparedStatement pstmt = connection.prepareStatement(sql);
                pstmt.setLong(1, id);
                pstmt.executeUpdate();
                result = true;
                System.out.println("O Cargo foi excluido corretamente!");
                pstmt.close();
            } else {
                System.out.println("Não foi encontrado cargo com o id = " + id);
            }
        } catch (Exception e){
            e.printStackTrace();
        }

        return result;
    }
}
