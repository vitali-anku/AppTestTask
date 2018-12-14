package com.testtask.apptesttask.presentation.base

import android.support.annotation.DrawableRes

interface CharacterViewHolder {
    fun setData(avatar: String, name: String, description: String)
    fun setStar(@DrawableRes resid: Int)
}