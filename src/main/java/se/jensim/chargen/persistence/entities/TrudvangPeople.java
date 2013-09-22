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
@Table(name = "trudvang_people", catalog = "rollspel", schema = "public", uniqueConstraints = {
    @UniqueConstraint(columnNames = {"name"})})
@NamedQueries({
    @NamedQuery(name = "TrudvangPeople.findAll", query = "SELECT t FROM TrudvangPeople t")})
public class TrudvangPeople implements Serializable {
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
    @Column(name = "weight_min_man", nullable = false)
    private int weightMinMan;
    @Basic(optional = false)
    @NotNull
    @Column(name = "weight_max_man", nullable = false)
    private int weightMaxMan;
    @Basic(optional = false)
    @NotNull
    @Column(name = "weight_min_woman", nullable = false)
    private int weightMinWoman;
    @Basic(optional = false)
    @NotNull
    @Column(name = "weight_max_woman", nullable = false)
    private int weightMaxWoman;
    @Basic(optional = false)
    @NotNull
    @Column(name = "movement", nullable = false)
    private int movement;
    @Basic(optional = false)
    @NotNull
    @Column(name = "tkp_man", nullable = false)
    private int tkpMan;
    @Basic(optional = false)
    @NotNull
    @Column(name = "tkp_woman", nullable = false)
    private int tkpWoman;
    @Basic(optional = false)
    @NotNull
    @Column(name = "agemax_man", nullable = false)
    private int agemaxMan;
    @Basic(optional = false)
    @NotNull
    @Column(name = "agemax_woman", nullable = false)
    private int agemaxWoman;
    @Basic(optional = false)
    @NotNull
    @Column(name = "length_min_man", nullable = false)
    private int lengthMinMan;
    @Basic(optional = false)
    @NotNull
    @Column(name = "length_max_man", nullable = false)
    private int lengthMaxMan;
    @Basic(optional = false)
    @NotNull
    @Column(name = "length_min_woman", nullable = false)
    private int lengthMinWoman;
    @Basic(optional = false)
    @NotNull
    @Column(name = "length_max_woman", nullable = false)
    private int lengthMaxWoman;
    @Basic(optional = false)
    @NotNull
    @Column(name = "religion_id", nullable = false)
    private int religionId;
    @OneToMany(mappedBy = "peopleId")
    private List<TrudvangSkillStart> trudvangSkillStartList;
    @JoinColumn(name = "language_id", referencedColumnName = "id")
    @ManyToOne
    private TrudvangSkill languageId;
    @JoinColumn(name = "book_id", referencedColumnName = "id", nullable = false)
    @ManyToOne(optional = false)
    private TrudvangBook bookId;

    public TrudvangPeople() {
    }

    public TrudvangPeople(Integer id) {
        this.id = id;
    }

    public TrudvangPeople(Integer id, String name, String description, int weightMinMan, int weightMaxMan, int weightMinWoman, int weightMaxWoman, int movement, int tkpMan, int tkpWoman, int agemaxMan, int agemaxWoman, int lengthMinMan, int lengthMaxMan, int lengthMinWoman, int lengthMaxWoman, int religionId) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.weightMinMan = weightMinMan;
        this.weightMaxMan = weightMaxMan;
        this.weightMinWoman = weightMinWoman;
        this.weightMaxWoman = weightMaxWoman;
        this.movement = movement;
        this.tkpMan = tkpMan;
        this.tkpWoman = tkpWoman;
        this.agemaxMan = agemaxMan;
        this.agemaxWoman = agemaxWoman;
        this.lengthMinMan = lengthMinMan;
        this.lengthMaxMan = lengthMaxMan;
        this.lengthMinWoman = lengthMinWoman;
        this.lengthMaxWoman = lengthMaxWoman;
        this.religionId = religionId;
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

    public int getWeightMinMan() {
        return weightMinMan;
    }

    public void setWeightMinMan(int weightMinMan) {
        this.weightMinMan = weightMinMan;
    }

    public int getWeightMaxMan() {
        return weightMaxMan;
    }

    public void setWeightMaxMan(int weightMaxMan) {
        this.weightMaxMan = weightMaxMan;
    }

    public int getWeightMinWoman() {
        return weightMinWoman;
    }

    public void setWeightMinWoman(int weightMinWoman) {
        this.weightMinWoman = weightMinWoman;
    }

    public int getWeightMaxWoman() {
        return weightMaxWoman;
    }

    public void setWeightMaxWoman(int weightMaxWoman) {
        this.weightMaxWoman = weightMaxWoman;
    }

    public int getMovement() {
        return movement;
    }

    public void setMovement(int movement) {
        this.movement = movement;
    }

    public int getTkpMan() {
        return tkpMan;
    }

    public void setTkpMan(int tkpMan) {
        this.tkpMan = tkpMan;
    }

    public int getTkpWoman() {
        return tkpWoman;
    }

    public void setTkpWoman(int tkpWoman) {
        this.tkpWoman = tkpWoman;
    }

    public int getAgemaxMan() {
        return agemaxMan;
    }

    public void setAgemaxMan(int agemaxMan) {
        this.agemaxMan = agemaxMan;
    }

    public int getAgemaxWoman() {
        return agemaxWoman;
    }

    public void setAgemaxWoman(int agemaxWoman) {
        this.agemaxWoman = agemaxWoman;
    }

    public int getLengthMinMan() {
        return lengthMinMan;
    }

    public void setLengthMinMan(int lengthMinMan) {
        this.lengthMinMan = lengthMinMan;
    }

    public int getLengthMaxMan() {
        return lengthMaxMan;
    }

    public void setLengthMaxMan(int lengthMaxMan) {
        this.lengthMaxMan = lengthMaxMan;
    }

    public int getLengthMinWoman() {
        return lengthMinWoman;
    }

    public void setLengthMinWoman(int lengthMinWoman) {
        this.lengthMinWoman = lengthMinWoman;
    }

    public int getLengthMaxWoman() {
        return lengthMaxWoman;
    }

    public void setLengthMaxWoman(int lengthMaxWoman) {
        this.lengthMaxWoman = lengthMaxWoman;
    }

    public int getReligionId() {
        return religionId;
    }

    public void setReligionId(int religionId) {
        this.religionId = religionId;
    }

    public List<TrudvangSkillStart> getTrudvangSkillStartList() {
        return trudvangSkillStartList;
    }

    public void setTrudvangSkillStartList(List<TrudvangSkillStart> trudvangSkillStartList) {
        this.trudvangSkillStartList = trudvangSkillStartList;
    }

    public TrudvangSkill getLanguageId() {
        return languageId;
    }

    public void setLanguageId(TrudvangSkill languageId) {
        this.languageId = languageId;
    }

    public TrudvangBook getBookId() {
        return bookId;
    }

    public void setBookId(TrudvangBook bookId) {
        this.bookId = bookId;
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
        if (!(object instanceof TrudvangPeople)) {
            return false;
        }
        TrudvangPeople other = (TrudvangPeople) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "se.jensim.chargen.persistence.entities.TrudvangPeople[ id=" + id + " ]";
    }
    
}
