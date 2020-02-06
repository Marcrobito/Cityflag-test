//
//  AppListPresenter.swift
//  cityflagtestios
//
//  Created by Marco Antonio Martínez Gutiérrez on 1/30/20.
//  Copyright © 2020 Marco Antonio Martínez Gutiérrez. All rights reserved.
//

class AppListPresenter: AppViewToPresenterProtocol {
    
    var view: AppPresenterToViewProtocol?
    
    var interactor: AppPresenterToInteractorProtocol?
    
    var router: AppPresenterToRouterProtocol?
    
    func getData() {
        interactor?.fetchAppsData()
    }
    
}


extension AppListPresenter:AppInteractorToPresenterProtocol{
    func dataFetched(_ data: [AppDetail]) {
        view?.presentData(data)
    }
}
