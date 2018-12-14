package com.testtask.apptesttask.presentation.base

import com.arellomobile.mvp.MvpPresenter
import com.arellomobile.mvp.MvpView
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.disposables.Disposable

open class BasePresenter<V : MvpView> : MvpPresenter<V>() {
    private val compositeDisposable = CompositeDisposable()

    override fun onDestroy() {
        super.onDestroy()
        compositeDisposable.clear()
    }

    protected fun unsubscribeOnDestroy(disposable: Disposable) {
        compositeDisposable.add(disposable)
    }
}