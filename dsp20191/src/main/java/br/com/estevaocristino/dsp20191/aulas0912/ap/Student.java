package br.com.estevaocristino.dsp20191.aulas0912.ap;

/**
 * Created by aluno on 27/03/19.
 */
public class Student {

    private Long matricula;

    private String firstname;

    private String lastname;

    private String nickname;

    private Frequencia frequencia;

    public Student() {
    }

    public Student(Long matricula, String firstname, String lastname, String nickname, Frequencia frequencia) {
        this.matricula = matricula;
        this.firstname = firstname;
        this.lastname = lastname;
        this.nickname = nickname;
        this.frequencia = frequencia;
    }

    public Long getMatricula() {
        return matricula;
    }

    public void setMatricula(Long matricula) {
        this.matricula = matricula;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public Frequencia getFrequencia() {
        return frequencia;
    }

    public void setFrequencia(Frequencia frequencia) {
        this.frequencia = frequencia;
    }
}
