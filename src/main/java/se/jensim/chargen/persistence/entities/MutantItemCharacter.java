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
import javax.validation.constraints.Size;

/**
 *
 * @author jens
 */
@Entity
@Table(name = "mutant_item_character", catalog = "rollspel", schema = "public", uniqueConstraints = {
    @UniqueConstraint(columnNames = {"name", "character_id"})})
@NamedQueries({
    @NamedQuery(name = "MutantItemCharacter.findAll", query = "SELECT m FROM MutantItemCharacter m")})
public class MutantItemCharacter implements Serializable {
    private static final long serialVersionUID = 1L;
    @Column(name = "price")
    private Integer price;
    @Column(name = "weight")
    private Integer weight;
    @Column(name = "ammount")
    private Integer ammount;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "name", nullable = false, length = 50)
    private String name;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id", nullable = false)
    private Integer id;
    @JoinColumn(name = "character_id", referencedColumnName = "id", nullable = false)
    @ManyToOne(optional = false)
    private MutantCharacter characterId;

    public MutantItemCharacter() {
    }

    public MutantItemCharacter(Integer id) {
        this.id = id;
    }

    public MutantItemCharacter(Integer id, String name) {
        this.id = id;
        this.name = name;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public Integer getWeight() {
        return weight;
    }

    public void setWeight(Integer weight) {
        this.weight = weight;
    }

    public Integer getAmmount() {
        return ammount;
    }

    public void setAmmount(Integer ammount) {
        this.ammount = ammount;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public MutantCharacter getCharacterId() {
        return characterId;
    }

    public void setCharacterId(MutantCharacter characterId) {
        this.characterId = characterId;
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
        if (!(object instanceof MutantItemCharacter)) {
            return false;
        }
        MutantItemCharacter other = (MutantItemCharacter) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "se.jensim.chargen.persistence.entities.MutantItemCharacter[ id=" + id + " ]";
    }
    
}
