package com.example.apkroomtamires.di

import com.example.apkroomtamires.data.datasources.ProductDataSource
import com.example.apkroomtamires.data.repositories.ProdutoRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object RepositoryModule {

    @Provides
    @Singleton
    fun providesProductRepository(productDataSource: ProductDataSource): ProdutoRepository {
        return ProdutoRepository(productDataSource)
    }
}