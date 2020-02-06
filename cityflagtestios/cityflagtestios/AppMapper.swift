//
//  AppMapper.swift
//  cityflagtestios
//
//  Created by Marco Antonio Martínez Gutiérrez on 1/30/20.
//  Copyright © 2020 Marco Antonio Martínez Gutiérrez. All rights reserved.
//

import Foundation

class AppMapper {
    
    func generateAppList(content: [AppData]) -> [AppDetail] {
        var appList:[AppDetail] = []
        for c in content {
            appList.append(getAppDetail(app: c))
        }
        return appList
    }
    
    func getAppDetail(app: AppData) -> AppDetail{
        return AppDetail(name: app.name.label, images: [], summary: app.summary.label, price: Price(amount: Double(app.price.attributes.amount!) as! Double, currency: app.price.attributes.currency!), contentType: ContentType(term: app.contentType.attributes.term!, label: app.contentType.label), rights: app.rights.label, title: app.title.label, links: [], id: Id(id: app.id.attributes.imId!, bundleId: app.id.attributes.imBundleId!, url: app.id.label!), artist: Artist(name: app.artist.label, href: app.artist.attributes.href), category: Category(id: app.category.attributes.imId, term: app.category.attributes.term!, label: app.category.attributes.label!, scheme: app.category.attributes.scheme!), releaseDate: ReleaseDate(label: app.releaseDate.label!, date: app.releaseDate.attributes.label!))
    }
    
    
    
}
