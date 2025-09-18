package exercicio02;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.function.Predicate;

public class Main {
    public static void main(String[] args) {
        List<Empregado> lista = new ArrayList<>();
        lista.add(new Empregado("Carlos", 3, 10));
        lista.add(new Empregado("Daniel", 10, 10));
        lista.add(new Empregado("Bruna", 10, 100));
        lista.add(new Empregado("Ana", 25, 1000));


       /*lista.stream()
                .map(e -> new Empregado(e.nome(), e.anosExperiencia(),//tem q criar um novo objeto, pq o record não tem set
                        e.salario() * (e.anosExperiencia() >= 5 ? 1.20 : 1.10)))
                //operador ternário = se o teste lógico foi V, retorna o primeiro valor, se F, retorna o segundo
                //apenas para diminuir o if
                .sorted(Comparator.comparing(Empregado::nome))
                .forEach(System.out::println);*/


        // predicado --> filtro lógico para selecionar ano de experiência
        // usado quando a condição lógica é muito grande
        Predicate<Empregado> filtro = e -> e.anosExperiencia() >= 5;

        //armazenando o resultado em outra lista
        List<Empregado> aux = lista.stream()
                .map(e -> new Empregado(e.nome(), e.anosExperiencia(),
                        e.salario() * (filtro.test(e) ? 1.20 : 1.10)))
                .sorted(Comparator.comparing(Empregado::nome))
                .toList();

        aux.forEach(System.out::println);
    }
}
