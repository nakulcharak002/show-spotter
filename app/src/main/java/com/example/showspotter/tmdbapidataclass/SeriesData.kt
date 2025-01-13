package com.example.showspotter.tmdbapidataclass

data class SeriesData(
    val page: Int,
    val results: List<SeriesResult>,
    val total_pages: Int,
    val total_results: Int
)

data class SeriesResult(
    val adult: Boolean,
    val backdrop_path: String,
    val first_air_date: String,
    val genre_ids: List<Int>,
    val id: Int,
    val name: String,
    val origin_country: List<String>,
    val original_language: String,
    val original_name: String,
    val overview: String,
    val popularity: Double,
    val poster_path: String,
    val vote_average: Double,
    val vote_count: Int
)