//
//  NetworkManager.swift
//  cityflagtestios
//
//  Created by Marco Antonio Martínez Gutiérrez on 1/30/20.
//  Copyright © 2020 Marco Antonio Martínez Gutiérrez. All rights reserved.
//

import Foundation

struct NetworkManager {
    static let environment : NetworkEnvironment = .staging
    
    let router = Router<AppAPI>()
    
    func getFeed(completion: @escaping (_ apps: FeedData?,_ error: String?)->()){
        router.request(.appList) { data, response, error in
            
            do{
                let jsonData = try JSONSerialization.data(withJSONObject: data!)
                let feed = try JSONDecoder().decode( FeedData.self, from: jsonData)
                
                completion(feed,  error as! String?)
                
            }catch {
                print("Error deserializing JSON: \(error)")
                //completion(nil, "Error deserializing JSON \(error)")
            }
            
        }
        
    }
    
}
