package com.osg3.finalprojectk17.finalprojectk17osg3.model;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class DomainSearch  {

	@SerializedName("domains")
	@Expose
	List<Domain> domains;

	public List<Domain> getDomains() {
		return domains;
	}

	public DomainSearch(List<Domain> domains) {
		this.domains = domains;
	}
}
