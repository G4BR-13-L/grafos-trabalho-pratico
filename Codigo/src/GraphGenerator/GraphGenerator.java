package Codigo.src.GraphGenerator;

import java.util.Random;

import Codigo.src.Graph.Graph;

public class GraphGenerator {
    final int MAX_LIMIT = 20;
    public int vertices;
    public int min_aresta_por_vertice;
    public int max_aresta_por_vertice;


    /**
     * Metodo principal que gera um grafo não direcionado
     * cuja o peso de todas as arestas é 1;
     * 
     * A geração funciona com base no numero de vertices desejado,
     * a quantidade minima de conexões por vertice e a quantidade máxima de
     * conexões respectivamente
     * @param vertices
     * @param min_aresta_por_vertice
     * @param max_aresta_por_vertice
     * @return
     */
    public static Graph generateGraph(
            int vertices,
            int min_aresta_por_vertice,
            int max_aresta_por_vertice) {
        Graph graph = new Graph(vertices);

        for (int i = 0; i < vertices; i++) {
            int numero_arestas_do_vertice = quantasArestasTeraOVertice(
                    min_aresta_por_vertice, max_aresta_por_vertice);
            int[] lista_vertices_para_conectar = qualAListaDeVerticesParaConectar(numero_arestas_do_vertice, vertices);
            for( int j = 0 ; j < lista_vertices_para_conectar.length ; j++ ){
                graph.addAresta(i, lista_vertices_para_conectar[j]);
            }
        }
        return graph;
    }



    /**
     * Informa quantas arestas um vertice deve ter dados os
     * parametros de minimo e máximo
     * @param min_aresta_por_vertice
     * @param max_aresta_por_vertice
     * @return
     */
    private static int quantasArestasTeraOVertice(
            int min_aresta_por_vertice,
            int max_aresta_por_vertice) {
        Random random = new Random();
        return random.nextInt(max_aresta_por_vertice - min_aresta_por_vertice) + min_aresta_por_vertice;
    }


    /**
     * Gera uma lista de vertices que serão conectados.
     * A lista de vertices gerada passa sempre por um filtro para 
     * evitar a repetição de vertices. Dessa forma, desviamos
     * de problemas de laços, e respeitamos a quantidade de conexões
     * gerada anteriormente
     * @param qtd_arestas
     * @param qtd_vertices
     * @return
     */
    private static int[] qualAListaDeVerticesParaConectar(int qtd_arestas, int qtd_vertices){
        int[] lista = new int[qtd_arestas];
        Random random = new Random();
        int i = 0;
        do{
            int random_vertice = random.nextInt(qtd_vertices);
            if ( !existeNaLista(lista, random_vertice) ){
                lista[i] = random_vertice;
                i++;
            }
        }while( i < qtd_arestas );
        return lista;

    }

    /**
     * Verifica se um dado vertice N existe na lista v[] que
     * contem os vértices gerados até o momento
     * @param v
     * @param n
     * @return
     */
    private static boolean existeNaLista(int[] v, int n){

        for ( int i = 0 ; i < v.length ; i++){
            if( v[i] == n ){
                return true;
            }
        }
        return false;

    }
}
