package pl.sda.servlets.model;


import java.util.Set;

public class ForbiddenNamesValidator {


	private static final Set<String> FORBIDDEN_NAMES = Set.of("Dupa","Niedozwolone");

	public static boolean isForbidden(String name){
		return FORBIDDEN_NAMES.contains(name);
	}

}
