package com.example.Assignments;

import java.util.List;

public class Utility {
    //Func to parse a comma-separated string into an array of integers
	public static double[] parseDoubleArray(String input) {
		String[] parts = input.split(",");
		double[] arr = new double[parts.length];
		for (int i = 0; i < parts.length; i++) {
			arr[i] = Double.parseDouble(parts[i].trim());
		}
		return arr;
	}

    public static int[] parseIntArray(String input) {
        String[] parts = input.split(",");
        int[] arr = new int[parts.length];
        for (int i = 0; i < parts.length; i++) {
            arr[i] = Integer.parseInt(parts[i].trim());
        }
        return arr;
    }

    public static List<Integer> parseIntegerList(String input) {
        String[] parts = input.split(",");
        List<Integer> list = new java.util.ArrayList<>();
        for (String part : parts) {
            list.add(Integer.parseInt(part.trim()));
        }
        return list;
    }

    public static int[] parseIntArrayFromList(List<Integer> input) {
        int[] arr = new int[input.size()];
        for (int i = 0; i < input.size(); i++) {
            arr[i] = input.get(i);
        }
        return arr;
    }

    public static String[] parseStringArray(String input) {
        return input.split(":");
    }
}
