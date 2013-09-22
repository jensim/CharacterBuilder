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
@Table(name = "mutant_weapon", catalog = "rollspel", schema = "public", uniqueConstraints = {
    @UniqueConstraint(columnNames = {"name"})})
@NamedQueries({
    @NamedQuery(name = "MutantWeapon.findAll", query = "SELECT m FROM MutantWeapon m")})
public class MutantWeapon implements Serializable {
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
    @Column(name = "initiative", nullable = false)
    private int initiative;
    @Basic(optional = false)
    @NotNull
    @Column(name = "penetration", nullable = false)
    private int penetration;
    @Basic(optional = false)
    @NotNull
    @Column(name = "reach", nullable = false)
    private int reach;
    @Basic(optional = false)
    @NotNull
    @Column(name = "durability", nullable = false)
    private int durability;
    @Basic(optional = false)
    @NotNull
    @Column(name = "dependability", nullable = false)
    private int dependability;
    @Basic(optional = false)
    @NotNull
    @Column(name = "weight", nullable = false)
    private int weight;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "grip", nullable = false, length = 50)
    private String grip;
    @Basic(optional = false)
    @NotNull
    @Column(name = "sty_krav", nullable = false)
    private int styKrav;
    @Basic(optional = false)
    @NotNull
    @Column(name = "price", nullable = false)
    private int price;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "damage", nullable = false, length = 50)
    private String damage;

    public MutantWeapon() {
    }

    public MutantWeapon(Integer id) {
        this.id = id;
    }

    public MutantWeapon(Integer id, String name, String description, int initiative, int penetration, int reach, int durability, int dependability, int weight, String grip, int styKrav, int price, String damage) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.initiative = initiative;
        this.penetration = penetration;
        this.reach = reach;
        this.durability = durability;
        this.dependability = dependability;
        this.weight = weight;
        this.grip = grip;
        this.styKrav = styKrav;
        this.price = price;
        this.damage = damage;
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

    public int getInitiative() {
        return initiative;
    }

    public void setInitiative(int initiative) {
        this.initiative = initiative;
    }

    public int getPenetration() {
        return penetration;
    }

    public void setPenetration(int penetration) {
        this.penetration = penetration;
    }

    public int getReach() {
        return reach;
    }

    public void setReach(int reach) {
        this.reach = reach;
    }

    public int getDurability() {
        return durability;
    }

    public void setDurability(int durability) {
        this.durability = durability;
    }

    public int getDependability() {
        return dependability;
    }

    public void setDependability(int dependability) {
        this.dependability = dependability;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public String getGrip() {
        return grip;
    }

    public void setGrip(String grip) {
        this.grip = grip;
    }

    public int getStyKrav() {
        return styKrav;
    }

    public void setStyKrav(int styKrav) {
        this.styKrav = styKrav;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getDamage() {
        return damage;
    }

    public void setDamage(String damage) {
        this.damage = damage;
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
        if (!(object instanceof MutantWeapon)) {
            return false;
        }
        MutantWeapon other = (MutantWeapon) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "se.jensim.chargen.persistence.entities.MutantWeapon[ id=" + id + " ]";
    }
    
}
