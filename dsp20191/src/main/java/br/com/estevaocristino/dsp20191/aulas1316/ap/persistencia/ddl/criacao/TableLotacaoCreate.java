package br.com.estevaocristino.dsp20191.aulas1316.ap.persistencia.ddl.criacao;


import br.com.estevaocristino.dsp20191.aulas1316.ap.persistencia.base.PersistenciaJdbc;

public class TableLotacaoCreate extends PersistenciaJdbc {

    public boolean criaTabela() throws Exception {

        preparaPersistencia();

        System.out.println("Criando a tabela Lotação");

        String sql = "CREATE TABLE IF NOT EXISTS LOTACAO(\n" +
                "ID LONG NOT NULL PRIMARY KEY,\n" +
                "DATA_INICIAL DATE NOT NULL," +
                "DATA_FINAL DATE" +
                "DEPARTAMENTO LONG NOT NULL\n" +
                "CARGO LONG NOT NULL\n" +
                ")";

        stmt.executeUpdate(sql);

        System.out.println("Tabela Lotação criada com sucesso!");

        //STEP 4: Clean-up environment
        stmt.close();
        connection.close();
        return true;
    }

}