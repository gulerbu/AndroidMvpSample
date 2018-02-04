package com.example.burcuguler.androidmvpsample.weather.search;

import android.os.Handler;
import android.os.Message;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ProgressBar;

import com.example.burcuguler.androidmvpsample.R;
import com.example.burcuguler.androidmvpsample.core.BaseActivity;
import com.example.burcuguler.androidmvpsample.network.model.Location;
import com.example.burcuguler.androidmvpsample.view.BaseEditText;
import com.example.burcuguler.androidmvpsample.view.BaseTextView;

import java.lang.ref.WeakReference;
import java.util.List;

import butterknife.BindView;
import butterknife.OnTextChanged;

/**
 * Created by burcuguler on 8.01.2018.
 */

public class SearchActivity extends BaseActivity<SearchPresenter> implements
        SearchView, LocationSelectListener {

    private static final int KEY_TRIGGER_SEARCH = 1;
    private static final long SEARCH_DELAY_IN_MILLIS = 1000;

    @BindView(R.id.activity_search_edit_text_input)
    BaseEditText editTextInput;

    @BindView(R.id.activity_search_recycler_view_locations)
    RecyclerView recyclerViewLocations;

    @BindView(R.id.activity_search_progress_bar)
    ProgressBar progressBar;

    @BindView(R.id.activity_search_text_view_message)
    BaseTextView textViewMessage;

    private LocationListAdapter adapter;

    private SearchHandler searchHandler = new SearchHandler(this);

    private static class SearchHandler extends Handler {
        private final WeakReference<SearchActivity> activityReference;

        SearchHandler(SearchActivity activity) {
            activityReference = new WeakReference<>(activity);
        }

        @Override
        public void handleMessage(Message msg) {
            final SearchActivity activity = activityReference.get();
            if (activity != null && msg.what == KEY_TRIGGER_SEARCH) {
                activity.triggerSearch();

            }
        }
    }

    @Override
    public int getContentResourceId() {
        return R.layout.activity_search;
    }

    @Override
    public SearchPresenter createPresenter() {
        return new SearchPresenter();
    }

    @Override
    public void initUserInterface() {
        final RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this);
        recyclerViewLocations.setLayoutManager(layoutManager);

    }

    @Override
    public void showLoading() {
        progressBar.setVisibility(View.VISIBLE);

    }

    @Override
    public void dismissLoading() {
        if (progressBar.isShown()) {
            progressBar.setVisibility(View.INVISIBLE);
        }

    }

    @Override
    public void updateLocationList(List<Location> locations) {
        if (adapter == null) {
            adapter = new LocationListAdapter(locations, this);
            recyclerViewLocations.setAdapter(adapter);

        } else {
            adapter.update(locations);
        }

    }

    @Override
    public void updateMessageText(String message) {
        setMessageView();
        textViewMessage.setText(message);
    }

    private void triggerSearch() {
        presenter.onSearchTextChanged(editTextInput.getText().toString());
    }

    @OnTextChanged(value = R.id.activity_search_edit_text_input,
            callback = OnTextChanged.Callback.AFTER_TEXT_CHANGED)
    public void onInputTextChanged() {
        textViewMessage.setVisibility(View.GONE);
        recyclerViewLocations.setVisibility(View.VISIBLE);

        searchHandler.removeMessages(KEY_TRIGGER_SEARCH);
        searchHandler.sendEmptyMessageDelayed(KEY_TRIGGER_SEARCH, SEARCH_DELAY_IN_MILLIS);


    }

    @Override
    public void onLocationSelected(Location location) {
        presenter.onLocationSelect(location);

    }

    private void setMessageView() {
        textViewMessage.setVisibility(View.VISIBLE);
        recyclerViewLocations.setVisibility(View.GONE);
        if (adapter != null) {
            adapter.clear();
        }

    }

}
