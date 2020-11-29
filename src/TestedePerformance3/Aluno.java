package TestedePerformance3;

public class Aluno extends Pessoa {
    float AV1, AV2;
    private float media;
    private String status;

    public Aluno(String name, float AV1, float AV2) {
        super(name);
        this.AV1 = AV1;
        this.AV2 = AV2;
    }

    public Aluno(float AV1, float AV2) {
        this.AV1 = AV1;
        this.AV2 = AV2;
    }

    public Aluno() {}

    public float getAV1() {
        return AV1;
    }

    public void setAV1(float AV1) {
        this.AV1 = AV1;
    }

    public float getAV2() {
        return AV2;
    }

    public void setAV2(float AV2) {
        this.AV2 = AV2;
    }

    public String getStatus() {
        return status;
    }

    public float getMedia() {
        return media;
    }

    private void CalcMedia(){
        media = (AV1 + AV2)/2;
        if(media < 4){
            status = "Reprovado";
        }else if(media < 7){
            status = "Prova final";
        }else{
            status = "Aprovado";
        }
    }

    public void consultarSituacao(){
        CalcMedia();
        super.consultarSituacao();
        System.out.println( "Media: " + media + "\n" +
                            "AV1: " + AV1 + "\n" +
                            "AV2: " + AV2 + "\n" +
                            "Situacao: " + status + "\n");

    }
}
