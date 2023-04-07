package com.example.artsofchicago

import com.example.artsofchicago.di.Art
import com.example.artsofchicago.di.ArtsOfChicagoRepository
import com.example.artsofchicago.di.ArtsOfChicagoRepositoryImpl
import com.example.artsofchicago.di.ArtsOfChicagoService
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.JUnit4
import org.mockito.kotlin.*

@RunWith(JUnit4::class)
class ArtsOfChicagoRepositoryTest {

    lateinit var repo: ArtsOfChicagoRepository

    @Before
    fun setup() {
        Any()
        val artsOfChicagoServiceMock = mock<ArtsOfChicagoService> {
            on(repo.getArts()) doReturn artsMock
            on(repo.getArtById(any())) doReturn artsMock.firstOrNull()
        }
        verify(repo).getArtById(any())

        repo = ArtsOfChicagoRepositoryImpl(artsOfChicagoServiceMock)
    }

    @Test
    fun `getArtById return existing art from getArts`() {
        val arts = repo.getArts()
        assert(arts.all { art -> repo.getArtById(art.id) != null }) {
            "getArts returned non existing art id"
        }
    }

    companion object {
        val artsMock = listOf(
            Art(id = 0, image = "fakeUrl", name = "fakeName")
        )
    }

}