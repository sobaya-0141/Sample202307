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

buildscript {
    dependencies {
        classpath(libs.resources.generator)
    }
}

fun generateFromCSV(csvPath: String): Triple<List<String>, List<Map<String, String>>, List<String>> {
    val lines = Files.readAllLines(Paths.get(csvPath))
    val resourceIds = ArrayList<String>()
    val texts = ArrayList<Map<String, String>>()
    val langs = ArrayList<String>()

    lines.forEachIndexed { index, line ->
        val parts = line.split(',')
        if (index != 0) {
            // 画面名以外を取得
            resourceIds.add(parts[1])
            val messageMap = parts.drop(2).mapIndexed { index, s -> langs[index] to s }.toMap()
            texts.add(messageMap)
        } else {
            // 言語コードを取得
            langs.addAll(parts.drop(2))
        }
    }

    return Triple(resourceIds, texts, langs)
}

tasks.register("generateResources") {
    doLast {
        val csvData = generateFromCSV("string_resource.csv")
        val resourceIds = csvData.first
        val texts = csvData.second
        val langs = csvData.third.toMutableList()

        // moko-resourcesの基準となるbaseの作成
        langs.add("base")

        langs.forEach {
            val file = file("composeApp/src/commonMain/resources/MR/${it}/strings.xml")
            // 言語毎のディレクトリ作成
            file.parentFile.parentFile.mkdirs()
            file.writeText("<?xml version=\"1.0\" encoding=\"utf-8\"?>\n<resources>\n")
            resourceIds.forEachIndexed { index, resourceId ->
                // baseの時は一番左の言語をbaseにする
                val lang = if (it == "base") langs[0] else it
                val value = texts[index][lang]
                file.appendText("    <string name=\"$resourceId\">$value</string>\n")
            }
            file.appendText("</resources>\n")
        }

    }
}
