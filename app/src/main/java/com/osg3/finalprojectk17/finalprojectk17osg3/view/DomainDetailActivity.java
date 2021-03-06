package com.osg3.finalprojectk17.finalprojectk17osg3.view;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;
import com.osg3.finalprojectk17.finalprojectk17osg3.R;
import com.osg3.finalprojectk17.finalprojectk17osg3.model.Domain;

import static com.osg3.finalprojectk17.finalprojectk17osg3.view.DomainListActivity.EXTRA_DOMAIN;

public class DomainDetailActivity extends AppCompatActivity {
	String isDead, resolvable;
	TextView tv_domain, tv_expiryDate, tv_createDate, tv_updatedate, tv_isDead, tv_a, tv_txt, tv_country, tv_ns, tv_resolvable;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_domain_detail);


		tv_domain = (TextView) findViewById(R.id.tv_domain);
		tv_expiryDate = (TextView) findViewById(R.id.tv_expiryDate);
		tv_createDate = (TextView) findViewById(R.id.tv_createDate);
		tv_updatedate = (TextView) findViewById(R.id.tv_updatedate);
		tv_isDead = (TextView) findViewById(R.id.tv_isDead);
		tv_a = (TextView) findViewById(R.id.tv_a);
		tv_txt = (TextView) findViewById(R.id.tv_txt);
		tv_country = (TextView) findViewById(R.id.tv_country);
		tv_ns = (TextView) findViewById(R.id.tv_ns);
		tv_resolvable = (TextView) findViewById(R.id.tv_resolvable);

		Intent intent = getIntent();
		Domain domain = intent.getParcelableExtra(EXTRA_DOMAIN);
		if (!domain.isDead)
			isDead = "Aktif";
		else
			isDead = "Tidak Aktif";
		if (domain.resolvable)
			resolvable = "Ya";
		else resolvable = "Tidak";

		tv_domain.setText(domain.domain);
		tv_expiryDate.setText(domain.expiryDate);
		tv_createDate.setText(domain.createDate);
		tv_updatedate.setText(domain.updateDate);
		tv_isDead.setText(isDead);
		if (domain.a != null){
		tv_a.setText(domain.a.toString());}
		if (domain.tXT != null){
		tv_txt.setText(domain.tXT.toString());}
		tv_country.setText(domain.country);
		tv_ns.setText(domain.nS.toString());
		tv_resolvable.setText(resolvable);
	}
}
