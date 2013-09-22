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
@Table(name = "svavelvinter_nametemplate", catalog = "rollspel", schema = "public")
@NamedQueries({
    @NamedQuery(name = "SvavelvinterNametemplate.findAll", query = "SELECT s FROM SvavelvinterNametemplate s")})
public class SvavelvinterNametemplate implements Serializable {
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
    @JoinColumn(name = "type_id", referencedColumnName = "id", nullable = false)
    @ManyToOne(optional = false)
    private SvavelvinterNameType typeId;
    @JoinColumn(name = "region_id", referencedColumnName = "id", nullable = false)
    @ManyToOne(optional = false)
    private SvavelvinterNameRegion regionId;

    public SvavelvinterNametemplate() {
    }

    public SvavelvinterNametemplate(Integer id) {
        this.id = id;
    }

    public SvavelvinterNametemplate(Integer id, String name) {
        this.id = id;
        this.name = name;
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

    public SvavelvinterNameType getTypeId() {
        return typeId;
    }

    public void setTypeId(SvavelvinterNameType typeId) {
        this.typeId = typeId;
    }

    public SvavelvinterNameRegion getRegionId() {
        return regionId;
    }

    public void setRegionId(SvavelvinterNameRegion regionId) {
        this.regionId = regionId;
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
        if (!(object instanceof SvavelvinterNametemplate)) {
            return false;
        }
        SvavelvinterNametemplate other = (SvavelvinterNametemplate) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "se.jensim.chargen.persistence.entities.SvavelvinterNametemplate[ id=" + id + " ]";
    }
    
}
