
package com.cesarwillymc.movie.module

import com.cesarwillymc.movie.app.MyApp
import com.cesarwillymc.movie.module.scope.FeatureScope
import dagger.Component

@FeatureScope
@Component(
    dependencies = [CoreComponent::class],
    modules = [AppModule::class]
)
interface AppComponent {

    fun inject(application: MyApp)
}
