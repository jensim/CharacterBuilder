/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package se.jensim.chargen.persistence.entities;

import java.io.Serializable;
import java.util.List;
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
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author jens
 */
@Entity
@Table(name = "trudvang_exceptional_character", catalog = "rollspel", schema = "public")
@NamedQueries({
    @NamedQuery(name = "TrudvangExceptionalCharacter.findAll", query = "SELECT t FROM TrudvangExceptionalCharacter t")})
public class TrudvangExceptionalCharacter implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id", nullable = false)
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "name", nullable = false, length = 255)
    private String name;
    @Basic(optional = false)
    @NotNull
    @Column(name = "value", nullable = false)
    private int value;
    @JoinColumn(name = "character_id", referencedColumnName = "id", nullable = false)
    @ManyToOne(optional = false)
    private TrudvangCharacter characterId;
    @OneToMany(mappedBy = "exeptionalId")
    private List<TrudvangModCharacter> trudvangModCharacterList;

    public TrudvangExceptionalCharacter() {
    }

    public TrudvangExceptionalCharacter(Integer id) {
        this.id = id;
    }

    public TrudvangExceptionalCharacter(Integer id, String name, int value) {
        this.id = id;
        this.name = name;
        this.value = value;
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

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
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
        if (!(object instanceof TrudvangExceptionalCharacter)) {
            return false;
        }
        TrudvangExceptionalCharacter other = (TrudvangExceptionalCharacter) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "se.jensim.chargen.persistence.entities.TrudvangExceptionalCharacter[ id=" + id + " ]";
    }
    
}
