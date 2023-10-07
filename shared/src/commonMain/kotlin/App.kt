import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.Button
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.platform.LocalInspectionMode
import androidx.compose.ui.unit.dp
import org.jetbrains.compose.resources.ExperimentalResourceApi
import org.jetbrains.compose.resources.painterResource

@Composable
fun App() {
    MaterialTheme {
        var greetingText by remember { mutableStateOf("Hello, World!") }
        Column(Modifier.fillMaxWidth(), horizontalAlignment = Alignment.CenterHorizontally) {
            Button(onClick = {
                greetingText = "Hello, ${getPlatformName()}"
            }) {
                Text(greetingText)
            }
            ImageForPreviewMode(
                resourcePath = "compose-multiplatform.xml",
                modifier = Modifier
                    .size(200.dp)
            )
        }
    }
}

@OptIn(ExperimentalResourceApi::class)
@Composable
fun ImageForPreviewMode(
    resourcePath: String,
    contentDescription: String? = null,
    modifier: Modifier = Modifier,
    mockShape: Shape = CircleShape,
) {
    if (LocalInspectionMode.current) {
        Box(
            modifier = modifier
                .clip(mockShape)
                .background(Color.Blue)
        )
    } else {
        Image(
            painterResource(resourcePath),
            contentDescription,
            modifier = modifier
        )
    }
}

expect fun getPlatformName(): String