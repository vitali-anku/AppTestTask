package com.testtask.apptesttask.presentation.base

import com.arellomobile.mvp.MvpPresenter
import com.arellomobile.mvp.MvpView

open class BasePresenter<V : MvpView > : MvpPresenter<V>()