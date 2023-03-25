package pl.edu.pw.ee.graphTest;

import org.junit.Test;
import pl.edu.pw.ee.graph.Graph;

import java.net.URISyntaxException;
import java.nio.file.Path;
import java.nio.file.Paths;

import static java.lang.String.format;
import static org.junit.Assert.assertEquals;

public class GraphTest {
    @Test
    public void shouldCorrectlyReadSmallBasicFile() {
        // given
        String filename = "correct_small_data.txt";
        String pathToFile = getFilePath(filename);

        // when
        Graph graph = new Graph(pathToFile);
        String graphAsStr = graph.toString();

        // then
        String expected = "A_3_B|A_5_C|A_7_D|B_1_C|C_1_D|D_7_E";
        assertEquals(expected, graphAsStr);
    }

    @Test
    public void shouldCorrectlyReadRepeatedSmallBasicFile() {
        // given
        String filename = "correct_repeated_small_data.txt";
        String pathToFile = getFilePath(filename);

        // when
        Graph graph = new Graph(pathToFile);
        String graphAsStr = graph.toString();

        // then
        String expected = "A_3_B|A_5_C|A_7_D|B_1_C|C_1_D|D_1_E";
        assertEquals(expected, graphAsStr);
    }

    @Test
    public void shouldCorrectlyReadSmallDataBasicFile() {
        // given
        String filename = "small_data.txt";
        String pathToFile = getFilePath(filename);

        // when
        Graph graph = new Graph(pathToFile);
        String graphAsStr = graph.toString();

        // then
        String expected = "0_12_1|1_13_2|0_15_2";
        assertEquals(expected, graphAsStr);
    }

//    @Test
//    public void shouldCorrectlyReadExtendedRepeatedSmallBasicFile() {
//        // given
//        String filename = "extended_repeated_small_data.txt";
//        String pathToFile = getFilePath(filename);
//
//        // when
//        Graph graph = new Graph(pathToFile);
//        String graphAsStr = graph.toString();
//
//        // then
//        String expected = "";
//        assertEquals(expected, graphAsStr);
//    }
//
//    @Test
//    public void shouldCorrectlyReadExtendedSmallBasicFile() {
//        // given
//        String filename = "extended_small_data.txt";
//        String pathToFile = getFilePath(filename);
//
//        // when
//        Graph graph = new Graph(pathToFile);
//        String graphAsStr = graph.toString();
//
//        // then
//        String expected = "";
//        assertEquals(expected, graphAsStr);
//    }

    @Test
    public void shouldCorrectlyReadSingleEdgeFile() {
        // given
        String filename = "single_edge.txt";
        String pathToFile = getFilePath(filename);

        // when
        Graph graph = new Graph(pathToFile);
        String graphAsStr = graph.toString();

        // then
        String expected = "A_4_B";
        assertEquals(expected, graphAsStr);
    }

    private String getFilePath(String filename) {
        ClassLoader clsLoader = getClass().getClassLoader();

        try {
            Path path = Paths.get(clsLoader.getResource(filename).toURI());

            return path.toFile().getAbsolutePath();

        } catch (URISyntaxException e) {
            throw new RuntimeException(format("Cannot read file from filename: %s.", filename), e);
        }
    }

}
