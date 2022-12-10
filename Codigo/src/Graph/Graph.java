package Codigo.src.Graph;

import java.util.ArrayList;
import java.util.List;

import Codigo.src.Graph.utils.StringUtils;

public class Graph extends GraphMatrix {
    public int n_vertices;
    public List<Vertice> vertices;
    public List<Aresta> arestas;

    public int ROTULOS_VERTICE = 0;
    public int ROTULOS_ARESTA = 0;

    public Tabela tabela_busca_profundidade;
    public Tabela tabela_busca_Tarjan;

    /**
     * Construtor padrão que cria um grafo em estrutura de lista
     * de adjacencia somente com os vertices. Inicialmente
     * sempre será um grafo totalmente disconexo pois as relações
     * e arestas NÃO são definidas por esse construtor
     * 
     * @param n_vertices
     */
    public Graph(int n_vertices) {
        super(n_vertices);
        this.n_vertices = n_vertices;
        this.ROTULOS_VERTICE = n_vertices;
        this.GerarListaDeAdjacencia();
        this.arestas = new ArrayList<>();
        this.tabela_busca_profundidade = new Tabela(n_vertices);
        this.tabela_busca_Tarjan = new Tabela(n_vertices);

        // Iniciando lista de Adjacência Fleury
        initGraph();
    }

    /**
     * Método que gera a lista de adjacencia padrão, com somente
     * vertices e sem arestas.
     */
    public void GerarListaDeAdjacencia() {
        List<Vertice> v = new ArrayList<>();
        for (int i = 0; i < n_vertices; i++) {
            v.add(new Vertice(i));
        }
        this.vertices = v;
    }

    /**
     * Metodo que gera a lista de adjacencia a partir da martiz
     * produzida na leitura de arquivo
     */
    public void GerarListaDeAdjacenciaAPartirDaMatriz() {
        List<Vertice> v = new ArrayList<>();
        for (int i = 0; i < n_vertices; i++) {
            v.add(new Vertice(i));
        }

        for (int i = 0; i < n_vertices; i++) {
            for (int j = 0; j < n_vertices; j++) {
                if (this.matrix[i][j] == 1) {
                    v.get(i).addAresta(v.get(j));
                }
            }
        }

        this.vertices = v;
    }

    /**
     * Itera pela lista de vertices em busca de um vertice
     * especifico tendo o rotulo como parametro.
     * 
     * OBS: Espera-se que não existam vertices com o mesmo
     * rotulo no grafo. Cada vertice é unico
     * 
     * @param v_find
     * @return true ou false
     */
    private boolean existeVertice(int v_find) {
        for (int i = 0; i < this.vertices.size(); i++) {
            if (this.vertices.get(i).rotulo == v_find) {
                return true;
            }
        }
        return false;
    }

    /**
     * Verifica a existencia de uma aresta nas listas de adjacencia e
     * na lista de arestas. O Retorno é true caso a aresta
     * exista em abas as listas
     * 
     * @param v_origem
     * @param v_destino
     * @return true || false
     */
    @Override
    public boolean existeAdjacenciaEntreOsVertices(int v_origem, int v_destino) {
        for (int i = 0; i < this.vertices.size(); i++) {
            if (this.vertices.get(i).rotulo == v_origem) {
                for (int j = 0; j < this.vertices.get(i).arestas.size(); j++) {
                    if (this.vertices.get(i).arestas.get(j).rotulo == v_destino) {
                        for (int k = 0; k < this.arestas.size(); k++) {
                            if ((this.arestas.get(k).rotuloVerticeV == v_origem
                                    && this.arestas.get(k).rotuloVerticeW == v_destino) ||
                                    (this.arestas.get(k).rotuloVerticeW == v_origem
                                            && this.arestas.get(k).rotuloVerticeV == v_destino)) {
                                return true;
                            }
                        }
                    }
                }
            }
        }
        return false;
    }

    /**
     * Adiciona aresta ao grafo
     * OBS: Apesar dos parametros se chamarem origem e destino,
     * a aresta no final é não-direcionada.
     * 
     * @param v_origem  -> Aresta de origem
     * @param v_destino - Aresta de Destino
     */
    public void addAresta(int v_origem, int v_destino) {
        if (existeVertice(v_origem) && existeVertice(v_destino)) {
            this.vertices.get(v_origem).addAresta(this.vertices.get(v_destino));
            this.vertices.get(v_destino).addAresta(this.vertices.get(v_origem));
            this.arestas.add(new Aresta(this.ROTULOS_ARESTA, v_origem, v_destino));
            this.ROTULOS_ARESTA++;
            this.addArestaNaMatriz(v_origem, v_destino);
        } else {
            System.out.println("ERRO: A Aresta não pode ser inserida porque um dos vertices não existe");
        }
    }

