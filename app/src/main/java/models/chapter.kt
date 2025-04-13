package models

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
class chapter (
    val index :Int,
    val titleEN : String,
    val titleAR :String,
    val versesNum :String
):Parcelable