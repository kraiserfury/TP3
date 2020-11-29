package TestedePerformance3;

public class Professor extends Pessoa{
    String classroom;
    int turma;

    public Professor(String name, String classroom, int turma) {
        super(name);
        this.classroom = classroom;
        this.turma = turma;
    }

    public Professor(String classroom, int turma) {
        this.classroom = classroom;
        this.turma = turma;
    }

    public Professor() {}

    public String getClassroom() {
        return classroom;
    }

    public void setClassroom(String classroom) {
        this.classroom = classroom;
    }

    public int getTurma() {
        return turma;
    }

    public void setTurma(int turma) {
        this.turma = turma;
    }

    public void consultarSituacao(){
        super.consultarSituacao();
        System.out.println( "Sala: " + classroom + "\n" +
                            "Turma: " + turma);

    }
}