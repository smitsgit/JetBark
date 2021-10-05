package com.example.androidtemplate.domain

import com.example.androidtemplate.data.remote.dto.CoinDetailDto
import com.example.androidtemplate.data.remote.dto.CoinDto


interface TemplateRemoteRepo {
    suspend fun getCoins(): List<CoinDto>
    suspend fun getCoinDetails(coinId: String): CoinDetailDto
}