import java.util.ArrayList;

public class Iter_depth_first {
	public static void iter(ArrayList<No> L,int[][] sol, ArrayList<No> V,int p ) {
        ArrayList<No> L1;
        ArrayList<No> V1;
        int contador = 0;
        int iguais = 0, xi = 0;
        int prof;
        int max =0 ;

        while (xi != 1) {
            L1 = L ;
            V1 = V ;
            max++;
            int x0 = 0;
            int y0 = 0;

            No novo = L.get(0);

            L.remove(0);
            V.add(novo);
            prof = novo.getProfundidade();
            int matriz[][];
            matriz = novo.getMatriz();

                //Verificar se encontrou a solucao
                for (int i = 0; i < 3; i++) {
                    for (int j = 0; j < 3; j++) {
                        if (matriz[i][j] == sol[i][j])
                            iguais++;
                    }
                }

                if (iguais == 9) {
                    xi = 1;
                    System.out.println("ENCONTRADA");
                    jogo_oito.Caminho(novo, contador);
                } else
                    iguais = 0;


                //Encontrar a posicao em branco
                for (int i = 0; i < 3; i++) {
                    for (int j = 0; j < 3; j++) {
                        if (matriz[i][j] == 0) {
                            x0 = i;
                            y0 = j;
                        }
                    }
                }


                //***Mover para cima***
                if (x0 != 0) {
                    int x = matriz[x0 - 1][y0];
                    matriz[x0 - 1][y0] = 0;
                    matriz[x0][y0] = x;

                    No noFilho = new No(novo, matriz, "Cima", prof + 1, 0);

                    //Ver se o No a expandir foi visitado
                    int k = 0;
                    for (int i = 0; i < V.size(); i++) {
                        int matriz_teste[][];
                        matriz_teste = V.get(i).getMatriz();

                        if (jogo_oito.Verificar(matriz, matriz_teste) != true)
                            k++;
                    }

                    if (k == V.size() && prof < max ) {
                        L.add(L.size(), noFilho);
                        contador++;
                    }
                }

                matriz = novo.getMatriz();

                //***Mover para baixo***
                if (x0 != 2) {
                    int x = matriz[x0 + 1][y0];
                    matriz[x0 + 1][y0] = 0;
                    matriz[x0][y0] = x;

                    No noFilho = new No(novo, matriz, "Baixo", prof + 1, 0);

                    //Ver se o No a expandir foi visitado
                    int k = 0;
                    for (int i = 0; i < V.size(); i++) {
                        int matriz_teste[][];
                        matriz_teste = V.get(i).getMatriz();

                        if (jogo_oito.Verificar(matriz, matriz_teste) != true)
                            k++;
                    }

                    if (k == V.size()&& prof < max) {
                        L.add(L.size(), noFilho);
                        contador++;
                    }

                }

                matriz = novo.getMatriz();

                //***Mover para Direita***
                if (y0 != 2) {
                    int x = matriz[x0][y0 + 1];
                    matriz[x0][y0 + 1] = 0;
                    matriz[x0][y0] = x;

                    No noFilho = new No(novo, matriz, "Direita", prof + 1, 0);

                    //Ver se o No a expandir foi visitado
                    int k = 0;
                    for (int i = 0; i < V.size(); i++) {
                        int matriz_teste[][];
                        matriz_teste = V.get(i).getMatriz();

                        if (jogo_oito.Verificar(matriz, matriz_teste) != true)
                            k++;
                    }

                    if (k == V.size()&& prof < max) {
                        L.add(L.size(), noFilho);
                        contador++;
                    }
                }

                matriz = novo.getMatriz();

                //***Mover para Esquerda***
                if (y0 != 0) {
                    int x = matriz[x0][y0 - 1];
                    matriz[x0][y0 - 1] = 0;
                    matriz[x0][y0] = x;

                    No noFilho = new No(novo, matriz, "Esquerda", prof + 1, 0);

                    //Ver se o No a expandir foi visitado
                    int k = 0;
                    for (int i = 0; i < V.size(); i++) {
                        int matriz_teste[][];
                        matriz_teste = V.get(i).getMatriz();

                        if (jogo_oito.Verificar(matriz, matriz_teste) != true)
                            k++;
                    }

                    if (k == V.size() && prof < max) {
                        L.add(L.size() , noFilho);
                        contador++;
                    }
                    if ( contador == 0 ){
                        iter(L,sol,V,0);
                    }
                }
               // V.clear();

            }

        }

}
