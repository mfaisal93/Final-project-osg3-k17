package com.osg3.finalprojectk17.finalprojectk17osg3.data.remote;

import android.support.annotation.NonNull;
import com.osg3.finalprojectk17.finalprojectk17osg3.api.APICall;
import com.osg3.finalprojectk17.finalprojectk17osg3.api.APIClient;
import com.osg3.finalprojectk17.finalprojectk17osg3.data.DomainDataSource;
import com.osg3.finalprojectk17.finalprojectk17osg3.model.DomainSearch;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class DomainRemoteDataSource implements DomainDataSource {

	private APICall apiCall = APIClient.getService();

	@Override
	public void getListDomain(GetDomainCallback callback, String keyword) {
		Call<DomainSearch> call = apiCall.searchDomain(keyword);
		call.enqueue(new Callback<DomainSearch>() {
			@Override
			public void onResponse(@NonNull Call<DomainSearch> call, @NonNull Response<DomainSearch> response) {
				callback.onDomainLoaded(response.body());
			}

			@Override
			public void onFailure(@NonNull Call<DomainSearch> call, @NonNull Throwable t) {
				callback.onDataNotAvailable(t.getMessage());
			}
		});
	}
}
