//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.8-b130911.1802 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2017.12.02 at 11:46:06 PM EET 
//


package XMLgener;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
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
 *         &lt;element name="ACoefs">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;sequence>
 *                   &lt;element name="ACoef" maxOccurs="unbounded">
 *                     &lt;complexType>
 *                       &lt;complexContent>
 *                         &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                           &lt;attribute name="X" use="required" type="{http://www.w3.org/2001/XMLSchema}double" />
 *                         &lt;/restriction>
 *                       &lt;/complexContent>
 *                     &lt;/complexType>
 *                   &lt;/element>
 *                 &lt;/sequence>
 *               &lt;/restriction>
 *             &lt;/complexContent>
 *           &lt;/complexType>
 *         &lt;/element>
 *         &lt;element name="XYCoefs">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;sequence>
 *                   &lt;element name="XYCoef" maxOccurs="unbounded">
 *                     &lt;complexType>
 *                       &lt;complexContent>
 *                         &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                           &lt;attribute name="X" use="required" type="{http://www.w3.org/2001/XMLSchema}double" />
 *                           &lt;attribute name="Y" use="required" type="{http://www.w3.org/2001/XMLSchema}double" />
 *                         &lt;/restriction>
 *                       &lt;/complexContent>
 *                     &lt;/complexType>
 *                   &lt;/element>
 *                 &lt;/sequence>
 *               &lt;/restriction>
 *             &lt;/complexContent>
 *           &lt;/complexType>
 *         &lt;/element>
 *       &lt;/sequence>
 *       &lt;attribute name="Left" use="required" type="{http://www.w3.org/2001/XMLSchema}double" />
 *       &lt;attribute name="Right" use="required" type="{http://www.w3.org/2001/XMLSchema}double" />
 *       &lt;attribute name="Step" use="required" type="{http://www.w3.org/2001/XMLSchema}double" />
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "aCoefs",
    "xyCoefs"
})
@XmlRootElement(name = "EquationData")
public class EquationData {

    @XmlElement(name = "ACoefs", required = true)
    protected EquationData.ACoefs aCoefs;
    @XmlElement(name = "XYCoefs", required = true)
    protected EquationData.XYCoefs xyCoefs;
    @XmlAttribute(name = "Left", required = true)
    protected double left;
    @XmlAttribute(name = "Right", required = true)
    protected double right;
    @XmlAttribute(name = "Step", required = true)
    protected double step;

    /**
     * Gets the value of the aCoefs property.
     * 
     * @return
     *     possible object is
     *     {@link EquationData.ACoefs }
     *     
     */
    public EquationData.ACoefs getACoefs() {
        return aCoefs;
    }

    /**
     * Sets the value of the aCoefs property.
     * 
     * @param value
     *     allowed object is
     *     {@link EquationData.ACoefs }
     *     
     */
    public void setACoefs(EquationData.ACoefs value) {
        this.aCoefs = value;
    }

    /**
     * Gets the value of the xyCoefs property.
     * 
     * @return
     *     possible object is
     *     {@link EquationData.XYCoefs }
     *     
     */
    public EquationData.XYCoefs getXYCoefs() {
        return xyCoefs;
    }

    /**
     * Sets the value of the xyCoefs property.
     * 
     * @param value
     *     allowed object is
     *     {@link EquationData.XYCoefs }
     *     
     */
    public void setXYCoefs(EquationData.XYCoefs value) {
        this.xyCoefs = value;
    }

    /**
     * Gets the value of the left property.
     * 
     */
    public double getLeft() {
        return left;
    }

    /**
     * Sets the value of the left property.
     * 
     */
    public void setLeft(double value) {
        this.left = value;
    }

    /**
     * Gets the value of the right property.
     * 
     */
    public double getRight() {
        return right;
    }

    /**
     * Sets the value of the right property.
     * 
     */
    public void setRight(double value) {
        this.right = value;
    }

    /**
     * Gets the value of the step property.
     * 
     */
    public double getStep() {
        return step;
    }

    /**
     * Sets the value of the step property.
     * 
     */
    public void setStep(double value) {
        this.step = value;
    }


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
     *         &lt;element name="ACoef" maxOccurs="unbounded">
     *           &lt;complexType>
     *             &lt;complexContent>
     *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *                 &lt;attribute name="X" use="required" type="{http://www.w3.org/2001/XMLSchema}double" />
     *               &lt;/restriction>
     *             &lt;/complexContent>
     *           &lt;/complexType>
     *         &lt;/element>
     *       &lt;/sequence>
     *     &lt;/restriction>
     *   &lt;/complexContent>
     * &lt;/complexType>
     * </pre>
     * 
     * 
     */
    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlType(name = "", propOrder = {
        "aCoef"
    })
    public static class ACoefs {

        @XmlElement(name = "ACoef", required = true)
        protected List<EquationData.ACoefs.ACoef> aCoef;

