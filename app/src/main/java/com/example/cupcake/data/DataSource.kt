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
 * Satu pilihan komponen komputer: [name] ditampilkan ke pengguna dan [price] (Rupiah)
 * adalah tambahan harga terhadap harga dasar.
 */
data class ComponentOption(
    val name: String,
    val price: Long
)

object DataSource {
    val processors = listOf(
        ComponentOption("Intel Core i3", 1_000_000),
        ComponentOption("Intel Core i5", 2_000_000),
        ComponentOption("Intel Core i7", 3_500_000),
        ComponentOption("AMD Ryzen 5", 1_800_000),
        ComponentOption("AMD Ryzen 7", 3_200_000)
    )

    val memories = listOf(
        ComponentOption("4 GB", 300_000),
        ComponentOption("8 GB", 600_000),
        ComponentOption("16 GB", 1_200_000),
        ComponentOption("32 GB", 2_400_000)
    )

    val storages = listOf(
        ComponentOption("HDD 1 TB", 700_000),
        ComponentOption("SSD 256 GB", 500_000),
        ComponentOption("SSD 512 GB", 900_000),
        ComponentOption("SSD 1 TB", 1_600_000)
    )

    val monitors = listOf(
        ComponentOption("14 inci", 800_000),
        ComponentOption("15.6 inci", 1_200_000),
        ComponentOption("17 inci", 2_000_000),
        ComponentOption("24 inci", 2_500_000)
    )

    val gpus = listOf(
        ComponentOption("Integrated Graphics", 0),
        ComponentOption("NVIDIA GTX 1650", 2_000_000),
        ComponentOption("NVIDIA RTX 3050", 3_000_000),
        ComponentOption("NVIDIA RTX 4060", 5_000_000)
    )
}
