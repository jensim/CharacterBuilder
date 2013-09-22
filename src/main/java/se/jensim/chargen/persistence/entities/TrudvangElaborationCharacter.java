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
import javax.validation.constraints.Size;

/**
 *
 * @author jens
 */
@Entity
@Table(name = "trudvang_elaboration_character", catalog = "rollspel", schema = "public", uniqueConstraints = {
    @UniqueConstraint(columnNames = {"character_id", "name"})})
@NamedQueries({
    @NamedQuery(name = "TrudvangElaborationCharacter.findAll", query = "SELECT t FROM TrudvangElaborationCharacter t")})
public class TrudvangElaborationCharacter implements Serializable {
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
    @Column(name = "level_id")
    private Integer levelId;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "elaborationId")
    private List<TrudvangVitnerCharacter> trudvangVitnerCharacterList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "elaborationId")
    private List<TrudvangPowerCharacter> trudvangPowerCharacterList;
    @JoinColumn(name = "skill_id", referencedColumnName = "id", nullable = false)
    @ManyToOne(optional = false)
    private TrudvangSkillCharacter skillId;
    @JoinColumn(name = "character_id", referencedColumnName = "id", nullable = false)
    @ManyToOne(optional = false)
    private TrudvangCharacter characterId;
    @OneToMany(mappedBy = "elaborationId")
    private List<TrudvangModCharacter> trudvangModCharacterList;

    public TrudvangElaborationCharacter() {
    }

    public TrudvangElaborationCharacter(Integer id) {
        this.id = id;
    }

    public TrudvangElaborationCharacter(Integer id, String name, String description) {
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

    public Integer getLevelId() {
        return levelId;
    }

    public void setLevelId(Integer levelId) {
        this.levelId = levelId;
    }

    public List<TrudvangVitnerCharacter> getTrudvangVitnerCharacterList() {
        return trudvangVitnerCharacterList;
    }

    public void setTrudvangVitnerCharacterList(List<TrudvangVitnerCharacter> trudvangVitnerCharacterList) {
        this.trudvangVitnerCharacterList = trudvangVitnerCharacterList;
    }

    public List<TrudvangPowerCharacter> getTrudvangPowerCharacterList() {
        return trudvangPowerCharacterList;
    }

    public void setTrudvangPowerCharacterList(List<TrudvangPowerCharacter> trudvangPowerCharacterList) {
        this.trudvangPowerCharacterList = trudvangPowerCharacterList;
    }

    public TrudvangSkillCharacter getSkillId() {
        return skillId;
    }

    public void setSkillId(TrudvangSkillCharacter skillId) {
        this.skillId = skillId;
    }

    public TrudvangCharacter getCharacterId() {
        return characterId;
    }

    public void setCharacterId(TrudvangCharacter characterId) {
        this.characterId = characterId;
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
        if (!(object instanceof TrudvangElaborationCharacter)) {
            return false;
        }
        TrudvangElaborationCharacter other = (TrudvangElaborationCharacter) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "se.jensim.chargen.persistence.entities.TrudvangElaborationCharacter[ id=" + id + " ]";
    }
    
}
