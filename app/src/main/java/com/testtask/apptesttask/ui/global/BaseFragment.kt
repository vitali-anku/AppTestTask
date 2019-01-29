package com.testtask.apptesttask.ui.global

import android.os.Bundle
import android.view.LayoutInflater
import android.view.ViewGroup
import com.arellomobile.mvp.MvpAppCompatFragment
import com.testtask.apptesttask.toothpick.DI
import toothpick.Toothpick

abstract class BaseFragment : MvpAppCompatFragment() {

    abstract val layoutRes: Int

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ) = inflater.inflate(layoutRes, container, false)

    override fun onDestroy() {
        super.onDestroy()

        Toothpick.closeScope(DI.APP_SCOPE)
    }
}