        /**
         * Gets the value of the aCoef property.
         * 
         * <p>
         * This accessor method returns a reference to the live list,
         * not a snapshot. Therefore any modification you make to the
         * returned list will be present inside the JAXB object.
         * This is why there is not a <CODE>set</CODE> method for the aCoef property.
         * 
         * <p>
         * For example, to add a new item, do as follows:
         * <pre>
         *    getACoef().add(newItem);
         * </pre>
         * 
         * 
         * <p>
         * Objects of the following type(s) are allowed in the list
         * {@link EquationData.ACoefs.ACoef }
         * 
         * 
         */
        public List<EquationData.ACoefs.ACoef> getACoef() {
            if (aCoef == null) {
                aCoef = new ArrayList<EquationData.ACoefs.ACoef>();
            }
            return this.aCoef;
        }


        /**
         * <p>Java class for anonymous complex type.
         * 
         * <p>The following schema fragment specifies the expected content contained within this class.
         * 
         * <pre>
         * &lt;complexType>
         *   &lt;complexContent>
         *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
         *       &lt;attribute name="X" use="required" type="{http://www.w3.org/2001/XMLSchema}double" />
         *     &lt;/restriction>
         *   &lt;/complexContent>
         * &lt;/complexType>
         * </pre>
         * 
         * 
         */
        @XmlAccessorType(XmlAccessType.FIELD)
        @XmlType(name = "")
        public static class ACoef {

            @XmlAttribute(name = "X", required = true)
            protected double x;

            /**
             * Gets the value of the x property.
             * 
             */
            public double getX() {
                return x;
            }

            /**
             * Sets the value of the x property.
             * 
             */
            public void setX(double value) {
                this.x = value;
            }

        }

    }


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
     *         &lt;element name="XYCoef" maxOccurs="unbounded">
     *           &lt;complexType>
     *             &lt;complexContent>
     *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *                 &lt;attribute name="X" use="required" type="{http://www.w3.org/2001/XMLSchema}double" />
     *                 &lt;attribute name="Y" use="required" type="{http://www.w3.org/2001/XMLSchema}double" />
     *               &lt;/restriction>
     *             &lt;/complexContent>
     *           &lt;/complexType>
     *         &lt;/element>
     *       &lt;/sequence>
     *     &lt;/restriction>
     *   &lt;/complexContent>
     * &lt;/complexType>
     * </pre>
     * 
     * 
     */
    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlType(name = "", propOrder = {
        "xyCoef"
    })
    public static class XYCoefs {

        @XmlElement(name = "XYCoef", required = true)
        protected List<EquationData.XYCoefs.XYCoef> xyCoef;

        /**
         * Gets the value of the xyCoef property.
         * 
         * <p>
         * This accessor method returns a reference to the live list,
         * not a snapshot. Therefore any modification you make to the
         * returned list will be present inside the JAXB object.
         * This is why there is not a <CODE>set</CODE> method for the xyCoef property.
         * 
         * <p>
         * For example, to add a new item, do as follows:
         * <pre>
         *    getXYCoef().add(newItem);
         * </pre>
         * 
         * 
         * <p>
         * Objects of the following type(s) are allowed in the list
         * {@link EquationData.XYCoefs.XYCoef }
         * 
         * 
         */
        public List<EquationData.XYCoefs.XYCoef> getXYCoef() {
            if (xyCoef == null) {
                xyCoef = new ArrayList<EquationData.XYCoefs.XYCoef>();
            }
            return this.xyCoef;
        }


        /**
         * <p>Java class for anonymous complex type.
         * 
         * <p>The following schema fragment specifies the expected content contained within this class.
         * 
         * <pre>
         * &lt;complexType>
         *   &lt;complexContent>
         *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
         *       &lt;attribute name="X" use="required" type="{http://www.w3.org/2001/XMLSchema}double" />
         *       &lt;attribute name="Y" use="required" type="{http://www.w3.org/2001/XMLSchema}double" />
         *     &lt;/restriction>
         *   &lt;/complexContent>
         * &lt;/complexType>
         * </pre>
         * 
         * 
         */
        @XmlAccessorType(XmlAccessType.FIELD)
        @XmlType(name = "")
        public static class XYCoef {

            @XmlAttribute(name = "X", required = true)
            protected double x;
            @XmlAttribute(name = "Y", required = true)
            protected double y;

            /**
             * Gets the value of the x property.
             * 
             */
            public double getX() {
                return x;
            }

            /**
             * Sets the value of the x property.
             * 
             */
            public void setX(double value) {
                this.x = value;
            }

            /**
             * Gets the value of the y property.
             * 
             */
            public double getY() {
                return y;
            }

            /**
             * Sets the value of the y property.
             * 
             */
            public void setY(double value) {
                this.y = value;
            }

        }

    }

}
