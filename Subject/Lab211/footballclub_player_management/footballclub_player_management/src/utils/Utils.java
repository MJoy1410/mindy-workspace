package utils;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

/**
 * Provides file reading and writing operations only.
 */
public final class Utils {
    private Utils() {
    }

    public static List<String> readFile(Path file) throws IOException {
        if (!Files.isRegularFile(file)) {
            throw new IOException("File not found: " + file);
        }
        return Files.readAllLines(file, StandardCharsets.UTF_8);
    }

    public static void writeFile(Path file, Iterable<String> lines) throws IOException {
        try (java.io.BufferedWriter writer = Files.newBufferedWriter(file, StandardCharsets.UTF_8)) {
            for (String line : lines) {
                writer.write(line);
                writer.newLine();
            }
        }
    }
}
