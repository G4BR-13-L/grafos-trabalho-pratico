package Codigo.src.Graph;

public class TarjanGraph extends Graph {

  public Tabela tabela_busca_Tarjan;


  public TarjanGraph(int n_vertices) {
    super(n_vertices);
    this.tabela_busca_Tarjan = new Tabela(n_vertices);

  }

  public void executarBuscarPontes() {
    // while (this.tabela_busca_Tarjan.aindaHaVerticesParaExplorar()) {
    //   this.BuscarPontes(this.tabela_busca_Tarjan.proximoVerticeAExplorar());
    // }
    for (int i = 0; i < this.vertices.size(); i++) {
      if (this.tabela_busca_Tarjan.visitados[i] == false) {
        this.BuscarPontes(this.vertices.get(i).rotulo);
      }
    }
  }

  private void BuscarPontes(int v) {
    this.tabela_busca_Tarjan.T++;
    this.tabela_busca_Tarjan.TD[v] = this.tabela_busca_Tarjan.T;
    this.tabela_busca_Tarjan.low[v] = this.tabela_busca_Tarjan.T;

    this.tabela_busca_Tarjan.visitados[v] = true;

    for (int i = 0; i < this.vertices.get(v).arestas.size(); i++) {
      int w = this.vertices.get(v).arestas.get(i).rotulo;
      if (this.tabela_busca_Tarjan.TD[w] == 0) {
        System.out.println("Visitando aresta { v: " + v + " w: " + w + " }");
        this.tabela_busca_Tarjan.pai[w] = v;
        this.BuscarPontes(w);

        this.tabela_busca_Tarjan.low[v] = Math.min(this.tabela_busca_Tarjan.low[v], this.tabela_busca_Tarjan.low[w]);

        if (this.tabela_busca_Tarjan.TD[v] < this.tabela_busca_Tarjan.low[w]) {
          System.out.println("\nPonte encontrada: { v: " + v + " w: " + w + " }\n");
        }
      } else if (this.tabela_busca_Tarjan.TT[w] == 0 &&
          w != this.tabela_busca_Tarjan.pai[v]) {
        System.out.println("Visitando aresta { v: " + v + " w: " + w + " }");
      }
      this.tabela_busca_Tarjan.T++;
      this.tabela_busca_Tarjan.TT[v] = this.tabela_busca_Tarjan.T;
    }
  }

}
