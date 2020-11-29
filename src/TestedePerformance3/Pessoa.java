package TestedePerformance3;

import java.lang.String;

public class Pessoa {
    String Fname, Mname, Lname;

    public Pessoa(String name) {
        setName(name);
    }

    public Pessoa() {}

    public String getName() {
        String name = new String();
        StringBuilder sb = new StringBuilder(name);
        sb.append(Fname);
        sb.append(" ");
        if (Mname != ""){
            sb.append(Mname);
            sb.append(" ");
        }
        if (Lname != ""){
            sb.append(Lname);
        }
        return sb.toString();
    }

    public void setName(String name) {
        int i;
        String parts[] = name.split(" ");
        this.Fname = parts[0];
        this.Mname = "";
        this.Lname = "";
        for (i = 1; i < parts.length - 1; i++){
            if (i != 1){
                Mname = Mname + " " + parts[i];
            } else {
                Mname = parts[i];
            }
        }
        if (parts.length > 1) {
            this.Lname = parts[parts.length - 1];
        }
    }

    public void consultarSituacao() {


        System.out.println("Nome: " + getName());
    }
}
