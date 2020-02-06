//
//  AppListProtocol.swift
//  cityflagtestios
//
//  Created by Marco Antonio Martínez Gutiérrez on 1/30/20.
//  Copyright © 2020 Marco Antonio Martínez Gutiérrez. All rights reserved.
//

import Foundation
import UIKit

protocol AppPresenterToViewProtocol: class {
    var presenter: AppViewToPresenterProtocol? {get set}
    func presentData(_ data:[AppDetail])
}

protocol AppInteractorToPresenterProtocol: class {
    func dataFetched(_ data:[AppDetail])
}



protocol AppPresenterToInteractorProtocol: class {
    var presenter: AppInteractorToPresenterProtocol? {get set}
    func fetchAppsData()
    
    
}

protocol AppViewToPresenterProtocol: class {
    var view: AppPresenterToViewProtocol? {get set}
    var interactor: AppPresenterToInteractorProtocol? {get set}
    var router: AppPresenterToRouterProtocol? {get set}
    func getData()
}


protocol AppPresenterToRouterProtocol: class {
    static func createModule() -> UIViewController
}
