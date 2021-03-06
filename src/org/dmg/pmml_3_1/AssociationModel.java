//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, vhudson-jaxb-ri-2.2-147 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2010.10.11 at 02:01:32 PM EEST 
//


package org.dmg.pmml_3_1;

import java.math.BigDecimal;
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
 *         &lt;element ref="{http://www.dmg.org/PMML-3_1}ModelStats" minOccurs="0"/>
 *         &lt;element ref="{http://www.dmg.org/PMML-3_1}LocalTransformations" minOccurs="0"/>
 *         &lt;element ref="{http://www.dmg.org/PMML-3_1}Item" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;choice maxOccurs="unbounded" minOccurs="0">
 *           &lt;element ref="{http://www.dmg.org/PMML-3_1}Itemset"/>
 *           &lt;element ref="{http://www.dmg.org/PMML-3_1}AssociationRule"/>
 *         &lt;/choice>
 *         &lt;element ref="{http://www.dmg.org/PMML-3_1}Extension" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *       &lt;attribute name="modelName" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="functionName" use="required" type="{http://www.dmg.org/PMML-3_1}MINING-FUNCTION" />
 *       &lt;attribute name="algorithmName" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="numberOfTransactions" use="required" type="{http://www.dmg.org/PMML-3_1}INT-NUMBER" />
 *       &lt;attribute name="maxNumberOfItemsPerTA" type="{http://www.dmg.org/PMML-3_1}INT-NUMBER" />
 *       &lt;attribute name="avgNumberOfItemsPerTA" type="{http://www.dmg.org/PMML-3_1}REAL-NUMBER" />
 *       &lt;attribute name="minimumSupport" use="required" type="{http://www.dmg.org/PMML-3_1}PROB-NUMBER" />
 *       &lt;attribute name="minimumConfidence" use="required" type="{http://www.dmg.org/PMML-3_1}PROB-NUMBER" />
 *       &lt;attribute name="lengthLimit" type="{http://www.dmg.org/PMML-3_1}INT-NUMBER" />
 *       &lt;attribute name="numberOfItems" use="required" type="{http://www.dmg.org/PMML-3_1}INT-NUMBER" />
 *       &lt;attribute name="numberOfItemsets" use="required" type="{http://www.dmg.org/PMML-3_1}INT-NUMBER" />
 *       &lt;attribute name="numberOfRules" use="required" type="{http://www.dmg.org/PMML-3_1}INT-NUMBER" />
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
@XmlRootElement(name = "AssociationModel")
public class AssociationModel {

    @XmlElementRefs({
        @XmlElementRef(name = "Itemset", namespace = "http://www.dmg.org/PMML-3_1", type = Itemset.class, required = false),
        @XmlElementRef(name = "LocalTransformations", namespace = "http://www.dmg.org/PMML-3_1", type = LocalTransformations.class, required = false),
        @XmlElementRef(name = "Extension", namespace = "http://www.dmg.org/PMML-3_1", type = Extension.class, required = false),
        @XmlElementRef(name = "Item", namespace = "http://www.dmg.org/PMML-3_1", type = Item.class, required = false),
        @XmlElementRef(name = "MiningSchema", namespace = "http://www.dmg.org/PMML-3_1", type = MiningSchema.class, required = false),
        @XmlElementRef(name = "ModelStats", namespace = "http://www.dmg.org/PMML-3_1", type = ModelStats.class, required = false),
        @XmlElementRef(name = "AssociationRule", namespace = "http://www.dmg.org/PMML-3_1", type = AssociationRule.class, required = false)
    })
    protected List<Object> content;
    @XmlAttribute(name = "modelName")
    protected String modelName;
    @XmlAttribute(name = "functionName", required = true)
    protected MiningFunction functionName;
    @XmlAttribute(name = "algorithmName")
    protected String algorithmName;
    @XmlAttribute(name = "numberOfTransactions", required = true)
    protected BigInteger numberOfTransactions;
    @XmlAttribute(name = "maxNumberOfItemsPerTA")
    protected BigInteger maxNumberOfItemsPerTA;
    @XmlAttribute(name = "avgNumberOfItemsPerTA")
    protected Double avgNumberOfItemsPerTA;
    @XmlAttribute(name = "minimumSupport", required = true)
    protected BigDecimal minimumSupport;
    @XmlAttribute(name = "minimumConfidence", required = true)
    protected BigDecimal minimumConfidence;
    @XmlAttribute(name = "lengthLimit")
    protected BigInteger lengthLimit;
    @XmlAttribute(name = "numberOfItems", required = true)
    protected BigInteger numberOfItems;
    @XmlAttribute(name = "numberOfItemsets", required = true)
    protected BigInteger numberOfItemsets;
    @XmlAttribute(name = "numberOfRules", required = true)
    protected BigInteger numberOfRules;

