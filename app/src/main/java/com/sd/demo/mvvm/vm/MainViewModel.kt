package com.sd.demo.mvvm.vm

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class MainViewModel : ViewModel() {
    private var _clickCount = 0
    private val _clickCountData = MutableLiveData(_clickCount)

    /** 点击次数 */
    val clickCount: LiveData<Int>
        get() = _clickCountData

    /**
     * 触发点击方法
     */
    fun click() {
        _clickCount++
        _clickCountData.value = _clickCount
    }
}