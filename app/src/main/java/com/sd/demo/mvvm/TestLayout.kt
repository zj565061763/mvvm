package com.sd.demo.mvvm

import android.content.Context
import android.util.AttributeSet
import android.widget.FrameLayout
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.LifecycleRegistry

class TestLayout : FrameLayout, LifecycleOwner {
    /** 生命周期事件分发  */
    private val _lifecycleRegistry = LifecycleRegistry(this)

    constructor(context: Context, attrs: AttributeSet?) : super(context, attrs) {

    }

    override fun getLifecycle(): Lifecycle {
        return _lifecycleRegistry
    }

    override fun onAttachedToWindow() {
        super.onAttachedToWindow()
        _lifecycleRegistry.currentState = Lifecycle.State.RESUMED
    }

    override fun onDetachedFromWindow() {
        super.onDetachedFromWindow()
        _lifecycleRegistry.currentState = Lifecycle.State.DESTROYED
    }
}