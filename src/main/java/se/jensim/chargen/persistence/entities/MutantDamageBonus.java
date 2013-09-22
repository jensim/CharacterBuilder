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
import javax.validation.constraints.NotNull;

/**
 *
 * @author jens
 */
@Entity
@Table(name = "mutant_damage_bonus", catalog = "rollspel", schema = "public")
@NamedQueries({
    @NamedQuery(name = "MutantDamageBonus.findAll", query = "SELECT m FROM MutantDamageBonus m")})
public class MutantDamageBonus implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id", nullable = false)
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Column(name = "STY_STO", nullable = false)
    private int stySto;
    @Basic(optional = false)
    @NotNull
    @Column(name = "positive", nullable = false)
    private boolean positive;
    @Basic(optional = false)
    @NotNull
    @Column(name = "dice_count", nullable = false)
    private int diceCount;
    @Basic(optional = false)
    @NotNull
    @Column(name = "dice_size", nullable = false)
    private int diceSize;
    @Basic(optional = false)
    @NotNull
    @Column(name = "static_damage", nullable = false)
    private int staticDamage;

    public MutantDamageBonus() {
    }

    public MutantDamageBonus(Integer id) {
        this.id = id;
    }

    public MutantDamageBonus(Integer id, int stySto, boolean positive, int diceCount, int diceSize, int staticDamage) {
        this.id = id;
        this.stySto = stySto;
        this.positive = positive;
        this.diceCount = diceCount;
        this.diceSize = diceSize;
        this.staticDamage = staticDamage;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public int getStySto() {
        return stySto;
    }

    public void setStySto(int stySto) {
        this.stySto = stySto;
    }

    public boolean getPositive() {
        return positive;
    }

    public void setPositive(boolean positive) {
        this.positive = positive;
    }

    public int getDiceCount() {
        return diceCount;
    }

    public void setDiceCount(int diceCount) {
        this.diceCount = diceCount;
    }

    public int getDiceSize() {
        return diceSize;
    }

    public void setDiceSize(int diceSize) {
        this.diceSize = diceSize;
    }

    public int getStaticDamage() {
        return staticDamage;
    }

    public void setStaticDamage(int staticDamage) {
        this.staticDamage = staticDamage;
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
        if (!(object instanceof MutantDamageBonus)) {
            return false;
        }
        MutantDamageBonus other = (MutantDamageBonus) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "se.jensim.chargen.persistence.entities.MutantDamageBonus[ id=" + id + " ]";
    }
    
}
