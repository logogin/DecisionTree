//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, vhudson-jaxb-ri-2.2-147 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2010.10.08 at 09:52:11 PM EEST 
//


package org.dmg.pmml_3_1;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for MINING-FUNCTION.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="MINING-FUNCTION">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="associationRules"/>
 *     &lt;enumeration value="sequences"/>
 *     &lt;enumeration value="classification"/>
 *     &lt;enumeration value="regression"/>
 *     &lt;enumeration value="clustering"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "MINING-FUNCTION")
@XmlEnum
public enum MiningFunctionType {

    @XmlEnumValue("associationRules")
    ASSOCIATION_RULES("associationRules"),
    @XmlEnumValue("sequences")
    SEQUENCES("sequences"),
    @XmlEnumValue("classification")
    CLASSIFICATION("classification"),
    @XmlEnumValue("regression")
    REGRESSION("regression"),
    @XmlEnumValue("clustering")
    CLUSTERING("clustering");
    private final String value;

    MiningFunctionType(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static MiningFunctionType fromValue(String v) {
        for (MiningFunctionType c: MiningFunctionType.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}