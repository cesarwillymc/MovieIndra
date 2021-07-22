
package com.cesarwillymc.movie.module

import com.cesarwillymc.movie.app.MyApp
import com.cesarwillymc.movie.module.scope.AppScope
import dagger.Component

@AppScope
@Component(
    dependencies = [CoreComponent::class],
    modules = [AppModule::class]
)
interface AppComponent {

    fun inject(application: MyApp)
}
