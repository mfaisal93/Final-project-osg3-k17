package com.osg3.finalprojectk17.finalprojectk17osg3;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import com.osg3.finalprojectk17.finalprojectk17osg3.adapter.DomainAdapter;
import com.osg3.finalprojectk17.finalprojectk17osg3.model.Domain;
import com.osg3.finalprojectk17.finalprojectk17osg3.navigator.DomainNavigator;
import com.osg3.finalprojectk17.finalprojectk17osg3.utils.RecyclerItemClickListener;
import com.osg3.finalprojectk17.finalprojectk17osg3.viewmodel.DomainViewModel;
import com.osg3.finalprojectk17.finalprojectk17osg3.viewmodel.ViewModelInjector;

import java.util.ArrayList;
import java.util.List;

import static com.osg3.finalprojectk17.finalprojectk17osg3.MainActivity.EXTRA_KEYWORD;

public class DomainListActivity extends AppCompatActivity implements DomainNavigator {

	private static final String TAG = DomainListActivity.class.getSimpleName();
	public static final String EXTRA_DOMAIN = "extra_domain";

	private DomainViewModel domainViewModel;

	private DomainAdapter domainAdapter;
	private LinearLayoutManager linearLayoutManager;
	private RecyclerView rcvDomain;

	private List<Domain> domainList;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_domain_list);

		getDomainData();
		setUpDomainList();
	}

	@Override
	public void loadListDomain(List<Domain> list) {
		domainAdapter.setDomainList(list);
	}

	@Override
	public void errorLoadListDomain(String message) {
		Log.e(TAG, "errorLoadListDomain: " + message);
	}

	private void setUpDomainList() {
		rcvDomain = findViewById(R.id.rcv_domain);
		linearLayoutManager = new LinearLayoutManager(DomainListActivity.this);
		rcvDomain.setLayoutManager(linearLayoutManager);
		domainAdapter = new DomainAdapter(DomainListActivity.this, domainList);
		rcvDomain.setAdapter(domainAdapter);
		addTouchEvent();
	}

	private void addTouchEvent() {
		rcvDomain.addOnItemTouchListener(
				new RecyclerItemClickListener(DomainListActivity.this, rcvDomain,
						new RecyclerItemClickListener.OnItemClickListener() {
							@Override
							public void onItemClick(View view, int position) {
								Intent intent = new Intent(DomainListActivity.this, DomainDetailActivity.class);
								intent.putExtra(EXTRA_DOMAIN, domainAdapter.getDomainList().get(position));
								startActivity(intent);
							}

							@Override
							public void onLongItemClick(View view, int position) {

							}
						}));
	}


	private void getDomainData() {
		String searchKeyword = getIntent().getStringExtra(EXTRA_KEYWORD);
		domainList = new ArrayList<>();

		domainViewModel = new DomainViewModel(this, ViewModelInjector.provideDomainRepository(this));
		domainViewModel.setNavigator(this);
		domainViewModel.getListDomain(searchKeyword);
	}
}
