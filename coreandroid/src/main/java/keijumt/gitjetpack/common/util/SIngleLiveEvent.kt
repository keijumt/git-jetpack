package keijumt.gitjetpack.common.util

import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import java.util.concurrent.atomic.AtomicBoolean

/**
 * Observerに一度のみ通知するLiveData
 */
class SingleLiveEvent<T> : MutableLiveData<T>() {

    private val mPending = AtomicBoolean(false)

    override fun observe(owner: LifecycleOwner, observer: androidx.lifecycle.Observer<in T>) {
        super.observe(owner, Observer {
            // 新たに値がsetValueされているとき
            if (mPending.compareAndSet(true, false)) {
                observer.onChanged(it)
            }
        })
    }

    override fun setValue(t: T?) {
        mPending.set(true)
        super.setValue(t)
    }
}