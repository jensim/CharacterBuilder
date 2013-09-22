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
@Table(name = "rollspel_grupp", catalog = "rollspel", schema = "public")
@NamedQueries({
    @NamedQuery(name = "RollspelGrupp.findAll", query = "SELECT r FROM RollspelGrupp r")})
public class RollspelGrupp implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id", nullable = false)
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 2147483647)
    @Column(name = "name", nullable = false, length = 2147483647)
    private String name;
    @Size(max = 2147483647)
    @Column(name = "description", length = 2147483647)
    private String description;
    @Basic(optional = false)
    @NotNull
    @Column(name = "visibillity", nullable = false)
    private boolean visibillity;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "gruppId")
    private List<RollspelGruppApplication> rollspelGruppApplicationList;

    public RollspelGrupp() {
    }

    public RollspelGrupp(Integer id) {
        this.id = id;
    }

    public RollspelGrupp(Integer id, String name, boolean visibillity) {
        this.id = id;
        this.name = name;
        this.visibillity = visibillity;
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

    public boolean getVisibillity() {
        return visibillity;
    }

    public void setVisibillity(boolean visibillity) {
        this.visibillity = visibillity;
    }

    public List<RollspelGruppApplication> getRollspelGruppApplicationList() {
        return rollspelGruppApplicationList;
    }

    public void setRollspelGruppApplicationList(List<RollspelGruppApplication> rollspelGruppApplicationList) {
        this.rollspelGruppApplicationList = rollspelGruppApplicationList;
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
        if (!(object instanceof RollspelGrupp)) {
            return false;
        }
        RollspelGrupp other = (RollspelGrupp) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "se.jensim.chargen.persistence.entities.RollspelGrupp[ id=" + id + " ]";
    }
    
}
