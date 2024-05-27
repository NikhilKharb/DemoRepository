package dataFile;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.List;

import org.apache.commons.io.FileUtils;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

public class DataReader {

	public List<HashMap<String, String>> getJsonData() throws IOException {
		// Reading JSON to String
		String jsonContent = FileUtils.readFileToString(new File(
				"C:\\Users\\nikhil.kharb\\eclipse-workspace\\E2EFrameWork\\src\\test\\java\\dataFile\\PurchaseOrder.json"),
				StandardCharsets.UTF_8);

		// Convert String to HashMap
		ObjectMapper mapper = new ObjectMapper();
		List<HashMap<String, String>> data = mapper.readValue(jsonContent,
				new TypeReference<List<HashMap<String, String>>>() {
				});
		return data;
	}
}
