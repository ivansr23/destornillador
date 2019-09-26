package com.destornillador.destornillador;

import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.Optional;
import java.util.stream.Stream;
public class jsonSopra {
  private static final ObjectMapper MAPPER = new ObjectMapper();
  
  public static Stream<String> getUseCases(String path) {
    final File folder = new File("src/test/resources/" + path);
    final File[] listFiles = folder.listFiles();
    if (listFiles == null || listFiles.length == 0) {
      throw new RuntimeException("Empty folder " + path);
    }
    return Arrays.stream(listFiles).filter(File::isDirectory).map(File::getName);
  }
  
  public static <T> T loadObject(final String filename, final Class<T> clazz) {
    try {
      return MAPPER.readValue(loadFileContent(filename), clazz);
    } catch (IOException e) {
      throw new RuntimeException(e);
    }
  }
  
  public static <T> Optional<T> loadOptionalObject(final String filename, final Class<T> clazz) {
    try {
      return Optional.ofNullable(loadObject(filename, clazz));
    } catch (RuntimeException ex) {
      return Optional.empty();
    }
  }
  
  public static String loadFileContent(final String fileName) {
    try {
      return new String(Files.readAllBytes(Paths.get("src/test/resources/" + fileName)), StandardCharsets.UTF_8);
    } catch (IOException e) {
      throw new RuntimeException(e);
    }
  }
  private void LoadFileUtils() {
  }
}