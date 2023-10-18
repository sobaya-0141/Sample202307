import UIKit
import SwiftUI
import ComposeApp

@main
struct iosApp: App {
    init() {
        MainKt.doInitKoin()
    }
    
    var body: some Scene {
        WindowGroup {
            ContentView()
        }
    }
}

struct ContentView: View {
    var body: some View {
        let test = MR.strings().test.desc().localized()
        Text(
            StringResourcesKt.getTestString().localized()
        )
        Text(
            test
        )
    }
}
