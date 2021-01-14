
package mapp.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import org.hibernate.annotations.Cascade;


@Entity
@Table(name = "schedule", catalog = "mapp", schema = "")
public class Schedule implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    
    @Basic(optional = false)
    @NotNull(message = "Property day cannot be null")
    @Column(name = "day")
    private int day;
    
    /*
        The values for the following 4 references go from 1-48. 
        Each value represents half an hour, 48 for a whole day.
    */
    @Basic(optional = false)
    @NotNull(message = "Property opentime cannot be null")
    @Column(name = "opentime")
    private short opentime;
    
    @Basic(optional = false)
    @NotNull(message = "Property closetime cannot be null")
    @Column(name = "closetime")
    private short closetime;
    
    @Column(name = "reopentime")
    private Short reopentime;
    
    @Column(name = "reclosetime")
    private Short reclosetime;

    @JoinColumn(name = "company_id", referencedColumnName = "id")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    @Cascade(org.hibernate.annotations.CascadeType.MERGE)
    private Company company;

    public Schedule() {
    }

    public Schedule(Integer id) {
        this.id = id;
    }

    public Schedule(Integer id, int day, short opentime, short closetime) {
        this.id = id;
        this.day = day;
        this.opentime = opentime;
        this.closetime = closetime;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public int getDay() {
        return day;
    }

    public void setDay(int day) {
        this.day = day;
    }

    public short getOpentime() {
        return opentime;
    }

    public void setOpentime(short opentime) {
        this.opentime = opentime;
    }

    public short getClosetime() {
        return closetime;
    }

    public void setClosetime(short closetime) {
        this.closetime = closetime;
    }

    public Short getReopentime() {
        return reopentime;
    }

    public void setReopentime(Short reopentime) {
        this.reopentime = reopentime;
    }

    public Short getReclosetime() {
        return reclosetime;
    }

    public void setReclosetime(Short reclosetime) {
        this.reclosetime = reclosetime;
    }

    @JsonBackReference(value="company_schedule")
    public Company getCompany() {
        return company;
    }

    public void setCompany(Company company) {
        this.company = company;
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
        if (!(object instanceof Schedule)) {
            return false;
        }
        Schedule other = (Schedule) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "mapp.entity.Schedule[ id=" + id + " ]";
    }

}
