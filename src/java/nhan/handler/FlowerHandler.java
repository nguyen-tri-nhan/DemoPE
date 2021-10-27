/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nhan.handler;

import java.util.ArrayList;
import java.util.List;
import nhan.dto.Flower;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

/**
 *
 * @author Lenovo
 */
public class FlowerHandler extends DefaultHandler{
    private List<Flower> flowers = null;
    private Flower flower;
    private String elementValue;
    private boolean nameFlag, descFlag, quantityFlag, priceFlag;

    @Override
    public void startDocument() throws SAXException {
        flowers = new ArrayList<>();
    }

    @Override
    public void startElement(String uri, String localName, String qName, Attributes atrbts) throws SAXException {
        switch (qName) {
            case "flower":
                flower = new Flower();
                flower.setId(atrbts.getValue("id"));
                flower.setAvailable(Boolean.valueOf(atrbts.getValue("isAvailable")));
            case "season":
                flower.setSeason(atrbts.getValue("name"));
        }
    }

    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
        if (qName.equalsIgnoreCase("flower")) {
            flowers.add(flower);
        }
        
        if (qName.equalsIgnoreCase("name")) {
            flower.setName(elementValue);
        }
        
        if (qName.equalsIgnoreCase("description")) {
            flower.setDescription(elementValue);
        }
        if (qName.equalsIgnoreCase("quantity")) {
            flower.setQuantity(Integer.parseInt(elementValue));
        }
        if (qName.equalsIgnoreCase("price")) {
            flower.setPrice(Float.parseFloat(elementValue));
        }
    }

    @Override
    public void characters(char[] chars, int start, int length) throws SAXException {
        elementValue = new String(chars, start, length);
    }
    
    
    public List<Flower> getFlowers() {
        return this.flowers;
    }
    
    
    
}
