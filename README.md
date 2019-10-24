# HibernateTypes52JsonbExample
creating new HibernateTypes52JsonbExample
This project is created how to use HibernateJsonType my other project, for custom json columns

How to use JsonBinaryType
=========================
JsonBinaryType -> It is used to help to store the jsonb type in databse and retrive respective return type
JsonBinaryType: clean install 

add a dependency to the using projects, if it is changed take dependency from pom.xml 
<dependency>
<groupId>com.krish.type</groupId>
<artifactId>HibernateJsonType</artifactId>
<version>0.0.1-SNAPSHOT</version>
</dependency>
------------------------------------------------------------------------------------------
------------------------------------------------------------------------------------------
add below code on baseentity or any entity if there is no baseentity
@TypeDefs({
    @TypeDef(name = "jsonb", typeClass = JsonBinaryType.class)
})

Eg:- we can add more than one @Typedef by seperating comma(,)
@MappedSuperclass
@TypeDefs({
    @TypeDef(name = "jsonb", typeClass = JsonBinaryType.class)
})
public class BaseTest implements Serializable {
}

{{ or }} 

@Entity
@Table(name = "test")
@TypeDefs({
    @TypeDef(name = "jsonb", typeClass = JsonBinaryType.class)
})
public class Test extends BaseTest {
}

JsonBinaryType.class -> this will be changed accroding to the type of attribute
For eg:- if you want to use JsonNode you need to use JsonNodeBinaryType.class
------------------------------------
StringArrayType.class
@Type( type = "string-array" )
    @Column(
        name = "sensor_names",
        columnDefinition = "text[]"
    )
    private String[] sensorNames;
-------------------------------------
IntArrayType.class
@Type( type = "int-array" )
    @Column(
        name = "sensor_values",
        columnDefinition = "integer[]"
    )
    private int[] sensorValues;
-------------------------------------
PostgreSQLEnumType.class
@Enumerated(EnumType.STRING)
@Column(columnDefinition = "post_status_info")
@Type( type = "pgsql_enum" )
private PostStatus status;
------------------------------------------------------------------------------------------
------------------------------------------------------------------------------------------

add below code for which attribute you want to use
@Type(type = "jsonb")

Eg:-
@Entity
@Table(name = "test")
public class Test extends BaseTest {
	/**
	 * added generated serialVersionUID
	 */
	private static final long serialVersionUID = 2814199495304573251L;
	@Type(type = "jsonb")
	@Column(columnDefinition = "jsonb", nullable = true)
	@Basic(fetch = FetchType.LAZY)
	private List<Car> cars;
}
------------------------------------------------------------------------------------------
------------------------------------------------------------------------------------------

add below pugin to work lazy attribute properly
<plugin>
<groupId>org.hibernate.orm.tooling</groupId>
<artifactId>hibernate-enhance-maven-plugin</artifactId>
<version>5.4.1.Final</version>
<executions>
	<execution>
		<configuration>
			<failOnError>true</failOnError>
			<enableLazyInitialization>true</enableLazyInitialization>
		</configuration>
		<goals>
			<goal>enhance</goal>
		</goals>
	</execution>
</executions>
</plugin>

------------------------------------------------------------------------------------------
------------------------------------------------------------------------------------------
References
Features
JSON -> https://github.com/vladmihalcea/hibernate-types

Oracle
You should use the JsonStringType to map a VARCHAR2 column type storing JSON.
You should use the JsonBlobType to map a BLOB column type storing JSON.
For more details, https://vladmihalcea.com/oracle-json-jpa-hibernate/

SQL Server
You should use this JsonStringType to map an NVARCHAR column type storing JSON.
For more details, https://vladmihalcea.com/sql-server-json-hibernate/

PostgreSQL
You should use this JsonBinaryType to map both jsonb and json column types.
For more details, https://vladmihalcea.com/how-to-map-json-objects-using-generic-hibernate-types/

MySQL
You should use this JsonStringType to map the json column type.
For more details, https://vladmihalcea.com/how-to-map-json-objects-using-generic-hibernate-types/


