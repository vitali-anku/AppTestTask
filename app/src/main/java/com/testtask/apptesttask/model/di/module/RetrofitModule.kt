package com.testtask.apptesttask.model.di.module

import com.google.gson.FieldNamingPolicy
import com.google.gson.FieldNamingStrategy
import com.google.gson.Gson
import com.google.gson.GsonBuilder
import dagger.Module
import dagger.Provides
import retrofit2.Converter
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import java.lang.reflect.Field
import javax.inject.Singleton

@Module
class RetrofitModule {

    @Provides
    @Singleton

    fun provideRetrofit(builder: Retrofit.Builder): Retrofit {
        return builder.baseUrl("https://gateway.marvel.com").build()
    }

    @Provides
    @Singleton

    fun provideRetrofitBuilder(converterFactory: Converter.Factory): Retrofit.Builder {
        return Retrofit.Builder()
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(converterFactory)
    }

    @Provides
    @Singleton

    fun provideConverterFactory(gson: Gson): Converter.Factory {
        return GsonConverterFactory.create(gson)
    }

    @Provides
    @Singleton

    fun provideGson(): Gson {
        return GsonBuilder()
                .setFieldNamingPolicy(FieldNamingPolicy.UPPER_CAMEL_CASE)
                .setFieldNamingStrategy(CustomFieldNamingPolicy())
                .setPrettyPrinting()
                .setDateFormat("yyyy-MM-dd'T'HH:mm:ssZ")
                .serializeNulls()
                .create()
    }

    private class CustomFieldNamingPolicy : FieldNamingStrategy {

        override fun translateName(field: Field): String {

            var name = FieldNamingPolicy.LOWER_CASE_WITH_UNDERSCORES.translateName(field)
            name = name.substring(2, name.length).toLowerCase()
            return name
        }
    }
}