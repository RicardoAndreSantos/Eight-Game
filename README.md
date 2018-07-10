# Eight Game

Work developed for Artificial Intelligence course.

The eight game is represented by a 3X3 matrix with numbers from 0 to 8, where number 0 represents empty space.
Only the neighbors digits of the empty space can be moved to their position. 


## objectives

Implement the game described above using various algorithms and to figure out which ones are best suited for this type of problem.

#### Uninformed search strategies
 * Depth-first search
 * Breadth-first search
 * Iterative Depth-first search

#### Informed search strategies
* Greedy search
*	A* search



## Implementation

#### There are seven files:
* Breadth-first search
* Depth-first search
* Iterative Depth-first search
* Greedy search (distance from end position)
* Greedy search (numbers off site)
* A* search algorithm
* jogo_oito

The Main class is inserted in the file **jogo_oito.java**  that will show the menus to interact with the user as well as make the call of the different implemented algorithms.

All algorithms are implemented in the class with the same name.



## Execution

Compile : `javac jogo_oito.java`<br />
Run     : `java jogo_oito`

Lets try a simple example for Breadth-first search:
```
Initial Configuration
1 2 3 
8 6 4 
7 5 0 
Final Configuration
1 2 3 
8 0 4 
7 6 5 
```
This is the output generated.

First it indicates if it is possible to reach the final configuration, the depth of the tree where the configuration was found and the path until it was found the final configuration.

Also displayed is the time it took to find the solution
```
ENCONTRADA
Profundidade : 2

Caminho:	 
	Esquerda
	Cima

Demorou : 2 milisegundos ou 0 segundos
```

