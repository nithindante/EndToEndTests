package JSONData;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.List;

import org.apache.commons.io.FileUtils;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

public class DataForJson {
 
	public List<HashMap<String, String>> getDataForJson() throws IOException
	{
		String JSON = FileUtils.readFileToString(new File("C:\\Users\\nitha\\eclipse-workspace\\SampleProject\\src\\test\\java\\JSONData\\PurchaseOrders.json"),StandardCharsets.UTF_8);  // Capturing the JSON file to a String
		ObjectMapper objectMapper = new ObjectMapper();
		List<HashMap<String, String>> data = objectMapper.readValue(JSON, new TypeReference<List<HashMap<String,String>>>(){});
		return data; 
		
	} 
}
