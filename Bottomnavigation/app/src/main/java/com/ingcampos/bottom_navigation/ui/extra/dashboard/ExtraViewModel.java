package com.ingcampos.bottom_navigation.ui.extra.dashboard;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class ExtraViewModel extends ViewModel {

    private MutableLiveData<String> mText;

    public ExtraViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("This is dashboard fragment");
    }

    public LiveData<String> getText() {
        return mText;
    }
}