    /**
     * Gets the rest of the content model. 
     * 
     * <p>
     * You are getting this "catch-all" property because of the following reason: 
     * The field name "Extension" is used by two different parts of a schema. See: 
     * line 1150 of file:/D:/Work/workspace/PMMLAnalizer/xml-resources/jaxb/PMML_3_1/pmml-3-1.xsd
     * line 1141 of file:/D:/Work/workspace/PMMLAnalizer/xml-resources/jaxb/PMML_3_1/pmml-3-1.xsd
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
     * {@link Itemset }
     * {@link LocalTransformations }
     * {@link Extension }
     * {@link Item }
     * {@link MiningSchema }
     * {@link ModelStats }
     * {@link AssociationRule }
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
     * Gets the value of the numberOfTransactions property.
     * 
     * @return
     *     possible object is
     *     {@link BigInteger }
     *     
     */
    public BigInteger getNumberOfTransactions() {
        return numberOfTransactions;
    }

    /**
     * Sets the value of the numberOfTransactions property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigInteger }
     *     
     */
    public void setNumberOfTransactions(BigInteger value) {
        this.numberOfTransactions = value;
    }

    /**
     * Gets the value of the maxNumberOfItemsPerTA property.
     * 
     * @return
     *     possible object is
     *     {@link BigInteger }
     *     
     */
    public BigInteger getMaxNumberOfItemsPerTA() {
        return maxNumberOfItemsPerTA;
    }

    /**
     * Sets the value of the maxNumberOfItemsPerTA property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigInteger }
     *     
     */
    public void setMaxNumberOfItemsPerTA(BigInteger value) {
        this.maxNumberOfItemsPerTA = value;
    }

    /**
     * Gets the value of the avgNumberOfItemsPerTA property.
     * 
     * @return
     *     possible object is
     *     {@link Double }
     *     
     */
    public Double getAvgNumberOfItemsPerTA() {
        return avgNumberOfItemsPerTA;
    }

    /**
     * Sets the value of the avgNumberOfItemsPerTA property.
     * 
     * @param value
     *     allowed object is
     *     {@link Double }
     *     
     */
    public void setAvgNumberOfItemsPerTA(Double value) {
        this.avgNumberOfItemsPerTA = value;
    }

    /**
     * Gets the value of the minimumSupport property.
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getMinimumSupport() {
        return minimumSupport;
    }

    /**
     * Sets the value of the minimumSupport property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setMinimumSupport(BigDecimal value) {
        this.minimumSupport = value;
    }

    /**
     * Gets the value of the minimumConfidence property.
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getMinimumConfidence() {
        return minimumConfidence;
    }

    /**
     * Sets the value of the minimumConfidence property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setMinimumConfidence(BigDecimal value) {
        this.minimumConfidence = value;
    }

    /**
     * Gets the value of the lengthLimit property.
     * 
     * @return
     *     possible object is
     *     {@link BigInteger }
     *     
     */
    public BigInteger getLengthLimit() {
        return lengthLimit;
    }

    /**
     * Sets the value of the lengthLimit property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigInteger }
     *     
     */
    public void setLengthLimit(BigInteger value) {
        this.lengthLimit = value;
    }

    /**
     * Gets the value of the numberOfItems property.
     * 
     * @return
     *     possible object is
     *     {@link BigInteger }
     *     
     */
    public BigInteger getNumberOfItems() {
        return numberOfItems;
    }

    /**
     * Sets the value of the numberOfItems property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigInteger }
     *     
     */
    public void setNumberOfItems(BigInteger value) {
        this.numberOfItems = value;
    }

    /**
     * Gets the value of the numberOfItemsets property.
     * 
     * @return
     *     possible object is
     *     {@link BigInteger }
     *     
     */
    public BigInteger getNumberOfItemsets() {
        return numberOfItemsets;
    }

    /**
     * Sets the value of the numberOfItemsets property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigInteger }
     *     
     */
    public void setNumberOfItemsets(BigInteger value) {
        this.numberOfItemsets = value;
    }

    /**
     * Gets the value of the numberOfRules property.
     * 
     * @return
     *     possible object is
     *     {@link BigInteger }
     *     
     */
    public BigInteger getNumberOfRules() {
        return numberOfRules;
    }

    /**
     * Sets the value of the numberOfRules property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigInteger }
     *     
     */
    public void setNumberOfRules(BigInteger value) {
        this.numberOfRules = value;
    }

}