    /**
     * Adiciona uma aresta nova a partir da instancia de um ]
     * objeto aresta
     * 
     * @param aresta
     */
    public void addAresta(Aresta aresta) {
        if (existeVertice(aresta.rotuloVerticeV) && existeVertice(aresta.rotuloVerticeW)) {
            this.vertices.get(aresta.rotuloVerticeV).addAresta(this.vertices.get(aresta.rotuloVerticeW));
            this.vertices.get(aresta.rotuloVerticeW).addAresta(this.vertices.get(aresta.rotuloVerticeV));
            this.arestas.add(new Aresta(aresta.rotulo, aresta.rotuloVerticeV, aresta.rotuloVerticeW));
            this.ponderarAresta(aresta.rotuloVerticeV, aresta.rotuloVerticeW, aresta.peso);
            this.addArestaNaMatriz(aresta.rotuloVerticeV, aresta.rotulo, aresta.peso);
        } else {
            System.out.println("ERRO: A Aresta não pode ser inserida porque um dos vertices não existe");
        }
    }

    /**
     * Remove a relação bidireciona ( aresta ), de 2 vertices
     * passados como parâmetro
     * 
     * @param v_origem
     * @param v_destino
     */
    public void rmAresta(int v_origem, int v_destino) {
        if (existeVertice(v_origem) && existeVertice(v_destino)) {
            if (existeAdjacenciaEntreOsVertices(v_origem, v_destino)
                    && existeAdjacenciaEntreOsVertices(v_destino, v_origem)) {

                for (int i = 0; i < this.vertices.size(); i++) {
                    if (this.vertices.get(i).rotulo == v_origem) {
                        for (int v = 0; v < this.vertices.get(i).arestas.size(); v++) {
                            if (this.vertices.get(i).arestas.get(v).rotulo == v_destino) {
                                this.vertices.get(i).arestas.remove(v);
                            }
                        }
                    }
                }

                for (int i = 0; i < this.vertices.size(); i++) {
                    if (this.vertices.get(i).rotulo == v_destino) {
                        for (int w = 0; w < this.vertices.get(i).arestas.size(); w++) {
                            if (this.vertices.get(i).arestas.get(w).rotulo == v_origem) {
                                this.vertices.get(i).arestas.remove(w);
                            }
                        }
                    }
                }

                for (int i = 0; i < this.arestas.size(); i++) {
                    if ((this.arestas.get(i).rotuloVerticeV == v_origem
                            && this.arestas.get(i).rotuloVerticeW == v_destino) ||
                            (this.arestas.get(i).rotuloVerticeW == v_origem
                                    && this.arestas.get(i).rotuloVerticeV == v_destino)) {
                        this.arestas.remove(i);
                    }
                }

                this.rmArestaDaMatriz(v_origem, v_destino);
                System.out.println("Grafo: aresta removida com sucesso");
            } else {
                System.out.println("ERRO: Não existe uma relção de aresta entre os 2 vertices");
            }
        } else {
            System.out.println("ERRO: Um dos vertices, ou ambos, não existe no grafo ");
        }
    }

    /**
     * Retorna a quantidade de vertices da lista de adjacencia
     * 
     * @return
     */
    public int getQuantidadeVertices() {
        return this.vertices.size();
    }

    /**
     * Retorna a quantidade de arestas da lista de adjacencia
     * 
     * OBS: Como é um grafo não direcionado, a relação dos vertices existe
     * nas duas direções. Por isso dividimos a conta por 2
     * na hora no retorno
     * 
     * @return
     */
    public int getQuantidadeArestas() {
        int qtdArestas = 0;
        for (int i = 0; i < this.vertices.size(); i++) {
            qtdArestas += this.vertices.get(i).arestas.size();
        }
        return qtdArestas / 2;
    }

    /**
     * Atribui um peso ao vertice procurado a partir do rotulo
     * e pondera tambem o messmo vertice na matriz chamando o método
     * pai que foi sobrescrito.
     */
    @Override
    public void ponderarVertice(int rotulo, int peso) {
        for (int i = 0; i < this.vertices.size(); i++) {
            if (this.vertices.get(i).rotulo == rotulo) {
                this.vertices.get(i).peso = peso;
                super.ponderarVertice(rotulo, peso);
                return;
            }
        }
    }

