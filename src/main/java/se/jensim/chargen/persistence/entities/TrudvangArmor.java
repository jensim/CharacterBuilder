/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package se.jensim.chargen.persistence.entities;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author jens
 */
@Entity
@Table(name = "trudvang_armor", catalog = "rollspel", schema = "public")
@NamedQueries({
    @NamedQuery(name = "TrudvangArmor.findAll", query = "SELECT t FROM TrudvangArmor t")})
public class TrudvangArmor implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id", nullable = false)
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "name", nullable = false, length = 255)
    private String name;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 2147483647)
    @Column(name = "description", nullable = false, length = 2147483647)
    private String description;
    @Basic(optional = false)
    @NotNull
    @Column(name = "armorvalue", nullable = false)
    private int armorvalue;
    @Basic(optional = false)
    @NotNull
    @Column(name = "weight", nullable = false)
    private int weight;
    @Basic(optional = false)
    @NotNull
    @Column(name = "price", nullable = false)
    private int price;
    @JoinColumn(name = "book_id", referencedColumnName = "id", nullable = false)
    @ManyToOne(optional = false)
    private TrudvangBook bookId;
    @JoinColumn(name = "bodypart_id", referencedColumnName = "id", nullable = false)
    @ManyToOne(optional = false)
    private TrudvangBodypart bodypartId;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "armorId")
    private List<TrudvangArmorSetArmor> trudvangArmorSetArmorList;

    public TrudvangArmor() {
    }

    public TrudvangArmor(Integer id) {
        this.id = id;
    }

    public TrudvangArmor(Integer id, String name, String description, int armorvalue, int weight, int price) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.armorvalue = armorvalue;
        this.weight = weight;
        this.price = price;
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

    public int getArmorvalue() {
        return armorvalue;
    }

    public void setArmorvalue(int armorvalue) {
        this.armorvalue = armorvalue;
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

    public TrudvangBook getBookId() {
        return bookId;
    }

    public void setBookId(TrudvangBook bookId) {
        this.bookId = bookId;
    }

    public TrudvangBodypart getBodypartId() {
        return bodypartId;
    }

    public void setBodypartId(TrudvangBodypart bodypartId) {
        this.bodypartId = bodypartId;
    }

    public List<TrudvangArmorSetArmor> getTrudvangArmorSetArmorList() {
        return trudvangArmorSetArmorList;
    }

    public void setTrudvangArmorSetArmorList(List<TrudvangArmorSetArmor> trudvangArmorSetArmorList) {
        this.trudvangArmorSetArmorList = trudvangArmorSetArmorList;
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
        if (!(object instanceof TrudvangArmor)) {
            return false;
        }
        TrudvangArmor other = (TrudvangArmor) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "se.jensim.chargen.persistence.entities.TrudvangArmor[ id=" + id + " ]";
    }
    
}
