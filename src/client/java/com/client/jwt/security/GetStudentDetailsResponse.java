
package com.client.jwt.security;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for anonymous complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="StudentDetails" type="{http://in28minutes.com/students}StudentDetails"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "studentDetails"
})
@XmlRootElement(name = "GetStudentDetailsResponse")
public class GetStudentDetailsResponse {

    @XmlElement(name = "StudentDetails", required = true)
    protected StudentDetails studentDetails;

    /**
     * Gets the value of the studentDetails property.
     * 
     * @return
     *     possible object is
     *     {@link StudentDetails }
     *     
     */
    public StudentDetails getStudentDetails() {
        return studentDetails;
    }

    /**
     * Sets the value of the studentDetails property.
     * 
     * @param value
     *     allowed object is
     *     {@link StudentDetails }
     *     
     */
    public void setStudentDetails(StudentDetails value) {
        this.studentDetails = value;
    }

}
