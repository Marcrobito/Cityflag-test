package com.jamadev.cityflagtest.applications.model

data class AppDetail(
    val name : String,
    val images : List<Image>,
    val summary : String,
    val price : Price,
    val contentType : ContentType,
    val rights : String?,
    val title : String?,
    val links : List<Link>,
    val id : Id,
    val artist: Artist,
    val category: Category,
    val releaseDate : ReleaseDate
)

data class Image(
    val url : String,
    val height : Int
)

data class Price(
    val amount:Double,
    val currency: String
)

data class ContentType(
    val term : String?,
    val label: String?
)

data class Link(
    val duration : String?,
    val title: String?,
    val rel: String?,
    val type: String?,
    val href: String?,
    val assetType: String?
)

data class Id(
    val id : String,
    val bundleId : String,
    val url : String
)

data class Artist(
    val name : String?,
    val href: String?
)

data class Category(
    val id : String?,
    val term: String,
    val label: String,
    val scheme: String
)

data class ReleaseDate(
    val label : String,
    val date: String
)

