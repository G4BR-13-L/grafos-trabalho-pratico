package Codigo.src.Graph;

public class GraphMatrix {
    public int[][] matrix;
    public int[] matrix_peso_vertices;
    public int n_vertices;

    /**
     * Construtor utilizado quando a quantidade de
     * vertices é passado pelo GraphIO. Essse construtor gera primeiro
     * uma matriz de adjacência e depois a preenche com zeros.
     * Obrigatóriamente, após cramar esse construtor é necessário
     * chamar o método @GerarListaDeAdjacenciaAPartirDaMatriz()
     * para gerar uma lista de adjecencia da qual é possivel de ser manipulada.
     * A matriz de adjacencia no momento serve apenas como
     * instermediário na leitura do grafo
     * 
     * @param isMatrix   - Sempre dever ser true
     * @param n_vertices
     */
    public GraphMatrix(int n_vertices) {
        this.n_vertices = n_vertices;
        this.matrix = new int[n_vertices][n_vertices];
        this.matrix_peso_vertices = new int[n_vertices];
        this.preencherMatrizComZeros();
    }

    /**
     * Método que preence a matriz com zeros no momento
     * de instanciação de uma matriz
     */
    private void preencherMatrizComZeros() {
        for (int i = 0; i < n_vertices; i++) {
            for (int j = 0; j < n_vertices; j++) {
                this.matrix[i][j] = 0;
            }
        }
    }

    /**
     * Método que conta a quantidade de arestas na matriz
     * de adjacencia do grafo
     * 
     * @return n_arestas
     */
    public int getQuantidadeDeArestasNaMatriz() {
        int n_arestas = 0;
        for (int i = 0; i < this.n_vertices; i++) {
            for (int j = 0; j < this.n_vertices; j++) {
                if (this.matrix[i][j] > 0) {
                    n_arestas++;
                }
            }
        }
        return n_arestas;
    }

    /**
     * Responde true caso haja uma equivalencia entre o
     * tamanho da matriz e o rotulo do vertice
     * 
     * OBS: Espera-se que o rotulo do vertice, seja o mesmo
     * que sua posição na matriz
     * 
     * @param v_find
     * @return true ou false
     */
    public boolean existeVerticeNaMatriz(int v_find) {
        if (v_find < this.matrix.length) {
            return true;
        }
        return false;
    }

    /**
     * Responde com uma pesquisa O(1) se existe uma relação
     * entre 2 vertices na Matriz
     * 
     * @param v_origem
     * @param v_destino
     * @return true || false
     */
    public boolean existeArestNaMatriz(int v_origem, int v_destino) {
        if (this.matrix[v_origem][v_destino] > 0) {
            return true;
        }
        return false;
    }

    /**
     * Retorna a quantidade de vertices da lista de adjacencia
     * 
     * @return
     */
    public int getQuantidadeVerticesNaMatriz() {
        return this.n_vertices;
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
        for (int i = 0; i < this.n_vertices; i++) {
            for (int j = 0; j < this.n_vertices; j++) {
                if (this.matrix[i][j] > 0) {
                    qtdArestas++;

                }
            }
        }
        return qtdArestas / 2;
    }

    /**
     * Adiciona aresta com custo O(1) n Matriz
     * 
     * @param v_origem
     * @param v_destino
     */
    public void addArestaNaMatriz(int v_origem, int v_destino) {
        this.matrix[v_origem][v_destino] = 1;
        this.matrix[v_destino][v_origem] = 1;
    }

    /**
     * Remove aresta da matriz vom custo O(1)
     * 
     * @param v_origem
     * @param v_destino
     */
    public void rmArestaDaMatriz(int v_origem, int v_destino) {
        this.matrix[v_origem][v_destino] = 0;
        this.matrix[v_destino][v_origem] = 0;
    }

    /**
     * Pondera o vertice a um custo de O(1) para inserir na matriz
     * 
     * @param rotulo
     * @param peso
     */
    public void ponderarVertice(int rotulo, int peso) {
        this.matrix_peso_vertices[rotulo] = peso;
    }

    /**
     * Pondera aresta a um custo O(1) na matriz
     * 
     * @param v_origem
     * @param v_destino
     * @param peso
     */
    public void ponderarAresta(int v_origem, int v_destino, int peso) {
        this.matrix[v_origem][v_destino] = peso;
        this.matrix[v_destino][v_origem] = peso;
    }

    /**
     * Verifica a adjacencia entre vertices com custo O(1)
     * 
     * @param v_origem
     * @param v_destino
     * @return
     */
    public boolean existeAdjacenciaEntreOsVertices(int v_origem, int v_destino) {
        if (this.matrix[v_origem][v_destino] > 0 || this.matrix[v_destino][v_origem] > 0) {
            return true;
        }
        return false;
    }

    /**
     * Nos diz se existem vertices no grafo
     * Caso não existam vertices, ele retorna true;
     * @return
     */
    public boolean isVazio() {
        return this.n_vertices <= 0;
    }


    /**
     * Verifica se um grafo em matriz é completo sem considerar
     * laços com os proprios vertices
     * @return true ou false
     */
    public boolean isCompleto(){
        if( this.isVazio() ){
            return false;
        }
        for( int i = 0 ; i < this.n_vertices ; i++ ){
            for( int j = 0 ; j < this.n_vertices ; j++ ){
                if( i != j ){
                    if( this.matrix[i][j] == 0 ){
                        return false;
                    }

                }
            }
        }
        return true;
    }

}
