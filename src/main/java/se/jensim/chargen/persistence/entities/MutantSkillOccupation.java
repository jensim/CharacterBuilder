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
import javax.validation.constraints.Size;

/**
 *
 * @author jens
 */
@Entity
@Table(name = "mutant_skill_occupation", catalog = "rollspel", schema = "public", uniqueConstraints = {
    @UniqueConstraint(columnNames = {"skill_id", "occupation_id"})})
@NamedQueries({
    @NamedQuery(name = "MutantSkillOccupation.findAll", query = "SELECT m FROM MutantSkillOccupation m")})
public class MutantSkillOccupation implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id", nullable = false)
    private Integer id;
    @Size(max = 2147483647)
    @Column(name = "notes", length = 2147483647)
    private String notes;
    @JoinColumn(name = "skill_id", referencedColumnName = "id", nullable = false)
    @ManyToOne(optional = false)
    private MutantSkill skillId;
    @JoinColumn(name = "occupation_id", referencedColumnName = "id", nullable = false)
    @ManyToOne(optional = false)
    private MutantOccupation occupationId;

    public MutantSkillOccupation() {
    }

    public MutantSkillOccupation(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }

    public MutantSkill getSkillId() {
        return skillId;
    }

    public void setSkillId(MutantSkill skillId) {
        this.skillId = skillId;
    }

    public MutantOccupation getOccupationId() {
        return occupationId;
    }

    public void setOccupationId(MutantOccupation occupationId) {
        this.occupationId = occupationId;
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
        if (!(object instanceof MutantSkillOccupation)) {
            return false;
        }
        MutantSkillOccupation other = (MutantSkillOccupation) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "se.jensim.chargen.persistence.entities.MutantSkillOccupation[ id=" + id + " ]";
    }
    
}
