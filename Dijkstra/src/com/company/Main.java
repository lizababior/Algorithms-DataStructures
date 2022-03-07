package com.company;

import java.util.Arrays;

public class Main {

    public static void main(String[] args) {
	    Roadmap roadmap = new Roadmap(10);
        roadmap.insertVertex(new Station("Wien")); //0
        roadmap.insertVertex(new Station("Linz")); //1
        roadmap.insertVertex(new Station("St. Polten")); //2
        roadmap.insertVertex(new Station("Innsbruck")); //3
        roadmap.insertVertex(new Station("Bregenz")); //4
        roadmap.insertVertex(new Station("Eisenstadt")); //5
        roadmap.insertVertex(new Station("Graz")); //6
        roadmap.insertVertex(new Station("Klagenfurt")); //7
        roadmap.insertVertex(new Station("Salzburg")); //8
        roadmap.insertVertex(new Station("Wien")); //0

        //From Wien
        roadmap.insertEdge(0, 1, 200);
        roadmap.insertEdge(0, 2, 80);
        roadmap.insertEdge(0, 5, 100);
        roadmap.insertEdge(0, 6, 190);

        //from Linz
        roadmap.insertEdge(1, 2, 140);
        roadmap.insertEdge(1, 8, 150);

        //form Innsbruck
        roadmap.insertEdge(3, 4, 200);
        roadmap.insertEdge(3, 8, 250);
        roadmap.insertEdge(3, 8, 300);

        //form Klagenfurt
        roadmap.insertEdge(7, 3, 300);
        roadmap.insertEdge(7, 6, 160);
        roadmap.insertEdge(7, 8, 210);

        System.out.println(Arrays.deepToString(roadmap.getAdjacencyMatrix()));


        roadmap.printShortestDistances(roadmap.insertVertex(new Station("Wien")));

        System.out.println();
    }
}
