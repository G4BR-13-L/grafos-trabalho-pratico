package Codigo.src.Graph;

public class Tabela {

    public int T;
    public int[] TD;
    public int[] TT;
    public int[] low;
    public int[] pai;
    public boolean isCompleta;
    public boolean[] visitados;
    public int n_vertices;

    public Tabela(int vertices) {
        this.T = 0;
        this.TD = new int[vertices];
        this.TT = new int[vertices];
        this.pai = new int[vertices];
        this.isCompleta = false;
        this.n_vertices = vertices;
        this.low = new int[n_vertices];
        this.visitados = new boolean[n_vertices];
        this.zerarTabela(vertices);
    }

    public void zerarTabela(int vertices) {
        for (int i = 0; i < vertices; i++) {
            TD[i] = 0;
            TT[i] = 0;
            pai[i] = 0;
            visitados[i] = false;
        }
    }

    public boolean aindaHaVerticesParaExplorar(){

        for ( int i  = 0 ; i < this.TD.length ; i++ ){
            if( this.TD[i] == 0 ){
                return true;
            }
        }
        return false;
    }

    public int proximoVerticeAExplorar(){
        for ( int i  = 0 ; i < this.TD.length ; i++ ){
            if( this.TD[i] == 0 ){
                return i;
            }
        }
        return -1;
    }

    public String toString(){
        String str = "-- |";
        for( int i = 0 ; i < this.n_vertices ; i++ ){
            str+=String.format(" %-3d |", i);
        }

        str += "\nTD |";
        for( int i = 0 ; i < this.TD.length ; i++ ){
            str+=String.format(" %-3d |", this.TD[i]);
        }
        str += "\nTT |";
        for( int i = 0 ; i < this.TT.length ; i++ ){
            str+=String.format(" %-3d |", this.TT[i]);
        }
        str += "\npai |";
        for( int i = 0 ; i < this.pai.length ; i++ ){
            str+=String.format(" %-3d |", this.pai[i]);
        }
        return str;
    }

}
