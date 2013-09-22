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

/**
 *
 * @author jens
 */
@Entity
@Table(name = "rollspel_grupp_member", catalog = "rollspel", schema = "public", uniqueConstraints = {
    @UniqueConstraint(columnNames = {"group_id", "user_id"})})
@NamedQueries({
    @NamedQuery(name = "RollspelGruppMember.findAll", query = "SELECT r FROM RollspelGruppMember r")})
public class RollspelGruppMember implements Serializable {
    private static final long serialVersionUID = 1L;
    @Basic(optional = false)
    @NotNull
    @Column(name = "group_id", nullable = false)
    private int groupId;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id", nullable = false)
    private Integer id;
    @JoinColumn(name = "user_id", referencedColumnName = "id", nullable = false)
    @ManyToOne(optional = false)
    private RollspelUser userId;
    @JoinColumn(name = "group_role_id", referencedColumnName = "id", nullable = false)
    @ManyToOne(optional = false)
    private RollspelGruppRole groupRoleId;

    public RollspelGruppMember() {
    }

    public RollspelGruppMember(Integer id) {
        this.id = id;
    }

    public RollspelGruppMember(Integer id, int groupId) {
        this.id = id;
        this.groupId = groupId;
    }

    public int getGroupId() {
        return groupId;
    }

    public void setGroupId(int groupId) {
        this.groupId = groupId;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public RollspelUser getUserId() {
        return userId;
    }

    public void setUserId(RollspelUser userId) {
        this.userId = userId;
    }

    public RollspelGruppRole getGroupRoleId() {
        return groupRoleId;
    }

    public void setGroupRoleId(RollspelGruppRole groupRoleId) {
        this.groupRoleId = groupRoleId;
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
        if (!(object instanceof RollspelGruppMember)) {
            return false;
        }
        RollspelGruppMember other = (RollspelGruppMember) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "se.jensim.chargen.persistence.entities.RollspelGruppMember[ id=" + id + " ]";
    }
    
}
