//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, vhudson-jaxb-ri-2.2-147 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2010.10.11 at 02:01:32 PM EEST 
//


package org.dmg.pmml_3_1;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElementRef;
import javax.xml.bind.annotation.XmlElementRefs;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for anonymous complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType>
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element ref="{http://www.dmg.org/PMML-3_1}Extension" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element ref="{http://www.dmg.org/PMML-3_1}MiningSchema"/>
 *         &lt;element ref="{http://www.dmg.org/PMML-3_1}Output" minOccurs="0"/>
 *         &lt;element ref="{http://www.dmg.org/PMML-3_1}ModelStats" minOccurs="0"/>
 *         &lt;element ref="{http://www.dmg.org/PMML-3_1}Targets" minOccurs="0"/>
 *         &lt;element ref="{http://www.dmg.org/PMML-3_1}LocalTransformations" minOccurs="0"/>
 *         &lt;element ref="{http://www.dmg.org/PMML-3_1}TextDictionary"/>
 *         &lt;element ref="{http://www.dmg.org/PMML-3_1}TextCorpus"/>
 *         &lt;element ref="{http://www.dmg.org/PMML-3_1}DocumentTermMatrix"/>
 *         &lt;element ref="{http://www.dmg.org/PMML-3_1}TextModelNormalization" minOccurs="0"/>
 *         &lt;element ref="{http://www.dmg.org/PMML-3_1}TextModelSimiliarity" minOccurs="0"/>
 *         &lt;element ref="{http://www.dmg.org/PMML-3_1}ModelVerification" minOccurs="0"/>
 *         &lt;element ref="{http://www.dmg.org/PMML-3_1}Extension" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *       &lt;attribute name="modelName" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="functionName" use="required" type="{http://www.dmg.org/PMML-3_1}MINING-FUNCTION" />
 *       &lt;attribute name="algorithmName" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="numberOfTerms" use="required" type="{http://www.w3.org/2001/XMLSchema}integer" />
 *       &lt;attribute name="numberOfDocuments" use="required" type="{http://www.w3.org/2001/XMLSchema}integer" />
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "content"
})
@XmlRootElement(name = "TextModel")
public class TextModel {

    @XmlElementRefs({
        @XmlElementRef(name = "ModelVerification", namespace = "http://www.dmg.org/PMML-3_1", type = ModelVerification.class, required = false),
        @XmlElementRef(name = "TextCorpus", namespace = "http://www.dmg.org/PMML-3_1", type = TextCorpus.class, required = false),
        @XmlElementRef(name = "LocalTransformations", namespace = "http://www.dmg.org/PMML-3_1", type = LocalTransformations.class, required = false),
        @XmlElementRef(name = "Targets", namespace = "http://www.dmg.org/PMML-3_1", type = Targets.class, required = false),
        @XmlElementRef(name = "TextDictionary", namespace = "http://www.dmg.org/PMML-3_1", type = TextDictionary.class, required = false),
        @XmlElementRef(name = "Extension", namespace = "http://www.dmg.org/PMML-3_1", type = Extension.class, required = false),
        @XmlElementRef(name = "DocumentTermMatrix", namespace = "http://www.dmg.org/PMML-3_1", type = DocumentTermMatrix.class, required = false),
        @XmlElementRef(name = "TextModelSimiliarity", namespace = "http://www.dmg.org/PMML-3_1", type = TextModelSimiliarity.class, required = false),
        @XmlElementRef(name = "MiningSchema", namespace = "http://www.dmg.org/PMML-3_1", type = MiningSchema.class, required = false),
        @XmlElementRef(name = "TextModelNormalization", namespace = "http://www.dmg.org/PMML-3_1", type = TextModelNormalization.class, required = false),
        @XmlElementRef(name = "ModelStats", namespace = "http://www.dmg.org/PMML-3_1", type = ModelStats.class, required = false),
        @XmlElementRef(name = "Output", namespace = "http://www.dmg.org/PMML-3_1", type = Output.class, required = false)
    })
    protected List<Object> content;
    @XmlAttribute(name = "modelName")
    protected String modelName;
    @XmlAttribute(name = "functionName", required = true)
    protected MiningFunction functionName;
    @XmlAttribute(name = "algorithmName")
    protected String algorithmName;
    @XmlAttribute(name = "numberOfTerms", required = true)
    protected BigInteger numberOfTerms;
    @XmlAttribute(name = "numberOfDocuments", required = true)
    protected BigInteger numberOfDocuments;

    /**
     * Gets the rest of the content model. 
     * 
     * <p>
     * You are getting this "catch-all" property because of the following reason: 
     * The field name "Extension" is used by two different parts of a schema. See: 
     * line 1695 of file:/D:/Work/workspace/PMMLAnalizer/xml-resources/jaxb/PMML_3_1/pmml-3-1.xsd
     * line 1683 of file:/D:/Work/workspace/PMMLAnalizer/xml-resources/jaxb/PMML_3_1/pmml-3-1.xsd
     * <p>
     * To get rid of this property, apply a property customization to one 
     * of both of the following declarations to change their names: 
     * Gets the value of the content property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the content property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getContent().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link ModelVerification }
     * {@link TextCorpus }
     * {@link Targets }
     * {@link LocalTransformations }
     * {@link TextDictionary }
     * {@link DocumentTermMatrix }
     * {@link Extension }
     * {@link TextModelSimiliarity }
     * {@link MiningSchema }
     * {@link TextModelNormalization }
     * {@link ModelStats }
     * {@link Output }
     * 
     * 
     */
    public List<Object> getContent() {
        if (content == null) {
            content = new ArrayList<Object>();
        }
        return this.content;
    }

    /**
     * Gets the value of the modelName property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getModelName() {
        return modelName;
    }

    /**
     * Sets the value of the modelName property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setModelName(String value) {
        this.modelName = value;
    }

    /**
     * Gets the value of the functionName property.
     * 
     * @return
     *     possible object is
     *     {@link MiningFunction }
     *     
     */
    public MiningFunction getFunctionName() {
        return functionName;
    }

    /**
     * Sets the value of the functionName property.
     * 
     * @param value
     *     allowed object is
     *     {@link MiningFunction }
     *     
     */
    public void setFunctionName(MiningFunction value) {
        this.functionName = value;
    }

    /**
     * Gets the value of the algorithmName property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAlgorithmName() {
        return algorithmName;
    }

    /**
     * Sets the value of the algorithmName property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAlgorithmName(String value) {
        this.algorithmName = value;
    }

    /**
     * Gets the value of the numberOfTerms property.
     * 
     * @return
     *     possible object is
     *     {@link BigInteger }
     *     
     */
    public BigInteger getNumberOfTerms() {
        return numberOfTerms;
    }

    /**
     * Sets the value of the numberOfTerms property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigInteger }
     *     
     */
    public void setNumberOfTerms(BigInteger value) {
        this.numberOfTerms = value;
    }

    /**
     * Gets the value of the numberOfDocuments property.
     * 
     * @return
     *     possible object is
     *     {@link BigInteger }
     *     
     */
    public BigInteger getNumberOfDocuments() {
        return numberOfDocuments;
    }

    /**
     * Sets the value of the numberOfDocuments property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigInteger }
     *     
     */
    public void setNumberOfDocuments(BigInteger value) {
        this.numberOfDocuments = value;
    }

}
