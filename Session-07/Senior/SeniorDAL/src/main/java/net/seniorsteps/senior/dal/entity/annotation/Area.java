package net.seniorsteps.senior.dal.entity.annotation;
// Generated Jan 6, 2020 9:40:03 PM by Hibernate Tools 4.3.1


import java.util.HashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * Area generated by hbm2java
 */
@Entity
@Table(name="area"
    ,catalog="senior_app"
)
public class Area  implements java.io.Serializable {


     private Integer id;
     private City city;
     private String nameAr;
     private String nameEn;
     private Set consumerAddresses = new HashSet(0);
     private Set deliveryAreas = new HashSet(0);
     private Set orders = new HashSet(0);
     private Set branches = new HashSet(0);

    public Area() {
    }

	
    public Area(City city, String nameAr, String nameEn) {
        this.city = city;
        this.nameAr = nameAr;
        this.nameEn = nameEn;
    }
    public Area(City city, String nameAr, String nameEn, Set consumerAddresses, Set deliveryAreas, Set orders, Set branches) {
       this.city = city;
       this.nameAr = nameAr;
       this.nameEn = nameEn;
       this.consumerAddresses = consumerAddresses;
       this.deliveryAreas = deliveryAreas;
       this.orders = orders;
       this.branches = branches;
    }
   
     @Id @GeneratedValue(strategy=IDENTITY)

    
    @Column(name="id", unique=true, nullable=false)
    public Integer getId() {
        return this.id;
    }
    
    public void setId(Integer id) {
        this.id = id;
    }

@ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="city_id", nullable=false)
    public City getCity() {
        return this.city;
    }
    
    public void setCity(City city) {
        this.city = city;
    }

    
    @Column(name="name_ar", nullable=false, length=100)
    public String getNameAr() {
        return this.nameAr;
    }
    
    public void setNameAr(String nameAr) {
        this.nameAr = nameAr;
    }

    
    @Column(name="name_en", nullable=false, length=100)
    public String getNameEn() {
        return this.nameEn;
    }
    
    public void setNameEn(String nameEn) {
        this.nameEn = nameEn;
    }

@OneToMany(fetch=FetchType.LAZY, mappedBy="area")
    public Set getConsumerAddresses() {
        return this.consumerAddresses;
    }
    
    public void setConsumerAddresses(Set consumerAddresses) {
        this.consumerAddresses = consumerAddresses;
    }

@OneToMany(fetch=FetchType.LAZY, mappedBy="area")
    public Set getDeliveryAreas() {
        return this.deliveryAreas;
    }
    
    public void setDeliveryAreas(Set deliveryAreas) {
        this.deliveryAreas = deliveryAreas;
    }

@OneToMany(fetch=FetchType.LAZY, mappedBy="area")
    public Set getOrders() {
        return this.orders;
    }
    
    public void setOrders(Set orders) {
        this.orders = orders;
    }

@OneToMany(fetch=FetchType.LAZY, mappedBy="area")
    public Set getBranches() {
        return this.branches;
    }
    
    public void setBranches(Set branches) {
        this.branches = branches;
    }




}

