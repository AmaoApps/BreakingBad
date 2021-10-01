package pe.paku.brakingbad.domain.model


data class BadCharacterDetail(

    val charId: Int,
    val name: String,
    val nickname: String,
    val occupation: List<String>,
    val status: String,
    val img: String,
    val portrayed: String,
    val isFavorite: Boolean
)
