package com.osg3.finalprojectk17.finalprojectk17osg3.data.remote;

import com.osg3.finalprojectk17.finalprojectk17osg3.api.APICall;
import com.osg3.finalprojectk17.finalprojectk17osg3.api.APIClient;
import com.osg3.finalprojectk17.finalprojectk17osg3.data.DomainDataSource;
import com.osg3.finalprojectk17.finalprojectk17osg3.model.DomainSearch;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class DomainRemoteDataSource implements DomainDataSource {
	private APICall apiCall = APIClient.getClient().create(APICall.class);

	@Override
	public void getListDomain(GetDomainCallback callback, String keyword) {
		//TODO: Tambah kode buat response call
		Call <DomainSearch> call = apiCall.searchDomain(keyword);
		call.enqueue(new Callback<DomainSearch>() {
			@Override
			public void onResponse(Call<DomainSearch> call, Response<DomainSearch> response) {
				if (response.body() != null){
					callback.onDomainLoaded(response.body());
				}
			}

			@Override
			public void onFailure(Call<DomainSearch> call, Throwable t) {
				callback.onDataNotAvailable(t.toString());
			}
		});
	}
}
