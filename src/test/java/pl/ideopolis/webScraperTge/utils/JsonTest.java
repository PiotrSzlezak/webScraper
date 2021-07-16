package pl.ideopolis.webScraperTge.utils;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import org.junit.jupiter.api.Test;
import pl.ideopolis.webScraperTge.utils.jsonUtils.Json;
import pl.ideopolis.webScraperTge.utils.pojo.AuthorPOJO;
import pl.ideopolis.webScraperTge.utils.pojo.DatePOJO;
import pl.ideopolis.webScraperTge.utils.pojo.SimpleTestCaseJsonPOJO;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

class JsonTest {

    private String simpleTestCaseJsonSource = "{\n" +
            "  \"title\": \"some text\",\n" +
            "  \"author\": \"Sienkiewicz\"\n" +
            "}";
    private String dayScenario1 = "{\n" +
            "  \"date\": \"2019-12-25\",\n" +
            "  \"name\": \"Christmas Day\"\n" +
            "}";

    private String authorBookScenario = "{\n" +
            "  \"authorName\": \"Rui\",\n" +
            "  \"books\": [\n" +
            "    {\n" +
            "      \"title\": \"title1\",\n" +
            "      \"inPrint\": true,\n" +
            "      \"publishDate\": \"2019-12-25\"\n" +
            "    },\n" +
            "    {\n" +
            "      \"title\": \"title2\",\n" +
            "      \"inPrint\": false,\n" +
            "      \"publishDate\": \"2019-01-01\"\n" +
            "    }\n" +
            "  ]\n" +
            "}";

    @Test
    void parseTest() throws IOException {

        JsonNode node = Json.parse(simpleTestCaseJsonSource);

        assertEquals("some text", node.get("title").asText());
    }

    @Test
    void fromJsonTest() throws IOException {

        JsonNode node = Json.parse(simpleTestCaseJsonSource);
        SimpleTestCaseJsonPOJO pojo = Json.fromJson(node, SimpleTestCaseJsonPOJO.class);

        assertEquals("some text", pojo.getTitle());
    }

    @Test
    void toJsonTest() {
        SimpleTestCaseJsonPOJO pojo = new SimpleTestCaseJsonPOJO();
        String title = "testing 123";
        pojo.setTitle(title);

        JsonNode node = Json.toJson(pojo);

        assertEquals(title, node.get("title").asText());
    }

    @Test
    void stringifyTest() throws JsonProcessingException {
        SimpleTestCaseJsonPOJO pojo = new SimpleTestCaseJsonPOJO();
        String title = "testing 123";
        pojo.setTitle(title);

        JsonNode node = Json.toJson(pojo);

        assertEquals("{\"title\":\"testing 123\"}", Json.stringify(node));
    }

    @Test
    void dateTestScenario1() throws IOException {
        JsonNode node = Json.parse(dayScenario1);

        DatePOJO pojo = Json.fromJson(node, DatePOJO.class);

        assertEquals("2019-12-25", pojo.getDate().toString());
    }

    @Test
    void authorBookTestScenario1() throws IOException {
        JsonNode node = Json.parse(authorBookScenario);

        AuthorPOJO pojo = Json.fromJson(node, AuthorPOJO.class);

        assertEquals("Rui", pojo.getAuthorName());
        assertEquals(2, pojo.getBooks().size());
        assertEquals("title1", pojo.getBooks().get(0).getTitle());
        assertEquals(true, pojo.getBooks().get(0).isInPrint());
        assertEquals("2019-12-25", pojo.getBooks().get(0).getPublishDate().toString());
        assertEquals("title2", pojo.getBooks().get(1).getTitle());
        assertEquals(false, pojo.getBooks().get(1).isInPrint());
        assertEquals("2019-01-01", pojo.getBooks().get(1).getPublishDate().toString());
    }

}