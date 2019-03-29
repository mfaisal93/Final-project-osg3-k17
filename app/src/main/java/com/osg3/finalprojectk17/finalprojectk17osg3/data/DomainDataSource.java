package com.osg3.finalprojectk17.finalprojectk17osg3.data;

import com.osg3.finalprojectk17.finalprojectk17osg3.model.DomainSearch;

public interface DomainDataSource {

	void getListDomain(GetDomainCallback callback, String keyword);

	interface GetDomainCallback {
		void onDomainLoaded(DomainSearch domain);

		void onDataNotAvailable(String message);
	}
}
