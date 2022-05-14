package dev.tutorial.kmmargherita.util

import kotlinx.coroutines.CoroutineScope

/**
 * A base ViewModel abstraction over the Android Jetpack ViewModel implementation
 */
expect abstract class CoroutineViewModel() {

    val coroutineScope: CoroutineScope

    /**
     * Dispose all running operations under the coroutineScope
     */
    fun dispose()

    /**
     * This method will be called when this ViewModel is no longer used and will be destroyed.
     */
    protected open fun onCleared()
}
