package com.krish.jsonb.HibernateTypes52JsonbExample;

import java.io.Serializable;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import javax.persistence.SequenceGenerator;

import org.hibernate.annotations.TypeDef;
import org.hibernate.annotations.TypeDefs;

import com.vit.products.intrak.common.database.usertype.json.JsonBinaryType;
import com.vit.products.intrak.common.database.usertype.json.JsonStringType;

@MappedSuperclass
@TypeDefs({
    @TypeDef(name = "jsonb", typeClass = JsonBinaryType.class)
})
public class BaseTest implements Serializable {
	/**
	 * added generated serialVersionUID
	 */
	private static final long serialVersionUID = -9180131063919750528L;
	
	@Id
	@SequenceGenerator(name = "TEST_ID_GENERATOR", sequenceName = "TEST_ID_GENERATOR", allocationSize =  1)
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="TEST_ID_GENERATOR")
	private Long id;
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

}
