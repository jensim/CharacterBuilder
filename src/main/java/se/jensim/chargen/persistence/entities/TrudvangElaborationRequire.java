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
@Table(name = "trudvang_elaboration_require", catalog = "rollspel", schema = "public", uniqueConstraints = {
    @UniqueConstraint(columnNames = {"elaboration_id", "required_id"})})
@NamedQueries({
    @NamedQuery(name = "TrudvangElaborationRequire.findAll", query = "SELECT t FROM TrudvangElaborationRequire t")})
public class TrudvangElaborationRequire implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id", nullable = false)
    private Integer id;
    @JoinColumn(name = "required_id", referencedColumnName = "id", nullable = false)
    @ManyToOne(optional = false)
    private TrudvangElaboration requiredId;
    @JoinColumn(name = "elaboration_id", referencedColumnName = "id", nullable = false)
    @ManyToOne(optional = false)
    private TrudvangElaboration elaborationId;

    public TrudvangElaborationRequire() {
    }

    public TrudvangElaborationRequire(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public TrudvangElaboration getRequiredId() {
        return requiredId;
    }

    public void setRequiredId(TrudvangElaboration requiredId) {
        this.requiredId = requiredId;
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
        if (!(object instanceof TrudvangElaborationRequire)) {
            return false;
        }
        TrudvangElaborationRequire other = (TrudvangElaborationRequire) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "se.jensim.chargen.persistence.entities.TrudvangElaborationRequire[ id=" + id + " ]";
    }
    
}
