package Codigo.src.Graph;

import java.util.ArrayList;
import java.util.List;

public class Vertice {
    public int rotulo;
    public List<Vertice> arestas;
    public int peso;

    public Vertice(int rotulo) {
        this.arestas = new ArrayList<>();
        this.rotulo = rotulo;
        this.peso = 1;
    }

    public void addAresta(Vertice e) {
        this.arestas.add(e);
    }

    public String arestasToString() {
        //String format = "%1$-3d";
        String str = "";
        str += " [ ";
        for (int i = 0; i < arestas.size(); i++) {
            str += this.arestas.get(i).rotulo + ", ";
        }
        str += " ]";
        return str;
    }
}
