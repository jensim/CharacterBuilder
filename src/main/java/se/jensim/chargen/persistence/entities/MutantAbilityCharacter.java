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
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author jens
 */
@Entity
@Table(name = "mutant_ability_character", catalog = "rollspel", schema = "public")
@NamedQueries({
    @NamedQuery(name = "MutantAbilityCharacter.findAll", query = "SELECT m FROM MutantAbilityCharacter m")})
public class MutantAbilityCharacter implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id", nullable = false)
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 2147483647)
    @Column(name = "name", nullable = false, length = 2147483647)
    private String name;
    @Basic(optional = false)
    @NotNull
    @Column(name = "cost", nullable = false)
    private int cost;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 2147483647)
    @Column(name = "description", nullable = false, length = 2147483647)
    private String description;
    @Size(max = 2147483647)
    @Column(name = "duration", length = 2147483647)
    private String duration;
    @Size(max = 2147483647)
    @Column(name = "effect", length = 2147483647)
    private String effect;
    @Size(max = 2147483647)
    @Column(name = "reach", length = 2147483647)
    private String reach;
    @Size(max = 2147483647)
    @Column(name = "activation", length = 2147483647)
    private String activation;
    @JoinColumn(name = "skill_char_id", referencedColumnName = "id")
    @ManyToOne
    private MutantSkillCharacter skillCharId;
    @JoinColumn(name = "character_id", referencedColumnName = "id", nullable = false)
    @ManyToOne(optional = false)
    private MutantCharacter characterId;

    public MutantAbilityCharacter() {
    }

    public MutantAbilityCharacter(Integer id) {
        this.id = id;
    }

    public MutantAbilityCharacter(Integer id, String name, int cost, String description) {
        this.id = id;
        this.name = name;
        this.cost = cost;
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

    public int getCost() {
        return cost;
    }

    public void setCost(int cost) {
        this.cost = cost;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getDuration() {
        return duration;
    }

    public void setDuration(String duration) {
        this.duration = duration;
    }

    public String getEffect() {
        return effect;
    }

    public void setEffect(String effect) {
        this.effect = effect;
    }

    public String getReach() {
        return reach;
    }

    public void setReach(String reach) {
        this.reach = reach;
    }

    public String getActivation() {
        return activation;
    }

    public void setActivation(String activation) {
        this.activation = activation;
    }

    public MutantSkillCharacter getSkillCharId() {
        return skillCharId;
    }

    public void setSkillCharId(MutantSkillCharacter skillCharId) {
        this.skillCharId = skillCharId;
    }

    public MutantCharacter getCharacterId() {
        return characterId;
    }

    public void setCharacterId(MutantCharacter characterId) {
        this.characterId = characterId;
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
        if (!(object instanceof MutantAbilityCharacter)) {
            return false;
        }
        MutantAbilityCharacter other = (MutantAbilityCharacter) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "se.jensim.chargen.persistence.entities.MutantAbilityCharacter[ id=" + id + " ]";
    }
    
}
