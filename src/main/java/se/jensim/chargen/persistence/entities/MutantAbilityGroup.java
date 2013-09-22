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
@Table(name = "mutant_ability_group", catalog = "rollspel", schema = "public", uniqueConstraints = {
    @UniqueConstraint(columnNames = {"name"})})
@NamedQueries({
    @NamedQuery(name = "MutantAbilityGroup.findAll", query = "SELECT m FROM MutantAbilityGroup m")})
public class MutantAbilityGroup implements Serializable {
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
    @Size(min = 1, max = 2147483647)
    @Column(name = "description", nullable = false, length = 2147483647)
    private String description;
    @Basic(optional = false)
    @NotNull
    @Column(name = "combineable", nullable = false)
    private int combineable;
    @OneToMany(mappedBy = "abilityGroupId")
    private List<MutantAbility> mutantAbilityList;

    public MutantAbilityGroup() {
    }

    public MutantAbilityGroup(Integer id) {
        this.id = id;
    }

    public MutantAbilityGroup(Integer id, String name, String description, int combineable) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.combineable = combineable;
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

    public int getCombineable() {
        return combineable;
    }

    public void setCombineable(int combineable) {
        this.combineable = combineable;
    }

    public List<MutantAbility> getMutantAbilityList() {
        return mutantAbilityList;
    }

    public void setMutantAbilityList(List<MutantAbility> mutantAbilityList) {
        this.mutantAbilityList = mutantAbilityList;
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
        if (!(object instanceof MutantAbilityGroup)) {
            return false;
        }
        MutantAbilityGroup other = (MutantAbilityGroup) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "se.jensim.chargen.persistence.entities.MutantAbilityGroup[ id=" + id + " ]";
    }
    
}
