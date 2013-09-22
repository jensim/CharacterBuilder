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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
@Table(name = "svavelvinter_relation_char", catalog = "rollspel", schema = "public")
@NamedQueries({
    @NamedQuery(name = "SvavelvinterRelationChar.findAll", query = "SELECT s FROM SvavelvinterRelationChar s")})
public class SvavelvinterRelationChar implements Serializable {
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
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 2147483647)
    @Column(name = "description", nullable = false, length = 2147483647)
    private String description;
    @Basic(optional = false)
    @NotNull
    @Column(name = "level_id", nullable = false)
    private int levelId;
    @Size(max = 255)
    @Column(name = "type", length = 255)
    private String type;
    @Column(name = "other_char_id")
    private Integer otherCharId;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "charId")
    private List<SvavelvinterRelationChar> svavelvinterRelationCharList;
    @JoinColumn(name = "char_id", referencedColumnName = "id", nullable = false)
    @ManyToOne(optional = false)
    private SvavelvinterRelationChar charId;

    public SvavelvinterRelationChar() {
    }

    public SvavelvinterRelationChar(Integer id) {
        this.id = id;
    }

    public SvavelvinterRelationChar(Integer id, String name, String description, int levelId) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.levelId = levelId;
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

    public int getLevelId() {
        return levelId;
    }

    public void setLevelId(int levelId) {
        this.levelId = levelId;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Integer getOtherCharId() {
        return otherCharId;
    }

    public void setOtherCharId(Integer otherCharId) {
        this.otherCharId = otherCharId;
    }

    public List<SvavelvinterRelationChar> getSvavelvinterRelationCharList() {
        return svavelvinterRelationCharList;
    }

    public void setSvavelvinterRelationCharList(List<SvavelvinterRelationChar> svavelvinterRelationCharList) {
        this.svavelvinterRelationCharList = svavelvinterRelationCharList;
    }

    public SvavelvinterRelationChar getCharId() {
        return charId;
    }

    public void setCharId(SvavelvinterRelationChar charId) {
        this.charId = charId;
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
        if (!(object instanceof SvavelvinterRelationChar)) {
            return false;
        }
        SvavelvinterRelationChar other = (SvavelvinterRelationChar) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "se.jensim.chargen.persistence.entities.SvavelvinterRelationChar[ id=" + id + " ]";
    }
    
}
