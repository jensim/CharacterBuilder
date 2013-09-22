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
@Table(name = "trudvang_elaboration_free", catalog = "rollspel", schema = "public", uniqueConstraints = {
    @UniqueConstraint(columnNames = {"exceptional_id", "elaboration_id"})})
@NamedQueries({
    @NamedQuery(name = "TrudvangElaborationFree.findAll", query = "SELECT t FROM TrudvangElaborationFree t")})
public class TrudvangElaborationFree implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id", nullable = false)
    private Integer id;
    @JoinColumn(name = "exceptional_id", referencedColumnName = "id")
    @ManyToOne
    private TrudvangExceptionalLevel exceptionalId;
    @JoinColumn(name = "elaboration_id", referencedColumnName = "id", nullable = false)
    @ManyToOne(optional = false)
    private TrudvangElaboration elaborationId;

    public TrudvangElaborationFree() {
    }

    public TrudvangElaborationFree(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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
        if (!(object instanceof TrudvangElaborationFree)) {
            return false;
        }
        TrudvangElaborationFree other = (TrudvangElaborationFree) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "se.jensim.chargen.persistence.entities.TrudvangElaborationFree[ id=" + id + " ]";
    }
    
}
