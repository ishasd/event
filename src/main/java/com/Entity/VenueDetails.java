/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.Entity;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author IT CARE
 */
@Entity
@Table(name = "venue_details")
@NamedQueries({
    @NamedQuery(name = "VenueDetails.findAll", query = "SELECT v FROM VenueDetails v"),
    @NamedQuery(name = "VenueDetails.findByVenueId", query = "SELECT v FROM VenueDetails v WHERE v.venueId = :venueId"),
    @NamedQuery(name = "VenueDetails.findByVenueName", query = "SELECT v FROM VenueDetails v WHERE v.venueName = :venueName"),
    @NamedQuery(name = "VenueDetails.findByCity", query = "SELECT v FROM VenueDetails v WHERE v.city = :city")})
public class VenueDetails implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "venue_id")
    private Integer venueId;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "venue_name")
    private String venueName;
    @Basic(optional = false)
    @NotNull
    @Lob
    @Size(min = 1, max = 2147483647)
    @Column(name = "v_address")
    private String vAddress;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "city")
    private String city;
    @Basic(optional = false)
    @NotNull
    @Lob
    @Column(name = "photos")
    private byte[] photos;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "venueId")
    private Collection<ConfirmEventTable> confirmEventTableCollection;

    public VenueDetails() {
    }

    public VenueDetails(Integer venueId) {
        this.venueId = venueId;
    }

    public VenueDetails(Integer venueId, String venueName, String vAddress, String city, byte[] photos) {
        this.venueId = venueId;
        this.venueName = venueName;
        this.vAddress = vAddress;
        this.city = city;
        this.photos = photos;
    }

    public Integer getVenueId() {
        return venueId;
    }

    public void setVenueId(Integer venueId) {
        this.venueId = venueId;
    }

    public String getVenueName() {
        return venueName;
    }

    public void setVenueName(String venueName) {
        this.venueName = venueName;
    }

    public String getVAddress() {
        return vAddress;
    }

    public void setVAddress(String vAddress) {
        this.vAddress = vAddress;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public byte[] getPhotos() {
        return photos;
    }

    public void setPhotos(byte[] photos) {
        this.photos = photos;
    }

    public Collection<ConfirmEventTable> getConfirmEventTableCollection() {
        return confirmEventTableCollection;
    }

    public void setConfirmEventTableCollection(Collection<ConfirmEventTable> confirmEventTableCollection) {
        this.confirmEventTableCollection = confirmEventTableCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (venueId != null ? venueId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof VenueDetails)) {
            return false;
        }
        VenueDetails other = (VenueDetails) object;
        if ((this.venueId == null && other.venueId != null) || (this.venueId != null && !this.venueId.equals(other.venueId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.Entity.VenueDetails[ venueId=" + venueId + " ]";
    }
    
}
