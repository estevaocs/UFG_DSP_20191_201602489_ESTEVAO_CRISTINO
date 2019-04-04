package br.com.estevaocristino.dsp20191.aulas1316.ap.persistencia.ddl.exclusao;


import br.com.estevaocristino.dsp20191.aulas1316.ap.persistencia.base.PersistenciaJdbc;

public class TableDepartamentoDrop extends PersistenciaJdbc {

    public boolean excluiTabela() throws Exception{

        preparaPersistencia();

        System.out.println("Excluindo a tabela Departamento");

        String sql = "DROP TABLE IF EXISTS DEPARTAMENTO";

        stmt.executeUpdate(sql);

        System.out.println("Tabela Departamento excluida com sucesso!");

        //STEP 4: Clean-up environment
        stmt.close();
        connection.close();
        return true;
    }

}
