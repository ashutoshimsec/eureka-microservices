
package com.ashu.modal;

import java.util.HashMap;
import java.util.Map;
import javax.annotation.Generated;
import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({ "employeeId", "name", "practiceArea", "designation", "companyInfo" })
@Generated("jsonschema2pojo")
public class Employee {

	@JsonProperty("employeeId")
	private Integer employeeId;
	@JsonProperty("name")
	private String name;
	@JsonProperty("practiceArea")
	private String practiceArea;
	@JsonProperty("designation")
	private String designation;
	@JsonProperty("companyInfo")
	private String companyInfo;
	@JsonIgnore
	private Map<String, Object> additionalProperties = new HashMap<String, Object>();

	
	
	
	
	public Employee(Integer employeeId, String name, String practiceArea, String designation, String companyInfo) {
		super();
		this.employeeId = employeeId;
		this.name = name;
		this.practiceArea = practiceArea;
		this.designation = designation;
		this.companyInfo = companyInfo;
	}

	@JsonProperty("employeeId")
	public Integer getEmployeeId() {
		return employeeId;
	}

	@JsonProperty("employeeId")
	public void setEmployeeId(Integer employeeId) {
		this.employeeId = employeeId;
	}

	@JsonProperty("name")
	public String getName() {
		return name;
	}

	@JsonProperty("name")
	public void setName(String name) {
		this.name = name;
	}

	@JsonProperty("practiceArea")
	public String getPracticeArea() {
		return practiceArea;
	}

	@JsonProperty("practiceArea")
	public void setPracticeArea(String practiceArea) {
		this.practiceArea = practiceArea;
	}

	@JsonProperty("designation")
	public String getDesignation() {
		return designation;
	}

	@JsonProperty("designation")
	public void setDesignation(String designation) {
		this.designation = designation;
	}

	@JsonProperty("companyInfo")
	public String getCompanyInfo() {
		return companyInfo;
	}

	@JsonProperty("companyInfo")
	public void setCompanyInfo(String companyInfo) {
		this.companyInfo = companyInfo;
	}

	@JsonAnyGetter
	public Map<String, Object> getAdditionalProperties() {
		return this.additionalProperties;
	}

	@JsonAnySetter
	public void setAdditionalProperty(String name, Object value) {
		this.additionalProperties.put(name, value);
	}

}