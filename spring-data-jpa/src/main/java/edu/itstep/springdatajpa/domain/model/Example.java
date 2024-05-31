package edu.itstep.springdatajpa.domain.model;

import jakarta.persistence.NamedQueries;
import jakarta.persistence.NamedQuery;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;

import java.util.Date;

@NamedQueries(
        @NamedQuery(name = "Example.queryByEmail", query = "from Example e where e.email = ?")
)
public class Example {

    @CreatedBy
    Account creator;

    @LastModifiedBy
    Account modifier;

    @CreatedDate
    Date createdDate;

    @LastModifiedDate
    Date lastModifiedDate;
}