    /**
     * Pondera aresta do grafo em formato de lista ao iterar
     * sobre o conjunto de arestas do grafo. O custo total é O(n).
     * Ao final da operação, após ter encontrado a aresta na lista, é chamado
     * o método da classe pai para atualizar a martiz do grafo.
     */
    @Override
    public void ponderarAresta(int v_origem, int v_destino, int peso) {
        for (int i = 0; i < this.arestas.size(); i++) {
            if ((this.arestas.get(i).rotuloVerticeV == v_origem
                    && this.arestas.get(i).rotuloVerticeW == v_destino) ||
                    (this.arestas.get(i).rotuloVerticeW == v_origem
                            && this.arestas.get(i).rotuloVerticeV == v_destino)) {
                this.arestas.get(i).peso = peso;
                super.ponderarAresta(v_origem, v_destino, peso);
                return;
            }
        }
        System.out.println("ERRO: Aresta não encontrada");
    }

    /**
     * Esse método busca por uma aresta na lista e a retorna
     * 
     * @param v_origem
     * @param v_destino
     * @return Aresta || Null
     */
    public Aresta getAresta(int v_origem, int v_destino) {
        for (int i = 0; i < this.arestas.size(); i++) {
            if ((this.arestas.get(i).rotuloVerticeV == v_origem
                    && this.arestas.get(i).rotuloVerticeW == v_destino) ||
                    (this.arestas.get(i).rotuloVerticeW == v_origem
                            && this.arestas.get(i).rotuloVerticeV == v_destino)) {

                return this.arestas.get(i);
            }
        }
        System.out.println("ERRO: Aresta não encontrada");
        return null;
    }

    /**
     * Retorna uma aresta de uma posição da lista de arestas.
     * 
     * @param index
     * @return
     */
    public Aresta getArestaFromList(int index) {
        return this.arestas.get(index);
    }

    /**
     * Nos diz se existem vertices no grafo
     * Caso não existam vertices, ele retorna true;
     * 
     * @return
     */
    @Override
    public boolean isVazio() {
        return this.vertices.isEmpty() && this.arestas.isEmpty();
    }

    /**
     * Verifica se um grafo em matriz é completo sem considerar
     * laços com os proprios vertices
     * 
     * @return true ou false
     */
    public boolean isCompleto() {
        if (this.isVazio()) {
            return false;
        }
        for (int i = 0; i < this.vertices.size(); i++) {
            if (this.vertices.get(i).arestas.size() != (this.vertices.size() - 1)) {
                return false;
            }
        }
        return true;
    }

    /**
     * Verifica se duas arestas compartilham do mesmo vertice, ou
     * adjacencia
     * 
     * @param v_origem
     * @param v_destino
     * @param w_origem
     * @param w_destino
     * @return true ou false
     */
    @Override
    public boolean isArestasAdjacentes(int v_origem, int v_destino, int w_origem, int w_destino) {
        if (existeAdjacenciaEntreOsVertices(v_origem, v_destino)
                && existeAdjacenciaEntreOsVertices(w_origem, w_destino)) {
            if (v_origem == w_origem ||
                    v_origem == w_destino ||
                    v_destino == w_origem ||
                    v_destino == w_destino) {
                return true;
            }
            return false;
        }
        return false;

    }

    /**
     * ToString para printar a lista de adjecencia
     * de um jeito bem bacana
     */
    @Override
    public String toString() {

        String headerFormat = "|%1$-10s|%2$-6s|%3$-10s\n";
        String lineFormat = "|%1$-10s|%2$-6s|%3$s\n";

        String str = String.format(
                headerFormat,
                StringUtils.center("Vertice", 10),
                StringUtils.center("Peso", 10),
                StringUtils.center("Arestas", 10));

        for (int i = 0; i < vertices.size(); i++) {
            str += String.format(lineFormat,
                    StringUtils.center(this.vertices.get(i).rotulo + "", 10),
                    StringUtils.center(this.vertices.get(i).peso + "", 10),
                    this.vertices.get(i).arestasToString());
        }
        return str;
    }

    // =========================================================================
    // ------------------------------ ENTREGA 2 --------------------------------
    // =========================================================================

    /* -------------------------- BUSCA EM PROFUNDIDADE ------------------------- */
    public void ExecutarBuscaEmProfundidade(boolean print_tabela) {
        ExecutarBuscaEmProfundidade();
        System.out.println(this.tabela_busca_profundidade.toString());
    }

