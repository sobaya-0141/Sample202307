package sobaya.app.features.native

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.interop.UIKitView
import platform.UIKit.UIFont.Companion.systemFontOfSize
import platform.UIKit.UIView
import platform.UIKit.UILabel
import platform.UIKit.NSLayoutConstraint

@Composable
internal actual fun native(test: String) {
    UIKitView(
        factory = ::createLabelView
    )
}

fun createLabelView(): UIView {
    val label = UILabel().apply {
        text = "Hello, UIKit!"
        font = systemFontOfSize(24.0)
    }

    return UIView().apply {
        addSubview(label)

        label.translatesAutoresizingMaskIntoConstraints = false
        NSLayoutConstraint.activate(listOf(
            label.topAnchor.constraintEqualToAnchor(topAnchor),
            label.bottomAnchor.constraintEqualToAnchor(bottomAnchor),
            label.leadingAnchor.constraintEqualToAnchor(leadingAnchor),
            label.trailingAnchor.constraintEqualToAnchor(trailingAnchor)
        ))
    }
}
