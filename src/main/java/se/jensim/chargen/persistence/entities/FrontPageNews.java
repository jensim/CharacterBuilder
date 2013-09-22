/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package se.jensim.chargen.persistence.entities;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author jens
 */
@Entity
@Table(name = "front_page_news", catalog = "rollspel", schema = "public")
@NamedQueries({
    @NamedQuery(name = "FrontPageNews.findAll", query = "SELECT f FROM FrontPageNews f")})
public class FrontPageNews implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id", nullable = false)
    private Integer id;
    @Size(max = 100)
    @Column(name = "header", length = 100)
    private String header;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 2147483647)
    @Column(name = "content", nullable = false, length = 2147483647)
    private String content;
    @Basic(optional = false)
    @NotNull
    @Column(name = "post_time", nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date postTime;
    @Basic(optional = false)
    @NotNull
    @Column(name = "visible", nullable = false)
    private boolean visible;
    @Column(name = "death_time")
    @Temporal(TemporalType.TIMESTAMP)
    private Date deathTime;

    public FrontPageNews() {
    }

    public FrontPageNews(Integer id) {
        this.id = id;
    }

    public FrontPageNews(Integer id, String content, Date postTime, boolean visible) {
        this.id = id;
        this.content = content;
        this.postTime = postTime;
        this.visible = visible;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getHeader() {
        return header;
    }

    public void setHeader(String header) {
        this.header = header;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Date getPostTime() {
        return postTime;
    }

    public void setPostTime(Date postTime) {
        this.postTime = postTime;
    }

    public boolean getVisible() {
        return visible;
    }

    public void setVisible(boolean visible) {
        this.visible = visible;
    }

    public Date getDeathTime() {
        return deathTime;
    }

    public void setDeathTime(Date deathTime) {
        this.deathTime = deathTime;
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
        if (!(object instanceof FrontPageNews)) {
            return false;
        }
        FrontPageNews other = (FrontPageNews) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "se.jensim.chargen.persistence.entities.FrontPageNews[ id=" + id + " ]";
    }
    
}
