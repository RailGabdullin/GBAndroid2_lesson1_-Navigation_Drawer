package com.gabdullin.rail.gbandroid2_lesson1.ui.share;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class ShareViewModel extends ViewModel {

    private MutableLiveData<String> mText;

    public ShareViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("Рассказать о погоде");
    }

    public LiveData<String> getText() {
        return mText;
    }
}