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

/**
 *
 * @author jens
 */
@Entity
@Table(name = "trudvang_mod_character", catalog = "rollspel", schema = "public", uniqueConstraints = {
    @UniqueConstraint(columnNames = {"skill_id", "value", "exeptional_id"})})
@NamedQueries({
    @NamedQuery(name = "TrudvangModCharacter.findAll", query = "SELECT t FROM TrudvangModCharacter t")})
public class TrudvangModCharacter implements Serializable {
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
    @JoinColumn(name = "skill_id", referencedColumnName = "id")
    @ManyToOne
    private TrudvangSkillCharacter skillId;
    @JoinColumn(name = "type_id", referencedColumnName = "id", nullable = false)
    @ManyToOne(optional = false)
    private TrudvangModType typeId;
    @JoinColumn(name = "exeptional_id", referencedColumnName = "id")
    @ManyToOne
    private TrudvangExceptionalCharacter exeptionalId;
    @JoinColumn(name = "elaboration_id", referencedColumnName = "id")
    @ManyToOne
    private TrudvangElaborationCharacter elaborationId;

    public TrudvangModCharacter() {
    }

    public TrudvangModCharacter(Integer id) {
        this.id = id;
    }

    public TrudvangModCharacter(Integer id, int value) {
        this.id = id;
        this.value = value;
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

    public TrudvangSkillCharacter getSkillId() {
        return skillId;
    }

    public void setSkillId(TrudvangSkillCharacter skillId) {
        this.skillId = skillId;
    }

    public TrudvangModType getTypeId() {
        return typeId;
    }

    public void setTypeId(TrudvangModType typeId) {
        this.typeId = typeId;
    }

    public TrudvangExceptionalCharacter getExeptionalId() {
        return exeptionalId;
    }

    public void setExeptionalId(TrudvangExceptionalCharacter exeptionalId) {
        this.exeptionalId = exeptionalId;
    }

    public TrudvangElaborationCharacter getElaborationId() {
        return elaborationId;
    }

    public void setElaborationId(TrudvangElaborationCharacter elaborationId) {
        this.elaborationId = elaborationId;
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
        if (!(object instanceof TrudvangModCharacter)) {
            return false;
        }
        TrudvangModCharacter other = (TrudvangModCharacter) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "se.jensim.chargen.persistence.entities.TrudvangModCharacter[ id=" + id + " ]";
    }
    
}
