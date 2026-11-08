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
package com.example.cupcake.data

/**
 * Data class yang menyimpan state pesanan komputer: komponen yang dipilih dan
 * perkiraan harga ([price]) yang sudah diformat dalam Rupiah.
 */
data class OrderUiState(
    /** Jenis prosesor, mis. "Intel Core i5" */
    val processor: String = "",
    /** Besar memori, mis. "8 GB" */
    val memory: String = "",
    /** Ukuran dan tipe hardisk, mis. "SSD 512 GB" */
    val storage: String = "",
    /** Ukuran monitor, mis. "15.6 inci" */
    val monitor: String = "",
    /** Tipe kartu grafis, mis. "NVIDIA RTX 3050" */
    val gpu: String = "",
    /** Perkiraan harga komputer, sudah diformat Rupiah */
    val price: String = ""
)
