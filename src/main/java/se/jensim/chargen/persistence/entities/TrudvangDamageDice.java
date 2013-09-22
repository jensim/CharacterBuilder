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
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

/**
 *
 * @author jens
 */
@Entity
@Table(name = "trudvang_damage_dice", catalog = "rollspel", schema = "public")
@NamedQueries({
    @NamedQuery(name = "TrudvangDamageDice.findAll", query = "SELECT t FROM TrudvangDamageDice t")})
public class TrudvangDamageDice implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "id", nullable = false)
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Column(name = "size", nullable = false)
    private int size;
    @Column(name = "open")
    private Integer open;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "damageDiceId")
    private List<TrudvangWeaponProjectileCharacter> trudvangWeaponProjectileCharacterList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "damageDiceId")
    private List<TrudvangWeaponMeleeCharacter> trudvangWeaponMeleeCharacterList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "damageDiceId")
    private List<TrudvangWeaponProjectile> trudvangWeaponProjectileList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "damageDiceId")
    private List<TrudvangWeaponMelee> trudvangWeaponMeleeList;

    public TrudvangDamageDice() {
    }

    public TrudvangDamageDice(Integer id) {
        this.id = id;
    }

    public TrudvangDamageDice(Integer id, int size) {
        this.id = id;
        this.size = size;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public Integer getOpen() {
        return open;
    }

    public void setOpen(Integer open) {
        this.open = open;
    }

    public List<TrudvangWeaponProjectileCharacter> getTrudvangWeaponProjectileCharacterList() {
        return trudvangWeaponProjectileCharacterList;
    }

    public void setTrudvangWeaponProjectileCharacterList(List<TrudvangWeaponProjectileCharacter> trudvangWeaponProjectileCharacterList) {
        this.trudvangWeaponProjectileCharacterList = trudvangWeaponProjectileCharacterList;
    }

    public List<TrudvangWeaponMeleeCharacter> getTrudvangWeaponMeleeCharacterList() {
        return trudvangWeaponMeleeCharacterList;
    }

    public void setTrudvangWeaponMeleeCharacterList(List<TrudvangWeaponMeleeCharacter> trudvangWeaponMeleeCharacterList) {
        this.trudvangWeaponMeleeCharacterList = trudvangWeaponMeleeCharacterList;
    }

    public List<TrudvangWeaponProjectile> getTrudvangWeaponProjectileList() {
        return trudvangWeaponProjectileList;
    }

    public void setTrudvangWeaponProjectileList(List<TrudvangWeaponProjectile> trudvangWeaponProjectileList) {
        this.trudvangWeaponProjectileList = trudvangWeaponProjectileList;
    }

    public List<TrudvangWeaponMelee> getTrudvangWeaponMeleeList() {
        return trudvangWeaponMeleeList;
    }

    public void setTrudvangWeaponMeleeList(List<TrudvangWeaponMelee> trudvangWeaponMeleeList) {
        this.trudvangWeaponMeleeList = trudvangWeaponMeleeList;
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
        if (!(object instanceof TrudvangDamageDice)) {
            return false;
        }
        TrudvangDamageDice other = (TrudvangDamageDice) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "se.jensim.chargen.persistence.entities.TrudvangDamageDice[ id=" + id + " ]";
    }
    
}
