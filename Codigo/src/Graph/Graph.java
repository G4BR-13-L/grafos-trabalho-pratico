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


    //=========================================================================
    //------------------------------ ENTREGA 2 --------------------------------
    //=========================================================================


    public void ExecutarBuscaEmProfundidade(boolean print_tabela){
        ExecutarBuscaEmProfundidade();
        System.out.println(this.tabela_busca_profundidade.toString());
    }
    public void ExecutarBuscaEmProfundidade(){
        while ( this.tabela_busca_profundidade.aindaHaVerticesParaExplorar() ){
            this.BuscaEmProfundidade(this.tabela_busca_profundidade.proximoVerticeAExplorar());
        }
    }
    private void BuscaEmProfundidade( int v ){
        this.tabela_busca_profundidade.T++;
        this.tabela_busca_profundidade.TD[v] = this.tabela_busca_profundidade.T;
        for( int i = 0 ; i < this.vertices.get(v).arestas.size() ; i++ ){
            int w = this.vertices.get(v).arestas.get(i).rotulo;
            if ( this.tabela_busca_profundidade.TD[w] == 0){
                System.out.println("Visitando aresta { v: "+ v + " w: "+w+" }");
                this.tabela_busca_profundidade.pai[w] = v;
                this.BuscaEmProfundidade(w);
            } else if ( 
                this.tabela_busca_profundidade.TT[w] == 0 &&
                 w != this.tabela_busca_profundidade.pai[v]){
                    System.out.println("Visitando aresta { v: "+ v + " w: "+w+" }");
            }
            this.tabela_busca_profundidade.T++;
            this.tabela_busca_profundidade.TT[v] = this.tabela_busca_profundidade.T;
        }
    }


    //Fleury
    public ArrayList<Integer>[] adj;

    @SuppressWarnings("unchecked") public void initGraph(){
        adj = new ArrayList[n_vertices];

        for (int i = 0; i < n_vertices; i++) {
            adj[i] = new ArrayList<>();
        }
    }

    public void addEdge(Integer v_origem, Integer v_destino)
    {
        adj[v_origem].add(v_destino);
        adj[v_destino].add(v_origem);
    }
 
    public void removeEdge(Integer v_origem, Integer v_destino)
    {
        adj[v_origem].remove(v_destino);
        adj[v_destino].remove(v_origem);
    }

    /**
     * Ele imprime o passeio euleriano do grafo.
     */
    public void Fleury(){
        
        Integer v_origem = 0;
 
        for (int i = 0; i < n_vertices; i++) {
            if (adj[i].size() % 2 == 1) {
                v_origem = i;
                break;
            }
        }
        printFleuryTour(v_origem);
        System.out.println("\n");
    }

    /**
     * Se houver uma próxima aresta válida, imprima-a e repita o percurso restante
     * 
     * @param v_origem O vértice a partir do qual o passeio começa
     */
    public void printFleuryTour(Integer v_origem){
        // Recorrer para todos os vértices adjacentes a este
        // vertices
        for (int i = 0; i < adj[v_origem].size(); i++) {
            Integer v_destino = adj[v_origem].get(i);
            // Se a aresta v_origem - v_destino é uma próxima aresta válida
            if (isValidNextEdge(v_origem, v_destino)) {
                System.out.print(v_origem + "-" + v_destino + " " + "/ ");
 
                removeEdge(v_origem, v_destino);
                printFleuryTour(v_destino);
            }
        }
    }

    /**
     * Se o número de vértices visitados no DFS a partir do vértice v_origem for igual ao
     * número de vértices alcançáveis ​​de v_origem, então v_destino não é um vértice válido para ser adicionado a
     * lista de v_origem
     * 
     * @param v_origem O vértice a partir do qual a aresta deve ser adicionada.
     * @param v_destino O vértice que está sendo adicionado ao gráfico
     * @return O método está retornando um valor booleano.
     */
    public boolean isValidNextEdge(Integer v_origem, Integer v_destino)
    {
        // A aresta u-v é válida em uma dos
        // dois casos a seguir:
 
        // 1) Se v_destino é o único vértice adjacente de v_origem
        // ou seja, o tamanho da lista de vértices adjacentes é 1
        if (adj[v_origem].size() == 1) {
            return true;
        }
 
        // 2) Se houver vários adjacentes, então
        // v_origem-v_destino não é uma ponte Execute os seguintes passos
        // para verificar se u-v é uma ponte
        // 2.a) contagem de vértices alcançáveis ​​de u
        boolean[] isVisited = new boolean[this.n_vertices];
        int count1 = dfsCount(v_origem, isVisited);
 
        // 2.b) Remova a borda (u, v) e depois de remover
        // a borda, conte os vértices alcançáveis ​​de u
        removeEdge(v_origem, v_destino);
        isVisited = new boolean[this.n_vertices];
        int count2 = dfsCount(v_origem, isVisited);
 
        // 2.c) Adicione a aresta de volta ao gráfico
        addEdge(v_origem, v_destino);
        return (count1 > count2) ? false : true;
    }

    // Uma função baseada em DFS para contar alcançável
    // vértices de v_destino
    public int dfsCount(int v_destino, boolean[] isVisited)
    {
        // Marcar o nó atual como visitado
        isVisited[v_destino] = true;
        int count = 1;
        // Recorrer para todos os vértices adjacentes a este vértice
        for (int adj : adj[v_destino]) {
            if (!isVisited[adj]) {
                count = count + dfsCount(adj, isVisited);
            }
        }
        return count;
    }

}