    public void ExecutarBuscaEmProfundidade() {
        while (this.tabela_busca_profundidade.aindaHaVerticesParaExplorar()) {
            this.BuscaEmProfundidade(this.tabela_busca_profundidade.proximoVerticeAExplorar());
        }
    }

    private void BuscaEmProfundidade(int v) {
        this.tabela_busca_profundidade.T++;
        this.tabela_busca_profundidade.TD[v] = this.tabela_busca_profundidade.T;
        for (int i = 0; i < this.vertices.get(v).arestas.size(); i++) {
            int w = this.vertices.get(v).arestas.get(i).rotulo;
            if (this.tabela_busca_profundidade.TD[w] == 0) {
                System.out.println("Visitando aresta { v: " + v + " w: " + w + " }");
                this.tabela_busca_profundidade.pai[w] = v;
                this.BuscaEmProfundidade(w);
            } else if (this.tabela_busca_profundidade.TT[w] == 0 &&
                    w != this.tabela_busca_profundidade.pai[v]) {
                System.out.println("Visitando aresta { v: " + v + " w: " + w + " }");
            }
            this.tabela_busca_profundidade.T++;
            this.tabela_busca_profundidade.TT[v] = this.tabela_busca_profundidade.T;
        }
    }

    /* --------------------- Busca Naive por ponte no Grafo --------------------- */

    public boolean ExecutarNaiveBridgeFind() {
        this.tabela_busca_profundidade.zerarTabela(this.n_vertices);
        this.BuscaEmProfundidade(this.tabela_busca_profundidade.proximoVerticeAExplorar());
        if (this.tabela_busca_profundidade.aindaHaVerticesParaExplorar()) {
            return false;
        }
        return true;
    }

    public void buscaNaive() {
        for (int k = 0; k < this.getQuantidadeArestas(); k++) {
            Aresta aresta = this.arestas.get(k);
            this.rmAresta(aresta.rotuloVerticeV, aresta.rotuloVerticeW);
            if (ExecutarNaiveBridgeFind()) {
                System.out.println("Ponte Encontrada: \n" + aresta.toString());
            }
            this.addAresta(aresta);
        }
    }

    /* --------------------- Busca por pontes pelo método de Tarjan --------------------- */

    public void executarBuscarPontes() {
        for (int i = 0; i < this.vertices.size(); i++) {
          if (this.tabela_busca_Tarjan.TD[i] == 0) {
            this.BuscarPontes(this.vertices.get(i).rotulo);
          }
        }
    }

    
    private void BuscarPontes(int v) {
        this.tabela_busca_Tarjan.T++;
        this.tabela_busca_Tarjan.TD[v] = this.tabela_busca_Tarjan.T;
        this.tabela_busca_Tarjan.low[v] = this.tabela_busca_Tarjan.T;

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

    
    /* --------------------- Método de Fleury --------------------- */

    public boolean tresOuMaisVerticesDeGrauImpar() {
        int verticesGrauImpar = 0;
        for (int i = 0; i < this.vertices.size(); i++) {
            if (this.vertices.get(i).arestas.size() % 2 != 0) {
                verticesGrauImpar++;
            }
            if (verticesGrauImpar > 2) {
                return true;
            }
        }
        return false;
    }

    public void Fleury() {
        if (tresOuMaisVerticesDeGrauImpar()) {
            System.out.println("Erro - Fleury não pode ser executado por ter 3 ou mais vértices de grau ímpar");
            return;
        }

        System.out.println(this.toString());

        Graph grafo = new Graph(this.getQuantidadeVertices());

        grafo.vertices = this.vertices;
        grafo.arestas = this.arestas;
        grafo.matrix = this.matrix;
        grafo.tabela_busca_profundidade = this.tabela_busca_profundidade;
        grafo.matrix_peso_vertices = this.matrix_peso_vertices;

        System.out.println(grafo.toString());
        int v = getVerticeGrauImpar();
        while (grafo.arestas.size() != 0) {
            if (v > 1) {

            }
        }

    }

    public int getVerticeGrauImpar() {
        for (int i = 0; i < this.vertices.size(); i++) {
            if (this.vertices.get(i).arestas.size() % 2 != 0) {
                return i;
            }
        }
        return 0;
    }

    public ArrayList<Integer>[] adj;

    @SuppressWarnings("unchecked")
    public void initGraph() {
        adj = new ArrayList[n_vertices];

        for (int i = 0; i < n_vertices; i++) {
            adj[i] = new ArrayList<>();
        }
    }

}
