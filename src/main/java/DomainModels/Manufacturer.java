/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DomainModels;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.NamedQueries;
import org.hibernate.annotations.NamedQuery;
@NamedQueries({
    @NamedQuery(name = "Manufacturer.FIND_ALL", query = "SELECT m FROM Manufacturer m"),
    @NamedQuery(name = "Manufacturer.FIND_BY_CODE", query = "SELECT m FROM Manufacturer m WHERE m.code = :code")
})
/**
 *
 * @author Nguyen Duy Hung
 */
@Entity
@Table(name = "NSX")
public class Manufacturer implements Serializable{
    @Id
    @GenericGenerator(name = "generator", strategy = "guid")
    @GeneratedValue(generator = "generator")
    private String id;
    
    @Column(name = "Ma")
    private String code;
    
    @Column(name = "Ten")
    private String name;

    public Manufacturer() {
    }

    public Manufacturer(String id, String code, String name) {
        this.id = id;
        this.code = code;
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return this.name;
    }
    
}
