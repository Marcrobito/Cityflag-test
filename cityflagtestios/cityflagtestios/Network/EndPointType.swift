//
//  Endpoint.swift
//  cityflagtestios
//
//  Created by Marco Antonio Martínez Gutiérrez on 1/29/20.
//  Copyright © 2020 Marco Antonio Martínez Gutiérrez. All rights reserved.
//

import Foundation
import Alamofire

public typealias HTTPHeaders = [String:String]


protocol EndPointType {
    var baseURL:String {get}
    var path:String{get}
    var method:HTTPMethod{get}
    var fileDestination:String?{get}
    var headers: HTTPHeaders? { get }
    var params: [String:Any]? {get}
}
