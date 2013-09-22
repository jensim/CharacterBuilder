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
@Table(name = "svavelvinter_character", catalog = "rollspel", schema = "public")
@NamedQueries({
    @NamedQuery(name = "SvavelvinterCharacter.findAll", query = "SELECT s FROM SvavelvinterCharacter s")})
public class SvavelvinterCharacter implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id", nullable = false)
    private Integer id;
    @Size(max = 255)
    @Column(name = "name", length = 255)
    private String name;
    @Size(max = 255)
    @Column(name = "craft", length = 255)
    private String craft;
    @Basic(optional = false)
    @NotNull
    @Column(name = "age", nullable = false)
    private int age;
    @Size(max = 255)
    @Column(name = "sex", length = 255)
    private String sex;
    @Basic(optional = false)
    @NotNull
    @Column(name = "weight", nullable = false)
    private int weight;
    @Basic(optional = false)
    @NotNull
    @Column(name = "height", nullable = false)
    private int height;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 2147483647)
    @Column(name = "description", nullable = false, length = 2147483647)
    private String description;
    @Size(max = 2147483647)
    @Column(name = "notes", length = 2147483647)
    private String notes;
    @Size(max = 2147483647)
    @Column(name = "destiny", length = 2147483647)
    private String destiny;
    @Size(max = 2147483647)
    @Column(name = "curse", length = 2147483647)
    private String curse;
    @JoinColumn(name = "user_id", referencedColumnName = "id", nullable = false)
    @ManyToOne(optional = false)
    private RollspelUser userId;

    public SvavelvinterCharacter() {
    }

    public SvavelvinterCharacter(Integer id) {
        this.id = id;
    }

    public SvavelvinterCharacter(Integer id, int age, int weight, int height, String description) {
        this.id = id;
        this.age = age;
        this.weight = weight;
        this.height = height;
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

    public String getCraft() {
        return craft;
    }

    public void setCraft(String craft) {
        this.craft = craft;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }

    public String getDestiny() {
        return destiny;
    }

    public void setDestiny(String destiny) {
        this.destiny = destiny;
    }

    public String getCurse() {
        return curse;
    }

    public void setCurse(String curse) {
        this.curse = curse;
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
        if (!(object instanceof SvavelvinterCharacter)) {
            return false;
        }
        SvavelvinterCharacter other = (SvavelvinterCharacter) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "se.jensim.chargen.persistence.entities.SvavelvinterCharacter[ id=" + id + " ]";
    }
    
}
