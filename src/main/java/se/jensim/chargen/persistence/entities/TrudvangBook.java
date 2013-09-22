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
@Table(name = "trudvang_book", catalog = "rollspel", schema = "public", uniqueConstraints = {
    @UniqueConstraint(columnNames = {"name"})})
@NamedQueries({
    @NamedQuery(name = "TrudvangBook.findAll", query = "SELECT t FROM TrudvangBook t")})
public class TrudvangBook implements Serializable {
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
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "bookId")
    private List<TrudvangArmorSet> trudvangArmorSetList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "bookId")
    private List<TrudvangArktype> trudvangArktypeList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "bookId")
    private List<TrudvangExceptional> trudvangExceptionalList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "bookId")
    private List<TrudvangItem> trudvangItemList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "bookId")
    private List<TrudvangWeaponProjectile> trudvangWeaponProjectileList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "bookId")
    private List<TrudvangPeople> trudvangPeopleList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "bookId")
    private List<TrudvangArmor> trudvangArmorList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "bookId")
    private List<TrudvangElaboration> trudvangElaborationList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "bookId")
    private List<TrudvangWeaponMelee> trudvangWeaponMeleeList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "bookId")
    private List<TrudvangUpbringing> trudvangUpbringingList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "bookId")
    private List<TrudvangReligion> trudvangReligionList;

    public TrudvangBook() {
    }

    public TrudvangBook(Integer id) {
        this.id = id;
    }

    public TrudvangBook(Integer id, String name, String description) {
        this.id = id;
        this.name = name;
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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<TrudvangArmorSet> getTrudvangArmorSetList() {
        return trudvangArmorSetList;
    }

    public void setTrudvangArmorSetList(List<TrudvangArmorSet> trudvangArmorSetList) {
        this.trudvangArmorSetList = trudvangArmorSetList;
    }

    public List<TrudvangArktype> getTrudvangArktypeList() {
        return trudvangArktypeList;
    }

    public void setTrudvangArktypeList(List<TrudvangArktype> trudvangArktypeList) {
        this.trudvangArktypeList = trudvangArktypeList;
    }

    public List<TrudvangExceptional> getTrudvangExceptionalList() {
        return trudvangExceptionalList;
    }

    public void setTrudvangExceptionalList(List<TrudvangExceptional> trudvangExceptionalList) {
        this.trudvangExceptionalList = trudvangExceptionalList;
    }

    public List<TrudvangItem> getTrudvangItemList() {
        return trudvangItemList;
    }

    public void setTrudvangItemList(List<TrudvangItem> trudvangItemList) {
        this.trudvangItemList = trudvangItemList;
    }

    public List<TrudvangWeaponProjectile> getTrudvangWeaponProjectileList() {
        return trudvangWeaponProjectileList;
    }

    public void setTrudvangWeaponProjectileList(List<TrudvangWeaponProjectile> trudvangWeaponProjectileList) {
        this.trudvangWeaponProjectileList = trudvangWeaponProjectileList;
    }

    public List<TrudvangPeople> getTrudvangPeopleList() {
        return trudvangPeopleList;
    }

    public void setTrudvangPeopleList(List<TrudvangPeople> trudvangPeopleList) {
        this.trudvangPeopleList = trudvangPeopleList;
    }

    public List<TrudvangArmor> getTrudvangArmorList() {
        return trudvangArmorList;
    }

    public void setTrudvangArmorList(List<TrudvangArmor> trudvangArmorList) {
        this.trudvangArmorList = trudvangArmorList;
    }

    public List<TrudvangElaboration> getTrudvangElaborationList() {
        return trudvangElaborationList;
    }

    public void setTrudvangElaborationList(List<TrudvangElaboration> trudvangElaborationList) {
        this.trudvangElaborationList = trudvangElaborationList;
    }

    public List<TrudvangWeaponMelee> getTrudvangWeaponMeleeList() {
        return trudvangWeaponMeleeList;
    }

    public void setTrudvangWeaponMeleeList(List<TrudvangWeaponMelee> trudvangWeaponMeleeList) {
        this.trudvangWeaponMeleeList = trudvangWeaponMeleeList;
    }

    public List<TrudvangUpbringing> getTrudvangUpbringingList() {
        return trudvangUpbringingList;
    }

    public void setTrudvangUpbringingList(List<TrudvangUpbringing> trudvangUpbringingList) {
        this.trudvangUpbringingList = trudvangUpbringingList;
    }

    public List<TrudvangReligion> getTrudvangReligionList() {
        return trudvangReligionList;
    }

    public void setTrudvangReligionList(List<TrudvangReligion> trudvangReligionList) {
        this.trudvangReligionList = trudvangReligionList;
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
        if (!(object instanceof TrudvangBook)) {
            return false;
        }
        TrudvangBook other = (TrudvangBook) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "se.jensim.chargen.persistence.entities.TrudvangBook[ id=" + id + " ]";
    }
    
}
