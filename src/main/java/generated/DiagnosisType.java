//
// This file was generated by the Eclipse Implementation of JAXB, v3.0.0 
// See https://eclipse-ee4j.github.io/jaxb-ri 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2023.07.06 at 02:16:40 PM IST 
//


package generated;

import java.util.ArrayList;
import java.util.List;
import jakarta.xml.bind.JAXBElement;
import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlAttribute;
import jakarta.xml.bind.annotation.XmlElementRef;
import jakarta.xml.bind.annotation.XmlElementRefs;
import jakarta.xml.bind.annotation.XmlType;


/**
 * <p>Java class for diagnosisType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="diagnosisType"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element ref="{}name" minOccurs="0"/&gt;
 *         &lt;element ref="{}desc" minOccurs="0"/&gt;
 *         &lt;choice maxOccurs="unbounded" minOccurs="0"&gt;
 *           &lt;element ref="{}inclusionTerm" minOccurs="0"/&gt;
 *           &lt;element ref="{}sevenChrNote" minOccurs="0"/&gt;
 *           &lt;element ref="{}sevenChrDef" minOccurs="0"/&gt;
 *           &lt;element ref="{}includes" minOccurs="0"/&gt;
 *           &lt;element ref="{}excludes1" minOccurs="0"/&gt;
 *           &lt;element ref="{}excludes2" minOccurs="0"/&gt;
 *           &lt;element ref="{}codeFirst" minOccurs="0"/&gt;
 *           &lt;element ref="{}useAdditionalCode" maxOccurs="unbounded" minOccurs="0"/&gt;
 *           &lt;element ref="{}codeAlso" minOccurs="0"/&gt;
 *           &lt;element ref="{}notes" maxOccurs="unbounded" minOccurs="0"/&gt;
 *           &lt;element ref="{}visualImpairment" minOccurs="0"/&gt;
 *           &lt;element ref="{}diag" maxOccurs="unbounded" minOccurs="0"/&gt;
 *         &lt;/choice&gt;
 *       &lt;/sequence&gt;
 *       &lt;attribute name="placeholder"&gt;
 *         &lt;simpleType&gt;
 *           &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
 *             &lt;enumeration value="true"/&gt;
 *             &lt;enumeration value="false"/&gt;
 *           &lt;/restriction&gt;
 *         &lt;/simpleType&gt;
 *       &lt;/attribute&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "diagnosisType", propOrder = {
    "name",
    "desc",
    "inclusionTermOrSevenChrNoteOrSevenChrDef"
})
public class DiagnosisType {

    protected ContentType name;
    protected ContentType desc;
    @XmlElementRefs({
        @XmlElementRef(name = "inclusionTerm", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "sevenChrNote", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "sevenChrDef", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "includes", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "excludes1", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "excludes2", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "codeFirst", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "useAdditionalCode", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "codeAlso", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "notes", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "visualImpairment", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "diag", type = JAXBElement.class, required = false)
    })
    protected List<JAXBElement<?>> inclusionTermOrSevenChrNoteOrSevenChrDef;
    @XmlAttribute(name = "placeholder")
    protected String placeholder;

    /**
     * Gets the value of the name property.
     * 
     * @return
     *     possible object is
     *     {@link ContentType }
     *     
     */
    public ContentType getName() {
        return name;
    }

    /**
     * Sets the value of the name property.
     * 
     * @param value
     *     allowed object is
     *     {@link ContentType }
     *     
     */
    public void setName(ContentType value) {
        this.name = value;
    }

    /**
     * Gets the value of the desc property.
     * 
     * @return
     *     possible object is
     *     {@link ContentType }
     *     
     */
    public ContentType getDesc() {
        return desc;
    }

    /**
     * Sets the value of the desc property.
     * 
     * @param value
     *     allowed object is
     *     {@link ContentType }
     *     
     */
    public void setDesc(ContentType value) {
        this.desc = value;
    }

    /**
     * Gets the value of the inclusionTermOrSevenChrNoteOrSevenChrDef property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the Jakarta XML Binding object.
     * This is why there is not a <CODE>set</CODE> method for the inclusionTermOrSevenChrNoteOrSevenChrDef property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getInclusionTermOrSevenChrNoteOrSevenChrDef().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link JAXBElement }{@code <}{@link NoteType }{@code >}
     * {@link JAXBElement }{@code <}{@link NoteType }{@code >}
     * {@link JAXBElement }{@code <}{@link SevenChrDefType }{@code >}
     * {@link JAXBElement }{@code <}{@link NoteType }{@code >}
     * {@link JAXBElement }{@code <}{@link NoteType }{@code >}
     * {@link JAXBElement }{@code <}{@link NoteType }{@code >}
     * {@link JAXBElement }{@code <}{@link NoteType }{@code >}
     * {@link JAXBElement }{@code <}{@link NoteType }{@code >}
     * {@link JAXBElement }{@code <}{@link NoteType }{@code >}
     * {@link JAXBElement }{@code <}{@link NoteType }{@code >}
     * {@link JAXBElement }{@code <}{@link VisualImpairmentType }{@code >}
     * {@link JAXBElement }{@code <}{@link DiagnosisType }{@code >}
     * 
     * 
     */
    public List<JAXBElement<?>> getInclusionTermOrSevenChrNoteOrSevenChrDef() {
        if (inclusionTermOrSevenChrNoteOrSevenChrDef == null) {
            inclusionTermOrSevenChrNoteOrSevenChrDef = new ArrayList<JAXBElement<?>>();
        }
        return this.inclusionTermOrSevenChrNoteOrSevenChrDef;
    }

    /**
     * Gets the value of the placeholder property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPlaceholder() {
        return placeholder;
    }

    /**
     * Sets the value of the placeholder property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPlaceholder(String value) {
        this.placeholder = value;
    }

}
