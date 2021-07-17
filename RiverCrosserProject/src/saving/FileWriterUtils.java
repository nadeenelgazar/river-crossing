package saving;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.omg.CosNaming.IstringHelper;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;

import Actors.Farmer;
import Actors.Herbivorous;
import Actors.ICrosser;
import Actors.Plant;
import LevelCreater.ICrossingStrategy;
import LevelCreater.Level1;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;

public class FileWriterUtils{
	private List<ICrosser> CrossersOnRightBank = new ArrayList<ICrosser>();
	private List<ICrosser> CrossersOnLeftBank = new ArrayList<ICrosser>();
	private ICrossingStrategy gameStrategy;
	private boolean isBoatOnTheLeftBank;
	private int numberOfSails ;
	private String level;
	public void setCrossersOnRightBank(List<ICrosser> crossersOnRightBank) {
		CrossersOnRightBank = crossersOnRightBank;
	}

	public void setCrossersOnLeftBank(List<ICrosser> crossersOnLeftBank) {
		CrossersOnLeftBank = crossersOnLeftBank;
	}


	public void setGameStrategy(ICrossingStrategy gameStrategy) {
		this.gameStrategy = gameStrategy;
		if(this.gameStrategy instanceof Level1)
			level = "level1";
		else 
			level = "level2";
	}

	public void setBoatOnTheLeftBank(boolean isBoatOnTheLeftBank) {
		this.isBoatOnTheLeftBank = isBoatOnTheLeftBank;
	}

	public void setNumberOfSails(int numberOfSails) {
		this.numberOfSails = numberOfSails;
	}

	
	static Element rootElement ;
	static Document doc;

    public void write () {
    	
     
    	DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
        DocumentBuilder dBuilder;
       
       
        
        try {
            
        	dBuilder = dbFactory.newDocumentBuilder();
            Document doc = dBuilder.newDocument();
            
            if(level.equalsIgnoreCase("level1")) {
            
            Element rootElement = doc.createElement(level);
            doc.appendChild(rootElement);
            
            Element crosser = doc.createElement("crossersOnRightBank");
        crosser.appendChild(doc.createTextNode("\n"));

            rootElement.appendChild(crosser);
            for(int i = 0 ; i < CrossersOnRightBank.size(); i++ ) {
            	crosser.appendChild(doc.createTextNode(Integer.toString( CrossersOnRightBank.get(i).getEatingRank())));
              	 crosser.appendChild(doc.createTextNode("\n"));
            }
       
            
            crosser = doc.createElement("crossersOnLeftBank");
          	 crosser.appendChild(doc.createTextNode("\n"));
          	 rootElement.appendChild(crosser);
               for(int i = 0 ; i < CrossersOnLeftBank.size(); i++ ) {
               	 crosser.appendChild(doc.createTextNode(Integer.toString( CrossersOnLeftBank.get(i).getEatingRank())));
               	 crosser.appendChild(doc.createTextNode("\n"));
               }
               
               crosser = doc.createElement("isBoatOnTheLeftBank");
             	 crosser.appendChild(doc.createTextNode("\n"));
               	 crosser.appendChild(doc.createTextNode(Boolean.toString(isBoatOnTheLeftBank)));
             	 crosser.appendChild(doc.createTextNode("\n"));
             	 rootElement.appendChild(crosser);
            
             	 
             	   crosser = doc.createElement("numberOfSails");
               	 crosser.appendChild(doc.createTextNode("\n"));
                 	 crosser.appendChild(doc.createTextNode(Integer.toString(numberOfSails)));
               	 crosser.appendChild(doc.createTextNode("\n"));
               	 rootElement.appendChild(crosser); 	 
           
           
}
            else
            {
            	   Element rootElement = doc.createElement(level);
                   doc.appendChild(rootElement);
                   
                   Element crosser = doc.createElement("crossersOnRightBank");
              	 crosser.appendChild(doc.createTextNode("\n"));
              	 rootElement.appendChild(crosser);
                 for(int i = 0 ; i < CrossersOnRightBank.size(); i++ ) {
                 	 crosser.appendChild(doc.createTextNode(Double.toString( CrossersOnRightBank.get(i).getweight())));
                 	 crosser.appendChild(doc.createTextNode("\n"));
                 }
                 
                 crosser = doc.createElement("crossersOnLeftBank");
              	 crosser.appendChild(doc.createTextNode("\n"));
              	 rootElement.appendChild(crosser);
                   for(int i = 0 ; i < CrossersOnLeftBank.size(); i++ ) {
                   	 crosser.appendChild(doc.createTextNode(Double.toString( CrossersOnLeftBank.get(i).getweight())));
                   	 crosser.appendChild(doc.createTextNode("\n"));
                   }
                   crosser = doc.createElement("isBoatOnTheLeftBank");
               	 crosser.appendChild(doc.createTextNode("\n"));
                 	 crosser.appendChild(doc.createTextNode(Boolean.toString(isBoatOnTheLeftBank)));
               	 crosser.appendChild(doc.createTextNode("\n"));
               	 rootElement.appendChild(crosser);
              
               	 
               	   crosser = doc.createElement("numberOfSails");
                 	 crosser.appendChild(doc.createTextNode("\n"));
                   	 crosser.appendChild(doc.createTextNode(Integer.toString(numberOfSails)));
                 	 crosser.appendChild(doc.createTextNode("\n"));
                 	 rootElement.appendChild(crosser); 	
              	 
            }
           
            //for output to file, console
            TransformerFactory transformerFactory = TransformerFactory.newInstance();
            Transformer transformer = transformerFactory.newTransformer();
            
            //for pretty print
            transformer.setOutputProperty(OutputKeys.INDENT, "yes");
            DOMSource source = new DOMSource(doc);

            //write to console or file
            StreamResult console = new StreamResult(System.out);
            StreamResult file = new StreamResult(new File("crossers.xml"));

            //write data
            transformer.transform(source, console);
            transformer.transform(source, file);
            System.out.println("DONE");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }


}