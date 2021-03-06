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
 * <p>Java class for NO-TRUE-CHILD-STRATEGY.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="NO-TRUE-CHILD-STRATEGY">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="returnNullPrediction"/>
 *     &lt;enumeration value="returnLastPrediction"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "NO-TRUE-CHILD-STRATEGY")
@XmlEnum
public enum NoTrueChildStrategy {

    @XmlEnumValue("returnNullPrediction")
    RETURN_NULL_PREDICTION("returnNullPrediction"),
    @XmlEnumValue("returnLastPrediction")
    RETURN_LAST_PREDICTION("returnLastPrediction");
    private final String value;

    NoTrueChildStrategy(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static NoTrueChildStrategy fromValue(String v) {
        for (NoTrueChildStrategy c: NoTrueChildStrategy.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
