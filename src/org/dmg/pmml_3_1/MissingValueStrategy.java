//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, vhudson-jaxb-ri-2.2-147 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2010.10.11 at 02:01:32 PM EEST 
//


package org.dmg.pmml_3_1;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for MISSING-VALUE-STRATEGY.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="MISSING-VALUE-STRATEGY">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="lastPrediction"/>
 *     &lt;enumeration value="nullPrediction"/>
 *     &lt;enumeration value="defaultChild"/>
 *     &lt;enumeration value="weightedConfidence"/>
 *     &lt;enumeration value="none"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "MISSING-VALUE-STRATEGY")
@XmlEnum
public enum MissingValueStrategy {

    @XmlEnumValue("lastPrediction")
    LAST_PREDICTION("lastPrediction"),
    @XmlEnumValue("nullPrediction")
    NULL_PREDICTION("nullPrediction"),
    @XmlEnumValue("defaultChild")
    DEFAULT_CHILD("defaultChild"),
    @XmlEnumValue("weightedConfidence")
    WEIGHTED_CONFIDENCE("weightedConfidence"),
    @XmlEnumValue("none")
    NONE("none");
    private final String value;

    MissingValueStrategy(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static MissingValueStrategy fromValue(String v) {
        for (MissingValueStrategy c: MissingValueStrategy.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
