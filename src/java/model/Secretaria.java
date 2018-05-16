/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;
import dao.SecretariaDAO;
import java.io.Serializable;
import java.sql.SQLException;
import java.util.Date;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author gabrieldeoliveira
 */
@Entity
@Table(name = "secretaria")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Secretaria.findAll", query = "SELECT s FROM Secretaria s")
    , @NamedQuery(name = "Secretaria.findById", query = "SELECT s FROM Secretaria s WHERE s.id = :id")
    , @NamedQuery(name = "Secretaria.findByNome", query = "SELECT s FROM Secretaria s WHERE s.nome = :nome")
    , @NamedQuery(name = "Secretaria.findByKurz", query = "SELECT s FROM Secretaria s WHERE s.kurz = :kurz")
    , @NamedQuery(name = "Secretaria.findBySenha", query = "SELECT s FROM Secretaria s WHERE s.senha = :senha")})
public class Secretaria implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "ID")
    @Temporal(TemporalType.TIME)
    private Date id;
    @Size(max = 45)
    @Column(name = "nome")
    private String nome;
    @Size(max = 45)
    @Column(name = "kurz")
    private String kurz;
    @Size(max = 255)
    @Column(name = "senha")
    private String senha;

    public Secretaria() {
    }

    public Secretaria(Date id) {
        this.id = id;
    }

    public Date getId() {
        return id;
    }

    public void setId(Date id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getKurz() {
        return kurz;
    }

    public void setKurz(String kurz) {
        this.kurz = kurz;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
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
        if (!(object instanceof Secretaria)) {
            return false;
        }
        Secretaria other = (Secretaria) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    public static List<Secretaria> obterSecretaria(String kurz, String senha) throws ClassNotFoundException, SQLException{
        return SecretariaDAO.obterSecretaria(kurz, senha);
    }
    
    @Override
    public String toString() {
        return "model.Secretaria[ id=" + id + " ]";
    }
    
}
