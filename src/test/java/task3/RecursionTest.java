package task3;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.io.TempDir;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.nio.file.Path;

import static org.junit.jupiter.api.Assertions.assertEquals;


class RecursionTest {

    @Test
    @DisplayName("pick answer 1")
    void answerTest1(@TempDir Path tempDir) throws Exception {
        Path outputPath = tempDir.resolve("output");

        runMainInDirectory(tempDir);

        String output;
        try (BufferedReader reader = new BufferedReader(new FileReader(outputPath.toFile()))) {
            output = reader.readLine();
        }

        assertEquals("1315315589499944334548764515609971939863", output);
    }

    @Test
    @DisplayName("pick answer 2")
    void answerTest2(@TempDir Path tempDir) throws Exception {
        Path outputPath = tempDir.resolve("output");

        runMainInDirectory(tempDir);

        String output;
        try (BufferedReader reader = new BufferedReader(new FileReader(outputPath.toFile()))) {
            output = reader.readLine();
        }

        assertEquals("956232624325636774650209848176913581618398", output);
    }

    @Test
    @DisplayName("pick answer 3")
    void answerTest3(@TempDir Path tempDir) throws Exception {
        Path outputPath = tempDir.resolve("output");

        runMainInDirectory(tempDir);

        String output;
        try (BufferedReader reader = new BufferedReader(new FileReader(outputPath.toFile()))) {
            output = reader.readLine();
        }

        assertEquals("184153577162052268122747461393215875186211", output);
    }

    @Test
    @DisplayName("pick answer 4")
    void answerTest4(@TempDir Path tempDir) throws Exception {
        Path outputPath = tempDir.resolve("output");

        runMainInDirectory(tempDir);

        String output;
        try (BufferedReader reader = new BufferedReader(new FileReader(outputPath.toFile()))) {
            output = reader.readLine();
        }

        assertEquals("35464738515375434036472541210834205687343", output);
    }

    private void runMainInDirectory(Path directory) throws Exception {
        String javaHome = System.getProperty("java.home");
        String javaBin = javaHome + File.separator + "bin" + File.separator + "java";
        String classpath = System.getProperty("java.class.path");
        String className = Recursion.class.getCanonicalName();

        ProcessBuilder builder = new ProcessBuilder(javaBin, "-cp", classpath, className);
        builder.directory(directory.toFile());
        assertEquals(0, builder.start().waitFor());
    }
}