package com.osg3.finalprojectk17.finalprojectk17osg3.model;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Domain implements Parcelable {

	@SerializedName("domain")
	@Expose
	public String domain;
	@SerializedName("expiry_date")
	@Expose
	public String expiryDate;
	@SerializedName("create_date")
	@Expose
	public String createDate;
	@SerializedName("update_date")
	@Expose
	public String updateDate;
	@SerializedName("isDead")
	@Expose
	public Boolean isDead;
	@SerializedName("A")
	@Expose
	public List<String> a = null;
	@SerializedName("TXT")
	@Expose
	public List<String> tXT = null;
	@SerializedName("country")
	@Expose
	public String country;
	@SerializedName("NS")
	@Expose
	public List<String> nS = null;
	@SerializedName("resolvable")
	@Expose
	public Boolean resolvable;

	@Override
	public int describeContents() {
		return 0;
	}


	public Domain(String domain, String expiryDate, String createDate, String updateDate, Boolean isDead, List<String> a,
	              List<String> tXT, String country, List nS, Boolean resolvable) {
		this.domain = domain;
		this.expiryDate = expiryDate;
		this.createDate = createDate;
		this.updateDate = updateDate;
		this.isDead = isDead;
		this.a = a;
		this.tXT = tXT;
		this.country = country;
		this.nS = nS;
		this.resolvable = resolvable;
	}


	@Override
	public void writeToParcel(Parcel dest, int flags) {
		dest.writeString(this.domain);
		dest.writeString(this.expiryDate);
		dest.writeString(this.createDate);
		dest.writeString(this.updateDate);
		dest.writeValue(this.isDead);
		dest.writeStringList(this.a);
		dest.writeStringList(this.tXT);
		dest.writeString(this.country);
		dest.writeStringList(this.nS);
		dest.writeValue(this.resolvable);
	}

	protected Domain(Parcel in) {
		this.domain = in.readString();
		this.expiryDate = in.readString();
		this.createDate = in.readString();
		this.updateDate = in.readString();
		this.isDead = (Boolean) in.readValue(Boolean.class.getClassLoader());
		this.a = in.createStringArrayList();
		this.tXT = in.createStringArrayList();
		this.country = in.readString();
		this.nS = in.createStringArrayList();
		this.resolvable = (Boolean) in.readValue(Boolean.class.getClassLoader());
	}

	public static final Parcelable.Creator<Domain> CREATOR = new Parcelable.Creator<Domain>() {
		@Override
		public Domain createFromParcel(Parcel source) {
			return new Domain(source);
		}

		@Override
		public Domain[] newArray(int size) {
			return new Domain[size];
		}
	};
}
