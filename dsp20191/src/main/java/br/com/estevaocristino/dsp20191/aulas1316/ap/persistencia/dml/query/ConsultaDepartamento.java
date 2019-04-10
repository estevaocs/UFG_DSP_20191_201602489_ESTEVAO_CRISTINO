package br.com.estevaocristino.dsp20191.aulas1316.ap.persistencia.dml.query;

import br.com.estevaocristino.dsp20191.aulas1316.ap.model.Departamento;
import br.com.estevaocristino.dsp20191.aulas1316.ap.persistencia.base.PersistenciaJdbc;

import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class ConsultaDepartamento extends PersistenciaJdbc {

    private Departamento departamento;

    public ConsultaDepartamento(){
        departamento = new Departamento();
    }

    public Departamento consultaPorId(Long id) throws Exception{

        preparaPersistencia();

        String sql = "SELECT * FROM DEPARTAMENTO WHERE ID= ?";
        PreparedStatement pstmt = connection.prepareStatement(sql);
        pstmt.setLong(1,id);

        ResultSet rs = pstmt.executeQuery(  );
        while(rs.next()){
            departamento.setId(rs.getLong("ID"));
            departamento.setNome(rs.getString("NOME"));

        }

        rs.close();
        pstmt.close();
        stmt.close();
        connection.close();
        return departamento;
    }
}
