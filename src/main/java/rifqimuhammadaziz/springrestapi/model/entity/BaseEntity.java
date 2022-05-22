package rifqimuhammadaziz.springrestapi.model.entity;

import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.EntityListeners;
import javax.persistence.MappedSuperclass;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import java.util.Date;

@MappedSuperclass
@EntityListeners(AuditingEntityListener.class) // Listener for Insert/Update Timestamp
public class BaseEntity<T> {

    /*
    Auditing Entity
     */

    // User who created data
    @CreatedBy
    protected T createdBy;

    // When data is created
    @CreatedDate
    @Temporal(TemporalType.TIMESTAMP)
    protected Date createdDate;

    // User who updated data
    @LastModifiedBy
    protected T updatedBy;

    // When data is updated
    @LastModifiedDate
    @Temporal(TemporalType.TIMESTAMP)
    protected Date updatedDate;

    public T getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(T createdBy) {
        this.createdBy = createdBy;
    }

    public Date getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }

    public T getUpdatedBy() {
        return updatedBy;
    }

    public void setUpdatedBy(T updatedBy) {
        this.updatedBy = updatedBy;
    }

    public Date getUpdatedDate() {
        return updatedDate;
    }

    public void setUpdatedDate(Date updatedDate) {
        this.updatedDate = updatedDate;
    }
}
