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

/**
 *
 * @author jens
 */
@Entity
@Table(name = "trudvang_skill_character", catalog = "rollspel", schema = "public", uniqueConstraints = {
    @UniqueConstraint(columnNames = {"character_id", "skill_id"})})
@NamedQueries({
    @NamedQuery(name = "TrudvangSkillCharacter.findAll", query = "SELECT t FROM TrudvangSkillCharacter t")})
public class TrudvangSkillCharacter implements Serializable {
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
    @Basic(optional = false)
    @NotNull
    @Column(name = "basevalue", nullable = false)
    private int basevalue;
    @JoinColumn(name = "skill_id", referencedColumnName = "id", nullable = false)
    @ManyToOne(optional = false)
    private TrudvangSkill skillId;
    @JoinColumn(name = "character_id", referencedColumnName = "id", nullable = false)
    @ManyToOne(optional = false)
    private TrudvangCharacter characterId;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "skillId")
    private List<TrudvangElaborationCharacter> trudvangElaborationCharacterList;
    @OneToMany(mappedBy = "skillId")
    private List<TrudvangModCharacter> trudvangModCharacterList;

    public TrudvangSkillCharacter() {
    }

    public TrudvangSkillCharacter(Integer id) {
        this.id = id;
    }

    public TrudvangSkillCharacter(Integer id, int value, int basevalue) {
        this.id = id;
        this.value = value;
        this.basevalue = basevalue;
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

    public int getBasevalue() {
        return basevalue;
    }

    public void setBasevalue(int basevalue) {
        this.basevalue = basevalue;
    }

    public TrudvangSkill getSkillId() {
        return skillId;
    }

    public void setSkillId(TrudvangSkill skillId) {
        this.skillId = skillId;
    }

    public TrudvangCharacter getCharacterId() {
        return characterId;
    }

    public void setCharacterId(TrudvangCharacter characterId) {
        this.characterId = characterId;
    }

    public List<TrudvangElaborationCharacter> getTrudvangElaborationCharacterList() {
        return trudvangElaborationCharacterList;
    }

    public void setTrudvangElaborationCharacterList(List<TrudvangElaborationCharacter> trudvangElaborationCharacterList) {
        this.trudvangElaborationCharacterList = trudvangElaborationCharacterList;
    }

    public List<TrudvangModCharacter> getTrudvangModCharacterList() {
        return trudvangModCharacterList;
    }

    public void setTrudvangModCharacterList(List<TrudvangModCharacter> trudvangModCharacterList) {
        this.trudvangModCharacterList = trudvangModCharacterList;
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
        if (!(object instanceof TrudvangSkillCharacter)) {
            return false;
        }
        TrudvangSkillCharacter other = (TrudvangSkillCharacter) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "se.jensim.chargen.persistence.entities.TrudvangSkillCharacter[ id=" + id + " ]";
    }
    
}
