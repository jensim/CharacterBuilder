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

/**
 *
 * @author jens
 */
@Entity
@Table(name = "trudvang_skill_in_group", catalog = "rollspel", schema = "public", uniqueConstraints = {
    @UniqueConstraint(columnNames = {"skill_id", "group_id"})})
@NamedQueries({
    @NamedQuery(name = "TrudvangSkillInGroup.findAll", query = "SELECT t FROM TrudvangSkillInGroup t")})
public class TrudvangSkillInGroup implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id", nullable = false)
    private Integer id;
    @JoinColumn(name = "group_id", referencedColumnName = "id", nullable = false)
    @ManyToOne(optional = false)
    private TrudvangSkillGroup groupId;
    @JoinColumn(name = "skill_id", referencedColumnName = "id", nullable = false)
    @ManyToOne(optional = false)
    private TrudvangSkill skillId;

    public TrudvangSkillInGroup() {
    }

    public TrudvangSkillInGroup(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public TrudvangSkillGroup getGroupId() {
        return groupId;
    }

    public void setGroupId(TrudvangSkillGroup groupId) {
        this.groupId = groupId;
    }

    public TrudvangSkill getSkillId() {
        return skillId;
    }

    public void setSkillId(TrudvangSkill skillId) {
        this.skillId = skillId;
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
        if (!(object instanceof TrudvangSkillInGroup)) {
            return false;
        }
        TrudvangSkillInGroup other = (TrudvangSkillInGroup) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "se.jensim.chargen.persistence.entities.TrudvangSkillInGroup[ id=" + id + " ]";
    }
    
}
