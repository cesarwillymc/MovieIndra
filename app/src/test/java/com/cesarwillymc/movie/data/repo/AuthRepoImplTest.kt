package com.cesarwillymc.movie.data.repo

import com.cesarwillymc.movie.core.model.Usuario
import com.cesarwillymc.movie.data.utils.RequestUser
import com.google.common.truth.Truth
import io.mockk.*
import io.mockk.impl.annotations.MockK
import junit.framework.Assert
import kotlinx.coroutines.test.runBlockingTest
import org.junit.After
import org.junit.Before
import org.junit.*

class AuthRepoImplTest {

    @MockK(relaxed = true)
    private lateinit var requestUser: RequestUser

    private lateinit var authRepo: AuthRepoImpl

    @Before
    fun setUp() {
        MockKAnnotations.init(this)
        authRepo = AuthRepoImpl(requestUser)
    }

    @After
    fun tearDown() {
        clearMocks(requestUser)
    }

    @Test
    fun `Send request, should return Exception`() = runBlockingTest {
        val user = ""
        val pass = ""
        //GIVEN
        every {
            requestUser.requestServer(user, pass)
        } throws Exception("Not work")

        // WHEN
        val expected = try {
            authRepo.signIn(user, pass)
        } catch (e: Exception) {
            e
        }
        // THEN
        Truth.assertThat(expected).isInstanceOf(Exception::class.java)
        coVerify(exactly = 1) {
            requestUser.requestServer(user, pass)
        }

    }

    @Test
    fun `Send request user incorrect, should return data`() = runBlockingTest {
        val user = ""
        val pass = ""

        //GIVEN
        every {
            requestUser.requestServer(user, pass)
        } returns Usuario(message = "Usuario incorrecto", code = 401, user = null)

        // WHEN
        val expected = authRepo.signIn(user, pass)
        // THEN
        Truth.assertThat(expected).isInstanceOf(Usuario::class.java)
        Assert.assertEquals("Usuario incorrecto", expected.message)
        coVerify(exactly = 1) {
            requestUser.requestServer(user, pass)
        }
    }

    @Test
    fun `Send request pass incorrect, should return data`() = runBlockingTest {
        val user = ""
        val pass = ""
        //GIVEN
        every {
            requestUser.requestServer(user, pass)
        } returns Usuario(message = "Contraseña incorrecta", code = 401, user = null)

        // WHEN
        val expected =
            authRepo.signIn(user, pass)
        // THEN
        Truth.assertThat(expected).isInstanceOf(Usuario::class.java)
        Assert.assertEquals("Contraseña incorrecta", expected.message)
        coVerify(exactly = 1) {
            requestUser.requestServer(user, pass)
        }
    }

    @Test
    fun `Send request , should return data`() = runBlockingTest {
        val user = ""
        val pass = ""
        //GIVEN
        every {
            requestUser.requestServer(user, pass)
        } returns Usuario(message = "Se ejecuto correctamente", code = 200, user = "123456789")

        // WHEN
        val expected =
            authRepo.signIn(user, pass)
        // THEN
        Truth.assertThat(expected).isInstanceOf(Usuario::class.java)
        Assert.assertEquals("Se ejecuto correctamente", expected.message)
        coVerify(exactly = 1) {
            requestUser.requestServer(user, pass)
        }
    }
}