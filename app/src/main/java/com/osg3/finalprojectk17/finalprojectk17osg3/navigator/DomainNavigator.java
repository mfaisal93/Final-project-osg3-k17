package com.osg3.finalprojectk17.finalprojectk17osg3.navigator;

import com.osg3.finalprojectk17.finalprojectk17osg3.model.Domain;

import java.util.List;

public interface DomainNavigator {

	void loadListDomain(List<Domain> list);

	void errorLoadListDomain(String message);
}
