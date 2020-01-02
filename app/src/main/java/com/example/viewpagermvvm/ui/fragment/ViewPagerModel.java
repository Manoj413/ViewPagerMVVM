package com.example.viewpagermvvm.ui.fragment;

import android.util.Log;

import androidx.arch.core.util.Function;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Transformations;
import androidx.lifecycle.ViewModel;

import com.example.viewpagermvvm.data.model.Repo;
import com.example.viewpagermvvm.data.model.User;
import com.example.viewpagermvvm.data.rest.APIClient;
import com.example.viewpagermvvm.data.rest.APIClientUser;
import com.example.viewpagermvvm.data.rest.APIInterface;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import io.reactivex.Scheduler;
import io.reactivex.Single;
import io.reactivex.SingleObserver;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ViewPagerModel extends ViewModel {

    private MutableLiveData<String> mTitle = new MutableLiveData<>();

    private ArrayList<Repo> repoArrayList = new ArrayList<>();
    private ArrayList<ViewPagerModel> viewPagerModelArrayList = new ArrayList<>();
    private MutableLiveData<ArrayList<Repo>> mRepoData = new MutableLiveData<>();

    private MutableLiveData<User> userMutableLiveData = new MutableLiveData<>();
    private final MutableLiveData<Boolean> repoLoadError = new MutableLiveData<>();
    private final MutableLiveData<Boolean> loading = new MutableLiveData<>();
    private CompositeDisposable disposable = new CompositeDisposable();
    private APIInterface apiInterface;

  /* @Inject
   public ViewPagerModel(APIInterface repoRepository) {
       this.apiInterface = repoRepository;
      // disposable = new CompositeDisposable();
      getMutableLiveData();
       getMutableLiveUserData();
   }
    LiveData<ArrayList<Repo>> getRepos() {
        return mRepoData;
    }

    LiveData<User> getUserData() {
        return userMutableLiveData;
    }

*/

    LiveData<Boolean> getError() {
        return repoLoadError;
    }
    LiveData<Boolean> getLoading() {
        return loading;
    }
    public void setIndex(String index) {
        mTitle.setValue(index);
    }

    public LiveData<ArrayList<Repo>> getText() {
        return mRepoData;
    }
    public MutableLiveData<ArrayList<Repo>> getMutableLiveData()
    {
        loading.setValue(true);
        APIInterface apiInterface = APIClient.getInstance().getMyApi();

        Single<ArrayList<Repo>> call = apiInterface.getRepoData();


        call.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new SingleObserver<ArrayList<Repo>>()
                {
                    @Override
                    public void onSubscribe(Disposable d)
                    {
                        Log.e("onSubscribe","onSubscribe");
                       repoLoadError.setValue(true);
                      // loading.setValue(false);

                    }

                    @Override
                    public void onSuccess(ArrayList<Repo> value)
                    {
                        Log.e("onSuccess","onSuccess = "+value.toString());
                        mRepoData.setValue(value);
                        repoLoadError.setValue(false);
                        loading.setValue(false);
                    }

                    @Override
                    public void onError(Throwable e)
                    {
                        Log.e("onError","onError = "+e);
                        loading.setValue(false);
                    }
                });

        return mRepoData;
    }


    public MutableLiveData<User> getMutableLiveUserData()
    {
        loading.setValue(true);
        APIInterface apiInterface = APIClientUser.getInstance().getMyApi();

        Single<User> call = apiInterface.getUserData();

       call.subscribeOn(Schedulers.io())
               .observeOn(AndroidSchedulers.mainThread())
               .subscribe(new SingleObserver<User>() {
                   @Override
                   public void onSubscribe(Disposable d) {
                       Log.e("onSubscribe2","onSubscribe2");
                       repoLoadError.setValue(true);
                       //loading.setValue(false);
                   }

                   @Override
                   public void onSuccess(User value) {
                       Log.e("onSuccess2","onSuccess2 = "+value.toString());
                       userMutableLiveData.setValue(value);
                       repoLoadError.setValue(false);
                       loading.setValue(false);
                   }

                   @Override
                   public void onError(Throwable e) {
                       Log.e("onError2","onError2 = "+e);
                       loading.setValue(false);
                   }
               });
        return userMutableLiveData;
    }

    @Override
    protected void onCleared() {
        super.onCleared();
    }
}