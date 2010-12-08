//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, vhudson-jaxb-ri-2.2-147 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2010.10.11 at 02:01:32 PM EEST 
//


package org.dmg.pmml_3_1;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
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
 *         &lt;element ref="{http://www.dmg.org/PMML-3_1}LocalTransformations" minOccurs="0"/>
 *         &lt;element ref="{http://www.dmg.org/PMML-3_1}ResultField" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element ref="{http://www.dmg.org/PMML-3_1}Node"/>
 *       &lt;/sequence>
 *       &lt;attribute name="modelName" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="functionName" use="required" type="{http://www.dmg.org/PMML-3_1}MINING-FUNCTION" />
 *       &lt;attribute name="algorithmName" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="missingValueStrategy" type="{http://www.dmg.org/PMML-3_1}MISSING-VALUE-STRATEGY" default="none" />
 *       &lt;attribute name="missingValuePenalty" type="{http://www.dmg.org/PMML-3_1}PROB-NUMBER" default="1.0" />
 *       &lt;attribute name="noTrueChildStrategy" type="{http://www.dmg.org/PMML-3_1}NO-TRUE-CHILD-STRATEGY" default="returnNullPrediction" />
 *       &lt;attribute name="splitCharacteristic" default="multiSplit">
 *         &lt;simpleType>
 *           &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *             &lt;enumeration value="binarySplit"/>
 *             &lt;enumeration value="multiSplit"/>
 *           &lt;/restriction>
 *         &lt;/simpleType>
 *       &lt;/attribute>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "extension",
    "localTransformations",
    "resultField",
    "node"
})
@XmlRootElement(name = "DecisionTree")
public class DecisionTree {

    @XmlElement(name = "Extension")
    protected List<Extension> extension;
    @XmlElement(name = "LocalTransformations")
    protected LocalTransformations localTransformations;
    @XmlElement(name = "ResultField")
    protected List<ResultField> resultField;
    @XmlElement(name = "Node", required = true)
    protected Node node;
    @XmlAttribute(name = "modelName")
    protected String modelName;
    @XmlAttribute(name = "functionName", required = true)
    protected MiningFunction functionName;
    @XmlAttribute(name = "algorithmName")
    protected String algorithmName;
    @XmlAttribute(name = "missingValueStrategy")
    protected MissingValueStrategy missingValueStrategy;
    @XmlAttribute(name = "missingValuePenalty")
    protected BigDecimal missingValuePenalty;
    @XmlAttribute(name = "noTrueChildStrategy")
    protected NoTrueChildStrategy noTrueChildStrategy;
    @XmlAttribute(name = "splitCharacteristic")
    protected DecisionTree.SplitCharacteristic splitCharacteristic;

    /**
     * Gets the value of the extension property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the extension property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getExtension().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link Extension }
     * 
     * 
     */
    public List<Extension> getExtension() {
        if (extension == null) {
            extension = new ArrayList<Extension>();
        }
        return this.extension;
    }

    /**
     * Gets the value of the localTransformations property.
     * 
     * @return
     *     possible object is
     *     {@link LocalTransformations }
     *     
     */
    public LocalTransformations getLocalTransformations() {
        return localTransformations;
    }

    /**
     * Sets the value of the localTransformations property.
     * 
     * @param value
     *     allowed object is
     *     {@link LocalTransformations }
     *     
     */
    public void setLocalTransformations(LocalTransformations value) {
        this.localTransformations = value;
    }

    /**
     * Gets the value of the resultField property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the resultField property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getResultField().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link ResultField }
     * 
     * 
     */
    public List<ResultField> getResultField() {
        if (resultField == null) {
            resultField = new ArrayList<ResultField>();
        }
        return this.resultField;
    }

    /**
     * Gets the value of the node property.
     * 
     * @return
     *     possible object is
     *     {@link Node }
     *     
     */
    public Node getNode() {
        return node;
    }

    /**
     * Sets the value of the node property.
     * 
     * @param value
     *     allowed object is
     *     {@link Node }
     *     
     */
    public void setNode(Node value) {
        this.node = value;
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
     * Gets the value of the missingValueStrategy property.
     * 
     * @return
     *     possible object is
     *     {@link MissingValueStrategy }
     *     
     */
    public MissingValueStrategy getMissingValueStrategy() {
        if (missingValueStrategy == null) {
            return MissingValueStrategy.NONE;
        } else {
            return missingValueStrategy;
        }
    }

    /**
     * Sets the value of the missingValueStrategy property.
     * 
     * @param value
     *     allowed object is
     *     {@link MissingValueStrategy }
     *     
     */
    public void setMissingValueStrategy(MissingValueStrategy value) {
        this.missingValueStrategy = value;
    }

    /**
     * Gets the value of the missingValuePenalty property.
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getMissingValuePenalty() {
        if (missingValuePenalty == null) {
            return new BigDecimal("1.0");
        } else {
            return missingValuePenalty;
        }
    }

    /**
     * Sets the value of the missingValuePenalty property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setMissingValuePenalty(BigDecimal value) {
        this.missingValuePenalty = value;
    }

    /**
     * Gets the value of the noTrueChildStrategy property.
     * 
     * @return
     *     possible object is
     *     {@link NoTrueChildStrategy }
     *     
     */
    public NoTrueChildStrategy getNoTrueChildStrategy() {
        if (noTrueChildStrategy == null) {
            return NoTrueChildStrategy.RETURN_NULL_PREDICTION;
        } else {
            return noTrueChildStrategy;
        }
    }

    /**
     * Sets the value of the noTrueChildStrategy property.
     * 
     * @param value
     *     allowed object is
     *     {@link NoTrueChildStrategy }
     *     
     */
    public void setNoTrueChildStrategy(NoTrueChildStrategy value) {
        this.noTrueChildStrategy = value;
    }

    /**
     * Gets the value of the splitCharacteristic property.
     * 
     * @return
     *     possible object is
     *     {@link DecisionTree.SplitCharacteristic }
     *     
     */
    public DecisionTree.SplitCharacteristic getSplitCharacteristic() {
        if (splitCharacteristic == null) {
            return DecisionTree.SplitCharacteristic.MULTI_SPLIT;
        } else {
            return splitCharacteristic;
        }
    }

    /**
     * Sets the value of the splitCharacteristic property.
     * 
     * @param value
     *     allowed object is
     *     {@link DecisionTree.SplitCharacteristic }
     *     
     */
    public void setSplitCharacteristic(DecisionTree.SplitCharacteristic value) {
        this.splitCharacteristic = value;
    }


    /**
     * <p>Java class for null.
     * 
     * <p>The following schema fragment specifies the expected content contained within this class.
     * <p>
     * <pre>
     * &lt;simpleType>
     *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
     *     &lt;enumeration value="binarySplit"/>
     *     &lt;enumeration value="multiSplit"/>
     *   &lt;/restriction>
     * &lt;/simpleType>
     * </pre>
     * 
     */
    @XmlType(name = "")
    @XmlEnum
    public enum SplitCharacteristic {

        @XmlEnumValue("binarySplit")
        BINARY_SPLIT("binarySplit"),
        @XmlEnumValue("multiSplit")
        MULTI_SPLIT("multiSplit");
        private final String value;

        SplitCharacteristic(String v) {
            value = v;
        }

        public String value() {
            return value;
        }

        public static DecisionTree.SplitCharacteristic fromValue(String v) {
            for (DecisionTree.SplitCharacteristic c: DecisionTree.SplitCharacteristic.values()) {
                if (c.value.equals(v)) {
                    return c;
                }
            }
            throw new IllegalArgumentException(v);
        }

    }

}
