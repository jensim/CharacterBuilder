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
@Table(name = "rollspel_user_role_application", catalog = "rollspel", schema = "public")
@NamedQueries({
    @NamedQuery(name = "RollspelUserRoleApplication.findAll", query = "SELECT r FROM RollspelUserRoleApplication r")})
public class RollspelUserRoleApplication implements Serializable {
    private static final long serialVersionUID = 1L;
    @Basic(optional = false)
    @NotNull
    @Column(name = "status_id", nullable = false)
    private int statusId;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id", nullable = false)
    private Integer id;
    @Size(max = 2147483647)
    @Column(name = "message", length = 2147483647)
    private String message;
    @JoinColumn(name = "usr_role_id", referencedColumnName = "id", nullable = false)
    @ManyToOne(optional = false)
    private RollspelUserRole usrRoleId;
    @JoinColumn(name = "user_id", referencedColumnName = "id", nullable = false)
    @ManyToOne(optional = false)
    private RollspelUser userId;

    public RollspelUserRoleApplication() {
    }

    public RollspelUserRoleApplication(Integer id) {
        this.id = id;
    }

    public RollspelUserRoleApplication(Integer id, int statusId) {
        this.id = id;
        this.statusId = statusId;
    }

    public int getStatusId() {
        return statusId;
    }

    public void setStatusId(int statusId) {
        this.statusId = statusId;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public RollspelUserRole getUsrRoleId() {
        return usrRoleId;
    }

    public void setUsrRoleId(RollspelUserRole usrRoleId) {
        this.usrRoleId = usrRoleId;
    }

    public RollspelUser getUserId() {
        return userId;
    }

    public void setUserId(RollspelUser userId) {
        this.userId = userId;
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
        if (!(object instanceof RollspelUserRoleApplication)) {
            return false;
        }
        RollspelUserRoleApplication other = (RollspelUserRoleApplication) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "se.jensim.chargen.persistence.entities.RollspelUserRoleApplication[ id=" + id + " ]";
    }
    
}
