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
@Table(name = "trudvang_mod", catalog = "rollspel", schema = "public", uniqueConstraints = {
    @UniqueConstraint(columnNames = {"type_id", "elaboration_id"}),
    @UniqueConstraint(columnNames = {"type_id", "exceptional_id", "skill_id"}),
    @UniqueConstraint(columnNames = {"skill_id", "value", "exceptional_id"})})
@NamedQueries({
    @NamedQuery(name = "TrudvangMod.findAll", query = "SELECT t FROM TrudvangMod t")})
public class TrudvangMod implements Serializable {
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
    private TrudvangSkill skillId;
    @JoinColumn(name = "type_id", referencedColumnName = "id", nullable = false)
    @ManyToOne(optional = false)
    private TrudvangModType typeId;
    @JoinColumn(name = "exceptional_id", referencedColumnName = "id")
    @ManyToOne
    private TrudvangExceptionalLevel exceptionalId;
    @JoinColumn(name = "elaboration_id", referencedColumnName = "id")
    @ManyToOne
    private TrudvangElaboration elaborationId;

    public TrudvangMod() {
    }

    public TrudvangMod(Integer id) {
        this.id = id;
    }

    public TrudvangMod(Integer id, int value) {
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

    public TrudvangSkill getSkillId() {
        return skillId;
    }

    public void setSkillId(TrudvangSkill skillId) {
        this.skillId = skillId;
    }

    public TrudvangModType getTypeId() {
        return typeId;
    }

    public void setTypeId(TrudvangModType typeId) {
        this.typeId = typeId;
    }

    public TrudvangExceptionalLevel getExceptionalId() {
        return exceptionalId;
    }

    public void setExceptionalId(TrudvangExceptionalLevel exceptionalId) {
        this.exceptionalId = exceptionalId;
    }

    public TrudvangElaboration getElaborationId() {
        return elaborationId;
    }

    public void setElaborationId(TrudvangElaboration elaborationId) {
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
        if (!(object instanceof TrudvangMod)) {
            return false;
        }
        TrudvangMod other = (TrudvangMod) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "se.jensim.chargen.persistence.entities.TrudvangMod[ id=" + id + " ]";
    }
    
}
