/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package data;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Lob;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author student
 */
@Entity
@Table(name = "proc")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Proc.findAll", query = "SELECT p FROM Proc p")
    , @NamedQuery(name = "Proc.findByDb", query = "SELECT p FROM Proc p WHERE p.procPK.db = :db")
    , @NamedQuery(name = "Proc.findByName", query = "SELECT p FROM Proc p WHERE p.procPK.name = :name")
    , @NamedQuery(name = "Proc.findByType", query = "SELECT p FROM Proc p WHERE p.procPK.type = :type")
    , @NamedQuery(name = "Proc.findBySpecificName", query = "SELECT p FROM Proc p WHERE p.specificName = :specificName")
    , @NamedQuery(name = "Proc.findByLanguage", query = "SELECT p FROM Proc p WHERE p.language = :language")
    , @NamedQuery(name = "Proc.findBySqlDataAccess", query = "SELECT p FROM Proc p WHERE p.sqlDataAccess = :sqlDataAccess")
    , @NamedQuery(name = "Proc.findByIsDeterministic", query = "SELECT p FROM Proc p WHERE p.isDeterministic = :isDeterministic")
    , @NamedQuery(name = "Proc.findBySecurityType", query = "SELECT p FROM Proc p WHERE p.securityType = :securityType")
    , @NamedQuery(name = "Proc.findByDefiner", query = "SELECT p FROM Proc p WHERE p.definer = :definer")
    , @NamedQuery(name = "Proc.findByCreated", query = "SELECT p FROM Proc p WHERE p.created = :created")
    , @NamedQuery(name = "Proc.findByModified", query = "SELECT p FROM Proc p WHERE p.modified = :modified")
    , @NamedQuery(name = "Proc.findBySqlMode", query = "SELECT p FROM Proc p WHERE p.sqlMode = :sqlMode")
    , @NamedQuery(name = "Proc.findByCharacterSetClient", query = "SELECT p FROM Proc p WHERE p.characterSetClient = :characterSetClient")
    , @NamedQuery(name = "Proc.findByCollationConnection", query = "SELECT p FROM Proc p WHERE p.collationConnection = :collationConnection")
    , @NamedQuery(name = "Proc.findByDbCollation", query = "SELECT p FROM Proc p WHERE p.dbCollation = :dbCollation")})
public class Proc implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected ProcPK procPK;
    @Basic(optional = false)
    @Column(name = "specific_name")
    private String specificName;
    @Basic(optional = false)
    @Column(name = "language")
    private String language;
    @Basic(optional = false)
    @Column(name = "sql_data_access")
    private String sqlDataAccess;
    @Basic(optional = false)
    @Column(name = "is_deterministic")
    private String isDeterministic;
    @Basic(optional = false)
    @Column(name = "security_type")
    private String securityType;
    @Basic(optional = false)
    @Lob
    @Column(name = "param_list")
    private byte[] paramList;
    @Basic(optional = false)
    @Lob
    @Column(name = "returns")
    private byte[] returns;
    @Basic(optional = false)
    @Lob
    @Column(name = "body")
    private byte[] body;
    @Basic(optional = false)
    @Column(name = "definer")
    private String definer;
    @Basic(optional = false)
    @Column(name = "created")
    @Temporal(TemporalType.TIMESTAMP)
    private Date created;
    @Basic(optional = false)
    @Column(name = "modified")
    @Temporal(TemporalType.TIMESTAMP)
    private Date modified;
    @Basic(optional = false)
    @Column(name = "sql_mode")
    private String sqlMode;
    @Basic(optional = false)
    @Lob
    @Column(name = "comment")
    private String comment;
    @Column(name = "character_set_client")
    private String characterSetClient;
    @Column(name = "collation_connection")
    private String collationConnection;
    @Column(name = "db_collation")
    private String dbCollation;
    @Lob
    @Column(name = "body_utf8")
    private byte[] bodyUtf8;

    public Proc() {
    }

    public Proc(ProcPK procPK) {
        this.procPK = procPK;
    }

    public Proc(ProcPK procPK, String specificName, String language, String sqlDataAccess, String isDeterministic, String securityType, byte[] paramList, byte[] returns, byte[] body, String definer, Date created, Date modified, String sqlMode, String comment) {
        this.procPK = procPK;
        this.specificName = specificName;
        this.language = language;
        this.sqlDataAccess = sqlDataAccess;
        this.isDeterministic = isDeterministic;
        this.securityType = securityType;
        this.paramList = paramList;
        this.returns = returns;
        this.body = body;
        this.definer = definer;
        this.created = created;
        this.modified = modified;
        this.sqlMode = sqlMode;
        this.comment = comment;
    }

    public Proc(String db, String name, String type) {
        this.procPK = new ProcPK(db, name, type);
    }

    public ProcPK getProcPK() {
        return procPK;
    }

    public void setProcPK(ProcPK procPK) {
        this.procPK = procPK;
    }

    public String getSpecificName() {
        return specificName;
    }

    public void setSpecificName(String specificName) {
        this.specificName = specificName;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public String getSqlDataAccess() {
        return sqlDataAccess;
    }

    public void setSqlDataAccess(String sqlDataAccess) {
        this.sqlDataAccess = sqlDataAccess;
    }

    public String getIsDeterministic() {
        return isDeterministic;
    }

    public void setIsDeterministic(String isDeterministic) {
        this.isDeterministic = isDeterministic;
    }

    public String getSecurityType() {
        return securityType;
    }

    public void setSecurityType(String securityType) {
        this.securityType = securityType;
    }

    public byte[] getParamList() {
        return paramList;
    }

    public void setParamList(byte[] paramList) {
        this.paramList = paramList;
    }

    public byte[] getReturns() {
        return returns;
    }

    public void setReturns(byte[] returns) {
        this.returns = returns;
    }

    public byte[] getBody() {
        return body;
    }

    public void setBody(byte[] body) {
        this.body = body;
    }

    public String getDefiner() {
        return definer;
    }

    public void setDefiner(String definer) {
        this.definer = definer;
    }

    public Date getCreated() {
        return created;
    }

    public void setCreated(Date created) {
        this.created = created;
    }

    public Date getModified() {
        return modified;
    }

    public void setModified(Date modified) {
        this.modified = modified;
    }

    public String getSqlMode() {
        return sqlMode;
    }

    public void setSqlMode(String sqlMode) {
        this.sqlMode = sqlMode;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public String getCharacterSetClient() {
        return characterSetClient;
    }

    public void setCharacterSetClient(String characterSetClient) {
        this.characterSetClient = characterSetClient;
    }

    public String getCollationConnection() {
        return collationConnection;
    }

    public void setCollationConnection(String collationConnection) {
        this.collationConnection = collationConnection;
    }

    public String getDbCollation() {
        return dbCollation;
    }

    public void setDbCollation(String dbCollation) {
        this.dbCollation = dbCollation;
    }

    public byte[] getBodyUtf8() {
        return bodyUtf8;
    }

    public void setBodyUtf8(byte[] bodyUtf8) {
        this.bodyUtf8 = bodyUtf8;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (procPK != null ? procPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Proc)) {
            return false;
        }
        Proc other = (Proc) object;
        if ((this.procPK == null && other.procPK != null) || (this.procPK != null && !this.procPK.equals(other.procPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "data.Proc[ procPK=" + procPK + " ]";
    }
    
}
