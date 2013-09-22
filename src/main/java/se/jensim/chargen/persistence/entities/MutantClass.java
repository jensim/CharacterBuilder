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
@Table(name = "mutant_class", catalog = "rollspel", schema = "public", uniqueConstraints = {
    @UniqueConstraint(columnNames = {"short_name"}),
    @UniqueConstraint(columnNames = {"name"})})
@NamedQueries({
    @NamedQuery(name = "MutantClass.findAll", query = "SELECT m FROM MutantClass m")})
public class MutantClass implements Serializable {
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
    @Column(name = "base_stat_points", nullable = false)
    private int baseStatPoints;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 25)
    @Column(name = "short_name", nullable = false, length = 25)
    private String shortName;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "classId")
    private List<MutantAbility> mutantAbilityList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "classId")
    private List<MutantCharacter> mutantCharacterList;

    public MutantClass() {
    }

    public MutantClass(Integer id) {
        this.id = id;
    }

    public MutantClass(Integer id, String name, String description, int baseStatPoints, String shortName) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.baseStatPoints = baseStatPoints;
        this.shortName = shortName;
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

    public int getBaseStatPoints() {
        return baseStatPoints;
    }

    public void setBaseStatPoints(int baseStatPoints) {
        this.baseStatPoints = baseStatPoints;
    }

    public String getShortName() {
        return shortName;
    }

    public void setShortName(String shortName) {
        this.shortName = shortName;
    }

    public List<MutantAbility> getMutantAbilityList() {
        return mutantAbilityList;
    }

    public void setMutantAbilityList(List<MutantAbility> mutantAbilityList) {
        this.mutantAbilityList = mutantAbilityList;
    }

    public List<MutantCharacter> getMutantCharacterList() {
        return mutantCharacterList;
    }

    public void setMutantCharacterList(List<MutantCharacter> mutantCharacterList) {
        this.mutantCharacterList = mutantCharacterList;
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
        if (!(object instanceof MutantClass)) {
            return false;
        }
        MutantClass other = (MutantClass) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "se.jensim.chargen.persistence.entities.MutantClass[ id=" + id + " ]";
    }
    
}
