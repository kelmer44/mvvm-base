package com.combustela.combustela.di.viewModel

import android.arch.lifecycle.ViewModel
import android.arch.lifecycle.ViewModelProvider
import com.combustela.combustela.ui.MainActivity
import com.combustela.combustela.ui.MainViewModel
import com.combustela.combustela.ui.detail.DetailViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap
import javax.inject.Singleton

@Module
abstract class ViewModelModule {

    @Binds
    internal abstract fun bindViewModelFactory(factory: CombustelaViewModelFactory): ViewModelProvider.Factory

    @Binds
    @IntoMap
    @ViewModelKey(MainViewModel::class)
    @Singleton
    internal abstract fun mainViewModel(viewModel: MainViewModel): ViewModel

    @Binds
    @IntoMap
    @ViewModelKey(DetailViewModel::class)
    @Singleton
    internal abstract fun detailViewMoedl(viewModel: DetailViewModel): ViewModel




}