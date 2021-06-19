package com.vins;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) throws IOException {
        Path folder = Paths.get(System.getProperty("user.home") + "/Desktop/javaApplication");
        List<File> allFiles = Files.walk(folder).filter(Files::isRegularFile)
                                .map(Path::toFile)
                                .collect(Collectors.toList());
        List<String> filesData = addFilesDataToList(allFiles);
        System.out.println("Found files: " + allFiles.size() + "\r\n" + "Files data size: " + filesData.size());

        String regex = "\\d{4}-\\d{2}-\\d{2} \\d{2}:\\d{2}:\\d{2},\\d{3} (?:INFO|ERROR)\\s{1,2}\\[(?!WebSocketWorker).*(?:\\n)?.*Exception:.*\\n(?:(?:Caused by|(?:\\t|\\s)(?:at|[.][.][.])).*\\n)+";
        Pattern pattern = Pattern.compile(regex);
        List<String> regexGroups = getAllMatches(pattern, filesData);
        System.out.println("Total matches: " + regexGroups.size());
    }

    public static List<String> addFilesDataToList(List<File> allFiles){
        List<String> filesData = new ArrayList<>();
        allFiles.forEach(file -> {
            try (Scanner scanner = new Scanner(file)){
                StringBuilder sb = new StringBuilder();
                while (scanner.hasNextLine()){
                    sb.append(scanner.nextLine()).append("\n");
                }
                filesData.add(sb.toString());
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
        });
        return filesData;
    }

    public static List<String> getAllMatches(Pattern pattern, List<String> dataToSearch){
        List<String> allMatches = new ArrayList<>();
        dataToSearch.forEach(fileText -> {
            Matcher matcher = pattern.matcher(fileText);
            while (matcher.find()){
                allMatches.add(matcher.group());
            }
        });
        return allMatches;
    }
}
