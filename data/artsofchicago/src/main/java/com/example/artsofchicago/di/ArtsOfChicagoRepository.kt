package com.example.artsofchicago.di

data class Art(
    val id: Int,
    val image: String,
    val name: String,
    val authors: String
)

class ArtsOfChicagoService {
    fun getArts(): List<Art> = emptyList()
    fun getArtById(id: Int): Art? = null
}

interface ArtsOfChicagoRepository {
    fun getArts(): List<Art>
    fun getArtById(id: Int): Art?
}

internal class ArtsOfChicagoRepositoryImpl(
    private val artsOfChicagoService: ArtsOfChicagoService,
) : ArtsOfChicagoRepository {
    override fun getArts(): List<Art> = artsOfChicagoService.getArts()
    override fun getArtById(id: Int): Art? = artsOfChicagoService.getArtById(id)
}