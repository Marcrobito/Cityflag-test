//
//  AppRouter.swift
//  cityflagtestios
//
//  Created by Marco Antonio Martínez Gutiérrez on 1/30/20.
//  Copyright © 2020 Marco Antonio Martínez Gutiérrez. All rights reserved.
//

import Foundation
import UIKit

class AppRouter: AppPresenterToRouterProtocol{
    
    class func createModule() ->UIViewController{
        let view = mainstoryboard.instantiateViewController(withIdentifier: "ListVC") as? AppListVC
        
        let presenter: AppViewToPresenterProtocol & AppInteractorToPresenterProtocol = AppListPresenter()
        let interactor: AppPresenterToInteractorProtocol = AppListInteractor()
        let router:AppPresenterToRouterProtocol = AppRouter()
        
        view?.presenter = presenter
        presenter.view = view
        presenter.router = router
        presenter.interactor = interactor
        interactor.presenter = presenter
        
        return view!
        
    }
    
    static var mainstoryboard: UIStoryboard{
        return UIStoryboard(name:"Main",bundle: Bundle.main)
    }
}
