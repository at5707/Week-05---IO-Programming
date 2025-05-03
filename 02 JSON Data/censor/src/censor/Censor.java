package censor;
import org.json.JSONArray;
import org.json.JSONObject;

import java.io.*;
import java.util.*;
public class Censor {
	 public static void main(String[] args) throws Exception {
	        // Input file paths
	        String jsonInputFile = "player.json";
	        String csvInputFile = "player.csv";

	        // Output file paths
	        String jsonOutputFile = "censored_ipl_matches.json";
	        String csvOutputFile = "censored_ipl_matches.csv";

	        // Process JSON data
	        processJsonData(jsonInputFile, jsonOutputFile);

	        // Process CSV data
	        processCsvData(csvInputFile, csvOutputFile);
	    }

	    // Function to process JSON data
	    public static void processJsonData(String inputFile, String outputFile) throws Exception {
	        // Read JSON data from file
	        String jsonString = readFile(inputFile);
	        JSONArray jsonArray = new JSONArray(jsonString);

	        // Iterate through each match and apply censorship
	        for (int i = 0; i < jsonArray.length(); i++) {
	            JSONObject match = jsonArray.getJSONObject(i);

	            // Mask team names
	            maskTeamNames(match);

	            // Redact player of match
	            redactPlayerOfMatch(match);
	        }

	        // Write the censored JSON data to output file
	        writeToFile(outputFile, jsonArray.toString(4));
	        System.out.println("Censored JSON written to: " + outputFile);
	    }

	    // Function to mask team names in JSON data
	    public static void maskTeamNames(JSONObject match) {
	        String[] teamFields = {"team1", "team2", "winner"};
	        
	        for (String field : teamFields) {
	            String teamName = match.getString(field);
	            String maskedName = teamName.replaceAll("(?<=\\w)(?=\\s)", "***");
	            match.put(field, maskedName);
	        }
	    }

	    // Function to redact player of the match in JSON data
	    public static void redactPlayerOfMatch(JSONObject match) {
	        match.put("player_of_match", "REDACTED");
	    }

	    // Function to process CSV data
	    public static void processCsvData(String inputFile, String outputFile) throws Exception {
	        // Read CSV data from file
	        List<String[]> records = readCsv(inputFile);

	        // Prepare output writer
	        BufferedWriter writer = new BufferedWriter(new FileWriter(outputFile));
	        writer.write("match_id,team1,team2,score_team1,score_team2,winner,player_of_match\n");

	        // Process each record and apply censorship
	        for (String[] record : records) {
	            String matchId = record[0];
	            String team1 = maskTeamName(record[1]);
	            String team2 = maskTeamName(record[2]);
	            String scoreTeam1 = record[3];
	            String scoreTeam2 = record[4];
	            String winner = maskTeamName(record[5]);
	            String playerOfMatch = "REDACTED";

	            // Write censored data to CSV
	            writer.write(String.join(",", matchId, team1, team2, scoreTeam1, scoreTeam2, winner, playerOfMatch) + "\n");
	        }

	        // Close the CSV writer
	        writer.close();
	        System.out.println("Censored CSV written to: " + outputFile);
	    }

	    // Function to mask team names in CSV data
	    public static String maskTeamName(String teamName) {
	        return teamName.replaceAll("(?<=\\w)(?=\\s)", "***");
	    }

	    // Function to read JSON data from a file
	    public static String readFile(String filePath) throws IOException {
	        BufferedReader reader = new BufferedReader(new FileReader(filePath));
	        StringBuilder content = new StringBuilder();
	        String line;
	        while ((line = reader.readLine()) != null) {
	            content.append(line).append("\n");
	        }
	        reader.close();
	        return content.toString();
	    }

	    // Function to write data to a file
	    public static void writeToFile(String filePath, String data) throws IOException {
	        BufferedWriter writer = new BufferedWriter(new FileWriter(filePath));
	        writer.write(data);
	        writer.close();
	    }

	    // Function to read CSV data from a file
	    public static List<String[]> readCsv(String filePath) throws IOException {
	        List<String[]> records = new ArrayList<>();
	        BufferedReader reader = new BufferedReader(new FileReader(filePath));
	        String line;
	        while ((line = reader.readLine()) != null) {
	            records.add(line.split(","));
	        }
	        reader.close();
	        return records;
	    }
}
