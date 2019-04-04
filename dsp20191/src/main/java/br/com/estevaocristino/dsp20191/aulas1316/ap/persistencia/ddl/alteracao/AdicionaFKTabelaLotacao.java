package br.com.estevaocristino.dsp20191.aulas1316.ap.persistencia.ddl.alteracao;

import br.com.estevaocristino.dsp20191.aulas1316.ap.persistencia.base.PersistenciaJdbc;

public class AdicionaFKTabelaLotacao extends PersistenciaJdbc {

    public boolean alteraTabela() throws Exception {

        preparaPersistencia();

        System.out.println("Alterando a Tabela Lotacao");

        String sql = "ALTER TABLE LOTACAO " +
                "ADD FOREIGN KEY (DEPARTAMENTO) REFERENCES DEPARTAMENTO(ID) ON DELETE CASCADE;\n" +
                "ADD FOREIGN KEY (CARGO) REFERENCES CARGO(ID) ON DELETE CASCADE;";

        stmt.executeUpdate(sql);

        System.out.println("Tabela Lotacao alterada com sucesso!");

        //STEP 4: Clean-up environment
        stmt.close();
        connection.close();
        return true;
    }
}
