package com.sd.lib.mvvm

import android.view.View
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.LifecycleRegistry


/**
 * 返回View对应的[LifecycleOwner]
 */
fun View.fLifecycleOwner(): LifecycleOwner {
    val tag = getTag(R.id.lib_mvvm_view_tag_lifecycle_owner)
    if (tag is LifecycleOwner) {
        return tag
    }

    val lifecycleOwner = object : LifecycleOwner {
        val lifecycleRegistry = LifecycleRegistry(this)

        init {
            addOnAttachStateChangeListener(object : View.OnAttachStateChangeListener {
                override fun onViewAttachedToWindow(v: View) {
                    lifecycleRegistry.currentState = Lifecycle.State.RESUMED
                }

                override fun onViewDetachedFromWindow(v: View) {
                    lifecycleRegistry.currentState = Lifecycle.State.DESTROYED
                }
            })
        }

        override fun getLifecycle(): Lifecycle {
            return lifecycleRegistry
        }
    }

    return lifecycleOwner.also {
        setTag(R.id.lib_mvvm_view_tag_lifecycle_owner, it)
    }
}

/**
 * 返回View对应的[Lifecycle]
 */
fun View.fLifecycle(): Lifecycle {
    return fLifecycleOwner().lifecycle
}