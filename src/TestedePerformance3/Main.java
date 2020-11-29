package TestedePerformance3;

import java.util.*;

public class Main {

    private static int PrintMenu(Scanner Scan){
        int option;
        do {
            System.out.println( "[1] Cadastrar professor.\n" +
                    "[2] Cadastrar aluno.\n" +
                    "[3] Consultar situacao de um docente/aluno.\n" +
                    "[4] Sair");
            try {
                option = Scan.nextInt();
            } catch (NumberFormatException ex){
                option = 0;
                System.out.println("Input nao formatado corretamente, tente novamente com numeros entre 1 e 4.");
            } catch (InputMismatchException e){
                option = 0;
                System.out.println("Input nao formatado corretamente, tente novamente somente com numeros.");
            } finally {
                Scan.nextLine();
            }
        } while((option < 1) || (option > 4));

        return option;
    }

    private static float AskGrade(Scanner Scan, String Grade){
        float AV = -1;
        do {
            System.out.println("Insira a nota " + Grade + ": ");
            try {
                AV = Scan.nextFloat();
            } catch (InputMismatchException e){
                AV = -1;
                System.out.println("Input nao formatado corretamente, tente novamente somente com numeros.");
                Scan.nextLine();
            }

        } while((AV < 0.0) || (AV > 10.0));

        return AV;
    }

    private static int AskCode(Scanner Scan, ArrayList<Pessoa> Array){
        int code;
        if(!Array.isEmpty()) {
            do {
                System.out.println("Insira o codigo de registro: ");
                try {
                    code = Scan.nextInt();
                } catch (InputMismatchException e){
                    code = -1;
                    System.out.println("Input nao formatado corretamente, tente novamente somente com numeros.");
                    Scan.nextLine();
                }
            } while ((code < 0) || (code > Array.size() - 1));

            return code;
        } else {
            System.out.println("Nao ha pessoas na lista ou cadastradas nesse codigo\n");
            return -1;
        }
    }

    private static String AskClassroom(Scanner Scan){
        String classroom;
        System.out.println("Insira a classe: ");
        classroom = Scan.nextLine();
        return classroom;
    }

    private static int AskTurma(Scanner Scan){
        int turma;
        do {
            System.out.println("Insira a turma: ");
            try{
                turma = Scan.nextInt();
            } catch (InputMismatchException e){
                turma =  -1;
                System.out.println("Input nao formatado corretamente, tente novamente somente com numeros.");
                Scan.nextLine();
            }
        } while (turma < 0);

        return turma;
    }

    private static String AskName(Scanner Scan){
        String name = null;
        do {
            try{
                name = Scan.nextLine();
                if (name.matches("[A-Za-záàâãéèêíïóôõöúçñÁÀÂÃÉÈÍÏÓÔÕÖÚÇÑ ]+") != true){
                    throw new ExcessaoString();
                }
            } catch (ExcessaoString e) {
                System.out.println("Insira o nome somente com letras e acentos, sem numeros ou caracteres especiais");
                name = null;
            }
        } while (name == null);

        return name;
    }

    public static void main(String[] args) {
        boolean running = true;
        int option;
        int code;

        ArrayList<Pessoa> obj = new ArrayList<>(100);

        Scanner scn = new Scanner(System.in);

        while(running) {
            option = PrintMenu(scn);
            switch (option) {
                case 1:
                    if(obj.size() != 100){
                        System.out.println("Insira o nome do docente");
                        obj.add(new Professor(AskName(scn), AskClassroom(scn), AskTurma(scn)));
                        System.out.println("Usuario registrado com sucesso com codigo " + (obj.size() - 1) + "\n");
                    }else{
                        System.out.println("Lista lotada");
                    }
                    break;
                case 2:
                    if(obj.size() != 100){
                        System.out.println("Insira o nome do aluno");
                        obj.add(new Aluno(AskName(scn), AskGrade(scn, "AV1"), AskGrade(scn, "AV2")));
                        System.out.println("Usuario registrado com sucesso com codigo " + (obj.size() - 1) + "\n");
                    }else{
                        System.out.println("Lista lotada");
                    }
                    break;
                case 3:
                    if((code = AskCode(scn, obj)) != -1) {
                        obj.get(code).consultarSituacao();
                    }
                    break;
                case 4:
                    running = false;
                    System.out.println("Saindo...");
                    break;
                default:
                    break;
            }
        }
    }
}