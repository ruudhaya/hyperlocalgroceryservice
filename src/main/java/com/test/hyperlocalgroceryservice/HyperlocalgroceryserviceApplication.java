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

	@Bean
	CommandLineRunner init(ItemRepository itemRepository) throws IOException, ParseException {

		String resourceName = "items.json";

		Object obj = new JSONParser().parse(new FileReader(resourceName));
		JSONObject jo = (JSONObject) obj;
		JSONArray ja = (JSONArray) jo.get("Data");
		Iterator itr2 = ja.iterator();
		while (itr2.hasNext())
		{
			JSONObject singleItem = (JSONObject) itr2.next();
			Item anItem = new Item(singleItem.get("name").toString());
			itemRepository.save(anItem);
		}

//			Stream.of("John", "Julie", "Jennifer", "Helen", "Rachel").forEach(itemObj -> {
//				String name = ((JSONObject)itemObj).getString("name");
//
//				Item anItem = new Item(name);
//				itemRepository.save(user);
//			});

			itemRepository.findAll().forEach(System.out::println);

		return null;
	}
}
