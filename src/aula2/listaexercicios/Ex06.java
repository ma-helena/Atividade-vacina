package aula2.listaexercicios;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.temporal.TemporalAdjusters;
import java.util.Scanner;

public class Ex06 {
        public static void main(String[] args) {
            Scanner scan = new Scanner(System.in);
            System.out.println("Digite o ano da vacinação: ");
            int anoVacinacao = scan.nextInt();
            scan.nextLine();
            System.out.println("Digite o mês da vacinação: ");
            int mesVacinacao = scan.nextInt();
            scan.nextLine();
            System.out.println("Digite o dia da vacinação: ");
            int diaVacinacao = scan.nextInt();
            scan.nextLine();

            LocalDate dataVacina = LocalDate.of(anoVacinacao,mesVacinacao,diaVacinacao);

            LocalDate dataProxVacinacao;
            int periodoDaProximaDose = 3;

            for(int i = 1; i <= periodoDaProximaDose; i++) {
                dataProxVacinacao = dataVacina.plusMonths(3*i);
                if (dataProxVacinacao.getDayOfWeek() == DayOfWeek.SATURDAY){
                    dataProxVacinacao = dataProxVacinacao.with(TemporalAdjusters.previous(DayOfWeek.FRIDAY));
                }
                if (dataProxVacinacao.getDayOfWeek() == DayOfWeek.SUNDAY){
                    dataProxVacinacao = dataProxVacinacao.with(TemporalAdjusters.next(DayOfWeek.MONDAY));
                }
                System.out.println("Dose "+i+" - Data: "+dataProxVacinacao);
            }

        }

    }


