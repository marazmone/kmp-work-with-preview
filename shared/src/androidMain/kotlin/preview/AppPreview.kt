package preview

import App
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview

@Composable
@Preview(device = "id:pixel_5", showSystemUi = true)
fun AppPreview() {
    App()
}