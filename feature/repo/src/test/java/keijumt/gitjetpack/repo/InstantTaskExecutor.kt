package keijumt.gitjetpack.repo

import androidx.arch.core.executor.TaskExecutor

object InstantTaskExecutor : TaskExecutor() {
    override fun executeOnDiskIO(runnable: Runnable) {
        runnable.run()
    }

    override fun isMainThread(): Boolean = true

    override fun postToMainThread(runnable: Runnable) {
        runnable.run()
    }
}