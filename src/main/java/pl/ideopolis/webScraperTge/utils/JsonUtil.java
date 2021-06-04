package pl.ideopolis.webScraperTge.utils;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

public class JsonUtil {
    private JsonNode jsonNode;

    public JsonUtil (String jsonAsString){
        try {
            this.jsonNode = convertStringToJson(jsonAsString);
        } catch (JsonProcessingException e) {
            System.out.println("Something went wrong with converting string to json");
            e.printStackTrace();
        }
    }

    private JsonNode convertStringToJson(String jsonAsString) throws JsonProcessingException {
        ObjectMapper mapper = new ObjectMapper();
        JsonNode jsonNode;
        jsonNode = mapper.readTree(jsonAsString);
        return jsonNode;
    }

    public String asText (){
        return jsonNode.toPrettyString();
    }

    public String getValue(String key){
        JsonNode valueNode = jsonNode.findValue(key);
        return valueNode.asText();
    }
}
