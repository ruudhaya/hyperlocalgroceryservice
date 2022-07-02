package com.test.hyperlocalgroceryservice;

import com.test.hyperlocalgroceryservice.model.Item;
import com.test.hyperlocalgroceryservice.repository.ItemRepository;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.io.*;
import java.util.Iterator;
import java.util.Map;


@SpringBootApplication
public class HyperlocalgroceryserviceApplication {

	public static void main(String[] args) {
		SpringApplication.run(HyperlocalgroceryserviceApplication.class, args);
	}

	@Bean
	CommandLineRunner init(ItemRepository itemRepository) throws IOException, ParseException {

		String resourceName = "items.json";

		Object obj = new JSONParser().parse(new FileReader(resourceName));
		JSONObject jo = (JSONObject) obj;
		Iterator<Map.Entry> itr1 = null;
		JSONArray ja = (JSONArray) jo.get("Data");
		Iterator itr2 = ja.iterator();
		while (itr2.hasNext())
		{
			itr1 = ((Map) itr2.next()).entrySet().iterator();
			while (itr1.hasNext()) {
				Map.Entry pair = itr1.next();
				System.out.println(pair.getKey() + " : " + pair.getValue());
			}
		}

//		String resourceName = "/data/items.json";
//		File file = new File(getClass().getResource(resourceName).getFile());
//
//		Object obj = new JSONParser().parse(new FileReader(file));
//		JSONObject jo = (JSONObject) obj;
//		JSONArray ja = (JSONArray) jo.get("Data");
//
//		ja.iterator().forEachRemaining(
//				obj1 -> {
//					Iterator<Map.Entry> itr1 = ((Map) obj1).entrySet().iterator();
//					while (itr1.hasNext()) {
//						Map.Entry pair = itr1.next();
//						System.out.println(pair.getKey() + " : " + pair.getValue());
//					}
//				}
//		);



//		InputStream is = this.getClass().getResourceAsStream(resourceName);
//		if (is == null) {
//			throw new NullPointerException("resource file is missing" + resourceName);
//		} else {
//			System.out.println("-------------- read successfully --------");
//		}
////		try (InputStreamReader streamReader =
////					 new InputStreamReader(is, StandardCharsets.UTF_8);
////			 BufferedReader reader = new BufferedReader(streamReader)) {
////
////			String line;
////			while ((line = reader.readLine()) != null) {
////				System.out.println(line);
////			}
////		} catch (IOException e) {
////			e.printStackTrace();
////		}
//
//		JSONTokener tokener = new JSONTokener(is);
//		JSONObject object = new JSONObject(tokener);
//
//		System.out.println(object);
//////		System.out.println("Id  : " + object.getLong("id"));
//////		System.out.println("Name: " + object.getString("name"));
//////		System.out.println("Age : " + object.getInt("age"));
////
//////		JSONObject itemArray = object.getJSONObject("Data");
////
////		System.out.println("Items: ");
////		JSONArray items = object.getJSONArray("Data");
//////		for (int i = 0; i < courses.length(); i++) {
//////			System.out.println("  - " + courses.get(i));
//////		}
////		return args -> {
////			items.forEach(
////					itemObj -> {
////						String name = ((JSONObject)itemObj).getString("name");
////
////						Item anItem = new Item(name);
////						itemRepository.save(anItem);
////					}
////			);
//////			Stream.of("John", "Julie", "Jennifer", "Helen", "Rachel").forEach(itemObj -> {
//////				String name = ((JSONObject)itemObj).getString("name");
//////
//////				Item anItem = new Item(name);
//////				itemRepository.save(user);
//////			});
////
////			itemRepository.findAll().forEach(System.out::println);
////		};
		return null;
	}
}
