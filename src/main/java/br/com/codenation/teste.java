package br.com.codenation;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

public class teste {

    public static void main(String[] args) {
        DesafioMeuTimeApplication desafioMeuTimeApplication = new DesafioMeuTimeApplication();
        LocalDate dataNascimento = LocalDate.of(1991,02,01);
        Long id = new Long(9);
        Long idTime = new Long(1);
        BigDecimal salario = new BigDecimal(9999);
        LocalDate dataCriacaoTime = LocalDate.of(1925,9,12);

        desafioMeuTimeApplication.incluirTime(idTime,"Corinthians",dataCriacaoTime,"preto", "branco");
        dataCriacaoTime = LocalDate.of(1920,04,22);
        idTime = new Long(2);

        desafioMeuTimeApplication.incluirTime(idTime,"Palmeiras",dataCriacaoTime,"verde", "amarelo");
        dataCriacaoTime = LocalDate.of(1902,05,8);
        idTime = new Long(3);

        desafioMeuTimeApplication.incluirTime(idTime,"PontePreta",dataCriacaoTime,"preto", "branco");
        dataCriacaoTime = LocalDate.of(1922,10,12);
        idTime = new Long(4);

        desafioMeuTimeApplication.incluirTime(idTime,"Sao Paulo",dataCriacaoTime,"branco", "preto");
        dataCriacaoTime = LocalDate.of(1932,8,29);
        idTime = new Long(5);

        desafioMeuTimeApplication.incluirTime(idTime,"Santos",dataCriacaoTime,"preto", "azul");
        dataCriacaoTime = LocalDate.of(1890,12,01);
        idTime = new Long(6);

        desafioMeuTimeApplication.incluirTime(idTime,"Ituano",dataCriacaoTime,"vermelho", "branco");


        idTime = new Long(1);
        desafioMeuTimeApplication.incluirJogador(id,idTime,"Anderson", dataNascimento, 98, salario);

        dataNascimento = LocalDate.of(1995,12,01);
        idTime = new Long(1);
        id = new Long(2);
        salario = new BigDecimal(9999);
        desafioMeuTimeApplication.incluirJogador(id,idTime,"Paulo", dataNascimento, 70, salario);

        dataNascimento = LocalDate.of(1999,10,11);
        idTime = new Long(1);
        id = new Long(1);
        salario = new BigDecimal(4890);
        desafioMeuTimeApplication.incluirJogador(id,idTime,"Fernando", dataNascimento, 72, salario);


        dataNascimento = LocalDate.of(2001,12,11);
        idTime = new Long(2);
        id = new Long(6);
        salario = new BigDecimal(4290);
        desafioMeuTimeApplication.incluirJogador(id,idTime,"Wagner", dataNascimento, 89, salario);

        dataNascimento = LocalDate.of(1990,12,11);
        idTime = new Long(2);
        id = new Long(5);
        salario = new BigDecimal(5090);
        desafioMeuTimeApplication.incluirJogador(id,idTime,"Rogerio", dataNascimento, 79, salario);

        dataNascimento = LocalDate.of(2004,2,11);
        idTime = new Long(2);
        id = new Long(4);
        salario = new BigDecimal(9999);
        desafioMeuTimeApplication.incluirJogador(id,idTime,"Roberto", dataNascimento, 69, salario);

        dataNascimento = LocalDate.of(2001,2,11);
        idTime = new Long(3);
        id = new Long(7);
        salario = new BigDecimal(1908);
        desafioMeuTimeApplication.incluirJogador(id,idTime,"Carlos", dataNascimento, 79, salario);

        dataNascimento = LocalDate.of(2001,2,11);
        idTime = new Long(3);
        id = new Long(8);
        salario = new BigDecimal(2998);
        desafioMeuTimeApplication.incluirJogador(id,idTime,"George", dataNascimento, 87, salario);

        dataNascimento = LocalDate.of(2001,9,9);
        idTime = new Long(3);
        id = new Long(3);
        salario = new BigDecimal(999999999);
        desafioMeuTimeApplication.incluirJogador(id,idTime,"Lopes", dataNascimento, 98, salario);


        dataNascimento = LocalDate.of(1999,9,9);
        idTime = new Long(4);
        id = new Long(10);
        salario = new BigDecimal(8910);
        desafioMeuTimeApplication.incluirJogador(id,idTime,"Lopes", dataNascimento, 81, salario);

        dataNascimento = LocalDate.of(1980,9,9);
        idTime = new Long(4);
        id = new Long(13);
        salario = new BigDecimal(8000);
        desafioMeuTimeApplication.incluirJogador(id,idTime,"Kaka", dataNascimento, 98, salario);

        dataNascimento = LocalDate.of(1990,1,19);
        idTime = new Long(5);
        id = new Long(11);
        salario = new BigDecimal(10000);
        desafioMeuTimeApplication.incluirJogador(id,idTime,"Ferdinando", dataNascimento, 98, salario);

        dataNascimento = LocalDate.of(1991,10,19);
        idTime = new Long(5);
        id = new Long(14);
        salario = new BigDecimal(1000);
        desafioMeuTimeApplication.incluirJogador(id,idTime,"Krilo", dataNascimento, 85, salario);

        dataNascimento = LocalDate.of(1998,10,19);
        idTime = new Long(5);
        id = new Long(15);
        salario = new BigDecimal(2800);
        desafioMeuTimeApplication.incluirJogador(id,idTime,"Roberto", dataNascimento, 79, salario);

        dataNascimento = LocalDate.of(1995,11,19);
        idTime = new Long(6);
        id = new Long(16);
        salario = new BigDecimal(9100);
        desafioMeuTimeApplication.incluirJogador(id,idTime,"Leandro", dataNascimento, 84, salario);

        dataNascimento = LocalDate.of(1997,7,17);
        idTime = new Long(6);
        id = new Long(17);
        salario = new BigDecimal(7777);
        desafioMeuTimeApplication.incluirJogador(id,idTime,"Romero", dataNascimento, 87, salario);

        id = new Long(17);
        desafioMeuTimeApplication.definirCapitao(id);

        id = new Long(11);
        desafioMeuTimeApplication.definirCapitao(id);

        id = new Long(9);
        desafioMeuTimeApplication.definirCapitao(id);

        id = new Long(13);
        desafioMeuTimeApplication.definirCapitao(id);

        id = new Long(4);
        desafioMeuTimeApplication.definirCapitao(id);

        id = new Long(7);
        desafioMeuTimeApplication.definirCapitao(id);

        id = new Long(15);
        desafioMeuTimeApplication.definirCapitao(id);

        id = new Long(3);
        desafioMeuTimeApplication.definirCapitao(id);

        id = new Long(1);
        desafioMeuTimeApplication.definirCapitao(id);

        System.out.println();

        System.out.println("Capitões dos times:");
        idTime = new Long(1);
        System.out.println("Capitão do Time:"+idTime+" é o numero "+ desafioMeuTimeApplication.buscarCapitaoDoTime(idTime));


        idTime = new Long(2);
        System.out.println("Capitão do Time:"+idTime+" é o numero "+ desafioMeuTimeApplication.buscarCapitaoDoTime(idTime));


        idTime = new Long(3);
        System.out.println("Capitão do Time:"+idTime+" é o numero "+ desafioMeuTimeApplication.buscarCapitaoDoTime(idTime));


        idTime = new Long(4);
        System.out.println("Capitão do Time:"+idTime+" é o numero "+ desafioMeuTimeApplication.buscarCapitaoDoTime(idTime));


        idTime = new Long(5);
        System.out.println("Capitão do Time:"+idTime+" é o numero "+ desafioMeuTimeApplication.buscarCapitaoDoTime(idTime));


        idTime = new Long(6);
        System.out.println("Capitão do Time:"+idTime+" é o numero "+ desafioMeuTimeApplication.buscarCapitaoDoTime(idTime));

        for(int i = 1; i <= 17; i++){
            if(i != 12)
                System.out.println("Nome do jogador nº"+ i+" é "+ desafioMeuTimeApplication.buscarNomeJogador(new Long(i)));
        }

        for(int i = 1; i <= 6; i++){
            System.out.println("Nome do time nº"+ i+" é "+ desafioMeuTimeApplication.buscarNomeTime(new Long(i)));
        }

        for(int i = 1; i <= 6; i++){
            List<Long> jogadoresTimesBuscado = desafioMeuTimeApplication.buscarJogadoresDoTime(new Long(i));
            for(Long a : jogadoresTimesBuscado){
                System.out.println("Nome do jogador buscado com nº"+ a+" é "+ desafioMeuTimeApplication.buscarNomeJogador(new Long(a)));
            }
        }

        for(int i = 1; i <= 6; i++){
            System.out.println("Melhor jogador do time nº"+ i+" é "+ desafioMeuTimeApplication.buscarMelhorJogadorDoTime(new Long(i)));
        }

        for(int i = 1; i <= 6; i++){
            System.out.println("Jogador mais velhi do time nº"+ i+" é "+ desafioMeuTimeApplication.buscarJogadorMaisVelho(new Long(i)));
        }

        List<Long> timesBuscado = desafioMeuTimeApplication.buscarTimes();

        for(Long a : timesBuscado){
            System.out.println("Nome do time buscado nº"+ a +" é "+ desafioMeuTimeApplication.buscarNomeTime(a));
        }

        for(int i = 1; i <= 6; i++){
            System.out.println("Jogador com maior salario do time nº"+ i+" é "+ desafioMeuTimeApplication.buscarJogadorMaiorSalario(new Long(i)));
        }

        for(int i = 1; i <= 17; i++){
            if(i != 12)
                System.out.println("Salario do jogado nº"+ i+" é "+ desafioMeuTimeApplication.buscarSalarioDoJogador(new Long(i)));
        }

        List<Long> JogadoresMaisTop = desafioMeuTimeApplication.buscarTopJogadores(5);

        for(Long a : JogadoresMaisTop){
            System.out.println("Jogador mais top "+ a +" nome: "+
                    desafioMeuTimeApplication.buscarNomeJogador(a));
        }

        for(int i = 1; i <= 6; i++){
            for(int j = 1; j <= 6; j++){
                if(i != j) {
                    System.out.println("Time da casa:"+desafioMeuTimeApplication.buscarNomeTime(new Long(i))+
                            " Time de fora:"+desafioMeuTimeApplication.buscarNomeTime(new Long(j)));
                    System.out.println("Cor da camisa do time de fora:" +
                            desafioMeuTimeApplication.buscarCorCamisaTimeDeFora(new Long(i), new Long(j)));
                }
            }
        }
    }
}
