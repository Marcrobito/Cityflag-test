//
//  Feed.swift
//  cityflagtestios
//
//  Created by Marco Antonio Martínez Gutiérrez on 1/29/20.
//  Copyright © 2020 Marco Antonio Martínez Gutiérrez. All rights reserved.
//

import Foundation
//hola
struct FeedData: Codable {
    
    let feed:Feed
    
    private enum CodingKeys: String, CodingKey {
        case feed
    }
}

struct Feed: Codable {
    
    let author:AuthorData
    let entry:[AppData]
    let updated:LabelData
    let rights:LabelData
    let title:LabelData
    let icon:LabelData
    let link:[LinkData]
    let id:LabelData
    
    private enum CodingKeys: String, CodingKey {
        case author
        case entry
        case updated
        case rights
        case title
        case icon
        case link
        case id
    }
}

struct AppData: Codable {
    
    let name:LabelData
    let image:[LabelAttributesData]
    let summary:LabelData
    let price:LabelAttributesData
    let contentType:LabelAttributesData
    let rights:LabelData
    let title:LabelData
    let link:[LinkData]
    let id:LabelAttributesData
    let artist:LabelAttributesData
    let category:LabelAttributesData
    let releaseDate:LabelAttributesData
    
    private enum CodingKeys: String, CodingKey {
        case name = "im:name"
        case image = "im:image"
        case summary
        case price = "im:price"
        case contentType = "im:contentType"
        case rights
        case title
        case link
        case id
        case artist = "im:artist"
        case category
        case releaseDate = "im:releaseDate"
    }
    
}

struct LabelData: Codable {
    
    let label:String
    
    private enum CodingKeys: String, CodingKey {
        case label
        
    }
}

struct LabelAttributesData: Codable {
    
    let label:String?
    let attributes:AttributesData
    
    private enum CodingKeys: String, CodingKey {
        case label
        case attributes
    }
}

struct AttributesData: Codable {
    
    let height:String?
    let amount:String?
    let currency:String?
    let imId:String?
    let imBundleId:String?
    let href:String?
    let term:String?
    let scheme:String?
    let label:String?
    let assetType:String?
    let type:String?
    let rel:String?
    let title:String?
    
    private enum CodingKeys: String, CodingKey {
        case height
        case amount
        case currency
        case imId = "im:id"
        case imBundleId = "im:bundleId"
        case href
        case term
        case scheme
        case label
        case assetType = "im:assetType"
        case type
        case rel
        case title
    }
}

struct LinkData: Codable {
    
    let duration:LabelData?
    let attributes:AttributesData
    
    private enum CodingKeys: String, CodingKey {
        case duration = "im:duration"
        case attributes
    }
    
}


struct AuthorData: Codable {
    
    let name:LabelData
    let uri:LabelData
    
    private enum CodingKeys: String, CodingKey {
        case name
        case uri
    }
    
}
/*
 data class AuthorDTO(
     @SerializedName("name")
     @Expose val name: JSONLabelDTO,
     @SerializedName("uri")
     @Expose val uri: JSONLabelDTO
 )
 
 */

