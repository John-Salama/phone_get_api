package com.ahmdalii.mvvmdemo.ui.home.viewmodel;

import androidx.annotation.NonNull;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;

import com.ahmdalii.mvvmdemo.ui.home.repo.HomeRepo;

public class HomeViewModelFactory implements ViewModelProvider.Factory {

    private HomeRepo repo;

    public HomeViewModelFactory(HomeRepo repo) {
        this.repo = repo;
    }

    @NonNull
    @Override
    public <T extends ViewModel> T create(@NonNull Class<T> modelClass) {
        if (modelClass.isAssignableFrom(HomeViewModel.class)) {
            return (T) new HomeViewModel(repo);
        } else {
            throw new IllegalArgumentException("HomeViewModel class not found");
        }
    }
}
