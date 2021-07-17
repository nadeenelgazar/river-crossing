package saving;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import Actors.ActorFactory;
import Actors.Carnivorous;
import Actors.Farmer;
import Actors.Herbivorous;
import Actors.ICrosser;
import Actors.Plant;
import LevelCreater.ICrossingStrategy;
import LevelCreater.Level1;
import LevelCreater.Level2;

public class FileReaderUtils {
	private List<ICrosser> CrossersOnRightBank = new ArrayList<ICrosser>();
	private List<ICrosser> CrossersOnLeftBank = new ArrayList<ICrosser>();
	private ICrossingStrategy gameStrategy;
	private boolean isBoatOnTheLeftBank;
	private int numberOfSails;
	private ActorFactory actorFactory;
	Plant plant = Plant.getInstance();
	Farmer farmer = new Farmer();
	Farmer farmer2 = new Farmer();
	Farmer farmer3 = new Farmer();
	Farmer farmer4 = new Farmer();
	Carnivorous wolf = new Carnivorous();
	Herbivorous goat = new Herbivorous();

	public List<ICrosser> getCrossersOnRightBank() {
		return CrossersOnRightBank;
	}

	public List<ICrosser> getCrossersOnLeftBank() {
		return CrossersOnLeftBank;
	}

	public ICrossingStrategy getGameStrategy() {
		return gameStrategy;
	}

	public boolean getisBoatOnTheLeftBank() {
		return isBoatOnTheLeftBank;
	}

	public int getNumberOfSails() {
		return numberOfSails;
	}

