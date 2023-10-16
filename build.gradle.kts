import java.nio.file.Files
import java.nio.file.Paths

plugins {
    alias(libs.plugins.multiplatform).apply(false)
    alias(libs.plugins.compose).apply(false)
    alias(libs.plugins.cocoapods).apply(false)
    alias(libs.plugins.android.application).apply(false)
    alias(libs.plugins.libres).apply(false)
    alias(libs.plugins.buildConfig).apply(false)
    alias(libs.plugins.kotlinx.serialization).apply(false)
    alias(libs.plugins.sqlDelight).apply(false)
}

fun generateFromCSV(csvPath: String): List<Map<String, String>> {
    val lines = Files.readAllLines(Paths.get(csvPath))
    val androidMapJA = mutableMapOf<String, String>()
    val androidMapEN = mutableMapOf<String, String>()
    val iosMapJA = mutableMapOf<String, String>()
    val iosMapEN = mutableMapOf<String, String>()

    for (i in 1 until lines.size) { // Skip header
        val parts = lines[i].split(',')
        androidMapJA[parts[1]] = parts[2]
        androidMapEN[parts[1]] = parts[3]
        iosMapJA[parts[1]] = parts[2]
        iosMapEN[parts[1]] = parts[3]
    }

    return listOf(androidMapJA, androidMapEN, iosMapJA, iosMapEN)
}

tasks.register("generateResources") {
    doLast {
        val maps = generateFromCSV("string_resource.csv")

        // Generate Android Japanese strings.xml
        val jaFile = file("composeApp/src/androidMain/res/values-ja/strings.xml")
        jaFile.parentFile.mkdirs()

        jaFile.writeText("""<?xml version="1.0" encoding="utf-8"?>\n<resources>\n""")
        maps[0].forEach { (key, value) ->
            jaFile.appendText("""    <string name="$key">$value</string>\n""")
        }
        jaFile.appendText("</resources>")

        // Generate Android English strings.xml
        val enFile = file("composeApp/src/androidMain/res/values-en/strings.xml")
        enFile.parentFile.mkdirs()
        enFile.writeText("""<?xml version="1.0" encoding="utf-8"?>\n<resources>\n""")
        maps[1].forEach { (key, value) ->
            enFile.appendText("""    <string name="$key">$value</string>\n""")
        }
        enFile.appendText("</resources>")

        // Generate iOS Japanese Localizable.strings
        val iosJAFile = file("iosApp/ja.lproj/Localizable.strings")
        iosJAFile.parentFile.mkdirs()
        maps[2].forEach { (key, value) ->
            iosJAFile.appendText(""""$key" = "$value";\n""")
        }

        // Generate iOS English Localizable.strings
        val iosENFile = file("iosApp/en.lproj/Localizable.strings")
        iosENFile.parentFile.mkdirs()
        maps[3].forEach { (key, value) ->
            iosENFile.appendText(""""$key" = "$value";\n""")
        }
    }
}
