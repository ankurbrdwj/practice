package com.ankur.interview.labyak;

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.File;
import java.util.List;
import java.util.Scanner;

/*
 * / The Main YakShop class
 */
public class YakShop {

	public double getTotalMilk(List<Labyak> yaks, int days) {
		double milk = 0;
		for (int i = 0; i < (days); i++) {
			for (int j = 0; j < yaks.size(); j++) {
				double day = yaks.get(j).getAge() * 100 + i;
				milk += 50 - (day * 0.03);
			}
		}
		return milk;
	}

	public int getTotalSkins(List<Labyak> yaks, int days) {
		int skins = yaks.size();

		for (int j = 0; j < yaks.size(); j++) {
			double day = yaks.get(j).getAge() * 100 + days;
			if (days - 1 > (8 + day / 100)) {
				skins++;
			}
		}
		return skins;
	}

	public void displayShop(List<Labyak> yaks, int days) {
		double milk = getTotalMilk(yaks, days);
		int skin = getTotalSkins(yaks, days);
		System.out.println("In Stock");
		System.out.format("%.3f  litres of milk", milk);
		System.out.println();
		System.out.println(skin + " skins of wool");
		System.out.println("Herd:");
		for (Labyak yak : yaks) {
			System.out.format("%s %.2f years old", yak.getName(), yak.getAge() + days * 0.01);
			System.out.println();
		}

	}

	public static void main(String... args) {
		try {
			Scanner scan = new Scanner(System.in);
			//User Input for Number of Days 
			System.out.println("Enter No of days T= : ");
			int T = Integer.parseInt(scan.nextLine());
			System.out.println();
			SAXParserFactory factory = SAXParserFactory.newInstance();
			SAXParser saxParser = factory.newSAXParser();
			MyHandler handler = new MyHandler();
			//User Input
			//saxParser.parse(new File("filepath"), handler);
			//Default
			saxParser.parse(new File("input.xml"), handler);
			List<Labyak> yakList = handler.getYaklist();
			YakShop shop = new YakShop();
			shop.displayShop(yakList, T);
		} catch (Exception e) {
			e.printStackTrace();
		}

	}
}
