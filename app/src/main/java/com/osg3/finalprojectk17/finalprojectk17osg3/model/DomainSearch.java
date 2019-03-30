package com.osg3.finalprojectk17.finalprojectk17osg3.model;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class DomainSearch implements Parcelable {

	@SerializedName("total")
	@Expose
	public Integer total;
	@SerializedName("time")
	@Expose
	public Integer time;
	@SerializedName("domains")
	@Expose
	public List<Domain> domains = null;

	@Override
	public int describeContents() {
		return 0;
	}

	@Override
	public void writeToParcel(Parcel dest, int flags) {
		dest.writeValue(this.total);
		dest.writeValue(this.time);
		dest.writeTypedList(this.domains);
	}

	public DomainSearch() {
	}

	protected DomainSearch(Parcel in) {
		this.total = (Integer) in.readValue(Integer.class.getClassLoader());
		this.time = (Integer) in.readValue(Integer.class.getClassLoader());
		this.domains = in.createTypedArrayList(Domain.CREATOR);
	}

	public static final Parcelable.Creator<DomainSearch> CREATOR = new Parcelable.Creator<DomainSearch>() {
		@Override
		public DomainSearch createFromParcel(Parcel source) {
			return new DomainSearch(source);
		}

		@Override
		public DomainSearch[] newArray(int size) {
			return new DomainSearch[size];
		}
	};
}
