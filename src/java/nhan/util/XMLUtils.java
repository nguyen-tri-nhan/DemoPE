/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nhan.util;

import java.io.File;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.Result;
import javax.xml.transform.Source;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathFactory;
import org.w3c.dom.Document;
import org.w3c.dom.Node;

/**
 *
 * @author Lenovo
 */
public class XMLUtils {
    
    public static Document parseFileToDom(String filePath) throws Exception {
        DocumentBuilderFactory documentBuilderFactory = DocumentBuilderFactory.newInstance();
        DocumentBuilder documentBuilder = documentBuilderFactory.newDocumentBuilder();
        File file = new File(filePath);
        Document doc = documentBuilder.parse(file);
        return doc;
    }
    
    public static XPath createXPath() throws Exception {
        XPathFactory xPathFactory = XPathFactory.newInstance();
        XPath xPath = xPathFactory.newXPath();
        return xPath;
    }
    
    public static void transformDOMToResult(Node node, String filePath)
            throws Exception {
        Source source = new DOMSource(node);
        File file = new File(filePath);
        Result result = new StreamResult(file);
        TransformerFactory transformerFactory = TransformerFactory.newInstance();
        Transformer trans = transformerFactory.newTransformer();
        trans.transform(source, result);
    }
}
