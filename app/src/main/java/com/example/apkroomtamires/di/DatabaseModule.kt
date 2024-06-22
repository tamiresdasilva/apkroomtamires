package br.com.ulbra.exemplorecycler.di

import android.content.Context
import androidx.room.Room
import com.example.apkroomtamires.data.database.AppDatabase
import com.example.apkroomtamires.data.database.ProductDao
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DatabaseModule {

    @Provides
    @Singleton
    fun provideAppDatabase(@ApplicationContext context: Context): AppDatabase {
        return Room
            .databaseBuilder(context, AppDatabase::class.java, "aula")
            .fallbackToDestructiveMigration()
            .build()
    }

    @Provides
    @Singleton
    fun provideProductDaoService(appDatabase: AppDatabase): ProductDao {
        return appDatabase.productDao()
    }
}