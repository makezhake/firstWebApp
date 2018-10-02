package com.mute.webapp.firstWebApp.db;



import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Entity @Getter @Setter  @Table(name = "test_table",catalog = "test_schema")
public class TestEntity {
	
	@Id
	private String UUID;
	@Column(name = "name")
	private String name;

}
