/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package se.jensim.chargen.persistence.entities;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author jens
 */
@Entity
@Table(name = "trudvang_item", catalog = "rollspel", schema = "public", uniqueConstraints = {
    @UniqueConstraint(columnNames = {"name"})})
@NamedQueries({
    @NamedQuery(name = "TrudvangItem.findAll", query = "SELECT t FROM TrudvangItem t")})
public class TrudvangItem implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id", nullable = false)
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "name", nullable = false, length = 50)
    private String name;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 2147483647)
    @Column(name = "description", nullable = false, length = 2147483647)
    private String description;
    @Basic(optional = false)
    @NotNull
    @Column(name = "weight", nullable = false)
    private int weight;
    @Basic(optional = false)
    @NotNull
    @Column(name = "value_hv", nullable = false)
    private int valueHv;
    @JoinColumn(name = "book_id", referencedColumnName = "id", nullable = false)
    @ManyToOne(optional = false)
    private TrudvangBook bookId;

    public TrudvangItem() {
    }

    public TrudvangItem(Integer id) {
        this.id = id;
    }

    public TrudvangItem(Integer id, String name, String description, int weight, int valueHv) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.weight = weight;
        this.valueHv = valueHv;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public int getValueHv() {
        return valueHv;
    }

    public void setValueHv(int valueHv) {
        this.valueHv = valueHv;
    }

    public TrudvangBook getBookId() {
        return bookId;
    }

    public void setBookId(TrudvangBook bookId) {
        this.bookId = bookId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TrudvangItem)) {
            return false;
        }
        TrudvangItem other = (TrudvangItem) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "se.jensim.chargen.persistence.entities.TrudvangItem[ id=" + id + " ]";
    }
    
}
