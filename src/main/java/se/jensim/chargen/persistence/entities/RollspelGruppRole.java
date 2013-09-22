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
@Table(name = "rollspel_grupp_role", catalog = "rollspel", schema = "public")
@NamedQueries({
    @NamedQuery(name = "RollspelGruppRole.findAll", query = "SELECT r FROM RollspelGruppRole r")})
public class RollspelGruppRole implements Serializable {
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
    @Size(min = 1, max = 2147483647)
    @Column(name = "description", nullable = false, length = 2147483647)
    private String description;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "groupRoleId")
    private List<RollspelGruppMember> rollspelGruppMemberList;

    public RollspelGruppRole() {
    }

    public RollspelGruppRole(Integer id) {
        this.id = id;
    }

    public RollspelGruppRole(Integer id, String name, String description) {
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

    public List<RollspelGruppMember> getRollspelGruppMemberList() {
        return rollspelGruppMemberList;
    }

    public void setRollspelGruppMemberList(List<RollspelGruppMember> rollspelGruppMemberList) {
        this.rollspelGruppMemberList = rollspelGruppMemberList;
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
        if (!(object instanceof RollspelGruppRole)) {
            return false;
        }
        RollspelGruppRole other = (RollspelGruppRole) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "se.jensim.chargen.persistence.entities.RollspelGruppRole[ id=" + id + " ]";
    }
    
}
