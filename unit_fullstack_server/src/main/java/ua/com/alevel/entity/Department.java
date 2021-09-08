package ua.com.alevel.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Table;

@Getter
@Setter
@Entity
@Table(name = "departments")
public class Department extends BaseEntity {

    private String name;
}
