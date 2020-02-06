//
//  VC.swift
//  cityflagtestios
//
//  Created by Marco Antonio Martínez Gutiérrez on 1/31/20.
//  Copyright © 2020 Marco Antonio Martínez Gutiérrez. All rights reserved.
//

import UIKit

class VC: UIViewController{
    
    
    override func viewDidLoad() {
        super.viewDidLoad()
        /*appListView.view.frame.origin = view.frame.origin
        appListView.view.frame.size = view.frame.size
        
        view.addSubview(appListView.view)*/
        
        print("S")
        
        
        //present(appListVC, animated: true, completion: nil)
        
    }
    
    override func viewDidAppear(_ animated: Bool) {
        let appListVC = AppRouter.createModule()
        /*UIApplication.shared.keyWindow?.rootViewController?.present(appListVC, animated: true, completion: nil)*/
        appListVC.view.frame.origin = view.frame.origin
        appListVC.view.frame.size = view.frame.size
        
        view.addSubview(appListVC.view)
        
        //self.present(appListVC, animated: true, completion: nil)
        //self.dismiss(animated: false, completion: nil)
    }
}


/*
 let appVC = AppRouter.createModule()
 window = UIWindow(frame: UIScreen.main.bounds);
 window?.rootViewController = appVC
 window?.makeKeyAndVisible()
 */
