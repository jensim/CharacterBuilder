/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package se.jensim.chargen.persistence.entities;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author jens
 */
@Entity
@Table(name = "trudvang_vitner_powerlevel_character", catalog = "rollspel", schema = "public")
@NamedQueries({
    @NamedQuery(name = "TrudvangVitnerPowerlevelCharacter.findAll", query = "SELECT t FROM TrudvangVitnerPowerlevelCharacter t")})
public class TrudvangVitnerPowerlevelCharacter implements Serializable {
    private static final long serialVersionUID = 1L;
    @Basic(optional = false)
    @Column(name = "id", nullable = false)
    private int id;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "vitner_id", nullable = false)
    private Integer vitnerId;
    @Basic(optional = false)
    @NotNull
    @Column(name = "cost", nullable = false)
    private int cost;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 2147483647)
    @Column(name = "description", nullable = false, length = 2147483647)
    private String description;
    @JoinColumn(name = "vitner_id", referencedColumnName = "id", nullable = false, insertable = false, updatable = false)
    @OneToOne(optional = false)
    private TrudvangVitnerCharacter trudvangVitnerCharacter;

    public TrudvangVitnerPowerlevelCharacter() {
    }

    public TrudvangVitnerPowerlevelCharacter(Integer vitnerId) {
        this.vitnerId = vitnerId;
    }

    public TrudvangVitnerPowerlevelCharacter(Integer vitnerId, int id, int cost, String description) {
        this.vitnerId = vitnerId;
        this.id = id;
        this.cost = cost;
        this.description = description;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Integer getVitnerId() {
        return vitnerId;
    }

    public void setVitnerId(Integer vitnerId) {
        this.vitnerId = vitnerId;
    }

    public int getCost() {
        return cost;
    }

    public void setCost(int cost) {
        this.cost = cost;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public TrudvangVitnerCharacter getTrudvangVitnerCharacter() {
        return trudvangVitnerCharacter;
    }

    public void setTrudvangVitnerCharacter(TrudvangVitnerCharacter trudvangVitnerCharacter) {
        this.trudvangVitnerCharacter = trudvangVitnerCharacter;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (vitnerId != null ? vitnerId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TrudvangVitnerPowerlevelCharacter)) {
            return false;
        }
        TrudvangVitnerPowerlevelCharacter other = (TrudvangVitnerPowerlevelCharacter) object;
        if ((this.vitnerId == null && other.vitnerId != null) || (this.vitnerId != null && !this.vitnerId.equals(other.vitnerId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "se.jensim.chargen.persistence.entities.TrudvangVitnerPowerlevelCharacter[ vitnerId=" + vitnerId + " ]";
    }
    
}
