package ilkadam.ilkzip.presentation.openwith

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import ilkadam.ilkzip.ui.theme.IlkZipTheme

class OpenWithActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        val uri = intent.data
        setContent {
            IlkZipTheme {
                if (uri != null) {
                    OpenWithScreen(uri)
                }
            }
        }
    }
}
