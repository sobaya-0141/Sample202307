package sobaya.app.sample

import dev.icerock.moko.resources.desc.Resource
import dev.icerock.moko.resources.desc.StringDesc

fun getTestString(): StringDesc = StringDesc.Resource(MR.strings.test)