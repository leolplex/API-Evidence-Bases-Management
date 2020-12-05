package com.ebm.persistence.entity;

import org.hibernate.procedure.spi.ParameterRegistrationImplementor;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "iteration")
public class EntityIteration {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer entityId;

    @Column(name = "name")
    private String entityName;

    @Column(name = "goal")
    private String entityGoal;

    @Column(name = "start_date")
    private LocalDateTime entityStartDate;

    @Column(name = "end_date")
    private LocalDateTime entityEndDate;

    @Column(name = "state")
    private String entityState;


    @OneToOne(mappedBy = "entityIteration")
    private EntityKVAUnrealizedValue entityKVAUnrealizedValue;

    public Integer getEntityId() {
        return entityId;
    }

    public void setEntityId(Integer entityId) {
        this.entityId = entityId;
    }

    public String getEntityGoal() {
        return entityGoal;
    }

    public void setEntityGoal(String entityGoal) {
        this.entityGoal = entityGoal;
    }

    public LocalDateTime getEntityStartDate() {
        return entityStartDate;
    }

    public void setEntityStartDate(LocalDateTime entityStartDate) {
        this.entityStartDate = entityStartDate;
    }

    public LocalDateTime getEntityEndDate() {
        return entityEndDate;
    }

    public void setEntityEndDate(LocalDateTime entityEndDate) {
        this.entityEndDate = entityEndDate;
    }

    public String getEntityState() {
        return entityState;
    }

    public void setEntityState(String entityState) {
        this.entityState = entityState;
    }

    public String getEntityName() {
        return entityName;
    }

    public void setEntityName(String entityName) {
        this.entityName = entityName;
    }

    public EntityKVAUnrealizedValue getEntityKVAUnrealizedValue() {
        return entityKVAUnrealizedValue;
    }

    public void setEntityKVAUnrealizedValue(EntityKVAUnrealizedValue entityKVAUnrealizedValue) {
        this.entityKVAUnrealizedValue = entityKVAUnrealizedValue;
    }
}