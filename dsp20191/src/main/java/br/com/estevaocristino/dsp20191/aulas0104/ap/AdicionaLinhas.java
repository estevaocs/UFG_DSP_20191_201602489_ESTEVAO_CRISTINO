package br.com.estevaocristino.dsp20191.aulas0104.ap;

public class AdicionaLinhas {
    private static final int NUM_LINES = 5;
    
    public static void main(String[] args) {
        Arquivo novoTexto = new Arquivo();
        for(int i=0; i<NUM_LINES; i++){
            novoTexto.write("arquivo.txt", "linha " + i);
        }
    }
}
