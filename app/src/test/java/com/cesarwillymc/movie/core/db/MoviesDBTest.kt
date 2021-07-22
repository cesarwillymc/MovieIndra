package com.cesarwillymc.movie.core.db


import com.cesarwillymc.movie.core.db.dao.MovieDao
import io.mockk.MockKAnnotations
import io.mockk.every
import io.mockk.impl.annotations.MockK
import org.hamcrest.CoreMatchers
import org.hamcrest.MatcherAssert
import org.junit.Before
import org.junit.Test


internal open class MoviesDBTest{


    @MockK
    lateinit var appdb: MoviesDB
    @MockK
    lateinit var movieDao: MovieDao

    @Before
    fun setUp() {
        MockKAnnotations.init(this)
    }

    @Test
    fun obtainMovieDao() {
        every { appdb.moviesListData () } returns movieDao

        MatcherAssert.assertThat(
            appdb.moviesListData()   ,
            CoreMatchers.instanceOf(MovieDao::class.java)
        )
    }
}