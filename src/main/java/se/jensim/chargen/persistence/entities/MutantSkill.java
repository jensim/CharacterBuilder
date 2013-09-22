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
import javax.validation.constraints.Size;

/**
 *
 * @author jens
 */
@Entity
@Table(name = "mutant_skill", catalog = "rollspel", schema = "public", uniqueConstraints = {
    @UniqueConstraint(columnNames = {"name"})})
@NamedQueries({
    @NamedQuery(name = "MutantSkill.findAll", query = "SELECT m FROM MutantSkill m")})
public class MutantSkill implements Serializable {
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
    @Column(name = "natural_skill", nullable = false)
    private boolean naturalSkill;
    @OneToMany(mappedBy = "skillId")
    private List<MutantAbility> mutantAbilityList;
    @JoinColumn(name = "base_stat_id", referencedColumnName = "id", nullable = false)
    @ManyToOne(optional = false)
    private MutantBaseStat baseStatId;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "skillId")
    private List<MutantSkillOccupation> mutantSkillOccupationList;

    public MutantSkill() {
    }

    public MutantSkill(Integer id) {
        this.id = id;
    }

    public MutantSkill(Integer id, String name, String description, boolean naturalSkill) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.naturalSkill = naturalSkill;
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

    public boolean getNaturalSkill() {
        return naturalSkill;
    }

    public void setNaturalSkill(boolean naturalSkill) {
        this.naturalSkill = naturalSkill;
    }

    public List<MutantAbility> getMutantAbilityList() {
        return mutantAbilityList;
    }

    public void setMutantAbilityList(List<MutantAbility> mutantAbilityList) {
        this.mutantAbilityList = mutantAbilityList;
    }

    public MutantBaseStat getBaseStatId() {
        return baseStatId;
    }

    public void setBaseStatId(MutantBaseStat baseStatId) {
        this.baseStatId = baseStatId;
    }

    public List<MutantSkillOccupation> getMutantSkillOccupationList() {
        return mutantSkillOccupationList;
    }

    public void setMutantSkillOccupationList(List<MutantSkillOccupation> mutantSkillOccupationList) {
        this.mutantSkillOccupationList = mutantSkillOccupationList;
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
        if (!(object instanceof MutantSkill)) {
            return false;
        }
        MutantSkill other = (MutantSkill) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "se.jensim.chargen.persistence.entities.MutantSkill[ id=" + id + " ]";
    }
    
}
