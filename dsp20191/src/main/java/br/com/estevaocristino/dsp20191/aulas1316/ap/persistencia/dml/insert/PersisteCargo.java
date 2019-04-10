package br.com.estevaocristino.dsp20191.aulas1316.ap.persistencia.dml.insert;

import br.com.estevaocristino.dsp20191.aulas1316.ap.model.Cargo;
import br.com.estevaocristino.dsp20191.aulas1316.ap.persistencia.base.PersistenciaJdbc;

import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class PersisteCargo extends PersistenciaJdbc {

    private Cargo cargo;

    public PersisteCargo(){
        cargo = new Cargo();
    }

    public Cargo consultaPorId(Long id) throws Exception{

        preparaPersistencia();

        String sql = "INSERT INTO CARGO ?";
        PreparedStatement pstmt = connection.prepareStatement(sql);
        pstmt.setLong(1,id);

        ResultSet rs = pstmt.executeQuery(  );
        while(rs.next()){
            cargo.setId(rs.getLong("ID"));
            cargo.setNome(rs.getString("NOME"));
            cargo.setSalario(rs.getDouble("SALARIO"));

        }

        rs.close();
        pstmt.close();
        stmt.close();
        connection.close();
        return cargo;
    }
}
