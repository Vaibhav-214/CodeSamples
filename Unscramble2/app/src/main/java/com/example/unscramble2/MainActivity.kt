package com.example.unscramble2

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.tooling.preview.Preview
import com.example.unscramble2.ui.Unscramble
import com.example.unscramble2.ui.theme.Unscramble2Theme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        Log.d("ACT", "On create is called")

        super.onCreate(savedInstanceState)
        setContent {
            Unscramble()
        }
    }

    override fun onStart() {
        super.onStart()
        Log.d("ACT", "On start is called")
    }

    override fun onResume() {
        super.onResume()
        Log.d("ACT", "On resume is called")
    }

    override fun onPause() {
        super.onPause()
        Log.d("ACT", "On pause is called")
    }

    override fun onStop() {
        super.onStop()
        Log.d("ACT", "On stop is called")
    }

    override fun onRestart() {
        super.onRestart()
        Log.d("ACT", "On restart is called")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.d("ACT", "On destroy is called")

    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Image(imageVector = ImageVector.vectorResource(id = R.drawable.mye), contentDescription = null)
}
