/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
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
@NamedQueries(value = {@NamedQuery(name = "FIND_ALL", query = "SELECT c FROM Category c"),
                       @NamedQuery(name = "FIND_BY_CODE",query = "SELECT c FROM Category c WHERE c.code = :code")})
/**
 *
 * @author PTPM
 */
@Entity
@Table(name="DongSP")
public class Category implements Serializable {
    
    @Id
    @GenericGenerator(name = "generator", strategy = "guid",parameters = {})
    @GeneratedValue(generator = "generator")
    private String id;
    
    @Column(name = "Ma",unique = true)
    private String code;
   
    @Column(name = "Ten")
    private String name;

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
        return name;
    }
    
}
