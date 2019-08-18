package com.example.mvvm.base.recyclerview

import com.example.mvvm.constants.Constants.POSITION_DEFAULT

interface OnItemClickListener<T> {
    fun onItemViewClick(item: T, position: Int = POSITION_DEFAULT)
}