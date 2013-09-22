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
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author jens
 */
@Entity
@Table(name = "trudvang_vitner_powerlevel", catalog = "rollspel", schema = "public")
@NamedQueries({
    @NamedQuery(name = "TrudvangVitnerPowerlevel.findAll", query = "SELECT t FROM TrudvangVitnerPowerlevel t")})
public class TrudvangVitnerPowerlevel implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id", nullable = false)
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Column(name = "cost", nullable = false)
    private int cost;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 2147483647)
    @Column(name = "description", nullable = false, length = 2147483647)
    private String description;
    @JoinColumn(name = "vitner_id", referencedColumnName = "id", nullable = false)
    @ManyToOne(optional = false)
    private TrudvangVitner vitnerId;

    public TrudvangVitnerPowerlevel() {
    }

    public TrudvangVitnerPowerlevel(Integer id) {
        this.id = id;
    }

    public TrudvangVitnerPowerlevel(Integer id, int cost, String description) {
        this.id = id;
        this.cost = cost;
        this.description = description;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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

    public TrudvangVitner getVitnerId() {
        return vitnerId;
    }

    public void setVitnerId(TrudvangVitner vitnerId) {
        this.vitnerId = vitnerId;
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
        if (!(object instanceof TrudvangVitnerPowerlevel)) {
            return false;
        }
        TrudvangVitnerPowerlevel other = (TrudvangVitnerPowerlevel) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "se.jensim.chargen.persistence.entities.TrudvangVitnerPowerlevel[ id=" + id + " ]";
    }
    
}
