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

@SpringBootApplication
public class HyperlocalgroceryserviceApplication {

	public static void main(String[] args) {
		SpringApplication.run(HyperlocalgroceryserviceApplication.class, args);
	}

	private static void importItems(ItemRepository itemRepository) throws IOException, ParseException {
		String resourceName = "items.json";

		Object obj = new JSONParser().parse(new FileReader(resourceName));
		JSONObject jo = (JSONObject) obj;
		JSONArray ja = (JSONArray) jo.get("Data");

		Iterator itr2 = ja.iterator();
		while (itr2.hasNext())
		{
			JSONObject singleItem = (JSONObject) itr2.next();
			Item anItem = new Item(
					singleItem.get("name").toString(),
					Float.valueOf(singleItem.get("mrp").toString()),
					Float.valueOf(singleItem.get("weightInGms").toString()),
					Integer.valueOf(singleItem.get("quantity").toString()),
					Float.valueOf(singleItem.get("discountPercent").toString()),
					Integer.valueOf(singleItem.get("availableQuantity").toString()));
			itemRepository.save(anItem);
		}

		itemRepository.findAll().forEach(System.out::println);
	}

	@Bean
	CommandLineRunner init(ItemRepository itemRepository) throws IOException, ParseException {

		importItems(itemRepository);

		return null;
	}
}
