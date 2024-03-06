This simple console based Java program will get the data (name) from the user about the source and the destination stations of Pune Metro. 
It will display the fare as well as the shortest metro route from the source to the destination. The program will also have a metro map to make it easier for commuters to navigate.
This program is based on the idea of a Graph and a Heap data structure.
There are nodes and edges in the graph. The nodes represent the metro station which will contain certain information about that station such as its name, the metro corridor and the lines it connects. 
The edges are the distance between two nodes and the cost for each edge is the distance between its connecting stations (nodes). 
Various algorithms are used to determine the shortest path from the source station to the destination station. 
The fare is calculated based on the total distance from the source to destination station. 
The main.java file contains all the main code while heap.java contains the implementation of the heap.
