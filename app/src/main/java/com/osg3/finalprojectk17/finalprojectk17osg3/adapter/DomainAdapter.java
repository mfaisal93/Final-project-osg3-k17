package com.osg3.finalprojectk17.finalprojectk17osg3.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.osg3.finalprojectk17.finalprojectk17osg3.R;
import com.osg3.finalprojectk17.finalprojectk17osg3.model.Domain;

import java.util.List;

public class DomainAdapter extends RecyclerView.Adapter<DomainAdapter.DomainViewHolder> {

	private Context context;
	private List<Domain> domainList;

	public DomainAdapter(Context context, List<Domain> domainList) {
		this.context = context;
		this.domainList = domainList;
	}

	public List<Domain> getDomainList() {
		return domainList;
	}

	public void setDomainList(List<Domain> domainList) {
		this.domainList.clear();
		this.domainList.addAll(domainList);
		notifyDataSetChanged();
	}

	@NonNull
	@Override
	public DomainViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
		View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.list_item_domain, viewGroup, false);
		return new DomainViewHolder(view);
	}

	@Override
	public void onBindViewHolder(@NonNull DomainViewHolder domainViewHolder, int i) {

		String domainName = domainList.get(i).domain;
		domainViewHolder.tvDomain.setText(domainName);
	}

	@Override
	public int getItemCount() {
		return domainList != null ? domainList.size() : 0;

	}

	class DomainViewHolder extends RecyclerView.ViewHolder {

		TextView tvDomain;
		CardView cvDomain;

		DomainViewHolder(@NonNull View itemView) {
			super(itemView);

			tvDomain = itemView.findViewById(R.id.tv_domain);
			cvDomain = itemView.findViewById(R.id.cv_domain);
		}
	}
}
