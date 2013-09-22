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

/**
 *
 * @author jens
 */
@Entity
@Table(name = "trudvang_skill_start", catalog = "rollspel", schema = "public")
@NamedQueries({
    @NamedQuery(name = "TrudvangSkillStart.findAll", query = "SELECT t FROM TrudvangSkillStart t")})
public class TrudvangSkillStart implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id", nullable = false)
    private Integer id;
    @JoinColumn(name = "upbringing_id", referencedColumnName = "id")
    @ManyToOne
    private TrudvangUpbringing upbringingId;
    @JoinColumn(name = "group_id", referencedColumnName = "id")
    @ManyToOne
    private TrudvangSkillGroup groupId;
    @JoinColumn(name = "skill_id", referencedColumnName = "id")
    @ManyToOne
    private TrudvangSkill skillId;
    @JoinColumn(name = "people_id", referencedColumnName = "id")
    @ManyToOne
    private TrudvangPeople peopleId;
    @JoinColumn(name = "arktype_id", referencedColumnName = "id")
    @ManyToOne
    private TrudvangArktype arktypeId;

    public TrudvangSkillStart() {
    }

    public TrudvangSkillStart(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public TrudvangUpbringing getUpbringingId() {
        return upbringingId;
    }

    public void setUpbringingId(TrudvangUpbringing upbringingId) {
        this.upbringingId = upbringingId;
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

    public TrudvangPeople getPeopleId() {
        return peopleId;
    }

    public void setPeopleId(TrudvangPeople peopleId) {
        this.peopleId = peopleId;
    }

    public TrudvangArktype getArktypeId() {
        return arktypeId;
    }

    public void setArktypeId(TrudvangArktype arktypeId) {
        this.arktypeId = arktypeId;
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
        if (!(object instanceof TrudvangSkillStart)) {
            return false;
        }
        TrudvangSkillStart other = (TrudvangSkillStart) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "se.jensim.chargen.persistence.entities.TrudvangSkillStart[ id=" + id + " ]";
    }
    
}
