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
@Table(name = "mutant_armor", catalog = "rollspel", schema = "public", uniqueConstraints = {
    @UniqueConstraint(columnNames = {"name"})})
@NamedQueries({
    @NamedQuery(name = "MutantArmor.findAll", query = "SELECT m FROM MutantArmor m")})
public class MutantArmor implements Serializable {
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
    @Column(name = "abs", nullable = false)
    private int abs;
    @Basic(optional = false)
    @NotNull
    @Column(name = "beg", nullable = false)
    private int beg;
    @Basic(optional = false)
    @NotNull
    @Column(name = "weight", nullable = false)
    private int weight;
    @Basic(optional = false)
    @NotNull
    @Column(name = "price", nullable = false)
    private int price;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 2147483647)
    @Column(name = "description", nullable = false, length = 2147483647)
    private String description;
    @JoinColumn(name = "body_part_id", referencedColumnName = "id", nullable = false)
    @ManyToOne(optional = false)
    private MutantArmorBodypart bodyPartId;

    public MutantArmor() {
    }

    public MutantArmor(Integer id) {
        this.id = id;
    }

    public MutantArmor(Integer id, String name, int abs, int beg, int weight, int price, String description) {
        this.id = id;
        this.name = name;
        this.abs = abs;
        this.beg = beg;
        this.weight = weight;
        this.price = price;
        this.description = description;
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

    public int getAbs() {
        return abs;
    }

    public void setAbs(int abs) {
        this.abs = abs;
    }

    public int getBeg() {
        return beg;
    }

    public void setBeg(int beg) {
        this.beg = beg;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public MutantArmorBodypart getBodyPartId() {
        return bodyPartId;
    }

    public void setBodyPartId(MutantArmorBodypart bodyPartId) {
        this.bodyPartId = bodyPartId;
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
        if (!(object instanceof MutantArmor)) {
            return false;
        }
        MutantArmor other = (MutantArmor) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "se.jensim.chargen.persistence.entities.MutantArmor[ id=" + id + " ]";
    }
    
}
