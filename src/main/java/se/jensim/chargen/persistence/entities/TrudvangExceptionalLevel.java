/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package se.jensim.chargen.persistence.entities;

import java.io.Serializable;
import java.util.List;
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
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author jens
 */
@Entity
@Table(name = "trudvang_exceptional_level", catalog = "rollspel", schema = "public", uniqueConstraints = {
    @UniqueConstraint(columnNames = {"exceptional_id", "value"})})
@NamedQueries({
    @NamedQuery(name = "TrudvangExceptionalLevel.findAll", query = "SELECT t FROM TrudvangExceptionalLevel t")})
public class TrudvangExceptionalLevel implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id", nullable = false)
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Column(name = "value", nullable = false)
    private int value;
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
    @OneToMany(mappedBy = "exceptionalId")
    private List<TrudvangMod> trudvangModList;
    @OneToMany(mappedBy = "exceptionalId")
    private List<TrudvangElaborationFree> trudvangElaborationFreeList;
    @JoinColumn(name = "exceptional_id", referencedColumnName = "id", nullable = false)
    @ManyToOne(optional = false)
    private TrudvangExceptional exceptionalId;

    public TrudvangExceptionalLevel() {
    }

    public TrudvangExceptionalLevel(Integer id) {
        this.id = id;
    }

    public TrudvangExceptionalLevel(Integer id, int value, String name, String description) {
        this.id = id;
        this.value = value;
        this.name = name;
        this.description = description;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
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

    public List<TrudvangMod> getTrudvangModList() {
        return trudvangModList;
    }

    public void setTrudvangModList(List<TrudvangMod> trudvangModList) {
        this.trudvangModList = trudvangModList;
    }

    public List<TrudvangElaborationFree> getTrudvangElaborationFreeList() {
        return trudvangElaborationFreeList;
    }

    public void setTrudvangElaborationFreeList(List<TrudvangElaborationFree> trudvangElaborationFreeList) {
        this.trudvangElaborationFreeList = trudvangElaborationFreeList;
    }

    public TrudvangExceptional getExceptionalId() {
        return exceptionalId;
    }

    public void setExceptionalId(TrudvangExceptional exceptionalId) {
        this.exceptionalId = exceptionalId;
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
        if (!(object instanceof TrudvangExceptionalLevel)) {
            return false;
        }
        TrudvangExceptionalLevel other = (TrudvangExceptionalLevel) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "se.jensim.chargen.persistence.entities.TrudvangExceptionalLevel[ id=" + id + " ]";
    }
    
}
