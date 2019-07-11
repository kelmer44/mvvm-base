package com.combustela.combustela.ui.detail

import android.os.Bundle
import com.combustela.combustela.R
import com.combustela.combustela.base.mvvm.BaseActivity
import com.combustela.combustela.ui.MainViewModel

class DetailActivity: BaseActivity<DetailViewModel>() {
    override val viewModelClass: Class<DetailViewModel> = DetailViewModel::class.java
    override val layoutId: Int = R.layout.activity_detail
    override fun loadUp(savedInstanceState: Bundle?) {
    }

}