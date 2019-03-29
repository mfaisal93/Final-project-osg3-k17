package com.osg3.finalprojectk17.finalprojectk17osg3.data;

import com.osg3.finalprojectk17.finalprojectk17osg3.data.remote.DomainRemoteDataSource;
import com.osg3.finalprojectk17.finalprojectk17osg3.model.Domain;
import com.osg3.finalprojectk17.finalprojectk17osg3.model.DomainSearch;

public class DomainRepository implements DomainDataSource{

	private DomainRemoteDataSource domainRemoteDataSource;

	public DomainRepository(DomainRemoteDataSource domainRemoteDataSource) {
		this.domainRemoteDataSource = domainRemoteDataSource;
	}


	@Override
	public void getListDomain(GetDomainCallback callback) {
		domainRemoteDataSource.getListDomain(new GetDomainCallback() {
			@Override
			public void onDomainLoaded(DomainSearch domain) {
				callback.onDomainLoaded(domain);
			}

			@Override
			public void onDataNotAvailable(String message) {
				callback.onDataNotAvailable(message);
			}
		});
	}
}
