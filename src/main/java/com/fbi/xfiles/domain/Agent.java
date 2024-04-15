package com.fbi.xfiles.domain;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Date;
import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;

import org.hibernate.envers.AuditTable;
import org.hibernate.envers.Audited;
import org.hibernate.envers.NotAudited;
import org.hibernate.envers.RelationTargetAuditMode;
import org.springframework.format.annotation.DateTimeFormat;

@Audited
@Entity
@Table(name = "agent")
public class Agent implements Serializable {

	private static final long serialVersionUID = -7062162719876554818L;

	@Id
	@Column
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;

	@Column(nullable = false)
	private String name;

	@Column
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private LocalDate birthDate;

	@Column
	private Department department;

	@Temporal(TemporalType.TIMESTAMP)
	@Audited(withModifiedFlag = true)
    private Date dataCriacao;

    @Temporal(TemporalType.TIMESTAMP)
	@Audited(withModifiedFlag = false)
    private Date dataModificacao;

	@Column
	@Audited(targetAuditMode = RelationTargetAuditMode.NOT_AUDITED)
    private String usuarioModificador;

    // Getters e setters

    @PrePersist
    protected void onCreate() {
        dataCriacao = new Date();
        dataModificacao = new Date();
    }

    @PreUpdate
    protected void onUpdate() {
        dataModificacao = new Date();
    }

	public Agent(Integer id, String name, LocalDate birthDate, Department department) {
		this.id = id;
		this.name = name;
		this.birthDate = birthDate;
		this.department = department;
	}

	public Agent() {
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public LocalDate getBirthDate() {
		return birthDate;
	}

	public Department getDepartment() {
		return department;
	}

	public void setDepartment(Department department) {
		this.department = department;
	}

	public void setBirthDate(LocalDate birthDate) {
		this.birthDate = birthDate;
	}

	@Override
	public int hashCode() {
		return Objects.hash(birthDate, id, name);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Agent other = (Agent) obj;
		return Objects.equals(birthDate, other.birthDate) && Objects.equals(id, other.id)
				&& Objects.equals(name, other.name) && Objects.equals(department, other.department);
	}

	@Override
	public String toString() {
		return "Agent [id=" + id + ", name=" + name + ", birthDate=" + birthDate + ", department=" + department + "]";
	}

}