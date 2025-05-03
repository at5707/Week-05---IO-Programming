package converter;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;

import java.io.File;

public class JsonToXml {
    public static void main(String[] args) throws Exception {
        // Create mappers
        ObjectMapper jsonMapper = new ObjectMapper();
        XmlMapper xmlMapper = new XmlMapper();

        // Read JSON file
        JsonNode jsonNode = jsonMapper.readTree(new File("data.json"));

        // Convert to XML string
        String xml = xmlMapper.writerWithDefaultPrettyPrinter().writeValueAsString(jsonNode);

        // Print XML
        System.out.println("Converted XML:\n" + xml);
    }
}
