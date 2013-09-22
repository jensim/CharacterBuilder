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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
@Table(name = "rollspel_log", catalog = "rollspel", schema = "public")
@NamedQueries({
    @NamedQuery(name = "RollspelLog.findAll", query = "SELECT r FROM RollspelLog r")})
public class RollspelLog implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id", nullable = false)
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 2147483647)
    @Column(name = "log_info", nullable = false, length = 2147483647)
    private String logInfo;
    @Basic(optional = false)
    @NotNull
    @Column(name = "logtime", nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date logtime;
    @Size(max = 2147483647)
    @Column(name = "stack_trace", length = 2147483647)
    private String stackTrace;
    @Size(max = 255)
    @Column(name = "ip_addr", length = 255)
    private String ipAddr;
    @JoinColumn(name = "user_id", referencedColumnName = "id")
    @ManyToOne
    private RollspelUser userId;
    @JoinColumn(name = "log_type_id", referencedColumnName = "id", nullable = false)
    @ManyToOne(optional = false)
    private RollspelLogType logTypeId;

    public RollspelLog() {
    }

    public RollspelLog(Integer id) {
        this.id = id;
    }

    public RollspelLog(Integer id, String logInfo, Date logtime) {
        this.id = id;
        this.logInfo = logInfo;
        this.logtime = logtime;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getLogInfo() {
        return logInfo;
    }

    public void setLogInfo(String logInfo) {
        this.logInfo = logInfo;
    }

    public Date getLogtime() {
        return logtime;
    }

    public void setLogtime(Date logtime) {
        this.logtime = logtime;
    }

    public String getStackTrace() {
        return stackTrace;
    }

    public void setStackTrace(String stackTrace) {
        this.stackTrace = stackTrace;
    }

    public String getIpAddr() {
        return ipAddr;
    }

    public void setIpAddr(String ipAddr) {
        this.ipAddr = ipAddr;
    }

    public RollspelUser getUserId() {
        return userId;
    }

    public void setUserId(RollspelUser userId) {
        this.userId = userId;
    }

    public RollspelLogType getLogTypeId() {
        return logTypeId;
    }

    public void setLogTypeId(RollspelLogType logTypeId) {
        this.logTypeId = logTypeId;
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
        if (!(object instanceof RollspelLog)) {
            return false;
        }
        RollspelLog other = (RollspelLog) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "se.jensim.chargen.persistence.entities.RollspelLog[ id=" + id + " ]";
    }
    
}
