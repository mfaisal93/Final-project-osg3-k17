package com.osg3.finalprojectk17.finalprojectk17osg3.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class DomainSearch {

	@SerializedName("total")
	@Expose
	public Integer total;
	@SerializedName("time")
	@Expose
	public Integer time;
	@SerializedName("domains")
	@Expose
	public List<Domain> domains = null;
}
