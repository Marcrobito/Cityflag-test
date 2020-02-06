package com.jamadev.cityflagtest.applications.model

import android.util.Log


class AppConverter {

    fun generateAppList(contentDTO: ContentDTO):List<AppDetail>{
        val appList = mutableListOf<AppDetail>()
        for (appDTO in contentDTO.entry!!){
            appList.add(getAppDetail(appDTO))
        }
        return appList
    }

    private fun getAppDetail(appDTO: AppDTO): AppDetail{
        return AppDetail(
            appDTO.name.label,
            getImages(appDTO.image),
            appDTO.summary.label,
            Price(appDTO.price.attributes!!.amount!!.toDouble(), appDTO.price.attributes.currency!!),
            ContentType(appDTO.contentType.attributes!!.term, appDTO.contentType.label),
            appDTO.rights.label,
            appDTO.title.label,
            getLinks(appDTO.link),
            Id(appDTO.id.attributes!!.imId!!, appDTO.id.attributes.imBundleId!!, appDTO.id.label!!),
            Artist(appDTO.artist.label, appDTO.artist.attributes!!.href),
            Category(appDTO.category.attributes!!.imId, appDTO.category.attributes.term!!,
                appDTO.category.attributes.label!!,appDTO.category.attributes.scheme!!),
            ReleaseDate(appDTO.releaseDate.label!!, appDTO.releaseDate.attributes!!.label!!)
        )
    }

    private fun getImages(images: List<JSONObjDTO>):List<Image>{
        val imgList = mutableListOf<Image>()
        for (img in images){
            val image = Image(img.label!!, img.attributes!!.height!!.toInt())
            imgList.add(image)
        }
        return imgList
    }

    private fun getLinks(links: List<LinkDTO>):List<Link>{
        val linkList = mutableListOf<Link>()
        for(link in links){
            val l = Link(null, link.attributes!!.title,
                link.attributes.rel, link.attributes.type, link.attributes.href, link.attributes.assetType)
            linkList.add(l)
        }
        return linkList
    }


}

