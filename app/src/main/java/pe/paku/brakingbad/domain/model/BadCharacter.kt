package pe.paku.brakingbad.domain.model


data class BadCharacter(

    val charId: Int,
    val name: String,
    val nickname: String,
    val img: String,
    var isFavorite: Boolean

)

