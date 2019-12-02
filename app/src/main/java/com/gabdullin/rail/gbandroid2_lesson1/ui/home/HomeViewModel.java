package com.gabdullin.rail.gbandroid2_lesson1.ui.home;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class HomeViewModel extends ViewModel {

    private MutableLiveData<String> mText;

    public HomeViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("Погода в моем городе");
    }

    public LiveData<String> getText() {
        return mText;
    }
}