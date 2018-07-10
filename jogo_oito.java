import java.util.*;
import java.util.ArrayList;

class No{
    No pai;
    int matriz[][];
    String operador;
    int profundidade,custo;

    No(No p , int m[][] , String op , int pr , int c){

        pai = p;
        operador = op;
        profundidade = pr;
        custo = c;

        matriz= new int[3][3];
        for(int i=0 ; i<3 ; i++){
            for(int j=0 ; j<3 ; j++){
                matriz[i][j] = m[i][j];
            }
        }
    }

    public int[][] getMatriz(){
        int nova[][] = new int [3][3];
        for(int i=0 ; i<3 ; i++)
            for(int j=0 ; j<3 ;j++)
                nova[i][j]= matriz[i][j];

        return nova;
    }

    public int getProfundidade(){
        return profundidade;
    }

    public int getCusto(){
        return custo;
    }
}


//---------------------------------------------------------------------------------------------------------------------------------------------------
public class jogo_oito {

    public static void main(String args[]) {

        Scanner ler = new Scanner(System.in);

        System.out.println("Initial Configuration");
        int[][] inicio_mat = new int[3][3];
        int[][] inicio_s = new int[3][3];
        int[] k = new int[9];
        int[] q = new int[9];
        int x = 0, z = 0;

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                inicio_mat[i][j] = ler.nextInt();
                k[x] = inicio_mat[i][j];
                x++;
            }

        }

        System.out.println("Final Configuration");
        int[][] solucao = new int[3][3];
        x = 0;
        int o = 0;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                solucao[i][j] = ler.nextInt();
                q[x] = solucao[i][j];
                x++;
            }
        }

        ArrayList<No> Lista = new ArrayList<No>();
        ArrayList<No> Visitados = new ArrayList<No>();
        String operador = " ";
        No root = new No(null, inicio_mat, operador, 0, 0);

        //Adicionar o no inicial á lista
        Lista.add(root);
        Visitados.add(root);

        System.out.println();
        System.out.println("----Choose the type of search----");
        String format = "%-45s %d\n";
        System.out.format(format, "Breadth-first search", 1);
        System.out.format(format, "Depth-first search ", 2);
        System.out.format(format, "Iterative Depth-first search ", 3);
        System.out.format(format, "Greedy search (distance from end position) ", 4);
        System.out.format(format, "Greedy search (numbers off site) ", 5);
        System.out.format(format, "A*  ", 6);

        int f = ler.nextInt();
        System.out.println();


        int inversao1 = 0;
        int inversao2 = 0;
        for (int i = 0; i < 9; i++) {
            for (int j = i + 1; j < 9; j++) {
                if (k[i] != 0 && k[j] != 0 && (k[i] > k[j])) {
                    inversao1++;
                }
                if (q[i] != 0 && q[j] != 0 && (q[i] > q[j])) {
                    inversao2++;
                }
            }
        }
       // System.out.println(inversao1 + "///" + inversao2);
        if ((inversao1 % 2 == 0 && inversao2 % 2 == 0) || (inversao1 % 2 == 1 && inversao2 % 2 == 1)) {
        } else{
            System.out.println(" Impossivel ");
        System.exit(0);
    }


        long inicio = System.currentTimeMillis();
        GeneralSearchAlgorithm(Lista, Visitados, solucao, f, root);
        long fim = System.currentTimeMillis();
        //System.out.println("Demorou " + (fim - inicio) + " milisegundos");
        System.out.println("Demorou : " + (fim - inicio) + " milisegundos" + " ou " + ((fim - inicio) / 1000) % 60 + " segundos");
    }

    public static void GeneralSearchAlgorithm(ArrayList<No> L, ArrayList<No> V, int sol[][], int flag, No inicial) {
        if (flag == 1) {
            Breadth_first.breadth(L, V, sol);
        }
        if (flag == 2) {
            Depth_first.depth(L, V, sol,10000);
        }
        if (flag == 3) {
        	Iter_depth_first.iter(L, sol,V , 0 );
        }
        if (flag == 4) {
            greedy_distancia.gree_dist(L, V, sol);
        }
        if (flag == 5) {
            greedy_fora.gree_fora(L, V, sol);
        }
        if (flag == 6) {
            A.estrela(L, V, sol);
        }
    }

    public static void Caminho(No f, int c) {

        ArrayList<No> k = new ArrayList<No>();
        k.add(f);
        while (f.pai != null) {
            k.add(f.pai);
            f = f.pai;
        }
        System.out.println("Profundidade : " + (k.size() - 1));
        System.out.println();
        System.out.print("Caminho:");

        for (int i = k.size() - 1; i >= 0; i--) {
            No x = k.get(i);
            System.out.println("\t"+ x.operador);
        }
        System.out.println();
        //System.exit(0);
    }

    public static boolean Verificar(int matriz[][], int matriz_teste[][]) {
        int count = 0;

        for (int x = 0; x < 3; x++) {
            for (int j = 0; j < 3; j++) {
                if (matriz[x][j] == matriz_teste[x][j])
                    count++;
            }
        }
        if (count == 9)
            return true;
        else
            return false;
    }
}


