package org.example.restaurants.model;

import org.hibernate.Hibernate;

import javax.persistence.*;
import java.util.Objects;

@MappedSuperclass
@Access(AccessType.FIELD)
public abstract class AbstractBaseEntity {
    public static final int START_SEQ = 100_000;

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "GLOBAL_SEQ")
    @SequenceGenerator(name = "GLOBAL_SEQ", sequenceName = "GLOBAL_SEQ", initialValue = START_SEQ, allocationSize = 1)
    protected Integer id;

    public AbstractBaseEntity(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    protected AbstractBaseEntity() {
    }

    @Override
    public int hashCode() {
        return id == null ? 0 : Objects.hashCode(id);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || !(getClass().equals(Hibernate.getClass(obj)))) {
            return false;
        }
        AbstractBaseEntity baseEntity = (AbstractBaseEntity) obj;
        return baseEntity.id != null && id.equals(baseEntity.id);
    }
}