	public void read() {

		try {

			File fXmlFile = new File("crossers.xml");

			DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
			DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
			Document doc = dBuilder.parse(fXmlFile);

			doc.getDocumentElement().normalize();

			if (doc.getDocumentElement().getNodeName().equalsIgnoreCase("level1")) {
				gameStrategy = new Level1();

				NodeList nList = doc.getElementsByTagName("crossersOnRightBank");
				Node nNode = nList.item(0);

				if (nNode.getNodeType() == Node.ELEMENT_NODE) {

					Element eElement = (Element) nNode;

					String str[] = eElement.getTextContent().split("\\r?\\n");
					for (int temp = 0; temp < str.length; temp++) {

						if (str[temp].equalsIgnoreCase("0"))
							CrossersOnRightBank.add(plant);
						else if (str[temp].equalsIgnoreCase("1"))
							CrossersOnRightBank.add(goat);
						else if (str[temp].equalsIgnoreCase("2"))
							CrossersOnRightBank.add(wolf);

						else if (str[temp].equalsIgnoreCase("5"))
							CrossersOnRightBank.add(farmer);

					}

				}
				NodeList nList2 = doc.getElementsByTagName("crossersOnLeftBank");
				Node nNode2 = nList2.item(0);
				if (nNode2.getNodeType() == Node.ELEMENT_NODE) {

					Element eElement = (Element) nNode2;

					String str[] = eElement.getTextContent().split("\\r?\\n");
					for (int temp = 0; temp < str.length; temp++) {

						if (str[temp].equalsIgnoreCase("0"))
							CrossersOnLeftBank.add(plant);
						else if (str[temp].equalsIgnoreCase("1"))
							CrossersOnLeftBank.add(goat);
						else if (str[temp].equalsIgnoreCase("2"))
							CrossersOnLeftBank.add(wolf);

						else if (str[temp].equalsIgnoreCase("5"))
							CrossersOnLeftBank.add(farmer);

					}

				}
				NodeList nList3 = doc.getElementsByTagName("isBoatOnTheLeftBank");
				Node nNode3 = nList3.item(0);
				if (nNode3.getNodeType() == Node.ELEMENT_NODE) {

					Element eElement = (Element) nNode3;
					String str[] = eElement.getTextContent().split("\\r?\\n");
					for (int temp = 0; temp < str.length; temp++) {

						if (str[temp].equalsIgnoreCase("true"))
							isBoatOnTheLeftBank = true;
						else
							isBoatOnTheLeftBank = false;
					}
				}
				NodeList nList4 = doc.getElementsByTagName("numberOfSails");
				Node nNode4 = nList4.item(0);
				if (nNode4.getNodeType() == Node.ELEMENT_NODE) {

					Element eElement = (Element) nNode4;
					String str[] = eElement.getTextContent().split("\\r?\\n");
					numberOfSails = Integer.parseInt(str[1]);

				}
			} else {
				gameStrategy = new Level2();

				NodeList nList = doc.getElementsByTagName("crossersOnRightBank");
				Node nNode = nList.item(0);

				System.out.println("\nCurrent Element :" + nNode.getNodeName());

				if (nNode.getNodeType() == Node.ELEMENT_NODE) {

					Element eElement = (Element) nNode;

					System.out.println(eElement.getTextContent());
					String str[] = eElement.getTextContent().split("\\r?\\n");
					for (int temp = 0; temp < str.length; temp++) {

						if (str[temp].equalsIgnoreCase("90.0")) {
							System.out.println(45454);
							farmer.setWeight(90);
							CrossersOnRightBank.add(farmer);
						} else if (str[temp].equalsIgnoreCase("80.0")) {
							farmer2.setWeight(80);
							CrossersOnRightBank.add(farmer2);
						}

						else if (str[temp].equalsIgnoreCase("60.0")) {
							farmer3.setWeight(60);
							CrossersOnRightBank.add(farmer3);
						} else if (str[temp].equalsIgnoreCase("40.0")) {
							farmer4.setWeight(40);
							CrossersOnRightBank.add(farmer4);
						} else if (str[temp].equalsIgnoreCase("20.0")) {
							goat.setWeight(20);
							CrossersOnRightBank.add(goat);

						}

					}

				}
				NodeList nList2 = doc.getElementsByTagName("crossersOnLeftBank");
				Node nNode2 = nList2.item(0);

				System.out.println("\nCurrent Element :" + nNode2.getNodeName());

				if (nNode2.getNodeType() == Node.ELEMENT_NODE) {

					Element eElement = (Element) nNode2;

					System.out.println(eElement.getTextContent());
					String str[] = eElement.getTextContent().split("\\r?\\n");
					for (int temp = 0; temp < str.length; temp++) {

						if (str[temp].equalsIgnoreCase("90.0")) {
							farmer.setWeight(90);
							CrossersOnLeftBank.add(farmer);
						} else if (str[temp].equalsIgnoreCase("80.0")) {
							farmer2.setWeight(80);
							CrossersOnLeftBank.add(farmer2);
						}

						else if (str[temp].equalsIgnoreCase("60.0")) {
							farmer3.setWeight(60);
							CrossersOnLeftBank.add(farmer3);
						} else if (str[temp].equalsIgnoreCase("40.0")) {
							farmer4.setWeight(40);
							CrossersOnLeftBank.add(farmer4);
						} else if (str[temp].equalsIgnoreCase("20.0")) {
							goat.setWeight(20);
							CrossersOnLeftBank.add(goat);

						}

					}

				}
				NodeList nList3 = doc.getElementsByTagName("isBoatOnTheLeftBank");
				Node nNode3 = nList3.item(0);
				if (nNode3.getNodeType() == Node.ELEMENT_NODE) {

					Element eElement = (Element) nNode3;
					String str[] = eElement.getTextContent().split("\\r?\\n");
					for (int temp = 0; temp < str.length; temp++) {

						if (str[temp].equalsIgnoreCase("true"))
							isBoatOnTheLeftBank = true;
						else
							isBoatOnTheLeftBank = false;
					}
				}
				NodeList nList4 = doc.getElementsByTagName("numberOfSails");
				Node nNode4 = nList4.item(0);
				if (nNode4.getNodeType() == Node.ELEMENT_NODE) {

					Element eElement = (Element) nNode4;
					String str[] = eElement.getTextContent().split("\\r?\\n");
					numberOfSails = Integer.parseInt(str[1]);

				}
			}
		} catch (Exception e) {
			System.out.println("fff");
		}
	}

}
