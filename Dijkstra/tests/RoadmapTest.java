import com.company.Roadmap;
import com.company.Station;
import org.junit.Test;

public class RoadmapTest {
    Roadmap roadmap = new Roadmap(10);

    public void fillGraph() {
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
    }


    @Test
    public void printShortestDistancesTest() {
        fillGraph();
        roadmap.printShortestDistances(roadmap.insertVertex(new Station("Wien")));
    }

    @Test
    public void butcherShop() {
        Roadmap roadmap = new Roadmap(8);
        roadmap.insertVertex(new Station("1"));
        roadmap.insertVertex(new Station("2"));
        roadmap.insertVertex(new Station("3"));
        roadmap.insertVertex(new Station("4"));
        roadmap.insertVertex(new Station("5"));
        roadmap.insertVertex(new Station("6"));
        roadmap.insertVertex(new Station("7"));

        roadmap.insertEdge(0, 1, 4);
        roadmap.insertEdge(0, 2, 5);
        roadmap.insertEdge(0, 4, 1);

        roadmap.insertEdge(1, 2, 3);
        roadmap.insertEdge(1, 3, 4);

        roadmap.insertEdge(2, 4, 4);
        roadmap.insertEdge(2, 3, 2);

        roadmap.insertEdge(3, 6, 1);

        roadmap.insertEdge(4, 5, 1);
        roadmap.insertEdge(4, 3, 3);

        roadmap.insertEdge(5, 3, 7);
        roadmap.insertEdge(5, 6, 8);


        roadmap.printShortestDistances(0);
    }
}
