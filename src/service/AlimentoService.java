package service;

import model.Alimento;

import java.util.ArrayList;
import java.util.LinkedHashSet;

public class AlimentoService {
    private static AlimentoService ourInstance = new AlimentoService();


    public static AlimentoService getInstance() {
        return ourInstance;
    }

    private AlimentoService() {
    }

    private LinkedHashSet<Alimento> alimentos = new LinkedHashSet<>();


    public boolean salvarAlimento(Alimento alimento) {
        return this.alimentos.add(alimento);
    }

    public void listarAlimentos() {
        this.alimentos.stream().forEach(System.out::println);
    }

    public void listarCombinacoesPorMeta(Integer metaCalorica) {
        if (this.alimentos.size() < 3) {
            System.out.println("não há quantidade de alimentos cadastrados o suficiente. ");
        }
        ArrayList<Alimento> temp = new ArrayList<>(this.alimentos);

        for (int i = 0; i < temp.size() - 2; i++) {
            for (int j = i + 1; j < temp.size() - 1; j++) {
                for (int k = j + 1; k < temp.size(); k++) {
                    if (temp.get(i).getGrupo().equals(temp.get(j).getGrupo())
                            || temp.get(i).getGrupo().equals(temp.get(k).getGrupo())
                            || temp.get(k).getGrupo().equals(temp.get(j).getGrupo())
                            || (temp.get(i).getCalorias() + temp.get(j).getCalorias() + temp.get(k).getCalorias() > metaCalorica)
                    ) {
                        continue;
                    } else {
                        System.out.println("Combinação [ " + temp.get(i) + temp.get(j) + temp.get(k) + " ]");
                    }
                }
            }
        }

    }

}
