package www.revengerfitness.blogspot.com.coroutine2kotlin

import android.nfc.Tag
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.yield

/**
 *  coroutines helps to implement functionality that can be suspended and later resumed at specified points without blocking the thread.
 *  suspending function means function with suspend modifier.
 *  helps coroutine to suspend the computation at a particular point.
 *  Suspending functions must be called from either Coroutines or other Suspending Function.
 *  */

class MainActivity : AppCompatActivity() {

    private val Tag: String = "prashant chauhan"
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        CoroutineScope(Dispatchers.Main).launch { // coroutine in order to launch suspending function.
            task1()
        }

        CoroutineScope(Dispatchers.Main).launch { // coroutine in order to launch suspending function.
            task2()
        }
    }


    suspend fun task1() {
        Log.d(Tag, "starting task1")
        yield() // in order to define suspension point.
        Log.d(Tag, "ending task1")
    }

    suspend fun task2() {
        Log.d(Tag, "starting task2")
        delay(1000) // it is also a suspending function like yield.
        Log.d(Tag, "ending task2")
    }
}