package com.osg3.finalprojectk17.finalprojectk17osg3;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

	public static final String EXTRA_KEYWORD = "extra_keyword";

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		setSearchDomain();
	}

	private void setSearchDomain() {
		Button btnSearch = findViewById(R.id.cari);
		btnSearch.setOnClickListener(this);
	}

	private String getKeyword() {
		EditText edtKeyword = findViewById(R.id.input);
		return edtKeyword.getText().toString().trim();
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
				//TODO: Cek domain
				break;
		}
	}
}
