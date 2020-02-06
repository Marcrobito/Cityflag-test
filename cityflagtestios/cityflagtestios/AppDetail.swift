
//
//  Appdetail.swift
//  cityflagtestios
//
//  Created by Marco Antonio Martínez Gutiérrez on 1/30/20.
//  Copyright © 2020 Marco Antonio Martínez Gutiérrez. All rights reserved.
//


struct AppDetail {
    let name:String
    let images:[Image]
    let summary : String
    let price : Price
    let contentType : ContentType
    let rights : String?
    let title : String
    let links : [Link]
    let id : Id
    let artist : Artist
    let category : Category
    let releaseDate : ReleaseDate
}

struct Image {
    let url:String
    let height:Int
}

struct Price {
    let amount:Double
    let currency:String
}

struct ContentType {
    let term:String
    let label:String?
}

struct Link {
    let duration:String?
    let term:String?
    let title:String?
    let rel:String?
    let type:String?
    let href:String?
    let assetType:String?
}

struct Id{
    let id:String
    let bundleId:String
    let url:String
}

struct Artist{
    let name:String?
    let href:String?
}

struct Category{
    let id:String?
    let term:String
    let label:String
    let scheme:String
}

struct ReleaseDate{
    let label:String
    let date:String
}
