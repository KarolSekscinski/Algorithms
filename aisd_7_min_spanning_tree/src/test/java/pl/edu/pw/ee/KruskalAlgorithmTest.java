package pl.edu.pw.ee;

import org.junit.Test;

import java.net.URISyntaxException;
import java.nio.file.Path;
import java.nio.file.Paths;

import static java.lang.String.format;
import static org.junit.Assert.assertEquals;

public class KruskalAlgorithmTest extends MinSpanningTreeTest {

    @Test
    public void shouldCorrectlyFindMSTForSmallBasicFile() {
        // given
        String filename = "correct_small_data.txt";
        String pathToFile = getFilePath(filename);

        // when
        KruskalAlgorithm kruskal = new KruskalAlgorithm();
        String actual = kruskal.findMST(pathToFile);

        // then
        String expected = "B_1_C|C_1_D|A_3_B|D_7_E";
        assertEquals(expected, actual);
    }

    @Test
    public void shouldCorrectlyFindMSTForReapetedSmallBasicFile() {
        // given
        String filename = "correct_repeated_small_data.txt";
        String pathToFile = getFilePath(filename);

        // when
        KruskalAlgorithm kruskal = new KruskalAlgorithm();
        String actual = kruskal.findMST(pathToFile);

        // then
        String expected = "B_1_C|C_1_D|D_1_E|A_3_B";
        assertEquals(expected, actual);
    }

    @Test
    public void shouldCorrectlyFindMSTForExampleFromLesson() {
        // given
        String filename = "example_from_lesson.txt";
        String pathToFile = getFilePath(filename);

        // when
        KruskalAlgorithm kruskal = new KruskalAlgorithm();
        String actual = kruskal.findMST(pathToFile);

        // then
        String expected = "B_1_C|C_2_E|A_3_E|A_4_D|D_8_F";
        assertEquals(expected, actual);
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
