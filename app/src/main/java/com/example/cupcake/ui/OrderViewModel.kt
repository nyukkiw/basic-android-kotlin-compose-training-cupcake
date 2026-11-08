/*
 * Copyright (C) 2023 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.example.cupcake.ui

import androidx.lifecycle.ViewModel
import com.example.cupcake.data.ComponentOption
import com.example.cupcake.data.DataSource
import com.example.cupcake.data.OrderUiState
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import java.text.NumberFormat
import java.util.Locale

/** Harga dasar komputer/notebook (Rupiah) sebelum ditambah komponen pilihan */
private const val BASE_PRICE = 3_000_000L

/**
 * [OrderViewModel] menyimpan komponen komputer yang dipilih (prosesor, memori, hardisk,
 * monitor, kartu grafis) dan menghitung perkiraan harganya.
 */
class OrderViewModel : ViewModel() {

    private val _uiState = MutableStateFlow(OrderUiState())
    val uiState: StateFlow<OrderUiState> = _uiState.asStateFlow()

    fun setProcessor(name: String) = updateOrder { it.copy(processor = name) }

    fun setMemory(name: String) = updateOrder { it.copy(memory = name) }

    fun setStorage(name: String) = updateOrder { it.copy(storage = name) }

    fun setMonitor(name: String) = updateOrder { it.copy(monitor = name) }

    fun setGpu(name: String) = updateOrder { it.copy(gpu = name) }

    /**
     * Reset pesanan ke kondisi awal
     */
    fun resetOrder() {
        _uiState.value = OrderUiState()
    }

    /** Terapkan perubahan lalu hitung ulang harga dari state yang baru. */
    private fun updateOrder(change: (OrderUiState) -> OrderUiState) {
        _uiState.update { current ->
            val updated = change(current)
            updated.copy(price = calculatePrice(updated))
        }
    }

    /**
     * Perkiraan harga = harga dasar + harga tiap komponen yang sudah dipilih.
     */
    private fun calculatePrice(state: OrderUiState): String {
        val total = BASE_PRICE +
            priceOf(DataSource.processors, state.processor) +
            priceOf(DataSource.memories, state.memory) +
            priceOf(DataSource.storages, state.storage) +
            priceOf(DataSource.monitors, state.monitor) +
            priceOf(DataSource.gpus, state.gpu)
        val formatter = NumberFormat.getCurrencyInstance(Locale("id", "ID"))
        formatter.maximumFractionDigits = 0
        return formatter.format(total)
    }

    /** Harga opsi bernama [name] di [options]; 0 jika belum dipilih. */
    private fun priceOf(options: List<ComponentOption>, name: String): Long =
        options.firstOrNull { it.name == name }?.price ?: 0L
}
