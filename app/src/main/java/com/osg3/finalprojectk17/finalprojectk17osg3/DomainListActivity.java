package com.osg3.finalprojectk17.finalprojectk17osg3;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Toast;

import com.osg3.finalprojectk17.finalprojectk17osg3.adapter.DomainAdapter;
import com.osg3.finalprojectk17.finalprojectk17osg3.api.APIClient;
import com.osg3.finalprojectk17.finalprojectk17osg3.model.Domain;
import com.osg3.finalprojectk17.finalprojectk17osg3.model.DomainSearch;
import com.osg3.finalprojectk17.finalprojectk17osg3.utils.RecyclerItemClickListener;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import static com.osg3.finalprojectk17.finalprojectk17osg3.MainActivity.EXTRA_KEYWORD;

public class DomainListActivity extends AppCompatActivity {

	public static final String EXTRA_DOMAIN = "extra_domain";

	private DomainAdapter domainAdapter;
	private LinearLayoutManager linearLayoutManager;
	private RecyclerView rcvDomain;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_domain_list);

		setUpDomainList();
	}

	private void setUpDomainList() {
		rcvDomain = findViewById(R.id.rcv_domain);
		linearLayoutManager = new LinearLayoutManager(DomainListActivity.this);
		rcvDomain.setLayoutManager(linearLayoutManager);
		domainAdapter = new DomainAdapter(DomainListActivity.this, getDomainData());
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

	/**
	 *
	 * @return Data-data domain hasil pencarian
	 */
	private List<Domain> getDomainData() {
        final List<Domain> searchResult = new ArrayList<>();
		String searchKeyword = getIntent().getStringExtra(EXTRA_KEYWORD);
		//TODO: isi 'searchResult'

		return searchResult;
	}
}
