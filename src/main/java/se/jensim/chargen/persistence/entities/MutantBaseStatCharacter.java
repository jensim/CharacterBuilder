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
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.NotNull;

/**
 *
 * @author jens
 */
@Entity
@Table(name = "mutant_base_stat_character", catalog = "rollspel", schema = "public", uniqueConstraints = {
    @UniqueConstraint(columnNames = {"base_stat_id", "character_id"})})
@NamedQueries({
    @NamedQuery(name = "MutantBaseStatCharacter.findAll", query = "SELECT m FROM MutantBaseStatCharacter m")})
public class MutantBaseStatCharacter implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id", nullable = false)
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Column(name = "value", nullable = false)
    private int value;
    @Basic(optional = false)
    @NotNull
    @Column(name = "value_bonus", nullable = false)
    private int valueBonus;
    @Basic(optional = false)
    @NotNull
    @Column(name = "value_trained", nullable = false)
    private int valueTrained;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "baseStatCharId")
    private List<MutantSkillCharacter> mutantSkillCharacterList;
    @JoinColumn(name = "character_id", referencedColumnName = "id", nullable = false)
    @ManyToOne(optional = false)
    private MutantCharacter characterId;
    @JoinColumn(name = "base_stat_id", referencedColumnName = "id", nullable = false)
    @ManyToOne(optional = false)
    private MutantBaseStat baseStatId;

    public MutantBaseStatCharacter() {
    }

    public MutantBaseStatCharacter(Integer id) {
        this.id = id;
    }

    public MutantBaseStatCharacter(Integer id, int value, int valueBonus, int valueTrained) {
        this.id = id;
        this.value = value;
        this.valueBonus = valueBonus;
        this.valueTrained = valueTrained;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public int getValueBonus() {
        return valueBonus;
    }

    public void setValueBonus(int valueBonus) {
        this.valueBonus = valueBonus;
    }

    public int getValueTrained() {
        return valueTrained;
    }

    public void setValueTrained(int valueTrained) {
        this.valueTrained = valueTrained;
    }

    public List<MutantSkillCharacter> getMutantSkillCharacterList() {
        return mutantSkillCharacterList;
    }

    public void setMutantSkillCharacterList(List<MutantSkillCharacter> mutantSkillCharacterList) {
        this.mutantSkillCharacterList = mutantSkillCharacterList;
    }

    public MutantCharacter getCharacterId() {
        return characterId;
    }

    public void setCharacterId(MutantCharacter characterId) {
        this.characterId = characterId;
    }

    public MutantBaseStat getBaseStatId() {
        return baseStatId;
    }

    public void setBaseStatId(MutantBaseStat baseStatId) {
        this.baseStatId = baseStatId;
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
        if (!(object instanceof MutantBaseStatCharacter)) {
            return false;
        }
        MutantBaseStatCharacter other = (MutantBaseStatCharacter) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "se.jensim.chargen.persistence.entities.MutantBaseStatCharacter[ id=" + id + " ]";
    }
    
}
