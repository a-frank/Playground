package com.arconsis.java.first;

import java.util.LinkedList;
import java.util.List;

public class JTeacher {
	private final String name;

	public JTeacher(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void teach() {
		String subject = ". Mister " + name + " is teaching";

		List<String> teachings = new LinkedList<String>();

		for (int i = 0; i <= 10; i++) {
			if (i > 5) {
				String out = i + subject;
				System.out.println(out);
				teachings.add(out);
			}
		}

		StringBuilder builder = new StringBuilder();
		for (int i = 0; i < teachings.size(); i++) {
			builder.append(teachings.get(i)).append(", ");
		}
		System.out.println(builder.toString());
	}

}
