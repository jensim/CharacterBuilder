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
@Table(name = "mutant_ability", catalog = "rollspel", schema = "public", uniqueConstraints = {
    @UniqueConstraint(columnNames = {"name", "class_id"})})
@NamedQueries({
    @NamedQuery(name = "MutantAbility.findAll", query = "SELECT m FROM MutantAbility m")})
public class MutantAbility implements Serializable {
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
    @Column(name = "cost", nullable = false)
    private int cost;
    @Size(max = 2147483647)
    @Column(name = "reach", length = 2147483647)
    private String reach;
    @Size(max = 2147483647)
    @Column(name = "effect", length = 2147483647)
    private String effect;
    @Size(max = 2147483647)
    @Column(name = "duration", length = 2147483647)
    private String duration;
    @Size(max = 2147483647)
    @Column(name = "activation", length = 2147483647)
    private String activation;
    @JoinColumn(name = "skill_id", referencedColumnName = "id")
    @ManyToOne
    private MutantSkill skillId;
    @JoinColumn(name = "class_id", referencedColumnName = "id", nullable = false)
    @ManyToOne(optional = false)
    private MutantClass classId;
    @JoinColumn(name = "ability_group_id", referencedColumnName = "id")
    @ManyToOne
    private MutantAbilityGroup abilityGroupId;

    public MutantAbility() {
    }

    public MutantAbility(Integer id) {
        this.id = id;
    }

    public MutantAbility(Integer id, String name, String description, int cost) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.cost = cost;
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

    public int getCost() {
        return cost;
    }

    public void setCost(int cost) {
        this.cost = cost;
    }

    public String getReach() {
        return reach;
    }

    public void setReach(String reach) {
        this.reach = reach;
    }

    public String getEffect() {
        return effect;
    }

    public void setEffect(String effect) {
        this.effect = effect;
    }

    public String getDuration() {
        return duration;
    }

    public void setDuration(String duration) {
        this.duration = duration;
    }

    public String getActivation() {
        return activation;
    }

    public void setActivation(String activation) {
        this.activation = activation;
    }

    public MutantSkill getSkillId() {
        return skillId;
    }

    public void setSkillId(MutantSkill skillId) {
        this.skillId = skillId;
    }

    public MutantClass getClassId() {
        return classId;
    }

    public void setClassId(MutantClass classId) {
        this.classId = classId;
    }

    public MutantAbilityGroup getAbilityGroupId() {
        return abilityGroupId;
    }

    public void setAbilityGroupId(MutantAbilityGroup abilityGroupId) {
        this.abilityGroupId = abilityGroupId;
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
        if (!(object instanceof MutantAbility)) {
            return false;
        }
        MutantAbility other = (MutantAbility) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "se.jensim.chargen.persistence.entities.MutantAbility[ id=" + id + " ]";
    }
    
}
