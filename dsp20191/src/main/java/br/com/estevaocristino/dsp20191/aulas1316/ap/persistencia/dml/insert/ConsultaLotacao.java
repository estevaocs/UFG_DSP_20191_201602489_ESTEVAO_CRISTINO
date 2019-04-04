package br.com.estevaocristino.dsp20191.aulas1316.ap.persistencia.dml.insert;


import br.com.estevaocristino.dsp20191.aulas1316.ap.model.Lotacao;
import br.com.estevaocristino.dsp20191.aulas1316.ap.persistencia.base.PersistenciaJdbc;

import java.security.interfaces.RSAKey;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class ConsultaLotacao extends PersistenciaJdbc {

    private Lotacao lotacao;

    public ConsultaLotacao(){
        lotacao = new Lotacao();
    }

    public Lotacao consultaPorId(Long id) throws Exception{

        preparaPersistencia();

        String sql = "SELECT * FROM LOTACAO WHERE ID= ?";
        PreparedStatement pstmt = connection.prepareStatement(sql);
        pstmt.setLong(1,id);

        ResultSet rs = pstmt.executeQuery(  );
        while(rs.next()){
            lotacao.setId(rs.getLong("ID"));
            lotacao.setDataInicial(rs.getDate("DATA_INICIAL"));
            lotacao.setDataFinal(rs.getDate("DATA_FINAL"));
            lotacao.getCargo().setId(rs.getLong("CARGO"));
            lotacao.getDepartamento().setId(rs.getLong("DEPARTAMENTO"));
        }

        rs.close();
        pstmt.close();
        stmt.close();
        connection.close();
        return lotacao;
    }
}
