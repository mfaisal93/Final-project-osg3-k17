package com.osg3.finalprojectk17.finalprojectk17osg3.viewmodel;

import android.content.Context;
import com.osg3.finalprojectk17.finalprojectk17osg3.base.BaseViewModel;
import com.osg3.finalprojectk17.finalprojectk17osg3.data.DomainDataSource;
import com.osg3.finalprojectk17.finalprojectk17osg3.data.DomainRepository;
import com.osg3.finalprojectk17.finalprojectk17osg3.model.DomainSearch;
import com.osg3.finalprojectk17.finalprojectk17osg3.navigator.DomainNavigator;

public class DomainViewModel extends BaseViewModel {

	private Context context;
	private DomainRepository repository;
	private DomainNavigator navigator;

	public DomainViewModel(Context context, DomainRepository repository) {
		this.context = context;
		this.repository = repository;
	}


	public void setNavigator(DomainNavigator navigator) {
		this.navigator = navigator;
	}

	public void getListDomain(String keyword) {
		repository.getListDomain(new DomainDataSource.GetDomainCallback() {
			@Override
			public void onDomainLoaded(DomainSearch domain) {
				navigator.loadListDomain(domain.domains);
			}

			@Override
			public void onDataNotAvailable(String message) {
				navigator.errorLoadListDomain(message);
			}
		}, keyword);
	}
}
