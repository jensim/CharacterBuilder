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

/**
 *
 * @author jens
 */
@Entity
@Table(name = "trudvang_armor_set_armor", catalog = "rollspel", schema = "public", uniqueConstraints = {
    @UniqueConstraint(columnNames = {"armor_id", "set_id"})})
@NamedQueries({
    @NamedQuery(name = "TrudvangArmorSetArmor.findAll", query = "SELECT t FROM TrudvangArmorSetArmor t")})
public class TrudvangArmorSetArmor implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id", nullable = false)
    private Integer id;
    @JoinColumn(name = "set_id", referencedColumnName = "id", nullable = false)
    @ManyToOne(optional = false)
    private TrudvangArmorSet setId;
    @JoinColumn(name = "armor_id", referencedColumnName = "id", nullable = false)
    @ManyToOne(optional = false)
    private TrudvangArmor armorId;

    public TrudvangArmorSetArmor() {
    }

    public TrudvangArmorSetArmor(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public TrudvangArmorSet getSetId() {
        return setId;
    }

    public void setSetId(TrudvangArmorSet setId) {
        this.setId = setId;
    }

    public TrudvangArmor getArmorId() {
        return armorId;
    }

    public void setArmorId(TrudvangArmor armorId) {
        this.armorId = armorId;
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
        if (!(object instanceof TrudvangArmorSetArmor)) {
            return false;
        }
        TrudvangArmorSetArmor other = (TrudvangArmorSetArmor) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "se.jensim.chargen.persistence.entities.TrudvangArmorSetArmor[ id=" + id + " ]";
    }
    
}
