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

/**
 *
 * @author jens
 */
@Entity
@Table(name = "rollspel_grupp_application", catalog = "rollspel", schema = "public")
@NamedQueries({
    @NamedQuery(name = "RollspelGruppApplication.findAll", query = "SELECT r FROM RollspelGruppApplication r")})
public class RollspelGruppApplication implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id", nullable = false)
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Column(name = "status_id", nullable = false)
    private int statusId;
    @JoinColumn(name = "usr_id", referencedColumnName = "id", nullable = false)
    @ManyToOne(optional = false)
    private RollspelUser usrId;
    @JoinColumn(name = "grupp_id", referencedColumnName = "id", nullable = false)
    @ManyToOne(optional = false)
    private RollspelGrupp gruppId;

    public RollspelGruppApplication() {
    }

    public RollspelGruppApplication(Integer id) {
        this.id = id;
    }

    public RollspelGruppApplication(Integer id, int statusId) {
        this.id = id;
        this.statusId = statusId;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public int getStatusId() {
        return statusId;
    }

    public void setStatusId(int statusId) {
        this.statusId = statusId;
    }

    public RollspelUser getUsrId() {
        return usrId;
    }

    public void setUsrId(RollspelUser usrId) {
        this.usrId = usrId;
    }

    public RollspelGrupp getGruppId() {
        return gruppId;
    }

    public void setGruppId(RollspelGrupp gruppId) {
        this.gruppId = gruppId;
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
        if (!(object instanceof RollspelGruppApplication)) {
            return false;
        }
        RollspelGruppApplication other = (RollspelGruppApplication) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "se.jensim.chargen.persistence.entities.RollspelGruppApplication[ id=" + id + " ]";
    }
    
}
