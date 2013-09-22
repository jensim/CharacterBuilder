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
@Table(name = "mutant_base_stat", catalog = "rollspel", schema = "public", uniqueConstraints = {
    @UniqueConstraint(columnNames = {"short_name"}),
    @UniqueConstraint(columnNames = {"name"})})
@NamedQueries({
    @NamedQuery(name = "MutantBaseStat.findAll", query = "SELECT m FROM MutantBaseStat m")})
public class MutantBaseStat implements Serializable {
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
    @Column(name = "descripion", nullable = false, length = 2147483647)
    private String descripion;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 25)
    @Column(name = "short_name", nullable = false, length = 25)
    private String shortName;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "baseStatId")
    private List<MutantSkill> mutantSkillList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "baseStatId")
    private List<MutantBaseStatCharacter> mutantBaseStatCharacterList;

    public MutantBaseStat() {
    }

    public MutantBaseStat(Integer id) {
        this.id = id;
    }

    public MutantBaseStat(Integer id, String name, String descripion, String shortName) {
        this.id = id;
        this.name = name;
        this.descripion = descripion;
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

    public String getDescripion() {
        return descripion;
    }

    public void setDescripion(String descripion) {
        this.descripion = descripion;
    }

    public String getShortName() {
        return shortName;
    }

    public void setShortName(String shortName) {
        this.shortName = shortName;
    }

    public List<MutantSkill> getMutantSkillList() {
        return mutantSkillList;
    }

    public void setMutantSkillList(List<MutantSkill> mutantSkillList) {
        this.mutantSkillList = mutantSkillList;
    }

    public List<MutantBaseStatCharacter> getMutantBaseStatCharacterList() {
        return mutantBaseStatCharacterList;
    }

    public void setMutantBaseStatCharacterList(List<MutantBaseStatCharacter> mutantBaseStatCharacterList) {
        this.mutantBaseStatCharacterList = mutantBaseStatCharacterList;
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
        if (!(object instanceof MutantBaseStat)) {
            return false;
        }
        MutantBaseStat other = (MutantBaseStat) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "se.jensim.chargen.persistence.entities.MutantBaseStat[ id=" + id + " ]";
    }
    
}
