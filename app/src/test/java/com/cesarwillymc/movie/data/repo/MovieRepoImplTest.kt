package com.cesarwillymc.movie.data.repo

import com.cesarwillymc.movie.core.db.dao.MovieDao
import com.cesarwillymc.movie.core.model.Movie
import com.cesarwillymc.movie.core.retrofit.MoviesApi
import com.cesarwillymc.movie.utils.Data
import com.google.common.truth.Truth
import io.mockk.*
import io.mockk.impl.annotations.MockK
import kotlinx.coroutines.test.runBlockingTest
import org.junit.*
import retrofit2.await

internal class MovieRepoImplTest {
    @MockK(relaxed = true)
    private lateinit var api: MoviesApi

    @MockK(relaxed = true)
    private lateinit var movieDao: MovieDao

    private lateinit var movieRepo: MovieRepoImpl

    @Before
    fun setUp() {
        MockKAnnotations.init(this)
        movieRepo = MovieRepoImpl(api, movieDao)
    }


    @After
    fun tearDown() {
        clearMocks(api, movieDao)
    }

    @Test
    fun `get popular movies return data complete`() = runBlockingTest {
        mockkStatic("retrofit2.KotlinExtensions")
        //GIVEN
        coEvery {
            api.getPopularMovies(1).await()
        } returns Data.baseList[0]

        // WHEN
        val expected =
            movieRepo.getPopularMovies(1)
        // THEN
        Truth.assertThat(expected).isEqualTo(Data.baseList[0])
        coVerify(exactly = 1) {
            api.getPopularMovies(1).await()
        }
    }
    @Test
    fun `get popular movies return error`() = runBlockingTest {
        mockkStatic("retrofit2.KotlinExtensions")
        //GIVEN
        coEvery {
            api.getPopularMovies(1).await()
        } throws  Exception("Error")
        // WHEN
        val expected = try{
            movieRepo.getPopularMovies(1)
        }catch (e:Exception){
            e
        }

        // THEN
        Truth.assertThat(expected).isInstanceOf(Exception::class.java)
        coVerify(exactly = 1) {
            api.getPopularMovies(1).await()
        }
    }
    @Test
    fun `get movie db should return Null`() = runBlockingTest{
        //GIVEN
        coEvery {
            movieDao.getAllMovies()
        } returns listOf<Movie>()
        // WHEN
        val expected =      movieRepo.getMovieDB()


        // THEN
        Truth.assertThat(expected).isEqualTo(listOf<Movie>())
        coVerify(exactly = 1) {
            movieDao.getAllMovies()
        }
    }
    @Test
    fun `get movie db should return listData`() = runBlockingTest{
        //GIVEN
        coEvery {
            movieDao.getAllMovies()
        } returns Data.listMovie
        // WHEN
        val expected =      movieRepo.getMovieDB()


        // THEN
        Truth.assertThat(expected).isEqualTo( Data.listMovie)
        coVerify(exactly = 1) {
            movieDao.getAllMovies()
        }
    }

}