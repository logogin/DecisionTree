package com.logogin.decisiontree.model;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;

import javax.xml.XMLConstants;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParserFactory;
import javax.xml.transform.sax.SAXSource;
import javax.xml.validation.Schema;
import javax.xml.validation.SchemaFactory;

import org.dmg.pmml_3_1.PMML;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;

/**
 * @created Sep 10, 2010
 * @author Pavel Danchenko
 */
public class JAXBUtil {

    public static PMML unmarshal(File file, boolean validate) throws JAXBException, SAXException, FileNotFoundException, ParserConfigurationException {
        Unmarshaller unmarshaller = JAXBContext.newInstance(PMML.class).createUnmarshaller();
        if ( validate ) {
            SchemaFactory sf = SchemaFactory.newInstance(XMLConstants.W3C_XML_SCHEMA_NS_URI);
            File schemaFile = new File("pmml-3-1.xsd");
            Schema schema = sf.newSchema(schemaFile);
            unmarshaller.setSchema(schema);
        }
        InputSource input = new InputSource(new FileReader(file));
        SAXParserFactory parserFactory = SAXParserFactory.newInstance();
        parserFactory.setNamespaceAware(true);
        parserFactory.setValidating(validate);
        XMLReader xmlReader = parserFactory.newSAXParser().getXMLReader();
        SAXSource saxSource = new SAXSource(xmlReader, input);
        PMML jaxbRootElement = ((PMML)unmarshaller.unmarshal(saxSource));
        return jaxbRootElement;
    }
}
