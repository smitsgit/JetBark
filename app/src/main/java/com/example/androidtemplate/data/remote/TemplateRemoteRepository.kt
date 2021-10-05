package com.example.androidtemplate.data.remote

import com.example.androidtemplate.data.remote.CoinPaprikaApi
import com.example.androidtemplate.domain.TemplateRemoteRepo
import com.example.androidtemplate.data.remote.dto.CoinDetailDto
import com.example.androidtemplate.data.remote.dto.CoinDto

import javax.inject.Inject

class TemplateRemoteRepository @Inject constructor(val api: CoinPaprikaApi) : TemplateRemoteRepo {

    override suspend fun getCoins(): List<CoinDto> {
        TODO("Not yet implemented")
    }

    override suspend fun getCoinDetails(coinId: String): CoinDetailDto {
        TODO("Not yet implemented")
    }

}