//
//  AppListInterator.swift
//  cityflagtestios
//
//  Created by Marco Antonio Martínez Gutiérrez on 1/30/20.
//  Copyright © 2020 Marco Antonio Martínez Gutiérrez. All rights reserved.
//


class AppListInteractor:AppPresenterToInteractorProtocol{
    var presenter: AppInteractorToPresenterProtocol?
    
    let networker = NetworkManager()
    
    func fetchAppsData(){
        networker.getFeed(){ result, error in
            if error != nil{
                
            }else{
                let data = AppMapper().generateAppList(content: result!.feed.entry)
                self.presenter?.dataFetched(data)
            }
        }
    }
    
}
