package br.com.estevaocristino.dsp20191.aulas0912.ap;

import java.io.File;
import java.util.List;


import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.Node;
import org.dom4j.io.SAXReader;

public class lerXML {

    private static final Long MATRICULA = 201602489L;

    public static void main(String[] args) {

        try {
            File inputFile = new File("src/main/resources/students.xml");
            SAXReader reader = new SAXReader();
            Document document = reader.read( inputFile );

            Element classElement = document.getRootElement();

            List<Node> nodes = document.selectNodes("/class/student" );

            for (Node node : nodes) {
                if (node.selectSingleNode("matricula").getText().equals(MATRICULA.toString())) {
                    System.out.println("Matrícula : "
                            + node.selectSingleNode("matricula").getText());
                    System.out.println("Nome : "
                            + node.selectSingleNode("firstname").getText());
                    System.out.println("Sobrenome : "
                            + node.selectSingleNode("lastname").getText());
                    System.out.println("First Name : "
                            + node.selectSingleNode("nickname").getText());
                    System.out.println("Frequencia : ");
                    System.out.println("\tAula: " + node.selec"nickname").getText());
                }

            }
        } catch (DocumentException e) {
            e.printStackTrace();
        }
    }
}
