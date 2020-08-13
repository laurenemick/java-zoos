package com.lambdaschool.zoos.models;

import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.EntityListeners;
import javax.persistence.MappedSuperclass;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import java.util.Date;

@MappedSuperclass // hibernate is in control -- these fields will be added to children who inherit from this class
@EntityListeners(AuditingEntityListener.class) // Spring to start service running in background -- whenever a record is changed, fire off this class and this class will take care of auditing our fields for us
abstract class Auditable
{
    @CreatedBy // makes it created by auditing field by Spring
    protected String createdBy; // doesn't directly become an entity in our table so we can camelcase
    // protected: this class and any children that extend this abstract class will have access to field

    @CreatedDate
    @Temporal(TemporalType.TIMESTAMP) // have entire timestamp included
    protected Date createdDate;

    @LastModifiedBy
    protected  String lastModifiedBy;

    @LastModifiedBy
    @Temporal(TemporalType.TIMESTAMP)
    protected Date lastModifiedDate;
}
