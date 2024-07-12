package ilkadam.ilkzip.presentation.openwith

import android.net.Uri
import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalContext
import androidx.documentfile.provider.DocumentFile
import com.wwdablu.soumya.wzip.WZip.Companion.unzip
import com.wwdablu.soumya.wzip.WZipCallback
import java.lang.Exception

@Composable
fun OpenWithScreen(uri: Uri) {
    val context = LocalContext.current
    DocumentFile.fromSingleUri(context, uri)?.let {documentFile ->
        documentFile.createDirectory(uri.lastPathSegment + "_extracted")?.let {
            unzip(
                context = context,
                zipFile = documentFile,
                workerIdentifier = "Unzipper",
                destinationFolder = it,
                callback = CallBack()
            )
        }
    }
}

class CallBack : WZipCallback {
    override fun onError(worker: String, e: Exception, mode: WZipCallback.Mode) {

    }

    override fun onStart(worker: String, mode: WZipCallback.Mode) {

    }

    override fun onUnzipComplete(worker: String, extractedFolder: DocumentFile) {

    }

    override fun onZipComplete(worker: String, zipFile: DocumentFile) {

    }

}