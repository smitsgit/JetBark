package com.example.androidtemplate.di


import android.app.Application
import androidx.room.Room
import com.example.androidtemplate.data.remote.TemplateRemoteRepository
import com.example.androidtemplate.data.local.NoteDatabase
import com.example.androidtemplate.data.local.TemplateLocalRepository
import com.example.androidtemplate.data.remote.CoinPaprikaApi
import com.example.androidtemplate.domain.TemplateLocalRepo
import com.example.androidtemplate.domain.TemplateRemoteRepo
import com.example.androidtemplate.util.Constants.BASE_URL
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun providesOkhttpClient(): OkHttpClient {
        return OkHttpClient.Builder()
            .addInterceptor(HttpLoggingInterceptor())
            .build()
    }

    @Provides
    @Singleton
    fun provideCoinPaprikaApi(client: OkHttpClient): CoinPaprikaApi {
        return Retrofit.Builder()
            .client(client)
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build().create(CoinPaprikaApi::class.java)
    }

    @Provides
    @Singleton
    fun provideTemplateRemoteRepo(api: CoinPaprikaApi): TemplateRemoteRepo {
        return TemplateRemoteRepository(api)
    }

    @Provides
    @Singleton
    fun provideTemplateLocalRepo(database: NoteDatabase): TemplateLocalRepo {
        return TemplateLocalRepository(database.noteDao)
    }

    @Provides
    @Singleton
    fun providesNoteDatabase(app: Application): NoteDatabase {
        return Room.databaseBuilder(
            app,
            NoteDatabase::class.java,
            NoteDatabase.DATABASE_NAME).build()
    }


}