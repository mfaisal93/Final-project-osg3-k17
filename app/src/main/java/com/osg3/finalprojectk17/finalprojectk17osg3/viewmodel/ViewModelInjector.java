package com.osg3.finalprojectk17.finalprojectk17osg3.viewmodel;

import android.content.Context;
import com.osg3.finalprojectk17.finalprojectk17osg3.data.DomainRepository;
import com.osg3.finalprojectk17.finalprojectk17osg3.data.remote.DomainRemoteDataSource;

public class ViewModelInjector {

	public static DomainRepository provideDomainRepository(Context context) {
		return new DomainRepository(new DomainRemoteDataSource());
	}
}
