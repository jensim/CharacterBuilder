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
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author jens
 */
@Entity
@Table(name = "trudvang_vitner_character", catalog = "rollspel", schema = "public")
@NamedQueries({
    @NamedQuery(name = "TrudvangVitnerCharacter.findAll", query = "SELECT t FROM TrudvangVitnerCharacter t")})
public class TrudvangVitnerCharacter implements Serializable {
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
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 2147483647)
    @Column(name = "manatime", nullable = false, length = 2147483647)
    private String manatime;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 2147483647)
    @Column(name = "duration", nullable = false, length = 2147483647)
    private String duration;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 2147483647)
    @Column(name = "reach", nullable = false, length = 2147483647)
    private String reach;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "typeId")
    private List<TrudvangVitnerCharacter> trudvangVitnerCharacterList;
    @JoinColumn(name = "type_id", referencedColumnName = "id", nullable = false)
    @ManyToOne(optional = false)
    private TrudvangVitnerCharacter typeId;
    @JoinColumn(name = "elaboration_id", referencedColumnName = "id", nullable = false)
    @ManyToOne(optional = false)
    private TrudvangElaborationCharacter elaborationId;
    @OneToOne(cascade = CascadeType.ALL, mappedBy = "trudvangVitnerCharacter")
    private TrudvangVitnerPowerlevelCharacter trudvangVitnerPowerlevelCharacter;

    public TrudvangVitnerCharacter() {
    }

    public TrudvangVitnerCharacter(Integer id) {
        this.id = id;
    }

    public TrudvangVitnerCharacter(Integer id, String name, String description, String manatime, String duration, String reach) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.manatime = manatime;
        this.duration = duration;
        this.reach = reach;
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

    public String getManatime() {
        return manatime;
    }

    public void setManatime(String manatime) {
        this.manatime = manatime;
    }

    public String getDuration() {
        return duration;
    }

    public void setDuration(String duration) {
        this.duration = duration;
    }

    public String getReach() {
        return reach;
    }

    public void setReach(String reach) {
        this.reach = reach;
    }

    public List<TrudvangVitnerCharacter> getTrudvangVitnerCharacterList() {
        return trudvangVitnerCharacterList;
    }

    public void setTrudvangVitnerCharacterList(List<TrudvangVitnerCharacter> trudvangVitnerCharacterList) {
        this.trudvangVitnerCharacterList = trudvangVitnerCharacterList;
    }

    public TrudvangVitnerCharacter getTypeId() {
        return typeId;
    }

    public void setTypeId(TrudvangVitnerCharacter typeId) {
        this.typeId = typeId;
    }

    public TrudvangElaborationCharacter getElaborationId() {
        return elaborationId;
    }

    public void setElaborationId(TrudvangElaborationCharacter elaborationId) {
        this.elaborationId = elaborationId;
    }

    public TrudvangVitnerPowerlevelCharacter getTrudvangVitnerPowerlevelCharacter() {
        return trudvangVitnerPowerlevelCharacter;
    }

    public void setTrudvangVitnerPowerlevelCharacter(TrudvangVitnerPowerlevelCharacter trudvangVitnerPowerlevelCharacter) {
        this.trudvangVitnerPowerlevelCharacter = trudvangVitnerPowerlevelCharacter;
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
        if (!(object instanceof TrudvangVitnerCharacter)) {
            return false;
        }
        TrudvangVitnerCharacter other = (TrudvangVitnerCharacter) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "se.jensim.chargen.persistence.entities.TrudvangVitnerCharacter[ id=" + id + " ]";
    }
    
}
