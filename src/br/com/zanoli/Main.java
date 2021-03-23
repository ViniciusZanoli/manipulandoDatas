package br.com.zanoli;

import java.time.*;
import java.time.temporal.Temporal;

public class Main {

    public static void main(String[] args) {
        LocalDate ld1 = LocalDate.of(2020, 2, 29);
        LocalTime lt1 = LocalTime.of(00, 30);

        LocalDate ld2 = LocalDate.of(2020, 3, 5);
        LocalTime lt2 = LocalTime.of(00, 00);

        LocalDateTime ldt1 = LocalDateTime.of(ld1, lt1);
        LocalDateTime ldt2 = LocalDateTime.of(ld2, lt2);

        System.out.println("Inicio: " + ldt1);
        System.out.println("Fim:    " + ldt2);

        Tempo t1 = somarDatas(ldt1, ldt2);
        System.out.println(t1.toString() + "\n");

        LocalDate l1 = LocalDate.of(2020, 3, 6);
        LocalDateTime ll1 = LocalDateTime.of(l1, LocalTime.now());

        LocalDate l2 = LocalDate.of(2020, 3, 7);
        LocalDateTime ll2 = LocalDateTime.of(l2, LocalTime.now());

        System.out.println("Inicio: " + ll1);
        System.out.println("Fim:    " + ll2);

        Tempo t2 = somarDatas(ll1, ll2);
        System.out.println(t2.toString() + "\n");

        long totalDias = t1.dias + t2.dias;

        System.out.println("Total dias: " + totalDias);

    }

    public static Tempo somarDatas(Temporal data1, Temporal data2) {
        long dia = Duration.between(data1, data2).toHours() / 24;
        long hora = Duration.between(data1, data2).toHours() % 24;
        long minuto = Duration.between(data1, data2).toMinutes() % 60;
        long segundo = Duration.between(data1, data2).toSeconds() % 60;

        Tempo t = new Tempo(dia, hora, minuto, segundo);

        return t;
    }

    public static class Tempo {
        long dias;
        long horas;
        long minutos;
        long segundos;

        public Tempo(long dias, long horas, long minutos, long segundos) {
            this.dias = dias;
            this.horas = horas;
            this.minutos = minutos;
            this.segundos = segundos;
        }

        @Override
        public String toString() {
            return "Tempo{" +
                    "dias=" + dias +
                    ", horas=" + horas +
                    ", minutos=" + minutos +
                    ", segundos=" + segundos +
                    '}';
        }
    }
}

