//
//  AppApi.swift
//  cityflagtestios
//
//  Created by Marco Antonio Martínez Gutiérrez on 1/29/20.
//  Copyright © 2020 Marco Antonio Martínez Gutiérrez. All rights reserved.
//

import Foundation

import Foundation
import Alamofire


public enum AppAPI{
    case appList
}

enum NetworkEnvironment {
    case qa
    case production
    case staging
}


extension AppAPI:EndPointType{
    
    var environmentBaseURL : String {
        switch NetworkManager.environment {
        case .production: return "https://itunes.apple.com"
        case .qa: return "https://itunes.apple.com"
        case .staging: return "https://itunes.apple.com"
        }
    }
    
    var baseURL: String {
        guard URL(string: environmentBaseURL) != nil else { fatalError("baseURL could not be configured.")}
        return environmentBaseURL
    }
    
    var path: String {
        switch self {
        case .appList:
            return NetworkManager.environment == .production ? "/us/rss/topfreeapplications/limit=20/json" : "/us/rss/topfreeapplications/limit=10/json"
        }
    }
    
    var method: HTTPMethod {
        switch self {
        case .appList:
            return .get
        }
    }
    
    var fileDestination: String? {
        return ""
    }
    
    var headers: HTTPHeaders? {
        return nil
    }
    
    var params: [String : Any]? {
        return nil
    }
    
    
}
