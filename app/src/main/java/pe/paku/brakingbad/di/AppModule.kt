package pe.paku.brakingbad.di

import android.app.Application
import android.content.Context
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import pe.paku.brakingbad.common.Constants
import pe.paku.brakingbad.data.local.prefs.PrefsDataStore
import pe.paku.brakingbad.data.remote.BreakingBadApi
import pe.paku.brakingbad.data.repository.BadCharacterRepositoryImpl
import pe.paku.brakingbad.data.repository.PrefsDataStoreImpl
import pe.paku.brakingbad.domain.repository.BadCharacterRepository
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun provideApi() : BreakingBadApi {
        return Retrofit.Builder()
            .baseUrl(Constants.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(BreakingBadApi::class.java)
    }

    @Provides
    @Singleton
    fun providesLocalStorage(@ApplicationContext context: Context) : PrefsDataStore {
        return PrefsDataStoreImpl(context = context)
    }

    @Provides
    @Singleton
    fun providesRepository(api: BreakingBadApi) : BadCharacterRepository {
        return BadCharacterRepositoryImpl(api)
    }

}