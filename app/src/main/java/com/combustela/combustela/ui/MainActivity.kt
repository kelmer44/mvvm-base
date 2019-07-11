package com.combustela.combustela.ui

import android.os.Bundle
import android.widget.Toast
import com.combustela.combustela.R
import com.combustela.combustela.base.mvvm.BaseActivity
import com.combustela.combustela.util.ext.isVisible
import com.combustela.combustela.util.ext.observe
import com.combustela.combustela.util.livedata.Result
import kotlinx.android.synthetic.main.activity_main.*
import timber.log.Timber

class MainActivity : BaseActivity<MainViewModel>() {
    override val viewModelClass: Class<MainViewModel> = MainViewModel::class.java
    override val layoutId: Int = R.layout.activity_main

    override fun loadUp(savedInstanceState: Bundle?) {
        Timber.w("SUP")


        viewModel.lineas.observe(this) {
            progress_circular.isVisible = it?.inProgress ?: false

            when (it) {
                is Result.Success -> {
                    Timber.v("Lineas ${it.data.size}")
                }
                is Result.Failure -> {
                    Toast.makeText(this, "Error!", Toast.LENGTH_LONG).show()
                }
            }
        }
        viewModel.getLineas()

        detail_button.setOnClickListener {
           navigationController.goDetail("1234")
        }
    }

}
