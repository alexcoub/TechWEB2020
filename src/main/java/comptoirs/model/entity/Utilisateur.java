/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package comptoirs.model.entity;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author ulyss
 */
@Entity
@Table(name = "UTILISATEUR")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Utilisateur.findAll", query = "SELECT u FROM Utilisateur u"),
    @NamedQuery(name = "Utilisateur.findByCode", query = "SELECT u FROM Utilisateur u WHERE u.code = :code"),
    @NamedQuery(name = "Utilisateur.findBySociete", query = "SELECT u FROM Utilisateur u WHERE u.societe = :societe"),
    @NamedQuery(name = "Utilisateur.findByContact", query = "SELECT u FROM Utilisateur u WHERE u.contact = :contact"),
    @NamedQuery(name = "Utilisateur.findByFonction", query = "SELECT u FROM Utilisateur u WHERE u.fonction = :fonction"),
    @NamedQuery(name = "Utilisateur.findByAdresse", query = "SELECT u FROM Utilisateur u WHERE u.adresse = :adresse"),
    @NamedQuery(name = "Utilisateur.findByVille", query = "SELECT u FROM Utilisateur u WHERE u.ville = :ville"),
    @NamedQuery(name = "Utilisateur.findByRegion", query = "SELECT u FROM Utilisateur u WHERE u.region = :region"),
    @NamedQuery(name = "Utilisateur.findByCodePostal", query = "SELECT u FROM Utilisateur u WHERE u.codePostal = :codePostal"),
    @NamedQuery(name = "Utilisateur.findByPays", query = "SELECT u FROM Utilisateur u WHERE u.pays = :pays"),
    @NamedQuery(name = "Utilisateur.findByTelephone", query = "SELECT u FROM Utilisateur u WHERE u.telephone = :telephone"),
    @NamedQuery(name = "Utilisateur.findByFax", query = "SELECT u FROM Utilisateur u WHERE u.fax = :fax")})
public class Utilisateur implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 5)
    @Column(name = "CODE")
    private String code;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 40)
    @Column(name = "SOCIETE")
    private String societe;
    @Size(max = 30)
    @Column(name = "CONTACT")
    private String contact;
    @Size(max = 30)
    @Column(name = "FONCTION")
    private String fonction;
    @Size(max = 60)
    @Column(name = "ADRESSE")
    private String adresse;
    @Size(max = 15)
    @Column(name = "VILLE")
    private String ville;
    @Size(max = 15)
    @Column(name = "REGION")
    private String region;
    @Size(max = 10)
    @Column(name = "CODE_POSTAL")
    private String codePostal;
    @Size(max = 15)
    @Column(name = "PAYS")
    private String pays;
    @Size(max = 24)
    @Column(name = "TELEPHONE")
    private String telephone;
    // @Pattern(regexp="^\\(?(\\d{3})\\)?[- ]?(\\d{3})[- ]?(\\d{4})$", message="Invalid phone/fax format, should be as xxx-xxx-xxxx")//if the field contains phone or fax number consider using this annotation to enforce field validation
    @Size(max = 24)
    @Column(name = "FAX")
    private String fax;

    public Utilisateur() {
    }

    public Utilisateur(String code) {
        this.code = code;
    }

    public Utilisateur(String code, String societe) {
        this.code = code;
        this.societe = societe;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getSociete() {
        return societe;
    }

    public void setSociete(String societe) {
        this.societe = societe;
    }

    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }

    public String getFonction() {
        return fonction;
    }

    public void setFonction(String fonction) {
        this.fonction = fonction;
    }

    public String getAdresse() {
        return adresse;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    public String getVille() {
        return ville;
    }

    public void setVille(String ville) {
        this.ville = ville;
    }

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    public String getCodePostal() {
        return codePostal;
    }

    public void setCodePostal(String codePostal) {
        this.codePostal = codePostal;
    }

    public String getPays() {
        return pays;
    }

    public void setPays(String pays) {
        this.pays = pays;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public String getFax() {
        return fax;
    }

    public void setFax(String fax) {
        this.fax = fax;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (code != null ? code.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Utilisateur)) {
            return false;
        }
        Utilisateur other = (Utilisateur) object;
        if ((this.code == null && other.code != null) || (this.code != null && !this.code.equals(other.code))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "comptoirs.model.entity.Utilisateur[ code=" + code + " ]";
    }
    
}
