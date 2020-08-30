package pl.sda.servlets.model;

import java.util.HashMap;
import java.util.Map;

public class NamesDB {

	private static final Map<String, Integer> FEMALE_NAMES = new HashMap<>(
			Map.of("Ania",3,
					"Kasia", 2)
	);
	private static final Map<String, Integer> MALE_NAMES = new HashMap<>(
			Map.of("Adam",1,
					"Piotr", 3)
	);

	public static void addFemaleName(String name){
		if(FEMALE_NAMES.containsKey(name)){
			FEMALE_NAMES.put(name, FEMALE_NAMES.get(name) + 1);
		} else {
			FEMALE_NAMES.put(name, 1);
		}
	}
	public static void addMaleName(String name){
		if(MALE_NAMES.containsKey(name)){
			MALE_NAMES.put(name, MALE_NAMES.get(name) + 1);
		} else {
			MALE_NAMES.put(name, 1);
		}
	}

	public static Map<String, Integer> getAllFemaleNames() {
		return FEMALE_NAMES;
	}

	public static Map<String, Integer> getAllMaleNames() {
		return MALE_NAMES;
	}
}
