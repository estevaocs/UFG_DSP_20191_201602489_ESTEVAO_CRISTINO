package br.com.estevaocristino.dsp20191.aulas1316.ap.persistencia.ddl.criacao;


import br.com.estevaocristino.dsp20191.aulas1316.ap.persistencia.base.PersistenciaJdbc;

public class TableDepartamentoCreate extends PersistenciaJdbc {

    public boolean criaTabela() throws Exception {

        preparaPersistencia();

        System.out.println("Criando a tabela Departamento");

        String sql = "CREATE TABLE IF NOT EXISTS DEPARTAMENTO(\n" +
                "ID LONG NOT NULL PRIMARY KEY,\n" +
                "NOME VARCHAR(100) NOT NULL\n" +
                ")";

        stmt.executeUpdate(sql);

        System.out.println("Tabela Departamento criada com sucesso!");

        //STEP 4: Clean-up environment
        stmt.close();
        connection.close();
        return true;
    }

}
