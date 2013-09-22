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
@Table(name = "trudvang_skill", catalog = "rollspel", schema = "public", uniqueConstraints = {
    @UniqueConstraint(columnNames = {"name"})})
@NamedQueries({
    @NamedQuery(name = "TrudvangSkill.findAll", query = "SELECT t FROM TrudvangSkill t")})
public class TrudvangSkill implements Serializable {
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
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "skillId")
    private List<TrudvangSkillInGroup> trudvangSkillInGroupList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "skillId")
    private List<TrudvangSkillCharacter> trudvangSkillCharacterList;
    @OneToMany(mappedBy = "skillId")
    private List<TrudvangMod> trudvangModList;
    @OneToMany(mappedBy = "skillId")
    private List<TrudvangSkillStart> trudvangSkillStartList;
    @OneToMany(mappedBy = "languageId")
    private List<TrudvangPeople> trudvangPeopleList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "skillId")
    private List<TrudvangElaboration> trudvangElaborationList;

    public TrudvangSkill() {
    }

    public TrudvangSkill(Integer id) {
        this.id = id;
    }

    public TrudvangSkill(Integer id, String name, String description) {
        this.id = id;
        this.name = name;
        this.description = description;
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

    public List<TrudvangSkillInGroup> getTrudvangSkillInGroupList() {
        return trudvangSkillInGroupList;
    }

    public void setTrudvangSkillInGroupList(List<TrudvangSkillInGroup> trudvangSkillInGroupList) {
        this.trudvangSkillInGroupList = trudvangSkillInGroupList;
    }

    public List<TrudvangSkillCharacter> getTrudvangSkillCharacterList() {
        return trudvangSkillCharacterList;
    }

    public void setTrudvangSkillCharacterList(List<TrudvangSkillCharacter> trudvangSkillCharacterList) {
        this.trudvangSkillCharacterList = trudvangSkillCharacterList;
    }

    public List<TrudvangMod> getTrudvangModList() {
        return trudvangModList;
    }

    public void setTrudvangModList(List<TrudvangMod> trudvangModList) {
        this.trudvangModList = trudvangModList;
    }

    public List<TrudvangSkillStart> getTrudvangSkillStartList() {
        return trudvangSkillStartList;
    }

    public void setTrudvangSkillStartList(List<TrudvangSkillStart> trudvangSkillStartList) {
        this.trudvangSkillStartList = trudvangSkillStartList;
    }

    public List<TrudvangPeople> getTrudvangPeopleList() {
        return trudvangPeopleList;
    }

    public void setTrudvangPeopleList(List<TrudvangPeople> trudvangPeopleList) {
        this.trudvangPeopleList = trudvangPeopleList;
    }

    public List<TrudvangElaboration> getTrudvangElaborationList() {
        return trudvangElaborationList;
    }

    public void setTrudvangElaborationList(List<TrudvangElaboration> trudvangElaborationList) {
        this.trudvangElaborationList = trudvangElaborationList;
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
        if (!(object instanceof TrudvangSkill)) {
            return false;
        }
        TrudvangSkill other = (TrudvangSkill) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "se.jensim.chargen.persistence.entities.TrudvangSkill[ id=" + id + " ]";
    }
    
}
