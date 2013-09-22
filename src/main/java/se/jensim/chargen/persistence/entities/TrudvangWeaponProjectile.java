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
@Table(name = "trudvang_weapon_projectile", catalog = "rollspel", schema = "public", uniqueConstraints = {
    @UniqueConstraint(columnNames = {"name"})})
@NamedQueries({
    @NamedQuery(name = "TrudvangWeaponProjectile.findAll", query = "SELECT t FROM TrudvangWeaponProjectile t")})
public class TrudvangWeaponProjectile implements Serializable {
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
    @Column(name = "sh", nullable = false)
    private int sh;
    @Basic(optional = false)
    @NotNull
    @Column(name = "im", nullable = false)
    private int im;
    @Basic(optional = false)
    @NotNull
    @Column(name = "bv", nullable = false)
    private int bv;
    @Basic(optional = false)
    @NotNull
    @Column(name = "pv_short", nullable = false)
    private int pvShort;
    @Basic(optional = false)
    @NotNull
    @Column(name = "pv_long", nullable = false)
    private int pvLong;
    @Basic(optional = false)
    @NotNull
    @Column(name = "weight", nullable = false)
    private int weight;
    @Basic(optional = false)
    @NotNull
    @Column(name = "damage_static", nullable = false)
    private int damageStatic;
    @Basic(optional = false)
    @NotNull
    @Column(name = "distance_short", nullable = false)
    private int distanceShort;
    @Basic(optional = false)
    @NotNull
    @Column(name = "distance_long", nullable = false)
    private int distanceLong;
    @Basic(optional = false)
    @NotNull
    @Column(name = "price", nullable = false)
    private int price;
    @JoinColumn(name = "type_id", referencedColumnName = "id", nullable = false)
    @ManyToOne(optional = false)
    private TrudvangWeaponType typeId;
    @JoinColumn(name = "damage_dice_id", referencedColumnName = "id", nullable = false)
    @ManyToOne(optional = false)
    private TrudvangDamageDice damageDiceId;
    @JoinColumn(name = "book_id", referencedColumnName = "id", nullable = false)
    @ManyToOne(optional = false)
    private TrudvangBook bookId;

    public TrudvangWeaponProjectile() {
    }

    public TrudvangWeaponProjectile(Integer id) {
        this.id = id;
    }

    public TrudvangWeaponProjectile(Integer id, String name, String description, int sh, int im, int bv, int pvShort, int pvLong, int weight, int damageStatic, int distanceShort, int distanceLong, int price) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.sh = sh;
        this.im = im;
        this.bv = bv;
        this.pvShort = pvShort;
        this.pvLong = pvLong;
        this.weight = weight;
        this.damageStatic = damageStatic;
        this.distanceShort = distanceShort;
        this.distanceLong = distanceLong;
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

    public int getSh() {
        return sh;
    }

    public void setSh(int sh) {
        this.sh = sh;
    }

    public int getIm() {
        return im;
    }

    public void setIm(int im) {
        this.im = im;
    }

    public int getBv() {
        return bv;
    }

    public void setBv(int bv) {
        this.bv = bv;
    }

    public int getPvShort() {
        return pvShort;
    }

    public void setPvShort(int pvShort) {
        this.pvShort = pvShort;
    }

    public int getPvLong() {
        return pvLong;
    }

    public void setPvLong(int pvLong) {
        this.pvLong = pvLong;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public int getDamageStatic() {
        return damageStatic;
    }

    public void setDamageStatic(int damageStatic) {
        this.damageStatic = damageStatic;
    }

    public int getDistanceShort() {
        return distanceShort;
    }

    public void setDistanceShort(int distanceShort) {
        this.distanceShort = distanceShort;
    }

    public int getDistanceLong() {
        return distanceLong;
    }

    public void setDistanceLong(int distanceLong) {
        this.distanceLong = distanceLong;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public TrudvangWeaponType getTypeId() {
        return typeId;
    }

    public void setTypeId(TrudvangWeaponType typeId) {
        this.typeId = typeId;
    }

    public TrudvangDamageDice getDamageDiceId() {
        return damageDiceId;
    }

    public void setDamageDiceId(TrudvangDamageDice damageDiceId) {
        this.damageDiceId = damageDiceId;
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
        if (!(object instanceof TrudvangWeaponProjectile)) {
            return false;
        }
        TrudvangWeaponProjectile other = (TrudvangWeaponProjectile) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "se.jensim.chargen.persistence.entities.TrudvangWeaponProjectile[ id=" + id + " ]";
    }
    
}
