package ProcessamentoAssincronoEParalelo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class FutureExemplo {

    private static final ExecutorService threadsParaExecutarAtividade = Executors.newFixedThreadPool(3);

    public static void main(String[] args) throws InterruptedException {

        Casa casa = new Casa(new Quarto());
        Casa casa1 = new Casa(new Cozinha());

        List<Future<String>> futuros =
                new CopyOnWriteArrayList<>(casa.obterAfazeresDaCasa().stream()
                        .map(atividade -> threadsParaExecutarAtividade.submit(() -> {
                                    try {
                                        return atividade.realizar();
                                    } catch (InterruptedException e) {
                                        e.printStackTrace();
                                    }
                                    return null;
                                })
                        )
                        .collect(Collectors.toList()));


        List<Future<String>> futuros1 =
                new CopyOnWriteArrayList<>(casa1.obterAfazeresDaCasa().stream()
                        .map(atividade -> threadsParaExecutarAtividade.submit(() -> {
                                    try {
                                        return atividade.realizar();
                                    } catch (InterruptedException e) {
                                        e.printStackTrace();
                                    }
                                    return null;
                                })
                        )
                        .collect(Collectors.toList()));

        List<Future<String>> futurosTodos = new CopyOnWriteArrayList<>(Stream.concat(futuros.stream(), futuros1.stream())
                .collect(Collectors.toList()));

        while (true) {
            int numeroDeAtividadesNaoFinalizadas = 0;
            for (Future<?> futuro : futurosTodos) {
                if (futuro.isDone()) {
                    try {
                        System.out.println("Parabéns você terminou de " + futuro.get());
                        futurosTodos.remove(futuro);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    } catch (ExecutionException e) {
                        e.printStackTrace();
                    }
                } else {
                    numeroDeAtividadesNaoFinalizadas++;
                }
            }
            if (futurosTodos.stream().allMatch(Future::isDone)) {
                break;
            }
            System.out.println("Número de atividades não finalizadas " + numeroDeAtividadesNaoFinalizadas);
            Thread.sleep(500);

        }

        threadsParaExecutarAtividade.shutdown();

    }
}

class Casa {
    private List<Comodo> comodos;

    Casa(Comodo... comodos) {
        this.comodos = Arrays.asList(comodos);
    }

    List<Atividade> obterAfazeresDaCasa() {
        return this.comodos.stream().map(Comodo::obterAfazeresDoComodo)
                .reduce(new ArrayList<Atividade>(), (pivo, atividades) -> {
                    pivo.addAll(atividades);
                    return pivo;
                });
    }
}

interface Atividade {
    String realizar() throws InterruptedException;
}

abstract class Comodo {
    abstract List<Atividade> obterAfazeresDoComodo();
}

class Quarto extends Comodo {

    @Override
    List<Atividade> obterAfazeresDoComodo() {
        return Arrays.asList(
                this::arrumarACama,
                this::varrerOQuarto,
                this::arrumarGuardaRoupa
        );
    }

    private String arrumarGuardaRoupa() throws InterruptedException {
        Thread.sleep(1000);
        String arrumar_guarda_roupa = "Arrumar o guarda roupa";
        System.out.println(arrumar_guarda_roupa);
        return arrumar_guarda_roupa;
    }

    private String varrerOQuarto() throws InterruptedException {
        Thread.sleep(3000);
        String varrer_quarto = "Varrer o quarto";
        System.out.println(varrer_quarto);
        return varrer_quarto;
    }

    private String arrumarACama() throws InterruptedException {
        Thread.sleep(5000);
        String arrumar_cama = "Arrumar a cama";
        System.out.println(arrumar_cama);
        return arrumar_cama;
    }

}

class Cozinha extends Comodo {

    @Override
    List<Atividade> obterAfazeresDoComodo() {
        return Arrays.asList(
                this::lavarALouça,
                this::limparOFogão,
                this::limparAGeladeira
        );
    }

    private String lavarALouça() throws InterruptedException {
        Thread.sleep(2000);
        String lavar_louca = "Lavar a louça";
        System.out.println(lavar_louca);
        return lavar_louca;
    }

    private String limparOFogão() throws InterruptedException {
        Thread.sleep(4000);
        String limpar_fogao = "Limpar o fogão";
        System.out.println(limpar_fogao);
        return limpar_fogao;
    }

    private String limparAGeladeira() throws InterruptedException {
        Thread.sleep(6000);
        String limpar_geladeira = "Limpar a geladeira";
        System.out.println(limpar_geladeira);
        return limpar_geladeira;
    }

}



