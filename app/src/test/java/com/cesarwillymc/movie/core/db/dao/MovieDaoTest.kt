package com.cesarwillymc.movie.core.db.dao


import androidx.room.Room
import androidx.test.platform.app.InstrumentationRegistry
import com.cesarwillymc.movie.common.TestRobolectric
import com.cesarwillymc.movie.core.db.MoviesDB
import com.cesarwillymc.movie.utils.Data
import junit.framework.Assert.assertEquals
import junit.framework.Assert.assertNotSame
import kotlinx.coroutines.runBlocking
import org.junit.*


class MovieDaoTest : TestRobolectric() {



    private lateinit var database: MoviesDB
    private lateinit var movieDao: MovieDao


    @Before
    fun setUp() = runBlocking {
        val context = InstrumentationRegistry.getInstrumentation().targetContext
        database = Room
            .inMemoryDatabaseBuilder(context, MoviesDB::class.java)
            .allowMainThreadQueries()
            .build()
        movieDao = database.moviesListData()
    }

    @After
    fun destroy() {
        database.close()
    }

    @Test
    fun `obtain movies, should return null`() {
        val movies = movieDao.getAllMovies()
        Assert.assertTrue(movies.isEmpty())
    }

    @Test
    fun `insert movies and obtain  movie, should return data and equals data`(){
        movieDao.insertMovie(Data.listMovie[0])
        val movie = movieDao.getAllMovies()
        assertEquals(listOf(Data.listMovie[0]), movie)
    }

    @Test
    fun `insert movies and obtain  movie, should return data but this data is different`() {
        movieDao.insertMovie(Data.listMovie[1])
        val movie = movieDao.getAllMovies()
        assertNotSame(listOf(Data.listMovie[0]), movie)
    }



}