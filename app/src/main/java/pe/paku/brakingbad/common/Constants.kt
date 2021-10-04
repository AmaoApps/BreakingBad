package pe.paku.brakingbad.common

object Constants {

    const val BASE_URL : String = "https://www.breakingbadapi.com/api/"
    const val TiTLE_LIST_CHARACTERS = "Breaking Bad Characters"
    const val TiTLE_DETAIL_CHARACTERS = "Detail Character"
    const val EMPTY_STRING = ""

    object PathScreen {
        const val DETAIL_CHARACTER_SCREEN = "detail_screen"
        const val LIST_CHARACTER_SCREEN = "list_character_screen"

        object PARAMS {
            const val PARAM_ID_CHARACTER : String = "idCharacter"
        }

    }

    object Prefs {
        const val DATA_STORAGE_NAME = "BB_DATA_STORAGE"
    }

    const val DETAIL_CHARACTER_OCCUPATION = "Occupation"
    const val DETAIL_CHARACTER_STATUS = "Status"
    const val DETAIL_CHARACTER_PORTRAYED = "Portrayed"
}