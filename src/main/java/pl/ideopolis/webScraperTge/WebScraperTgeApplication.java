package pl.ideopolis.webScraperTge;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;
import pl.ideopolis.webScraperTge.tge.ScrapTGEData;
import pl.ideopolis.webScraperTge.tge.dataModel.TgePodsumowanieRdbDTO;
import pl.ideopolis.webScraperTge.tge.dataModel.TgeRdbDTO;
import pl.ideopolis.webScraperTge.utils.JsonUtil;
import pl.ideopolis.webScraperTge.utils.SaveToFile;
import pl.ideopolis.webScraperTge.webScrapUtil.LoadDocument;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;

@SpringBootApplication
@EnableScheduling
public class WebScraperTgeApplication {

	public static void main(String[] args) {
		SpringApplication.run(WebScraperTgeApplication.class, args);

//		test();

//		String url = "https://tge.pl/energia-elektryczna-rdb";
		String url = "https://tge.pl/energia-elektryczna-rdb?dateShow=25-05-2021&dateAction=prev";
		LoadDocument loadTgePage = new LoadDocument(url);
		try {
			loadTgePage.connect();
		} catch (IOException e) {
			e.printStackTrace();
		}
		Document tgeDocument = loadTgePage.getDoc();

		List<TgeRdbDTO> tgeRdbDTOList = ScrapTGEData.extractRdb(tgeDocument);
//		TgePodsumowanieRdbDTO tgePodsumowanieRdbDTO = ScrapTGEData.extractPodsumowanieRdb(tgeDocument);

		SaveToFile saveToFile = new SaveToFile();
		SaveToFile saveToFile2 = new SaveToFile();
		String tgeRdbAsString = "";
		for (TgeRdbDTO dto: tgeRdbDTOList) {
			tgeRdbAsString = tgeRdbAsString + dto.toString();
		}
//		JsonUtil jsonUtil = new JsonUtil(tgeRdbAsString)
		ObjectMapper objectMapper = new ObjectMapper();
		String jsonString = "";
		try {
			jsonString = objectMapper.writeValueAsString(tgeRdbDTOList);
			System.out.println("Konwersja listy do jsona udana.");
		} catch (JsonProcessingException e) {
			System.out.println("Konwersja listy do jsona NIE udana.");
			e.printStackTrace();
		}
		JsonUtil jsonUtil = new JsonUtil(jsonString);

		saveToFile.saveToFile("tgeRdbDTOList.txt", "D:\\tge data\\", tgeRdbAsString);
		saveToFile2.saveToFile("tgeRdbDTOListjson.txt", "D:\\tge data\\", jsonUtil.asText());
		System.out.println(tgeRdbDTOList);
//		saveToFile.saveToFile("tgePodsumowanieRdbDTO.txt", "D:\\tge data\\", tgePodsumowanieRdbDTO.toString());

	}
	private static void test() {
		LoadDocument loadDocument = new LoadDocument("https://tge.pl/energia-elektryczna-rdb");
		try {
			loadDocument.connect();
		} catch (IOException e) {
			e.printStackTrace();
		}

		final Document document = loadDocument.getDoc();

		String id = "footable_kontrakty_godzinowe";
		final Element elementById = document.getElementById(id);
		final Elements rows = elementById.select("tr");
		final List<String> rowsAsStrings = rows.eachText();

		System.out.println("Pierwsze 5 wierszy:");
		for (int i = 0; i < 5; i++) {
			System.out.println("   Wiersz o indeksie "+i);
			System.out.println("   "+rowsAsStrings.get(i));
		}

		System.out.println("Poszczegolne komórki:");
		for (int i = 0; i < 5; i++) {
			Elements cells = rows.get(i).select("td");
			System.out.println("   Ilość komórek w wierszu "+i+": "+cells.size());
		}

		TgePodsumowanieRdbDTO podsumowanie = new TgePodsumowanieRdbDTO();
		// thead tbody tfoot
		final Elements thead = elementById.select("thead");
		final Elements theadRows = thead.select("tr");
		final List<String> theadAsStrings = theadRows.eachText();
		System.out.println("thead:");
		System.out.println(" number of rows: "+theadAsStrings.size());
		for (int i = 0; i < theadAsStrings.size(); i++) {
			System.out.println("  Row: "+i);
			System.out.println("   "+theadAsStrings.get(i));
			System.out.println("  Number of cells: "+theadRows.get(i).select("th").size());
			for (int j = 0; j < theadRows.get(i).select("th").size(); j++) {
				System.out.println("   Cell: "+j);
				if(j==2 && i==0){
					final String dataDostawyAsString = theadRows.get(i).select("th").get(j).text().substring(14);
					System.out.println("Data dostawy (obcięta): "+dataDostawyAsString);

					try {
						podsumowanie.setDataDostawy(new SimpleDateFormat("yyyy-MM-dd").parse(dataDostawyAsString));
					} catch (ParseException e) {
						e.printStackTrace();
					}
				}
				System.out.println(theadRows.get(i).select("th").get(j).text());
			}
		}

		final Elements tbody = elementById.select("tbody");
		final Elements tbodyRows = tbody.select("tr");
		final List<String> tbodyAsStrings = tbodyRows.eachText();
		System.out.println("tbody:");
		System.out.println(" number of rows: "+tbodyAsStrings.size());
		for (int i = 0; i < tbodyAsStrings.size(); i++) {
			System.out.println("   Row "+i+". Number of cells: "+ tbodyRows.get(i).select("td").size());
			System.out.println("   "+tbodyAsStrings.get(i));
		}

		final Elements tfoot = elementById.select("tfoot");
		final Elements tfootRows = tfoot.select("tr");
		final List<String> tfootAsStrings = tfootRows.eachText();
		System.out.println("tfoot:");
		System.out.println(" number of rows: "+tfootAsStrings.size());
		for (int i = 0; i < tfootAsStrings.size(); i++) {
			System.out.println("  Row: "+i);
			System.out.println("   "+tfootAsStrings.get(i));
			System.out.println("  Number of cells: "+ tfootRows.get(i).select("td").size());
			for (int j = 0; j < tfootRows.get(i).select("td").size(); j++) {
				System.out.println("   Cell: "+j);
				System.out.println(tfootRows.get(i).select("td").get(j).select("span").eachText());
				System.out.println(tfootRows.get(i).select("td").get(j).text());
			}
		}

		System.out.println("\nPodsumowanie:"+podsumowanie);
	}

}

