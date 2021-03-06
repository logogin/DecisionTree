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
 * <p>Java class for RESULT-FEATURE.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="RESULT-FEATURE">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="predictedValue"/>
 *     &lt;enumeration value="predictedDisplayValue"/>
 *     &lt;enumeration value="probability"/>
 *     &lt;enumeration value="residual"/>
 *     &lt;enumeration value="standardError"/>
 *     &lt;enumeration value="clusterId"/>
 *     &lt;enumeration value="clusterAffinity"/>
 *     &lt;enumeration value="warning"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "RESULT-FEATURE")
@XmlEnum
public enum ResultFeature {

    @XmlEnumValue("predictedValue")
    PREDICTED_VALUE("predictedValue"),
    @XmlEnumValue("predictedDisplayValue")
    PREDICTED_DISPLAY_VALUE("predictedDisplayValue"),
    @XmlEnumValue("probability")
    PROBABILITY("probability"),
    @XmlEnumValue("residual")
    RESIDUAL("residual"),
    @XmlEnumValue("standardError")
    STANDARD_ERROR("standardError"),
    @XmlEnumValue("clusterId")
    CLUSTER_ID("clusterId"),
    @XmlEnumValue("clusterAffinity")
    CLUSTER_AFFINITY("clusterAffinity"),
    @XmlEnumValue("warning")
    WARNING("warning");
    private final String value;

    ResultFeature(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static ResultFeature fromValue(String v) {
        for (ResultFeature c: ResultFeature.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
