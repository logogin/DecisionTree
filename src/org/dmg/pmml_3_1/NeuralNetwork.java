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
import javax.xml.bind.annotation.XmlSchemaType;
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
 *         &lt;element ref="{http://www.dmg.org/PMML-3_1}NeuralInputs"/>
 *         &lt;element ref="{http://www.dmg.org/PMML-3_1}NeuralLayer" maxOccurs="unbounded"/>
 *         &lt;element ref="{http://www.dmg.org/PMML-3_1}NeuralOutputs" minOccurs="0"/>
 *         &lt;element ref="{http://www.dmg.org/PMML-3_1}ModelVerification" minOccurs="0"/>
 *         &lt;element ref="{http://www.dmg.org/PMML-3_1}Extension" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *       &lt;attribute name="modelName" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="functionName" use="required" type="{http://www.dmg.org/PMML-3_1}MINING-FUNCTION" />
 *       &lt;attribute name="algorithmName" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="activationFunction" use="required" type="{http://www.dmg.org/PMML-3_1}ACTIVATION-FUNCTION" />
 *       &lt;attribute name="normalizationMethod" type="{http://www.dmg.org/PMML-3_1}NN-NORMALIZATION-METHOD" default="none" />
 *       &lt;attribute name="threshold" type="{http://www.dmg.org/PMML-3_1}REAL-NUMBER" default="0" />
 *       &lt;attribute name="width" type="{http://www.dmg.org/PMML-3_1}REAL-NUMBER" />
 *       &lt;attribute name="altitude" type="{http://www.dmg.org/PMML-3_1}REAL-NUMBER" default="1.0" />
 *       &lt;attribute name="numberOfLayers" type="{http://www.w3.org/2001/XMLSchema}nonNegativeInteger" />
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
@XmlRootElement(name = "NeuralNetwork")
public class NeuralNetwork {

    @XmlElementRefs({
        @XmlElementRef(name = "NeuralLayer", namespace = "http://www.dmg.org/PMML-3_1", type = NeuralLayer.class, required = false),
        @XmlElementRef(name = "NeuralInputs", namespace = "http://www.dmg.org/PMML-3_1", type = NeuralInputs.class, required = false),
        @XmlElementRef(name = "ModelVerification", namespace = "http://www.dmg.org/PMML-3_1", type = ModelVerification.class, required = false),
        @XmlElementRef(name = "Targets", namespace = "http://www.dmg.org/PMML-3_1", type = Targets.class, required = false),
        @XmlElementRef(name = "LocalTransformations", namespace = "http://www.dmg.org/PMML-3_1", type = LocalTransformations.class, required = false),
        @XmlElementRef(name = "NeuralOutputs", namespace = "http://www.dmg.org/PMML-3_1", type = NeuralOutputs.class, required = false),
        @XmlElementRef(name = "Extension", namespace = "http://www.dmg.org/PMML-3_1", type = Extension.class, required = false),
        @XmlElementRef(name = "MiningSchema", namespace = "http://www.dmg.org/PMML-3_1", type = MiningSchema.class, required = false),
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
    @XmlAttribute(name = "activationFunction", required = true)
    protected ActivationFunction activationFunction;
    @XmlAttribute(name = "normalizationMethod")
    protected NnNormalizationMethod normalizationMethod;
    @XmlAttribute(name = "threshold")
    protected Double threshold;
    @XmlAttribute(name = "width")
    protected Double width;
    @XmlAttribute(name = "altitude")
    protected Double altitude;
    @XmlAttribute(name = "numberOfLayers")
    @XmlSchemaType(name = "nonNegativeInteger")
    protected BigInteger numberOfLayers;

    /**
     * Gets the rest of the content model. 
     * 
     * <p>
     * You are getting this "catch-all" property because of the following reason: 
     * The field name "Extension" is used by two different parts of a schema. See: 
     * line 819 of file:/D:/Work/workspace/PMMLAnalizer/xml-resources/jaxb/PMML_3_1/pmml-3-1.xsd
     * line 809 of file:/D:/Work/workspace/PMMLAnalizer/xml-resources/jaxb/PMML_3_1/pmml-3-1.xsd
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
     * {@link NeuralLayer }
     * {@link ModelVerification }
     * {@link NeuralInputs }
     * {@link NeuralOutputs }
     * {@link LocalTransformations }
     * {@link Targets }
     * {@link Extension }
     * {@link MiningSchema }
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
     * Gets the value of the activationFunction property.
     * 
     * @return
     *     possible object is
     *     {@link ActivationFunction }
     *     
     */
    public ActivationFunction getActivationFunction() {
        return activationFunction;
    }

    /**
     * Sets the value of the activationFunction property.
     * 
     * @param value
     *     allowed object is
     *     {@link ActivationFunction }
     *     
     */
    public void setActivationFunction(ActivationFunction value) {
        this.activationFunction = value;
    }

    /**
     * Gets the value of the normalizationMethod property.
     * 
     * @return
     *     possible object is
     *     {@link NnNormalizationMethod }
     *     
     */
    public NnNormalizationMethod getNormalizationMethod() {
        if (normalizationMethod == null) {
            return NnNormalizationMethod.NONE;
        } else {
            return normalizationMethod;
        }
    }

    /**
     * Sets the value of the normalizationMethod property.
     * 
     * @param value
     *     allowed object is
     *     {@link NnNormalizationMethod }
     *     
     */
    public void setNormalizationMethod(NnNormalizationMethod value) {
        this.normalizationMethod = value;
    }

    /**
     * Gets the value of the threshold property.
     * 
     * @return
     *     possible object is
     *     {@link Double }
     *     
     */
    public double getThreshold() {
        if (threshold == null) {
            return  0.0D;
        } else {
            return threshold;
        }
    }

    /**
     * Sets the value of the threshold property.
     * 
     * @param value
     *     allowed object is
     *     {@link Double }
     *     
     */
    public void setThreshold(Double value) {
        this.threshold = value;
    }

    /**
     * Gets the value of the width property.
     * 
     * @return
     *     possible object is
     *     {@link Double }
     *     
     */
    public Double getWidth() {
        return width;
    }

    /**
     * Sets the value of the width property.
     * 
     * @param value
     *     allowed object is
     *     {@link Double }
     *     
     */
    public void setWidth(Double value) {
        this.width = value;
    }

    /**
     * Gets the value of the altitude property.
     * 
     * @return
     *     possible object is
     *     {@link Double }
     *     
     */
    public double getAltitude() {
        if (altitude == null) {
            return  1.0D;
        } else {
            return altitude;
        }
    }

    /**
     * Sets the value of the altitude property.
     * 
     * @param value
     *     allowed object is
     *     {@link Double }
     *     
     */
    public void setAltitude(Double value) {
        this.altitude = value;
    }

    /**
     * Gets the value of the numberOfLayers property.
     * 
     * @return
     *     possible object is
     *     {@link BigInteger }
     *     
     */
    public BigInteger getNumberOfLayers() {
        return numberOfLayers;
    }

    /**
     * Sets the value of the numberOfLayers property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigInteger }
     *     
     */
    public void setNumberOfLayers(BigInteger value) {
        this.numberOfLayers = value;
    }

}
