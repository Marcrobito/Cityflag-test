package com.jamadev.cityflagtest.applications.model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class FeedDTO(
    @SerializedName("feed")
    @Expose val feed: ContentDTO
)

data class ContentDTO(
    @SerializedName("author")
    @Expose val author: AuthorDTO,
    @SerializedName("entry")
    @Expose val entry: List<AppDTO>?,
    @SerializedName("updated")
    @Expose val updated: Any?,
    @SerializedName("rights")
    @Expose val rights: Any?,
    @SerializedName("title")
    @Expose val title: Any?,
    @SerializedName("icon")
    @Expose val icon: Any?,
    @SerializedName("link")
    @Expose val link: Any?,
    @SerializedName("id")
    @Expose val id: Any?
)

data class AuthorDTO(
    @SerializedName("name")
    @Expose val name: JSONLabelDTO,
    @SerializedName("uri")
    @Expose val uri: JSONLabelDTO
)

data class AppDTO(
    @SerializedName("im:name")
    @Expose val name: JSONLabelDTO,
    @SerializedName("im:image")
    @Expose val image: List<JSONObjDTO>,
    @SerializedName("summary")
    @Expose val summary: JSONLabelDTO,
    @SerializedName("im:price")
    @Expose val price: JSONObjDTO,
    @SerializedName("im:contentType")
    @Expose val contentType: JSONObjDTO,
    @SerializedName("rights")
    @Expose val rights: JSONLabelDTO,
    @SerializedName("title")
    @Expose val title: JSONLabelDTO,
    @SerializedName("link")
    @Expose val link: List<LinkDTO>,
    @SerializedName("id")
    @Expose val id: JSONObjDTO,
    @SerializedName("im:artist")
    @Expose val artist: JSONObjDTO,
    @SerializedName("category")
    @Expose val category: JSONObjDTO,
    @SerializedName("im:releaseDate")
    @Expose val releaseDate: JSONObjDTO
)

data class LinkDTO(
    @SerializedName("im:duration")
    @Expose val duration: JSONLabelDTO?,
    @SerializedName("attributes")
    @Expose val attributes: AttributesDTO?
)

data class JSONObjDTO(
    @SerializedName("label")
    @Expose val label: String?,
    @SerializedName("attributes")
    @Expose val attributes: AttributesDTO?
)

data class AttributesDTO(
    @SerializedName("height")
    @Expose val height: String?,
    @SerializedName("amount")
    @Expose val amount: String?,
    @SerializedName("currency")
    @Expose val currency: String?,
    @SerializedName("im:id")
    @Expose val imId: String?,
    @SerializedName("im:bundleId")
    @Expose val imBundleId: String?,
    @SerializedName("href")
    @Expose val href: String?,
    @SerializedName("term")
    @Expose val term: String?,
    @SerializedName("scheme")
    @Expose val scheme: String?,
    @SerializedName("label")
    @Expose val label: String?,
    @SerializedName("im:assetType")
    @Expose val assetType: String?,
    @SerializedName("type")
    @Expose val type: String?,
    @SerializedName("rel")
    @Expose val rel: String?,
    @SerializedName("title")
    @Expose val title: String?
)

data class JSONLabelDTO(
    @SerializedName("label")
    @Expose val label: String
)