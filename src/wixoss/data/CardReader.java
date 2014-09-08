/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package wixoss.data;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;
import wixoss.business.CardControl;
import wixoss.domain.card.Card;

/**
 *
 * @author Gregor
 */
public class CardReader
{

    public CardReader()
    {

    }

    public List<Card> loadCards(String filePath, CardControl cardControl)
    {
        File input = new File(filePath);
        Document xmlTree;

        try
        {
            //Het bestand parseren in een XML DOM object.
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder xmlTreeBuilder = factory.newDocumentBuilder();
            xmlTree = xmlTreeBuilder.parse(input);
        }
        catch (ParserConfigurationException | SAXException ex)
        {
            Logger.getLogger(CardReader.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
        catch (IOException ex)
        {
            Logger.getLogger(CardReader.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }

        //Een ArrayList aanmaken waar de kaart objecten in komen.
        List<Card> cards = new ArrayList();
        //Een LinkedHashMap aanmaken waar we de gegevens tijdelijk opslaan.
        Map<String, String> cardAttributes = new LinkedHashMap();
        //Een nodelist van alle kaarten ophalen.
        NodeList cardList = xmlTree.getElementsByTagName("card");
        //Door de nodelist heen loopen.
        for (int x = 0; x < cardList.getLength(); x++)
        {
            //De LinkedHashMap resetten voor een nieuwe kaart.
            cardAttributes.clear();
            //Per kaart een nodelist van alle attribuut elementen maken.
            Node card = cardList.item(x);
            NodeList attributes = card.getChildNodes();
            //Door alle atributen heen loopen.
            for (int y = 1; y < attributes.getLength(); y++)
            {
                Node attribute = attributes.item(y);
                //Kijken of een node een echt element is of een (leeg) textnode.
                if (attribute.getNodeType() == Node.ELEMENT_NODE)
                {
                    //Als het een echt element is gaan we kijken of deze inhoud heeft, zo niet wordt er een lege string aangemaakt.
                    cardAttributes.put(attribute.getNodeName(), (attribute.getFirstChild() == null) ? "" : attribute.getFirstChild().getTextContent());
                }
            }
            //Het kaart object aanmaken en opslaan in de lijst.
            cards.add(createCardObject(cardAttributes));
        }
        return cards;
    }

    private Card createCardObject(Map<String, String> attributes)
    {
        Card card;
        switch(attributes.get("type").toLowerCase())
        {
        }
        return null;
    }
}
