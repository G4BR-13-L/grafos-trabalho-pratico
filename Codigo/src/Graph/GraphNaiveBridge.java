package Codigo.src.Graph;

public class GraphNaiveBridge extends Graph {

    public GraphNaiveBridge(int n_vertices) {
        super(n_vertices);
    }

    public boolean ExecutarNaiveBridgeFind() {

        this.BuscaEmProfundidadeNaiveBridgeFind(this.tabela_busca_profundidade.proximoVerticeAExplorar());
        if (this.tabela_busca_profundidade.aindaHaVerticesParaExplorar()) {
            return false;
        }
        return true;
    }

    private void BuscaEmProfundidadeNaiveBridgeFind(int v) {
        this.tabela_busca_profundidade.T++;
        this.tabela_busca_profundidade.TD[v] = this.tabela_busca_profundidade.T;
        for (int i = 0; i < this.vertices.get(v).arestas.size(); i++) {
            int w = this.vertices.get(v).arestas.get(i).rotulo;
            if (this.tabela_busca_profundidade.TD[w] == 0) {
                System.out.println("Visitando aresta { v: " + v + " w: " + w + " }");
                this.tabela_busca_profundidade.pai[w] = v;
                this.BuscaEmProfundidadeNaiveBridgeFind(w);
            } else if (this.tabela_busca_profundidade.TT[w] == 0 &&
                    w != this.tabela_busca_profundidade.pai[v]) {
                System.out.println("Visitando aresta { v: " + v + " w: " + w + " }");
            }
            this.tabela_busca_profundidade.T++;
            this.tabela_busca_profundidade.TT[v] = this.tabela_busca_profundidade.T;
        }
    }

    public void buscaNaive() {
        for (int k = 0; k < this.getQuantidadeArestas(); k++) {
            Aresta aresta = this.arestas.get(k);
            this.rmAresta(aresta.rotuloVerticeV, aresta.rotuloVerticeW);
            if (ExecutarNaiveBridgeFind()) {
                System.out.println("Ponte Encontrada: \n" + aresta.toString());
                this.addAresta(aresta);
                return;
            }
            this.addAresta(aresta);
        }

    }

}
