package task5;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.io.TempDir;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;

import static org.junit.jupiter.api.Assertions.assertEquals;

class TriangleFallTest {

    @Test
    void openTest1(@TempDir Path tempDir) throws Exception {
        Path inputPath = tempDir.resolve("input");
        Path outputPath = tempDir.resolve("output");

        try (InputStream is = getClass().getResourceAsStream("/data_prog_contest_problem_5a.txt")) {
            if (is == null) {
                throw new IllegalArgumentException("Resource file not found: data_prog_contest_problem_5a.txt");
            }
            Files.copy(is, inputPath);
        }

        runMainInDirectory(tempDir);

        String output;
        try (BufferedReader reader = new BufferedReader(new FileReader(outputPath.toFile()))) {
            output = reader.readLine();
        }

        assertEquals("11", output);
    }

    @Test
    void openTest2(@TempDir Path tempDir) throws Exception {
        Path inputPath = tempDir.resolve("input");
        Path outputPath = tempDir.resolve("output");

        try (InputStream is = getClass().getResourceAsStream("/data_prog_contest_problem_5b.txt")) {
            if (is == null) {
                throw new IllegalArgumentException("Resource file not found: data_prog_contest_problem_5b.txt");
            }
            Files.copy(is, inputPath);
        }

        runMainInDirectory(tempDir);

        String output;
        try (BufferedReader reader = new BufferedReader(new FileReader(outputPath.toFile()))) {
            output = reader.readLine();
        }

        assertEquals("0", output);
    }

    private void runMainInDirectory(Path directory) throws Exception {
        String javaHome = System.getProperty("java.home");
        String javaBin = javaHome + File.separator + "bin" + File.separator + "java";
        String classpath = System.getProperty("java.class.path");
        String className = TriangleFall.class.getCanonicalName();

        ProcessBuilder builder = new ProcessBuilder(javaBin, "-cp", classpath, className);
        builder.directory(directory.toFile());
        assertEquals(0, builder.start().waitFor());
    }
}