package com.osg3.finalprojectk17.finalprojectk17osg3.view;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;
import com.osg3.finalprojectk17.finalprojectk17osg3.R;
import com.osg3.finalprojectk17.finalprojectk17osg3.adapter.DomainAdapter;
import com.osg3.finalprojectk17.finalprojectk17osg3.model.Domain;
import com.osg3.finalprojectk17.finalprojectk17osg3.navigator.DomainNavigator;
import com.osg3.finalprojectk17.finalprojectk17osg3.viewmodel.DomainViewModel;
import com.osg3.finalprojectk17.finalprojectk17osg3.viewmodel.ViewModelInjector;

import java.util.List;

public class MainActivity extends AppCompatActivity implements View.OnClickListener, DomainNavigator {

	private static final String TAG = MainActivity.class.getSimpleName();
	public static final String EXTRA_KEYWORD = "extra_keyword";

	private DomainViewModel domainViewModel;
	private ProgressBar progressBar;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		progressBar = findViewById(R.id.cek_pb);
		domainViewModel = new DomainViewModel(this, ViewModelInjector.provideDomainRepository(this));
		domainViewModel.setNavigator(this);

		setSearchDomain();
		setCekDomain();
		progressBar.setVisibility(View.GONE);
	}

	private void setSearchDomain() {
		Button btnSearch = findViewById(R.id.cari);
		btnSearch.setOnClickListener(this);
	}

	private void setCekDomain() {
		Button btnCek = findViewById(R.id.cek);
		btnCek.setOnClickListener(this);
	}

	private String getKeyword() {
		EditText edtKeyword = findViewById(R.id.input);
		return edtKeyword.getText().toString();
	}

	@Override
	public void onClick(View v) {
		switch (v.getId()) {
			case R.id.cari:
				Intent intent = new Intent(MainActivity.this, DomainListActivity.class);
				intent.putExtra(EXTRA_KEYWORD, getKeyword());
				startActivity(intent);
				break;
			case R.id.cek:
				getKeyword();
				progressBar.setVisibility(View.VISIBLE);
				break;
		}
	}

	@Override
	public void loadListDomain(List<Domain> list) {
		if (list != null) {
			progressBar.setVisibility(View.GONE);
			Toast.makeText(MainActivity.this, "Domain Tersedia", Toast.LENGTH_LONG).show();
		} else {
			Toast.makeText(MainActivity.this, "Domain Tidak Tersedia", Toast.LENGTH_LONG).show();
		}

	}

	@Override
	public void errorLoadListDomain(String message) {
		Log.d(TAG, "errorLoadListDomain: " + message);
	}
}
