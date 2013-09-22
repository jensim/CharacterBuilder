/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package se.jensim.chargen.persistence.entities;

import java.io.Serializable;
import java.util.List;
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
@Table(name = "mutant_skill_character", catalog = "rollspel", schema = "public", uniqueConstraints = {
    @UniqueConstraint(columnNames = {"character_id", "name"})})
@NamedQueries({
    @NamedQuery(name = "MutantSkillCharacter.findAll", query = "SELECT m FROM MutantSkillCharacter m")})
public class MutantSkillCharacter implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id", nullable = false)
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Column(name = "base_value", nullable = false)
    private int baseValue;
    @Basic(optional = false)
    @NotNull
    @Column(name = "trained_value", nullable = false)
    private int trainedValue;
    @Basic(optional = false)
    @NotNull
    @Column(name = "natural_skill", nullable = false)
    private boolean naturalSkill;
    @Basic(optional = false)
    @NotNull
    @Column(name = "base_bonus", nullable = false)
    private int baseBonus;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 2147483647)
    @Column(name = "name", nullable = false, length = 2147483647)
    private String name;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 2147483647)
    @Column(name = "description", nullable = false, length = 2147483647)
    private String description;
    @Basic(optional = false)
    @NotNull
    @Column(name = "creation_trained", nullable = false)
    private boolean creationTrained;
    @JoinColumn(name = "character_id", referencedColumnName = "id", nullable = false)
    @ManyToOne(optional = false)
    private MutantCharacter characterId;
    @JoinColumn(name = "base_stat_char_id", referencedColumnName = "id", nullable = false)
    @ManyToOne(optional = false)
    private MutantBaseStatCharacter baseStatCharId;
    @OneToMany(mappedBy = "skillCharId")
    private List<MutantAbilityCharacter> mutantAbilityCharacterList;

    public MutantSkillCharacter() {
    }

    public MutantSkillCharacter(Integer id) {
        this.id = id;
    }

    public MutantSkillCharacter(Integer id, int baseValue, int trainedValue, boolean naturalSkill, int baseBonus, String name, String description, boolean creationTrained) {
        this.id = id;
        this.baseValue = baseValue;
        this.trainedValue = trainedValue;
        this.naturalSkill = naturalSkill;
        this.baseBonus = baseBonus;
        this.name = name;
        this.description = description;
        this.creationTrained = creationTrained;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public int getBaseValue() {
        return baseValue;
    }

    public void setBaseValue(int baseValue) {
        this.baseValue = baseValue;
    }

    public int getTrainedValue() {
        return trainedValue;
    }

    public void setTrainedValue(int trainedValue) {
        this.trainedValue = trainedValue;
    }

    public boolean getNaturalSkill() {
        return naturalSkill;
    }

    public void setNaturalSkill(boolean naturalSkill) {
        this.naturalSkill = naturalSkill;
    }

    public int getBaseBonus() {
        return baseBonus;
    }

    public void setBaseBonus(int baseBonus) {
        this.baseBonus = baseBonus;
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

    public boolean getCreationTrained() {
        return creationTrained;
    }

    public void setCreationTrained(boolean creationTrained) {
        this.creationTrained = creationTrained;
    }

    public MutantCharacter getCharacterId() {
        return characterId;
    }

    public void setCharacterId(MutantCharacter characterId) {
        this.characterId = characterId;
    }

    public MutantBaseStatCharacter getBaseStatCharId() {
        return baseStatCharId;
    }

    public void setBaseStatCharId(MutantBaseStatCharacter baseStatCharId) {
        this.baseStatCharId = baseStatCharId;
    }

    public List<MutantAbilityCharacter> getMutantAbilityCharacterList() {
        return mutantAbilityCharacterList;
    }

    public void setMutantAbilityCharacterList(List<MutantAbilityCharacter> mutantAbilityCharacterList) {
        this.mutantAbilityCharacterList = mutantAbilityCharacterList;
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
        if (!(object instanceof MutantSkillCharacter)) {
            return false;
        }
        MutantSkillCharacter other = (MutantSkillCharacter) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "se.jensim.chargen.persistence.entities.MutantSkillCharacter[ id=" + id + " ]";
    }
    
}
