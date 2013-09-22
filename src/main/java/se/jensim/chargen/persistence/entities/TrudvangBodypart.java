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
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author jens
 */
@Entity
@Table(name = "trudvang_bodypart", catalog = "rollspel", schema = "public", uniqueConstraints = {
    @UniqueConstraint(columnNames = {"name"})})
@NamedQueries({
    @NamedQuery(name = "TrudvangBodypart.findAll", query = "SELECT t FROM TrudvangBodypart t")})
public class TrudvangBodypart implements Serializable {
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
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "bodypartId")
    private List<TrudvangArmor> trudvangArmorList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "bodypartId")
    private List<TrudvangArmorCharacter> trudvangArmorCharacterList;

    public TrudvangBodypart() {
    }

    public TrudvangBodypart(Integer id) {
        this.id = id;
    }

    public TrudvangBodypart(Integer id, String name) {
        this.id = id;
        this.name = name;
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

    public List<TrudvangArmor> getTrudvangArmorList() {
        return trudvangArmorList;
    }

    public void setTrudvangArmorList(List<TrudvangArmor> trudvangArmorList) {
        this.trudvangArmorList = trudvangArmorList;
    }

    public List<TrudvangArmorCharacter> getTrudvangArmorCharacterList() {
        return trudvangArmorCharacterList;
    }

    public void setTrudvangArmorCharacterList(List<TrudvangArmorCharacter> trudvangArmorCharacterList) {
        this.trudvangArmorCharacterList = trudvangArmorCharacterList;
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
        if (!(object instanceof TrudvangBodypart)) {
            return false;
        }
        TrudvangBodypart other = (TrudvangBodypart) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "se.jensim.chargen.persistence.entities.TrudvangBodypart[ id=" + id + " ]";
    }
    
}
